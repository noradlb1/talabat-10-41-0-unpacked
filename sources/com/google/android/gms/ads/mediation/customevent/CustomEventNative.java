package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;

@Deprecated
public interface CustomEventNative extends CustomEvent {
    void requestNativeAd(@RecentlyNonNull Context context, @RecentlyNonNull CustomEventNativeListener customEventNativeListener, @Nullable String str, @RecentlyNonNull NativeMediationAdRequest nativeMediationAdRequest, @Nullable Bundle bundle);
}
