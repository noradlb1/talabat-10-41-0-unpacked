package com.instabug.survey.network;

import androidx.annotation.Nullable;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.TimeUtils;
import com.instabug.survey.settings.c;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
class a implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f52408a;

    public a(c cVar) {
        this.f52408a = cVar;
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        this.f52408a.f52409a.onError(th2);
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable JSONObject jSONObject) {
        if (jSONObject != null) {
            InstabugSDKLogger.d("IBG-Surveys", "resolveCountryCode succeed");
            com.instabug.survey.models.a aVar = new com.instabug.survey.models.a();
            try {
                aVar.fromJson(JSONObjectInstrumentation.toString(jSONObject));
                this.f52408a.f52409a.a(aVar);
                c.a(TimeUtils.currentTimeMillis());
                com.instabug.survey.announcements.settings.a.a(TimeUtils.currentTimeMillis());
            } catch (JSONException e11) {
                e11.printStackTrace();
                this.f52408a.f52409a.onError(e11);
            }
        } else {
            InstabugSDKLogger.e("IBG-Surveys", "resolveCountryCode succeed: but response is null");
        }
    }
}
