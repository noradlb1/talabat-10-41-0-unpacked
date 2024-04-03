package com.google.android.gms.ads.nonagon.signalgeneration;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzalt;
import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzciz;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.UUID;
import org.json.JSONObject;

final class TaggingLibraryJsInterface {
    private final Context zza;
    /* access modifiers changed from: private */
    public final WebView zzb;
    private final zzalt zzc;

    public TaggingLibraryJsInterface(WebView webView, zzalt zzalt) {
        this.zzb = webView;
        this.zza = webView.getContext();
        this.zzc = zzalt;
    }

    @JavascriptInterface
    @TargetApi(21)
    @KeepForSdk
    public String getClickSignals(String str) {
        zzblj.zzc(this.zza);
        try {
            return this.zzc.zzc().zze(this.zza, str, this.zzb);
        } catch (RuntimeException e11) {
            zzciz.zzh("Exception getting click signals. ", e11);
            zzt.zzo().zzs(e11, "TaggingLibraryJsInterface.getClickSignals");
            return "";
        }
    }

    @JavascriptInterface
    @TargetApi(21)
    @KeepForSdk
    public String getQueryInfo() {
        zzt.zzp();
        String uuid = UUID.randomUUID().toString();
        Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_6");
        Context context = this.zza;
        AdFormat adFormat = AdFormat.BANNER;
        AdRequest.Builder builder = new AdRequest.Builder();
        builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        QueryInfo.generate(context, adFormat, builder.build(), new zzai(this, uuid));
        return uuid;
    }

    @JavascriptInterface
    @TargetApi(21)
    @KeepForSdk
    public String getViewSignals() {
        zzblj.zzc(this.zza);
        try {
            return this.zzc.zzc().zzh(this.zza, this.zzb, (Activity) null);
        } catch (RuntimeException e11) {
            zzciz.zzh("Exception getting view signals. ", e11);
            zzt.zzo().zzs(e11, "TaggingLibraryJsInterface.getViewSignals");
            return "";
        }
    }

    @JavascriptInterface
    @TargetApi(21)
    @KeepForSdk
    public void reportTouchEvent(String str) {
        int i11;
        int i12;
        zzblj.zzc(this.zza);
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i13 = jSONObject.getInt(Param.X);
            int i14 = jSONObject.getInt(Param.Y);
            int i15 = jSONObject.getInt("duration_ms");
            float f11 = (float) jSONObject.getDouble("force");
            int i16 = jSONObject.getInt("type");
            if (i16 != 0) {
                int i17 = 1;
                if (i16 != 1) {
                    i17 = 2;
                    if (i16 != 2) {
                        i17 = 3;
                        if (i16 != 3) {
                            i12 = -1;
                        }
                    }
                }
                i11 = i17;
                this.zzc.zzd(MotionEvent.obtain(0, (long) i15, i11, (float) i13, (float) i14, f11, 1.0f, 0, 1.0f, 1.0f, 0, 0));
            }
            i12 = 0;
            i11 = i12;
            this.zzc.zzd(MotionEvent.obtain(0, (long) i15, i11, (float) i13, (float) i14, f11, 1.0f, 0, 1.0f, 1.0f, 0, 0));
        } catch (RuntimeException e11) {
            zzciz.zzh("Failed to parse the touch string. ", e11);
            zzt.zzo().zzs(e11, "TaggingLibraryJsInterface.reportTouchEvent");
        }
    }
}
