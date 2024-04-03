package com.google.android.gms.internal.icing;

final class zzdw implements zzeq {
    private static final zzec zzb = new zzdu();
    private final zzec zza;

    public zzdw() {
        zzec zzec;
        zzec[] zzecArr = new zzec[2];
        zzecArr[0] = zzcw.zza();
        try {
            zzec = (zzec) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zzec = zzb;
        }
        zzecArr[1] = zzec;
        zzdv zzdv = new zzdv(zzecArr);
        zzdh.zzb(zzdv, "messageInfoFactory");
        this.zza = zzdv;
    }

    private static boolean zzb(zzeb zzeb) {
        return zzeb.zzc() == 1;
    }

    public final <T> zzep<T> zza(Class<T> cls) {
        zzer.zza(cls);
        zzeb zzc = this.zza.zzc(cls);
        Class<zzda> cls2 = zzda.class;
        if (zzc.zza()) {
            if (cls2.isAssignableFrom(cls)) {
                return zzei.zzg(zzer.zzC(), zzcs.zza(), zzc.zzb());
            }
            return zzei.zzg(zzer.zzA(), zzcs.zzb(), zzc.zzb());
        } else if (cls2.isAssignableFrom(cls)) {
            if (zzb(zzc)) {
                return zzeh.zzg(cls, zzc, zzek.zzb(), zzds.zzd(), zzer.zzC(), zzcs.zza(), zzea.zzb());
            }
            return zzeh.zzg(cls, zzc, zzek.zzb(), zzds.zzd(), zzer.zzC(), (zzcq<?>) null, zzea.zzb());
        } else if (zzb(zzc)) {
            return zzeh.zzg(cls, zzc, zzek.zza(), zzds.zzc(), zzer.zzA(), zzcs.zzb(), zzea.zza());
        } else {
            return zzeh.zzg(cls, zzc, zzek.zza(), zzds.zzc(), zzer.zzB(), (zzcq<?>) null, zzea.zza());
        }
    }
}
