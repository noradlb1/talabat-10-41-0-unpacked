package com.google.android.gms.internal.places;

public enum zzef {
    DOUBLE(zzem.DOUBLE, 1),
    FLOAT(zzem.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzem.BOOLEAN, 0),
    STRING(zzem.STRING, 2),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(zzem.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(zzem.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzem zzob;
    private final int zzoc;

    private zzef(zzem zzem, int i11) {
        this.zzob = zzem;
        this.zzoc = i11;
    }

    public final zzem zzdr() {
        return this.zzob;
    }

    public final int zzds() {
        return this.zzoc;
    }
}
