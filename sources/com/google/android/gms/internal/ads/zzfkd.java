package com.google.android.gms.internal.ads;

import com.facebook.internal.AnalyticsEvents;

public enum zzfkd {
    HTML("html"),
    NATIVE(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE),
    JAVASCRIPT("javascript");
    
    private final String zze;

    private zzfkd(String str) {
        this.zze = str;
    }

    public final String toString() {
        return this.zze;
    }
}
