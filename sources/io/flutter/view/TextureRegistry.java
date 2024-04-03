package io.flutter.view;

import android.graphics.SurfaceTexture;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface TextureRegistry {

    public interface OnFrameConsumedListener {
        void onFrameConsumed();
    }

    public interface OnTrimMemoryListener {
        void onTrimMemory(int i11);
    }

    public interface SurfaceTextureEntry {
        long id();

        void release();

        void setOnFrameConsumedListener(@Nullable OnFrameConsumedListener onFrameConsumedListener);

        void setOnTrimMemoryListener(@Nullable OnTrimMemoryListener onTrimMemoryListener);

        @NonNull
        SurfaceTexture surfaceTexture();
    }

    @NonNull
    SurfaceTextureEntry createSurfaceTexture();

    void onTrimMemory(int i11);

    @NonNull
    SurfaceTextureEntry registerSurfaceTexture(@NonNull SurfaceTexture surfaceTexture);
}
