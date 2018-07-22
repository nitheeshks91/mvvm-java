package com.ejugiter.virob.core.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ejugiter.virob.R;

import timber.log.Timber;

public class FragmentUtils {

    /**
     * The method for adding a new fragment
     *
     * @param activity        : Parent Activity
     * @param frag:           Fragment to be added
     * @param id:             Fragment container ID
     * @param addtoBackStack: Flag indicating whether to add to backstack or not
     */
    public static void addFragment(AppCompatActivity activity, Fragment frag, int id, boolean addtoBackStack) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.anim_enter, R.anim.anim_exit, R.anim.anim_pop_enter, R.anim.anim_pop_exit);

        if (addtoBackStack)
            transaction.addToBackStack(frag.getClass().getCanonicalName());
        transaction.add(id, frag, frag.getClass().getCanonicalName());
        transaction.commit();
    }

    /**
     * The method for replacing a fragment
     *
     * @param fragment:       Fragment to be added
     * @param id:             Fragment container ID
     * @param addToBackStack: Flag indicating whether to add to backstack or not
     * @param animationType:  Fragment transition animation type
     */
    public static void replaceFragment(FragmentManager fragmentManager, Fragment fragment, int id, boolean addToBackStack, FragmentAnimation animationType) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (animationType) {
            case TRANSITION_POP: {
                transaction.setCustomAnimations(R.anim.anim_enter, R.anim.anim_exit, R.anim.anim_pop_enter, R.anim.anim_pop_exit);
                break;
            }
            case TRANSITION_FADE_IN_OUT: {
                transaction.setCustomAnimations(R.anim.anim_frag_fade_in, R.anim.anim_frag_fade_out);
                break;
            }
            case TRANSITION_SLIDE_LEFT_RIGHT: {
                transaction.setCustomAnimations(R.anim.slide_in_from_rigth, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right);
                break;
            }
            case TRANSITION_SLIDE_LEFT_RIGHT_WITHOUT_EXIT: {
                transaction.setCustomAnimations(R.anim.slide_in_from_rigth, 0);
                break;
            }
        }

        if (addToBackStack)
            transaction.addToBackStack(fragment.getClass().getCanonicalName());

        transaction.replace(id, fragment, fragment.getClass().getCanonicalName());
        transaction.commit();
    }


    /**
     * The method for replacing a fragment
     *
     * @param activity        : Parent Activity
     * @param fragment:       Fragment to be added
     * @param id:             Fragment container ID
     * @param addToBackStack: Flag indicating whether to add to backstack or not
     * @param animationType:  Fragment transition animation type
     */
    public static void replaceFragment(AppCompatActivity activity, Fragment fragment, int id, boolean addToBackStack, FragmentAnimation animationType) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (animationType) {
            case TRANSITION_POP: {
                transaction.setCustomAnimations(R.anim.anim_enter, R.anim.anim_exit, R.anim.anim_pop_enter, R.anim.anim_pop_exit);
                break;
            }
            case TRANSITION_FADE_IN_OUT: {
                transaction.setCustomAnimations(R.anim.anim_frag_fade_in, R.anim.anim_frag_fade_out);
                break;
            }
            case TRANSITION_SLIDE_LEFT_RIGHT: {
                transaction.setCustomAnimations(R.anim.slide_in_from_rigth, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right);
                break;
            }
            case TRANSITION_SLIDE_LEFT_RIGHT_WITHOUT_EXIT: {
                transaction.setCustomAnimations(R.anim.slide_in_from_rigth, 0);
                break;
            }
        }

        if (addToBackStack)
            transaction.addToBackStack(fragment.getClass().getCanonicalName());

        transaction.replace(id, fragment, fragment.getClass().getCanonicalName());
        transaction.commit();
    }


    /**
     * The method for replacing a fragment allowing state loss
     *
     * @param activity        : Parent Activity
     * @param fragment:       Fragment to be added
     * @param id:             Fragment container ID
     * @param addToBackStack: Flag indicating whether to add to backstack or not
     * @param animationType:  Fragment transition animation type
     */
    public static void replaceFragmentAllowingStateLoss(AppCompatActivity activity, Fragment fragment, int id, boolean addToBackStack, FragmentAnimation animationType) {
        FragmentManager fragManager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = fragManager.beginTransaction();
        switch (animationType) {
            case TRANSITION_POP: {
                transaction.setCustomAnimations(R.anim.anim_enter, R.anim.anim_exit, R.anim.anim_pop_enter, R.anim.anim_pop_exit);
                break;
            }
            case TRANSITION_FADE_IN_OUT: {
                transaction.setCustomAnimations(R.anim.anim_frag_fade_in, R.anim.anim_frag_fade_out);
                break;
            }
            case TRANSITION_SLIDE_LEFT_RIGHT: {
                transaction.setCustomAnimations(R.anim.slide_in_from_rigth, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right);
                break;
            }
            case TRANSITION_SLIDE_LEFT_RIGHT_WITHOUT_EXIT: {
                transaction.setCustomAnimations(R.anim.slide_in_from_rigth, 0);
                break;
            }
        }

        if (addToBackStack)
            transaction.addToBackStack(fragment.getClass().getCanonicalName());

        transaction.replace(id, fragment, fragment.getClass().getCanonicalName());
        transaction.commitAllowingStateLoss();
    }


    /**
     * The method for replacing a fragment without any transition animatiom
     *
     * @param activity        : Parent Activity
     * @param fragment:       Fragment to be added
     * @param id:             Fragment container ID
     * @param addToBackStack: Flag indicating whether to add to backstack or not
     */
    public static void replaceFragmentWithoutAnimation(AppCompatActivity activity, Fragment fragment, int id, boolean addToBackStack) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragTransaction = fragmentManager.beginTransaction();
        if (addToBackStack)
            fragTransaction.addToBackStack(fragment.getClass().getCanonicalName());

        fragTransaction.replace(id, fragment, fragment.getClass().getCanonicalName());
        fragTransaction.commit();
    }

    /**
     * The method for replacing a child fragment without any transition animatiom
     *
     * @param currentFragment : Current Fragment
     * @param fragment:       Fragment to be added
     * @param id:             Fragment container ID
     * @param addToBackStack: Flag indicating whether to add to backstack or not
     */
    public static void replaceChildFragment(Fragment currentFragment, Fragment fragment, int id, boolean addToBackStack) {
        FragmentManager fragmentManager = currentFragment.getChildFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.anim_enter, R.anim.anim_exit, R.anim.pop_enter, R.anim.pop_exit);

        if (addToBackStack)
            transaction.addToBackStack(fragment.getClass().getCanonicalName());

        transaction.replace(id, fragment, fragment.getClass().getCanonicalName());

        transaction.commit();
    }

    /**
     * This method pops the back the stack till the first fragment
     *
     * @param activity: Parent Activity
     */
    public static void popToFirstFragment(AppCompatActivity activity) {
        try {
            activity.getSupportFragmentManager().popBackStackImmediate(activity.getSupportFragmentManager().getBackStackEntryAt(0).getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        } catch (IndexOutOfBoundsException e) {
            Timber.log(Log.ASSERT, e.getMessage());
        } catch (NullPointerException e) {
            Timber.log(Log.ASSERT, e.getMessage());
        }

    }

    /**
     * This method checks whether the specified fragment is the top fragment or not
     *
     * @param activity:   Parent Activity
     * @param fragmentTag : Fragment Tag Name
     */
    public static boolean isCurrentTopFragment(AppCompatActivity activity, String fragmentTag) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        String tag = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
        return fragmentTag.equalsIgnoreCase(tag);
    }

    /**
     * This method pops the backstack till the specified fragment
     *
     * @param activity : Parent activity
     * @param tagname: Fragment Tag Name
     */
    public static void popToProvidedFragment(AppCompatActivity activity, String tagname) {
        try {
            activity.getSupportFragmentManager().popBackStackImmediate(tagname, 0);
        } catch (IndexOutOfBoundsException e) {
            Timber.log(Log.ASSERT, e.getMessage());
        } catch (NullPointerException e) {
            Timber.log(Log.ASSERT, e.getMessage());
        }

    }

    /**
     * This method clears the whole backstack including the current fragment
     *
     * @param activity: Parent activity
     */
    public static void clearBackStackInclusive(AppCompatActivity activity) {
        if (activity.getSupportFragmentManager().getBackStackEntryCount() == 0)
            return;
        FragmentManager.BackStackEntry entry = activity.getSupportFragmentManager().getBackStackEntryAt(0);
        activity.getSupportFragmentManager().popBackStack(entry.getId(),
                FragmentManager.POP_BACK_STACK_INCLUSIVE);
        activity.getSupportFragmentManager().executePendingTransactions();

    }

    /**
     * This method clears the backstack
     */
    public static void clearBackStack(AppCompatActivity activity) {
        while (activity.getSupportFragmentManager().getBackStackEntryCount() != 0) {
            activity.getSupportFragmentManager().popBackStackImmediate();
        }
    }

    /**
     * This method pops the immediate fragment
     */
    public static void popBackStack(AppCompatActivity activity) {
        activity.getSupportFragmentManager().popBackStackImmediate();
    }
}
