package io.flutter.embedding.engine.renderer;

import android.graphics.SurfaceTexture;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@Keep
public class SurfaceTextureWrapper {
    private boolean attached;
    private Runnable onFrameConsumed;
    private boolean released;
    private SurfaceTexture surfaceTexture;

    public SurfaceTextureWrapper(@NonNull SurfaceTexture surfaceTexture2) {
        this(surfaceTexture2, (Runnable) null);
    }

    public void attachToGLContext(int i11) {
        synchronized (this) {
            if (!this.released) {
                if (this.attached) {
                    this.surfaceTexture.detachFromGLContext();
                }
                this.surfaceTexture.attachToGLContext(i11);
                this.attached = true;
            }
        }
    }

    public void detachFromGLContext() {
        synchronized (this) {
            if (this.attached && !this.released) {
                this.surfaceTexture.detachFromGLContext();
                this.attached = false;
            }
        }
    }

    public void getTransformMatrix(@NonNull float[] fArr) {
        this.surfaceTexture.getTransformMatrix(fArr);
    }

    public void release() {
        synchronized (this) {
            if (!this.released) {
                this.surfaceTexture.release();
                this.released = true;
                this.attached = false;
            }
        }
    }

    @NonNull
    public SurfaceTexture surfaceTexture() {
        return this.surfaceTexture;
    }

    public void updateTexImage() {
        synchronized (this) {
            if (!this.released) {
                this.surfaceTexture.updateTexImage();
                Runnable runnable = this.onFrameConsumed;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    public SurfaceTextureWrapper(@NonNull SurfaceTexture surfaceTexture2, @Nullable Runnable runnable) {
        this.surfaceTexture = surfaceTexture2;
        this.released = false;
        this.onFrameConsumed = runnable;
    }
}
