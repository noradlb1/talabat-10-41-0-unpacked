package com.google.android.gms.internal.icing;

public enum zzfs {
    DOUBLE(zzft.DOUBLE, 1),
    FLOAT(zzft.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzft.BOOLEAN, 0),
    STRING(zzft.STRING, 2),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(zzft.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(zzft.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzft zzs;

    private zzfs(zzft zzft, int i11) {
        this.zzs = zzft;
    }

    public final zzft zza() {
        return this.zzs;
    }
}
