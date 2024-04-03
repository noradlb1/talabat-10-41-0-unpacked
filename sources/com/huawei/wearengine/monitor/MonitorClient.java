package com.huawei.wearengine.monitor;

import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.wearengine.WearEngineException;
import com.huawei.wearengine.device.Device;
import java.util.List;
import java.util.concurrent.Callable;

public final class MonitorClient {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public MonitorServiceProxy f44727a = new MonitorServiceProxy();

    public class a implements Callable<Void> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Device f44731b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ MonitorListener f44732c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ MonitorItem f44733d;

        public a(Device device, MonitorListener monitorListener, MonitorItem monitorItem) {
            this.f44731b = device;
            this.f44732c = monitorListener;
            this.f44733d = monitorItem;
        }

        public Object call() {
            com.huawei.wearengine.common.a.a(this.f44731b, (Object) "Device can not be null!");
            com.huawei.wearengine.common.a.a(this.f44732c, (Object) "register single monitor, monitorListener can not be null!");
            MonitorClient$1$1 monitorClient$1$1 = new MonitorClient$1$1(this);
            int registerListener = MonitorClient.this.f44727a.registerListener(this.f44731b, com.huawei.wearengine.utils.b.a().getPackageName(), this.f44733d, monitorClient$1$1, System.identityHashCode(this.f44732c));
            if (registerListener == 0) {
                return null;
            }
            throw new WearEngineException(registerListener);
        }
    }

    public class b implements Callable<Void> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Device f44735b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ MonitorListener f44736c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f44737d;

        public b(Device device, MonitorListener monitorListener, List list) {
            this.f44735b = device;
            this.f44736c = monitorListener;
            this.f44737d = list;
        }

        public Object call() {
            com.huawei.wearengine.common.a.a(this.f44735b, (Object) "Device can not be null!");
            com.huawei.wearengine.common.a.a(this.f44736c, (Object) "Register monitorListener can not be null!");
            MonitorClient$2$1 monitorClient$2$1 = new MonitorClient$2$1(this);
            int registerListListener = MonitorClient.this.f44727a.registerListListener(this.f44735b, com.huawei.wearengine.utils.b.a().getPackageName(), this.f44737d, monitorClient$2$1, System.identityHashCode(this.f44736c));
            if (registerListListener == 0) {
                return null;
            }
            throw new WearEngineException(registerListListener);
        }
    }

    public class c implements Callable<Void> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MonitorListener f44739b;

        public c(MonitorListener monitorListener) {
            this.f44739b = monitorListener;
        }

        public Object call() {
            com.huawei.wearengine.common.a.a(this.f44739b, (Object) "Unregister monitorListener can not be null!");
            int unregisterListener = MonitorClient.this.f44727a.unregisterListener(new MonitorClient$3$1(this), System.identityHashCode(this.f44739b));
            if (unregisterListener == 0) {
                return null;
            }
            throw new WearEngineException(unregisterListener);
        }
    }

    public class d implements Callable<MonitorData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Device f44741b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ MonitorItem f44742c;

        public d(Device device, MonitorItem monitorItem) {
            this.f44741b = device;
            this.f44742c = monitorItem;
        }

        public Object call() {
            com.huawei.wearengine.common.a.a(this.f44741b, (Object) "Device can not be null!");
            com.huawei.wearengine.common.a.a(this.f44742c, (Object) "MonitorItem can not be null!");
            MonitorData query = MonitorClient.this.f44727a.query(this.f44741b, this.f44742c);
            if (query != null) {
                return query;
            }
            throw new WearEngineException(12);
        }
    }

    public static class e {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final MonitorClient f44744a = new MonitorClient((a) null);
    }

    private MonitorClient() {
    }

    public /* synthetic */ MonitorClient(a aVar) {
    }

    public static MonitorClient getInstance() {
        return e.f44744a;
    }

    public Task<MonitorData> query(Device device, MonitorItem monitorItem) {
        return Tasks.callInBackground(new d(device, monitorItem));
    }

    public Task<Void> register(Device device, MonitorItem monitorItem, MonitorListener monitorListener) {
        return Tasks.callInBackground(new a(device, monitorListener, monitorItem));
    }

    public Task<Void> register(Device device, List<MonitorItem> list, MonitorListener monitorListener) {
        return Tasks.callInBackground(new b(device, monitorListener, list));
    }

    public Task<Void> unregister(MonitorListener monitorListener) {
        return Tasks.callInBackground(new c(monitorListener));
    }
}
