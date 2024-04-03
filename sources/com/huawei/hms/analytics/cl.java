package com.huawei.hms.analytics;

import android.content.Context;
import com.huawei.hms.analytics.database.APIEvent;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.utils.HMSBIInitializer;
import java.util.List;

public final class cl {
    private static cl lmn;
    private Context klm;

    private cl(Context context) {
        this.klm = context;
        HMSBIInitializer.getInstance(context).initBI();
    }

    private static synchronized void klm(Context context) {
        synchronized (cl.class) {
            if (lmn == null) {
                lmn = new cl(context);
            }
        }
    }

    public static cl lmn(Context context) {
        if (lmn == null) {
            klm(context);
        }
        return lmn;
    }

    public final void lmn(List<APIEvent> list) {
        for (APIEvent next : list) {
            HiAnalyticsUtil.getInstance().onNewEvent(this.klm, next.getCode(), next.toMap());
        }
    }
}
