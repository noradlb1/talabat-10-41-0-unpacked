package com.huawei.wearengine.sensor;

import com.huawei.wearengine.sensor.AsyncReadCallback;
import com.huawei.wearengine.sensor.SensorClient;

class SensorClient$3$1 extends AsyncReadCallback.Stub {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SensorClient.c f44829b;

    public SensorClient$3$1(SensorClient.c cVar) {
        this.f44829b = cVar;
    }

    public void onReadResult(int i11, DataResult dataResult) {
        this.f44829b.f44837b.onReadResult(i11, dataResult);
    }
}
