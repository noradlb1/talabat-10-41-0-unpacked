package com.google.android.libraries.places.internal;

import com.google.android.exoplayer2.C;

public final class zzwh extends zzabs<zzwh, zzwc> implements zzada {
    /* access modifiers changed from: private */
    public static final zzwh zzb;
    private zzuq zzA;
    private zzyv zzB;
    private boolean zzC;
    private String zzD = "";
    private zzva zzE;
    private boolean zzF;
    private String zzG = "";
    private int zzH;
    private String zzI = "";
    private String zzJ = "";
    private int zzK;
    private String zzL = "";
    private byte zzM = 2;
    private int zze;
    private int zzf;
    private int zzg = 1;
    private zzjy zzh;
    private zzna zzi;
    private int zzj;
    private float zzk;
    private zzabz<zzyz> zzl = zzabs.zzB();
    private zzxt zzm;
    private zzabz<zzvd> zzn = zzabs.zzB();
    private zzvd zzo;
    private zzvk zzp;
    private zzxl zzq;
    private zzwv zzr;
    private zzxe zzs;
    private zzxa zzt;
    private zzxq zzu;
    private zzvw zzv;
    private zzwj zzw;
    private zzxg zzx;
    private zzvz zzy;
    private zzvn zzz;

    static {
        zzwh zzwh = new zzwh();
        zzb = zzwh;
        zzabs.zzG(zzwh.class, zzwh);
    }

    private zzwh() {
    }

    public static zzwc zza() {
        return (zzwc) zzb.zzx();
    }

    public static /* synthetic */ void zzc(zzwh zzwh, zzxt zzxt) {
        zzxt.getClass();
        zzwh.zzm = zzxt;
        zzwh.zze |= 64;
    }

    public static /* synthetic */ void zze(zzwh zzwh, zzxl zzxl) {
        zzxl.getClass();
        zzwh.zzq = zzxl;
        zzwh.zze |= 512;
    }

    public static /* synthetic */ void zzf(zzwh zzwh, zzwv zzwv) {
        zzwv.getClass();
        zzwh.zzr = zzwv;
        zzwh.zze |= 1024;
    }

    public static /* synthetic */ void zzg(zzwh zzwh, zzjy zzjy) {
        zzjy.getClass();
        zzwh.zzh = zzjy;
        zzwh.zze |= 4;
    }

    public static /* synthetic */ void zzh(zzwh zzwh, zzvw zzvw) {
        zzvw.getClass();
        zzwh.zzv = zzvw;
        zzwh.zze |= 16384;
    }

    public static /* synthetic */ void zzi(zzwh zzwh, zzva zzva) {
        zzva.getClass();
        zzwh.zzE = zzva;
        zzwh.zze |= 8388608;
    }

    public static /* synthetic */ void zzj(zzwh zzwh, boolean z11) {
        zzwh.zze |= 16777216;
        zzwh.zzF = true;
    }

    public static /* synthetic */ void zzk(zzwh zzwh, String str) {
        str.getClass();
        zzwh.zze |= 33554432;
        zzwh.zzG = str;
    }

    public static /* synthetic */ void zzl(zzwh zzwh, String str) {
        zzwh.zze |= C.BUFFER_FLAG_FIRST_SAMPLE;
        zzwh.zzI = "2.5.0";
    }

    public static /* synthetic */ void zzm(zzwh zzwh, String str) {
        str.getClass();
        zzwh.zze |= 1073741824;
        zzwh.zzL = str;
    }

    public static /* synthetic */ void zzn(zzwh zzwh, int i11) {
        zzwh.zzg = i11;
        zzwh.zze |= 2;
    }

    public static /* synthetic */ void zzo(zzwh zzwh, int i11) {
        zzwh.zzK = i11 - 1;
        zzwh.zze |= 536870912;
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return Byte.valueOf(this.zzM);
        }
        byte b11 = 1;
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001!\u0000\u0001\u0001!!\u0000\u0002\u0003\u0001ဌ\u0001\u0002ဉ\u0002\u0003ᐉ\u0003\u0004\u001b\u0005ᐉ\u0006\u0006\u001b\u0007ဉ\u0007\bᐉ\b\tဌ\u0004\nခ\u0005\u000bဇ\u0015\fဉ\t\rဈ\u0016\u000eဉ\n\u000fဉ\u000b\u0010ဉ\f\u0011ဉ\r\u0012ဉ\u000e\u0013ဉ\u000f\u0014ဉ\u0010\u0015ဉ\u0011\u0016ဉ\u0012\u0017ဉ\u0013\u0018ဉ\u0017\u0019င\u0000\u001aဉ\u0014\u001bဇ\u0018\u001cဈ\u0019\u001dဌ\u001a\u001eဈ\u001b\u001fဈ\u001c ဌ\u001d!ဈ\u001e", new Object[]{"zze", "zzg", zzwe.zza, "zzh", "zzi", "zzl", zzyz.class, "zzm", "zzn", zzvd.class, "zzo", "zzp", "zzj", zzwd.zza, "zzk", "zzC", "zzq", "zzD", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzE", "zzf", "zzB", "zzF", "zzG", "zzH", zzwf.zza, "zzI", "zzJ", "zzK", zzwg.zza, "zzL"});
        } else if (i12 == 3) {
            return new zzwh();
        } else {
            if (i12 == 4) {
                return new zzwc((zztv) null);
            }
            if (i12 == 5) {
                return zzb;
            }
            if (obj == null) {
                b11 = 0;
            }
            this.zzM = b11;
            return null;
        }
    }
}
