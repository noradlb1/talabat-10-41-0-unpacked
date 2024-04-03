package com.huawei.wearengine.device;

import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.wearengine.device.DeviceClient;
import com.huawei.wearengine.monitor.MonitorData;
import java.util.concurrent.CountDownLatch;

class b implements OnSuccessListener<MonitorData> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Integer[] f35173a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Integer[] f35174b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f35175c;

    public b(DeviceClient.d dVar, Integer[] numArr, Integer[] numArr2, CountDownLatch countDownLatch) {
        this.f35173a = numArr;
        this.f35174b = numArr2;
        this.f35175c = countDownLatch;
    }

    public void onSuccess(Object obj) {
        MonitorData monitorData = (MonitorData) obj;
        if (monitorData == null) {
            this.f35173a[0] = -1;
            this.f35174b[0] = 12;
        } else {
            this.f35173a[0] = Integer.valueOf(monitorData.asInt());
            this.f35174b[0] = 0;
        }
        this.f35175c.countDown();
    }
}
