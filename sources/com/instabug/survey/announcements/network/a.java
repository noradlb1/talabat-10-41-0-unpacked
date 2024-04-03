package com.instabug.survey.announcements.network;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.model.State;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.request.RequestParameter;
import com.instabug.library.user.UserManagerWrapper;
import com.instabug.survey.announcements.models.c;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class a {
    private static JSONArray a(ArrayList arrayList) {
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.instabug.survey.common.models.a aVar = (com.instabug.survey.common.models.a) it.next();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", (Object) aVar.a());
            jSONObject.put("timestamp", aVar.c());
            jSONObject.put(FirebaseAnalytics.Param.INDEX, aVar.b());
            jSONArray.put((Object) jSONObject);
        }
        return jSONArray;
    }

    public static JSONObject a(com.instabug.survey.announcements.models.a aVar, String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", aVar.i());
        jSONObject.put("type", (Object) aVar.q());
        jSONObject.put("title", (Object) aVar.o());
        jSONObject.put("is_announcement", true);
        jSONObject.put("responses", (Object) b(aVar, str));
        return jSONObject;
    }

    public static void a(Request.Builder builder, String str, com.instabug.survey.announcements.models.a aVar) {
        if (aVar != null) {
            if (aVar.c() != null) {
                JSONArray b11 = b(aVar.c());
                if (b11.length() > 0) {
                    builder.addParameter(new RequestParameter("responses", b11));
                }
            }
            builder.addParameter(new RequestParameter(InstabugDbContract.AnnouncementEntry.COLUMN_ID, Long.valueOf(aVar.i())));
            builder.addParameter(new RequestParameter("name", InstabugCore.getIdentifiedUsername()));
            builder.addParameter(new RequestParameter("email", UserManagerWrapper.getUserEmail()));
            builder.addParameter(new RequestParameter("responded_at", Long.valueOf(aVar.k())));
            builder.addParameter(new RequestParameter("app_version", str));
            if (!(aVar.n() == null || aVar.n().a() == null)) {
                builder.addParameter(new RequestParameter("events", a(aVar.n().a())));
            }
            if (!(aVar.j() == null || aVar.j().a() == null)) {
                builder.addParameter(new RequestParameter("locale", aVar.j().a()));
            }
            builder.addParameter(new RequestParameter(State.KEY_PUSH_TOKEN, InstabugCore.getPushNotificationToken()));
        }
    }

    public static JSONArray b(com.instabug.survey.announcements.models.a aVar, String str) {
        JSONArray jSONArray = new JSONArray();
        if (aVar.c() != null) {
            Iterator it = aVar.c().iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.b() != null && !cVar.b().equals("")) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("question_id", cVar.d());
                    jSONObject.put("question_title", (Object) cVar.g() != null ? cVar.g() : "");
                    jSONObject.put("question_type", (Object) !cVar.i().equals("") ? cVar.i() : aVar.q());
                    jSONObject.put("response_timestamp", str.equals(com.instabug.survey.models.State.DISMISSED) ? aVar.g() : aVar.k());
                    jSONObject.put("response_value", (Object) cVar.b());
                    jSONArray.put((Object) jSONObject);
                }
            }
        }
        return jSONArray;
    }

    public static JSONArray b(ArrayList arrayList) {
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.b() != null && !cVar.b().equals("")) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("value", (Object) cVar.b());
                jSONObject.put(InstabugDbContract.AnnouncementAssetsEntry.COLUMN_ANNOUNCE_ID, cVar.d());
                jSONArray.put((Object) jSONObject);
            }
        }
        return jSONArray;
    }
}
