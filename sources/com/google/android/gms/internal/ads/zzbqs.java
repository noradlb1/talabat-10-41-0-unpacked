package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzby;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbqs implements zzbrt<Object> {
    private final zzbqt zza;

    public zzbqs(zzbqt zzbqt) {
        this.zza = zzbqt;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (this.zza != null) {
            String str = map.get("name");
            if (str == null) {
                zzciz.zzi("Ad metadata with no name parameter.");
                str = "";
            }
            Bundle bundle = null;
            if (map.containsKey(CustomerInfoLocalDataSourceImpl.KEY)) {
                try {
                    bundle = zzby.zza(new JSONObject(map.get(CustomerInfoLocalDataSourceImpl.KEY)));
                } catch (JSONException e11) {
                    zzciz.zzh("Failed to convert ad metadata to JSON.", e11);
                }
            }
            if (bundle == null) {
                zzciz.zzg("Failed to convert ad metadata to Bundle.");
            } else {
                this.zza.zza(str, bundle);
            }
        }
    }
}
