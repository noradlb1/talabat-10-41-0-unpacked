package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@Deprecated
@ParametersAreNonnullByDefault
public final class zzblp {
    public static final void zza(zzblo zzblo, @Nullable zzblm zzblm) {
        if (zzblm.zza() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(zzblm.zzb())) {
            zzblo.zzd(zzblm.zza(), zzblm.zzb(), zzblm.zzc(), zzblm.zzd());
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }
}
