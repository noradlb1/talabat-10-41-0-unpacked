package com.google.android.gms.internal.ads;

import android.os.Build;
import android.webkit.WebView;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.visa.checkout.Profile;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class zzflc {
    private zzfma zza = new zzfma((WebView) null);
    private long zzb;
    private int zzc;

    public zzflc() {
        zzb();
    }

    public final WebView zza() {
        return (WebView) this.zza.get();
    }

    public final void zzb() {
        this.zzb = System.nanoTime();
        this.zzc = 1;
    }

    public void zzc() {
        this.zza.clear();
    }

    public final void zzd(String str, long j11) {
        if (j11 >= this.zzb && this.zzc != 3) {
            this.zzc = 3;
            zzfkv.zza().zzf(zza(), str);
        }
    }

    public final void zze(String str, long j11) {
        if (j11 >= this.zzb) {
            this.zzc = 2;
            zzfkv.zza().zzf(zza(), str);
        }
    }

    public void zzf(zzfke zzfke, zzfkc zzfkc) {
        zzg(zzfke, zzfkc, (JSONObject) null);
    }

    public final void zzg(zzfke zzfke, zzfkc zzfkc, JSONObject jSONObject) {
        String zzh = zzfke.zzh();
        JSONObject jSONObject2 = new JSONObject();
        zzflg.zzg(jSONObject2, Profile.ENVIRONMENT, "app");
        zzflg.zzg(jSONObject2, "adSessionType", zzfkc.zzd());
        JSONObject jSONObject3 = new JSONObject();
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append("; ");
        sb2.append(str2);
        zzflg.zzg(jSONObject3, "deviceType", sb2.toString());
        zzflg.zzg(jSONObject3, AnalyticsAttribute.OS_VERSION_ATTRIBUTE, Integer.toString(Build.VERSION.SDK_INT));
        zzflg.zzg(jSONObject3, "os", "Android");
        zzflg.zzg(jSONObject2, "deviceInfo", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put((Object) "clid");
        jSONArray.put((Object) "vlid");
        zzflg.zzg(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        zzflg.zzg(jSONObject4, "partnerName", zzfkc.zze().zzb());
        zzflg.zzg(jSONObject4, "partnerVersion", zzfkc.zze().zzc());
        zzflg.zzg(jSONObject2, "omidNativeInfo", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        zzflg.zzg(jSONObject5, "libraryVersion", "1.3.3-google_20200416");
        zzflg.zzg(jSONObject5, "appId", zzfkt.zzb().zza().getApplicationContext().getPackageName());
        zzflg.zzg(jSONObject2, "app", jSONObject5);
        if (zzfkc.zzf() != null) {
            zzflg.zzg(jSONObject2, "contentUrl", zzfkc.zzf());
        }
        zzflg.zzg(jSONObject2, "customReferenceData", zzfkc.zzg());
        JSONObject jSONObject6 = new JSONObject();
        Iterator<zzfkk> it = zzfkc.zzh().iterator();
        if (!it.hasNext()) {
            zzfkv.zza().zzg(zza(), zzh, jSONObject2, jSONObject6, jSONObject);
        } else {
            zzfkk next = it.next();
            throw null;
        }
    }

    public final void zzh(float f11) {
        zzfkv.zza().zze(zza(), f11);
    }

    public final void zzi(WebView webView) {
        this.zza = new zzfma(webView);
    }

    public void zzj() {
    }

    public final boolean zzk() {
        return this.zza.get() != null;
    }
}
