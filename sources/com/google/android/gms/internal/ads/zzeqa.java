package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.Preconditions;
import com.huawei.hms.flutter.map.constants.Param;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class zzeqa implements zzevm<Bundle> {
    final zzfef zza;
    private final long zzb;

    public zzeqa(zzfef zzfef, long j11) {
        Preconditions.checkNotNull(zzfef, "the targeting must not be null");
        this.zza = zzfef;
        this.zzb = j11;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        Bundle bundle = (Bundle) obj;
        zzbfd zzbfd = this.zza.zzd;
        bundle.putInt("http_timeout_millis", zzbfd.zzw);
        bundle.putString("slotname", this.zza.zzf);
        int i11 = this.zza.zzo.zza;
        int i12 = i11 - 1;
        if (i11 != 0) {
            boolean z17 = true;
            if (i12 == 1) {
                bundle.putBoolean("is_new_rewarded", true);
            } else if (i12 == 2) {
                bundle.putBoolean("is_rewarded_interstitial", true);
            }
            bundle.putLong("start_signals_timestamp", this.zzb);
            String format = new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(zzbfd.zzb));
            if (zzbfd.zzb != -1) {
                z11 = true;
            } else {
                z11 = false;
            }
            zzfeq.zzg(bundle, "cust_age", format, z11);
            zzfeq.zzb(bundle, "extras", zzbfd.zzc);
            Integer valueOf = Integer.valueOf(zzbfd.zzd);
            if (zzbfd.zzd != -1) {
                z12 = true;
            } else {
                z12 = false;
            }
            zzfeq.zzf(bundle, "cust_gender", valueOf, z12);
            zzfeq.zzd(bundle, "kw", zzbfd.zze);
            Integer valueOf2 = Integer.valueOf(zzbfd.zzg);
            if (zzbfd.zzg != -1) {
                z13 = true;
            } else {
                z13 = false;
            }
            zzfeq.zzf(bundle, "tag_for_child_directed_treatment", valueOf2, z13);
            if (zzbfd.zzf) {
                bundle.putBoolean("test_request", true);
            }
            if (zzbfd.zza < 2 || !zzbfd.zzh) {
                z14 = false;
            } else {
                z14 = true;
            }
            zzfeq.zzf(bundle, "d_imp_hdr", 1, z14);
            String str = zzbfd.zzi;
            if (zzbfd.zza < 2 || TextUtils.isEmpty(str)) {
                z15 = false;
            } else {
                z15 = true;
            }
            zzfeq.zzg(bundle, "ppid", str, z15);
            Location location = zzbfd.zzk;
            if (location != null) {
                Float valueOf3 = Float.valueOf(location.getAccuracy() * 1000.0f);
                Long valueOf4 = Long.valueOf(location.getTime() * 1000);
                Long valueOf5 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
                Long valueOf6 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
                Bundle bundle2 = new Bundle();
                bundle2.putFloat(Param.RADIUS, valueOf3.floatValue());
                bundle2.putLong("lat", valueOf5.longValue());
                bundle2.putLong(Constants.LONG, valueOf6.longValue());
                bundle2.putLong("time", valueOf4.longValue());
                bundle.putBundle("uule", bundle2);
            }
            zzfeq.zzc(bundle, "url", zzbfd.zzl);
            zzfeq.zzd(bundle, "neighboring_content_urls", zzbfd.zzv);
            zzfeq.zzb(bundle, "custom_targeting", zzbfd.zzn);
            zzfeq.zzd(bundle, "category_exclusions", zzbfd.zzo);
            zzfeq.zzc(bundle, "request_agent", zzbfd.zzp);
            zzfeq.zzc(bundle, "request_pkg", zzbfd.zzq);
            Boolean valueOf7 = Boolean.valueOf(zzbfd.zzr);
            if (zzbfd.zza >= 7) {
                z16 = true;
            } else {
                z16 = false;
            }
            zzfeq.zze(bundle, "is_designed_for_families", valueOf7, z16);
            if (zzbfd.zza >= 8) {
                Integer valueOf8 = Integer.valueOf(zzbfd.zzt);
                if (zzbfd.zzt == -1) {
                    z17 = false;
                }
                zzfeq.zzf(bundle, "tag_for_under_age_of_consent", valueOf8, z17);
                zzfeq.zzc(bundle, "max_ad_content_rating", zzbfd.zzu);
                return;
            }
            return;
        }
        throw null;
    }
}
