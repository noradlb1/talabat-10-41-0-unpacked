package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.ExoPlayer;

public final class zzbnj {
    public static final zzbml<Boolean> zza = zzbml.zzd("gads:always_collect_trustless_token_at_native_side", true);
    public static final zzbml<Boolean> zzb = zzbml.zzd("gms:expose_token_for_gma:enabled", true);
    public static final zzbml<Long> zzc = zzbml.zzb("gads:timeout_for_trustless_token:millis", ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    public static final zzbml<Long> zzd = zzbml.zzb("gads:cached_token:ttl_millis", 10800000);
}
