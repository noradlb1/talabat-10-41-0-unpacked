package com.huawei.hms.analytics.framework.c;

import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.core.storage.Event;
import com.huawei.hms.analytics.core.storage.IStorageHandler;
import com.huawei.hms.analytics.framework.SyncManager;
import com.huawei.hms.analytics.framework.c.a.a;
import com.huawei.hms.analytics.framework.config.ICallback;
import com.huawei.hms.analytics.framework.e.b;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@Instrumented
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f47973a;

    /* renamed from: b  reason: collision with root package name */
    private final ICallback f47974b;

    /* renamed from: c  reason: collision with root package name */
    private List<?> f47975c;

    public f(a aVar, ICallback iCallback) {
        this.f47973a = aVar;
        this.f47974b = iCallback;
    }

    public f(a aVar, List<?> list, ICallback iCallback) {
        this.f47973a = aVar;
        this.f47975c = list;
        this.f47974b = iCallback;
    }

    public final void run() {
        List list;
        List<?> list2 = this.f47975c;
        if (list2 == null || list2.size() <= 0) {
            String str = this.f47973a.f47942a;
            IStorageHandler a11 = com.huawei.hms.analytics.framework.a.a.a(str);
            if (a11 != null) {
                list = a11.readEvents(str);
                if (list == null || list.size() == 0) {
                    HiLog.i("regionReport", "no have last region data. tag: " + this.f47973a.f47942a);
                } else {
                    a11.deleteByTag(str);
                }
            }
            list = null;
        } else {
            b a12 = com.huawei.hms.analytics.framework.e.a.a().a(this.f47973a.f47942a, System.currentTimeMillis());
            String a13 = a12.a();
            boolean b11 = a12.b();
            list = new ArrayList();
            for (Object next : this.f47975c) {
                if (next instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) next;
                    Event event = new Event();
                    event.setServiceTag(this.f47973a.f47942a);
                    event.setEvtType(this.f47973a.f47943b);
                    event.setEvtId((String) jSONObject.remove("^eventId"));
                    event.setEvtTime(String.valueOf(System.currentTimeMillis()));
                    event.setSessionid(String.valueOf(b11));
                    event.setSessionName(a13);
                    event.setAssociationid((String) jSONObject.remove("^id"));
                    event.setPid((String) jSONObject.remove("^pid"));
                    event.setContent(JSONObjectInstrumentation.toString(jSONObject));
                    list.add(event);
                } else if (next instanceof Event) {
                    list.add((Event) next);
                }
            }
        }
        SyncManager.getInstance().countDown(SyncManager.TaskNames.REGION_CHANGE);
        if (list != null) {
            new e(list, this.f47973a, this.f47974b).d();
            return;
        }
        a aVar = this.f47973a;
        String str2 = aVar.f47942a;
        com.huawei.hms.analytics.framework.b.b.a().a(str2).serviceListener(true, aVar.f47944c);
    }
}
