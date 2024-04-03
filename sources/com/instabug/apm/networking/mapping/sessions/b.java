package com.instabug.apm.networking.mapping.sessions;

import androidx.annotation.NonNull;
import com.apptimize.av;
import com.deliveryhero.chatsdk.util.PushNotificationParser;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.appevents.UserDataStore;
import com.instabug.apm.cache.model.f;
import com.instabug.apm.networking.mapping.applaunch.a;
import com.instabug.library.model.v3Session.IBGSessionData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private a f45530a = com.instabug.apm.di.a.m();

    /* renamed from: b  reason: collision with root package name */
    private com.instabug.apm.networking.mapping.networklog.a f45531b = com.instabug.apm.di.a.Q();

    /* renamed from: c  reason: collision with root package name */
    private com.instabug.apm.networking.mapping.executiontraces.a f45532c = com.instabug.apm.di.a.B();

    /* renamed from: d  reason: collision with root package name */
    private com.instabug.apm.networking.mapping.uitrace.a f45533d = com.instabug.apm.di.a.l0();

    /* renamed from: e  reason: collision with root package name */
    private com.instabug.apm.networking.mapping.experiment.a f45534e = com.instabug.apm.di.a.E();

    /* renamed from: f  reason: collision with root package name */
    private com.instabug.apm.networking.mapping.fragment_span.a f45535f = com.instabug.apm.di.a.I();

    private void a(f fVar, JSONObject jSONObject) {
        int b11;
        JSONArray a11 = (fVar.a() == null || fVar.a().isEmpty()) ? null : this.f45530a.a(fVar.a());
        if (a11 != null || (fVar.h() != null && fVar.h().b() > 0)) {
            JSONObject jSONObject2 = new JSONObject();
            if (a11 != null) {
                jSONObject2.put("ll", (Object) a11);
            }
            if (fVar.h() != null) {
                int a12 = fVar.h().a();
                if (a12 != 0) {
                    jSONObject2.put("dcrl", a12);
                }
                if (!(fVar.h() == null || fVar.a() == null || (b11 = (fVar.h().b() - fVar.h().a()) - fVar.a().size()) == 0)) {
                    jSONObject2.put("dcsl", b11);
                }
            }
            jSONObject.put("ls", (Object) jSONObject2);
        }
    }

    private void b(f fVar, JSONObject jSONObject) {
        int d11;
        JSONArray a11 = (fVar.d() == null || fVar.d().isEmpty()) ? null : this.f45532c.a(fVar.d());
        if (a11 != null || (fVar.h() != null && fVar.h().d() > 0)) {
            JSONObject jSONObject2 = new JSONObject();
            if (a11 != null) {
                jSONObject2.put("tl", (Object) a11);
            }
            if (fVar.h() != null) {
                int c11 = fVar.h().c();
                if (c11 != 0) {
                    jSONObject2.put("dcrl", c11);
                }
                if (!(fVar.d() == null || (d11 = (fVar.h().d() - fVar.h().c()) - fVar.d().size()) == 0)) {
                    jSONObject2.put("dcsl", d11);
                }
            }
            jSONObject.put("ts", (Object) jSONObject2);
        }
    }

    private void c(@NonNull f fVar, @NonNull JSONObject jSONObject) {
        JSONObject a11;
        com.instabug.apm.networking.mapping.experiment.a aVar = this.f45534e;
        if (aVar != null && fVar != null && jSONObject != null && (a11 = aVar.a(fVar.e(), fVar.h())) != null) {
            jSONObject.put(AuthenticationTokenClaims.JSON_KEY_EXP, (Object) a11);
        }
    }

    private void d(@NonNull f fVar, @NonNull JSONObject jSONObject) {
        JSONObject a11;
        com.instabug.apm.networking.mapping.fragment_span.a aVar = this.f45535f;
        if (aVar != null && fVar != null && jSONObject != null && (a11 = aVar.a(fVar.f(), fVar.h())) != null) {
            jSONObject.put("frs", (Object) a11);
        }
    }

    private void e(f fVar, JSONObject jSONObject) {
        int h11;
        JSONArray a11 = (fVar.g() == null || fVar.g().isEmpty()) ? null : this.f45531b.a(fVar.g());
        if (a11 != null || (fVar.h() != null && fVar.h().h() > 0)) {
            JSONObject jSONObject2 = new JSONObject();
            if (a11 != null) {
                jSONObject2.put("nl", (Object) a11);
            }
            if (fVar.h() != null) {
                int g11 = fVar.h().g();
                if (g11 != 0) {
                    jSONObject2.put("dcrl", g11);
                }
                if (!(fVar.g() == null || (h11 = (fVar.h().h() - fVar.h().g()) - fVar.g().size()) == 0)) {
                    jSONObject2.put("dcsl", h11);
                }
            }
            jSONObject.put("nts", (Object) jSONObject2);
        }
    }

    private void f(f fVar, JSONObject jSONObject) {
        int j11;
        JSONArray a11 = (fVar.j() == null || fVar.j().isEmpty()) ? null : this.f45533d.a(fVar.j());
        if (a11 != null || (fVar.h() != null && fVar.h().j() > 0)) {
            JSONObject jSONObject2 = new JSONObject();
            if (a11 != null) {
                jSONObject2.put("uil", (Object) a11);
            }
            if (fVar.h() != null) {
                int i11 = fVar.h().i();
                if (i11 != 0) {
                    jSONObject2.put("dcrl", i11);
                }
                if (!(fVar.j() == null || (j11 = (fVar.h().j() - fVar.h().i()) - fVar.j().size()) == 0)) {
                    jSONObject2.put("dcsl", j11);
                }
            }
            jSONObject.put("uis", (Object) jSONObject2);
        }
    }

    @NonNull
    public JSONArray a(@NonNull List list) {
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sid", (Object) fVar.b());
            jSONObject.put("os", (Object) fVar.getOs());
            jSONObject.put(PushNotificationParser.PUSH_ID_KEY, (Object) fVar.getUuid());
            jSONObject.put(av.f41238a, (Object) fVar.getAppVersion());
            jSONObject.put(UserDataStore.STATE, fVar.getStartTimestampMicros());
            jSONObject.put("sec", fVar.i());
            if (fVar.c() > 0) {
                jSONObject.put("sd", fVar.c());
            }
            a(fVar, jSONObject);
            e(fVar, jSONObject);
            b(fVar, jSONObject);
            f(fVar, jSONObject);
            c(fVar, jSONObject);
            d(fVar, jSONObject);
            jSONArray.put((Object) jSONObject);
        }
        return jSONArray;
    }

    @NonNull
    public Map b(@NonNull List list) {
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            JSONObject jSONObject = new JSONObject();
            a(fVar, jSONObject);
            e(fVar, jSONObject);
            b(fVar, jSONObject);
            f(fVar, jSONObject);
            d(fVar, jSONObject);
            if (jSONObject.keys().hasNext()) {
                hashMap.put(fVar.b(), new IBGSessionData("ad", jSONObject));
            }
        }
        return hashMap;
    }
}
