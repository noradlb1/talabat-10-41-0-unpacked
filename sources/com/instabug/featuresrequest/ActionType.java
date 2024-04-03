package com.instabug.featuresrequest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ActionType {
    public static final int ADD_COMMENT_TO_FEATURE = 4;
    public static final int REQUEST_NEW_FEATURE = 2;
}
