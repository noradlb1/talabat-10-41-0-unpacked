package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.google.android.gms.ads.internal.zzt;

public final class zzesh implements zzevn<zzesg> {
    private final Context zza;
    private final zzfxb zzb;

    public zzesh(Context context, zzfxb zzfxb) {
        this.zza = context;
        this.zzb = zzfxb;
    }

    public final /* synthetic */ zzesg zza() throws Exception {
        String str;
        Bundle bundle;
        zzt.zzp();
        Context context = this.zza;
        String str2 = "";
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzex)).booleanValue()) {
            str = str2;
        } else {
            str = context.getSharedPreferences("mobileads_consent", 0).getString("consent_string", str2);
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzez)).booleanValue()) {
            str2 = this.zza.getSharedPreferences("mobileads_consent", 0).getString("fc_consent", str2);
        }
        zzt.zzp();
        Context context2 = this.zza;
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzey)).booleanValue()) {
            bundle = null;
        } else {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context2);
            bundle = new Bundle();
            if (defaultSharedPreferences.contains("IABConsent_CMPPresent")) {
                bundle.putBoolean("IABConsent_CMPPresent", defaultSharedPreferences.getBoolean("IABConsent_CMPPresent", false));
            }
            String[] strArr = {"IABConsent_SubjectToGDPR", "IABConsent_ConsentString", "IABConsent_ParsedPurposeConsents", "IABConsent_ParsedVendorConsents"};
            for (int i11 = 0; i11 < 4; i11++) {
                String str3 = strArr[i11];
                if (defaultSharedPreferences.contains(str3)) {
                    bundle.putString(str3, defaultSharedPreferences.getString(str3, (String) null));
                }
            }
        }
        return new zzesg(str, str2, bundle, (zzesf) null);
    }

    public final zzfxa<zzesg> zzb() {
        return this.zzb.zzb(new zzese(this));
    }
}
