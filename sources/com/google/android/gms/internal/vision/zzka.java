package com.google.android.gms.internal.vision;

public enum zzka {
    DOUBLE(zzkd.DOUBLE, 1),
    FLOAT(zzkd.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzkd.BOOLEAN, 0),
    STRING(zzkd.STRING, 2),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(zzkd.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(zzkd.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzkd zzace;
    private final int zzacf;

    private zzka(zzkd zzkd, int i11) {
        this.zzace = zzkd;
        this.zzacf = i11;
    }

    public final zzkd zzip() {
        return this.zzace;
    }

    public final int zziq() {
        return this.zzacf;
    }
}
