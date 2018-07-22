package com.ejugiter.virob.di.component;


import android.app.Application;

import com.ejugiter.virob.di.modules.ActivityModule;
import com.ejugiter.virob.di.modules.AppModule;
import com.ejugiter.virob.di.modules.NetworkModule;
import com.ejugiter.virob.view.AppApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(
        modules = {
                AndroidInjectionModule.class,
                AppModule.class,
                NetworkModule.class,
                ActivityModule.class}
)
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(AppApplication application);
}

