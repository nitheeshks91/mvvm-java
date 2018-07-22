package com.ejugiter.virob.view.activity;

import android.os.Bundle;

import com.ejugiter.virob.R;
import com.ejugiter.virob.core.utils.FragmentAnimation;
import com.ejugiter.virob.core.utils.FragmentUtils;
import com.ejugiter.virob.view.fragment.LoginFragment;

import dagger.android.AndroidInjection;

/**
 * All activity should extend base activity
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sample for commiting the fragment. Can use Fragment util class for all fragment transactions. Can commit from inside any fragment also
        FragmentUtils.replaceFragment(this, new LoginFragment(), R.id.fragment_container, false, FragmentAnimation.TRANSITION_FADE_IN_OUT);
    }

}
