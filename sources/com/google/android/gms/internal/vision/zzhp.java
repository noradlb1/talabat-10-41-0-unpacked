package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;

final class zzhp implements zziu {
    private static final zzhz zzyi = new zzhs();
    private final zzhz zzyh;

    public zzhp() {
        this(new zzhr(zzgq.zzfw(), zzhb()));
    }

    private static boolean zza(zzia zzia) {
        return zzia.zzhi() == zzgs.zzf.zzwt;
    }

    private static zzhz zzhb() {
        try {
            return (zzhz) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return zzyi;
        }
    }

    public final <T> zzir<T> zze(Class<T> cls) {
        zzit.zzg(cls);
        zzia zzb = this.zzyh.zzb(cls);
        Class<zzgs> cls2 = zzgs.class;
        if (zzb.zzhj()) {
            if (cls2.isAssignableFrom(cls)) {
                return zzii.zza(zzit.zzhu(), zzgj.zzfq(), zzb.zzhk());
            }
            return zzii.zza(zzit.zzhs(), zzgj.zzfr(), zzb.zzhk());
        } else if (cls2.isAssignableFrom(cls)) {
            if (zza(zzb)) {
                return zzig.zza(cls, zzb, zzim.zzhm(), zzhm.zzha(), zzit.zzhu(), zzgj.zzfq(), zzhx.zzhg());
            }
            return zzig.zza(cls, zzb, zzim.zzhm(), zzhm.zzha(), zzit.zzhu(), (zzgf<?>) null, zzhx.zzhg());
        } else if (zza(zzb)) {
            return zzig.zza(cls, zzb, zzim.zzhl(), zzhm.zzgz(), zzit.zzhs(), zzgj.zzfr(), zzhx.zzhf());
        } else {
            return zzig.zza(cls, zzb, zzim.zzhl(), zzhm.zzgz(), zzit.zzht(), (zzgf<?>) null, zzhx.zzhf());
        }
    }

    private zzhp(zzhz zzhz) {
        this.zzyh = (zzhz) zzgt.zza(zzhz, "messageInfoFactory");
    }
}
