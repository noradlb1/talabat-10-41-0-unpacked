package com.huawei.hms.stats;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a {

    /* renamed from: f  reason: collision with root package name */
    private static final a f49804f = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Object f49805a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f49806b = false;

    /* renamed from: c  reason: collision with root package name */
    private final List<Runnable> f49807c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final Handler f49808d = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f49809e = new C0073a();

    /* renamed from: com.huawei.hms.stats.a$a  reason: collision with other inner class name */
    public class C0073a implements Runnable {
        public C0073a() {
        }

        public void run() {
            HMSLog.i("AnalyticsCacheManager", "Timeout execCacheBi.");
            if (!HiAnalyticsUtils.getInstance().getInitFlag()) {
                a.this.a();
            } else {
                a.this.b();
            }
        }
    }

    private a() {
    }

    public static a c() {
        return f49804f;
    }

    public void a(Runnable runnable) {
        synchronized (this.f49805a) {
            if (runnable != null) {
                if (!this.f49806b) {
                    if (this.f49807c.size() < 60) {
                        this.f49807c.add(runnable);
                        this.f49808d.removeCallbacks(this.f49809e);
                        this.f49808d.postDelayed(this.f49809e, 10000);
                    }
                }
            }
        }
    }

    public void b() {
        synchronized (this.f49805a) {
            HMSLog.i("AnalyticsCacheManager", "execCacheBi: cache size: " + this.f49807c.size());
            this.f49806b = true;
            try {
                Iterator<Runnable> it = this.f49807c.iterator();
                while (it.hasNext()) {
                    it.next().run();
                    it.remove();
                }
            } catch (Throwable th2) {
                HMSLog.e("AnalyticsCacheManager", "<execCacheBi> failed. " + th2.getMessage());
                a();
            }
            this.f49806b = false;
        }
    }

    public void a() {
        synchronized (this.f49805a) {
            HMSLog.i("AnalyticsCacheManager", "clear AnalyticsCache.");
            this.f49807c.clear();
        }
    }
}
