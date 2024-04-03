package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.zzb;
import com.google.android.gms.ads.zza;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbyg extends zzbxj {
    /* access modifiers changed from: private */
    public final Object zza;
    private zzbyi zzb;
    private zzcer zzc;
    private IObjectWrapper zzd;
    /* access modifiers changed from: private */
    public View zze;
    /* access modifiers changed from: private */
    public MediationInterstitialAd zzf;
    /* access modifiers changed from: private */
    public UnifiedNativeAdMapper zzg;
    /* access modifiers changed from: private */
    public MediationRewardedAd zzh;
    /* access modifiers changed from: private */
    public MediationInterscrollerAd zzi;
    private final String zzj = "";

    public zzbyg(@NonNull Adapter adapter) {
        this.zza = adapter;
    }

    private final Bundle zzR(zzbfd zzbfd) {
        Bundle bundle;
        Bundle bundle2 = zzbfd.zzm;
        if (bundle2 == null || (bundle = bundle2.getBundle(this.zza.getClass().getName())) == null) {
            return new Bundle();
        }
        return bundle;
    }

    private final Bundle zzS(String str, zzbfd zzbfd, String str2) throws RemoteException {
        String str3;
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str3 = "Server parameters: ".concat(valueOf);
        } else {
            str3 = new String("Server parameters: ");
        }
        zzciz.zze(str3);
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle2.putString(next, jSONObject.getString(next));
                }
                bundle = bundle2;
            }
            if (this.zza instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzbfd != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzbfd.zzg);
                }
            }
            bundle.remove("max_ad_content_rating");
            return bundle;
        } catch (Throwable th2) {
            zzciz.zzh("", th2);
            throw new RemoteException();
        }
    }

    private static final boolean zzT(zzbfd zzbfd) {
        if (zzbfd.zzf) {
            return true;
        }
        zzbgo.zzb();
        return zzcis.zzm();
    }

    @Nullable
    private static final String zzU(String str, zzbfd zzbfd) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return zzbfd.zzu;
        }
    }

    public final void zzA(zzbfd zzbfd, String str, String str2) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            zzz(this.zzd, zzbfd, str, new zzbyj((Adapter) obj, this.zzc));
            return;
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = this.zza.getClass().getCanonicalName();
        StringBuilder sb2 = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb2.append(canonicalName);
        sb2.append(" #009 Class mismatch: ");
        sb2.append(canonicalName2);
        zzciz.zzj(sb2.toString());
        throw new RemoteException();
    }

    public final void zzB(IObjectWrapper iObjectWrapper, zzbfd zzbfd, String str, zzbxn zzbxn) throws RemoteException {
        zzbfd zzbfd2 = zzbfd;
        String str2 = str;
        if (this.zza instanceof Adapter) {
            zzciz.zze("Requesting rewarded interstitial ad from adapter.");
            try {
                zzbyf zzbyf = new zzbyf(this, zzbxn);
                Bundle zzS = zzS(str2, zzbfd2, (String) null);
                Bundle zzR = zzR(zzbfd2);
                boolean zzT = zzT(zzbfd);
                Location location = zzbfd2.zzk;
                int i11 = zzbfd2.zzg;
                int i12 = zzbfd2.zzt;
                String zzU = zzU(str2, zzbfd2);
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration = r5;
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration2 = new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzS, zzR, zzT, location, i11, i12, zzU, "");
                ((Adapter) this.zza).loadRewardedInterstitialAd(mediationRewardedAdConfiguration, zzbyf);
            } catch (Exception e11) {
                zzciz.zzh("", e11);
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zza.getClass().getCanonicalName();
            StringBuilder sb2 = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb2.append(canonicalName);
            sb2.append(" #009 Class mismatch: ");
            sb2.append(canonicalName2);
            zzciz.zzj(sb2.toString());
            throw new RemoteException();
        }
    }

    public final void zzC(IObjectWrapper iObjectWrapper) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        Object obj = this.zza;
        if (obj instanceof OnContextChangedListener) {
            ((OnContextChangedListener) obj).onContextChanged(context);
        }
    }

    public final void zzD() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onPause();
            } catch (Throwable th2) {
                zzciz.zzh("", th2);
                throw new RemoteException();
            }
        }
    }

    public final void zzE() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onResume();
            } catch (Throwable th2) {
                zzciz.zzh("", th2);
                throw new RemoteException();
            }
        }
    }

    public final void zzF(boolean z11) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof OnImmersiveModeUpdatedListener) {
            try {
                ((OnImmersiveModeUpdatedListener) obj).onImmersiveModeUpdated(z11);
            } catch (Throwable th2) {
                zzciz.zzh("", th2);
            }
        } else {
            String canonicalName = OnImmersiveModeUpdatedListener.class.getCanonicalName();
            String canonicalName2 = this.zza.getClass().getCanonicalName();
            StringBuilder sb2 = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb2.append(canonicalName);
            sb2.append(" #009 Class mismatch: ");
            sb2.append(canonicalName2);
            zzciz.zze(sb2.toString());
        }
    }

    public final void zzG() throws RemoteException {
        if (this.zza instanceof MediationInterstitialAdapter) {
            zzciz.zze("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zza).showInterstitial();
            } catch (Throwable th2) {
                zzciz.zzh("", th2);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.zza.getClass().getCanonicalName();
            StringBuilder sb2 = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb2.append(canonicalName);
            sb2.append(" #009 Class mismatch: ");
            sb2.append(canonicalName2);
            zzciz.zzj(sb2.toString());
            throw new RemoteException();
        }
    }

    public final void zzH(IObjectWrapper iObjectWrapper) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof Adapter) && !(obj instanceof MediationInterstitialAdapter)) {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zza.getClass().getCanonicalName();
            int length = String.valueOf(canonicalName).length();
            StringBuilder sb2 = new StringBuilder(length + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb2.append(canonicalName);
            sb2.append(" or ");
            sb2.append(canonicalName2);
            sb2.append(" #009 Class mismatch: ");
            sb2.append(canonicalName3);
            zzciz.zzj(sb2.toString());
            throw new RemoteException();
        } else if (obj instanceof MediationInterstitialAdapter) {
            zzG();
        } else {
            zzciz.zze("Show interstitial ad from adapter.");
            MediationInterstitialAd mediationInterstitialAd = this.zzf;
            if (mediationInterstitialAd != null) {
                mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            } else {
                zzciz.zzg("Can not show null mediation interstitial ad.");
                throw new RemoteException();
            }
        }
    }

    public final void zzI(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zza instanceof Adapter) {
            zzciz.zze("Show rewarded ad from adapter.");
            MediationRewardedAd mediationRewardedAd = this.zzh;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            } else {
                zzciz.zzg("Can not show null mediation rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zza.getClass().getCanonicalName();
            StringBuilder sb2 = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb2.append(canonicalName);
            sb2.append(" #009 Class mismatch: ");
            sb2.append(canonicalName2);
            zzciz.zzj(sb2.toString());
            throw new RemoteException();
        }
    }

    public final void zzJ() throws RemoteException {
        if (this.zza instanceof Adapter) {
            MediationRewardedAd mediationRewardedAd = this.zzh;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(this.zzd));
            } else {
                zzciz.zzg("Can not show null mediated rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zza.getClass().getCanonicalName();
            StringBuilder sb2 = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb2.append(canonicalName);
            sb2.append(" #009 Class mismatch: ");
            sb2.append(canonicalName2);
            zzciz.zzj(sb2.toString());
            throw new RemoteException();
        }
    }

    public final boolean zzK() {
        return false;
    }

    public final boolean zzL() throws RemoteException {
        if (!(this.zza instanceof Adapter)) {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zza.getClass().getCanonicalName();
            StringBuilder sb2 = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb2.append(canonicalName);
            sb2.append(" #009 Class mismatch: ");
            sb2.append(canonicalName2);
            zzciz.zzj(sb2.toString());
            throw new RemoteException();
        } else if (this.zzc != null) {
            return true;
        } else {
            return false;
        }
    }

    public final zzbxs zzM() {
        return null;
    }

    public final zzbxt zzN() {
        return null;
    }

    public final Bundle zze() {
        Object obj = this.zza;
        if (obj instanceof zzcqk) {
            return ((zzcqk) obj).zza();
        }
        String canonicalName = zzcqk.class.getCanonicalName();
        String canonicalName2 = this.zza.getClass().getCanonicalName();
        StringBuilder sb2 = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb2.append(canonicalName);
        sb2.append(" #009 Class mismatch: ");
        sb2.append(canonicalName2);
        zzciz.zzj(sb2.toString());
        return new Bundle();
    }

    public final Bundle zzf() {
        Object obj = this.zza;
        if (obj instanceof zzcql) {
            return ((zzcql) obj).getInterstitialAdapterInfo();
        }
        String canonicalName = zzcql.class.getCanonicalName();
        String canonicalName2 = this.zza.getClass().getCanonicalName();
        StringBuilder sb2 = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb2.append(canonicalName);
        sb2.append(" #009 Class mismatch: ");
        sb2.append(canonicalName2);
        zzciz.zzj(sb2.toString());
        return new Bundle();
    }

    public final Bundle zzg() {
        return new Bundle();
    }

    public final zzbiz zzh() {
        Object obj = this.zza;
        if (obj instanceof zzb) {
            try {
                return ((zzb) obj).getVideoController();
            } catch (Throwable th2) {
                zzciz.zzh("", th2);
            }
        }
        return null;
    }

    public final zzbpc zzi() {
        zzbyi zzbyi = this.zzb;
        if (zzbyi == null) {
            return null;
        }
        NativeCustomTemplateAd zza2 = zzbyi.zza();
        if (zza2 instanceof zzbpd) {
            return ((zzbpd) zza2).zza();
        }
        return null;
    }

    public final zzbxq zzj() {
        MediationInterscrollerAd mediationInterscrollerAd = this.zzi;
        if (mediationInterscrollerAd != null) {
            return new zzbyh(mediationInterscrollerAd);
        }
        return null;
    }

    public final zzbxw zzk() {
        UnifiedNativeAdMapper unifiedNativeAdMapper;
        UnifiedNativeAdMapper zzb2;
        Object obj = this.zza;
        if (obj instanceof MediationNativeAdapter) {
            zzbyi zzbyi = this.zzb;
            if (zzbyi == null || (zzb2 = zzbyi.zzb()) == null) {
                return null;
            }
            return new zzbyz(zzb2);
        } else if (!(obj instanceof Adapter) || (unifiedNativeAdMapper = this.zzg) == null) {
            return null;
        } else {
            return new zzbyz(unifiedNativeAdMapper);
        }
    }

    public final zzcab zzl() {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            return null;
        }
        return zzcab.zza(((Adapter) obj).getVersionInfo());
    }

    public final zzcab zzm() {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            return null;
        }
        return zzcab.zza(((Adapter) obj).getSDKVersionInfo());
    }

    public final IObjectWrapper zzn() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationBannerAdapter) {
            try {
                return ObjectWrapper.wrap(((MediationBannerAdapter) obj).getBannerView());
            } catch (Throwable th2) {
                zzciz.zzh("", th2);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            return ObjectWrapper.wrap(this.zze);
        } else {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zza.getClass().getCanonicalName();
            int length = String.valueOf(canonicalName).length();
            StringBuilder sb2 = new StringBuilder(length + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb2.append(canonicalName);
            sb2.append(" or ");
            sb2.append(canonicalName2);
            sb2.append(" #009 Class mismatch: ");
            sb2.append(canonicalName3);
            zzciz.zzj(sb2.toString());
            throw new RemoteException();
        }
    }

    public final void zzo() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onDestroy();
            } catch (Throwable th2) {
                zzciz.zzh("", th2);
                throw new RemoteException();
            }
        }
    }

    public final void zzp(IObjectWrapper iObjectWrapper, zzbfd zzbfd, String str, zzcer zzcer, String str2) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            this.zzd = iObjectWrapper;
            this.zzc = zzcer;
            zzcer.zzl(ObjectWrapper.wrap(obj));
            return;
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = this.zza.getClass().getCanonicalName();
        StringBuilder sb2 = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb2.append(canonicalName);
        sb2.append(" #009 Class mismatch: ");
        sb2.append(canonicalName2);
        zzciz.zzj(sb2.toString());
        throw new RemoteException();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzq(com.google.android.gms.dynamic.IObjectWrapper r9, com.google.android.gms.internal.ads.zzbtr r10, java.util.List<com.google.android.gms.internal.ads.zzbtx> r11) throws android.os.RemoteException {
        /*
            r8 = this;
            java.lang.Object r0 = r8.zza
            boolean r0 = r0 instanceof com.google.android.gms.ads.mediation.Adapter
            if (r0 == 0) goto L_0x0096
            com.google.android.gms.internal.ads.zzbyb r0 = new com.google.android.gms.internal.ads.zzbyb
            r0.<init>(r8, r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Iterator r11 = r11.iterator()
        L_0x0014:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto L_0x0088
            java.lang.Object r1 = r11.next()
            com.google.android.gms.internal.ads.zzbtx r1 = (com.google.android.gms.internal.ads.zzbtx) r1
            java.lang.String r2 = r1.zza
            int r3 = r2.hashCode()
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            switch(r3) {
                case -1396342996: goto L_0x0056;
                case -1052618729: goto L_0x004c;
                case -239580146: goto L_0x0042;
                case 604727084: goto L_0x0038;
                case 1911491517: goto L_0x002e;
                default: goto L_0x002d;
            }
        L_0x002d:
            goto L_0x0060
        L_0x002e:
            java.lang.String r3 = "rewarded_interstitial"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0060
            r2 = r5
            goto L_0x0061
        L_0x0038:
            java.lang.String r3 = "interstitial"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0060
            r2 = r7
            goto L_0x0061
        L_0x0042:
            java.lang.String r3 = "rewarded"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0060
            r2 = r6
            goto L_0x0061
        L_0x004c:
            java.lang.String r3 = "native"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0060
            r2 = r4
            goto L_0x0061
        L_0x0056:
            java.lang.String r3 = "banner"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0060
            r2 = 0
            goto L_0x0061
        L_0x0060:
            r2 = -1
        L_0x0061:
            if (r2 == 0) goto L_0x0079
            if (r2 == r7) goto L_0x0076
            if (r2 == r6) goto L_0x0073
            if (r2 == r5) goto L_0x0070
            if (r2 == r4) goto L_0x006d
            r2 = 0
            goto L_0x007b
        L_0x006d:
            com.google.android.gms.ads.AdFormat r2 = com.google.android.gms.ads.AdFormat.NATIVE
            goto L_0x007b
        L_0x0070:
            com.google.android.gms.ads.AdFormat r2 = com.google.android.gms.ads.AdFormat.REWARDED_INTERSTITIAL
            goto L_0x007b
        L_0x0073:
            com.google.android.gms.ads.AdFormat r2 = com.google.android.gms.ads.AdFormat.REWARDED
            goto L_0x007b
        L_0x0076:
            com.google.android.gms.ads.AdFormat r2 = com.google.android.gms.ads.AdFormat.INTERSTITIAL
            goto L_0x007b
        L_0x0079:
            com.google.android.gms.ads.AdFormat r2 = com.google.android.gms.ads.AdFormat.BANNER
        L_0x007b:
            if (r2 == 0) goto L_0x0014
            com.google.android.gms.ads.mediation.MediationConfiguration r3 = new com.google.android.gms.ads.mediation.MediationConfiguration
            android.os.Bundle r1 = r1.zzb
            r3.<init>(r2, r1)
            r10.add(r3)
            goto L_0x0014
        L_0x0088:
            java.lang.Object r11 = r8.zza
            com.google.android.gms.ads.mediation.Adapter r11 = (com.google.android.gms.ads.mediation.Adapter) r11
            java.lang.Object r9 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r9)
            android.content.Context r9 = (android.content.Context) r9
            r11.initialize(r9, r0, r10)
            return
        L_0x0096:
            android.os.RemoteException r9 = new android.os.RemoteException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbyg.zzq(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.ads.zzbtr, java.util.List):void");
    }

    public final void zzr(IObjectWrapper iObjectWrapper, zzcer zzcer, List<String> list) throws RemoteException {
        zzciz.zzj("Could not initialize rewarded video adapter.");
        throw new RemoteException();
    }

    public final void zzs(zzbfd zzbfd, String str) throws RemoteException {
        zzA(zzbfd, str, (String) null);
    }

    public final void zzt(IObjectWrapper iObjectWrapper, zzbfi zzbfi, zzbfd zzbfd, String str, zzbxn zzbxn) throws RemoteException {
        zzu(iObjectWrapper, zzbfi, zzbfd, str, (String) null, zzbxn);
    }

    public final void zzu(IObjectWrapper iObjectWrapper, zzbfi zzbfi, zzbfd zzbfd, String str, String str2, zzbxn zzbxn) throws RemoteException {
        AdSize adSize;
        HashSet hashSet;
        Date date;
        Bundle bundle;
        zzbfi zzbfi2 = zzbfi;
        zzbfd zzbfd2 = zzbfd;
        String str3 = str;
        String str4 = str2;
        zzbxn zzbxn2 = zzbxn;
        Object obj = this.zza;
        if ((obj instanceof MediationBannerAdapter) || (obj instanceof Adapter)) {
            zzciz.zze("Requesting banner ad from adapter.");
            if (zzbfi2.zzn) {
                adSize = zza.zzd(zzbfi2.zze, zzbfi2.zzb);
            } else {
                adSize = zza.zzc(zzbfi2.zze, zzbfi2.zzb, zzbfi2.zza);
            }
            AdSize adSize2 = adSize;
            Object obj2 = this.zza;
            if (obj2 instanceof MediationBannerAdapter) {
                try {
                    MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) obj2;
                    List<String> list = zzbfd2.zze;
                    if (list != null) {
                        hashSet = new HashSet(list);
                    } else {
                        hashSet = null;
                    }
                    long j11 = zzbfd2.zzb;
                    if (j11 == -1) {
                        date = null;
                    } else {
                        date = new Date(j11);
                    }
                    zzbxz zzbxz = new zzbxz(date, zzbfd2.zzd, hashSet, zzbfd2.zzk, zzT(zzbfd), zzbfd2.zzg, zzbfd2.zzr, zzbfd2.zzt, zzU(str3, zzbfd2));
                    Bundle bundle2 = zzbfd2.zzm;
                    if (bundle2 != null) {
                        bundle = bundle2.getBundle(mediationBannerAdapter.getClass().getName());
                    } else {
                        bundle = null;
                    }
                    mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzbyi(zzbxn2), zzS(str3, zzbfd2, str4), adSize2, zzbxz, bundle);
                } catch (Throwable th2) {
                    zzciz.zzh("", th2);
                    throw new RemoteException();
                }
            } else if (obj2 instanceof Adapter) {
                try {
                    zzbyc zzbyc = new zzbyc(this, zzbxn2);
                    Bundle zzS = zzS(str3, zzbfd2, str4);
                    Bundle zzR = zzR(zzbfd2);
                    boolean zzT = zzT(zzbfd);
                    Location location = zzbfd2.zzk;
                    int i11 = zzbfd2.zzg;
                    int i12 = zzbfd2.zzt;
                    String zzU = zzU(str3, zzbfd2);
                    String str5 = this.zzj;
                    MediationBannerAdConfiguration mediationBannerAdConfiguration = r2;
                    MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzS, zzR, zzT, location, i11, i12, zzU, adSize2, str5);
                    ((Adapter) obj2).loadBannerAd(mediationBannerAdConfiguration, zzbyc);
                } catch (Throwable th3) {
                    zzciz.zzh("", th3);
                    throw new RemoteException();
                }
            }
        } else {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zza.getClass().getCanonicalName();
            StringBuilder sb2 = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb2.append(canonicalName);
            sb2.append(" or ");
            sb2.append(canonicalName2);
            sb2.append(" #009 Class mismatch: ");
            sb2.append(canonicalName3);
            zzciz.zzj(sb2.toString());
            throw new RemoteException();
        }
    }

    public final void zzv(IObjectWrapper iObjectWrapper, zzbfi zzbfi, zzbfd zzbfd, String str, String str2, zzbxn zzbxn) throws RemoteException {
        zzbfi zzbfi2 = zzbfi;
        zzbfd zzbfd2 = zzbfd;
        String str3 = str;
        if (this.zza instanceof Adapter) {
            zzciz.zze("Requesting interscroller ad from adapter.");
            try {
                Adapter adapter = (Adapter) this.zza;
                zzbya zzbya = new zzbya(this, zzbxn, adapter);
                Bundle zzS = zzS(str3, zzbfd2, str2);
                Bundle zzR = zzR(zzbfd2);
                boolean zzT = zzT(zzbfd);
                Location location = zzbfd2.zzk;
                int i11 = zzbfd2.zzg;
                int i12 = zzbfd2.zzt;
                String zzU = zzU(str3, zzbfd2);
                AdSize zze2 = zza.zze(zzbfi2.zze, zzbfi2.zzb);
                MediationBannerAdConfiguration mediationBannerAdConfiguration = r6;
                MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzS, zzR, zzT, location, i11, i12, zzU, zze2, "");
                adapter.loadInterscrollerAd(mediationBannerAdConfiguration, zzbya);
            } catch (Exception e11) {
                zzciz.zzh("", e11);
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zza.getClass().getCanonicalName();
            StringBuilder sb2 = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb2.append(canonicalName);
            sb2.append(" #009 Class mismatch: ");
            sb2.append(canonicalName2);
            zzciz.zzj(sb2.toString());
            throw new RemoteException();
        }
    }

    public final void zzw(IObjectWrapper iObjectWrapper, zzbfd zzbfd, String str, zzbxn zzbxn) throws RemoteException {
        zzx(iObjectWrapper, zzbfd, str, (String) null, zzbxn);
    }

    public final void zzx(IObjectWrapper iObjectWrapper, zzbfd zzbfd, String str, String str2, zzbxn zzbxn) throws RemoteException {
        HashSet hashSet;
        Date date;
        Bundle bundle;
        zzbfd zzbfd2 = zzbfd;
        String str3 = str;
        String str4 = str2;
        zzbxn zzbxn2 = zzbxn;
        Object obj = this.zza;
        if ((obj instanceof MediationInterstitialAdapter) || (obj instanceof Adapter)) {
            zzciz.zze("Requesting interstitial ad from adapter.");
            Object obj2 = this.zza;
            if (obj2 instanceof MediationInterstitialAdapter) {
                try {
                    MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) obj2;
                    List<String> list = zzbfd2.zze;
                    if (list != null) {
                        hashSet = new HashSet(list);
                    } else {
                        hashSet = null;
                    }
                    long j11 = zzbfd2.zzb;
                    if (j11 == -1) {
                        date = null;
                    } else {
                        date = new Date(j11);
                    }
                    int i11 = zzbfd2.zzd;
                    Location location = zzbfd2.zzk;
                    boolean zzT = zzT(zzbfd);
                    int i12 = zzbfd2.zzg;
                    boolean z11 = zzbfd2.zzr;
                    int i13 = i12;
                    zzbxz zzbxz = new zzbxz(date, i11, hashSet, location, zzT, i13, z11, zzbfd2.zzt, zzU(str3, zzbfd2));
                    Bundle bundle2 = zzbfd2.zzm;
                    if (bundle2 != null) {
                        bundle = bundle2.getBundle(mediationInterstitialAdapter.getClass().getName());
                    } else {
                        bundle = null;
                    }
                    mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzbyi(zzbxn2), zzS(str3, zzbfd2, str4), zzbxz, bundle);
                } catch (Throwable th2) {
                    zzciz.zzh("", th2);
                    throw new RemoteException();
                }
            } else if (obj2 instanceof Adapter) {
                try {
                    ((Adapter) obj2).loadInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzS(str3, zzbfd2, str4), zzR(zzbfd2), zzT(zzbfd), zzbfd2.zzk, zzbfd2.zzg, zzbfd2.zzt, zzU(str3, zzbfd2), this.zzj), new zzbyd(this, zzbxn2));
                } catch (Throwable th3) {
                    zzciz.zzh("", th3);
                    throw new RemoteException();
                }
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zza.getClass().getCanonicalName();
            int length = String.valueOf(canonicalName).length();
            StringBuilder sb2 = new StringBuilder(length + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb2.append(canonicalName);
            sb2.append(" or ");
            sb2.append(canonicalName2);
            sb2.append(" #009 Class mismatch: ");
            sb2.append(canonicalName3);
            zzciz.zzj(sb2.toString());
            throw new RemoteException();
        }
    }

    public final void zzy(IObjectWrapper iObjectWrapper, zzbfd zzbfd, String str, String str2, zzbxn zzbxn, zzbnw zzbnw, List<String> list) throws RemoteException {
        HashSet hashSet;
        Date date;
        Bundle bundle;
        zzbfd zzbfd2 = zzbfd;
        String str3 = str;
        String str4 = str2;
        zzbxn zzbxn2 = zzbxn;
        Object obj = this.zza;
        if ((obj instanceof MediationNativeAdapter) || (obj instanceof Adapter)) {
            zzciz.zze("Requesting native ad from adapter.");
            Object obj2 = this.zza;
            if (obj2 instanceof MediationNativeAdapter) {
                try {
                    MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) obj2;
                    List<String> list2 = zzbfd2.zze;
                    if (list2 != null) {
                        hashSet = new HashSet(list2);
                    } else {
                        hashSet = null;
                    }
                    long j11 = zzbfd2.zzb;
                    if (j11 == -1) {
                        date = null;
                    } else {
                        date = new Date(j11);
                    }
                    int i11 = zzbfd2.zzd;
                    Location location = zzbfd2.zzk;
                    boolean zzT = zzT(zzbfd);
                    int i12 = zzbfd2.zzg;
                    boolean z11 = zzbfd2.zzr;
                    int i13 = i12;
                    zzbnw zzbnw2 = zzbnw;
                    List<String> list3 = list;
                    zzbyk zzbyk = new zzbyk(date, i11, hashSet, location, zzT, i13, zzbnw2, list3, z11, zzbfd2.zzt, zzU(str3, zzbfd2));
                    Bundle bundle2 = zzbfd2.zzm;
                    if (bundle2 != null) {
                        bundle = bundle2.getBundle(mediationNativeAdapter.getClass().getName());
                    } else {
                        bundle = null;
                    }
                    this.zzb = new zzbyi(zzbxn2);
                    mediationNativeAdapter.requestNativeAd((Context) ObjectWrapper.unwrap(iObjectWrapper), this.zzb, zzS(str3, zzbfd2, str4), zzbyk, bundle);
                } catch (Throwable th2) {
                    zzciz.zzh("", th2);
                    throw new RemoteException();
                }
            } else if (obj2 instanceof Adapter) {
                try {
                    ((Adapter) obj2).loadNativeAd(new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzS(str3, zzbfd2, str4), zzR(zzbfd2), zzT(zzbfd), zzbfd2.zzk, zzbfd2.zzg, zzbfd2.zzt, zzU(str3, zzbfd2), this.zzj, zzbnw), new zzbye(this, zzbxn2));
                } catch (Throwable th3) {
                    zzciz.zzh("", th3);
                    throw new RemoteException();
                }
            }
        } else {
            String canonicalName = MediationNativeAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zza.getClass().getCanonicalName();
            int length = String.valueOf(canonicalName).length();
            StringBuilder sb2 = new StringBuilder(length + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb2.append(canonicalName);
            sb2.append(" or ");
            sb2.append(canonicalName2);
            sb2.append(" #009 Class mismatch: ");
            sb2.append(canonicalName3);
            zzciz.zzj(sb2.toString());
            throw new RemoteException();
        }
    }

    public final void zzz(IObjectWrapper iObjectWrapper, zzbfd zzbfd, String str, zzbxn zzbxn) throws RemoteException {
        zzbfd zzbfd2 = zzbfd;
        String str2 = str;
        if (this.zza instanceof Adapter) {
            zzciz.zze("Requesting rewarded ad from adapter.");
            try {
                zzbyf zzbyf = new zzbyf(this, zzbxn);
                Bundle zzS = zzS(str2, zzbfd2, (String) null);
                Bundle zzR = zzR(zzbfd2);
                boolean zzT = zzT(zzbfd);
                Location location = zzbfd2.zzk;
                int i11 = zzbfd2.zzg;
                int i12 = zzbfd2.zzt;
                String zzU = zzU(str2, zzbfd2);
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration = r5;
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration2 = new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzS, zzR, zzT, location, i11, i12, zzU, "");
                ((Adapter) this.zza).loadRewardedAd(mediationRewardedAdConfiguration, zzbyf);
            } catch (Exception e11) {
                zzciz.zzh("", e11);
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zza.getClass().getCanonicalName();
            StringBuilder sb2 = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb2.append(canonicalName);
            sb2.append(" #009 Class mismatch: ");
            sb2.append(canonicalName2);
            zzciz.zzj(sb2.toString());
            throw new RemoteException();
        }
    }

    public zzbyg(@NonNull MediationAdapter mediationAdapter) {
        this.zza = mediationAdapter;
    }
}
