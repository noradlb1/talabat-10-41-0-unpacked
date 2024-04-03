package com.huawei.location.logic;

import com.huawei.hms.location.entity.activity.ActivityTransitionRequest;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.base.activity.callback.ATCallback;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.LocationUtil;

public class Vw implements FB {
    private static volatile FB Vw;

    /* renamed from: yn  reason: collision with root package name */
    private static final byte[] f50164yn = new byte[0];
    private yn FB = yn.yn();

    private Vw() {
        LocationUtil.registerScreenStatusBroadcast();
    }

    public static FB yn() {
        if (Vw == null) {
            synchronized (f50164yn) {
                if (Vw == null) {
                    Vw = new Vw();
                }
            }
        }
        return Vw;
    }

    public void yn(long j11, ARCallback aRCallback, ClientInfo clientInfo) {
        LogConsole.i("HwActivityRecognitionManager", "requestActivityUpdates begin.");
        this.FB.yn(j11, aRCallback, clientInfo);
    }

    public void yn(ARCallback aRCallback, ClientInfo clientInfo) {
        LogConsole.i("HwActivityRecognitionManager", "removeActivityUpdates begin.");
        this.FB.yn(aRCallback, clientInfo);
    }

    public void yn(String str, ActivityTransitionRequest activityTransitionRequest, ATCallback aTCallback, ClientInfo clientInfo) {
        this.FB.yn(activityTransitionRequest, aTCallback, clientInfo);
    }

    public void yn(String str, ATCallback aTCallback, ClientInfo clientInfo) {
        this.FB.yn(aTCallback, clientInfo);
    }
}
