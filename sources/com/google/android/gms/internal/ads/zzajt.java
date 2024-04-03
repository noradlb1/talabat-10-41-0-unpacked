package com.google.android.gms.internal.ads;

public final class zzajt extends zzgkl<zzajt, zzajs> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzajt zzb;
    private int zze;
    private zzgjf zzf;
    private zzgjf zzg;
    private zzgjf zzh;
    private zzgjf zzi;

    static {
        zzajt zzajt = new zzajt();
        zzb = zzajt;
        zzgkl.zzaK(zzajt.class, zzajt);
    }

    private zzajt() {
        zzgjf zzgjf = zzgjf.zzb;
        this.zzf = zzgjf;
        this.zzg = zzgjf;
        this.zzh = zzgjf;
        this.zzi = zzgjf;
    }

    public static zzajs zza() {
        return (zzajs) zzb.zzat();
    }

    public static zzajt zzd(byte[] bArr, zzgjx zzgjx) throws zzgkx {
        return (zzajt) zzgkl.zzaz(zzb, bArr, zzgjx);
    }

    public static /* synthetic */ void zzi(zzajt zzajt, zzgjf zzgjf) {
        zzajt.zze |= 1;
        zzajt.zzf = zzgjf;
    }

    public static /* synthetic */ void zzj(zzajt zzajt, zzgjf zzgjf) {
        zzajt.zze |= 2;
        zzajt.zzg = zzgjf;
    }

    public static /* synthetic */ void zzk(zzajt zzajt, zzgjf zzgjf) {
        zzajt.zze |= 4;
        zzajt.zzh = zzgjf;
    }

    public static /* synthetic */ void zzl(zzajt zzajt, zzgjf zzgjf) {
        zzajt.zze |= 8;
        zzajt.zzi = zzgjf;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i12 == 3) {
            return new zzajt();
        } else {
            if (i12 == 4) {
                return new zzajs((zzaiy) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgjf zze() {
        return this.zzf;
    }

    public final zzgjf zzf() {
        return this.zzg;
    }

    public final zzgjf zzg() {
        return this.zzi;
    }

    public final zzgjf zzh() {
        return this.zzh;
    }
}
