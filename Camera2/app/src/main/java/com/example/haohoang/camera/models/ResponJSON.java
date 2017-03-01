package com.example.haohoang.camera.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by haohoang on 2/27/17.
 */

public class ResponJSON {
    @SerializedName("secure_url")
    String url;

    public String getUrl() {
        return url;
    }

    public ResponJSON(String url) {

        this.url = url;
    }

    @Override
    public String toString() {
        return "ResponJSON{" +
                "url='" + url + '\'' +
                '}';
    }
}
