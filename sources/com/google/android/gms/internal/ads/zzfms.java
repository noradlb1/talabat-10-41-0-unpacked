package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
public final class zzfms {
    private final Context zza;
    private final Looper zzb;

    public zzfms(@NonNull Context context, @NonNull Looper looper) {
        this.zza = context;
        this.zzb = looper;
    }

    public final void zza(@NonNull String str) {
        zzfng zza2 = zzfni.zza();
        zza2.zza(this.zza.getPackageName());
        zza2.zzc(2);
        zzfnd zza3 = zzfne.zza();
        zza3.zza(str);
        zza3.zzb(2);
        zza2.zzb(zza3);
        new zzfmt(this.zza, this.zzb, (zzfni) zza2.zzah()).zza();
    }
}
