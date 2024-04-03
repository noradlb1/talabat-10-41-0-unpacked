package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;

public final /* synthetic */ class zzdro implements ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ View zza;
    public final /* synthetic */ zzcop zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ WindowManager.LayoutParams zzd;
    public final /* synthetic */ int zze;
    public final /* synthetic */ WindowManager zzf;

    public /* synthetic */ zzdro(View view, zzcop zzcop, String str, WindowManager.LayoutParams layoutParams, int i11, WindowManager windowManager) {
        this.zza = view;
        this.zzb = zzcop;
        this.zzc = str;
        this.zzd = layoutParams;
        this.zze = i11;
        this.zzf = windowManager;
    }

    public final void onScrollChanged() {
        View view = this.zza;
        zzcop zzcop = this.zzb;
        String str = this.zzc;
        WindowManager.LayoutParams layoutParams = this.zzd;
        int i11 = this.zze;
        WindowManager windowManager = this.zzf;
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect) && zzcop.zzH().getWindowToken() != null) {
            if ("1".equals(str) || ExifInterface.GPS_MEASUREMENT_2D.equals(str)) {
                layoutParams.y = rect.bottom - i11;
            } else {
                layoutParams.y = rect.top - i11;
            }
            windowManager.updateViewLayout(zzcop.zzH(), layoutParams);
        }
    }
}
