package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;

public abstract class zzfka {
    public static zzfka zza(zzfkb zzfkb, zzfkc zzfkc) {
        if (zzfjy.zzb()) {
            return new zzfke(zzfkb, zzfkc);
        }
        throw new IllegalStateException("Method called before OM SDK activation");
    }

    public abstract void zzb(View view, zzfkg zzfkg, @Nullable String str);

    public abstract void zzc();

    public abstract void zzd(View view);

    public abstract void zze();
}
