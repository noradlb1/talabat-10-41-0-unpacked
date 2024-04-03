package com.huawei.hms.utils;

import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import j$.util.concurrent.ConcurrentHashMap;
import java.sql.Timestamp;
import java.util.Map;

public class ResolutionFlagUtil {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ResolutionFlagUtil f49971a;

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, Long> f49972b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f49973c = new Object();

    private ResolutionFlagUtil() {
    }

    private void a() {
        long time = new Timestamp(System.currentTimeMillis()).getTime() - 10800000;
        for (String next : f49972b.keySet()) {
            Map<String, Long> map = f49972b;
            Long l11 = map.get(next);
            if (l11 == null || l11.longValue() == 0) {
                map.remove(next);
                HMSLog.i("ResolutionFlagUtil", "remove resolution flag because the data in this pair was abnormal: " + next);
            } else if (time >= l11.longValue()) {
                map.remove(next);
                HMSLog.i("ResolutionFlagUtil", "remove resolution flag because aging time: " + next);
            }
        }
    }

    public static ResolutionFlagUtil getInstance() {
        if (f49971a != null) {
            return f49971a;
        }
        synchronized (f49973c) {
            if (f49971a == null) {
                f49971a = new ResolutionFlagUtil();
            }
        }
        return f49971a;
    }

    public long getResolutionFlag(String str) {
        if (str == null) {
            HMSLog.e("ResolutionFlagUtil", "transactionId is null");
            return 0;
        }
        Map<String, Long> map = f49972b;
        if (map.get(str) != null) {
            return map.get(str).longValue();
        }
        return 0;
    }

    public void removeResolutionFlag(String str) {
        if (str == null) {
            HMSLog.e("ResolutionFlagUtil", "transactionId is null");
            return;
        }
        f49972b.remove(str);
        HMSLog.i("ResolutionFlagUtil", "remove resolution flag");
    }

    public void saveResolutionFlag(String str, long j11) {
        if (TextUtils.isEmpty(str) || j11 == 0) {
            HMSLog.e("ResolutionFlagUtil", "saveResolutionFlag error, transactionId: " + str + ", timestamp: " + j11);
            return;
        }
        a(str, j11);
    }

    private void a(String str, long j11) {
        Map<String, Long> map = f49972b;
        synchronized (map) {
            a();
            map.put(str, Long.valueOf(j11));
            HMSLog.i("ResolutionFlagUtil", "save resolution flag");
        }
    }
}
