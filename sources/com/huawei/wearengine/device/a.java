package com.huawei.wearengine.device;

import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.wearengine.common.WearEngineErrorCode;
import com.huawei.wearengine.device.DeviceClient;
import java.util.concurrent.CountDownLatch;

class a implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Integer[] f35170a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Integer[] f35171b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f35172c;

    public a(DeviceClient.d dVar, Integer[] numArr, Integer[] numArr2, CountDownLatch countDownLatch) {
        this.f35170a = numArr;
        this.f35171b = numArr2;
        this.f35172c = countDownLatch;
    }

    public void onFailure(Exception exc) {
        com.huawei.wearengine.common.a.a("DeviceClient", "getAvailableKbytes query Exception");
        this.f35170a[0] = -1;
        this.f35171b[0] = Integer.valueOf(WearEngineErrorCode.getErrorCodeFromErrorMsg(exc.getMessage()));
        this.f35172c.countDown();
    }
}
