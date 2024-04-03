package com.google.android.libraries.places.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.internal.zzcz;
import java.util.Map;

public abstract class zzam<TypeT, RequestT extends zzcz> {
    private final RequestT zza;

    public zzam(RequestT requestt) {
        this.zza = requestt;
    }

    @Nullable
    public final CancellationToken zza() {
        return this.zza.getCancellationToken();
    }

    public final RequestT zzb() {
        return this.zza;
    }

    public abstract String zzc();

    public abstract Map<String, String> zzd();
}
