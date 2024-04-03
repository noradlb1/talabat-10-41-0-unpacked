package com.huawei.hms.analytics;

import android.os.Bundle;
import com.huawei.hms.analytics.core.log.HiLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public final class cm implements Runnable {
    private Map<String, Method> hij;
    private Map<String, Object> ijk;
    private Bundle ikl;
    private Bundle klm;
    private String lmn;

    public cm(String str, Bundle bundle, Bundle bundle2, Map<String, Object> map, Map<String, Method> map2) {
        this.lmn = str;
        this.klm = bundle;
        this.ikl = bundle2;
        this.ijk = map;
        this.hij = map2;
    }

    public final void run() {
        String str;
        HiLog.d("EventAdapterMission", "EventAdapterTask is running");
        Map<String, Object> map = this.ijk;
        if (map != null && this.hij != null) {
            for (Map.Entry next : map.entrySet()) {
                Method method = this.hij.get((String) next.getKey());
                if (method == null) {
                    HiLog.d("EventAdapterMission", "mOnEvent is null");
                } else {
                    try {
                        method.invoke(next.getValue(), new Object[]{this.lmn, this.klm, this.ikl});
                    } catch (IllegalAccessException unused) {
                        str = "IllegalAccessException";
                    } catch (InvocationTargetException unused2) {
                        str = "InvocationTargetException";
                    }
                }
            }
            return;
        }
        return;
        HiLog.w("EventAdapterMission", str);
    }
}
