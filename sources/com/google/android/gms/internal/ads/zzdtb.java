package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.braze.models.inappmessage.InAppMessageBase;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.util.zzby;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzt;
import com.instabug.library.model.NetworkLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdtb {
    private final Context zza;
    private final zzdsk zzb;
    private final zzalt zzc;
    private final zzcjf zzd;
    private final zza zze;
    private final zzbay zzf;
    private final Executor zzg;
    private final zzbnw zzh;
    private final zzdtt zzi;
    private final zzdwj zzj;
    private final ScheduledExecutorService zzk;
    private final zzdve zzl;
    private final zzdyz zzm;
    private final zzfio zzn;
    private final zzfjs zzo;
    private final zzehh zzp;

    public zzdtb(Context context, zzdsk zzdsk, zzalt zzalt, zzcjf zzcjf, zza zza2, zzbay zzbay, Executor executor, zzfef zzfef, zzdtt zzdtt, zzdwj zzdwj, ScheduledExecutorService scheduledExecutorService, zzdyz zzdyz, zzfio zzfio, zzfjs zzfjs, zzehh zzehh, zzdve zzdve) {
        this.zza = context;
        this.zzb = zzdsk;
        this.zzc = zzalt;
        this.zzd = zzcjf;
        this.zze = zza2;
        this.zzf = zzbay;
        this.zzg = executor;
        this.zzh = zzfef.zzi;
        this.zzi = zzdtt;
        this.zzj = zzdwj;
        this.zzk = scheduledExecutorService;
        this.zzm = zzdyz;
        this.zzn = zzfio;
        this.zzo = zzfjs;
        this.zzp = zzehh;
        this.zzl = zzdve;
    }

    @Nullable
    public static final zzbjs zzi(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mute");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzr(optJSONObject);
    }

    public static final List<zzbjs> zzj(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("mute");
        if (optJSONObject == null) {
            return zzfss.zzo();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("reasons");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return zzfss.zzo();
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
            zzbjs zzr = zzr(optJSONArray.optJSONObject(i11));
            if (zzr != null) {
                arrayList.add(zzr);
            }
        }
        return zzfss.zzm(arrayList);
    }

    private final zzbfi zzk(int i11, int i12) {
        if (i11 == 0) {
            if (i12 == 0) {
                return zzbfi.zzc();
            }
            i11 = 0;
        }
        return new zzbfi(this.zza, new AdSize(i11, i12));
    }

    private static <T> zzfxa<T> zzl(zzfxa<T> zzfxa, T t11) {
        return zzfwq.zzg(zzfxa, Exception.class, new zzdsr((Object) null), zzcjm.zzf);
    }

    private static <T> zzfxa<T> zzm(boolean z11, zzfxa<T> zzfxa, T t11) {
        if (z11) {
            return zzfwq.zzn(zzfxa, new zzdsy(zzfxa), zzcjm.zzf);
        }
        return zzl(zzfxa, (Object) null);
    }

    private final zzfxa<zzbnu> zzn(@Nullable JSONObject jSONObject, boolean z11) {
        if (jSONObject == null) {
            return zzfwq.zzi(null);
        }
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            return zzfwq.zzi(null);
        }
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        int optInt = jSONObject.optInt("width", -1);
        int optInt2 = jSONObject.optInt("height", -1);
        if (z11) {
            return zzfwq.zzi(new zzbnu((Drawable) null, Uri.parse(optString), optDouble, optInt, optInt2));
        }
        return zzm(jSONObject.optBoolean("require"), zzfwq.zzm(this.zzb.zzb(optString, optDouble, optBoolean), new zzdsu(optString, optDouble, optInt, optInt2), this.zzg), (Object) null);
    }

    private final zzfxa<List<zzbnu>> zzo(@Nullable JSONArray jSONArray, boolean z11, boolean z12) {
        int i11;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzfwq.zzi(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        if (z12) {
            i11 = jSONArray.length();
        } else {
            i11 = 1;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            arrayList.add(zzn(jSONArray.optJSONObject(i12), z11));
        }
        return zzfwq.zzm(zzfwq.zze(arrayList), zzdsv.zza, this.zzg);
    }

    private final zzfxa<zzcop> zzp(JSONObject jSONObject, zzfdn zzfdn, zzfdq zzfdq) {
        zzfxa<zzcop> zzb2 = this.zzi.zzb(jSONObject.optString("base_url"), jSONObject.optString("html"), zzfdn, zzfdq, zzk(jSONObject.optInt("width", 0), jSONObject.optInt("height", 0)));
        return zzfwq.zzn(zzb2, new zzdta(zzb2), zzcjm.zzf);
    }

    private static Integer zzq(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    private static final zzbjs zzr(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("reason");
        String optString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new zzbjs(optString, optString2);
    }

    public final /* synthetic */ zzbnr zza(JSONObject jSONObject, List list) {
        Integer num = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        String optString = jSONObject.optString("text");
        Integer zzq = zzq(jSONObject, InAppMessageBase.BG_COLOR);
        Integer zzq2 = zzq(jSONObject, InAppMessageBase.MESSAGE_TEXT_COLOR);
        int optInt = jSONObject.optInt("text_size", -1);
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int optInt2 = jSONObject.optInt("animation_ms", 1000);
        int optInt3 = jSONObject.optInt("presentation_ms", 4000);
        if (optInt > 0) {
            num = Integer.valueOf(optInt);
        }
        return new zzbnr(optString, list, zzq, zzq2, num, optInt3 + optInt2, this.zzh.zze, optBoolean);
    }

    public final /* synthetic */ zzfxa zzb(zzbfi zzbfi, zzfdn zzfdn, zzfdq zzfdq, String str, String str2, Object obj) throws Exception {
        zzcop zza2 = this.zzj.zza(zzbfi, zzfdn, zzfdq);
        zzcjq zza3 = zzcjq.zza(zza2);
        zzdvb zzb2 = this.zzl.zzb();
        zzdvb zzdvb = zzb2;
        zzcqc zzP = zza2.zzP();
        zzb zzb3 = r3;
        zzb zzb4 = new zzb(this.zza, (zzcgf) null, (zzcde) null);
        zzP.zzL(zzb2, zzdvb, zzb2, zzb2, zzb2, false, (zzbrw) null, zzb3, (zzcar) null, (zzcgf) null, this.zzp, this.zzo, this.zzm, this.zzn, (zzbru) null, zzb2);
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzcr)).booleanValue()) {
            zza2.zzaf("/getNativeAdViewSignals", zzbrs.zzs);
        }
        zza2.zzaf("/getNativeClickMeta", zzbrs.zzt);
        zza2.zzP().zzz(new zzdsq(zza3));
        zza2.zzad(str, str2, (String) null);
        return zza3;
    }

    public final /* synthetic */ zzfxa zzc(String str, Object obj) throws Exception {
        zzt.zzz();
        zzcop zza2 = zzcpb.zza(this.zza, zzcqe.zza(), "native-omid", false, false, this.zzc, (zzbmi) null, this.zzd, (zzbly) null, (zzl) null, this.zze, this.zzf, (zzfdn) null, (zzfdq) null);
        zzcjq zza3 = zzcjq.zza(zza2);
        zza2.zzP().zzz(new zzdss(zza3));
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdE)).booleanValue()) {
            zza2.loadData(Base64.encodeToString(str.getBytes(), 1), NetworkLog.HTML, "base64");
        } else {
            zza2.loadData(str, NetworkLog.HTML, "UTF-8");
        }
        return zza3;
    }

    public final zzfxa<zzbnr> zzd(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return zzfwq.zzi(null);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("images");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("image");
        if (optJSONArray == null && optJSONObject2 != null) {
            optJSONArray = new JSONArray();
            optJSONArray.put((Object) optJSONObject2);
        }
        return zzm(optJSONObject.optBoolean("require"), zzfwq.zzm(zzo(optJSONArray, false, true), new zzdst(this, optJSONObject), this.zzg), (Object) null);
    }

    public final zzfxa<zzbnu> zze(JSONObject jSONObject, String str) {
        return zzn(jSONObject.optJSONObject(str), this.zzh.zzb);
    }

    public final zzfxa<List<zzbnu>> zzf(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray("images");
        zzbnw zzbnw = this.zzh;
        return zzo(optJSONArray, zzbnw.zzb, zzbnw.zzd);
    }

    public final zzfxa<zzcop> zzg(JSONObject jSONObject, String str, zzfdn zzfdn, zzfdq zzfdq) {
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzgZ)).booleanValue()) {
            return zzfwq.zzi(null);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("images");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return zzfwq.zzi(null);
        }
        JSONObject optJSONObject = optJSONArray.optJSONObject(0);
        if (optJSONObject == null) {
            return zzfwq.zzi(null);
        }
        String optString = optJSONObject.optString("base_url");
        String optString2 = optJSONObject.optString("html");
        zzbfi zzk2 = zzk(optJSONObject.optInt("width", 0), optJSONObject.optInt("height", 0));
        if (TextUtils.isEmpty(optString2)) {
            return zzfwq.zzi(null);
        }
        zzfxa zzn2 = zzfwq.zzn(zzfwq.zzi(null), new zzdsw(this, zzk2, zzfdn, zzfdq, optString, optString2), zzcjm.zze);
        return zzfwq.zzn(zzn2, new zzdsz(zzn2), zzcjm.zzf);
    }

    public final zzfxa<zzcop> zzh(JSONObject jSONObject, zzfdn zzfdn, zzfdq zzfdq) {
        zzfxa<zzcop> zzfxa;
        JSONObject zzg2 = zzby.zzg(jSONObject, "html_containers", "instream");
        if (zzg2 != null) {
            return zzp(zzg2, zzfdn, zzfdq);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("video");
        if (optJSONObject == null) {
            return zzfwq.zzi(null);
        }
        String optString = optJSONObject.optString("vast_xml");
        boolean z11 = false;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgY)).booleanValue() && optJSONObject.has("html")) {
            z11 = true;
        }
        if (TextUtils.isEmpty(optString)) {
            if (!z11) {
                zzciz.zzj("Required field 'vast_xml' or 'html' is missing");
                return zzfwq.zzi(null);
            }
        } else if (!z11) {
            zzfxa = this.zzi.zza(optJSONObject);
            return zzl(zzfwq.zzo(zzfxa, (long) ((Integer) zzbgq.zzc().zzb(zzblj.zzcs)).intValue(), TimeUnit.SECONDS, this.zzk), (Object) null);
        }
        zzfxa = zzp(optJSONObject, zzfdn, zzfdq);
        return zzl(zzfwq.zzo(zzfxa, (long) ((Integer) zzbgq.zzc().zzb(zzblj.zzcs)).intValue(), TimeUnit.SECONDS, this.zzk), (Object) null);
    }
}
