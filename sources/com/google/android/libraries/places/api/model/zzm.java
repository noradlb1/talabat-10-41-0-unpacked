package com.google.android.libraries.places.api.model;

import androidx.annotation.Nullable;
import com.google.android.libraries.places.api.model.Period;

final class zzm extends Period.Builder {
    private TimeOfWeek zza;
    private TimeOfWeek zzb;

    public final Period build() {
        return new zzan(this.zza, this.zzb);
    }

    @Nullable
    public final TimeOfWeek getClose() {
        return this.zzb;
    }

    @Nullable
    public final TimeOfWeek getOpen() {
        return this.zza;
    }

    public final Period.Builder setClose(@Nullable TimeOfWeek timeOfWeek) {
        this.zzb = timeOfWeek;
        return this;
    }

    public final Period.Builder setOpen(@Nullable TimeOfWeek timeOfWeek) {
        this.zza = timeOfWeek;
        return this;
    }
}
