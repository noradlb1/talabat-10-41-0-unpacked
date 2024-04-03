package com.huawei.wearengine.device;

import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.wearengine.HiWear;
import com.huawei.wearengine.WearEngineException;
import com.huawei.wearengine.monitor.MonitorItem;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class DeviceClient {

    /* renamed from: b  reason: collision with root package name */
    private static volatile DeviceClient f35149b;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public DeviceServiceProxy f35150a = DeviceServiceProxy.getInstance();

    public class a implements Callable<List<Device>> {
        public a() {
        }

        public Object call() {
            List<Device> bondedDevices = DeviceClient.this.f35150a.getBondedDevices();
            if (bondedDevices != null) {
                return bondedDevices;
            }
            throw new WearEngineException(12);
        }
    }

    public class b implements Callable<Boolean> {
        public b() {
        }

        public Object call() {
            return Boolean.valueOf(DeviceClient.this.f35150a.hasAvailableDevices());
        }
    }

    public class c implements Callable<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Device f35153b;

        public c(Device device) {
            this.f35153b = device;
        }

        public Object call() {
            com.huawei.wearengine.common.a.a(this.f35153b, (Object) "Device can not be null!");
            return DeviceClient.this.f35150a.getHiLinkDeviceId(this.f35153b);
        }
    }

    public class d implements Callable<Integer> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Device f35155b;

        public d(DeviceClient deviceClient, Device device) {
            this.f35155b = device;
        }

        public Object call() {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Integer[] numArr = new Integer[1];
            Integer[] numArr2 = new Integer[1];
            HiWear.getMonitorClient(com.huawei.wearengine.utils.b.a()).query(this.f35155b, MonitorItem.MONITOR_ITEM_USER_AVAILABLE_KBYTES).addOnSuccessListener(new b(this, numArr, numArr2, countDownLatch)).addOnFailureListener(new a(this, numArr, numArr2, countDownLatch));
            try {
                if (!countDownLatch.await(30000, TimeUnit.MILLISECONDS)) {
                    com.huawei.wearengine.common.a.a("DeviceClient", "getAvailableKbytes timeout");
                    throw new WearEngineException(12);
                } else if (numArr2[0].intValue() == 0) {
                    return numArr[0];
                } else {
                    com.huawei.wearengine.common.a.a("DeviceClient", "getAvailableKbytes with WearEngineException");
                    throw new WearEngineException(numArr2[0].intValue());
                }
            } catch (InterruptedException unused) {
                throw com.huawei.wearengine.a.a("DeviceClient", "getAvailableKbytes InterruptedException", 12);
            }
        }
    }

    private DeviceClient() {
    }

    public static DeviceClient getInstance() {
        if (f35149b == null) {
            synchronized (DeviceClient.class) {
                if (f35149b == null) {
                    f35149b = new DeviceClient();
                }
            }
        }
        return f35149b;
    }

    public Task<Integer> getAvailableKbytes(Device device) {
        return Tasks.callInBackground(new d(this, device));
    }

    public Task<List<Device>> getBondedDevices() {
        return Tasks.callInBackground(new a());
    }

    public Task<String> getHiLinkDeviceId(Device device) {
        return Tasks.callInBackground(new c(device));
    }

    public Task<Boolean> hasAvailableDevices() {
        return Tasks.callInBackground(new b());
    }
}
