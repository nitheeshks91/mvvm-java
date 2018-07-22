package com.ejugiter.virob.di.modules;

import com.ejugiter.virob.core.data.DataManager;
import com.ejugiter.virob.core.data.api.Api;
import com.ejugiter.virob.schedulers.BaseSchedulers;
import com.ejugiter.virob.schedulers.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = {ViewModelModule.class})
public class AppModule {

    @Provides
    @Singleton
    BaseSchedulers provideScheduler() {
        return new SchedulerProvider();
    }

    @Provides
    @Singleton
    Api provideApi(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }


    @Provides
    @Singleton
    DataManager provideDataManager(Api api, BaseSchedulers scheduler) {
        return new DataManager(api, scheduler);
    }

}
