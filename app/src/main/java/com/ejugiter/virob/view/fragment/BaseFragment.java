package com.ejugiter.virob.view.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v4.app.Fragment;

import com.ejugiter.virob.di.Injectable;

import javax.inject.Inject;

public abstract class BaseFragment extends Fragment implements Injectable {
    @Inject
    ViewModelProvider.Factory viewModelFactory;
}
