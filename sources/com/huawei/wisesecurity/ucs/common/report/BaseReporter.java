package com.huawei.wisesecurity.ucs.common.report;

import android.content.Context;
import com.huawei.wisesecurity.kfs.exception.ParamException;
import com.huawei.wisesecurity.kfs.ha.HaReporter;
import com.huawei.wisesecurity.kfs.log.KfsLog;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;

public abstract class BaseReporter {
    public static final String TAG = "BaseReporter";
    public String haUrl;
    public ReportOption option;

    public static class UcsLog implements KfsLog {
        public final String TAG;

        public UcsLog(String str) {
            this.TAG = str;
        }

        public void d(String str, String str2) {
            LogUcs.d(this.TAG, str2, new Object[0]);
        }

        public void e(String str, String str2) {
            LogUcs.e(this.TAG, str2, new Object[0]);
        }

        public void i(String str, String str2) {
            LogUcs.i(this.TAG, str2, new Object[0]);
        }

        public void w(String str, String str2) {
            LogUcs.w(this.TAG, str2, new Object[0]);
        }
    }

    public BaseReporter(String str, ReportOption reportOption) {
        this.option = reportOption;
        this.haUrl = str;
    }

    public HaReporter getInstance(Context context, String str, String str2) {
        try {
            return new HaReporter(context, str, this.haUrl, new UcsLog(str2));
        } catch (ParamException e11) {
            LogUcs.e(TAG, "HaReporter instance exception: {0}", e11.getMessage());
            return null;
        }
    }

    public abstract String getLogTag();

    public abstract String getReporterTag();

    public void setOobeCheck(HaReporter haReporter) {
        if (ReportOption.REPORT_ALWAYS == this.option && haReporter != null) {
            LogUcs.i(TAG, "set OobeCheckOff.", new Object[0]);
            haReporter.setOobeCheckOff();
        }
    }
}
