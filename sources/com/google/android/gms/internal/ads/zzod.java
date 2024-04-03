package com.google.android.gms.internal.ads;

import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.Nullable;

public final class zzod {
    public final zzoh zza;
    public final MediaFormat zzb;
    public final zzab zzc;
    @Nullable
    public final Surface zzd;
    @Nullable
    public final MediaCrypto zze = null;

    private zzod(zzoh zzoh, MediaFormat mediaFormat, zzab zzab, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i11, boolean z11) {
        this.zza = zzoh;
        this.zzb = mediaFormat;
        this.zzc = zzab;
        this.zzd = surface;
    }

    public static zzod zza(zzoh zzoh, MediaFormat mediaFormat, zzab zzab, @Nullable MediaCrypto mediaCrypto) {
        return new zzod(zzoh, mediaFormat, zzab, (Surface) null, (MediaCrypto) null, 0, false);
    }

    public static zzod zzb(zzoh zzoh, MediaFormat mediaFormat, zzab zzab, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto) {
        return new zzod(zzoh, mediaFormat, zzab, surface, (MediaCrypto) null, 0, false);
    }
}
