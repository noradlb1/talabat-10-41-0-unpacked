package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;

public enum zzfkf {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    HTML_DISPLAY("htmlDisplay"),
    NATIVE_DISPLAY("nativeDisplay"),
    zzd("video"),
    AUDIO(MimeTypes.BASE_TYPE_AUDIO);
    
    private final String zzg;

    private zzfkf(String str) {
        this.zzg = str;
    }

    public final String toString() {
        return this.zzg;
    }
}
