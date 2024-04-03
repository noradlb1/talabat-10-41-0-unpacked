package io.flutter.embedding.engine.plugins.service;

import android.app.Service;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;

public interface ServiceControlSurface {
    void attachToService(@NonNull Service service2, @Nullable Lifecycle lifecycle, boolean z11);

    void detachFromService();

    void onMoveToBackground();

    void onMoveToForeground();
}
