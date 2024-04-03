package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class zzpr {
    private static final AtomicLong zzd = new AtomicLong();
    public final zzdm zza;
    public final Uri zzb;
    public final Map<String, List<String>> zzc;

    public zzpr(long j11, zzdm zzdm, Uri uri, Map<String, List<String>> map, long j12, long j13, long j14) {
        this.zza = zzdm;
        this.zzb = uri;
        this.zzc = map;
    }

    public static long zza() {
        return zzd.getAndIncrement();
    }
}
