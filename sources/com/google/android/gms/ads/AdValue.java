package com.google.android.gms.ads;

import androidx.annotation.RecentlyNonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class AdValue {
    private final int zza;
    private final String zzb;
    private final long zzc;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PrecisionType {
        public static final int ESTIMATED = 1;
        public static final int PRECISE = 3;
        public static final int PUBLISHER_PROVIDED = 2;
        public static final int UNKNOWN = 0;
    }

    private AdValue(int i11, String str, long j11) {
        this.zza = i11;
        this.zzb = str;
        this.zzc = j11;
    }

    @RecentlyNonNull
    public static AdValue zza(int i11, @RecentlyNonNull String str, long j11) {
        return new AdValue(i11, str, j11);
    }

    @RecentlyNonNull
    public String getCurrencyCode() {
        return this.zzb;
    }

    public int getPrecisionType() {
        return this.zza;
    }

    public long getValueMicros() {
        return this.zzc;
    }
}
