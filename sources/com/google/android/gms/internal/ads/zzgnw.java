package com.google.android.gms.internal.ads;

public enum zzgnw {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzgjf.zzb),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzk;

    private zzgnw(Object obj) {
        this.zzk = obj;
    }
}
