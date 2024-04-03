package com.huawei.hms.analytics;

import android.content.Context;
import android.os.Looper;
import com.huawei.hms.analytics.bg;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.database.APIEvent;
import com.huawei.hms.analytics.framework.SyncManager;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.utils.HMSBIInitializer;

public final class efg {
    private static boolean klm = false;
    private static final HiAnalyticsInstance lmn = new HiAnalyticsInstance();

    public static synchronized HiAnalyticsInstance lmn(Context context, String str) {
        boolean z11;
        synchronized (efg.class) {
            if (!ea.lmn().lmn(context)) {
                HiLog.e("HiAnalyticsCreation", "The user is not unlocked.");
                HiAnalyticsInstance hiAnalyticsInstance = lmn;
                return hiAnalyticsInstance;
            }
            if (Looper.getMainLooper() != Looper.myLooper()) {
                HiLog.e("HiAnalyticsCreation", HiLog.ErrorCode.IE001, "init must be called in the main thread");
                z11 = false;
            } else {
                z11 = true;
            }
            if (!z11) {
                HiAnalyticsInstance hiAnalyticsInstance2 = lmn;
                return hiAnalyticsInstance2;
            }
            Context applicationContext = context.getApplicationContext() != null ? context.getApplicationContext() : context;
            cj lmn2 = ck.lmn("HiAnalyticsInstance#getInstance(Context)");
            try {
                def def = (def) cde.lmn().lmn("_openness_config_tag");
                if (def == null) {
                    def = new def(applicationContext);
                    lmn.lmn = def;
                    cde.lmn().lmn("_openness_config_tag", (bl) def);
                }
                if (!klm) {
                    cde.lmn();
                    cde.klm(context);
                    cde.lmn();
                    cde.lmn(applicationContext, (bl) def);
                    cde.lmn();
                    cde.lmn(applicationContext);
                    klm = true;
                }
                fgh fgh = new fgh(context, "_openness_config_tag", str, SyncManager.TaskNames.INIT_TASK_OPENNESS);
                fgh.lmn(new ikl(def));
                fgh.lmn(ck.lmn("HiAnalyticsInstance#initTask"));
                try {
                    Class.forName("com.huawei.hms.analytics.extended.Plugin");
                    dg.ikl().lmn(new cr(context));
                } catch (ClassNotFoundException unused) {
                    HiLog.w("HiAnalyticsCreation", "not find analytics plugin");
                }
                cde.lmn();
                cde.lmn((hij) fgh);
                lmn2.lmn = "0";
            } catch (bg.lmn e11) {
                HiLog.e("HiAnalyticsCreation", HiLog.ErrorCode.SE001, "DBException");
                lmn2.klm = "SE-001:002";
                dr.lmn(e11);
                try {
                    HMSBIInitializer.getInstance(applicationContext).initBI();
                    APIEvent klm2 = ck.klm(lmn2);
                    HiAnalyticsUtil.getInstance().onNewEvent(applicationContext, klm2.getCode(), klm2.toMap());
                } catch (Exception | NoClassDefFoundError unused2) {
                    HiLog.w("APIEvtRecordHolder", "init hms BISDK failed");
                }
            } catch (Throwable th2) {
                ck.lmn(lmn2);
                throw th2;
            }
            ck.lmn(lmn2);
            HiAnalyticsInstance hiAnalyticsInstance3 = lmn;
            return hiAnalyticsInstance3;
        }
    }
}
