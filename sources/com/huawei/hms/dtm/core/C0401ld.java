package com.huawei.hms.dtm.core;

import android.content.Context;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.utils.HMSBIInitializer;
import java.util.Map;

/* renamed from: com.huawei.hms.dtm.core.ld  reason: case insensitive filesystem */
public class C0401ld implements C0396kd {
    public void a(Context context) {
        HMSBIInitializer.getInstance(context).initBI();
    }

    public void a(Context context, String str, Map<String, String> map) {
        HiAnalyticsUtil.getInstance().onNewEvent(context, str, map);
    }
}
