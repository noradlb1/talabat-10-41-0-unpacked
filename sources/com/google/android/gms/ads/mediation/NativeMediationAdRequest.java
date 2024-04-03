package com.google.android.gms.ads.mediation;

import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.formats.NativeAdOptions;
import java.util.Map;

@Deprecated
public interface NativeMediationAdRequest extends MediationAdRequest {
    float getAdVolume();

    @RecentlyNonNull
    @Deprecated
    NativeAdOptions getNativeAdOptions();

    @NonNull
    com.google.android.gms.ads.nativead.NativeAdOptions getNativeAdRequestOptions();

    boolean isAdMuted();

    boolean isUnifiedNativeAdRequested();

    @RecentlyNonNull
    Map<String, Boolean> zza();

    boolean zzb();
}
