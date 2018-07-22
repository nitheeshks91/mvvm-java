package com.ejugiter.virob.di.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.ejugiter.virob.di.ViewModelFactory;
import com.ejugiter.virob.di.keys.ViewModelKey;
import com.ejugiter.virob.viewmodel.LoginFragmentViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * All viewmodel class must be specified here
 */
@SuppressWarnings("WeakerAccess")
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginFragmentViewModel.class)
    abstract ViewModel bindLoginViewModel(LoginFragmentViewModel fragmentViewModel);


    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);


   /* @Binds
    @IntoMap
    @ViewModelKey(ForgotFragmentViewModel.class)
    ViewModel bindForgotViewModel(ForgotFragmentViewModel fragmentViewModel);*/
}
