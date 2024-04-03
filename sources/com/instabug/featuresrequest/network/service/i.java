package com.instabug.featuresrequest.network.service;

import androidx.annotation.Nullable;
import com.instabug.featuresrequest.models.d;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import org.json.JSONObject;

class i implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f46581a;

    public i(d dVar) {
        this.f46581a = dVar;
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        if (th2.getMessage() != null) {
            InstabugSDKLogger.e("IBG-FR", th2.getMessage(), th2);
        }
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable JSONObject jSONObject) {
        PoolProvider.postMainThreadTask(new h(this));
    }
}
