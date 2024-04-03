package com.huawei.wearengine;

import android.app.Activity;
import android.content.Context;
import com.huawei.wearengine.auth.AuthClient;
import com.huawei.wearengine.client.ServiceConnectionListener;
import com.huawei.wearengine.client.WearEngineClient;
import com.huawei.wearengine.common.a;
import com.huawei.wearengine.device.DeviceClient;
import com.huawei.wearengine.monitor.MonitorClient;
import com.huawei.wearengine.notify.NotifyClient;
import com.huawei.wearengine.p2p.P2pClient;
import com.huawei.wearengine.sensor.SensorClient;
import com.huawei.wearengine.utils.b;

public final class HiWear {
    private HiWear() {
    }

    public static AuthClient getAuthClient(Activity activity) {
        a.a(activity, (Object) "Activity must not be null!");
        return getAuthClient(activity.getApplicationContext());
    }

    public static AuthClient getAuthClient(Context context) {
        a.a(context, (Object) "Context must not be null!");
        b.a(context);
        return AuthClient.getInstance();
    }

    public static DeviceClient getDeviceClient(Activity activity) {
        a.a(activity, (Object) "Activity must not be null!");
        return getDeviceClient(activity.getApplicationContext());
    }

    public static DeviceClient getDeviceClient(Context context) {
        a.a(context, (Object) "Context must not be null!");
        b.a(context);
        return DeviceClient.getInstance();
    }

    public static MonitorClient getMonitorClient(Activity activity) {
        a.a(activity, (Object) "Activity must not be null!");
        return getMonitorClient(activity.getApplicationContext());
    }

    public static MonitorClient getMonitorClient(Context context) {
        a.a(context, (Object) "Context must not be null!");
        b.a(context);
        return MonitorClient.getInstance();
    }

    public static NotifyClient getNotifyClient(Activity activity) {
        a.a(activity, (Object) "Activity must not be null!");
        return getNotifyClient(activity.getApplicationContext());
    }

    public static NotifyClient getNotifyClient(Context context) {
        a.a(context, (Object) "Context must not be null!");
        b.a(context);
        return NotifyClient.getInstance();
    }

    public static P2pClient getP2pClient(Activity activity) {
        a.a(activity, (Object) "Activity must not be null!");
        return getP2pClient(activity.getApplicationContext());
    }

    public static P2pClient getP2pClient(Context context) {
        a.a(context, (Object) "Context must not be null!");
        b.a(context);
        return P2pClient.getInstance();
    }

    public static SensorClient getSensorClient(Activity activity) {
        a.a(activity, (Object) "Activity must not be null!");
        return getSensorClient(activity.getApplicationContext());
    }

    public static SensorClient getSensorClient(Context context) {
        a.a(context, (Object) "Context must not be null!");
        b.a(context);
        return SensorClient.getInstance();
    }

    public static WearEngineClient getWearEngineClient(Activity activity, ServiceConnectionListener serviceConnectionListener) {
        a.a(activity, (Object) "Activity must not be null!");
        return getWearEngineClient(activity.getApplicationContext(), serviceConnectionListener);
    }

    public static WearEngineClient getWearEngineClient(Context context, ServiceConnectionListener serviceConnectionListener) {
        a.a(context, (Object) "Context must not be null!");
        a.a(serviceConnectionListener, (Object) "Listener must not be null!");
        b.a(context);
        return WearEngineClient.getInstance(serviceConnectionListener);
    }
}
