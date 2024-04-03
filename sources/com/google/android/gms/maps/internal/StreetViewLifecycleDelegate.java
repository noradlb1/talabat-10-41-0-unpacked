package com.google.android.gms.maps.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;

public interface StreetViewLifecycleDelegate extends LifecycleDelegate {
    void getStreetViewPanoramaAsync(@NonNull OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback);
}
