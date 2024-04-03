package com.google.android.gms.internal.icing;

public final class zzga extends zzda<zzga, zzfz> implements zzef {
    /* access modifiers changed from: private */
    public static final zzga zzi;
    private int zzb;
    private String zze = "";
    private String zzf = "";
    private zzdg<zzfy> zzg = zzda.zzw();
    private zzfw zzh;

    static {
        zzga zzga = new zzga();
        zzi = zzga;
        zzda.zzq(zzga.class, zzga);
    }

    private zzga() {
    }

    public final Object zzf(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzda.zzr(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဉ\u0002", new Object[]{"zzb", "zze", "zzf", "zzg", zzfy.class, "zzh"});
        } else if (i12 == 3) {
            return new zzga();
        } else {
            if (i12 == 4) {
                return new zzfz((zzfu) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzi;
        }
    }
}
