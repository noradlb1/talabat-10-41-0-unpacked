package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsCallback;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.zzt;
import java.util.regex.Pattern;

public final class zzefp implements zzdjm, zzbes, zzdfl, zzdev {
    private final Context zza;
    private final zzfer zzb;
    private final zzfdz zzc;
    private final zzfdn zzd;
    private final zzehh zze;
    @Nullable
    private Boolean zzf;
    private final boolean zzg = ((Boolean) zzbgq.zzc().zzb(zzblj.zzfj)).booleanValue();
    @NonNull
    private final zzfio zzh;
    private final String zzi;

    public zzefp(Context context, zzfer zzfer, zzfdz zzfdz, zzfdn zzfdn, zzehh zzehh, @NonNull zzfio zzfio, String str) {
        this.zza = context;
        this.zzb = zzfer;
        this.zzc = zzfdz;
        this.zzd = zzfdn;
        this.zze = zzehh;
        this.zzh = zzfio;
        this.zzi = str;
    }

    private final zzfin zzf(String str) {
        String str2;
        zzfin zzb2 = zzfin.zzb(str);
        zzb2.zzh(this.zzc, (zzcio) null);
        zzb2.zzf(this.zzd);
        zzb2.zza("request_id", this.zzi);
        if (!this.zzd.zzu.isEmpty()) {
            zzb2.zza("ancn", this.zzd.zzu.get(0));
        }
        if (this.zzd.zzag) {
            zzt.zzp();
            if (true != com.google.android.gms.ads.internal.util.zzt.zzJ(this.zza)) {
                str2 = "offline";
            } else {
                str2 = CustomTabsCallback.ONLINE_EXTRAS_KEY;
            }
            zzb2.zza("device_connectivity", str2);
            zzb2.zza("event_timestamp", String.valueOf(zzt.zzA().currentTimeMillis()));
            zzb2.zza("offline_ad", "1");
        }
        return zzb2;
    }

    private final void zzg(zzfin zzfin) {
        if (this.zzd.zzag) {
            this.zze.zzd(new zzehj(zzt.zzA().currentTimeMillis(), this.zzc.zzb.zzb.zzb, this.zzh.zza(zzfin), 2));
            return;
        }
        this.zzh.zzb(zzfin);
    }

    private final boolean zzh() {
        if (this.zzf == null) {
            synchronized (this) {
                if (this.zzf == null) {
                    String str = (String) zzbgq.zzc().zzb(zzblj.zzbe);
                    zzt.zzp();
                    String zzv = com.google.android.gms.ads.internal.util.zzt.zzv(this.zza);
                    boolean z11 = false;
                    if (!(str == null || zzv == null)) {
                        try {
                            z11 = Pattern.matches(str, zzv);
                        } catch (RuntimeException e11) {
                            zzt.zzo().zzs(e11, "CsiActionsListener.isPatternMatched");
                        }
                    }
                    this.zzf = Boolean.valueOf(z11);
                }
            }
        }
        return this.zzf.booleanValue();
    }

    public final void onAdClicked() {
        if (this.zzd.zzag) {
            zzg(zzf("click"));
        }
    }

    public final void zza(zzbew zzbew) {
        zzbew zzbew2;
        if (this.zzg) {
            int i11 = zzbew.zza;
            String str = zzbew.zzb;
            if (zzbew.zzc.equals(MobileAds.ERROR_DOMAIN) && (zzbew2 = zzbew.zzd) != null && !zzbew2.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                zzbew zzbew3 = zzbew.zzd;
                i11 = zzbew3.zza;
                str = zzbew3.zzb;
            }
            String zza2 = this.zzb.zza(str);
            zzfin zzf2 = zzf("ifts");
            zzf2.zza("reason", "adapter");
            if (i11 >= 0) {
                zzf2.zza("arec", String.valueOf(i11));
            }
            if (zza2 != null) {
                zzf2.zza("areec", zza2);
            }
            this.zzh.zzb(zzf2);
        }
    }

    public final void zzb() {
        if (this.zzg) {
            zzfio zzfio = this.zzh;
            zzfin zzf2 = zzf("ifts");
            zzf2.zza("reason", "blocked");
            zzfio.zzb(zzf2);
        }
    }

    public final void zzc() {
        if (zzh()) {
            this.zzh.zzb(zzf("adapter_shown"));
        }
    }

    public final void zzd() {
        if (zzh()) {
            this.zzh.zzb(zzf("adapter_impression"));
        }
    }

    public final void zze(zzdoa zzdoa) {
        if (this.zzg) {
            zzfin zzf2 = zzf("ifts");
            zzf2.zza("reason", "exception");
            if (!TextUtils.isEmpty(zzdoa.getMessage())) {
                zzf2.zza("msg", zzdoa.getMessage());
            }
            this.zzh.zzb(zzf2);
        }
    }

    public final void zzl() {
        if (zzh() || this.zzd.zzag) {
            zzg(zzf("impression"));
        }
    }
}
