package com.huawei.location.lite.common.http.request;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class HeadBuilder {
    private static final String APPLICATION_JSON = "application/json";
    public static final String CLIENT_CP_NAME = "X-CP-Info";
    public static final String CLIENT_SDK_VERSION = "x-client-sdk-version";
    private static final String CONTENT_TYPE = "Content-Type";
    public static final String X_REQUEST_ID = "X-Request-ID";
    private final HashMap<String, String> headers;

    public HeadBuilder() {
        this(UUID.randomUUID().toString());
    }

    public HeadBuilder(@NonNull String str) {
        HashMap<String, String> hashMap = new HashMap<>(16);
        this.headers = hashMap;
        hashMap.put("X-Request-ID", TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str);
        hashMap.put("Content-Type", "application/json");
    }

    public HeadBuilder add(String str, String str2) {
        if (!(str == null || str2 == null)) {
            this.headers.put(str, str2);
        }
        return this;
    }

    public HeadBuilder addAll(@NonNull HashMap<String, String> hashMap) {
        if (hashMap != null) {
            this.headers.putAll(hashMap);
        }
        return this;
    }

    public String get(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.headers.get(str);
    }

    public HashMap<String, String> getHeaders() {
        return this.headers;
    }

    public String remove(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.headers.remove(str);
    }

    public HeadBuilder setCPKitSDKVersion(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            this.headers.put(CLIENT_SDK_VERSION, str);
        }
        return this;
    }

    public HeadBuilder setContentType(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            this.headers.put("Content-Type", str);
        }
        return this;
    }

    public HeadBuilder setPackageName(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            this.headers.put(CLIENT_CP_NAME, str);
        }
        return this;
    }

    public String toString() {
        return "HeadBuilder{headers=" + this.headers + AbstractJsonLexerKt.END_OBJ;
    }
}
