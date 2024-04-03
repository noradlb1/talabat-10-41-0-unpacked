package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.zza;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class zzbyl<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zzbxj {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zza;
    private final NETWORK_EXTRAS zzb;

    public zzbyl(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.zza = mediationAdapter;
        this.zzb = network_extras;
    }

    private final SERVER_PARAMETERS zzb(String str) throws RemoteException {
        HashMap hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            } catch (Throwable th2) {
                zzciz.zzh("", th2);
                throw new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class<SERVER_PARAMETERS> serverParametersType = this.zza.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        SERVER_PARAMETERS server_parameters = (MediationServerParameters) serverParametersType.newInstance();
        server_parameters.load(hashMap);
        return server_parameters;
    }

    private static final boolean zzc(zzbfd zzbfd) {
        if (zzbfd.zzf) {
            return true;
        }
        zzbgo.zzb();
        return zzcis.zzm();
    }

    public final void zzA(zzbfd zzbfd, String str, String str2) {
    }

    public final void zzB(IObjectWrapper iObjectWrapper, zzbfd zzbfd, String str, zzbxn zzbxn) throws RemoteException {
    }

    public final void zzC(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzD() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzE() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzF(boolean z11) {
    }

    public final void zzG() throws RemoteException {
        String str;
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zza;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            if (valueOf.length() != 0) {
                str = "Not a MediationInterstitialAdapter: ".concat(valueOf);
            } else {
                str = new String("Not a MediationInterstitialAdapter: ");
            }
            zzciz.zzj(str);
            throw new RemoteException();
        }
        zzciz.zze("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zza).showInterstitial();
        } catch (Throwable th2) {
            zzciz.zzh("", th2);
            throw new RemoteException();
        }
    }

    public final void zzH(IObjectWrapper iObjectWrapper) {
    }

    public final void zzI(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzJ() {
    }

    public final boolean zzK() {
        return false;
    }

    public final boolean zzL() {
        return true;
    }

    public final zzbxs zzM() {
        return null;
    }

    public final zzbxt zzN() {
        return null;
    }

    public final Bundle zze() {
        return new Bundle();
    }

    public final Bundle zzf() {
        return new Bundle();
    }

    public final Bundle zzg() {
        return new Bundle();
    }

    public final zzbiz zzh() {
        return null;
    }

    public final zzbpc zzi() {
        return null;
    }

    public final zzbxq zzj() {
        return null;
    }

    public final zzbxw zzk() {
        return null;
    }

    public final zzcab zzl() {
        return null;
    }

    public final zzcab zzm() {
        return null;
    }

    public final IObjectWrapper zzn() throws RemoteException {
        String str;
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zza;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            if (valueOf.length() != 0) {
                str = "Not a MediationBannerAdapter: ".concat(valueOf);
            } else {
                str = new String("Not a MediationBannerAdapter: ");
            }
            zzciz.zzj(str);
            throw new RemoteException();
        }
        try {
            return ObjectWrapper.wrap(((MediationBannerAdapter) mediationAdapter).getBannerView());
        } catch (Throwable th2) {
            zzciz.zzh("", th2);
            throw new RemoteException();
        }
    }

    public final void zzo() throws RemoteException {
        try {
            this.zza.destroy();
        } catch (Throwable th2) {
            zzciz.zzh("", th2);
            throw new RemoteException();
        }
    }

    public final void zzp(IObjectWrapper iObjectWrapper, zzbfd zzbfd, String str, zzcer zzcer, String str2) throws RemoteException {
    }

    public final void zzq(IObjectWrapper iObjectWrapper, zzbtr zzbtr, List<zzbtx> list) throws RemoteException {
    }

    public final void zzr(IObjectWrapper iObjectWrapper, zzcer zzcer, List<String> list) {
    }

    public final void zzs(zzbfd zzbfd, String str) {
    }

    public final void zzt(IObjectWrapper iObjectWrapper, zzbfi zzbfi, zzbfd zzbfd, String str, zzbxn zzbxn) throws RemoteException {
        zzu(iObjectWrapper, zzbfi, zzbfd, str, (String) null, zzbxn);
    }

    public final void zzu(IObjectWrapper iObjectWrapper, zzbfi zzbfi, zzbfd zzbfd, String str, String str2, zzbxn zzbxn) throws RemoteException {
        AdSize adSize;
        String str3;
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zza;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            if (valueOf.length() != 0) {
                str3 = "Not a MediationBannerAdapter: ".concat(valueOf);
            } else {
                str3 = new String("Not a MediationBannerAdapter: ");
            }
            zzciz.zzj(str3);
            throw new RemoteException();
        }
        zzciz.zze("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zza;
            zzbyx zzbyx = new zzbyx(zzbxn);
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
            MediationServerParameters zzb2 = zzb(str);
            int i11 = 0;
            AdSize[] adSizeArr = {AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
            while (true) {
                if (i11 < 6) {
                    if (adSizeArr[i11].getWidth() == zzbfi.zze && adSizeArr[i11].getHeight() == zzbfi.zzb) {
                        adSize = adSizeArr[i11];
                        break;
                    }
                    i11++;
                } else {
                    adSize = new AdSize(zza.zzc(zzbfi.zze, zzbfi.zzb, zzbfi.zza));
                    break;
                }
            }
            mediationBannerAdapter.requestBannerAd(zzbyx, activity, zzb2, adSize, zzbyy.zzb(zzbfd, zzc(zzbfd)), this.zzb);
        } catch (Throwable th2) {
            zzciz.zzh("", th2);
            throw new RemoteException();
        }
    }

    public final void zzv(IObjectWrapper iObjectWrapper, zzbfi zzbfi, zzbfd zzbfd, String str, String str2, zzbxn zzbxn) {
    }

    public final void zzw(IObjectWrapper iObjectWrapper, zzbfd zzbfd, String str, zzbxn zzbxn) throws RemoteException {
        zzx(iObjectWrapper, zzbfd, str, (String) null, zzbxn);
    }

    public final void zzx(IObjectWrapper iObjectWrapper, zzbfd zzbfd, String str, String str2, zzbxn zzbxn) throws RemoteException {
        String str3;
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zza;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            if (valueOf.length() != 0) {
                str3 = "Not a MediationInterstitialAdapter: ".concat(valueOf);
            } else {
                str3 = new String("Not a MediationInterstitialAdapter: ");
            }
            zzciz.zzj(str3);
            throw new RemoteException();
        }
        zzciz.zze("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zza).requestInterstitialAd(new zzbyx(zzbxn), (Activity) ObjectWrapper.unwrap(iObjectWrapper), zzb(str), zzbyy.zzb(zzbfd, zzc(zzbfd)), this.zzb);
        } catch (Throwable th2) {
            zzciz.zzh("", th2);
            throw new RemoteException();
        }
    }

    public final void zzy(IObjectWrapper iObjectWrapper, zzbfd zzbfd, String str, String str2, zzbxn zzbxn, zzbnw zzbnw, List<String> list) {
    }

    public final void zzz(IObjectWrapper iObjectWrapper, zzbfd zzbfd, String str, zzbxn zzbxn) throws RemoteException {
    }
}
