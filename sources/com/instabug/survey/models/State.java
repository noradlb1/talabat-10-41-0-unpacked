package com.instabug.survey.models;

import androidx.annotation.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Keep
@Retention(RetentionPolicy.SOURCE)
public @interface State {
    public static final String DISMISSED = "DISMISSED";
    public static final String ENDED = "ENDED";
    public static final String SUBMITTED = "SUBMITTED";
}
