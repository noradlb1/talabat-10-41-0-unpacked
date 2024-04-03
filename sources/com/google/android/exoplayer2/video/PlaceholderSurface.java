package com.google.android.exoplayer2.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.EGLSurfaceTexture;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.util.Log;

@RequiresApi(17)
public final class PlaceholderSurface extends Surface {
    private static final String TAG = "PlaceholderSurface";
    private static int secureMode;
    private static boolean secureModeInitialized;
    public final boolean secure;
    private final PlaceholderSurfaceThread thread;
    private boolean threadReleased;

    public static class PlaceholderSurfaceThread extends HandlerThread implements Handler.Callback {
        private static final int MSG_INIT = 1;
        private static final int MSG_RELEASE = 2;
        private EGLSurfaceTexture eglSurfaceTexture;
        private Handler handler;
        @Nullable
        private Error initError;
        @Nullable
        private RuntimeException initException;
        @Nullable
        private PlaceholderSurface surface;

        public PlaceholderSurfaceThread() {
            super("ExoPlayer:PlaceholderSurface");
        }

        private void initInternal(int i11) throws GlUtil.GlException {
            boolean z11;
            Assertions.checkNotNull(this.eglSurfaceTexture);
            this.eglSurfaceTexture.init(i11);
            SurfaceTexture surfaceTexture = this.eglSurfaceTexture.getSurfaceTexture();
            if (i11 != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.surface = new PlaceholderSurface(this, surfaceTexture, z11);
        }

        private void releaseInternal() {
            Assertions.checkNotNull(this.eglSurfaceTexture);
            this.eglSurfaceTexture.release();
        }

        public boolean handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == 1) {
                try {
                    initInternal(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e11) {
                    Log.e(PlaceholderSurface.TAG, "Failed to initialize placeholder surface", e11);
                    this.initException = e11;
                    synchronized (this) {
                        notify();
                    }
                } catch (GlUtil.GlException e12) {
                    Log.e(PlaceholderSurface.TAG, "Failed to initialize placeholder surface", e12);
                    this.initException = new IllegalStateException(e12);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e13) {
                    try {
                        Log.e(PlaceholderSurface.TAG, "Failed to initialize placeholder surface", e13);
                        this.initError = e13;
                        synchronized (this) {
                            notify();
                        }
                    } catch (Throwable th2) {
                        synchronized (this) {
                            notify();
                            throw th2;
                        }
                    }
                }
                return true;
            } else if (i11 != 2) {
                return true;
            } else {
                try {
                    releaseInternal();
                } catch (Throwable th3) {
                    quit();
                    throw th3;
                }
                quit();
                return true;
            }
        }

        public PlaceholderSurface init(int i11) {
            boolean z11;
            start();
            this.handler = new Handler(getLooper(), this);
            this.eglSurfaceTexture = new EGLSurfaceTexture(this.handler);
            synchronized (this) {
                z11 = false;
                this.handler.obtainMessage(1, i11, 0).sendToTarget();
                while (this.surface == null && this.initException == null && this.initError == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z11 = true;
                    }
                }
            }
            if (z11) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.initException;
            if (runtimeException == null) {
                Error error = this.initError;
                if (error == null) {
                    return (PlaceholderSurface) Assertions.checkNotNull(this.surface);
                }
                throw error;
            }
            throw runtimeException;
        }

        public void release() {
            Assertions.checkNotNull(this.handler);
            this.handler.sendEmptyMessage(2);
        }
    }

    private static int getSecureMode(Context context) {
        if (!GlUtil.isProtectedContentExtensionSupported(context)) {
            return 0;
        }
        if (GlUtil.isSurfacelessContextExtensionSupported()) {
            return 1;
        }
        return 2;
    }

    public static synchronized boolean isSecureSupported(Context context) {
        boolean z11;
        synchronized (PlaceholderSurface.class) {
            z11 = true;
            if (!secureModeInitialized) {
                secureMode = getSecureMode(context);
                secureModeInitialized = true;
            }
            if (secureMode == 0) {
                z11 = false;
            }
        }
        return z11;
    }

    public static PlaceholderSurface newInstanceV17(Context context, boolean z11) {
        boolean z12;
        int i11 = 0;
        if (!z11 || isSecureSupported(context)) {
            z12 = true;
        } else {
            z12 = false;
        }
        Assertions.checkState(z12);
        PlaceholderSurfaceThread placeholderSurfaceThread = new PlaceholderSurfaceThread();
        if (z11) {
            i11 = secureMode;
        }
        return placeholderSurfaceThread.init(i11);
    }

    public void release() {
        super.release();
        synchronized (this.thread) {
            if (!this.threadReleased) {
                this.thread.release();
                this.threadReleased = true;
            }
        }
    }

    private PlaceholderSurface(PlaceholderSurfaceThread placeholderSurfaceThread, SurfaceTexture surfaceTexture, boolean z11) {
        super(surfaceTexture);
        this.thread = placeholderSurfaceThread;
        this.secure = z11;
    }
}
