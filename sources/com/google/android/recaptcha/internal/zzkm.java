package com.google.android.recaptcha.internal;

public enum zzkm {
    DOUBLE(zzkn.DOUBLE, 1),
    FLOAT(zzkn.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzkn.BOOLEAN, 0),
    STRING(zzkn.STRING, 2),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(zzkn.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(zzkn.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzkn zzt;

    private zzkm(zzkn zzkn, int i11) {
        this.zzt = zzkn;
    }

    public final zzkn zza() {
        return this.zzt;
    }
}
