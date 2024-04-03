package com.instabug.library.networkv2.request;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface Header {
    public static final String ACCEPT_CHARSET = "Accept-Charset";
    public static final String ANDROID_VERSION = "IBG-OS-VERSION";
    public static final String APP_TOKEN = "IBG-APP-TOKEN";
    public static final String APP_VERSION = "app-version";
    public static final String AUTHORIZATION = "Authorization";
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final String CONNECTION = "Connection";
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String DEBUG_MODE_HEADER = "IBG-APM-DEBUG-MODE";
    public static final String ID = "id";
    public static final String IF_MATCH = "If-Match";
    public static final String SDK_VERSION = "IBG-SDK-VERSION";
    public static final String SYSTEM_PLATFORM_OS = "IBG-OS";
}
