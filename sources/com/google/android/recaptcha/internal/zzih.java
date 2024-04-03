package com.google.android.recaptcha.internal;

final class zzih implements zzjd {
    private static final zzin zza = new zzif();
    private final zzin zzb;

    public zzih() {
        zzin zzin;
        zzin[] zzinArr = new zzin[2];
        zzinArr[0] = zzgy.zza();
        try {
            zzin = (zzin) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zzin = zza;
        }
        zzinArr[1] = zzin;
        zzig zzig = new zzig(zzinArr);
        byte[] bArr = zzhn.zzd;
        this.zzb = zzig;
    }

    private static boolean zzb(zzim zzim) {
        return zzim.zzc() + -1 != 1;
    }

    public final zzjc zza(Class cls) {
        zzje.zzE(cls);
        zzim zzb2 = this.zzb.zzb(cls);
        Class<zzhf> cls2 = zzhf.class;
        if (zzb2.zzb()) {
            if (cls2.isAssignableFrom(cls)) {
                return zzit.zzc(zzje.zzz(), zzgt.zzb(), zzb2.zza());
            }
            return zzit.zzc(zzje.zzy(), zzgt.zza(), zzb2.zza());
        } else if (cls2.isAssignableFrom(cls)) {
            if (zzb(zzb2)) {
                return zzis.zzm(cls, zzb2, zziw.zzb(), zzid.zze(), zzje.zzz(), zzgt.zzb(), zzil.zzb());
            }
            return zzis.zzm(cls, zzb2, zziw.zzb(), zzid.zze(), zzje.zzz(), (zzgr) null, zzil.zzb());
        } else if (zzb(zzb2)) {
            return zzis.zzm(cls, zzb2, zziw.zza(), zzid.zzd(), zzje.zzy(), zzgt.zza(), zzil.zza());
        } else {
            return zzis.zzm(cls, zzb2, zziw.zza(), zzid.zzd(), zzje.zzy(), (zzgr) null, zzil.zza());
        }
    }
}
