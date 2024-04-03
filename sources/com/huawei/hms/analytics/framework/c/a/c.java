package com.huawei.hms.analytics.framework.c.a;

import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.core.storage.Event;
import com.huawei.hms.analytics.core.storage.IStorageHandler;
import com.huawei.hms.analytics.framework.a.a;
import com.huawei.hms.analytics.framework.b.b;
import com.huawei.hms.analytics.framework.config.DeviceAttributeCollector;
import com.huawei.hms.analytics.framework.config.EvtHeaderAttributeCollector;
import com.huawei.hms.analytics.framework.config.ICollectorConfig;
import com.huawei.hms.analytics.framework.config.RomAttributeCollector;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f47954a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    public DeviceAttributeCollector f47955b;

    /* renamed from: c  reason: collision with root package name */
    public EvtHeaderAttributeCollector f47956c;

    /* renamed from: d  reason: collision with root package name */
    public RomAttributeCollector f47957d;

    /* renamed from: e  reason: collision with root package name */
    public String f47958e;

    /* renamed from: f  reason: collision with root package name */
    private String f47959f;

    /* renamed from: g  reason: collision with root package name */
    private List<Event> f47960g;

    /* renamed from: h  reason: collision with root package name */
    private ICollectorConfig f47961h;

    /* renamed from: i  reason: collision with root package name */
    private List<String> f47962i;

    public c(DeviceAttributeCollector deviceAttributeCollector, EvtHeaderAttributeCollector evtHeaderAttributeCollector, RomAttributeCollector romAttributeCollector, String str, String str2) {
        this.f47955b = deviceAttributeCollector;
        this.f47956c = evtHeaderAttributeCollector;
        this.f47957d = romAttributeCollector;
        this.f47958e = str;
        this.f47959f = str2;
        this.f47961h = b.a().a(str2);
    }

    private void a(JSONArray jSONArray, Event event, boolean z11) {
        String content = event.getContent();
        if (!z11) {
            content = com.huawei.hms.analytics.framework.c.b.a(content, b.a().f47924a);
        }
        event.setContent(content);
        JSONObject json = event.toJson();
        if (json != null) {
            jSONArray.put((Object) json);
            return;
        }
        if (this.f47960g == null) {
            this.f47960g = new ArrayList();
        }
        this.f47960g.add(event);
        HiLog.w("UploadEvtBean", "custom event is empty,delete this event");
    }

    public final String a() {
        List<String> list = this.f47962i;
        if (list == null || list.size() <= 1) {
            return this.f47959f;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String append : this.f47962i) {
            sb2.append(append);
            sb2.append("|");
        }
        return sb2.substring(0, sb2.length() - 1);
    }

    public final JSONArray a(List<Event> list, boolean z11) {
        IStorageHandler a11;
        List list2;
        JSONArray jSONArray = new JSONArray();
        for (Event next : list) {
            if (!"$AppPushToken".equals(next.getEvtId()) || !this.f47961h.isDebugModel()) {
                try {
                    a(jSONArray, next.clone(), z11);
                    String serviceTag = next.getServiceTag();
                    List<String> list3 = this.f47962i;
                    if (list3 == null) {
                        list2 = new ArrayList();
                        this.f47962i = list2;
                    } else if (!list3.contains(serviceTag)) {
                        list2 = this.f47962i;
                    }
                    list2.add(serviceTag);
                } catch (CloneNotSupportedException unused) {
                    HiLog.w("UploadEvtBean", "CloneNotSupportedException");
                    a(jSONArray, next, z11);
                }
            }
        }
        List<Event> list4 = this.f47960g;
        if (!(list4 == null || list4.size() <= 0 || (a11 = a.a(this.f47959f)) == null)) {
            a11.deleteEvents(this.f47960g);
        }
        return jSONArray;
    }
}
