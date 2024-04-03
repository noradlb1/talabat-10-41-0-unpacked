package com.google.android.gms.internal.ads;

final class zzgln implements zzgmp {
    private static final zzglt zza = new zzgll();
    private final zzglt zzb;

    public zzgln() {
        zzglt zzglt;
        zzglt[] zzgltArr = new zzglt[2];
        zzgltArr[0] = zzgkg.zza();
        try {
            zzglt = (zzglt) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zzglt = zza;
        }
        zzgltArr[1] = zzglt;
        zzglm zzglm = new zzglm(zzgltArr);
        zzgkv.zzf(zzglm, "messageInfoFactory");
        this.zzb = zzglm;
    }

    private static boolean zzb(zzgls zzgls) {
        return zzgls.zzc() == 1;
    }

    public final <T> zzgmo<T> zza(Class<T> cls) {
        zzgmq.zzG(cls);
        zzgls zzb2 = this.zzb.zzb(cls);
        Class<zzgkl> cls2 = zzgkl.class;
        if (zzb2.zzb()) {
            if (cls2.isAssignableFrom(cls)) {
                return zzglz.zzc(zzgmq.zzB(), zzgka.zzb(), zzb2.zza());
            }
            return zzglz.zzc(zzgmq.zzz(), zzgka.zza(), zzb2.zza());
        } else if (cls2.isAssignableFrom(cls)) {
            if (zzb(zzb2)) {
                return zzgly.zzl(cls, zzb2, zzgmb.zzb(), zzglj.zze(), zzgmq.zzB(), zzgka.zzb(), zzglr.zzb());
            }
            return zzgly.zzl(cls, zzb2, zzgmb.zzb(), zzglj.zze(), zzgmq.zzB(), (zzgjy<?>) null, zzglr.zzb());
        } else if (zzb(zzb2)) {
            return zzgly.zzl(cls, zzb2, zzgmb.zza(), zzglj.zzd(), zzgmq.zzz(), zzgka.zza(), zzglr.zza());
        } else {
            return zzgly.zzl(cls, zzb2, zzgmb.zza(), zzglj.zzd(), zzgmq.zzA(), (zzgjy<?>) null, zzglr.zza());
        }
    }
}
