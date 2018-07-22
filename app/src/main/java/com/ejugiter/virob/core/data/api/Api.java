package com.ejugiter.virob.core.data.api;

import com.ejugiter.virob.model.User;

import io.reactivex.Observable;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("/dologin")
    Observable<User> doLogin(@Field("user") String username, @Field("pass") String password);

    @FormUrlEncoded
    @POST("/forgot_password")
    Observable<User> forgotPassword(@Field("user") String username);
}
