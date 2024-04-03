package com.instabug.library.model;

import androidx.annotation.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Keep
@Retention(RetentionPolicy.SOURCE)
public @interface StepType {
    public static final String ACTIVITY_CREATED = "ACTIVITY_CREATED";
    public static final String ACTIVITY_DESTROYED = "ACTIVITY_DESTROYED";
    public static final String ACTIVITY_PAUSED = "ACTIVITY_PAUSED";
    public static final String ACTIVITY_RESUMED = "ACTIVITY_RESUMED";
    public static final String ACTIVITY_STARTED = "ACTIVITY_STARTED";
    public static final String ACTIVITY_STOPPED = "ACTIVITY_STOPPED";
    public static final String APPLICATION_BACKGROUND = "APPLICATION_BACKGROUND";
    public static final String APPLICATION_CREATED = "APPLICATION_CREATED";
    public static final String APPLICATION_FOREGROUND = "APPLICATION_FOREGROUND";
    public static final String DIALOG_FRAGMENT_RESUMED = "DIALOG_FRAGMENT_RESUMED";
    public static final String DISABLE = "DISABLE";
    public static final String DOUBLE_TAP = "DOUBLE_TAP";
    public static final String ENABLE = "ENABLE";
    public static final String END_EDITING = "END_EDITING";
    public static final String FLING = "FLING";
    public static final String FRAGMENT_ATTACHED = "FRAGMENT_ATTACHED";
    public static final String FRAGMENT_DETACHED = "FRAGMENT_DETACHED";
    public static final String FRAGMENT_PAUSED = "FRAGMENT_PAUSED";
    public static final String FRAGMENT_RESUMED = "FRAGMENT_RESUMED";
    public static final String FRAGMENT_STARTED = "FRAGMENT_STARTED";
    public static final String FRAGMENT_STOPPED = "FRAGMENT_STOPPED";
    public static final String FRAGMENT_VIEW_CREATED = "FRAGMENT_VIEW_CREATED";
    public static final String FRAGMENT_VISIBILITY_CHANGED = "FRAGMENT_VISIBILITY_CHANGED";
    public static final String LONG_PRESS = "LONG_PRESS";
    public static final String MOVE = "MOVE";
    public static final String OPEN_DIALOG = "OPEN_DIALOG";
    public static final String PINCH = "PINCH";
    public static final String SCROLL = "SCROLL";
    public static final String SHAKE = "SHAKE";
    public static final String START_EDITING = "START_EDITING";
    public static final String SWIPE = "SWIPE";
    public static final String TAB_SELECT = "TAB_SELECT";
    public static final String TAP = "TAP";
    public static final String UNKNOWN = "UNKNOWN";
}
