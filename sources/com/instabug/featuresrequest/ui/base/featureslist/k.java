package com.instabug.featuresrequest.ui.base.featureslist;

import androidx.annotation.Nullable;
import com.instabug.featuresrequest.models.e;
import com.instabug.featuresrequest.ui.base.b;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import org.json.JSONException;
import org.json.JSONObject;

class k implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f46652a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f46653b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f46654c;

    public k(n nVar, boolean z11, b bVar) {
        this.f46654c = nVar;
        this.f46652a = z11;
        this.f46653b = bVar;
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-FR", th2.getMessage() != null ? th2.getMessage() : "Error While fetching features Requests", th2);
        PoolProvider.postMainThreadTask(new j(this));
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            onFailed((Throwable) new JSONException("response json is null"));
            return;
        }
        try {
            PoolProvider.postMainThreadTask(new i(this, e.a(jSONObject)));
        } catch (JSONException e11) {
            onFailed((Throwable) e11);
        }
    }
}
