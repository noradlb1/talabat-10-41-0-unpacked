package com.huawei.wisesecurity.kfs.ha;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.wisesecurity.kfs.exception.ParamException;
import com.huawei.wisesecurity.kfs.ha.message.ReportMsgBuilder;
import com.huawei.wisesecurity.kfs.log.KfsLog;

public class HaReporter {
    public static final String TAG = "HaReporter";
    public HiAnalyticsInstance analyticsInstance;
    public final BIChecker biChecker;
    public final KfsLog kfsLog;

    public HaReporter(Context context, String str, String str2, KfsLog kfsLog2) throws ParamException {
        if (!TextUtils.isEmpty(str2)) {
            this.kfsLog = kfsLog2;
            kfsLog2.i(TAG, "hiAnalyticsUrl is " + str2);
            this.biChecker = new BIChecker(kfsLog2);
            initHaInstance(str2, context, str);
            return;
        }
        throw new ParamException("hiAnalyticsUrl is empty");
    }

    private void initHaInstance(String str, Context context, String str2) {
        HiAnalyticsConfig build = new HiAnalyticsConfig.Builder().setCollectURL(str).setEnableUUID(false).build();
        this.analyticsInstance = new HiAnalyticsInstance.Builder(context).setMaintConf(build).setOperConf(build).refresh(str2);
    }

    public void onEvent(Context context, ReportMsgBuilder reportMsgBuilder) {
        onEvent(context, reportMsgBuilder, HiAnalyticsType.HIANALYTICS_MAINTENANCE);
    }

    public void onEvent(Context context, ReportMsgBuilder reportMsgBuilder, HiAnalyticsType hiAnalyticsType) {
        KfsLog kfsLog2;
        String str;
        if (this.analyticsInstance == null) {
            kfsLog2 = this.kfsLog;
            str = "onEvent null == analyticsInstance";
        } else if (this.biChecker.hasError(context)) {
            kfsLog2 = this.kfsLog;
            str = "onEvent isEnabledUserExperience is false";
        } else {
            try {
                this.analyticsInstance.onEvent(hiAnalyticsType.getCode(), reportMsgBuilder.getEventId(), reportMsgBuilder.build());
                this.kfsLog.i(TAG, "onEvent success");
                return;
            } catch (Exception e11) {
                KfsLog kfsLog3 = this.kfsLog;
                kfsLog3.w(TAG, "onEvent fail : " + e11.getMessage());
                return;
            }
        }
        kfsLog2.i(TAG, str);
    }

    public void onReport(Context context) {
        onReport(context, HiAnalyticsType.HIANALYTICS_MAINTENANCE);
    }

    public void onReport(Context context, HiAnalyticsType hiAnalyticsType) {
        KfsLog kfsLog2;
        String str;
        if (this.analyticsInstance == null) {
            kfsLog2 = this.kfsLog;
            str = "onReport null == analyticsInstance";
        } else if (this.biChecker.hasError(context)) {
            kfsLog2 = this.kfsLog;
            str = "onReport isEnabledUserExperience is false";
        } else {
            try {
                this.analyticsInstance.onReport(hiAnalyticsType.getCode());
                this.kfsLog.i(TAG, "onReport success");
                return;
            } catch (Exception e11) {
                KfsLog kfsLog3 = this.kfsLog;
                kfsLog3.w(TAG, "onReport fail : " + e11.getMessage());
                return;
            }
        }
        kfsLog2.i(TAG, str);
    }

    public void setOobeCheckOff() {
        this.biChecker.setOobeCheckOff();
    }

    public void setOobeCheckOn() {
        this.biChecker.setOobeCheckOn();
    }
}
