package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzba;
import com.google.android.gms.ads.internal.util.zzcb;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.huawei.hms.flutter.map.constants.Param;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
@ParametersAreNonnullByDefault
public final class zzdpc implements zzdqk {
    private final Context zza;
    private final zzdqn zzb;
    private final JSONObject zzc;
    private final zzduy zzd;
    private final zzdqc zze;
    private final zzalt zzf;
    /* access modifiers changed from: private */
    public final zzdfj zzg;
    /* access modifiers changed from: private */
    public final zzdep zzh;
    /* access modifiers changed from: private */
    public final zzdmb zzi;
    private final zzfdn zzj;
    private final zzcjf zzk;
    private final zzfef zzl;
    private final zzcxf zzm;
    private final zzdre zzn;
    private final Clock zzo;
    private final zzdly zzp;
    private final zzfjs zzq;
    private boolean zzr = false;
    private boolean zzs;
    private boolean zzt = false;
    private boolean zzu = false;
    private Point zzv = new Point();
    private Point zzw = new Point();
    private long zzx = 0;
    private long zzy = 0;
    private zzbif zzz;

    public zzdpc(Context context, zzdqn zzdqn, JSONObject jSONObject, zzduy zzduy, zzdqc zzdqc, zzalt zzalt, zzdfj zzdfj, zzdep zzdep, zzdmb zzdmb, zzfdn zzfdn, zzcjf zzcjf, zzfef zzfef, zzcxf zzcxf, zzdre zzdre, Clock clock, zzdly zzdly, zzfjs zzfjs) {
        this.zza = context;
        this.zzb = zzdqn;
        this.zzc = jSONObject;
        this.zzd = zzduy;
        this.zze = zzdqc;
        this.zzf = zzalt;
        this.zzg = zzdfj;
        this.zzh = zzdep;
        this.zzi = zzdmb;
        this.zzj = zzfdn;
        this.zzk = zzcjf;
        this.zzl = zzfef;
        this.zzm = zzcxf;
        this.zzn = zzdre;
        this.zzo = clock;
        this.zzp = zzdly;
        this.zzq = zzfjs;
    }

    @Nullable
    private final String zzB(@Nullable View view, @Nullable Map<String, WeakReference<View>> map) {
        if (!(map == null || view == null)) {
            for (Map.Entry next : map.entrySet()) {
                if (view.equals((View) ((WeakReference) next.getValue()).get())) {
                    return (String) next.getKey();
                }
            }
        }
        int zzc2 = this.zze.zzc();
        if (zzc2 == 1) {
            return "1099";
        }
        if (zzc2 == 2) {
            return "2099";
        }
        if (zzc2 != 6) {
            return null;
        }
        return "3099";
    }

    private final boolean zzC(String str) {
        JSONObject optJSONObject = this.zzc.optJSONObject("allow_pub_event_reporting");
        if (optJSONObject == null || !optJSONObject.optBoolean(str, false)) {
            return false;
        }
        return true;
    }

    private final boolean zzD() {
        return this.zzc.optBoolean("allow_custom_click_gesture", false);
    }

    private final boolean zzE(@Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2, @Nullable JSONObject jSONObject3, @Nullable JSONObject jSONObject4, @Nullable String str, @Nullable JSONObject jSONObject5, boolean z11) {
        String str2;
        Preconditions.checkMainThread("recordImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", (Object) this.zzc);
            jSONObject6.put("asset_view_signal", (Object) jSONObject2);
            jSONObject6.put("ad_view_signal", (Object) jSONObject);
            jSONObject6.put("scroll_view_signal", (Object) jSONObject3);
            jSONObject6.put("lock_screen_signal", (Object) jSONObject4);
            jSONObject6.put("provided_signals", (Object) jSONObject5);
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzch)).booleanValue()) {
                jSONObject6.put("view_signals", (Object) str);
            }
            jSONObject6.put("policy_validator_enabled", z11);
            Context context = this.zza;
            JSONObject jSONObject7 = new JSONObject();
            zzt.zzp();
            DisplayMetrics zzy2 = com.google.android.gms.ads.internal.util.zzt.zzy((WindowManager) context.getSystemService("window"));
            try {
                jSONObject7.put("width", zzbgo.zzb().zzb(context, zzy2.widthPixels));
                jSONObject7.put("height", zzbgo.zzb().zzb(context, zzy2.heightPixels));
            } catch (JSONException unused) {
                jSONObject7 = null;
            }
            jSONObject6.put("screen", (Object) jSONObject7);
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgk)).booleanValue()) {
                this.zzd.zzi("/clickRecorded", new zzdoz(this, (zzdoy) null));
            } else {
                this.zzd.zzi("/logScionEvent", new zzdox(this, (zzdow) null));
            }
            this.zzd.zzi("/nativeImpression", new zzdpb(this, (zzdpa) null));
            zzcjp.zza(this.zzd.zzd("google.afma.nativeAds.handleImpression", jSONObject6), "Error during performing handleImpression");
            if (this.zzr) {
                return true;
            }
            zzba zzs2 = zzt.zzs();
            Context context2 = this.zza;
            String str3 = this.zzk.zza;
            JSONObject jSONObject8 = this.zzj.zzD;
            if (!(jSONObject8 instanceof JSONObject)) {
                str2 = jSONObject8.toString();
            } else {
                str2 = JSONObjectInstrumentation.toString(jSONObject8);
            }
            this.zzr = zzs2.zzn(context2, str3, str2, this.zzl.zzf);
            return true;
        } catch (JSONException e11) {
            zzciz.zzh("Unable to create impression JSON.", e11);
            return false;
        }
    }

    public final boolean zzA(Bundle bundle) {
        if (!zzC("impression_reporting")) {
            zzciz.zzg("The ad slot cannot handle external impression events. You must be in the allow list to be able to report your impression events.");
            return false;
        }
        return zzE((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (String) null, zzt.zzp().zzg(bundle, (JSONObject) null), false);
    }

    @Nullable
    public final JSONObject zzd(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2) {
        JSONObject zzd2 = zzcb.zzd(this.zza, map, map2, view);
        JSONObject zzg2 = zzcb.zzg(this.zza, view);
        JSONObject zzf2 = zzcb.zzf(view);
        JSONObject zze2 = zzcb.zze(this.zza, view);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("asset_view_signal", (Object) zzd2);
            jSONObject.put("ad_view_signal", (Object) zzg2);
            jSONObject.put("scroll_view_signal", (Object) zzf2);
            jSONObject.put("lock_screen_signal", (Object) zze2);
            return jSONObject;
        } catch (JSONException e11) {
            zzciz.zzh("Unable to create native ad view signals JSON.", e11);
            return null;
        }
    }

    @Nullable
    public final JSONObject zze(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2) {
        JSONObject zzd2 = zzd(view, map, map2);
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.zzu && zzD()) {
                jSONObject.put("custom_click_gesture_eligible", true);
            }
            if (zzd2 != null) {
                jSONObject.put("nas", (Object) zzd2);
            }
        } catch (JSONException e11) {
            zzciz.zzh("Unable to create native click meta data JSON.", e11);
        }
        return jSONObject;
    }

    public final void zzf() {
        try {
            zzbif zzbif = this.zzz;
            if (zzbif != null) {
                zzbif.zze();
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void zzg() {
        if (this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.zzn.zzb();
        }
    }

    public final void zzh() {
        this.zzd.zzf();
    }

    public final void zzi(@Nullable zzbij zzbij) {
        try {
            if (!this.zzt) {
                if (zzbij == null) {
                    if (this.zze.zzk() != null) {
                        this.zzt = true;
                        this.zzq.zzb(this.zze.zzk().zzf());
                        zzf();
                        return;
                    }
                }
                this.zzt = true;
                this.zzq.zzb(zzbij.zzf());
                zzf();
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void zzj(View view, @Nullable View view2, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, boolean z11) {
        View view3;
        View view4 = view2;
        Map<String, WeakReference<View>> map3 = map;
        JSONObject zzd2 = zzcb.zzd(this.zza, map, map2, view2);
        JSONObject zzg2 = zzcb.zzg(this.zza, view2);
        JSONObject zzf2 = zzcb.zzf(view2);
        JSONObject zze2 = zzcb.zze(this.zza, view2);
        View view5 = view;
        String zzB = zzB(view, map);
        JSONObject zzc2 = zzcb.zzc(zzB, this.zza, this.zzw, this.zzv);
        if (true == ((Boolean) zzbgq.zzc().zzb(zzblj.zzci)).booleanValue()) {
            view3 = view4;
        } else {
            view3 = view5;
        }
        zzm(view3, zzg2, zzd2, zzf2, zze2, zzB, zzc2, (JSONObject) null, z11, false);
    }

    public final void zzk(String str) {
        zzm((View) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, str, (JSONObject) null, (JSONObject) null, false, false);
    }

    public final void zzl(@Nullable Bundle bundle) {
        String str;
        if (bundle == null) {
            zzciz.zze("Click data is null. No click is reported.");
        } else if (!zzC("click_reporting")) {
            zzciz.zzg("The ad slot cannot handle external click events. You must be part of the allow list to be able to report your click events.");
        } else {
            Bundle bundle2 = bundle.getBundle("click_signal");
            if (bundle2 != null) {
                str = bundle2.getString(InstabugDbContract.AnnouncementAssetsEntry.COLUMN_ID);
            } else {
                str = null;
            }
            zzm((View) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, str, (JSONObject) null, zzt.zzp().zzg(bundle, (JSONObject) null), false, false);
        }
    }

    @VisibleForTesting
    public final void zzm(@Nullable View view, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2, @Nullable JSONObject jSONObject3, @Nullable JSONObject jSONObject4, @Nullable String str, @Nullable JSONObject jSONObject5, @Nullable JSONObject jSONObject6, boolean z11, boolean z12) {
        boolean z13;
        boolean z14;
        boolean z15;
        String str2;
        Preconditions.checkMainThread("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("ad", (Object) this.zzc);
            jSONObject7.put("asset_view_signal", (Object) jSONObject2);
            jSONObject7.put("ad_view_signal", (Object) jSONObject);
            jSONObject7.put("click_signal", (Object) jSONObject5);
            jSONObject7.put("scroll_view_signal", (Object) jSONObject3);
            jSONObject7.put("lock_screen_signal", (Object) jSONObject4);
            boolean z16 = false;
            if (this.zzb.zzc(this.zze.zzy()) != null) {
                z13 = true;
            } else {
                z13 = false;
            }
            jSONObject7.put("has_custom_click_handler", z13);
            jSONObject7.put("provided_signals", (Object) jSONObject6);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put(InstabugDbContract.AnnouncementAssetsEntry.COLUMN_ID, (Object) str);
            jSONObject8.put("template", this.zze.zzc());
            jSONObject8.put("view_aware_api_used", z11);
            zzbnw zzbnw = this.zzl.zzi;
            if (zzbnw == null || !zzbnw.zzg) {
                z14 = false;
            } else {
                z14 = true;
            }
            jSONObject8.put("custom_mute_requested", z14);
            if (this.zze.zzF().isEmpty() || this.zze.zzk() == null) {
                z15 = false;
            } else {
                z15 = true;
            }
            jSONObject8.put("custom_mute_enabled", z15);
            if (this.zzn.zza() != null && this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject8.put("custom_one_point_five_click_eligible", true);
            }
            jSONObject8.put("timestamp", this.zzo.currentTimeMillis());
            if (this.zzu && zzD()) {
                jSONObject8.put("custom_click_gesture_eligible", true);
            }
            if (z12) {
                jSONObject8.put("is_custom_click_gesture", true);
            }
            if (this.zzb.zzc(this.zze.zzy()) != null) {
                z16 = true;
            }
            jSONObject8.put("has_custom_click_handler", z16);
            try {
                JSONObject optJSONObject = this.zzc.optJSONObject("tracking_urls_and_actions");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                str2 = this.zzf.zzc().zze(this.zza, optJSONObject.optString("click_string"), view);
            } catch (Exception e11) {
                zzciz.zzh("Exception obtaining click signals", e11);
                str2 = null;
            }
            jSONObject8.put("click_signals", (Object) str2);
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdf)).booleanValue()) {
                jSONObject8.put("open_chrome_custom_tab", true);
            }
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgo)).booleanValue() && PlatformVersion.isAtLeastR()) {
                jSONObject8.put("try_fallback_for_deep_link", true);
            }
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgp)).booleanValue() && PlatformVersion.isAtLeastR()) {
                jSONObject8.put("in_app_link_handling_for_android_11_enabled", true);
            }
            jSONObject7.put("click", (Object) jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            long currentTimeMillis = this.zzo.currentTimeMillis();
            jSONObject9.put("time_from_last_touch_down", currentTimeMillis - this.zzx);
            jSONObject9.put("time_from_last_touch", currentTimeMillis - this.zzy);
            jSONObject7.put("touch_signal", (Object) jSONObject9);
            zzcjp.zza(this.zzd.zzd("google.afma.nativeAds.handleClick", jSONObject7), "Error during performing handleClick");
        } catch (JSONException e12) {
            zzciz.zzh("Unable to create click JSON.", e12);
        }
    }

    public final void zzn(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, boolean z11) {
        View view2 = view;
        Map<String, WeakReference<View>> map3 = map;
        if (!this.zzu) {
            zzciz.zze("Custom click reporting failed. enableCustomClickGesture is not set.");
        } else if (!zzD()) {
            zzciz.zze("Custom click reporting failed. Ad unit id not in the allow list.");
        } else {
            Map<String, WeakReference<View>> map4 = map2;
            JSONObject zzd2 = zzcb.zzd(this.zza, map, map2, view);
            JSONObject zzg2 = zzcb.zzg(this.zza, view);
            JSONObject zzf2 = zzcb.zzf(view);
            JSONObject zze2 = zzcb.zze(this.zza, view);
            String zzB = zzB((View) null, map);
            zzm(view, zzg2, zzd2, zzf2, zze2, zzB, zzcb.zzc(zzB, this.zza, this.zzw, this.zzv), (JSONObject) null, z11, true);
        }
    }

    public final void zzo() {
        Preconditions.checkMainThread("recordDownloadedImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", (Object) this.zzc);
            zzcjp.zza(this.zzd.zzd("google.afma.nativeAds.handleDownloadedImpression", jSONObject), "Error during performing handleDownloadedImpression");
        } catch (JSONException e11) {
            zzciz.zzh("", e11);
        }
    }

    public final void zzp(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2) {
        String str;
        JSONObject zzd2 = zzcb.zzd(this.zza, map, map2, view);
        JSONObject zzg2 = zzcb.zzg(this.zza, view);
        JSONObject zzf2 = zzcb.zzf(view);
        JSONObject zze2 = zzcb.zze(this.zza, view);
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzch)).booleanValue()) {
            try {
                str = this.zzf.zzc().zzh(this.zza, view, (Activity) null);
            } catch (Exception unused) {
                zzciz.zzg("Exception getting data.");
            }
            zzE(zzg2, zzd2, zzf2, zze2, str, (JSONObject) null, zzcb.zzh(this.zza, this.zzj));
        }
        str = null;
        zzE(zzg2, zzd2, zzf2, zze2, str, (JSONObject) null, zzcb.zzh(this.zza, this.zzj));
    }

    public final void zzq() {
        zzE((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (String) null, (JSONObject) null, false);
    }

    public final void zzr(@Nullable View view, MotionEvent motionEvent, @Nullable View view2) {
        this.zzv = zzcb.zza(motionEvent, view2);
        long currentTimeMillis = this.zzo.currentTimeMillis();
        this.zzy = currentTimeMillis;
        if (motionEvent.getAction() == 0) {
            this.zzx = currentTimeMillis;
            this.zzw = this.zzv;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        Point point = this.zzv;
        obtain.setLocation((float) point.x, (float) point.y);
        this.zzf.zzd(obtain);
        obtain.recycle();
    }

    public final void zzs(@Nullable Bundle bundle) {
        if (bundle == null) {
            zzciz.zze("Touch event data is null. No touch event is reported.");
        } else if (!zzC("touch_reporting")) {
            zzciz.zzg("The ad slot cannot handle external touch events. You must be in the allow list to be able to report your touch events.");
        } else {
            float f11 = bundle.getFloat(Param.X);
            float f12 = bundle.getFloat(Param.Y);
            this.zzf.zzc().zzl((int) f11, (int) f12, bundle.getInt("duration_ms"));
        }
    }

    public final void zzt(View view) {
        if (!this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzciz.zzj("setClickConfirmingView: Your account need to be in the allow list to use this feature.\nContact your account manager for more information.");
            return;
        }
        zzdre zzdre = this.zzn;
        if (view != null) {
            view.setOnClickListener(zzdre);
            view.setClickable(true);
            zzdre.zzc = new WeakReference<>(view);
        }
    }

    public final void zzu() {
        this.zzu = true;
    }

    public final void zzv(zzbif zzbif) {
        this.zzz = zzbif;
    }

    public final void zzw(zzbqc zzbqc) {
        if (!this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzciz.zzj("setUnconfirmedClickListener: Your account need to be in the allow list to use this feature.\nContact your account manager for more information.");
        } else {
            this.zzn.zzc(zzbqc);
        }
    }

    public final void zzx(View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        this.zzv = new Point();
        this.zzw = new Point();
        if (!this.zzs) {
            this.zzp.zza(view);
            this.zzs = true;
        }
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        this.zzm.zzi(this);
        boolean zzi2 = zzcb.zzi(this.zzk.zzc);
        if (map != null) {
            for (Map.Entry<String, WeakReference<View>> value : map.entrySet()) {
                View view2 = (View) ((WeakReference) value.getValue()).get();
                if (view2 != null) {
                    if (zzi2) {
                        view2.setOnTouchListener(onTouchListener);
                    }
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
        if (map2 != null) {
            for (Map.Entry<String, WeakReference<View>> value2 : map2.entrySet()) {
                View view3 = (View) ((WeakReference) value2.getValue()).get();
                if (view3 != null) {
                    if (zzi2) {
                        view3.setOnTouchListener(onTouchListener);
                    }
                    view3.setClickable(false);
                }
            }
        }
    }

    public final void zzy(@Nullable View view, @Nullable Map<String, WeakReference<View>> map) {
        this.zzv = new Point();
        this.zzw = new Point();
        if (view != null) {
            this.zzp.zzb(view);
        }
        this.zzs = false;
    }

    public final boolean zzz() {
        return zzD();
    }
}
