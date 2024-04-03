package com.google.android.recaptcha.internal;

public enum zzkn {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzfi.zzb),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzk;

    private zzkn(Object obj) {
        this.zzk = obj;
    }
}
