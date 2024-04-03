package com.huawei.wearengine.sensor;

import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.wearengine.WearEngineException;
import com.huawei.wearengine.device.Device;
import java.util.List;
import java.util.concurrent.Callable;

public class SensorClient {

    /* renamed from: b  reason: collision with root package name */
    private static volatile SensorClient f44826b;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public SensorServiceProxy f44827a = SensorServiceProxy.getInstance();

    public class a implements Callable<List<Sensor>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Device f44831b;

        public a(Device device) {
            this.f44831b = device;
        }

        public Object call() {
            List<Sensor> sensorList = SensorClient.this.f44827a.getSensorList(this.f44831b);
            if (sensorList != null) {
                return sensorList;
            }
            throw new WearEngineException(12);
        }
    }

    public class b implements Callable<Void> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SensorReadCallback f44833b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Device f44834c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Sensor f44835d;

        public b(SensorReadCallback sensorReadCallback, Device device, Sensor sensor) {
            this.f44833b = sensorReadCallback;
            this.f44834c = device;
            this.f44835d = sensor;
        }

        public Object call() {
            int asyncRead = SensorClient.this.f44827a.asyncRead(this.f44834c, this.f44835d, new SensorClient$2$1(this));
            if (asyncRead == 0) {
                return null;
            }
            throw new WearEngineException(asyncRead);
        }
    }

    public class c implements Callable<Void> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SensorReadCallback f44837b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Device f44838c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f44839d;

        public c(SensorReadCallback sensorReadCallback, Device device, List list) {
            this.f44837b = sensorReadCallback;
            this.f44838c = device;
            this.f44839d = list;
        }

        public Object call() {
            int asyncReadSensors = SensorClient.this.f44827a.asyncReadSensors(this.f44838c, this.f44839d, new SensorClient$3$1(this));
            if (asyncReadSensors == 0) {
                return null;
            }
            throw new WearEngineException(asyncReadSensors);
        }
    }

    private SensorClient() {
    }

    public static SensorClient getInstance() {
        if (f44826b == null) {
            synchronized (SensorClient.class) {
                if (f44826b == null) {
                    f44826b = new SensorClient();
                }
            }
        }
        return f44826b;
    }

    public Task<Void> asyncRead(Device device, Sensor sensor, SensorReadCallback sensorReadCallback) {
        return Tasks.callInBackground(new b(sensorReadCallback, device, sensor));
    }

    public Task<Void> asyncRead(Device device, List<Sensor> list, SensorReadCallback sensorReadCallback) {
        return Tasks.callInBackground(new c(sensorReadCallback, device, list));
    }

    public Task<List<Sensor>> getSensorList(Device device) {
        return Tasks.callInBackground(new a(device));
    }

    public Task<Void> stopAsyncRead(Device device, Sensor sensor, SensorStopCallback sensorStopCallback) {
        return Tasks.callInBackground(new a(this, sensorStopCallback, sensor, device, (List) null));
    }

    public Task<Void> stopAsyncRead(Device device, List<Sensor> list, SensorStopCallback sensorStopCallback) {
        return Tasks.callInBackground(new a(this, sensorStopCallback, (Sensor) null, device, list));
    }
}
