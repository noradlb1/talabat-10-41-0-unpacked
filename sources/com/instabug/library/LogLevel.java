package com.instabug.library;

import androidx.annotation.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Keep
@Retention(RetentionPolicy.SOURCE)
public @interface LogLevel {
    public static final int DEBUG = 2;
    public static final int ERROR = 1;
    public static final int NONE = 0;
    public static final int VERBOSE = 3;
}
