package com.huawei.hms.analytics.framework.c;

import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.core.storage.Event;
import com.huawei.hms.analytics.framework.c.a.a;
import com.huawei.hms.analytics.framework.config.ICallback;
import java.util.ArrayList;
import java.util.List;

public final class e extends a {
    public e(List<Event> list, a aVar, ICallback iCallback) {
        super(list, aVar, iCallback);
    }

    private void e() {
        long b11 = a.b((long) this.f47936a.size());
        this.f47939d.f47946e = false;
        this.f47937b.setStopEventReport(false);
        for (int i11 = 0; ((long) i11) < b11; i11++) {
            try {
                a(a(i11 * 300));
            } catch (IllegalArgumentException e11) {
                HiLog.w("regionProcess", e11.getMessage());
            }
        }
    }

    public final void d() {
        if (b()) {
            a(true, this.f47939d.f47944c);
            try {
                Event a11 = a();
                if (a11 != null) {
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(a11);
                    this.f47939d.f47946e = true;
                    this.f47937b.setStopEventReport(true);
                    a((List<Event>) arrayList);
                }
                e();
            } catch (IllegalArgumentException e11) {
                HiLog.e("regionProcess", e11.getMessage());
            }
        }
    }
}
