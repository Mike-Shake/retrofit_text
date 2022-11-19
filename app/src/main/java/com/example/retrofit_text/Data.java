package com.example.retrofit_text;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("code")
    private int code;
    @SerializedName("content")
    private String content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
