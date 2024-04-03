package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import java.util.List;
import org.json.JSONException;

public final class zzdek extends zzbiv {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final List<zzbfm> zzd;
    private final long zze;
    private final String zzf;

    public zzdek(zzfdn zzfdn, String str, zzehy zzehy, zzfdq zzfdq) {
        String str2;
        String str3;
        String str4;
        String str5 = null;
        if (zzfdn == null) {
            str2 = null;
        } else {
            str2 = zzfdn.zzY;
        }
        this.zzb = str2;
        if (zzfdq == null) {
            str3 = null;
        } else {
            str3 = zzfdq.zzb;
        }
        this.zzc = str3;
        if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                str5 = zzfdn.zzw.getString("class_name");
            } catch (JSONException unused) {
            }
        }
        this.zza = str5 != null ? str5 : str;
        this.zzd = zzehy.zzb();
        this.zze = zzt.zzA().currentTimeMillis() / 1000;
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzgR)).booleanValue() || zzfdq == null || TextUtils.isEmpty(zzfdq.zzh)) {
            str4 = "";
        } else {
            str4 = zzfdq.zzh;
        }
        this.zzf = str4;
    }

    public final long zzc() {
        return this.zze;
    }

    public final String zzd() {
        return this.zzf;
    }

    public final String zze() {
        return this.zza;
    }

    public final String zzf() {
        return this.zzb;
    }

    @Nullable
    public final List<zzbfm> zzg() {
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzge)).booleanValue()) {
            return null;
        }
        return this.zzd;
    }

    public final String zzh() {
        return this.zzc;
    }
}
