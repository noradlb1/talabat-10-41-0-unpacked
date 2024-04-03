package com.huawei.wearengine.monitor;

import com.huawei.wearengine.monitor.MonitorClient;
import com.huawei.wearengine.monitor.MonitorDataCallback;

class MonitorClient$1$1 extends MonitorDataCallback.Stub {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MonitorClient.a f44728b;

    public MonitorClient$1$1(MonitorClient.a aVar) {
        this.f44728b = aVar;
    }

    public void onChanged(int i11, MonitorItem monitorItem, MonitorData monitorData) {
        this.f44728b.f44732c.onChanged(i11, monitorItem, monitorData);
    }
}
