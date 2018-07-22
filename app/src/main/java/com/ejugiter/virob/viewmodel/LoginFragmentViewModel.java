package com.ejugiter.virob.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.ejugiter.virob.core.data.DataManager;
import com.ejugiter.virob.core.data.api.response.ApiResponse;
import com.ejugiter.virob.core.data.api.response.ResponseListener;
import com.ejugiter.virob.model.User;

import javax.inject.Inject;

/**
 * ViewModel class for the fragment
 * All view model class should extend ViewModel
 */
public class LoginFragmentViewModel extends ViewModel {

    private final DataManager dataManager;
    public MutableLiveData<ApiResponse<User>> loginResponse = new MutableLiveData<>();
    public MutableLiveData<Boolean> loadingStatus = new MutableLiveData<>();

    @Inject
    LoginFragmentViewModel(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    /**
     * Login service which will be called from fragment
     */
    public void doLogin() {
        // do api call
        // get response
        dataManager.doLogin("user", "password", new ResponseListener<User>() {
            @Override
            public void onStart() {
                //show progress
                loadingStatus.setValue(true);
            }

            @Override
            public void onFinish() {
                //hide progressbar
                loadingStatus.setValue(false);
            }

            @Override
            public void onResponse(ApiResponse<User> apiResponse) {
                // set response to loginResponse
                // then we can observe the change in the fragment if we observe the loginResponse
                loginResponse.setValue(apiResponse);
            }
        });


    }
}
