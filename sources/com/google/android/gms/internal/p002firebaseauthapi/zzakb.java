package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakb  reason: invalid package */
public enum zzakb {
    DOUBLE(zzakc.DOUBLE, 1),
    FLOAT(zzakc.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzakc.BOOLEAN, 0),
    STRING(zzakc.STRING, 2),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(zzakc.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(zzakc.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzakc zzt;

    private zzakb(zzakc zzakc, int i11) {
        this.zzt = zzakc;
    }

    public final zzakc zza() {
        return this.zzt;
    }
}
