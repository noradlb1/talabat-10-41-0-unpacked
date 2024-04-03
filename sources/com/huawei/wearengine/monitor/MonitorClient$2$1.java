package com.huawei.wearengine.monitor;

import com.huawei.wearengine.monitor.MonitorClient;
import com.huawei.wearengine.monitor.MonitorDataCallback;

class MonitorClient$2$1 extends MonitorDataCallback.Stub {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MonitorClient.b f44729b;

    public MonitorClient$2$1(MonitorClient.b bVar) {
        this.f44729b = bVar;
    }

    public void onChanged(int i11, MonitorItem monitorItem, MonitorData monitorData) {
        this.f44729b.f44736c.onChanged(i11, monitorItem, monitorData);
    }
}
