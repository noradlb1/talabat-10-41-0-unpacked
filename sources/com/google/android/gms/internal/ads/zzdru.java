package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.internal.util.zzcb;
import com.google.android.gms.ads.internal.zzb;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class zzdru {
    private final zzdwj zza;
    private final zzduy zzb;
    private ViewTreeObserver.OnScrollChangedListener zzc = null;

    public zzdru(zzdwj zzdwj, zzduy zzduy) {
        this.zza = zzdwj;
        this.zzb = zzduy;
    }

    private static final int zzf(Context context, String str, int i11) {
        try {
            i11 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        zzbgo.zzb();
        return zzcis.zzs(context, i11);
    }

    public final View zza(@NonNull View view, @NonNull WindowManager windowManager) throws zzcpa {
        zzcop zza2 = this.zza.zza(zzbfi.zzc(), (zzfdn) null, (zzfdq) null);
        View view2 = (View) zza2;
        view2.setVisibility(4);
        view2.setContentDescription("policy_validator");
        zza2.zzaf("/sendMessageToSdk", new zzdrp(this));
        zza2.zzaf("/hideValidatorOverlay", new zzdrr(this, windowManager, view));
        zza2.zzaf("/open", new zzbse((zzb) null, (zzcak) null, (zzehh) null, (zzdyz) null, (zzfio) null));
        this.zzb.zzj(new WeakReference(zza2), "/loadNativeAdPolicyViolations", new zzdrq(this, view, windowManager));
        this.zzb.zzj(new WeakReference(zza2), "/showValidatorOverlay", zzdrs.zza);
        return (View) zza2;
    }

    public final /* synthetic */ void zzb(zzcop zzcop, Map map) {
        this.zzb.zzg("sendMessageToNativeJs", map);
    }

    public final /* synthetic */ void zzc(WindowManager windowManager, View view, zzcop zzcop, Map map) {
        zzciz.zze("Hide native ad policy validator overlay.");
        zzcop.zzH().setVisibility(8);
        if (zzcop.zzH().getWindowToken() != null) {
            windowManager.removeView(zzcop.zzH());
        }
        zzcop.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.zzc != null && viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this.zzc);
        }
    }

    public final /* synthetic */ void zzd(Map map, boolean z11) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "validatorHtmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzb.zzg("sendMessageToNativeJs", hashMap);
    }

    public final /* synthetic */ void zze(View view, WindowManager windowManager, zzcop zzcop, Map map) {
        int i11;
        zzcop.zzP().zzz(new zzdrt(this, map));
        if (map != null) {
            Context context = view.getContext();
            int zzf = zzf(context, (String) map.get("validator_width"), ((Integer) zzbgq.zzc().zzb(zzblj.zzfR)).intValue());
            int zzf2 = zzf(context, (String) map.get("validator_height"), ((Integer) zzbgq.zzc().zzb(zzblj.zzfS)).intValue());
            int zzf3 = zzf(context, (String) map.get("validator_x"), 0);
            int zzf4 = zzf(context, (String) map.get("validator_y"), 0);
            zzcop.zzai(zzcqe.zzb(zzf, zzf2));
            try {
                zzcop.zzI().getSettings().setUseWideViewPort(((Boolean) zzbgq.zzc().zzb(zzblj.zzfT)).booleanValue());
                zzcop.zzI().getSettings().setLoadWithOverviewMode(((Boolean) zzbgq.zzc().zzb(zzblj.zzfU)).booleanValue());
            } catch (NullPointerException unused) {
            }
            WindowManager.LayoutParams zzb2 = zzcb.zzb();
            zzb2.x = zzf3;
            zzb2.y = zzf4;
            windowManager.updateViewLayout(zzcop.zzH(), zzb2);
            String str = (String) map.get("orientation");
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                if ("1".equals(str) || ExifInterface.GPS_MEASUREMENT_2D.equals(str)) {
                    i11 = rect.bottom;
                } else {
                    i11 = rect.top;
                }
                this.zzc = new zzdro(view, zzcop, str, zzb2, i11 - zzf4, windowManager);
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnScrollChangedListener(this.zzc);
                }
            }
            String str2 = (String) map.get("overlay_url");
            if (!TextUtils.isEmpty(str2)) {
                zzcop.loadUrl(str2);
            }
        }
    }
}
