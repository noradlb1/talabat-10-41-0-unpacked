package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;

public enum zzcbo {
    BEGIN_TO_RENDER("beginToRender"),
    DEFINED_BY_JAVASCRIPT("definedByJavascript"),
    ONE_PIXEL("onePixel"),
    UNSPECIFIED("unspecified");
    
    private final String zzf;

    private zzcbo(String str) {
        this.zzf = str;
    }

    @NonNull
    public final String toString() {
        return this.zzf;
    }
}
