package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.adjust.sdk.Constants;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.Map;

final class zzg implements DataLayer.zzb {
    private final Context zzrm;

    public zzg(Context context) {
        this.zzrm = context;
    }

    public final void zzc(Map<String, Object> map) {
        String queryParameter;
        Object obj;
        Object obj2 = map.get("gtm.url");
        if (obj2 == null && (obj = map.get("gtm")) != null && (obj instanceof Map)) {
            obj2 = ((Map) obj).get("url");
        }
        if (obj2 != null && (obj2 instanceof String) && (queryParameter = Uri.parse((String) obj2).getQueryParameter(Constants.REFERRER)) != null) {
            zzcw.zzf(this.zzrm, queryParameter);
        }
    }
}
