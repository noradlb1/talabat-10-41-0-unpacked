package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import com.adjust.sdk.Constants;

@RequiresApi(17)
public final class zzuq extends Surface {
    private static int zzb;
    private static boolean zzc;
    public final boolean zza;
    private final zzuo zzd;
    private boolean zze;

    public /* synthetic */ zzuq(zzuo zzuo, SurfaceTexture surfaceTexture, boolean z11, zzup zzup) {
        super(surfaceTexture);
        this.zzd = zzuo;
        this.zza = z11;
    }

    public static zzuq zza(Context context, boolean z11) {
        int i11 = 0;
        boolean z12 = true;
        if (z11 && !zzb(context)) {
            z12 = false;
        }
        zzdy.zzf(z12);
        zzuo zzuo = new zzuo();
        if (z11) {
            i11 = zzb;
        }
        return zzuo.zza(i11);
    }

    public static synchronized boolean zzb(Context context) {
        int i11;
        int i12;
        synchronized (zzuq.class) {
            if (!zzc) {
                int i13 = zzfn.zza;
                if (i13 >= 24) {
                    if (i13 < 26) {
                        if (!Constants.REFERRER_API_SAMSUNG.equals(zzfn.zzc)) {
                            if ("XT1650".equals(zzfn.zzd)) {
                            }
                        }
                    }
                    if (i13 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
                        String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                        if (eglQueryString != null && eglQueryString.contains("EGL_EXT_protected_content")) {
                            i12 = 2;
                            if (i13 >= 17) {
                                String eglQueryString2 = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                                if (eglQueryString2 != null && eglQueryString2.contains("EGL_KHR_surfaceless_context")) {
                                    i12 = 1;
                                }
                            }
                            zzb = i12;
                            zzc = true;
                        }
                    }
                }
                i12 = 0;
                zzb = i12;
                zzc = true;
            }
            i11 = zzb;
        }
        if (i11 != 0) {
            return true;
        }
        return false;
    }

    public final void release() {
        super.release();
        synchronized (this.zzd) {
            if (!this.zze) {
                this.zzd.zzb();
                this.zze = true;
            }
        }
    }
}
