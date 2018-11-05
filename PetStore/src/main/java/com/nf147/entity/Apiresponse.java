package com.nf147.entity;

public class Apiresponse {
    private Integer apiResponse_code;

    private String apiResponse_type;

    private String apiResponse_message;

    public Integer getApiResponse_code() {
        return apiResponse_code;
    }

    public void setApiResponse_code(Integer apiResponse_code) {
        this.apiResponse_code = apiResponse_code;
    }

    public String getApiResponse_type() {
        return apiResponse_type;
    }

    public void setApiResponse_type(String apiResponse_type) {
        this.apiResponse_type = apiResponse_type == null ? null : apiResponse_type.trim();
    }

    public String getApiResponse_message() {
        return apiResponse_message;
    }

    public void setApiResponse_message(String apiResponse_message) {
        this.apiResponse_message = apiResponse_message == null ? null : apiResponse_message.trim();
    }
}