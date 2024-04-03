package com.instabug.featuresrequest.network.timelinerepository;

import androidx.annotation.Nullable;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import org.json.JSONObject;

class b implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f46586a;

    public b(c cVar, d dVar) {
        this.f46586a = dVar;
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-FR", th2.getMessage() != null ? th2.getMessage() : "something went wrong while trying to add new comment", th2);
        this.f46586a.a(th2);
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f46586a.a((Object) jSONObject);
        }
    }
}
