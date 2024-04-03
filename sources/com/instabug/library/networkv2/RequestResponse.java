package com.instabug.library.networkv2;

import android.annotation.SuppressLint;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.Map;

@Keep
public class RequestResponse {
    @Nullable
    private Map<String, String> headers;
    @Nullable
    private Object responseBody;
    private int responseCode;

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface HttpStatusCode {

        @Keep
        @Retention(RetentionPolicy.SOURCE)
        public @interface _2xx {
            public static final int OK = 200;
        }

        @Keep
        @Retention(RetentionPolicy.SOURCE)
        public @interface _3xx {
            public static final int NOT_MODIFIED = 304;
        }

        @Keep
        @Retention(RetentionPolicy.SOURCE)
        public @interface _4xx {
            public static final int BAD_REQUEST = 400;
            public static final int RATE_LIMIT_REACHED = 429;
        }
    }

    @NonNull
    public Map<String, String> getHeaders() {
        Map<String, String> map = this.headers;
        return map == null ? Collections.emptyMap() : map;
    }

    @Nullable
    public Object getResponseBody() {
        return this.responseBody;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public RequestResponse setHeaders(@Nullable Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public void setResponseBody(@Nullable Object obj) {
        this.responseBody = obj;
    }

    public void setResponseCode(int i11) {
        this.responseCode = i11;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @NonNull
    public String toString() {
        return "Response code: " + this.responseCode + ", Response body: " + this.responseBody;
    }
}
