package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public final class zzagy<T> {
    @Nullable
    public final T zza;
    @Nullable
    public final zzagb zzb;
    @Nullable
    public final zzahb zzc;
    public boolean zzd;

    private zzagy(zzahb zzahb) {
        this.zzd = false;
        this.zza = null;
        this.zzb = null;
        this.zzc = zzahb;
    }

    private zzagy(@Nullable T t11, @Nullable zzagb zzagb) {
        this.zzd = false;
        this.zza = t11;
        this.zzb = zzagb;
        this.zzc = null;
    }

    public static <T> zzagy<T> zza(zzahb zzahb) {
        return new zzagy<>(zzahb);
    }

    public static <T> zzagy<T> zzb(@Nullable T t11, @Nullable zzagb zzagb) {
        return new zzagy<>(t11, zzagb);
    }

    public final boolean zzc() {
        return this.zzc == null;
    }
}
