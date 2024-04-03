package com.google.android.gms.internal.ads;

import com.facebook.internal.AnalyticsEvents;

public enum zzfki {
    NATIVE(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE),
    JAVASCRIPT("javascript"),
    zzc("none");
    
    private final String zze;

    private zzfki(String str) {
        this.zze = str;
    }

    public final String toString() {
        return this.zze;
    }
}
