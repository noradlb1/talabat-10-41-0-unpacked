package com.huawei.hms.analytics.framework.c;

import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.core.storage.Event;
import com.huawei.hms.analytics.core.storage.IStorageHandler;
import com.huawei.hms.analytics.framework.b.b;
import com.huawei.hms.analytics.framework.c.a.a;
import com.huawei.hms.analytics.framework.config.ICallback;
import com.huawei.hms.analytics.framework.config.IConfig;
import java.util.ArrayList;
import java.util.List;

public final class g extends a {
    public g(List<Event> list, a aVar, ICallback iCallback) {
        super(list, aVar, iCallback);
    }

    private void b(List<String> list) {
        List<Event> readEvents = this.f47938c.readEvents(list);
        long b11 = a.b((long) readEvents.size());
        HiLog.d("ReportAssignment", this.f47939d.f47942a + " report times: " + b11);
        for (int i11 = 0; ((long) i11) < b11; i11++) {
            int i12 = i11 * 300;
            List<Event> subList = readEvents.subList(i12, Math.min(readEvents.size(), i12 + 300));
            a(subList, true);
            a(subList);
        }
    }

    private void e() {
        this.f47939d.f47946e = false;
        this.f47937b.setStopEventReport(false);
        List<String> serviceTagsByElbHeader = b.a().a(this.f47939d.f47942a).getServiceTagsByElbHeader(this.f47939d.f47944c.getSite());
        if (serviceTagsByElbHeader.size() == 0) {
            long count = this.f47938c.count(this.f47939d.f47942a);
            HiLog.d("ReportAssignment", this.f47939d.f47942a + " report count: " + count);
            long b11 = a.b(count);
            for (int i11 = 0; ((long) i11) < b11; i11++) {
                IStorageHandler iStorageHandler = this.f47938c;
                a aVar = this.f47939d;
                List<Event> readEvents = iStorageHandler.readEvents(aVar.f47942a, aVar.f47943b, 300);
                a(readEvents, true);
                a(readEvents);
            }
            return;
        }
        b(serviceTagsByElbHeader);
    }

    public final void d() {
        if (b()) {
            a(false, (IConfig) null);
            try {
                Event a11 = a();
                if (a11 != null) {
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(a11);
                    this.f47939d.f47946e = true;
                    this.f47937b.setStopEventReport(true);
                    a((List<Event>) arrayList);
                }
            } catch (IllegalArgumentException e11) {
                HiLog.e("ReportAssignment", e11.getMessage());
                a(System.currentTimeMillis());
            }
            try {
                if (this.f47938c != null) {
                    e();
                }
            } catch (Exception unused) {
                HiLog.e("ReportAssignment", "upload data failed.");
            }
        }
    }
}
