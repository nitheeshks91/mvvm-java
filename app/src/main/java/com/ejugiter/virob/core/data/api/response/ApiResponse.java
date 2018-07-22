package com.ejugiter.virob.core.data.api.response;

import android.text.TextUtils;
import android.util.MalformedJsonException;

import com.google.gson.Gson;

import org.json.JSONException;

import java.io.IOException;
import java.net.SocketTimeoutException;

import retrofit2.HttpException;

public class ApiResponse<T> {

    public int status;
    public T data;
    public Throwable throwable;

    public String errorCode = "";
    public String errorDescription = "Something went wrong";

    public ApiResponse(int status, T data, Throwable throwable) {
        this.status = status;
        this.data = data;
        this.throwable = throwable;

        parseException(throwable);
    }

    private void parseException(Throwable throwable) {
        if (throwable != null) {
            if (throwable instanceof SocketTimeoutException) {
                this.errorDescription = "Oooops! We couldn’t capture your request in time. Please try again.";
                this.errorCode = "No_internet";

            } else if (throwable instanceof MalformedJsonException) {
                this.errorDescription = "Oops! We hit an error. Try again later.";
                this.errorCode = "malformed_json";

            } else if (throwable instanceof IOException) {
                this.errorDescription = "Oh! You are not connected to a wifi or cellular data network. Please connect and try again";
                this.errorCode = "No_internet";
            } else if (throwable instanceof HttpException) {
                try {
                    ApiResponseError apiResponseError = new Gson().fromJson(((HttpException) throwable).response().errorBody().string(), ApiResponseError.class);
                    if (!TextUtils.isEmpty(apiResponseError.errorCode))
                        this.errorCode = apiResponseError.errorCode;
                    if (!TextUtils.isEmpty(apiResponseError.errorMessage))
                        this.errorDescription = apiResponseError.errorMessage;
                } catch (IOException e) {
                    this.errorDescription = "Something went wrong";
                }
            }
        }

    }
}
