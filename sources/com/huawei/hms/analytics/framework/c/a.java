package com.huawei.hms.analytics.framework.c;

import android.text.TextUtils;
import com.huawei.hms.analytics.core.crypto.RandomUtil;
import com.huawei.hms.analytics.core.crypto.RsaCipher;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.core.storage.Event;
import com.huawei.hms.analytics.core.storage.IStorageHandler;
import com.huawei.hms.analytics.framework.b.b;
import com.huawei.hms.analytics.framework.b.d;
import com.huawei.hms.analytics.framework.b.e;
import com.huawei.hms.analytics.framework.c.a.c;
import com.huawei.hms.analytics.framework.config.DeviceAttributeCollector;
import com.huawei.hms.analytics.framework.config.ICallback;
import com.huawei.hms.analytics.framework.config.ICollectorConfig;
import com.huawei.hms.analytics.framework.config.IConfig;
import com.huawei.hms.analytics.framework.policy.IStoragePolicy;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Instrumented
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected List<Event> f47936a;

    /* renamed from: b  reason: collision with root package name */
    protected ICallback f47937b;

    /* renamed from: c  reason: collision with root package name */
    protected IStorageHandler f47938c;

    /* renamed from: d  reason: collision with root package name */
    protected com.huawei.hms.analytics.framework.c.a.a f47939d;

    /* renamed from: e  reason: collision with root package name */
    private ICollectorConfig f47940e;

    /* renamed from: f  reason: collision with root package name */
    private IStoragePolicy f47941f;

    public a(List<Event> list, com.huawei.hms.analytics.framework.c.a.a aVar, ICallback iCallback) {
        this.f47936a = list;
        this.f47937b = iCallback;
        this.f47939d = aVar;
        ICollectorConfig a11 = b.a().a(aVar.f47942a);
        this.f47940e = a11;
        a11.setIConfig(aVar.f47944c);
        this.f47941f = com.huawei.hms.analytics.framework.a.a.b(aVar.f47942a);
        this.f47938c = com.huawei.hms.analytics.framework.a.a.a(aVar.f47942a);
    }

    private c a(String str) {
        e a11 = e.a();
        String site = this.f47939d.f47944c.getSite();
        d dVar = a11.f47935a.get(site);
        if (dVar == null) {
            dVar = new d();
            e.a(dVar, site);
            a11.f47935a.put(site, dVar);
        } else {
            if (!dVar.f47932d.equals(e.a(site))) {
                e.a(dVar, site);
            }
            if (System.currentTimeMillis() - dVar.f47931c > 43200000) {
                String generateSecureRandomStr = RandomUtil.getInstance().generateSecureRandomStr(16);
                String encrypt = RsaCipher.encrypt(dVar.a(), generateSecureRandomStr);
                dVar.f47929a = generateSecureRandomStr;
                dVar.f47930b = encrypt;
                dVar.f47931c = System.currentTimeMillis();
            }
        }
        if (TextUtils.isEmpty(dVar.f47930b)) {
            return null;
        }
        this.f47940e.syncOaid();
        String appId = this.f47940e.getAppId();
        DeviceAttributeCollector deviceAttribute = this.f47940e.getDeviceAttribute(this.f47939d.f47943b);
        String str2 = dVar.f47930b;
        com.huawei.hms.analytics.framework.c.a.b bVar = new com.huawei.hms.analytics.framework.c.a.b();
        bVar.f47949b = appId;
        bVar.f47948a = str2;
        bVar.f47952e = str;
        bVar.f47950c = this.f47939d.f47942a;
        StringBuffer stringBuffer = new StringBuffer("hmshi");
        stringBuffer.append(this.f47939d.f47943b);
        stringBuffer.append("qrt");
        bVar.f47953f = stringBuffer.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.currentTimeMillis());
        bVar.f47951d = sb2.toString();
        return new c(deviceAttribute, this.f47940e.getEvtCustomHeader(this.f47939d.f47943b, bVar.a()), this.f47940e.getRomAttribute(this.f47939d.f47943b), dVar.f47929a, this.f47939d.f47942a);
    }

    private void a(byte[] bArr, String str, List<Event> list) {
        com.huawei.hms.analytics.framework.c.a.a aVar = this.f47939d;
        aVar.f47945d = str;
        i iVar = new i(bArr, aVar, list);
        iVar.f47980a = this.f47937b;
        iVar.run();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0091 A[Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0094 A[Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] a(java.util.List<com.huawei.hms.analytics.core.storage.Event> r6, com.huawei.hms.analytics.framework.c.a.c r7, boolean r8) {
        /*
            r0 = 0
            java.lang.String r1 = "ReportAssignment"
            r2 = 0
            java.lang.String r3 = "UploadEvtBean"
            if (r6 == 0) goto L_0x008c
            int r4 = r6.size()     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            if (r4 != 0) goto L_0x0010
            goto L_0x008c
        L_0x0010:
            com.huawei.hms.analytics.framework.config.EvtHeaderAttributeCollector r4 = r7.f47956c     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            if (r4 == 0) goto L_0x0089
            com.huawei.hms.analytics.framework.config.DeviceAttributeCollector r4 = r7.f47955b     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            if (r4 == 0) goto L_0x0089
            com.huawei.hms.analytics.framework.config.RomAttributeCollector r4 = r7.f47957d     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            if (r4 != 0) goto L_0x001d
            goto L_0x0089
        L_0x001d:
            org.json.JSONArray r6 = r7.a(r6, r8)     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            int r8 = r6.length()     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            if (r8 != 0) goto L_0x002d
            java.lang.String r6 = "send data is empty"
            com.huawei.hms.analytics.core.log.HiLog.i(r3, r6)     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            goto L_0x008f
        L_0x002d:
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            r8.<init>()     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            com.huawei.hms.analytics.framework.config.EvtHeaderAttributeCollector r4 = r7.f47956c     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            org.json.JSONObject r4 = r4.doCollector()     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            if (r4 != 0) goto L_0x0040
            java.lang.String r6 = "headerJson is null"
        L_0x003c:
            com.huawei.hms.analytics.core.log.HiLog.w(r3, r6)     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            goto L_0x008f
        L_0x0040:
            java.lang.String r2 = "servicetag"
            java.lang.String r3 = r7.a()     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            r4.put((java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            java.lang.String r2 = "header"
            r8.put((java.lang.String) r2, (java.lang.Object) r4)     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            r2.<init>()     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            com.huawei.hms.analytics.framework.config.DeviceAttributeCollector r3 = r7.f47955b     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            org.json.JSONObject r3 = r3.doCollector()     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            java.lang.String r4 = "properties"
            com.huawei.hms.analytics.framework.config.RomAttributeCollector r5 = r7.f47957d     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            org.json.JSONObject r5 = r5.doCollector()     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            r3.put((java.lang.String) r4, (java.lang.Object) r5)     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            java.lang.String r4 = "events_common"
            r2.put((java.lang.String) r4, (java.lang.Object) r3)     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            java.lang.String r3 = "events"
            r2.put((java.lang.String) r3, (java.lang.Object) r6)     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            java.lang.String r6 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r2)     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            java.nio.charset.Charset r2 = com.huawei.hms.analytics.framework.c.a.c.f47954a     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            byte[] r6 = r6.getBytes(r2)     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            byte[] r6 = com.huawei.hms.analytics.framework.g.a.a((byte[]) r6)     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            java.lang.String r7 = r7.f47958e     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            java.lang.String r6 = com.huawei.hms.analytics.core.crypto.AesCipher.encryptCbc((byte[]) r6, (java.lang.String) r7)     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            java.lang.String r7 = "event"
            r8.put((java.lang.String) r7, (java.lang.Object) r6)     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            r2 = r8
            goto L_0x008f
        L_0x0089:
            java.lang.String r6 = "one attributeModel is null"
            goto L_0x003c
        L_0x008c:
            java.lang.String r6 = "Not have actionEvent to send"
            goto L_0x003c
        L_0x008f:
            if (r2 != 0) goto L_0x0094
            byte[] r6 = new byte[r0]     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            return r6
        L_0x0094:
            java.lang.String r6 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r2)     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            java.lang.String r7 = "UTF-8"
            byte[] r6 = r6.getBytes(r7)     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            byte[] r6 = com.huawei.hms.analytics.framework.g.a.a((byte[]) r6)     // Catch:{ UnsupportedEncodingException -> 0x00a6, JSONException -> 0x00a3 }
            return r6
        L_0x00a3:
            java.lang.String r6 = "json exception"
            goto L_0x00a8
        L_0x00a6:
            java.lang.String r6 = "sendData(): getBytes - Unsupported coding format!!"
        L_0x00a8:
            com.huawei.hms.analytics.core.log.HiLog.w(r1, r6)
            byte[] r6 = new byte[r0]
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.framework.c.a.a(java.util.List, com.huawei.hms.analytics.framework.c.a.c, boolean):byte[]");
    }

    public static long b(long j11) {
        long j12 = j11 / 300;
        return j11 % 300 > 0 ? j12 + 1 : j12;
    }

    public final Event a() {
        return this.f47940e.getSpecialEvent(this.f47939d.f47943b);
    }

    public final List<Event> a(int i11) {
        List<Event> list = this.f47936a;
        List<Event> subList = list.subList(i11, Math.min(list.size(), i11 + 300));
        a(subList, false);
        return subList;
    }

    public final void a(long j11) {
        ICallback iCallback = this.f47937b;
        if (iCallback != null) {
            iCallback.onResult(-1, j11, -1, this.f47936a);
        }
    }

    public final void a(List<Event> list) {
        String generateSecureRandomStr = RandomUtil.getInstance().generateSecureRandomStr(16);
        c a11 = a(generateSecureRandomStr);
        if (a11 != null) {
            byte[] a12 = a(list, a11, this.f47939d.f47946e);
            if (a12.length != 0) {
                a(a12, generateSecureRandomStr, list);
            } else {
                HiLog.w("ReportAssignment", "request body is empty");
                throw new IllegalArgumentException("body length is empty");
            }
        } else {
            throw new IllegalArgumentException("uploadEvtModel is null");
        }
    }

    public final void a(List<Event> list, boolean z11) {
        ArrayList arrayList = new ArrayList();
        Iterator<Event> it = list.iterator();
        while (it.hasNext()) {
            Event next = it.next();
            if (this.f47941f.decide(IStoragePolicy.PolicyType.STORAGECYCLY, Long.parseLong(next.getEvtTime()))) {
                arrayList.add(next);
                it.remove();
            }
        }
        if (arrayList.size() > 0 && z11 && this.f47938c != null) {
            HiLog.d("ReportAssignment", "delete events: " + arrayList.size());
            this.f47938c.deleteEvents(arrayList);
        }
    }

    public final void a(boolean z11, IConfig iConfig) {
        this.f47940e.serviceListener(z11, iConfig);
    }

    public final boolean b() {
        return this.f47941f.decide(IStoragePolicy.PolicyType.PARAMS, (Object) this.f47939d.f47944c);
    }

    public final void c() {
        a(this.f47936a);
    }
}
