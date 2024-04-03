package com.instabug.library.model.session.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface SyncMode {
    public static final int BATCHING = 2;
    public static final int NO_BATCHING = 1;
    public static final int OFF = 0;
}
