package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzdqv extends zzbor implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzdrw {
    private final WeakReference<View> zza;
    private final Map<String, WeakReference<View>> zzb = new HashMap();
    private final Map<String, WeakReference<View>> zzc = new HashMap();
    private final Map<String, WeakReference<View>> zzd = new HashMap();
    @GuardedBy("this")
    private zzdpx zze;
    private zzayb zzf;

    public zzdqv(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        zzt.zzx();
        zzcjz.zza(view, this);
        zzt.zzx();
        zzcjz.zzb(view, this);
        this.zza = new WeakReference<>(view);
        for (Map.Entry next : hashMap.entrySet()) {
            String str = (String) next.getKey();
            View view2 = (View) next.getValue();
            if (view2 != null) {
                this.zzb.put(str, new WeakReference(view2));
                if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !"3011".equals(str)) {
                    view2.setOnTouchListener(this);
                    view2.setClickable(true);
                    view2.setOnClickListener(this);
                }
            }
        }
        this.zzd.putAll(this.zzb);
        for (Map.Entry next2 : hashMap2.entrySet()) {
            View view3 = (View) next2.getValue();
            if (view3 != null) {
                this.zzc.put((String) next2.getKey(), new WeakReference(view3));
                view3.setOnTouchListener(this);
                view3.setClickable(false);
            }
        }
        this.zzd.putAll(this.zzc);
        this.zzf = new zzayb(view.getContext(), view);
    }

    public final synchronized void onClick(View view) {
        zzdpx zzdpx = this.zze;
        if (zzdpx != null) {
            zzdpx.zzx(view, zzf(), zzl(), zzm(), true);
        }
    }

    public final synchronized void onGlobalLayout() {
        zzdpx zzdpx = this.zze;
        if (zzdpx != null) {
            zzdpx.zzv(zzf(), zzl(), zzm(), zzdpx.zzP(zzf()));
        }
    }

    public final synchronized void onScrollChanged() {
        zzdpx zzdpx = this.zze;
        if (zzdpx != null) {
            zzdpx.zzv(zzf(), zzl(), zzm(), zzdpx.zzP(zzf()));
        }
    }

    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        zzdpx zzdpx = this.zze;
        if (zzdpx != null) {
            zzdpx.zzD(view, motionEvent, zzf());
        }
        return false;
    }

    public final synchronized void zzb(IObjectWrapper iObjectWrapper) {
        if (this.zze != null) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (!(unwrap instanceof View)) {
                zzciz.zzj("Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
            }
            this.zze.zzF((View) unwrap);
        }
    }

    public final synchronized void zzc(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof zzdpx)) {
            zzciz.zzj("Not an instance of InternalNativeAd. This is most likely a transient error");
            return;
        }
        zzdpx zzdpx = this.zze;
        if (zzdpx != null) {
            zzdpx.zzL(this);
        }
        zzdpx zzdpx2 = (zzdpx) unwrap;
        if (zzdpx2.zzM()) {
            this.zze = zzdpx2;
            zzdpx2.zzK(this);
            this.zze.zzC(zzf());
            return;
        }
        zzciz.zzg("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
    }

    public final synchronized void zzd() {
        zzdpx zzdpx = this.zze;
        if (zzdpx != null) {
            zzdpx.zzL(this);
            this.zze = null;
        }
    }

    @Nullable
    public final View zzf() {
        return this.zza.get();
    }

    public final synchronized View zzg(String str) {
        WeakReference weakReference = this.zzd.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    @Nullable
    public final FrameLayout zzh() {
        return null;
    }

    public final zzayb zzi() {
        return this.zzf;
    }

    @Nullable
    public final synchronized IObjectWrapper zzj() {
        return null;
    }

    public final synchronized String zzk() {
        return "1007";
    }

    public final synchronized Map<String, WeakReference<View>> zzl() {
        return this.zzd;
    }

    public final synchronized Map<String, WeakReference<View>> zzm() {
        return this.zzb;
    }

    @Nullable
    public final synchronized Map<String, WeakReference<View>> zzn() {
        return this.zzc;
    }

    @Nullable
    public final synchronized JSONObject zzo() {
        return null;
    }

    @Nullable
    public final synchronized JSONObject zzp() {
        zzdpx zzdpx = this.zze;
        if (zzdpx == null) {
            return null;
        }
        return zzdpx.zzg(zzf(), zzl(), zzm());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzq(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.zzd     // Catch:{ all -> 0x0034 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0034 }
            r0.<init>(r3)     // Catch:{ all -> 0x0034 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0034 }
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0034 }
            if (r4 != 0) goto L_0x0032
            java.lang.String r4 = "3011"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0034 }
            if (r4 == 0) goto L_0x001c
            goto L_0x0032
        L_0x001c:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.zzb     // Catch:{ all -> 0x0034 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0034 }
            r0.<init>(r3)     // Catch:{ all -> 0x0034 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0034 }
            r2 = 1
            r3.setClickable(r2)     // Catch:{ all -> 0x0034 }
            r3.setOnClickListener(r1)     // Catch:{ all -> 0x0034 }
            r3.setOnTouchListener(r1)     // Catch:{ all -> 0x0034 }
            monitor-exit(r1)
            return
        L_0x0032:
            monitor-exit(r1)
            return
        L_0x0034:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdqv.zzq(java.lang.String, android.view.View, boolean):void");
    }
}
