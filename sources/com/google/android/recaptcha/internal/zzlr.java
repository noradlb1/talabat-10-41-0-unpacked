package com.google.android.recaptcha.internal;

import java.util.List;

public final class zzlr extends zzhf implements zziq {
    /* access modifiers changed from: private */
    public static final zzlr zzb;
    private zzhm zzd = zzhf.zzw();
    private zzhm zze = zzhf.zzw();

    static {
        zzlr zzlr = new zzlr();
        zzb = zzlr;
        zzhf.zzC(zzlr.class, zzlr);
    }

    private zzlr() {
    }

    public static /* synthetic */ void zzH(zzlr zzlr, zzlo zzlo) {
        zzlo.getClass();
        zzhm zzhm = zzlr.zzd;
        if (!zzhm.zzc()) {
            zzlr.zzd = zzhf.zzx(zzhm);
        }
        zzlr.zzd.add(zzlo);
    }

    public static /* synthetic */ void zzI(zzlr zzlr, zzmd zzmd) {
        zzmd.getClass();
        zzhm zzhm = zzlr.zze;
        if (!zzhm.zzc()) {
            zzlr.zze = zzhf.zzx(zzhm);
        }
        zzlr.zze.add(zzmd);
    }

    public static zzlq zzi() {
        return (zzlq) zzb.zzp();
    }

    public static zzlr zzk(byte[] bArr) throws zzhp {
        return (zzlr) zzhf.zzu(zzb, bArr);
    }

    public final List zzG() {
        return this.zzd;
    }

    public final int zzf() {
        return this.zzd.size();
    }

    public final int zzg() {
        return this.zze.size();
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzhf.zzz(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"zzd", zzlo.class, "zze", zzmd.class});
        } else if (i12 == 3) {
            return new zzlr();
        } else {
            if (i12 == 4) {
                return new zzlq((zzlp) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
