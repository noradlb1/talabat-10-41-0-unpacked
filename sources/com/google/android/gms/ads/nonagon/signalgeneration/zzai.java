package com.google.android.gms.ads.nonagon.signalgeneration;

import android.webkit.ValueCallback;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzciz;
import org.json.JSONException;
import org.json.JSONObject;

final class zzai extends QueryInfoGenerationCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ TaggingLibraryJsInterface zzb;

    public zzai(TaggingLibraryJsInterface taggingLibraryJsInterface, String str) {
        this.zzb = taggingLibraryJsInterface;
        this.zza = str;
    }

    public final void onFailure(String str) {
        String str2;
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "Failed to generate query info for the tagging library, error: ".concat(valueOf);
        } else {
            str2 = new String("Failed to generate query info for the tagging library, error: ");
        }
        zzciz.zzj(str2);
        this.zzb.zzb.evaluateJavascript(String.format("window.postMessage({'paw_id': '%1$s', 'error': '%2$s'}, '*');", new Object[]{this.zza, str}), (ValueCallback) null);
    }

    public final void onSuccess(QueryInfo queryInfo) {
        String str;
        String query = queryInfo.getQuery();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("paw_id", (Object) this.zza);
            jSONObject.put("signal", (Object) query);
            str = String.format("window.postMessage(%1$s, '*');", new Object[]{jSONObject});
        } catch (JSONException unused) {
            str = String.format("window.postMessage({'paw_id': '%1$s', 'signal': '%2$s'}, '*');", new Object[]{this.zza, queryInfo.getQuery()});
        }
        this.zzb.zzb.evaluateJavascript(str, (ValueCallback) null);
    }
}
