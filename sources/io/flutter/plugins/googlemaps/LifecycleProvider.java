package io.flutter.plugins.googlemaps;

import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;

interface LifecycleProvider {
    @Nullable
    Lifecycle getLifecycle();
}
