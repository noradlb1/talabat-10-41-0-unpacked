package com.google.android.gms.internal.ads;

public enum zzgnv {
    DOUBLE(zzgnw.DOUBLE, 1),
    FLOAT(zzgnw.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzgnw.BOOLEAN, 0),
    STRING(zzgnw.STRING, 2),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(zzgnw.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(zzgnw.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzgnw zzt;

    private zzgnv(zzgnw zzgnw, int i11) {
        this.zzt = zzgnw;
    }

    public final zzgnw zza() {
        return this.zzt;
    }
}
