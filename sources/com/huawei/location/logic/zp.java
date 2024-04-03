package com.huawei.location.logic;

import com.huawei.hms.location.entity.activity.ActivityTransition;
import com.huawei.hms.location.entity.activity.ActivityTransitionRequest;
import com.huawei.location.activity.RiemannSoftArService;
import com.huawei.location.base.activity.AbstractARServiceManager;
import com.huawei.location.base.activity.ISoftARManager;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.base.activity.callback.ATCallback;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.lite.common.log.LogConsole;
import java.util.List;

public class zp implements ISoftARManager {
    private static volatile zp Vw;

    /* renamed from: yn  reason: collision with root package name */
    private static final byte[] f50173yn = new byte[0];
    private AbstractARServiceManager FB = RiemannSoftArService.getInstance();

    private zp() {
    }

    public static zp yn() {
        if (Vw == null) {
            synchronized (f50173yn) {
                if (Vw == null) {
                    Vw = new zp();
                }
            }
        }
        return Vw;
    }

    public void removeActivityTransitionUpdates(ATCallback aTCallback) {
        LogConsole.i("SoftARManagerImpl", "removeActivityTransitionUpdates");
        try {
            this.FB.removeActivityTransitionUpdates(aTCallback, (ClientInfo) null);
        } catch (Exception unused) {
            LogConsole.e("SoftARManagerImpl", "removeAT exception", true);
        }
    }

    public void removeActivityUpdates(ARCallback aRCallback) {
        LogConsole.i("SoftARManagerImpl", "removeActivityUpdates");
        try {
            this.FB.removeActivityUpdates(aRCallback, (ClientInfo) null);
        } catch (Exception unused) {
            LogConsole.e("SoftARManagerImpl", "removeAR exception", true);
        }
    }

    public void requestActivityTransitionUpdates(List<ActivityTransition> list, ATCallback aTCallback) {
        LogConsole.i("SoftARManagerImpl", "requestActivityTransitionUpdates");
        ActivityTransitionRequest activityTransitionRequest = new ActivityTransitionRequest();
        activityTransitionRequest.setTransitions(list);
        try {
            this.FB.requestActivityTransitionUpdates(activityTransitionRequest, aTCallback, (ClientInfo) null);
        } catch (Exception unused) {
            LogConsole.e("SoftARManagerImpl", "requestAT exception", true);
        }
    }

    public void requestActivityUpdates(long j11, ARCallback aRCallback) {
        LogConsole.i("SoftARManagerImpl", "requestActivityUpdates");
        if (j11 <= 0) {
            j11 = 30000;
        }
        try {
            this.FB.requestActivityUpdates(j11, aRCallback, (ClientInfo) null);
        } catch (Exception unused) {
            LogConsole.e("SoftARManagerImpl", "requestAR exception", true);
        }
    }
}
