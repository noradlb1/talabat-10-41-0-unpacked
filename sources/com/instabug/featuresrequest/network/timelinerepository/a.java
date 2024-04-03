package com.instabug.featuresrequest.network.timelinerepository;

import androidx.annotation.Nullable;
import com.instabug.featuresrequest.models.j;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import org.json.JSONException;
import org.json.JSONObject;

class a implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f46584a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f46585b;

    public a(c cVar, long j11, d dVar) {
        this.f46584a = j11;
        this.f46585b = dVar;
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-FR", th2.getMessage() != null ? th2.getMessage() : "something went wrong while getting feature timeline", th2);
        this.f46585b.a(th2);
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            onFailed((Throwable) new JSONException("response json is null"));
            return;
        }
        try {
            j a11 = j.a(jSONObject);
            a11.a(this.f46584a);
            this.f46585b.a((Object) a11);
        } catch (JSONException unused) {
        }
    }
}
