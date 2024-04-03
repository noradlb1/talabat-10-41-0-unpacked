package com.instabug.library.model.session.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface SessionsConfigParameter {
    public static final String MAX_SESSIONS_PER_REQUEST = "max_number";
    public static final String SYNC_INTERVAL = "interval";
    public static final String SYNC_MODE = "mode";
}
