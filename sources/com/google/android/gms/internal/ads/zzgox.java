package com.google.android.gms.internal.ads;

import java.util.List;

public final class zzgox extends zzgkl<zzgox, zzgnz> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgox zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private zzgob zzk;
    private zzgku<zzgou> zzl = zzgkl.zzaE();
    private String zzm = "";
    private zzgoo zzn;
    private boolean zzo;
    private zzgku<String> zzp = zzgkl.zzaE();
    private String zzq = "";
    private boolean zzr;
    private boolean zzs;
    private zzgjf zzt = zzgjf.zzb;
    private zzgow zzu;
    private zzgku<String> zzv = zzgkl.zzaE();
    private zzgku<String> zzw = zzgkl.zzaE();
    private byte zzx = 2;

    static {
        zzgox zzgox = new zzgox();
        zzb = zzgox;
        zzgkl.zzaK(zzgox.class, zzgox);
    }

    private zzgox() {
    }

    public static zzgnz zza() {
        return (zzgnz) zzb.zzat();
    }

    public static /* synthetic */ void zzg(zzgox zzgox, String str) {
        str.getClass();
        zzgox.zze |= 4;
        zzgox.zzh = str;
    }

    public static /* synthetic */ void zzh(zzgox zzgox, String str) {
        str.getClass();
        zzgox.zze |= 8;
        zzgox.zzi = str;
    }

    public static /* synthetic */ void zzi(zzgox zzgox, zzgob zzgob) {
        zzgob.getClass();
        zzgox.zzk = zzgob;
        zzgox.zze |= 32;
    }

    public static /* synthetic */ void zzj(zzgox zzgox, zzgou zzgou) {
        zzgou.getClass();
        zzgku<zzgou> zzgku = zzgox.zzl;
        if (!zzgku.zzc()) {
            zzgox.zzl = zzgkl.zzaF(zzgku);
        }
        zzgox.zzl.add(zzgou);
    }

    public static /* synthetic */ void zzk(zzgox zzgox, String str) {
        zzgox.zze |= 64;
        zzgox.zzm = str;
    }

    public static /* synthetic */ void zzl(zzgox zzgox) {
        zzgox.zze &= -65;
        zzgox.zzm = zzb.zzm;
    }

    public static /* synthetic */ void zzm(zzgox zzgox, zzgoo zzgoo) {
        zzgoo.getClass();
        zzgox.zzn = zzgoo;
        zzgox.zze |= 128;
    }

    public static /* synthetic */ void zzn(zzgox zzgox, zzgow zzgow) {
        zzgow.getClass();
        zzgox.zzu = zzgow;
        zzgox.zze |= 8192;
    }

    public static /* synthetic */ void zzo(zzgox zzgox, Iterable iterable) {
        zzgku<String> zzgku = zzgox.zzv;
        if (!zzgku.zzc()) {
            zzgox.zzv = zzgkl.zzaF(zzgku);
        }
        zzgin.zzap(iterable, zzgox.zzv);
    }

    public static /* synthetic */ void zzp(zzgox zzgox, Iterable iterable) {
        zzgku<String> zzgku = zzgox.zzw;
        if (!zzgku.zzc()) {
            zzgox.zzw = zzgkl.zzaF(zzgku);
        }
        zzgin.zzap(iterable, zzgox.zzw);
    }

    public static /* synthetic */ void zzq(zzgox zzgox, int i11) {
        zzgox.zzf = i11 - 1;
        zzgox.zze |= 1;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return Byte.valueOf(this.zzx);
        }
        byte b11 = 1;
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0012\u0000\u0001\u0001\u0015\u0012\u0000\u0004\u0001\u0001ဈ\u0002\u0002ဈ\u0003\u0003ဈ\u0004\u0004Л\u0005ဇ\b\u0006\u001a\u0007ဈ\t\bဇ\n\tဇ\u000b\nဌ\u0000\u000bဌ\u0001\fဉ\u0005\rဈ\u0006\u000eဉ\u0007\u000fည\f\u0011ဉ\r\u0014\u001a\u0015\u001a", new Object[]{"zze", "zzh", "zzi", "zzj", "zzl", zzgou.class, "zzo", "zzp", "zzq", "zzr", "zzs", "zzf", zzgop.zza, "zzg", zzgny.zza, "zzk", "zzm", "zzn", "zzt", "zzu", "zzv", "zzw"});
        } else if (i12 == 3) {
            return new zzgox();
        } else {
            if (i12 == 4) {
                return new zzgnz((zzgnx) null);
            }
            if (i12 == 5) {
                return zzb;
            }
            if (obj == null) {
                b11 = 0;
            }
            this.zzx = b11;
            return null;
        }
    }

    public final String zzd() {
        return this.zzm;
    }

    public final String zze() {
        return this.zzh;
    }

    public final List<zzgou> zzf() {
        return this.zzl;
    }
}
