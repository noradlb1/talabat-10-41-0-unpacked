package com.instabug.library.model.session;

import androidx.annotation.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Keep
@Retention(RetentionPolicy.SOURCE)
public @interface SyncStatus {
    public static final int OFFLINE = 0;
    public static final int READY_FOR_SYNC = 1;
    public static final int SYNCED_WITH_REMOTE = 2;
}
