package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class zzeky<AdT> implements zzeht<AdT> {
    private static Bundle zzd(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }

    public final zzfxa<AdT> zza(zzfdz zzfdz, zzfdn zzfdn) {
        zzfdn zzfdn2 = zzfdn;
        String optString = zzfdn2.zzw.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "");
        zzfef zzfef = zzfdz.zza.zza;
        zzfed zzfed = new zzfed();
        zzfed.zzp(zzfef);
        zzfed.zzs(optString);
        Bundle zzd = zzd(zzfef.zzd.zzm);
        Bundle zzd2 = zzd(zzd.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        zzd2.putInt("gw", 1);
        String optString2 = zzfdn2.zzw.optString("mad_hac", (String) null);
        if (optString2 != null) {
            zzd2.putString("mad_hac", optString2);
        }
        String optString3 = zzfdn2.zzw.optString("adJson", (String) null);
        if (optString3 != null) {
            zzd2.putString("_ad", optString3);
        }
        zzd2.putBoolean("_noRefresh", true);
        Iterator<String> keys = zzfdn2.zzE.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString4 = zzfdn2.zzE.optString(next, (String) null);
            if (next != null) {
                zzd2.putString(next, optString4);
            }
        }
        zzd.putBundle("com.google.ads.mediation.admob.AdMobAdapter", zzd2);
        zzbfd zzbfd = zzfef.zzd;
        zzbfd zzbfd2 = r5;
        zzbfd zzbfd3 = new zzbfd(zzbfd.zza, zzbfd.zzb, zzd2, zzbfd.zzd, zzbfd.zze, zzbfd.zzf, zzbfd.zzg, zzbfd.zzh, zzbfd.zzi, zzbfd.zzj, zzbfd.zzk, zzbfd.zzl, zzd, zzbfd.zzn, zzbfd.zzo, zzbfd.zzp, zzbfd.zzq, zzbfd.zzr, zzbfd.zzs, zzbfd.zzt, zzbfd.zzu, zzbfd.zzv, zzbfd.zzw, zzbfd.zzx);
        zzfed.zzD(zzbfd2);
        zzfef zzF = zzfed.zzF();
        Bundle bundle = new Bundle();
        zzfdz zzfdz2 = zzfdz;
        zzfdq zzfdq = zzfdz2.zzb.zzb;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList(zzfdq.zza));
        bundle2.putInt("refresh_interval", zzfdq.zzc);
        bundle2.putString("gws_query_id", zzfdq.zzb);
        bundle.putBundle("parent_common_config", bundle2);
        String str = zzfdz2.zza.zza.zzf;
        Bundle bundle3 = new Bundle();
        bundle3.putString("initial_ad_unit_id", str);
        zzfdn zzfdn3 = zzfdn;
        bundle3.putString("allocation_id", zzfdn3.zzx);
        bundle3.putStringArrayList("click_urls", new ArrayList(zzfdn3.zzc));
        bundle3.putStringArrayList("imp_urls", new ArrayList(zzfdn3.zzd));
        bundle3.putStringArrayList("manual_tracking_urls", new ArrayList(zzfdn3.zzq));
        bundle3.putStringArrayList("fill_urls", new ArrayList(zzfdn3.zzn));
        bundle3.putStringArrayList("video_start_urls", new ArrayList(zzfdn3.zzh));
        bundle3.putStringArrayList("video_reward_urls", new ArrayList(zzfdn3.zzi));
        bundle3.putStringArrayList("video_complete_urls", new ArrayList(zzfdn3.zzj));
        bundle3.putString("transaction_id", zzfdn3.zzk);
        bundle3.putString("valid_from_timestamp", zzfdn3.zzl);
        bundle3.putBoolean("is_closable_area_disabled", zzfdn3.zzM);
        if (zzfdn3.zzm != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("rb_amount", zzfdn3.zzm.zzb);
            bundle4.putString("rb_type", zzfdn3.zzm.zza);
            bundle3.putParcelableArray("rewards", new Bundle[]{bundle4});
        }
        bundle.putBundle("parent_ad_config", bundle3);
        return zzc(zzF, bundle);
    }

    public final boolean zzb(zzfdz zzfdz, zzfdn zzfdn) {
        return !TextUtils.isEmpty(zzfdn.zzw.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, ""));
    }

    public abstract zzfxa<AdT> zzc(zzfef zzfef, Bundle bundle);
}
