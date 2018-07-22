package com.ejugiter.virob.core.data;

import com.ejugiter.virob.core.data.api.Api;
import com.ejugiter.virob.core.data.api.response.ApiResponse;
import com.ejugiter.virob.core.data.api.response.ResponseListener;
import com.ejugiter.virob.core.data.api.response.ResponseStatus;
import com.ejugiter.virob.model.User;
import com.ejugiter.virob.schedulers.BaseSchedulers;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Class responsible for calling the api services
 */
public class DataManager {

    private Api api;
    private BaseSchedulers scheduler;

    @Inject
    public DataManager(Api api, BaseSchedulers schedulers) {
        this.api = api;
        this.scheduler = schedulers;
    }

    /**
     * Base Method for the response handling
     * <p>
     * All api call should be done using the below method
     */
    private <T> void performRequest(Observable<T> observable, final ResponseListener<T> responseListener) {
        observable.subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .subscribe(new Observer<T>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        responseListener.onStart();
                    }

                    @SuppressWarnings("unchecked")
                    @Override
                    public void onNext(T t) {
                        responseListener.onResponse(new ApiResponse(ResponseStatus.SUCCESS, t, null));
                    }

                    @SuppressWarnings("unchecked")
                    @Override
                    public void onError(Throwable e) {
                        responseListener.onResponse(new ApiResponse(ResponseStatus.ERROR, null, e));
                    }

                    @Override
                    public void onComplete() {
                        responseListener.onFinish();
                    }
                });


    }

    public void doLogin(String username, String password, ResponseListener<User> responseListener) {
        performRequest(api.doLogin(username, password), responseListener);
    }

    public void forgotPassword(String username, ResponseListener<User> responseListener) {
        performRequest(api.forgotPassword(username), responseListener);
    }
}
