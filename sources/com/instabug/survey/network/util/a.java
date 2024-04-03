package com.instabug.survey.network.util;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.device.InstabugDeviceProperties;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.request.RequestParameter;
import com.instabug.library.user.UserManagerWrapper;
import com.instabug.library.util.DeviceStateProvider;
import com.instabug.survey.models.State;
import com.instabug.survey.models.Survey;
import com.instabug.survey.models.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class a {
    public static JSONArray a(ArrayList arrayList) {
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.a() != null && !bVar.a().equals("")) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("value", (Object) bVar.a());
                jSONObject.put("question_id", bVar.c());
                jSONArray.put((Object) jSONObject);
            }
        }
        return jSONArray;
    }

    @VisibleForTesting
    public static JSONArray a(ArrayList arrayList, int i11, String str) {
        JSONArray jSONArray = new JSONArray();
        if ((i11 == 0 || i11 == 1) && str.equals(State.DISMISSED)) {
            return jSONArray;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.a() != null && !bVar.a().equals("")) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("question_id", bVar.c());
                jSONObject.put("question_title", (Object) bVar.e());
                jSONObject.put("question_type", (Object) bVar.g());
                jSONObject.put("response_timestamp", bVar.b());
                jSONObject.put("response_value", (Object) bVar.a());
                jSONArray.put((Object) jSONObject);
            }
        }
        return jSONArray;
    }

    public static JSONObject a(Survey survey, String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", survey.getId());
        jSONObject.put("type", (Object) survey.getTypeAsString());
        jSONObject.put("title", (Object) survey.getTitle());
        jSONObject.put("is_announcement", false);
        jSONObject.put("responses", (Object) a((ArrayList) survey.getQuestions(), survey.getType(), str));
        return jSONObject;
    }

    private static JSONObject a(HashMap hashMap) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : hashMap.entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    public static void a(Context context, Request.Builder builder, Survey survey) {
        if (!survey.isLastEventDismiss()) {
            JSONArray a11 = a((ArrayList) survey.getQuestions());
            if (a11.length() > 0) {
                builder.addParameter(new RequestParameter("responses", a11));
            }
        }
        builder.addParameter(new RequestParameter("responded_at", Long.valueOf(survey.getRespondedAt())));
        builder.addParameter(new RequestParameter("name", InstabugCore.getIdentifiedUsername()));
        builder.addParameter(new RequestParameter("email", UserManagerWrapper.getUserEmail()));
        builder.addParameter(new RequestParameter("events", b(survey.getSurveyEvents())));
        if (!(survey.getLocalization() == null || survey.getLocalization().a() == null)) {
            builder.addParameter(new RequestParameter("locale", survey.getLocalization().a()));
        }
        builder.addParameter(new RequestParameter("sdk_version", "11.7.0"));
        builder.addParameter(new RequestParameter("app_version", InstabugDeviceProperties.getAppVersion(context)));
        builder.addParameter(new RequestParameter(com.instabug.library.model.State.KEY_PUSH_TOKEN, InstabugCore.getPushNotificationToken()));
        HashMap<String, String> retrieveAllSDKAttributes = InstabugCore.retrieveAllSDKAttributes();
        if (retrieveAllSDKAttributes != null && retrieveAllSDKAttributes.size() > 0) {
            builder.addParameter(new RequestParameter("user_attributes", a((HashMap) retrieveAllSDKAttributes)));
        }
        builder.addParameter(new RequestParameter("os", DeviceStateProvider.getOS()));
        builder.addParameter(new RequestParameter("device", DeviceStateProvider.getDevice()));
    }

    private static JSONArray b(ArrayList arrayList) {
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                com.instabug.survey.common.models.a aVar = (com.instabug.survey.common.models.a) it.next();
                if (!aVar.d()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("event_type", (Object) aVar.a());
                    jSONObject.put("timestamp", aVar.c());
                    jSONObject.put(FirebaseAnalytics.Param.INDEX, aVar.b());
                    jSONArray.put((Object) jSONObject);
                }
            }
        }
        return jSONArray;
    }
}
