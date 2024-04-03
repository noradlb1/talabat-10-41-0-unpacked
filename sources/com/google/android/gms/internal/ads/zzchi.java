package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.GuardedBy;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class zzchi {
    @GuardedBy("ScionComponent.class")
    @VisibleForTesting
    static zzchi zza;

    public static synchronized zzchi zzd(Context context) {
        synchronized (zzchi.class) {
            zzchi zzchi = zza;
            if (zzchi != null) {
                return zzchi;
            }
            Context applicationContext = context.getApplicationContext();
            zzblj.zzc(applicationContext);
            zzg zzh = zzt.zzo().zzh();
            zzh.zzp(applicationContext);
            zzcgn zzcgn = new zzcgn((zzcgm) null);
            zzcgn.zzb(applicationContext);
            zzcgn.zzc(zzt.zzA());
            zzcgn.zza(zzh);
            zzcgn.zzd(zzt.zzn());
            zzchi zze = zzcgn.zze();
            zza = zze;
            zze.zza().zza();
            zza.zzb().zzc();
            zzchm zzc = zza.zzc();
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzal)).booleanValue()) {
                HashMap hashMap = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject((String) zzbgq.zzc().zzb(zzblj.zzan));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        HashSet hashSet = new HashSet();
                        JSONArray optJSONArray = jSONObject.optJSONArray(next);
                        if (optJSONArray != null) {
                            for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                                String optString = optJSONArray.optString(i11);
                                if (optString != null) {
                                    hashSet.add(optString);
                                }
                            }
                            hashMap.put(next, hashSet);
                        }
                    }
                    for (String zzc2 : hashMap.keySet()) {
                        zzc.zzc(zzc2);
                    }
                    zzc.zzd(new zzchk(zzc, hashMap));
                } catch (JSONException e11) {
                    zzciz.zzf("Failed to parse listening list", e11);
                }
            }
            zzchi zzchi2 = zza;
            return zzchi2;
        }
    }

    public abstract zzcgg zza();

    public abstract zzcgk zzb();

    public abstract zzchm zzc();
}
