package com.ejugiter.virob.view.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ejugiter.virob.R;
import com.ejugiter.virob.core.data.api.response.ApiResponse;
import com.ejugiter.virob.core.data.api.response.ResponseStatus;
import com.ejugiter.virob.databinding.FragmentLoginBinding;
import com.ejugiter.virob.model.User;
import com.ejugiter.virob.viewmodel.LoginFragmentViewModel;

/**
 * All fragment should extends Base fragment
 * <p>
 * Import : Inorder to use databinding xml file should use the <layout></layout> tag and should
 * mention the viewmodel for the fragment inside the layout
 * <p>
 * The binding class name will be the name of the xmlfile in camelcase ending with "Binding'
 * <p>
 * Follow the login fragment implementation, injection , data binding , live data
 */
public class LoginFragment extends BaseFragment {

    private FragmentLoginBinding binding;
    private LoginFragmentViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginFragmentViewModel.class);
        //setViewModel method name depends on the name that given in the xml file for the view model class
        binding.setViewModel(viewModel);

        observeLoginResponse();

        observeLoadingStatus();
    }

    /**
     * Listenes to the load status livedata object
     */
    private void observeLoadingStatus() {
        viewModel.loadingStatus.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean show) {
                if (show != null && show) {
                    //show progress
                } else {
                    //hide progress
                }
            }
        });
    }

    /**
     * Listens to the loding response
     */
    private void observeLoginResponse() {
        viewModel.loginResponse.observe(this, new Observer<ApiResponse<User>>() {
            @Override
            public void onChanged(@Nullable ApiResponse<User> userApiResponse) {
                if (userApiResponse != null && userApiResponse.status == ResponseStatus.SUCCESS && userApiResponse.data != null) {
                    // proceed after login success
                } else {
                    String errorDescription = userApiResponse.errorDescription;
                    // show error message and display message has to be errorDescription


                }
            }
        });
    }

    /**
     * reseting because have some issues the data persist , so if fragment switched and comes backs working weird
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        viewModel.loginResponse.setValue(null);
    }
}
