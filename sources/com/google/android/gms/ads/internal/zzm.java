package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ads.zzbew;
import com.google.android.gms.internal.ads.zzciz;
import com.google.android.gms.internal.ads.zzfey;

final class zzm extends WebViewClient {
    final /* synthetic */ zzs zza;

    public zzm(zzs zzs) {
        this.zza = zzs;
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (this.zza.zzg != null) {
            try {
                this.zza.zzg.zzf(zzfey.zzd(1, (String) null, (zzbew) null));
            } catch (RemoteException e11) {
                zzciz.zzl("#007 Could not call remote method.", e11);
            }
        }
        if (this.zza.zzg != null) {
            try {
                this.zza.zzg.zze(0);
            } catch (RemoteException e12) {
                zzciz.zzl("#007 Could not call remote method.", e12);
            }
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith(this.zza.zzq())) {
            return false;
        }
        if (str.startsWith("gmsg://noAdLoaded")) {
            if (this.zza.zzg != null) {
                try {
                    this.zza.zzg.zzf(zzfey.zzd(3, (String) null, (zzbew) null));
                } catch (RemoteException e11) {
                    zzciz.zzl("#007 Could not call remote method.", e11);
                }
            }
            if (this.zza.zzg != null) {
                try {
                    this.zza.zzg.zze(3);
                } catch (RemoteException e12) {
                    zzciz.zzl("#007 Could not call remote method.", e12);
                }
            }
            this.zza.zzV(0);
            return true;
        } else if (str.startsWith("gmsg://scriptLoadFailed")) {
            if (this.zza.zzg != null) {
                try {
                    this.zza.zzg.zzf(zzfey.zzd(1, (String) null, (zzbew) null));
                } catch (RemoteException e13) {
                    zzciz.zzl("#007 Could not call remote method.", e13);
                }
            }
            if (this.zza.zzg != null) {
                try {
                    this.zza.zzg.zze(0);
                } catch (RemoteException e14) {
                    zzciz.zzl("#007 Could not call remote method.", e14);
                }
            }
            this.zza.zzV(0);
            return true;
        } else if (str.startsWith("gmsg://adResized")) {
            if (this.zza.zzg != null) {
                try {
                    this.zza.zzg.zzi();
                } catch (RemoteException e15) {
                    zzciz.zzl("#007 Could not call remote method.", e15);
                }
            }
            this.zza.zzV(this.zza.zzb(str));
            return true;
        } else if (str.startsWith("gmsg://")) {
            return true;
        } else {
            if (this.zza.zzg != null) {
                try {
                    this.zza.zzg.zzc();
                    this.zza.zzg.zzh();
                } catch (RemoteException e16) {
                    zzciz.zzl("#007 Could not call remote method.", e16);
                }
            }
            zzs.zzw(this.zza, zzs.zzo(this.zza, str));
            return true;
        }
    }
}
