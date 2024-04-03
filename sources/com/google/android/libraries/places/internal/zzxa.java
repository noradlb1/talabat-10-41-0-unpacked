package com.google.android.libraries.places.internal;

public final class zzxa extends zzabs<zzxa, zzwz> implements zzada {
    /* access modifiers changed from: private */
    public static final zzxa zzb;
    private int zze;
    private int zzf;
    private zzabz<String> zzg = zzabs.zzB();
    private int zzh;
    private int zzi;
    private long zzj;
    private String zzk = "";
    private boolean zzl;

    static {
        zzxa zzxa = new zzxa();
        zzb = zzxa;
        zzabs.zzG(zzxa.class, zzxa);
    }

    private zzxa() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001a\u0003င\u0001\u0004ဌ\u0002\u0005ဂ\u0003\u0006ဈ\u0004\u0007ဇ\u0005", new Object[]{"zze", "zzf", zzut.zza, "zzg", "zzh", "zzi", zzxd.zza, "zzj", "zzk", "zzl"});
        } else if (i12 == 3) {
            return new zzxa();
        } else {
            if (i12 == 4) {
                return new zzwz((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
