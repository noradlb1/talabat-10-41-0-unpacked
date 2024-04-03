package com.huawei.agconnect.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.common.network.AccessNetworkManager;
import com.huawei.agconnect.credential.obs.ah;
import com.huawei.agconnect.credential.obs.ai;
import java.util.HashMap;
import java.util.Map;

public class HaConnector {
    private static final String HA_HTTP_HEADER = "com.huawei.agconnect";
    private static final String HA_SERVICE_TAG = "AGC_TAG";
    private static final HaConnector INSTANCE = new HaConnector();
    private static final String TAG = "HaConnector";
    /* access modifiers changed from: private */
    public ai hiAnalytics;
    /* access modifiers changed from: private */
    public final Handler mainHandler = new Handler(Looper.getMainLooper());

    private HaConnector() {
    }

    public static synchronized HaConnector getInstance() {
        HaConnector haConnector;
        synchronized (HaConnector.class) {
            haConnector = INSTANCE;
        }
        return haConnector;
    }

    /* access modifiers changed from: private */
    public void initInMainThread(Context context) {
        ai a11 = ah.a(context, HA_SERVICE_TAG, HA_HTTP_HEADER, AGConnectInstance.getInstance().getOptions().getRoutePolicy().getRouteName());
        this.hiAnalytics = a11;
        if (a11 == null) {
            Logger.e(TAG, "init HiAnalyticsBridge SDK error, please make sure the project inherits HiAnalytics SDK correctlyor download the latest agconnect-services.json file and try again.");
        } else {
            Logger.i(TAG, "init HiAnalyticsBridge SDK end.");
        }
    }

    public boolean containHaInstance() {
        return this.hiAnalytics != null;
    }

    public Map<String, String> getUserProfiles(boolean z11) {
        HashMap hashMap = new HashMap();
        ai aiVar = this.hiAnalytics;
        return aiVar != null ? aiVar.a(z11) : hashMap;
    }

    public void init(final Context context) {
        AccessNetworkManager.getInstance().addCallback(new AccessNetworkManager.AccessNetworkCallback() {
            public void onNetWorkReady() {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    HaConnector.this.initInMainThread(context);
                } else {
                    HaConnector.this.mainHandler.post(new Runnable() {
                        public void run() {
                            AnonymousClass1 r02 = AnonymousClass1.this;
                            HaConnector.this.initInMainThread(context);
                        }
                    });
                }
                HaConnector.this.mainHandler.postDelayed(new Runnable() {
                    public void run() {
                        if (HaConnector.this.hiAnalytics != null) {
                            Logger.i(HaConnector.TAG, "Auto onReport");
                            HaConnector.this.hiAnalytics.a();
                        }
                    }
                }, 5000);
            }
        });
    }

    public void onEvent(String str, Bundle bundle) {
        ai aiVar = this.hiAnalytics;
        if (aiVar != null) {
            aiVar.a(str, bundle);
        }
    }

    public void onReport() {
        ai aiVar = this.hiAnalytics;
        if (aiVar != null) {
            aiVar.a();
        }
    }
}
