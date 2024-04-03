package com.instabug.library.model.session;

import androidx.annotation.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Keep
@Retention(RetentionPolicy.SOURCE)
public @interface SessionParameter {
    public static final String APP_TOKEN = "application_token";
    public static final String APP_VERSION = "app_version";
    public static final String CRASH_REPORTING_ENABLED = "crash_reporting_enabled";
    public static final String CUSTOM_ATTRIBUTES = "custom_attributes";
    public static final String CUSTOM_ATTRIBUTES_KEYS = "custom_attribute_keys";
    public static final String DEVICE = "device";
    public static final String DURATION = "duration";
    public static final String OS = "os";
    public static final String SDK_VERSION = "sdk_version";
    public static final String STARTED_AT = "started_at";
    public static final String STITCHED_SESSION_LEAD = "stitched_session_lead";
    public static final String USER_EMAIL = "email";
    public static final String USER_EVENTS = "user_events";
    public static final String USER_EVENTS_KEYS = "user_event_keys";
    public static final String USER_NAME = "name";
    public static final String UUID = "uuid";
}
