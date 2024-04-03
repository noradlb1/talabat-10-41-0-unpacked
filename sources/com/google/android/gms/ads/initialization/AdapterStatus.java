package com.google.android.gms.ads.initialization;

import androidx.annotation.RecentlyNonNull;

public interface AdapterStatus {

    public enum State {
        NOT_READY,
        READY
    }

    @RecentlyNonNull
    String getDescription();

    @RecentlyNonNull
    State getInitializationState();

    int getLatency();
}
