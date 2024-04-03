package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zzekn implements zzekh<zzdpx> {
    private final zzdop zza;
    private final zzfxb zzb;
    private final zzdso zzc;
    private final zzfew<zzduy> zzd;
    private final zzdve zze;

    public zzekn(zzdop zzdop, zzfxb zzfxb, zzdso zzdso, zzfew<zzduy> zzfew, zzdve zzdve) {
        this.zza = zzdop;
        this.zzb = zzfxb;
        this.zzc = zzdso;
        this.zzd = zzfew;
        this.zze = zzdve;
    }

    private final zzfxa<zzdpx> zzg(zzfdz zzfdz, zzfdn zzfdn, JSONObject jSONObject) {
        zzfxa<zzduy> zza2 = this.zzd.zza();
        zzfxa<zzdqc> zza3 = this.zzc.zza(zzfdz, zzfdn, jSONObject);
        return zzfwq.zzd(zza2, zza3).zza(new zzekm(this, zza3, zza2, zzfdz, zzfdn, jSONObject), this.zzb);
    }

    public final zzfxa<List<zzfxa<zzdpx>>> zza(zzfdz zzfdz, zzfdn zzfdn) {
        return zzfwq.zzn(zzfwq.zzn(this.zzd.zza(), new zzekk(this, zzfdn), this.zzb), new zzekl(this, zzfdz, zzfdn), this.zzb);
    }

    public final boolean zzb(zzfdz zzfdz, zzfdn zzfdn) {
        zzfds zzfds = zzfdn.zzt;
        return (zzfds == null || zzfds.zzc == null) ? false : true;
    }

    public final /* synthetic */ zzdpx zzc(zzfxa zzfxa, zzfxa zzfxa2, zzfdz zzfdz, zzfdn zzfdn, JSONObject jSONObject) throws Exception {
        zzdqc zzdqc = (zzdqc) zzfxa.get();
        zzduy zzduy = (zzduy) zzfxa2.get();
        zzdqd zzd2 = this.zza.zzd(new zzdbk(zzfdz, zzfdn, (String) null), new zzdqo(zzdqc), new zzdpe(jSONObject, zzduy));
        zzd2.zzj().zzb();
        zzd2.zzk().zza(zzduy);
        zzd2.zzg().zza(zzdqc.zzr());
        zzd2.zzl().zza(this.zze);
        return zzd2.zza();
    }

    public final /* synthetic */ zzfxa zzd(zzduy zzduy, JSONObject jSONObject) throws Exception {
        this.zzd.zzb(zzfwq.zzi(zzduy));
        if (jSONObject.optBoolean("success")) {
            return zzfwq.zzi(jSONObject.getJSONObject("json").getJSONArray("ads"));
        }
        throw new zzbvw("process json failed");
    }

    public final /* synthetic */ zzfxa zze(zzfdn zzfdn, zzduy zzduy) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isNonagon", true);
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgn)).booleanValue() && PlatformVersion.isAtLeastR()) {
            jSONObject.put("skipDeepLinkValidation", true);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("response", (Object) zzfdn.zzt.zzc);
        jSONObject2.put("sdk_params", (Object) jSONObject);
        return zzfwq.zzn(zzduy.zzd("google.afma.nativeAds.preProcessJson", jSONObject2), new zzekj(this, zzduy), this.zzb);
    }

    public final /* synthetic */ zzfxa zzf(zzfdz zzfdz, zzfdn zzfdn, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzfwq.zzh(new zzecd(3));
        }
        if (zzfdz.zza.zza.zzk <= 1) {
            return zzfwq.zzm(zzg(zzfdz, zzfdn, jSONArray.getJSONObject(0)), zzeki.zza, this.zzb);
        }
        int length = jSONArray.length();
        this.zzd.zzc(Math.min(length, zzfdz.zza.zza.zzk));
        ArrayList arrayList = new ArrayList(zzfdz.zza.zza.zzk);
        for (int i11 = 0; i11 < zzfdz.zza.zza.zzk; i11++) {
            if (i11 < length) {
                arrayList.add(zzg(zzfdz, zzfdn, jSONArray.getJSONObject(i11)));
            } else {
                arrayList.add(zzfwq.zzh(new zzecd(3)));
            }
        }
        return zzfwq.zzi(arrayList);
    }
}
