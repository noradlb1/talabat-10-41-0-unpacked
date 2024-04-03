package com.google.android.gms.internal.ads;

public enum zzfkh {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    UNSPECIFIED("unspecified"),
    LOADED("loaded"),
    BEGIN_TO_RENDER("beginToRender"),
    ONE_PIXEL("onePixel"),
    VIEWABLE("viewable"),
    AUDIBLE("audible"),
    OTHER("other");
    
    private final String zzj;

    private zzfkh(String str) {
        this.zzj = str;
    }

    public final String toString() {
        return this.zzj;
    }
}
