package com.google.android.gms.internal.ads;

public enum zzbdj implements zzgkn {
    UNSPECIFIED(0),
    CONNECTING(1),
    CONNECTED(2),
    DISCONNECTING(3),
    DISCONNECTED(4),
    zzf(5);
    
    private static final zzgko<zzbdj> zzg = null;
    private final int zzi;

    /* access modifiers changed from: public */
    static {
        zzg = new zzbdh();
    }

    private zzbdj(int i11) {
        this.zzi = i11;
    }

    public static zzbdj zzb(int i11) {
        if (i11 == 0) {
            return UNSPECIFIED;
        }
        if (i11 == 1) {
            return CONNECTING;
        }
        if (i11 == 2) {
            return CONNECTED;
        }
        if (i11 == 3) {
            return DISCONNECTING;
        }
        if (i11 == 4) {
            return DISCONNECTED;
        }
        if (i11 != 5) {
            return null;
        }
        return zzf;
    }

    public static zzgkp zzc() {
        return zzbdi.zza;
    }

    public final String toString() {
        return Integer.toString(this.zzi);
    }

    public final int zza() {
        return this.zzi;
    }
}
