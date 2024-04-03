package com.huawei.hms.dtm.core;

import android.os.Bundle;
import java.util.concurrent.Executor;

public interface K {
    String getConfigurationID();

    Executor getCoreExecutor();

    String getResourceVersion();

    String getUserProfile(String str);

    boolean isReportToHwAnalytics();

    void onEventExecuted(String str, Bundle bundle);
}
