package com.instabug.library.networkv2.request;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface RequestMethod {
    public static final String DELETE = "DELETE";
    public static final String GET = "GET";
    public static final String POST = "POST";
    public static final String PUT = "PUT";
}
