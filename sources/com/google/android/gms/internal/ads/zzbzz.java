package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.zzb;
import com.google.android.gms.ads.zza;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbzz extends zzbzn {
    private final RtbAdapter zza;
    /* access modifiers changed from: private */
    public MediationInterstitialAd zzb;
    /* access modifiers changed from: private */
    public MediationRewardedAd zzc;
    private String zzd = "";

    public zzbzz(RtbAdapter rtbAdapter) {
        this.zza = rtbAdapter;
    }

    private final Bundle zzs(zzbfd zzbfd) {
        Bundle bundle;
        Bundle bundle2 = zzbfd.zzm;
        if (bundle2 == null || (bundle = bundle2.getBundle(this.zza.getClass().getName())) == null) {
            return new Bundle();
        }
        return bundle;
    }

    private static final Bundle zzt(String str) throws RemoteException {
        String str2;
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "Server parameters: ".concat(valueOf);
        } else {
            str2 = new String("Server parameters: ");
        }
        zzciz.zzj(str2);
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            return bundle2;
        } catch (JSONException e11) {
            zzciz.zzh("", e11);
            throw new RemoteException();
        }
    }

    private static final boolean zzu(zzbfd zzbfd) {
        if (zzbfd.zzf) {
            return true;
        }
        zzbgo.zzb();
        return zzcis.zzm();
    }

    @Nullable
    private static final String zzv(String str, zzbfd zzbfd) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return zzbfd.zzu;
        }
    }

    public final zzbiz zze() {
        RtbAdapter rtbAdapter = this.zza;
        if (rtbAdapter instanceof zzb) {
            try {
                return ((zzb) rtbAdapter).getVideoController();
            } catch (Throwable th2) {
                zzciz.zzh("", th2);
            }
        }
        return null;
    }

    public final zzcab zzf() throws RemoteException {
        return zzcab.zza(this.zza.getVersionInfo());
    }

    public final zzcab zzg() throws RemoteException {
        return zzcab.zza(this.zza.getSDKVersionInfo());
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(com.google.android.gms.dynamic.IObjectWrapper r8, java.lang.String r9, android.os.Bundle r10, android.os.Bundle r11, com.google.android.gms.internal.ads.zzbfi r12, com.google.android.gms.internal.ads.zzbzr r13) throws android.os.RemoteException {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzbzx r0 = new com.google.android.gms.internal.ads.zzbzx     // Catch:{ all -> 0x008c }
            r0.<init>(r7, r13)     // Catch:{ all -> 0x008c }
            com.google.android.gms.ads.mediation.rtb.RtbAdapter r13 = r7.zza     // Catch:{ all -> 0x008c }
            com.google.android.gms.ads.mediation.MediationConfiguration r1 = new com.google.android.gms.ads.mediation.MediationConfiguration     // Catch:{ all -> 0x008c }
            int r2 = r9.hashCode()     // Catch:{ all -> 0x008c }
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r2) {
                case -1396342996: goto L_0x003d;
                case -1052618729: goto L_0x0033;
                case -239580146: goto L_0x0029;
                case 604727084: goto L_0x001f;
                case 1911491517: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0047
        L_0x0015:
            java.lang.String r2 = "rewarded_interstitial"
            boolean r9 = r9.equals(r2)
            if (r9 == 0) goto L_0x0047
            r9 = r4
            goto L_0x0048
        L_0x001f:
            java.lang.String r2 = "interstitial"
            boolean r9 = r9.equals(r2)
            if (r9 == 0) goto L_0x0047
            r9 = r6
            goto L_0x0048
        L_0x0029:
            java.lang.String r2 = "rewarded"
            boolean r9 = r9.equals(r2)
            if (r9 == 0) goto L_0x0047
            r9 = r5
            goto L_0x0048
        L_0x0033:
            java.lang.String r2 = "native"
            boolean r9 = r9.equals(r2)
            if (r9 == 0) goto L_0x0047
            r9 = r3
            goto L_0x0048
        L_0x003d:
            java.lang.String r2 = "banner"
            boolean r9 = r9.equals(r2)
            if (r9 == 0) goto L_0x0047
            r9 = 0
            goto L_0x0048
        L_0x0047:
            r9 = -1
        L_0x0048:
            if (r9 == 0) goto L_0x0066
            if (r9 == r6) goto L_0x0063
            if (r9 == r5) goto L_0x0060
            if (r9 == r4) goto L_0x005d
            if (r9 != r3) goto L_0x0055
            com.google.android.gms.ads.AdFormat r9 = com.google.android.gms.ads.AdFormat.NATIVE     // Catch:{ all -> 0x008c }
            goto L_0x0068
        L_0x0055:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x008c }
            java.lang.String r9 = "Internal Error"
            r8.<init>(r9)     // Catch:{ all -> 0x008c }
            throw r8     // Catch:{ all -> 0x008c }
        L_0x005d:
            com.google.android.gms.ads.AdFormat r9 = com.google.android.gms.ads.AdFormat.REWARDED_INTERSTITIAL     // Catch:{ all -> 0x008c }
            goto L_0x0068
        L_0x0060:
            com.google.android.gms.ads.AdFormat r9 = com.google.android.gms.ads.AdFormat.REWARDED     // Catch:{ all -> 0x008c }
            goto L_0x0068
        L_0x0063:
            com.google.android.gms.ads.AdFormat r9 = com.google.android.gms.ads.AdFormat.INTERSTITIAL     // Catch:{ all -> 0x008c }
            goto L_0x0068
        L_0x0066:
            com.google.android.gms.ads.AdFormat r9 = com.google.android.gms.ads.AdFormat.BANNER     // Catch:{ all -> 0x008c }
        L_0x0068:
            r1.<init>(r9, r11)     // Catch:{ all -> 0x008c }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x008c }
            r9.<init>()     // Catch:{ all -> 0x008c }
            r9.add(r1)     // Catch:{ all -> 0x008c }
            com.google.android.gms.ads.mediation.rtb.RtbSignalData r11 = new com.google.android.gms.ads.mediation.rtb.RtbSignalData     // Catch:{ all -> 0x008c }
            java.lang.Object r8 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r8)     // Catch:{ all -> 0x008c }
            android.content.Context r8 = (android.content.Context) r8     // Catch:{ all -> 0x008c }
            int r1 = r12.zze     // Catch:{ all -> 0x008c }
            int r2 = r12.zzb     // Catch:{ all -> 0x008c }
            java.lang.String r12 = r12.zza     // Catch:{ all -> 0x008c }
            com.google.android.gms.ads.AdSize r12 = com.google.android.gms.ads.zza.zzc(r1, r2, r12)     // Catch:{ all -> 0x008c }
            r11.<init>(r8, r9, r10, r12)     // Catch:{ all -> 0x008c }
            r13.collectSignals(r11, r0)     // Catch:{ all -> 0x008c }
            return
        L_0x008c:
            r8 = move-exception
            java.lang.String r9 = "Error generating signals for RTB"
            com.google.android.gms.internal.ads.zzciz.zzh(r9, r8)
            android.os.RemoteException r8 = new android.os.RemoteException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbzz.zzh(com.google.android.gms.dynamic.IObjectWrapper, java.lang.String, android.os.Bundle, android.os.Bundle, com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbzr):void");
    }

    public final void zzi(String str, String str2, zzbfd zzbfd, IObjectWrapper iObjectWrapper, zzbzc zzbzc, zzbxn zzbxn, zzbfi zzbfi) throws RemoteException {
        zzbfd zzbfd2 = zzbfd;
        zzbfi zzbfi2 = zzbfi;
        try {
            zzbzt zzbzt = new zzbzt(this, zzbzc, zzbxn);
            RtbAdapter rtbAdapter = this.zza;
            Bundle zzt = zzt(str2);
            Bundle zzs = zzs(zzbfd2);
            boolean zzu = zzu(zzbfd);
            Location location = zzbfd2.zzk;
            int i11 = zzbfd2.zzg;
            int i12 = zzbfd2.zzt;
            String zzv = zzv(str2, zzbfd);
            AdSize zzc2 = zza.zzc(zzbfi2.zze, zzbfi2.zzb, zzbfi2.zza);
            String str3 = this.zzd;
            MediationBannerAdConfiguration mediationBannerAdConfiguration = r5;
            MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzt, zzs, zzu, location, i11, i12, zzv, zzc2, str3);
            rtbAdapter.loadRtbBannerAd(mediationBannerAdConfiguration, zzbzt);
        } catch (Throwable th2) {
            zzciz.zzh("Adapter failed to render banner ad.", th2);
            throw new RemoteException();
        }
    }

    public final void zzj(String str, String str2, zzbfd zzbfd, IObjectWrapper iObjectWrapper, zzbzc zzbzc, zzbxn zzbxn, zzbfi zzbfi) throws RemoteException {
        zzbfd zzbfd2 = zzbfd;
        zzbfi zzbfi2 = zzbfi;
        try {
            zzbzu zzbzu = new zzbzu(this, zzbzc, zzbxn);
            RtbAdapter rtbAdapter = this.zza;
            Bundle zzt = zzt(str2);
            Bundle zzs = zzs(zzbfd2);
            boolean zzu = zzu(zzbfd);
            Location location = zzbfd2.zzk;
            int i11 = zzbfd2.zzg;
            int i12 = zzbfd2.zzt;
            String zzv = zzv(str2, zzbfd);
            AdSize zzc2 = zza.zzc(zzbfi2.zze, zzbfi2.zzb, zzbfi2.zza);
            String str3 = this.zzd;
            MediationBannerAdConfiguration mediationBannerAdConfiguration = r5;
            MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzt, zzs, zzu, location, i11, i12, zzv, zzc2, str3);
            rtbAdapter.loadRtbInterscrollerAd(mediationBannerAdConfiguration, zzbzu);
        } catch (Throwable th2) {
            zzciz.zzh("Adapter failed to render interscroller ad.", th2);
            throw new RemoteException();
        }
    }

    public final void zzk(String str, String str2, zzbfd zzbfd, IObjectWrapper iObjectWrapper, zzbzf zzbzf, zzbxn zzbxn) throws RemoteException {
        zzbfd zzbfd2 = zzbfd;
        try {
            this.zza.loadRtbInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzt(str2), zzs(zzbfd2), zzu(zzbfd), zzbfd2.zzk, zzbfd2.zzg, zzbfd2.zzt, zzv(str2, zzbfd), this.zzd), new zzbzv(this, zzbzf, zzbxn));
        } catch (Throwable th2) {
            zzciz.zzh("Adapter failed to render interstitial ad.", th2);
            throw new RemoteException();
        }
    }

    public final void zzl(String str, String str2, zzbfd zzbfd, IObjectWrapper iObjectWrapper, zzbzi zzbzi, zzbxn zzbxn) throws RemoteException {
        zzm(str, str2, zzbfd, iObjectWrapper, zzbzi, zzbxn, (zzbnw) null);
    }

    public final void zzm(String str, String str2, zzbfd zzbfd, IObjectWrapper iObjectWrapper, zzbzi zzbzi, zzbxn zzbxn, zzbnw zzbnw) throws RemoteException {
        zzbfd zzbfd2 = zzbfd;
        try {
            zzbzw zzbzw = new zzbzw(this, zzbzi, zzbxn);
            RtbAdapter rtbAdapter = this.zza;
            MediationNativeAdConfiguration mediationNativeAdConfiguration = r4;
            MediationNativeAdConfiguration mediationNativeAdConfiguration2 = new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzt(str2), zzs(zzbfd2), zzu(zzbfd), zzbfd2.zzk, zzbfd2.zzg, zzbfd2.zzt, zzv(str2, zzbfd), this.zzd, zzbnw);
            rtbAdapter.loadRtbNativeAd(mediationNativeAdConfiguration, zzbzw);
        } catch (Throwable th2) {
            zzciz.zzh("Adapter failed to render native ad.", th2);
            throw new RemoteException();
        }
    }

    public final void zzn(String str, String str2, zzbfd zzbfd, IObjectWrapper iObjectWrapper, zzbzl zzbzl, zzbxn zzbxn) throws RemoteException {
        zzbfd zzbfd2 = zzbfd;
        try {
            this.zza.loadRtbRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzt(str2), zzs(zzbfd2), zzu(zzbfd), zzbfd2.zzk, zzbfd2.zzg, zzbfd2.zzt, zzv(str2, zzbfd), this.zzd), new zzbzy(this, zzbzl, zzbxn));
        } catch (Throwable th2) {
            zzciz.zzh("Adapter failed to render rewarded interstitial ad.", th2);
            throw new RemoteException();
        }
    }

    public final void zzo(String str, String str2, zzbfd zzbfd, IObjectWrapper iObjectWrapper, zzbzl zzbzl, zzbxn zzbxn) throws RemoteException {
        zzbfd zzbfd2 = zzbfd;
        try {
            this.zza.loadRtbRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzt(str2), zzs(zzbfd2), zzu(zzbfd), zzbfd2.zzk, zzbfd2.zzg, zzbfd2.zzt, zzv(str2, zzbfd), this.zzd), new zzbzy(this, zzbzl, zzbxn));
        } catch (Throwable th2) {
            zzciz.zzh("Adapter failed to render rewarded ad.", th2);
            throw new RemoteException();
        }
    }

    public final void zzp(String str) {
        this.zzd = str;
    }

    public final boolean zzq(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationInterstitialAd mediationInterstitialAd = this.zzb;
        if (mediationInterstitialAd == null) {
            return false;
        }
        try {
            mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th2) {
            zzciz.zzh("", th2);
            return true;
        }
    }

    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationRewardedAd mediationRewardedAd = this.zzc;
        if (mediationRewardedAd == null) {
            return false;
        }
        try {
            mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th2) {
            zzciz.zzh("", th2);
            return true;
        }
    }
}
