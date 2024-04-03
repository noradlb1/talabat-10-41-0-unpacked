package com.instabug.survey.announcements;

import androidx.annotation.Nullable;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.TimeUtils;
import org.json.JSONException;
import org.json.JSONObject;

class a implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f52219a;

    public a(b bVar) {
        this.f52219a = bVar;
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        this.f52219a.a(th2);
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable JSONObject jSONObject) {
        try {
            com.instabug.survey.announcements.settings.a.b().b(TimeUtils.currentTimeMillis());
            if (jSONObject != null) {
                this.f52219a.e(com.instabug.survey.announcements.models.a.a(jSONObject));
                return;
            }
            this.f52219a.a((Throwable) new NullPointerException("json response is null"));
        } catch (JSONException e11) {
            this.f52219a.a((Throwable) e11);
        }
    }
}
