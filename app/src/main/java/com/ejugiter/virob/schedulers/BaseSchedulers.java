package com.ejugiter.virob.schedulers;

import android.support.annotation.NonNull;

import io.reactivex.Scheduler;

public interface BaseSchedulers {

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();

}
