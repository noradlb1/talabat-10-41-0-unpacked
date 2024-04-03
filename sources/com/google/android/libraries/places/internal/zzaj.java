package com.google.android.libraries.places.internal;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;
import java.util.Map;

final class zzaj extends ImageRequest {
    final /* synthetic */ Map zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaj(zzak zzak, String str, Response.Listener listener, int i11, int i12, ImageView.ScaleType scaleType, Bitmap.Config config, Response.ErrorListener errorListener, Map map) {
        super(str, listener, 0, 0, scaleType, config, errorListener);
        this.zza = map;
    }

    public final Map<String, String> getHeaders() {
        return this.zza;
    }
}
