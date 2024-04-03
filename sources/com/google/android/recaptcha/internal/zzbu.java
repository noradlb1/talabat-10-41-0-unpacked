package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

final class zzbu extends Lambda implements Function2 {
    final /* synthetic */ zzbh zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ int zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbu(zzbh zzbh, String str, int i11) {
        super(2);
        this.zza = zzbh;
        this.zzb = str;
        this.zzc = i11;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        Object[] objArr = (Object[]) obj;
        this.zza.zzd().zzb(this.zzb, (String) obj2);
        int i11 = this.zzc;
        if (i11 != -1) {
            this.zza.zze().zzf(i11, objArr);
        }
        return Unit.INSTANCE;
    }
}
