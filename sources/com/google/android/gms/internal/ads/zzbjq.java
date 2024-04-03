package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnAdInspectorClosedListener;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public final class zzbjq {
    @GuardedBy("InternalMobileAds.class")
    private static zzbjq zza;
    /* access modifiers changed from: private */
    public final ArrayList<OnInitializationCompleteListener> zzb = new ArrayList<>();
    private final Object zzc = new Object();
    @GuardedBy("lock")
    private zzbib zzd;
    /* access modifiers changed from: private */
    public boolean zze = false;
    /* access modifiers changed from: private */
    public boolean zzf = false;
    /* access modifiers changed from: private */
    @Nullable
    public OnAdInspectorClosedListener zzg = null;
    @NonNull
    private RequestConfiguration zzh = new RequestConfiguration.Builder().build();
    private InitializationStatus zzi;

    private zzbjq() {
    }

    public static zzbjq zzf() {
        zzbjq zzbjq;
        synchronized (zzbjq.class) {
            if (zza == null) {
                zza = new zzbjq();
            }
            zzbjq = zza;
        }
        return zzbjq;
    }

    @GuardedBy("lock")
    private final void zzv(Context context) {
        if (this.zzd == null) {
            this.zzd = (zzbib) new zzbgg(zzbgo.zza(), context).zzd(context, false);
        }
    }

    @GuardedBy("lock")
    private final void zzw(@NonNull RequestConfiguration requestConfiguration) {
        try {
            this.zzd.zzs(new zzbkk(requestConfiguration));
        } catch (RemoteException e11) {
            zzciz.zzh("Unable to set request configuration parcel.", e11);
        }
    }

    /* access modifiers changed from: private */
    public static final InitializationStatus zzx(List<zzbtn> list) {
        AdapterStatus.State state;
        HashMap hashMap = new HashMap();
        for (zzbtn next : list) {
            String str = next.zza;
            if (next.zzb) {
                state = AdapterStatus.State.READY;
            } else {
                state = AdapterStatus.State.NOT_READY;
            }
            hashMap.put(str, new zzbtv(state, next.zzd, next.zzc));
        }
        return new zzbtw(hashMap);
    }

    public final float zza() {
        float f11;
        synchronized (this.zzc) {
            zzbib zzbib = this.zzd;
            f11 = 1.0f;
            if (zzbib == null) {
                return 1.0f;
            }
            try {
                f11 = zzbib.zze();
            } catch (RemoteException e11) {
                zzciz.zzh("Unable to get app volume.", e11);
            }
        }
        return f11;
    }

    @NonNull
    public final RequestConfiguration zzc() {
        return this.zzh;
    }

    public final InitializationStatus zze() {
        boolean z11;
        synchronized (this.zzc) {
            if (this.zzd != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkState(z11, "MobileAds.initialize() must be called prior to getting initialization status.");
            try {
                InitializationStatus initializationStatus = this.zzi;
                if (initializationStatus != null) {
                    return initializationStatus;
                }
                InitializationStatus zzx = zzx(this.zzd.zzg());
                return zzx;
            } catch (RemoteException unused) {
                zzciz.zzg("Unable to get Initialization status.");
                return new zzbjj(this);
            }
        }
    }

    public final String zzg() {
        boolean z11;
        String zzc2;
        synchronized (this.zzc) {
            if (this.zzd != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkState(z11, "MobileAds.initialize() must be called prior to getting version string.");
            try {
                zzc2 = zzfqr.zzc(this.zzd.zzf());
            } catch (RemoteException e11) {
                zzciz.zzh("Unable to get version string.", e11);
                return "";
            }
        }
        return zzc2;
    }

    public final void zzk(Context context) {
        synchronized (this.zzc) {
            zzv(context);
            try {
                this.zzd.zzi();
            } catch (RemoteException unused) {
                zzciz.zzg("Unable to disable mediation adapter initialization.");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzl(android.content.Context r4, @javax.annotation.Nullable java.lang.String r5, @javax.annotation.Nullable com.google.android.gms.ads.initialization.OnInitializationCompleteListener r6) {
        /*
            r3 = this;
            java.lang.Object r5 = r3.zzc
            monitor-enter(r5)
            boolean r0 = r3.zze     // Catch:{ all -> 0x00c2 }
            if (r0 == 0) goto L_0x0014
            if (r6 == 0) goto L_0x0012
            com.google.android.gms.internal.ads.zzbjq r4 = zzf()     // Catch:{ all -> 0x00c2 }
            java.util.ArrayList<com.google.android.gms.ads.initialization.OnInitializationCompleteListener> r4 = r4.zzb     // Catch:{ all -> 0x00c2 }
            r4.add(r6)     // Catch:{ all -> 0x00c2 }
        L_0x0012:
            monitor-exit(r5)     // Catch:{ all -> 0x00c2 }
            return
        L_0x0014:
            boolean r0 = r3.zzf     // Catch:{ all -> 0x00c2 }
            if (r0 == 0) goto L_0x0023
            if (r6 == 0) goto L_0x0021
            com.google.android.gms.ads.initialization.InitializationStatus r4 = r3.zze()     // Catch:{ all -> 0x00c2 }
            r6.onInitializationComplete(r4)     // Catch:{ all -> 0x00c2 }
        L_0x0021:
            monitor-exit(r5)     // Catch:{ all -> 0x00c2 }
            return
        L_0x0023:
            r0 = 1
            r3.zze = r0     // Catch:{ all -> 0x00c2 }
            if (r6 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzbjq r0 = zzf()     // Catch:{ all -> 0x00c2 }
            java.util.ArrayList<com.google.android.gms.ads.initialization.OnInitializationCompleteListener> r0 = r0.zzb     // Catch:{ all -> 0x00c2 }
            r0.add(r6)     // Catch:{ all -> 0x00c2 }
        L_0x0031:
            if (r4 == 0) goto L_0x00ba
            com.google.android.gms.internal.ads.zzbxa r0 = com.google.android.gms.internal.ads.zzbxa.zza()     // Catch:{ RemoteException -> 0x00b2 }
            r1 = 0
            r0.zzb(r4, r1)     // Catch:{ RemoteException -> 0x00b2 }
            r3.zzv(r4)     // Catch:{ RemoteException -> 0x00b2 }
            if (r6 == 0) goto L_0x004a
            com.google.android.gms.internal.ads.zzbib r0 = r3.zzd     // Catch:{ RemoteException -> 0x00b2 }
            com.google.android.gms.internal.ads.zzbjp r2 = new com.google.android.gms.internal.ads.zzbjp     // Catch:{ RemoteException -> 0x00b2 }
            r2.<init>(r3, r1)     // Catch:{ RemoteException -> 0x00b2 }
            r0.zzr(r2)     // Catch:{ RemoteException -> 0x00b2 }
        L_0x004a:
            com.google.android.gms.internal.ads.zzbib r0 = r3.zzd     // Catch:{ RemoteException -> 0x00b2 }
            com.google.android.gms.internal.ads.zzbxe r2 = new com.google.android.gms.internal.ads.zzbxe     // Catch:{ RemoteException -> 0x00b2 }
            r2.<init>()     // Catch:{ RemoteException -> 0x00b2 }
            r0.zzn(r2)     // Catch:{ RemoteException -> 0x00b2 }
            com.google.android.gms.internal.ads.zzbib r0 = r3.zzd     // Catch:{ RemoteException -> 0x00b2 }
            r0.zzj()     // Catch:{ RemoteException -> 0x00b2 }
            com.google.android.gms.internal.ads.zzbib r0 = r3.zzd     // Catch:{ RemoteException -> 0x00b2 }
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r1)     // Catch:{ RemoteException -> 0x00b2 }
            r0.zzk(r1, r2)     // Catch:{ RemoteException -> 0x00b2 }
            com.google.android.gms.ads.RequestConfiguration r0 = r3.zzh     // Catch:{ RemoteException -> 0x00b2 }
            int r0 = r0.getTagForChildDirectedTreatment()     // Catch:{ RemoteException -> 0x00b2 }
            r1 = -1
            if (r0 != r1) goto L_0x0073
            com.google.android.gms.ads.RequestConfiguration r0 = r3.zzh     // Catch:{ RemoteException -> 0x00b2 }
            int r0 = r0.getTagForUnderAgeOfConsent()     // Catch:{ RemoteException -> 0x00b2 }
            if (r0 == r1) goto L_0x0078
        L_0x0073:
            com.google.android.gms.ads.RequestConfiguration r0 = r3.zzh     // Catch:{ RemoteException -> 0x00b2 }
            r3.zzw(r0)     // Catch:{ RemoteException -> 0x00b2 }
        L_0x0078:
            com.google.android.gms.internal.ads.zzblj.zzc(r4)     // Catch:{ RemoteException -> 0x00b2 }
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r4 = com.google.android.gms.internal.ads.zzblj.zzdP     // Catch:{ RemoteException -> 0x00b2 }
            com.google.android.gms.internal.ads.zzblh r0 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ RemoteException -> 0x00b2 }
            java.lang.Object r4 = r0.zzb(r4)     // Catch:{ RemoteException -> 0x00b2 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ RemoteException -> 0x00b2 }
            boolean r4 = r4.booleanValue()     // Catch:{ RemoteException -> 0x00b2 }
            if (r4 != 0) goto L_0x00b8
            java.lang.String r4 = r3.zzg()     // Catch:{ RemoteException -> 0x00b2 }
            java.lang.String r0 = "0"
            boolean r4 = r4.endsWith(r0)     // Catch:{ RemoteException -> 0x00b2 }
            if (r4 != 0) goto L_0x00b8
            java.lang.String r4 = "Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time."
            com.google.android.gms.internal.ads.zzciz.zzg(r4)     // Catch:{ RemoteException -> 0x00b2 }
            com.google.android.gms.internal.ads.zzbjj r4 = new com.google.android.gms.internal.ads.zzbjj     // Catch:{ RemoteException -> 0x00b2 }
            r4.<init>(r3)     // Catch:{ RemoteException -> 0x00b2 }
            r3.zzi = r4     // Catch:{ RemoteException -> 0x00b2 }
            if (r6 == 0) goto L_0x00b8
            android.os.Handler r4 = com.google.android.gms.internal.ads.zzcis.zza     // Catch:{ RemoteException -> 0x00b2 }
            com.google.android.gms.internal.ads.zzbjk r0 = new com.google.android.gms.internal.ads.zzbjk     // Catch:{ RemoteException -> 0x00b2 }
            r0.<init>(r3, r6)     // Catch:{ RemoteException -> 0x00b2 }
            r4.post(r0)     // Catch:{ RemoteException -> 0x00b2 }
            goto L_0x00b8
        L_0x00b2:
            r4 = move-exception
            java.lang.String r6 = "MobileAdsSettingManager initialization failed"
            com.google.android.gms.internal.ads.zzciz.zzk(r6, r4)     // Catch:{ all -> 0x00c2 }
        L_0x00b8:
            monitor-exit(r5)     // Catch:{ all -> 0x00c2 }
            return
        L_0x00ba:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00c2 }
            java.lang.String r6 = "Context cannot be null."
            r4.<init>(r6)     // Catch:{ all -> 0x00c2 }
            throw r4     // Catch:{ all -> 0x00c2 }
        L_0x00c2:
            r4 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00c2 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbjq.zzl(android.content.Context, java.lang.String, com.google.android.gms.ads.initialization.OnInitializationCompleteListener):void");
    }

    public final /* synthetic */ void zzm(OnInitializationCompleteListener onInitializationCompleteListener) {
        onInitializationCompleteListener.onInitializationComplete(this.zzi);
    }

    public final void zzn(Context context, OnAdInspectorClosedListener onAdInspectorClosedListener) {
        synchronized (this.zzc) {
            zzv(context);
            zzf().zzg = onAdInspectorClosedListener;
            try {
                this.zzd.zzl(new zzbjn((zzbjm) null));
            } catch (RemoteException unused) {
                zzciz.zzg("Unable to open the ad inspector.");
                if (onAdInspectorClosedListener != null) {
                    onAdInspectorClosedListener.onAdInspectorClosed(new AdInspectorError(0, "Ad inspector had an internal error.", MobileAds.ERROR_DOMAIN));
                }
            }
        }
    }

    public final void zzo(Context context, String str) {
        boolean z11;
        synchronized (this.zzc) {
            if (this.zzd != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkState(z11, "MobileAds.initialize() must be called prior to opening debug menu.");
            try {
                this.zzd.zzm(ObjectWrapper.wrap(context), str);
            } catch (RemoteException e11) {
                zzciz.zzh("Unable to open debug menu.", e11);
            }
        }
    }

    public final void zzp(Class<? extends RtbAdapter> cls) {
        synchronized (this.zzc) {
            try {
                this.zzd.zzh(cls.getCanonicalName());
            } catch (RemoteException e11) {
                zzciz.zzh("Unable to register RtbAdapter", e11);
            }
        }
    }

    public final void zzq(@NonNull WebView webView) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        synchronized (this.zzc) {
            if (webView == null) {
                zzciz.zzg("The webview to be registered cannot be null.");
                return;
            }
            zzcht zza2 = zzccj.zza(webView.getContext());
            if (zza2 == null) {
                zzciz.zzj("Internal error, query info generator is null.");
                return;
            }
            try {
                zza2.zzg(ObjectWrapper.wrap(webView));
            } catch (RemoteException e11) {
                zzciz.zzh("", e11);
            }
        }
    }

    public final void zzr(boolean z11) {
        boolean z12;
        synchronized (this.zzc) {
            if (this.zzd != null) {
                z12 = true;
            } else {
                z12 = false;
            }
            Preconditions.checkState(z12, "MobileAds.initialize() must be called prior to setting app muted state.");
            try {
                this.zzd.zzo(z11);
            } catch (RemoteException e11) {
                zzciz.zzh("Unable to set app mute state.", e11);
            }
        }
    }

    public final void zzs(float f11) {
        boolean z11;
        boolean z12 = true;
        if (f11 < 0.0f || f11 > 1.0f) {
            z11 = false;
        } else {
            z11 = true;
        }
        Preconditions.checkArgument(z11, "The app volume must be a value between 0 and 1 inclusive.");
        synchronized (this.zzc) {
            if (this.zzd == null) {
                z12 = false;
            }
            Preconditions.checkState(z12, "MobileAds.initialize() must be called prior to setting the app volume.");
            try {
                this.zzd.zzp(f11);
            } catch (RemoteException e11) {
                zzciz.zzh("Unable to set app volume.", e11);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzt(@androidx.annotation.NonNull com.google.android.gms.ads.RequestConfiguration r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0004
            r0 = 1
            goto L_0x0005
        L_0x0004:
            r0 = 0
        L_0x0005:
            java.lang.String r1 = "Null passed to setRequestConfiguration."
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0, r1)
            java.lang.Object r0 = r4.zzc
            monitor-enter(r0)
            com.google.android.gms.ads.RequestConfiguration r1 = r4.zzh     // Catch:{ all -> 0x0030 }
            r4.zzh = r5     // Catch:{ all -> 0x0030 }
            com.google.android.gms.internal.ads.zzbib r2 = r4.zzd     // Catch:{ all -> 0x0030 }
            if (r2 != 0) goto L_0x0017
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0017:
            int r2 = r1.getTagForChildDirectedTreatment()     // Catch:{ all -> 0x0030 }
            int r3 = r5.getTagForChildDirectedTreatment()     // Catch:{ all -> 0x0030 }
            if (r2 != r3) goto L_0x002b
            int r1 = r1.getTagForUnderAgeOfConsent()     // Catch:{ all -> 0x0030 }
            int r2 = r5.getTagForUnderAgeOfConsent()     // Catch:{ all -> 0x0030 }
            if (r1 == r2) goto L_0x002e
        L_0x002b:
            r4.zzw(r5)     // Catch:{ all -> 0x0030 }
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0030:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbjq.zzt(com.google.android.gms.ads.RequestConfiguration):void");
    }

    public final boolean zzu() {
        boolean z11;
        synchronized (this.zzc) {
            zzbib zzbib = this.zzd;
            z11 = false;
            if (zzbib == null) {
                return false;
            }
            try {
                z11 = zzbib.zzt();
            } catch (RemoteException e11) {
                zzciz.zzh("Unable to get app mute state.", e11);
            }
        }
        return z11;
    }
}
