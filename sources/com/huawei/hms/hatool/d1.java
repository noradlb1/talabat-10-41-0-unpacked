package com.huawei.hms.hatool;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

@Instrumented
public class d1 implements g {

    /* renamed from: a  reason: collision with root package name */
    private String f48990a;

    /* renamed from: b  reason: collision with root package name */
    private String f48991b;

    /* renamed from: c  reason: collision with root package name */
    private String f48992c;

    /* renamed from: d  reason: collision with root package name */
    private List<b1> f48993d;

    public d1(List<b1> list, String str, String str2, String str3) {
        this.f48990a = str;
        this.f48991b = str2;
        this.f48992c = str3;
        this.f48993d = list;
    }

    private void a() {
        String a11 = n1.a(this.f48990a, this.f48992c, this.f48991b);
        d.a(q0.i(), "backup_event", a11);
    }

    public void run() {
        List<b1> list = this.f48993d;
        if (list == null || list.size() == 0) {
            v.d("hmsSdk", "failed events is empty");
            return;
        }
        if (c0.a(q0.i(), "cached_v2_1", q0.k() * 1048576)) {
            v.e("hmsSdk", "The cacheFile is full,Can not writing data! reqID:" + this.f48991b);
            return;
        }
        String a11 = n1.a(this.f48990a, this.f48992c);
        List list2 = c1.b(q0.i(), "cached_v2_1", a11).get(a11);
        if (!(list2 == null || list2.size() == 0)) {
            this.f48993d.addAll(list2);
        }
        JSONArray jSONArray = new JSONArray();
        for (b1 d11 : this.f48993d) {
            try {
                jSONArray.put((Object) d11.d());
            } catch (JSONException unused) {
                v.e("hmsSdk", "event to json error");
            }
        }
        String jSONArrayInstrumentation = JSONArrayInstrumentation.toString(jSONArray);
        if (jSONArrayInstrumentation.length() > q0.h() * 1048576) {
            v.e("hmsSdk", "this failed data is too long,can not writing it");
            this.f48993d = null;
            return;
        }
        v.d("hmsSdk", "data send failed, write to cache file...reqID:" + this.f48991b);
        d.b(q0.i(), "cached_v2_1", a11, jSONArrayInstrumentation);
        a();
    }
}
