package io.flutter.embedding.engine;

import android.view.Surface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;

@Keep
public class FlutterOverlaySurface {

    /* renamed from: id  reason: collision with root package name */
    private final int f14172id;
    @NonNull
    private final Surface surface;

    public FlutterOverlaySurface(int i11, @NonNull Surface surface2) {
        this.f14172id = i11;
        this.surface = surface2;
    }

    public int getId() {
        return this.f14172id;
    }

    public Surface getSurface() {
        return this.surface;
    }
}
