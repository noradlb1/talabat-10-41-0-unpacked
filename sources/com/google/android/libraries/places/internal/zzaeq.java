package com.google.android.libraries.places.internal;

public enum zzaeq {
    DOUBLE(zzaer.DOUBLE, 1),
    FLOAT(zzaer.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzaer.BOOLEAN, 0),
    STRING(zzaer.STRING, 2),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(zzaer.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(zzaer.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzaer zzt;

    private zzaeq(zzaer zzaer, int i11) {
        this.zzt = zzaer;
    }

    public final zzaer zza() {
        return this.zzt;
    }
}
