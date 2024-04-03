package com.google.android.libraries.places.internal;

public final class zzaae extends zzabs<zzaae, zzaad> implements zzada {
    /* access modifiers changed from: private */
    public static final zzaae zzb;
    private int zze;
    private int zzf;
    private zzzi zzg;
    private zzzi zzh;
    private zzabz<zzaab> zzi = zzabs.zzB();
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private zzzi zzo;
    private zzzl zzp;
    private zzzr zzq;
    private int zzr;
    private int zzs;
    private zzzo zzt;
    private byte zzu = 2;

    static {
        zzaae zzaae = new zzaae();
        zzb = zzaae;
        zzabs.zzG(zzaae.class, zzaae);
    }

    private zzaae() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return Byte.valueOf(this.zzu);
        }
        byte b11 = 1;
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u000f\u0000\u0001\u0002\u0010\u000f\u0000\u0001\u0001\u0002ᔄ\u0000\u0003ဉ\u0001\u0004ဉ\u0002\u0005\u001b\u0006င\u0003\u0007င\u0004\bင\u0005\tင\u0006\nင\u0007\u000bဉ\b\fဉ\t\rဉ\n\u000eင\u000b\u000fင\f\u0010ဉ\r", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzaab.class, "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt"});
        } else if (i12 == 3) {
            return new zzaae();
        } else {
            if (i12 == 4) {
                return new zzaad((zzaac) null);
            }
            if (i12 == 5) {
                return zzb;
            }
            if (obj == null) {
                b11 = 0;
            }
            this.zzu = b11;
            return null;
        }
    }
}
