package com.ejugiter.virob.core.data.api.response;

public interface ResponseListener<T> {
    void onStart();

    void onFinish();

    void onResponse(ApiResponse<T> apiResponse);
}
