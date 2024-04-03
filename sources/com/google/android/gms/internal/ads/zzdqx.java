package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

@Instrumented
public final class zzdqx extends zzbol implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzdrw {
    public static final zzfss<String> zza = zzfss.zzr("2011", "1009", "3010");
    private final String zzb;
    @GuardedBy("this")
    private Map<String, WeakReference<View>> zzc = new HashMap();
    private FrameLayout zzd;
    private FrameLayout zze;
    private final zzfxb zzf;
    private View zzg;
    private final int zzh;
    @GuardedBy("this")
    private zzdpx zzi;
    private zzayb zzj;
    private IObjectWrapper zzk = null;
    private zzbof zzl;
    private boolean zzm;
    private boolean zzn = false;

    public zzdqx(FrameLayout frameLayout, FrameLayout frameLayout2, int i11) {
        String str;
        this.zzd = frameLayout;
        this.zze = frameLayout2;
        this.zzh = 214106000;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = "1007";
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = "2009";
        } else {
            "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(canonicalName);
            str = "3012";
        }
        this.zzb = str;
        zzt.zzx();
        zzcjz.zza(frameLayout, this);
        zzt.zzx();
        zzcjz.zzb(frameLayout, this);
        this.zzf = zzcjm.zze;
        this.zzj = new zzayb(this.zzd.getContext(), this.zzd);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    private final synchronized void zzs(String str) {
        DisplayMetrics displayMetrics;
        FrameLayout frameLayout = new FrameLayout(this.zze.getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Context context = this.zze.getContext();
        frameLayout.setClickable(false);
        frameLayout.setFocusable(false);
        if (!TextUtils.isEmpty(str)) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            Resources resources = context.getResources();
            if (!(resources == null || (displayMetrics = resources.getDisplayMetrics()) == null)) {
                try {
                    byte[] decode = Base64.decode(str, 0);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapFactoryInstrumentation.decodeByteArray(decode, 0, decode.length));
                    bitmapDrawable.setTargetDensity(displayMetrics.densityDpi);
                    Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                    bitmapDrawable.setTileModeXY(tileMode, tileMode);
                    frameLayout.setBackground(bitmapDrawable);
                } catch (IllegalArgumentException e11) {
                    zzciz.zzk("Encountered invalid base64 watermark.", e11);
                }
            }
        }
        this.zze.addView(frameLayout);
    }

    private final synchronized void zzt() {
        this.zzf.execute(new zzdqw(this));
    }

    public final synchronized void onClick(View view) {
        zzdpx zzdpx = this.zzi;
        if (zzdpx != null) {
            zzdpx.zzk();
            this.zzi.zzx(view, this.zzd, zzl(), zzm(), false);
        }
    }

    public final synchronized void onGlobalLayout() {
        zzdpx zzdpx = this.zzi;
        if (zzdpx != null) {
            zzdpx.zzv(this.zzd, zzl(), zzm(), zzdpx.zzP(this.zzd));
        }
    }

    public final synchronized void onScrollChanged() {
        zzdpx zzdpx = this.zzi;
        if (zzdpx != null) {
            zzdpx.zzv(this.zzd, zzl(), zzm(), zzdpx.zzP(this.zzd));
        }
    }

    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        zzdpx zzdpx = this.zzi;
        if (zzdpx != null) {
            zzdpx.zzD(view, motionEvent, this.zzd);
        }
        return false;
    }

    public final synchronized IObjectWrapper zzb(String str) {
        return ObjectWrapper.wrap(zzg(str));
    }

    public final synchronized void zzbE(String str, IObjectWrapper iObjectWrapper) {
        zzq(str, (View) ObjectWrapper.unwrap(iObjectWrapper), true);
    }

    public final synchronized void zzbF(IObjectWrapper iObjectWrapper) {
        this.zzi.zzF((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final synchronized void zzbG(zzbof zzbof) {
        if (!this.zzn) {
            this.zzm = true;
            this.zzl = zzbof;
            zzdpx zzdpx = this.zzi;
            if (zzdpx != null) {
                zzdpx.zza().zzb(zzbof);
            }
        }
    }

    public final synchronized void zzbH(IObjectWrapper iObjectWrapper) {
        if (!this.zzn) {
            this.zzk = iObjectWrapper;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzbI(com.google.android.gms.dynamic.IObjectWrapper r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzn     // Catch:{ all -> 0x006f }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            java.lang.Object r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)     // Catch:{ all -> 0x006f }
            boolean r0 = r2 instanceof com.google.android.gms.internal.ads.zzdpx     // Catch:{ all -> 0x006f }
            if (r0 != 0) goto L_0x0016
            java.lang.String r2 = "Not an instance of native engine. This is most likely a transient error"
            com.google.android.gms.internal.ads.zzciz.zzj(r2)     // Catch:{ all -> 0x006f }
            monitor-exit(r1)
            return
        L_0x0016:
            com.google.android.gms.internal.ads.zzdpx r0 = r1.zzi     // Catch:{ all -> 0x006f }
            if (r0 == 0) goto L_0x001d
            r0.zzL(r1)     // Catch:{ all -> 0x006f }
        L_0x001d:
            r1.zzt()     // Catch:{ all -> 0x006f }
            com.google.android.gms.internal.ads.zzdpx r2 = (com.google.android.gms.internal.ads.zzdpx) r2     // Catch:{ all -> 0x006f }
            r1.zzi = r2     // Catch:{ all -> 0x006f }
            r2.zzK(r1)     // Catch:{ all -> 0x006f }
            com.google.android.gms.internal.ads.zzdpx r2 = r1.zzi     // Catch:{ all -> 0x006f }
            android.widget.FrameLayout r0 = r1.zzd     // Catch:{ all -> 0x006f }
            r2.zzC(r0)     // Catch:{ all -> 0x006f }
            com.google.android.gms.internal.ads.zzdpx r2 = r1.zzi     // Catch:{ all -> 0x006f }
            android.widget.FrameLayout r0 = r1.zze     // Catch:{ all -> 0x006f }
            r2.zzi(r0)     // Catch:{ all -> 0x006f }
            boolean r2 = r1.zzm     // Catch:{ all -> 0x006f }
            if (r2 == 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzdpx r2 = r1.zzi     // Catch:{ all -> 0x006f }
            com.google.android.gms.internal.ads.zzdpz r2 = r2.zza()     // Catch:{ all -> 0x006f }
            com.google.android.gms.internal.ads.zzbof r0 = r1.zzl     // Catch:{ all -> 0x006f }
            r2.zzb(r0)     // Catch:{ all -> 0x006f }
        L_0x0044:
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzblj.zzcy     // Catch:{ all -> 0x006f }
            com.google.android.gms.internal.ads.zzblh r0 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ all -> 0x006f }
            java.lang.Object r2 = r0.zzb(r2)     // Catch:{ all -> 0x006f }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x006f }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x006f }
            if (r2 == 0) goto L_0x006d
            com.google.android.gms.internal.ads.zzdpx r2 = r1.zzi     // Catch:{ all -> 0x006f }
            java.lang.String r2 = r2.zzd()     // Catch:{ all -> 0x006f }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x006f }
            if (r2 != 0) goto L_0x006d
            com.google.android.gms.internal.ads.zzdpx r2 = r1.zzi     // Catch:{ all -> 0x006f }
            java.lang.String r2 = r2.zzd()     // Catch:{ all -> 0x006f }
            r1.zzs(r2)     // Catch:{ all -> 0x006f }
            monitor-exit(r1)
            return
        L_0x006d:
            monitor-exit(r1)
            return
        L_0x006f:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdqx.zzbI(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    public final synchronized void zzc() {
        if (!this.zzn) {
            zzdpx zzdpx = this.zzi;
            if (zzdpx != null) {
                zzdpx.zzL(this);
                this.zzi = null;
            }
            this.zzc.clear();
            this.zzd.removeAllViews();
            this.zze.removeAllViews();
            this.zzc = null;
            this.zzd = null;
            this.zze = null;
            this.zzg = null;
            this.zzj = null;
            this.zzn = true;
        }
    }

    public final void zzd(IObjectWrapper iObjectWrapper) {
        onTouch(this.zzd, (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper, int i11) {
    }

    public final /* synthetic */ View zzf() {
        return this.zzd;
    }

    public final synchronized View zzg(String str) {
        if (this.zzn) {
            return null;
        }
        WeakReference weakReference = this.zzc.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    public final FrameLayout zzh() {
        return this.zze;
    }

    public final zzayb zzi() {
        return this.zzj;
    }

    @Nullable
    public final IObjectWrapper zzj() {
        return this.zzk;
    }

    public final synchronized String zzk() {
        return this.zzb;
    }

    public final synchronized Map<String, WeakReference<View>> zzl() {
        return this.zzc;
    }

    public final synchronized Map<String, WeakReference<View>> zzm() {
        return this.zzc;
    }

    @Nullable
    public final synchronized Map<String, WeakReference<View>> zzn() {
        return null;
    }

    @Nullable
    public final synchronized JSONObject zzo() {
        zzdpx zzdpx = this.zzi;
        if (zzdpx == null) {
            return null;
        }
        return zzdpx.zzf(this.zzd, zzl(), zzm());
    }

    @Nullable
    public final synchronized JSONObject zzp() {
        zzdpx zzdpx = this.zzi;
        if (zzdpx == null) {
            return null;
        }
        return zzdpx.zzg(this.zzd, zzl(), zzm());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzq(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r4 = r1.zzn     // Catch:{ all -> 0x0041 }
            if (r4 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            if (r3 != 0) goto L_0x0010
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzc     // Catch:{ all -> 0x0041 }
            r3.remove(r2)     // Catch:{ all -> 0x0041 }
            monitor-exit(r1)
            return
        L_0x0010:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.zzc     // Catch:{ all -> 0x0041 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0041 }
            r0.<init>(r3)     // Catch:{ all -> 0x0041 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0041 }
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0041 }
            if (r4 != 0) goto L_0x003f
            java.lang.String r4 = "3011"
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x002b
            goto L_0x003f
        L_0x002b:
            int r2 = r1.zzh     // Catch:{ all -> 0x0041 }
            boolean r2 = com.google.android.gms.ads.internal.util.zzcb.zzi(r2)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0036
            r3.setOnTouchListener(r1)     // Catch:{ all -> 0x0041 }
        L_0x0036:
            r2 = 1
            r3.setClickable(r2)     // Catch:{ all -> 0x0041 }
            r3.setOnClickListener(r1)     // Catch:{ all -> 0x0041 }
            monitor-exit(r1)
            return
        L_0x003f:
            monitor-exit(r1)
            return
        L_0x0041:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdqx.zzq(java.lang.String, android.view.View, boolean):void");
    }

    public final /* synthetic */ void zzr() {
        if (this.zzg == null) {
            View view = new View(this.zzd.getContext());
            this.zzg = view;
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        }
        if (this.zzd != this.zzg.getParent()) {
            this.zzd.addView(this.zzg);
        }
    }
}
