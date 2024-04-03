package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsCallback;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.nonagon.signalgeneration.zze;
import java.util.regex.Pattern;

public final class zzdyk implements zzdjm, zzbes, zzdfl, zzdev {
    private final Context zza;
    private final zzfer zzb;
    private final zzdyz zzc;
    private final zzfdz zzd;
    private final zzfdn zze;
    private final zzehh zzf;
    @Nullable
    private Boolean zzg;
    private final boolean zzh = ((Boolean) zzbgq.zzc().zzb(zzblj.zzfj)).booleanValue();

    public zzdyk(Context context, zzfer zzfer, zzdyz zzdyz, zzfdz zzfdz, zzfdn zzfdn, zzehh zzehh) {
        this.zza = context;
        this.zzb = zzfer;
        this.zzc = zzdyz;
        this.zzd = zzfdz;
        this.zze = zzfdn;
        this.zzf = zzehh;
    }

    private final zzdyy zzf(String str) {
        String str2;
        zzdyy zza2 = this.zzc.zza();
        zza2.zzd(this.zzd.zzb.zzb);
        zza2.zzc(this.zze);
        zza2.zzb(NativeProtocol.WEB_DIALOG_ACTION, str);
        if (!this.zze.zzu.isEmpty()) {
            zza2.zzb("ancn", this.zze.zzu.get(0));
        }
        if (this.zze.zzag) {
            zzt.zzp();
            if (true != com.google.android.gms.ads.internal.util.zzt.zzJ(this.zza)) {
                str2 = "offline";
            } else {
                str2 = CustomTabsCallback.ONLINE_EXTRAS_KEY;
            }
            zza2.zzb("device_connectivity", str2);
            zza2.zzb("event_timestamp", String.valueOf(zzt.zzA().currentTimeMillis()));
            zza2.zzb("offline_ad", "1");
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfs)).booleanValue()) {
            boolean zzd2 = zze.zzd(this.zzd);
            zza2.zzb("scar", String.valueOf(zzd2));
            if (zzd2) {
                String zzb2 = zze.zzb(this.zzd);
                if (!TextUtils.isEmpty(zzb2)) {
                    zza2.zzb("ragent", zzb2);
                }
                String zza3 = zze.zza(this.zzd);
                if (!TextUtils.isEmpty(zza3)) {
                    zza2.zzb("rtype", zza3);
                }
            }
        }
        return zza2;
    }

    private final void zzg(zzdyy zzdyy) {
        if (this.zze.zzag) {
            this.zzf.zzd(new zzehj(zzt.zzA().currentTimeMillis(), this.zzd.zzb.zzb.zzb, zzdyy.zze(), 2));
            return;
        }
        zzdyy.zzf();
    }

    private final boolean zzh() {
        if (this.zzg == null) {
            synchronized (this) {
                if (this.zzg == null) {
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
                    this.zzg = Boolean.valueOf(z11);
                }
            }
        }
        return this.zzg.booleanValue();
    }

    public final void onAdClicked() {
        if (this.zze.zzag) {
            zzg(zzf("click"));
        }
    }

    public final void zza(zzbew zzbew) {
        zzbew zzbew2;
        if (this.zzh) {
            zzdyy zzf2 = zzf("ifts");
            zzf2.zzb("reason", "adapter");
            int i11 = zzbew.zza;
            String str = zzbew.zzb;
            if (zzbew.zzc.equals(MobileAds.ERROR_DOMAIN) && (zzbew2 = zzbew.zzd) != null && !zzbew2.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                zzbew zzbew3 = zzbew.zzd;
                i11 = zzbew3.zza;
                str = zzbew3.zzb;
            }
            if (i11 >= 0) {
                zzf2.zzb("arec", String.valueOf(i11));
            }
            String zza2 = this.zzb.zza(str);
            if (zza2 != null) {
                zzf2.zzb("areec", zza2);
            }
            zzf2.zzf();
        }
    }

    public final void zzb() {
        if (this.zzh) {
            zzdyy zzf2 = zzf("ifts");
            zzf2.zzb("reason", "blocked");
            zzf2.zzf();
        }
    }

    public final void zzc() {
        if (zzh()) {
            zzf("adapter_shown").zzf();
        }
    }

    public final void zzd() {
        if (zzh()) {
            zzf("adapter_impression").zzf();
        }
    }

    public final void zze(zzdoa zzdoa) {
        if (this.zzh) {
            zzdyy zzf2 = zzf("ifts");
            zzf2.zzb("reason", "exception");
            if (!TextUtils.isEmpty(zzdoa.getMessage())) {
                zzf2.zzb("msg", zzdoa.getMessage());
            }
            zzf2.zzf();
        }
    }

    public final void zzl() {
        if (zzh() || this.zze.zzag) {
            zzg(zzf("impression"));
        }
    }
}
