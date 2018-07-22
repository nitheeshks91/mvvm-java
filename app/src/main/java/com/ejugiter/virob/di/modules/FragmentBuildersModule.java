package com.ejugiter.virob.di.modules;

import com.ejugiter.virob.view.fragment.LoginFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


/**
 * All fragments must be specified here
 */
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract LoginFragment contributeLoginFragment();


/*    @ContributesAndroidInjector
    abstract ForgotFragment contributeForgotFragment();*/
}
