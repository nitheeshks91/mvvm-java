package com.ejugiter.virob.di.modules;

import com.ejugiter.virob.view.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * All Activity must tbe specified here
 */

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = {FragmentBuildersModule.class})
    abstract MainActivity contributeMainActivity();
}
