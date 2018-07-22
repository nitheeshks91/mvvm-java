package com.ejugiter.virob.core.data.api.response;

import com.google.gson.annotations.SerializedName;

public class ApiResponseError {

    @SerializedName("errorCode")
    public String errorCode;

    @SerializedName("errorMessage")
    public String errorMessage;
}
