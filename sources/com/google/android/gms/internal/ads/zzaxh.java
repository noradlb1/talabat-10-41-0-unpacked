package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;

@TargetApi(17)
public final class zzaxh extends Surface {
    private static boolean zza;
    private static boolean zzb;
    private final zzaxf zzc;
    private boolean zzd;

    public /* synthetic */ zzaxh(zzaxf zzaxf, SurfaceTexture surfaceTexture, boolean z11, zzaxg zzaxg) {
        super(surfaceTexture);
        this.zzc = zzaxf;
    }

    public static zzaxh zza(Context context, boolean z11) {
        if (zzaxb.zza >= 17) {
            boolean z12 = true;
            if (z11 && !zzb(context)) {
                z12 = false;
            }
            zzawm.zze(z12);
            return new zzaxf().zza(z11);
        }
        throw new UnsupportedOperationException("Unsupported prior to API level 17");
    }

    public static synchronized boolean zzb(Context context) {
        boolean z11;
        synchronized (zzaxh.class) {
            if (!zzb) {
                int i11 = zzaxb.zza;
                if (i11 >= 17) {
                    boolean z12 = false;
                    String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                    if (eglQueryString != null && eglQueryString.contains("EGL_EXT_protected_content")) {
                        if (i11 == 24) {
                            String str = zzaxb.zzd;
                            if ((str.startsWith("SM-G950") || str.startsWith("SM-G955")) && !context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
                            }
                        }
                        z12 = true;
                    }
                    zza = z12;
                }
                zzb = true;
            }
            z11 = zza;
        }
        return z11;
    }

    public final void release() {
        super.release();
        synchronized (this.zzc) {
            if (!this.zzd) {
                this.zzc.zzb();
                this.zzd = true;
            }
        }
    }
}
