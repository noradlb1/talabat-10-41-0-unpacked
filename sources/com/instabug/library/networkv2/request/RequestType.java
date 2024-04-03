package com.instabug.library.networkv2.request;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface RequestType {
    public static final int FILE_DOWNLOAD = 3;
    public static final int MULTI_PART = 2;
    public static final int NORMAL = 1;
    public static final int UNDEFINED = -1;
}
