package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class zzbvv implements zzbum, zzbvu {
    private final zzbvu zza;
    private final HashSet<AbstractMap.SimpleEntry<String, zzbrt<? super zzbvu>>> zzb = new HashSet<>();

    public zzbvv(zzbvu zzbvu) {
        this.zza = zzbvu;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zzb(String str, String str2) {
        zzbul.zzc(this, str, str2);
    }

    public final void zzc() {
        String str;
        Iterator<AbstractMap.SimpleEntry<String, zzbrt<? super zzbvu>>> it = this.zzb.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry next = it.next();
            String valueOf = String.valueOf(((zzbrt) next.getValue()).toString());
            if (valueOf.length() != 0) {
                str = "Unregistering eventhandler: ".concat(valueOf);
            } else {
                str = new String("Unregistering eventhandler: ");
            }
            zze.zza(str);
            this.zza.zzr((String) next.getKey(), (zzbrt) next.getValue());
        }
        this.zzb.clear();
    }

    public final /* synthetic */ void zzd(String str, Map map) {
        zzbul.zza(this, str, map);
    }

    public final /* synthetic */ void zze(String str, JSONObject jSONObject) {
        zzbul.zzb(this, str, jSONObject);
    }

    public final /* synthetic */ void zzl(String str, JSONObject jSONObject) {
        zzbul.zzd(this, str, jSONObject);
    }

    public final void zzq(String str, zzbrt<? super zzbvu> zzbrt) {
        this.zza.zzq(str, zzbrt);
        this.zzb.add(new AbstractMap.SimpleEntry(str, zzbrt));
    }

    public final void zzr(String str, zzbrt<? super zzbvu> zzbrt) {
        this.zza.zzr(str, zzbrt);
        this.zzb.remove(new AbstractMap.SimpleEntry(str, zzbrt));
    }
}
