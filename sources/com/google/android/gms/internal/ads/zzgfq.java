package com.google.android.gms.internal.ads;

import java.util.List;

public final class zzgfq extends zzgkl<zzgfq, zzgfn> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgfq zzb;
    private int zze;
    private zzgku<zzgfp> zzf = zzgkl.zzaE();

    static {
        zzgfq zzgfq = new zzgfq();
        zzb = zzgfq;
        zzgkl.zzaK(zzgfq.class, zzgfq);
    }

    private zzgfq() {
    }

    public static zzgfq zze(byte[] bArr, zzgjx zzgjx) throws zzgkx {
        return (zzgfq) zzgkl.zzaz(zzb, bArr, zzgjx);
    }

    public final int zza() {
        return this.zzf.size();
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zze", "zzf", zzgfp.class});
        } else if (i12 == 3) {
            return new zzgfq();
        } else {
            if (i12 == 4) {
                return new zzgfn((zzgfm) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final int zzc() {
        return this.zze;
    }

    public final List<zzgfp> zzf() {
        return this.zzf;
    }
}
