package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzba;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@Instrumented
@ParametersAreNonnullByDefault
public final class zzdrz implements zzdqk {
    @Nullable
    private final zzbxw zza;
    private final zzdfj zzb;
    private final zzdep zzc;
    private final zzdmb zzd;
    private final Context zze;
    private final zzfdn zzf;
    private final zzcjf zzg;
    private final zzfef zzh;
    private boolean zzi = false;
    private boolean zzj = false;
    private boolean zzk = true;
    @Nullable
    private final zzbxs zzl;
    @Nullable
    private final zzbxt zzm;

    public zzdrz(@Nullable zzbxs zzbxs, @Nullable zzbxt zzbxt, @Nullable zzbxw zzbxw, zzdfj zzdfj, zzdep zzdep, zzdmb zzdmb, Context context, zzfdn zzfdn, zzcjf zzcjf, zzfef zzfef, byte[] bArr) {
        this.zzl = zzbxs;
        this.zzm = zzbxt;
        this.zza = zzbxw;
        this.zzb = zzdfj;
        this.zzc = zzdep;
        this.zzd = zzdmb;
        this.zze = context;
        this.zzf = zzfdn;
        this.zzg = zzcjf;
        this.zzh = zzfef;
    }

    private final void zza(View view) {
        try {
            zzbxw zzbxw = this.zza;
            if (zzbxw == null || zzbxw.zzA()) {
                zzbxs zzbxs = this.zzl;
                if (zzbxs == null || zzbxs.zzx()) {
                    zzbxt zzbxt = this.zzm;
                    if (zzbxt != null && !zzbxt.zzv()) {
                        this.zzm.zzq(ObjectWrapper.wrap(view));
                        this.zzc.onAdClicked();
                        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzhm)).booleanValue()) {
                            this.zzd.zzq();
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.zzl.zzs(ObjectWrapper.wrap(view));
                this.zzc.onAdClicked();
                if (((Boolean) zzbgq.zzc().zzb(zzblj.zzhm)).booleanValue()) {
                    this.zzd.zzq();
                    return;
                }
                return;
            }
            this.zza.zzw(ObjectWrapper.wrap(view));
            this.zzc.onAdClicked();
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzhm)).booleanValue()) {
                this.zzd.zzq();
            }
        } catch (RemoteException e11) {
            zzciz.zzk("Failed to call handleClick", e11);
        }
    }

    private static final HashMap<String, View> zzb(Map<String, WeakReference<View>> map) {
        HashMap<String, View> hashMap = new HashMap<>();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            for (Map.Entry next : map.entrySet()) {
                View view = (View) ((WeakReference) next.getValue()).get();
                if (view != null) {
                    hashMap.put((String) next.getKey(), view);
                }
            }
        }
        return hashMap;
    }

    public final boolean zzA(Bundle bundle) {
        return false;
    }

    @Nullable
    public final JSONObject zzd(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return null;
    }

    @Nullable
    public final JSONObject zze(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return null;
    }

    public final void zzf() {
        throw null;
    }

    public final void zzg() {
    }

    public final void zzh() {
    }

    public final void zzi(@Nullable zzbij zzbij) {
        zzciz.zzj("Mute This Ad is not supported for 3rd party ads");
    }

    public final void zzj(View view, @Nullable View view2, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, boolean z11) {
        if (!this.zzj || !this.zzf.zzI) {
            zza(view);
        }
    }

    public final void zzk(String str) {
    }

    public final void zzl(Bundle bundle) {
    }

    public final void zzn(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z11) {
        if (!this.zzj) {
            zzciz.zzj("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (!this.zzf.zzI) {
            zzciz.zzj("Custom click reporting for 3p ads failed. Ad unit id not in allow list.");
        } else {
            zza(view);
        }
    }

    public final void zzo() {
    }

    public final void zzp(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2) {
        String str;
        try {
            if (!this.zzi) {
                zzba zzs = zzt.zzs();
                Context context = this.zze;
                String str2 = this.zzg.zza;
                JSONObject jSONObject = this.zzf.zzD;
                if (!(jSONObject instanceof JSONObject)) {
                    str = jSONObject.toString();
                } else {
                    str = JSONObjectInstrumentation.toString(jSONObject);
                }
                this.zzi = zzs.zzn(context, str2, str, this.zzh.zzf);
            }
            if (this.zzk) {
                zzbxw zzbxw = this.zza;
                if (zzbxw != null) {
                    if (!zzbxw.zzB()) {
                        this.zza.zzx();
                        this.zzb.zza();
                        return;
                    }
                }
                zzbxs zzbxs = this.zzl;
                if (zzbxs != null) {
                    if (!zzbxs.zzy()) {
                        this.zzl.zzt();
                        this.zzb.zza();
                        return;
                    }
                }
                zzbxt zzbxt = this.zzm;
                if (zzbxt != null && !zzbxt.zzw()) {
                    this.zzm.zzr();
                    this.zzb.zza();
                }
            }
        } catch (RemoteException e11) {
            zzciz.zzk("Failed to call recordImpression", e11);
        }
    }

    public final void zzq() {
    }

    public final void zzr(View view, MotionEvent motionEvent, @Nullable View view2) {
    }

    public final void zzs(Bundle bundle) {
    }

    public final void zzt(View view) {
    }

    public final void zzu() {
        this.zzj = true;
    }

    public final void zzv(zzbif zzbif) {
        zzciz.zzj("Mute This Ad is not supported for 3rd party ads");
    }

    public final void zzw(zzbqc zzbqc) {
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzx(android.view.View r9, @androidx.annotation.Nullable java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r10, @androidx.annotation.Nullable java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r11, android.view.View.OnTouchListener r12, android.view.View.OnClickListener r13) {
        /*
            r8 = this;
            com.google.android.gms.dynamic.IObjectWrapper r9 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r9)     // Catch:{ RemoteException -> 0x0122 }
            com.google.android.gms.internal.ads.zzfdn r12 = r8.zzf     // Catch:{ RemoteException -> 0x0122 }
            org.json.JSONObject r12 = r12.zzah     // Catch:{ RemoteException -> 0x0122 }
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r13 = com.google.android.gms.internal.ads.zzblj.zzbh     // Catch:{ RemoteException -> 0x0122 }
            com.google.android.gms.internal.ads.zzblh r0 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ RemoteException -> 0x0122 }
            java.lang.Object r13 = r0.zzb(r13)     // Catch:{ RemoteException -> 0x0122 }
            java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch:{ RemoteException -> 0x0122 }
            boolean r13 = r13.booleanValue()     // Catch:{ RemoteException -> 0x0122 }
            r0 = 1
            if (r13 == 0) goto L_0x00de
            int r13 = r12.length()     // Catch:{ RemoteException -> 0x0122 }
            if (r13 != 0) goto L_0x0023
            goto L_0x00de
        L_0x0023:
            if (r10 != 0) goto L_0x002b
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ RemoteException -> 0x0122 }
            r13.<init>()     // Catch:{ RemoteException -> 0x0122 }
            goto L_0x002c
        L_0x002b:
            r13 = r10
        L_0x002c:
            if (r11 != 0) goto L_0x0034
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ RemoteException -> 0x0122 }
            r1.<init>()     // Catch:{ RemoteException -> 0x0122 }
            goto L_0x0035
        L_0x0034:
            r1 = r11
        L_0x0035:
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ RemoteException -> 0x0122 }
            r2.<init>()     // Catch:{ RemoteException -> 0x0122 }
            r2.putAll(r13)     // Catch:{ RemoteException -> 0x0122 }
            r2.putAll(r1)     // Catch:{ RemoteException -> 0x0122 }
            java.util.Iterator r13 = r12.keys()     // Catch:{ RemoteException -> 0x0122 }
        L_0x0044:
            boolean r1 = r13.hasNext()     // Catch:{ RemoteException -> 0x0122 }
            if (r1 == 0) goto L_0x00de
            java.lang.Object r1 = r13.next()     // Catch:{ RemoteException -> 0x0122 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ RemoteException -> 0x0122 }
            org.json.JSONArray r3 = r12.optJSONArray(r1)     // Catch:{ RemoteException -> 0x0122 }
            if (r3 == 0) goto L_0x0044
            java.lang.Object r4 = r2.get(r1)     // Catch:{ RemoteException -> 0x0122 }
            java.lang.ref.WeakReference r4 = (java.lang.ref.WeakReference) r4     // Catch:{ RemoteException -> 0x0122 }
            r5 = 0
            if (r4 != 0) goto L_0x0062
        L_0x005f:
            r0 = r5
            goto L_0x00de
        L_0x0062:
            java.lang.Object r4 = r4.get()     // Catch:{ RemoteException -> 0x0122 }
            if (r4 != 0) goto L_0x0069
            goto L_0x005f
        L_0x0069:
            java.lang.Class r4 = r4.getClass()     // Catch:{ RemoteException -> 0x0122 }
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r6 = com.google.android.gms.internal.ads.zzblj.zzbi     // Catch:{ RemoteException -> 0x0122 }
            com.google.android.gms.internal.ads.zzblh r7 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ RemoteException -> 0x0122 }
            java.lang.Object r6 = r7.zzb(r6)     // Catch:{ RemoteException -> 0x0122 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ RemoteException -> 0x0122 }
            boolean r6 = r6.booleanValue()     // Catch:{ RemoteException -> 0x0122 }
            if (r6 == 0) goto L_0x00b1
            java.lang.String r6 = "3010"
            boolean r1 = r1.equals(r6)     // Catch:{ RemoteException -> 0x0122 }
            if (r1 == 0) goto L_0x00b1
            com.google.android.gms.internal.ads.zzbxw r1 = r8.zza     // Catch:{ RemoteException -> 0x0122 }
            r4 = 0
            if (r1 == 0) goto L_0x0091
            com.google.android.gms.dynamic.IObjectWrapper r1 = r1.zzn()     // Catch:{ RemoteException -> 0x00aa }
            goto L_0x00a4
        L_0x0091:
            com.google.android.gms.internal.ads.zzbxs r1 = r8.zzl     // Catch:{ RemoteException -> 0x0122 }
            if (r1 == 0) goto L_0x009a
            com.google.android.gms.dynamic.IObjectWrapper r1 = r1.zzk()     // Catch:{ RemoteException -> 0x00aa }
            goto L_0x00a4
        L_0x009a:
            com.google.android.gms.internal.ads.zzbxt r1 = r8.zzm     // Catch:{ RemoteException -> 0x0122 }
            if (r1 == 0) goto L_0x00a3
            com.google.android.gms.dynamic.IObjectWrapper r1 = r1.zzj()     // Catch:{ RemoteException -> 0x00aa }
            goto L_0x00a4
        L_0x00a3:
            r1 = r4
        L_0x00a4:
            if (r1 == 0) goto L_0x00aa
            java.lang.Object r4 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r1)     // Catch:{  }
        L_0x00aa:
            if (r4 != 0) goto L_0x00ad
            goto L_0x005f
        L_0x00ad:
            java.lang.Class r4 = r4.getClass()     // Catch:{ RemoteException -> 0x0122 }
        L_0x00b1:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ JSONException -> 0x0044 }
            r1.<init>()     // Catch:{ JSONException -> 0x0044 }
            com.google.android.gms.ads.internal.util.zzby.zzc(r3, r1)     // Catch:{ JSONException -> 0x0044 }
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ JSONException -> 0x0044 }
            android.content.Context r3 = r8.zze     // Catch:{ JSONException -> 0x0044 }
            java.lang.ClassLoader r3 = r3.getClassLoader()     // Catch:{ JSONException -> 0x0044 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ JSONException -> 0x0044 }
        L_0x00c6:
            boolean r6 = r1.hasNext()     // Catch:{ JSONException -> 0x0044 }
            if (r6 == 0) goto L_0x005f
            java.lang.Object r6 = r1.next()     // Catch:{ JSONException -> 0x0044 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ JSONException -> 0x0044 }
            java.lang.Class r6 = java.lang.Class.forName(r6, r5, r3)     // Catch:{ all -> 0x00c6 }
            boolean r6 = r6.isAssignableFrom(r4)     // Catch:{ all -> 0x00c6 }
            if (r6 == 0) goto L_0x00c6
            goto L_0x0044
        L_0x00de:
            r8.zzk = r0     // Catch:{ RemoteException -> 0x0122 }
            java.util.HashMap r10 = zzb(r10)     // Catch:{ RemoteException -> 0x0122 }
            java.util.HashMap r11 = zzb(r11)     // Catch:{ RemoteException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbxw r12 = r8.zza     // Catch:{ RemoteException -> 0x0122 }
            if (r12 == 0) goto L_0x00f8
            com.google.android.gms.dynamic.IObjectWrapper r10 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0122 }
            com.google.android.gms.dynamic.IObjectWrapper r11 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r11)     // Catch:{ RemoteException -> 0x0122 }
            r12.zzy(r9, r10, r11)     // Catch:{ RemoteException -> 0x0122 }
            return
        L_0x00f8:
            com.google.android.gms.internal.ads.zzbxs r12 = r8.zzl     // Catch:{ RemoteException -> 0x0122 }
            if (r12 == 0) goto L_0x010d
            com.google.android.gms.dynamic.IObjectWrapper r10 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0122 }
            com.google.android.gms.dynamic.IObjectWrapper r11 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r11)     // Catch:{ RemoteException -> 0x0122 }
            r12.zzv(r9, r10, r11)     // Catch:{ RemoteException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbxs r10 = r8.zzl     // Catch:{ RemoteException -> 0x0122 }
            r10.zzu(r9)     // Catch:{ RemoteException -> 0x0122 }
            return
        L_0x010d:
            com.google.android.gms.internal.ads.zzbxt r12 = r8.zzm     // Catch:{ RemoteException -> 0x0122 }
            if (r12 == 0) goto L_0x0121
            com.google.android.gms.dynamic.IObjectWrapper r10 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0122 }
            com.google.android.gms.dynamic.IObjectWrapper r11 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r11)     // Catch:{ RemoteException -> 0x0122 }
            r12.zzt(r9, r10, r11)     // Catch:{ RemoteException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbxt r10 = r8.zzm     // Catch:{ RemoteException -> 0x0122 }
            r10.zzs(r9)     // Catch:{ RemoteException -> 0x0122 }
        L_0x0121:
            return
        L_0x0122:
            r9 = move-exception
            java.lang.String r10 = "Failed to call trackView"
            com.google.android.gms.internal.ads.zzciz.zzk(r10, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdrz.zzx(android.view.View, java.util.Map, java.util.Map, android.view.View$OnTouchListener, android.view.View$OnClickListener):void");
    }

    public final void zzy(View view, @Nullable Map<String, WeakReference<View>> map) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            zzbxw zzbxw = this.zza;
            if (zzbxw != null) {
                zzbxw.zzz(wrap);
                return;
            }
            zzbxs zzbxs = this.zzl;
            if (zzbxs != null) {
                zzbxs.zzw(wrap);
                return;
            }
            zzbxt zzbxt = this.zzm;
            if (zzbxt != null) {
                zzbxt.zzu(wrap);
            }
        } catch (RemoteException e11) {
            zzciz.zzk("Failed to call untrackView", e11);
        }
    }

    public final boolean zzz() {
        return this.zzf.zzI;
    }
}
