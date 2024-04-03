package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(17)
public final class zzeg implements SurfaceTexture.OnFrameAvailableListener, Runnable {
    private static final int[] zza = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};
    private final Handler zzb;
    private final int[] zzc = new int[1];
    @Nullable
    private EGLDisplay zzd;
    @Nullable
    private EGLContext zze;
    @Nullable
    private EGLSurface zzf;
    @Nullable
    private SurfaceTexture zzg;

    public zzeg(Handler handler, @Nullable zzef zzef) {
        this.zzb = handler;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzb.post(this);
    }

    public final void run() {
        SurfaceTexture surfaceTexture = this.zzg;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }

    public final SurfaceTexture zza() {
        SurfaceTexture surfaceTexture = this.zzg;
        surfaceTexture.getClass();
        return surfaceTexture;
    }

    public final void zzb(int i11) {
        EGLConfig eGLConfig;
        int[] iArr;
        EGLSurface eGLSurface;
        String str;
        String str2;
        int[] iArr2;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        if (eglGetDisplay != null) {
            int[] iArr3 = new int[2];
            if (EGL14.eglInitialize(eglGetDisplay, iArr3, 0, iArr3, 1)) {
                this.zzd = eglGetDisplay;
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                int[] iArr4 = new int[1];
                boolean eglChooseConfig = EGL14.eglChooseConfig(eglGetDisplay, zza, 0, eGLConfigArr, 0, 1, iArr4, 0);
                if (!eglChooseConfig || iArr4[0] <= 0 || (eGLConfig = eGLConfigArr[0]) == null) {
                    throw new zzee(zzfn.zzD("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(eglChooseConfig), Integer.valueOf(iArr4[0]), eGLConfigArr[0]), (zzed) null);
                }
                EGLDisplay eGLDisplay = this.zzd;
                if (i11 == 0) {
                    iArr = new int[]{12440, 2, 12344};
                } else {
                    iArr = new int[]{12440, 2, 12992, 1, 12344};
                }
                EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr, 0);
                if (eglCreateContext != null) {
                    this.zze = eglCreateContext;
                    EGLDisplay eGLDisplay2 = this.zzd;
                    if (i11 == 1) {
                        eGLSurface = EGL14.EGL_NO_SURFACE;
                    } else {
                        if (i11 == 2) {
                            iArr2 = new int[]{12375, 1, 12374, 1, 12992, 1, 12344};
                        } else {
                            iArr2 = new int[]{12375, 1, 12374, 1, 12344};
                        }
                        eGLSurface = EGL14.eglCreatePbufferSurface(eGLDisplay2, eGLConfig, iArr2, 0);
                        if (eGLSurface == null) {
                            throw new zzee("eglCreatePbufferSurface failed", (zzed) null);
                        }
                    }
                    if (EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, eglCreateContext)) {
                        this.zzf = eGLSurface;
                        GLES20.glGenTextures(1, this.zzc, 0);
                        int i12 = 0;
                        while (true) {
                            int glGetError = GLES20.glGetError();
                            if (glGetError == 0) {
                                break;
                            }
                            String valueOf = String.valueOf(GLU.gluErrorString(glGetError));
                            if (valueOf.length() != 0) {
                                str2 = "glError ".concat(valueOf);
                            } else {
                                str2 = new String("glError ");
                            }
                            Log.e("GlUtil", str2);
                            i12 = glGetError;
                        }
                        if (i12 != 0) {
                            String valueOf2 = String.valueOf(GLU.gluErrorString(i12));
                            if (valueOf2.length() != 0) {
                                str = "glError ".concat(valueOf2);
                            } else {
                                str = new String("glError ");
                            }
                            Log.e("GlUtil", str);
                        }
                        SurfaceTexture surfaceTexture = new SurfaceTexture(this.zzc[0]);
                        this.zzg = surfaceTexture;
                        surfaceTexture.setOnFrameAvailableListener(this);
                        return;
                    }
                    throw new zzee("eglMakeCurrent failed", (zzed) null);
                }
                throw new zzee("eglCreateContext failed", (zzed) null);
            }
            throw new zzee("eglInitialize failed", (zzed) null);
        }
        throw new zzee("eglGetDisplay failed", (zzed) null);
    }

    /* JADX INFO: finally extract failed */
    public final void zzc() {
        this.zzb.removeCallbacks(this);
        try {
            SurfaceTexture surfaceTexture = this.zzg;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, this.zzc, 0);
            }
            EGLDisplay eGLDisplay = this.zzd;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = this.zzd;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = this.zzf;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.zzd, this.zzf);
            }
            EGLContext eGLContext = this.zze;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(this.zzd, eGLContext);
            }
            if (zzfn.zza >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay3 = this.zzd;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.zzd);
            }
            this.zzd = null;
            this.zze = null;
            this.zzf = null;
            this.zzg = null;
        } catch (Throwable th2) {
            EGLDisplay eGLDisplay4 = this.zzd;
            if (eGLDisplay4 != null && !eGLDisplay4.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay5 = this.zzd;
                EGLSurface eGLSurface3 = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay5, eGLSurface3, eGLSurface3, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface4 = this.zzf;
            if (eGLSurface4 != null && !eGLSurface4.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.zzd, this.zzf);
            }
            EGLContext eGLContext2 = this.zze;
            if (eGLContext2 != null) {
                EGL14.eglDestroyContext(this.zzd, eGLContext2);
            }
            if (zzfn.zza >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay6 = this.zzd;
            if (eGLDisplay6 != null && !eGLDisplay6.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.zzd);
            }
            this.zzd = null;
            this.zze = null;
            this.zzf = null;
            this.zzg = null;
            throw th2;
        }
    }
}
