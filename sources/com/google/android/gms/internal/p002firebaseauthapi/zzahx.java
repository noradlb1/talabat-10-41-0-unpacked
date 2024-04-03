package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahx  reason: invalid package */
final class zzahx implements zzais {
    private static final zzaid zza = new zzahv();
    private final zzaid zzb;

    public zzahx() {
        zzaid zzaid;
        zzaid[] zzaidArr = new zzaid[2];
        zzaidArr[0] = zzagv.zza();
        try {
            zzaid = (zzaid) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zzaid = zza;
        }
        zzaidArr[1] = zzaid;
        zzahw zzahw = new zzahw(zzaidArr);
        byte[] bArr = zzahg.zzd;
        this.zzb = zzahw;
    }

    private static boolean zzb(zzaic zzaic) {
        return zzaic.zzc() + -1 != 1;
    }

    public final zzair zza(Class cls) {
        zzait.zzr(cls);
        zzaic zzb2 = this.zzb.zzb(cls);
        Class<zzaha> cls2 = zzaha.class;
        if (zzb2.zzb()) {
            if (cls2.isAssignableFrom(cls)) {
                return zzaij.zzc(zzait.zzn(), zzagq.zzb(), zzb2.zza());
            }
            return zzaij.zzc(zzait.zzm(), zzagq.zza(), zzb2.zza());
        } else if (cls2.isAssignableFrom(cls)) {
            if (zzb(zzb2)) {
                return zzaii.zzl(cls, zzb2, zzail.zzb(), zzaht.zze(), zzait.zzn(), zzagq.zzb(), zzaib.zzb());
            }
            return zzaii.zzl(cls, zzb2, zzail.zzb(), zzaht.zze(), zzait.zzn(), (zzago) null, zzaib.zzb());
        } else if (zzb(zzb2)) {
            return zzaii.zzl(cls, zzb2, zzail.zza(), zzaht.zzd(), zzait.zzm(), zzagq.zza(), zzaib.zza());
        } else {
            return zzaii.zzl(cls, zzb2, zzail.zza(), zzaht.zzd(), zzait.zzm(), (zzago) null, zzaib.zza());
        }
    }
}
