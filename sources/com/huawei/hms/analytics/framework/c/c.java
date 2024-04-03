package com.huawei.hms.analytics.framework.c;

import com.huawei.hms.analytics.core.storage.Event;
import com.huawei.hms.analytics.framework.b.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class c {
    public static List<Event> a(String str, String str2, boolean z11) {
        long currentTimeMillis = System.currentTimeMillis();
        List<JSONObject> customEventJson = b.a().a(str).getCustomEventJson(currentTimeMillis);
        if (customEventJson == null || customEventJson.size() <= 0) {
            return null;
        }
        d dVar = new d(str, str2, customEventJson, currentTimeMillis);
        dVar.f47964a = z11;
        ArrayList arrayList = new ArrayList();
        for (JSONObject a11 : customEventJson) {
            dVar.a(arrayList, a11);
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }
}
