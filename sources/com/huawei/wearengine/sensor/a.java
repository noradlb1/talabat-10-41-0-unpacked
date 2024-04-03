package com.huawei.wearengine.sensor;

import com.huawei.wearengine.WearEngineException;
import com.huawei.wearengine.device.Device;
import java.util.List;
import java.util.concurrent.Callable;

class a implements Callable<Void> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SensorStopCallback f44842b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Sensor f44843c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Device f44844d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ List f44845e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ SensorClient f44846f;

    public a(SensorClient sensorClient, SensorStopCallback sensorStopCallback, Sensor sensor, Device device, List list) {
        this.f44846f = sensorClient;
        this.f44842b = sensorStopCallback;
        this.f44843c = sensor;
        this.f44844d = device;
        this.f44845e = list;
    }

    public Object call() {
        SensorClient$4$1 sensorClient$4$1 = new SensorClient$4$1(this);
        int stopAsyncReadSensors = this.f44843c == null ? this.f44846f.f44827a.stopAsyncReadSensors(this.f44844d, this.f44845e, sensorClient$4$1) : this.f44846f.f44827a.stopAsyncRead(this.f44844d, this.f44843c, sensorClient$4$1);
        if (stopAsyncReadSensors == 0) {
            return null;
        }
        throw new WearEngineException(stopAsyncReadSensors);
    }
}
