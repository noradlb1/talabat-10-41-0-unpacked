package com.instabug.survey.network;

import androidx.annotation.Nullable;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.TimeUtils;
import com.instabug.survey.models.Survey;
import com.instabug.survey.settings.c;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class d implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f52410a;

    public d(f fVar) {
        this.f52410a = fVar;
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        this.f52410a.f52411a.a(th2);
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable JSONObject jSONObject) {
        try {
            c.b(TimeUtils.currentTimeMillis());
            if (jSONObject != null) {
                List<Survey> fromJson = Survey.fromJson(jSONObject);
                fromJson.addAll(Survey.getPausedSurveysFromJson(jSONObject));
                this.f52410a.f52411a.a((List) fromJson);
                return;
            }
            this.f52410a.f52411a.a((Throwable) new NullPointerException("Json response is null"));
        } catch (JSONException e11) {
            this.f52410a.f52411a.a((Throwable) e11);
        }
    }
}
