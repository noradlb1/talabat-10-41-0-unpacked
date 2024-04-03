package com.huawei.hms.analytics.framework.c;

import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.core.storage.Event;
import com.huawei.hms.analytics.core.storage.IStorageHandler;
import com.huawei.hms.analytics.framework.b.b;
import com.huawei.hms.analytics.framework.b.c;
import com.huawei.hms.analytics.framework.config.ICallback;
import com.huawei.hms.analytics.framework.e.a;
import com.huawei.hms.analytics.framework.policy.IStoragePolicy;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@Instrumented
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public boolean f47964a;

    /* renamed from: b  reason: collision with root package name */
    public ICallback f47965b;

    /* renamed from: c  reason: collision with root package name */
    private String f47966c;

    /* renamed from: d  reason: collision with root package name */
    private String f47967d;

    /* renamed from: e  reason: collision with root package name */
    private long f47968e;

    /* renamed from: f  reason: collision with root package name */
    private List<JSONObject> f47969f;

    /* renamed from: g  reason: collision with root package name */
    private String f47970g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f47971h;

    /* renamed from: i  reason: collision with root package name */
    private List<Event> f47972i;

    public d(String str, String str2, List<JSONObject> list) {
        this(str, str2, list, 0);
    }

    public d(String str, String str2, List<JSONObject> list, long j11) {
        this.f47966c = str;
        this.f47968e = j11 == 0 ? System.currentTimeMillis() : j11;
        if (list != null) {
            this.f47969f = new ArrayList(list);
        }
        this.f47967d = str2;
        if ("oper".equals(str2) && b.a().a(str).isEnableSession("oper")) {
            com.huawei.hms.analytics.framework.e.b a11 = a.a().a(str, this.f47968e);
            this.f47970g = a11.a();
            this.f47971h = a11.b();
        }
    }

    public d(List<Event> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList(list);
            this.f47972i = arrayList;
            this.f47966c = ((Event) arrayList.get(0)).getServiceTag();
            this.f47967d = this.f47972i.get(0).getEvtType();
        }
    }

    private void a() {
        c b11 = b.a().b(this.f47966c);
        if (b11 == null) {
            HiLog.w("RecordMission", "get framework config info error");
            return;
        }
        long a11 = b11.a(this.f47967d);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - a11 > 30000) {
            HiLog.d("RecordMission", "begin to auto report!");
            b11.a(this.f47967d, currentTimeMillis);
            com.huawei.hms.analytics.framework.f.a.b().a(new h(this.f47966c, this.f47967d, this.f47965b));
            return;
        }
        HiLog.w("RecordMission", "autoReport timeout. interval < 30s ");
    }

    private void a(List<Event> list) {
        IStorageHandler a11 = com.huawei.hms.analytics.framework.a.a.a(this.f47966c);
        IStoragePolicy b11 = com.huawei.hms.analytics.framework.a.a.b(this.f47966c);
        if (a11 == null || b11 == null) {
            HiLog.e("RecordMission", "storageHandler is null!");
        } else if (b11.decide(IStoragePolicy.PolicyType.STORAGELENGTH, (Object) "userEvent.db")) {
            HiLog.e("RecordMission", "db file reach max limited length,clear db file");
            a11.deleteAll();
            a11.insertEx(list);
        } else {
            long count = a11.count(this.f47966c);
            if (count == 0) {
                a11.insertEx(list);
                HiLog.d("RecordMission", "record event size: 1");
            } else if (count > 5000) {
                HiLog.e("RecordMission", "db file reach max limited size,clear db file");
                a11.deleteByTag(this.f47966c);
                a11.insertEx(list);
            } else {
                a11.insertEx(list);
                long count2 = a11.count(this.f47966c);
                HiLog.i("RecordMission", "record evt size : ".concat(String.valueOf(count2)));
                if (b11.decide(IStoragePolicy.PolicyType.STORAGESIZE, count2) && b11.decide(IStoragePolicy.PolicyType.NETWORK, (Object) "")) {
                    HiLog.i("RecordMission", "ready to auto report!");
                    a();
                }
            }
        }
    }

    public final void a(List<Event> list, JSONObject jSONObject) {
        Object remove = jSONObject.remove("f");
        Event event = new Event();
        event.setServiceTag(this.f47966c);
        event.setEvtType(this.f47967d);
        event.setEvtId((String) jSONObject.remove("^eventId"));
        event.setEvtTime(String.valueOf(this.f47968e));
        event.setSessionid(String.valueOf(this.f47971h));
        event.setSessionName(this.f47970g);
        event.setAssociationid((String) jSONObject.remove("^id"));
        event.setPid((String) jSONObject.remove("^pid"));
        if (remove != null) {
            event.setPushEvtFlag((String) remove);
        }
        String jSONObjectInstrumentation = JSONObjectInstrumentation.toString(jSONObject);
        if (!this.f47964a) {
            jSONObjectInstrumentation = b.a(jSONObjectInstrumentation);
        }
        event.setContent(jSONObjectInstrumentation);
        list.add(event);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            java.lang.String r0 = "RecordMission"
            com.huawei.hms.analytics.framework.SyncManager r1 = com.huawei.hms.analytics.framework.SyncManager.getInstance()     // Catch:{ InterruptedException -> 0x0017 }
            java.lang.String r2 = "region_change"
            r3 = 2000(0x7d0, double:9.88E-321)
            r1.await(r2, r3)     // Catch:{ InterruptedException -> 0x0017 }
            com.huawei.hms.analytics.framework.SyncManager r1 = com.huawei.hms.analytics.framework.SyncManager.getInstance()     // Catch:{ InterruptedException -> 0x0017 }
            java.lang.String r2 = "aaid_task"
            r1.await(r2, r3)     // Catch:{ InterruptedException -> 0x0017 }
            goto L_0x001c
        L_0x0017:
            java.lang.String r1 = "wait sync error"
            com.huawei.hms.analytics.core.log.HiLog.e(r0, r1)
        L_0x001c:
            com.huawei.hms.analytics.framework.config.ICallback r1 = r10.f47965b
            if (r1 == 0) goto L_0x0087
            java.lang.String r2 = r10.f47966c
            java.util.List<com.huawei.hms.analytics.core.storage.Event> r3 = r10.f47972i
            java.lang.String r4 = "$LaunchApp"
            r5 = 0
            java.lang.String r6 = "$AppFirstOpen"
            if (r3 == 0) goto L_0x0050
            java.util.Iterator r3 = r3.iterator()
        L_0x002f:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x0050
            java.lang.Object r7 = r3.next()
            com.huawei.hms.analytics.core.storage.Event r7 = (com.huawei.hms.analytics.core.storage.Event) r7
            java.lang.String r8 = r7.getEvtId()
            boolean r8 = r8.equals(r6)
            if (r8 != 0) goto L_0x007c
            java.lang.String r7 = r7.getEvtId()
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L_0x002f
            goto L_0x007c
        L_0x0050:
            java.util.List<org.json.JSONObject> r3 = r10.f47969f
            if (r3 == 0) goto L_0x007b
            java.util.Iterator r3 = r3.iterator()
        L_0x0058:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x007b
            java.lang.Object r7 = r3.next()
            org.json.JSONObject r7 = (org.json.JSONObject) r7
            java.lang.String r8 = "^eventId"
            java.lang.String r9 = r7.optString(r8)
            boolean r9 = r6.equals(r9)
            if (r9 != 0) goto L_0x007c
            java.lang.String r7 = r7.optString(r8)
            boolean r7 = r4.equals(r7)
            if (r7 == 0) goto L_0x0058
            goto L_0x007c
        L_0x007b:
            r5 = 1
        L_0x007c:
            boolean r1 = r1.isAAIDChanged(r2, r5)
            if (r1 == 0) goto L_0x0087
            java.lang.String r1 = "aaid changed"
            com.huawei.hms.analytics.core.log.HiLog.i(r0, r1)
        L_0x0087:
            java.util.List<com.huawei.hms.analytics.core.storage.Event> r0 = r10.f47972i
            if (r0 == 0) goto L_0x00ab
            java.util.Iterator r1 = r0.iterator()
        L_0x008f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00a7
            java.lang.Object r2 = r1.next()
            com.huawei.hms.analytics.core.storage.Event r2 = (com.huawei.hms.analytics.core.storage.Event) r2
            java.lang.String r3 = r2.getContent()
            java.lang.String r3 = com.huawei.hms.analytics.framework.c.b.a(r3)
            r2.setContent(r3)
            goto L_0x008f
        L_0x00a7:
            r10.a(r0)
            return
        L_0x00ab:
            java.util.List<org.json.JSONObject> r0 = r10.f47969f
            if (r0 != 0) goto L_0x00b0
            return
        L_0x00b0:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List<org.json.JSONObject> r1 = r10.f47969f
            java.util.Iterator r1 = r1.iterator()
        L_0x00bb:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00cb
            java.lang.Object r2 = r1.next()
            org.json.JSONObject r2 = (org.json.JSONObject) r2
            r10.a(r0, r2)
            goto L_0x00bb
        L_0x00cb:
            int r1 = r0.size()
            if (r1 != 0) goto L_0x00d2
            return
        L_0x00d2:
            boolean r1 = r10.f47964a
            if (r1 == 0) goto L_0x00e9
            com.huawei.hms.analytics.framework.f.a r1 = com.huawei.hms.analytics.framework.f.a.b()
            com.huawei.hms.analytics.framework.c.k r2 = new com.huawei.hms.analytics.framework.c.k
            java.lang.String r3 = r10.f47966c
            java.lang.String r4 = r10.f47967d
            com.huawei.hms.analytics.framework.config.ICallback r5 = r10.f47965b
            r2.<init>(r3, r4, r0, r5)
            r1.a(r2)
            return
        L_0x00e9:
            r10.a(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.framework.c.d.run():void");
    }
}
