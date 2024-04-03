package com.iab.omid.library.deliveryhero3.adsession;

import com.facebook.internal.AnalyticsEvents;

public enum AdSessionContextType {
    HTML("html"),
    NATIVE(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE),
    JAVASCRIPT("javascript");
    
    private final String typeString;

    private AdSessionContextType(String str) {
        this.typeString = str;
    }

    public String toString() {
        return this.typeString;
    }
}
