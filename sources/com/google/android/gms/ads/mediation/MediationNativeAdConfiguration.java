package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.internal.ads.zzbnw;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class MediationNativeAdConfiguration extends MediationAdConfiguration {
    @Nullable
    private final zzbnw zza;

    public MediationNativeAdConfiguration(Context context, String str, Bundle bundle, Bundle bundle2, boolean z11, @Nullable Location location, int i11, int i12, @Nullable String str2, String str3, @Nullable zzbnw zzbnw) {
        super(context, str, bundle, bundle2, z11, location, i11, i12, str2, str3);
        this.zza = zzbnw;
    }

    @RecentlyNonNull
    public NativeAdOptions getNativeAdOptions() {
        return zzbnw.zza(this.zza);
    }
}
