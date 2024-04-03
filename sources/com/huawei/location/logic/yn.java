package com.huawei.location.logic;

import android.os.Handler;
import android.os.HandlerThread;
import com.huawei.hms.location.entity.activity.ActivityTransitionRequest;
import com.huawei.location.activity.RiemannSoftArService;
import com.huawei.location.base.activity.AbstractARServiceManager;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.base.activity.callback.ATCallback;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.lite.common.android.receiver.PackageOperateCallback;
import com.huawei.location.lite.common.android.receiver.PackageReceiver;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.ROMUtil;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class yn {
    private static volatile yn Vw;

    /* renamed from: yn  reason: collision with root package name */
    private static final byte[] f50168yn = new byte[0];
    /* access modifiers changed from: private */
    public Map<String, Runnable> E5 = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public AbstractARServiceManager FB = RiemannSoftArService.getInstance();
    /* access modifiers changed from: private */
    public Handler LW;

    /* renamed from: d2  reason: collision with root package name */
    private PackageOperateCallback f50169d2 = new C0082yn();
    /* access modifiers changed from: private */
    public HandlerThread dC;

    /* renamed from: com.huawei.location.logic.yn$yn  reason: collision with other inner class name */
    public class C0082yn implements PackageOperateCallback {

        /* renamed from: com.huawei.location.logic.yn$yn$yn  reason: collision with other inner class name */
        public class C0083yn implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f50171b;

            public C0083yn(String str) {
                this.f50171b = str;
            }

            public void run() {
                try {
                    LogConsole.i("ActivityRecognitionClientImpl", "uninstall:" + this.f50171b + " remove AR and AT request start", true);
                    yn.this.FB.getRecognitionRequestMapping().removeActivityUpdatesMappingInfoByPackageName(this.f50171b);
                    yn.this.FB.getTransitionMappingManager().removeActivityTransitionMappingInfoByPackageName(this.f50171b);
                    yn.this.FB.scheduleTimer();
                    yn.this.E5.remove(this.f50171b);
                    yn.this.LW.getLooper().quitSafely();
                    LogConsole.i("ActivityRecognitionClientImpl", "uninstall:" + this.f50171b + " remove AR and AT request success!");
                } catch (Exception unused) {
                    LogConsole.e("ActivityRecognitionClientImpl", "uninstall:" + this.f50171b + " remove AR and AT exception", true);
                }
            }
        }

        public C0082yn() {
        }

        public void onAdded(String str) {
            LogConsole.i("ActivityRecognitionClientImpl", "call onAdded enter:" + str);
        }

        public void onRemoved(String str) {
            LogConsole.i("ActivityRecognitionClientImpl", "call onRemoved:" + str, true);
            C0083yn ynVar = new C0083yn(str);
            yn.this.E5.put(str, ynVar);
            if (yn.this.LW == null || yn.this.dC == null || !yn.this.dC.isAlive()) {
                yn.d(yn.this);
            }
            yn.this.LW.postDelayed(ynVar, 60000);
            LogConsole.i("ActivityRecognitionClientImpl", "call onRemoved end:" + str);
        }

        public void onReplaced(String str) {
            LogConsole.i("ActivityRecognitionClientImpl", "call onReplaced enter:" + str, true);
            Runnable runnable = (Runnable) yn.this.E5.get(str);
            if (runnable == null) {
                LogConsole.i("ActivityRecognitionClientImpl", "removeThread had deleted or executed", true);
                return;
            }
            yn.this.LW.removeCallbacks(runnable);
            LogConsole.i("ActivityRecognitionClientImpl", "call onReplaced end:" + str + ":cancle removeThread success");
        }
    }

    private yn() {
        PackageReceiver.getInstance().registerCallback(this.f50169d2);
    }

    public static void d(yn ynVar) {
        ynVar.getClass();
        HandlerThread handlerThread = new HandlerThread("Location-ARCImp");
        ynVar.dC = handlerThread;
        handlerThread.start();
        ynVar.LW = new Handler(ynVar.dC.getLooper());
    }

    public static yn yn() {
        if (Vw == null) {
            synchronized (f50168yn) {
                if (Vw == null) {
                    Vw = new yn();
                }
            }
        }
        return Vw;
    }

    private List<String> yn(ClientInfo clientInfo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(clientInfo.getPackageName());
        arrayList.add(clientInfo.getTransactionID());
        arrayList.add("ARService is not support");
        return arrayList;
    }

    public void yn(long j11, ARCallback aRCallback, ClientInfo clientInfo) {
        if (!ROMUtil.isHuaweiPlatformDevice() || ROMUtil.getEmuiVersionCode() >= 17) {
            this.FB.requestActivityUpdates(j11, aRCallback, clientInfo);
            return;
        }
        LogConsole.e("ActivityRecognitionClientImpl", yn(clientInfo), true);
        throw new LocationServiceException(10301, ActivityErrorCode.getErrorCodeMessage(10301) + ":end request.");
    }

    public void yn(ActivityTransitionRequest activityTransitionRequest, ATCallback aTCallback, ClientInfo clientInfo) {
        if (!ROMUtil.isHuaweiPlatformDevice() || ROMUtil.getEmuiVersionCode() >= 17) {
            this.FB.requestActivityTransitionUpdates(activityTransitionRequest, aTCallback, clientInfo);
            return;
        }
        LogConsole.e("ActivityRecognitionClientImpl", yn(clientInfo), true);
        throw new LocationServiceException(10301, ActivityErrorCode.getErrorCodeMessage(10301) + ":end request.");
    }

    public void yn(ARCallback aRCallback, ClientInfo clientInfo) {
        if (!ROMUtil.isHuaweiPlatformDevice() || ROMUtil.getEmuiVersionCode() >= 17) {
            this.FB.removeActivityUpdates(aRCallback, clientInfo);
            return;
        }
        LogConsole.e("ActivityRecognitionClientImpl", yn(clientInfo), true);
        throw new LocationServiceException(10301, ActivityErrorCode.getErrorCodeMessage(10301) + ":end request.");
    }

    public void yn(ATCallback aTCallback, ClientInfo clientInfo) {
        if (!ROMUtil.isHuaweiPlatformDevice() || ROMUtil.getEmuiVersionCode() >= 17) {
            this.FB.removeActivityTransitionUpdates(aTCallback, clientInfo);
            return;
        }
        LogConsole.e("ActivityRecognitionClientImpl", yn(clientInfo), true);
        throw new LocationServiceException(10301, ActivityErrorCode.getErrorCodeMessage(10301) + ":end request.");
    }
}
