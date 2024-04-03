package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

final class zzaxf extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {
    private final int[] zza = new int[1];
    private Handler zzb;
    private SurfaceTexture zzc;
    private Error zzd;
    private RuntimeException zze;
    private zzaxh zzf;

    public zzaxf() {
        super("dummySurface");
    }

    public final boolean handleMessage(Message message) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        Message message2 = message;
        int i11 = message2.what;
        if (i11 == 1) {
            try {
                if (message2.arg1 != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
                if (eglGetDisplay != null) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                zzawm.zzf(z12, "eglGetDisplay failed");
                int[] iArr = new int[2];
                zzawm.zzf(EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1), "eglInitialize failed");
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                int[] iArr2 = new int[1];
                EGLConfig[] eGLConfigArr2 = eGLConfigArr;
                if (!EGL14.eglChooseConfig(eglGetDisplay, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0) || iArr2[0] <= 0 || eGLConfigArr2[0] == null) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                zzawm.zzf(z13, "eglChooseConfig failed");
                EGLConfig eGLConfig = eGLConfigArr2[0];
                EGLContext eglCreateContext = EGL14.eglCreateContext(eglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, z11 ? new int[]{12440, 2, 12992, 1, 12344} : new int[]{12440, 2, 12344}, 0);
                if (eglCreateContext != null) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                zzawm.zzf(z14, "eglCreateContext failed");
                EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, z11 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
                if (eglCreatePbufferSurface != null) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                zzawm.zzf(z15, "eglCreatePbufferSurface failed");
                zzawm.zzf(EGL14.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext), "eglMakeCurrent failed");
                GLES20.glGenTextures(1, this.zza, 0);
                SurfaceTexture surfaceTexture = new SurfaceTexture(this.zza[0]);
                this.zzc = surfaceTexture;
                surfaceTexture.setOnFrameAvailableListener(this);
                this.zzf = new zzaxh(this, this.zzc, z11, (zzaxg) null);
                synchronized (this) {
                    notify();
                }
            } catch (RuntimeException e11) {
                Log.e("DummySurface", "Failed to initialize dummy surface", e11);
                this.zze = e11;
                synchronized (this) {
                    notify();
                }
            } catch (Error e12) {
                try {
                    Log.e("DummySurface", "Failed to initialize dummy surface", e12);
                    this.zzd = e12;
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
        } else if (i11 == 2) {
            this.zzc.updateTexImage();
            return true;
        } else if (i11 != 3) {
            return true;
        } else {
            try {
                this.zzc.release();
                this.zzf = null;
                this.zzc = null;
                GLES20.glDeleteTextures(1, this.zza, 0);
            } catch (Throwable th3) {
                try {
                    Log.e("DummySurface", "Failed to release dummy surface", th3);
                } catch (Throwable th4) {
                    quit();
                    throw th4;
                }
            }
            quit();
            return true;
        }
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzb.sendEmptyMessage(2);
    }

    public final zzaxh zza(boolean z11) {
        boolean z12;
        start();
        this.zzb = new Handler(getLooper(), this);
        synchronized (this) {
            z12 = false;
            this.zzb.obtainMessage(1, z11 ? 1 : 0, 0).sendToTarget();
            while (this.zzf == null && this.zze == null && this.zzd == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z12 = true;
                }
            }
        }
        if (z12) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.zze;
        if (runtimeException == null) {
            Error error = this.zzd;
            if (error == null) {
                return this.zzf;
            }
            throw error;
        }
        throw runtimeException;
    }

    public final void zzb() {
        this.zzb.sendEmptyMessage(3);
    }
}
