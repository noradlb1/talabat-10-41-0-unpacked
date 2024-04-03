package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;

final class zzrz implements zzta {
    private static final zzsj zzbcn = new zzsa();
    private final zzsj zzbcm;

    public zzrz() {
        this(new zzsb(zzrb.zzpc(), zzqe()));
    }

    private static boolean zza(zzsi zzsi) {
        return zzsi.zzql() == zzrc.zze.zzbaz;
    }

    private static zzsj zzqe() {
        try {
            return (zzsj) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return zzbcn;
        }
    }

    public final <T> zzsz<T> zzh(Class<T> cls) {
        zztb.zzj(cls);
        zzsi zzf = this.zzbcm.zzf(cls);
        Class<zzrc> cls2 = zzrc.class;
        if (zzf.zzqm()) {
            if (cls2.isAssignableFrom(cls)) {
                return zzsp.zza(zztb.zzqx(), zzqs.zzot(), zzf.zzqn());
            }
            return zzsp.zza(zztb.zzqv(), zzqs.zzou(), zzf.zzqn());
        } else if (cls2.isAssignableFrom(cls)) {
            if (zza(zzf)) {
                return zzso.zza(cls, zzf, zzst.zzqq(), zzru.zzqd(), zztb.zzqx(), zzqs.zzot(), zzsh.zzqj());
            }
            return zzso.zza(cls, zzf, zzst.zzqq(), zzru.zzqd(), zztb.zzqx(), (zzqq<?>) null, zzsh.zzqj());
        } else if (zza(zzf)) {
            return zzso.zza(cls, zzf, zzst.zzqp(), zzru.zzqc(), zztb.zzqv(), zzqs.zzou(), zzsh.zzqi());
        } else {
            return zzso.zza(cls, zzf, zzst.zzqp(), zzru.zzqc(), zztb.zzqw(), (zzqq<?>) null, zzsh.zzqi());
        }
    }

    private zzrz(zzsj zzsj) {
        this.zzbcm = (zzsj) zzre.zza(zzsj, "messageInfoFactory");
    }
}
