package com.google.android.gms.internal.gtm;

public enum zzug {
    DOUBLE(zzul.DOUBLE, 1),
    FLOAT(zzul.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzul.BOOLEAN, 0),
    STRING(zzul.STRING, 2),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(zzul.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(zzul.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzul zzbgh;
    private final int zzbgi;

    private zzug(zzul zzul, int i11) {
        this.zzbgh = zzul;
        this.zzbgi = i11;
    }

    public final zzul zzrs() {
        return this.zzbgh;
    }

    public final int zzrt() {
        return this.zzbgi;
    }
}
