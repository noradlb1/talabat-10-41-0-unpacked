package com.huawei.wisesecurity.kfs.ha;

import android.content.Context;
import com.huawei.wisesecurity.kfs.exception.KfsException;
import com.huawei.wisesecurity.kfs.exception.ParamException;
import com.huawei.wisesecurity.kfs.log.KfsLog;

public class HaReporterBuilder {
    public Context context;
    public String hiAnalyticsUrl;
    public KfsLog kfsLog;
    public String serviceTag;

    public HaReporter build() throws ParamException, KfsException {
        return new HaReporter(this.context, this.serviceTag, this.hiAnalyticsUrl, this.kfsLog);
    }

    public HaReporterBuilder withContext(Context context2) {
        this.context = context2;
        return this;
    }

    public HaReporterBuilder withHiAnalyticsUrl(String str) {
        this.hiAnalyticsUrl = str;
        return this;
    }

    public HaReporterBuilder withKfsLog(KfsLog kfsLog2) {
        this.kfsLog = kfsLog2;
        return this;
    }

    public HaReporterBuilder withServiceTag(String str) {
        this.serviceTag = str;
        return this;
    }
}
