package com.huawei.hms.analytics.framework.config;

import com.huawei.hms.analytics.core.storage.Event;
import java.util.List;

public interface ICallback {
    public static final int DEF_FLAG = 0;
    public static final int NO_REQUEST_FLAG = -1;
    public static final int REGION_CHANGE_REQUEST_FLAG = -2;

    boolean isAAIDChanged(String str, boolean z11);

    boolean isNeedStorage();

    boolean isStopEvent();

    void onResult(int i11, long j11, int i12, List<Event> list);

    void setStopEventReport(boolean z11);
}
