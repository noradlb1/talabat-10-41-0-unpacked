package com.google.android.libraries.places.internal;

public final class zzvf extends zzabs<zzvf, zzve> implements zzada {
    /* access modifiers changed from: private */
    public static final zzvf zzb;
    private int zze;
    private int zzf;
    private zzabz<String> zzg = zzabs.zzB();
    private String zzh = "";
    private String zzi = "";
    private boolean zzj;
    private zzabz<String> zzk = zzabs.zzB();

    static {
        zzvf zzvf = new zzvf();
        zzb = zzvf;
        zzabs.zzG(zzvf.class, zzvf);
    }

    private zzvf() {
    }

    public static zzve zza() {
        return (zzve) zzb.zzx();
    }

    public static /* synthetic */ void zzc(zzvf zzvf, String str) {
        str.getClass();
        zzabz<String> zzabz = zzvf.zzg;
        if (!zzabz.zzc()) {
            zzvf.zzg = zzabs.zzC(zzabz);
        }
        zzvf.zzg.add(str);
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0002\u0000\u0001င\u0000\u0002\u001a\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006\u001a", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i12 == 3) {
            return new zzvf();
        } else {
            if (i12 == 4) {
                return new zzve((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
