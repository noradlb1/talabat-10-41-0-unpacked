package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;

public final class zzgc extends zzcg.zzd<zzgc, zza> {
    private static volatile zzdz<zzgc> zzbg;
    /* access modifiers changed from: private */
    public static final zzgc zzsg;
    private byte zzsf = 2;

    public static final class zza extends zzcg.zzc<zzgc, zza> {
        private zza() {
            super(zzgc.zzsg);
        }

        public /* synthetic */ zza(zzgd zzgd) {
            this();
        }
    }

    static {
        zzgc zzgc = new zzgc();
        zzsg = zzgc;
        zzcg.zza(zzgc.class, zzgc);
    }

    private zzgc() {
    }

    public static zzgc zzer() {
        return zzsg;
    }

    /* JADX WARNING: type inference failed for: r2v13, types: [com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgc>, com.google.android.gms.internal.clearcut.zzcg$zzb] */
    public final Object zza(int i11, Object obj, Object obj2) {
        zzdz<zzgc> zzdz;
        int i12 = 1;
        switch (zzgd.zzba[i11 - 1]) {
            case 1:
                return new zzgc();
            case 2:
                return new zza((zzgd) null);
            case 3:
                return zzcg.zza((zzdo) zzsg, "\u0003\u0000", (Object[]) null);
            case 4:
                return zzsg;
            case 5:
                zzdz<zzgc> zzdz2 = zzbg;
                zzdz<zzgc> zzdz3 = zzdz2;
                if (zzdz2 == null) {
                    synchronized (zzgc.class) {
                        zzdz<zzgc> zzdz4 = zzbg;
                        zzdz = zzdz4;
                        if (zzdz4 == null) {
                            ? zzb = new zzcg.zzb(zzsg);
                            zzbg = zzb;
                            zzdz = zzb;
                        }
                    }
                    zzdz3 = zzdz;
                }
                return zzdz3;
            case 6:
                return Byte.valueOf(this.zzsf);
            case 7:
                if (obj == null) {
                    i12 = 0;
                }
                this.zzsf = (byte) i12;
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
