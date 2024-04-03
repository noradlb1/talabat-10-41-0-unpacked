package com.instabug.library.invocation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface InvocationMode {
    public static final int ASK_QUESTION = 3;
    public static final int CHATS = 4;
    public static final int FEATURE_REQUESTS = 5;
    public static final int NEW_BUG = 1;
    public static final int NEW_FEEDBACK = 2;
    public static final int PROMPT_OPTIONS = 0;
    public static final int UNDEFINED = -1;
}
