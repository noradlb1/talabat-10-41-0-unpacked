package com.instabug.library.diagnostics.nonfatals.networking.mapping;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.internal.security.CertificateUtil;
import com.instabug.library.diagnostics.nonfatals.model.a;
import com.instabug.library.model.State;
import com.instabug.library.model.session.SessionParameter;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.user.f;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements a {
    @NonNull
    public JSONArray a(@NonNull List list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            JSONObject jSONObject = new JSONObject();
            if (!(aVar == null || aVar.k() == null)) {
                jSONObject.put("sdk_version", (Object) aVar.k().getSdkVersion());
                jSONObject.put(State.KEY_APP_PACKAGE_NAME, (Object) aVar.k().getAppPackageName());
                jSONObject.put("carrier", (Object) aVar.k().getCarrier());
                jSONObject.put(State.KEY_DENSITY, (Object) aVar.k().getScreenDensity());
                jSONObject.put("device", (Object) aVar.k().getDevice());
                jSONObject.put(State.KEY_SCREEN_SIZE, (Object) aVar.k().getScreenSize());
                jSONObject.put("locale", (Object) aVar.k().getLocale());
                jSONObject.put("os", (Object) aVar.k().getOS());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("module_affected", (Object) a(aVar.a()));
                jSONObject2.put("app_version", (Object) aVar.k().getAppVersion());
                jSONObject2.put("user_uuid", (Object) f.k());
                jSONObject2.put(SessionParameter.APP_TOKEN, (Object) SettingsManager.getInstance().getAppToken());
                jSONObject.put("user_attributes", (Object) jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("name", (Object) aVar.b());
                jSONObject4.put("exception", (Object) aVar.b() + CertificateUtil.DELIMITER + aVar.f());
                jSONObject4.put("message", (Object) aVar.f());
                jSONObject4.put("location", (Object) aVar.a() + CertificateUtil.DELIMITER + aVar.e());
                jSONObject4.put("stackTrace", (Object) aVar.j());
                jSONObject3.put("error", (Object) jSONObject4);
                jSONObject.put("error_details", (Object) jSONObject3);
                jSONObject.put("uuid", (Object) SettingsManager.getInstance().getUuid());
                JSONArray jSONArray2 = new JSONArray();
                for (int i11 = 0; i11 < aVar.h().size(); i11++) {
                    JSONObject jSONObject5 = new JSONObject();
                    com.instabug.library.diagnostics.nonfatals.model.b bVar = (com.instabug.library.diagnostics.nonfatals.model.b) aVar.h().get(i11);
                    jSONObject5.put(State.KEY_REPORTED_AT, bVar.b());
                    if (bVar.c() != null) {
                        jSONObject5.put(State.KEY_WIFI_STATE, bVar.c().isWifiEnable());
                        jSONObject5.put("app_status", (Object) bVar.c().getAppStatus());
                        jSONObject5.put("battery_level", bVar.c().getBatteryLevel());
                        jSONObject5.put("battery_state", (Object) bVar.c().getBatteryState());
                        jSONObject5.put(State.KEY_CURRENT_VIEW, (Object) bVar.c().getCurrentView());
                        jSONObject5.put("duration", bVar.c().getDuration());
                        jSONObject5.put("memory_total", bVar.c().getTotalMemory());
                        jSONObject5.put("memory_used", bVar.c().getUsedMemory());
                        jSONObject5.put("orientation", (Object) bVar.c().getScreenOrientation());
                        jSONObject5.put(State.KEY_STORAGE_TOTAL, bVar.c().getTotalStorage());
                        jSONObject5.put(State.KEY_STORAGE_USED, bVar.c().getUsedStorage());
                    }
                    jSONArray2.put((Object) jSONObject5);
                }
                jSONObject.put("occurrences", (Object) jSONArray2);
            }
            if (jSONObject.length() != 0) {
                jSONArray.put((Object) jSONObject);
            }
        }
        return jSONArray;
    }

    @VisibleForTesting
    public String a(@Nullable String str) {
        if (str == null || str.isEmpty() || !str.startsWith("com.instabug.")) {
            return "";
        }
        String substring = str.substring(13);
        return substring.substring(0, substring.indexOf(46));
    }
}
