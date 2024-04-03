package com.huawei.wearengine.sensor;

import com.huawei.wearengine.sensor.AsyncReadCallback;
import com.huawei.wearengine.sensor.SensorClient;

class SensorClient$2$1 extends AsyncReadCallback.Stub {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SensorClient.b f44828b;

    public SensorClient$2$1(SensorClient.b bVar) {
        this.f44828b = bVar;
    }

    public void onReadResult(int i11, DataResult dataResult) {
        this.f44828b.f44833b.onReadResult(i11, dataResult);
    }
}
