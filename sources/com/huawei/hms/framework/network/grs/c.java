package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.f.b;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.g.h;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import net.bytebuddy.utility.JavaConstant;

public class c {
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final String f48837i = "c";

    /* renamed from: j  reason: collision with root package name */
    private static final ExecutorService f48838j = ExecutorsUtils.newSingleThreadExecutor("GRS_GrsClient-Init");
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static long f48839k = 0;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public GrsBaseInfo f48840a;

    /* renamed from: b  reason: collision with root package name */
    private Context f48841b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public g f48842c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public com.huawei.hms.framework.network.grs.e.a f48843d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public com.huawei.hms.framework.network.grs.e.c f48844e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public com.huawei.hms.framework.network.grs.e.c f48845f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public a f48846g;

    /* renamed from: h  reason: collision with root package name */
    private FutureTask<Boolean> f48847h = null;

    public class a implements Callable<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f48848a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GrsBaseInfo f48849b;

        public a(Context context, GrsBaseInfo grsBaseInfo) {
            this.f48848a = context;
            this.f48849b = grsBaseInfo;
        }

        public Boolean call() {
            g unused = c.this.f48842c = new g();
            c cVar = c.this;
            Context context = this.f48848a;
            com.huawei.hms.framework.network.grs.e.c unused2 = cVar.f48844e = new com.huawei.hms.framework.network.grs.e.c(context, GrsApp.getInstance().getBrand(JavaConstant.Dynamic.DEFAULT_NAME) + "share_pre_grs_conf_");
            c cVar2 = c.this;
            Context context2 = this.f48848a;
            com.huawei.hms.framework.network.grs.e.c unused3 = cVar2.f48845f = new com.huawei.hms.framework.network.grs.e.c(context2, GrsApp.getInstance().getBrand(JavaConstant.Dynamic.DEFAULT_NAME) + "share_pre_grs_services_");
            c cVar3 = c.this;
            com.huawei.hms.framework.network.grs.e.a unused4 = cVar3.f48843d = new com.huawei.hms.framework.network.grs.e.a(cVar3.f48844e, c.this.f48845f, c.this.f48842c);
            c cVar4 = c.this;
            a unused5 = cVar4.f48846g = new a(cVar4.f48840a, c.this.f48843d, c.this.f48842c, c.this.f48845f);
            if (b.a(this.f48848a.getPackageName()) == null) {
                new b(this.f48848a, true);
            }
            String c11 = new com.huawei.hms.framework.network.grs.g.j.c(this.f48849b, this.f48848a).c();
            String c12 = c.f48837i;
            Logger.v(c12, "scan serviceSet is: " + c11);
            String a11 = c.this.f48845f.a("services", "");
            String a12 = h.a(a11, c11);
            if (!TextUtils.isEmpty(a12)) {
                c.this.f48845f.b("services", a12);
                String c13 = c.f48837i;
                Logger.i(c13, "postList is:" + StringUtils.anonymizeMessage(a12));
                String c14 = c.f48837i;
                Logger.i(c14, "currentServices:" + StringUtils.anonymizeMessage(a11));
                if (!a12.equals(a11)) {
                    c.this.f48842c.a(c.this.f48840a.getGrsParasKey(true, true, this.f48848a));
                    c.this.f48842c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.f48849b, this.f48848a), (b) null, (String) null, c.this.f48845f, c.this.f48840a.getQueryTimeout());
                }
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - c.f48839k;
            if (c.f48839k == 0 || TimeUnit.MILLISECONDS.toHours(elapsedRealtime) > 24) {
                Logger.i(c.f48837i, "Try to clear unUsed sp data.");
                long unused6 = c.f48839k = SystemClock.elapsedRealtime();
                c cVar5 = c.this;
                cVar5.a(cVar5.f48844e.a());
            }
            c.this.f48843d.b(this.f48849b, this.f48848a);
            return Boolean.TRUE;
        }
    }

    public c(Context context, GrsBaseInfo grsBaseInfo) {
        this.f48841b = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        a(grsBaseInfo);
        GrsBaseInfo grsBaseInfo2 = this.f48840a;
        FutureTask<Boolean> futureTask = new FutureTask<>(new a(this.f48841b, grsBaseInfo2));
        this.f48847h = futureTask;
        f48838j.execute(futureTask);
        Logger.i(f48837i, "GrsClient Instance is init, GRS SDK version: %s, GrsBaseInfoParam: app_name=%s, reg_country=%s, ser_country=%s, issue_country=%s ,queryTimeout=%d", com.huawei.hms.framework.network.grs.h.a.a(), grsBaseInfo2.getAppName(), grsBaseInfo.getRegCountry(), grsBaseInfo.getSerCountry(), grsBaseInfo.getIssueCountry(), Integer.valueOf(grsBaseInfo.getQueryTimeout()));
    }

    public c(GrsBaseInfo grsBaseInfo) {
        a(grsBaseInfo);
    }

    private void a(GrsBaseInfo grsBaseInfo) {
        try {
            this.f48840a = grsBaseInfo.clone();
        } catch (CloneNotSupportedException e11) {
            Logger.w(f48837i, "GrsClient catch CloneNotSupportedException", (Throwable) e11);
            this.f48840a = grsBaseInfo.copy();
        }
    }

    /* access modifiers changed from: private */
    public void a(Map<String, ?> map) {
        if (map == null || map.isEmpty()) {
            Logger.v(f48837i, "sp's content is empty.");
            return;
        }
        Set<String> keySet = map.keySet();
        for (String next : keySet) {
            if (next.endsWith(this.f48841b.getPackageName() + "time")) {
                String a11 = this.f48844e.a(next, "");
                long j11 = 0;
                if (!TextUtils.isEmpty(a11) && a11.matches("\\d+")) {
                    try {
                        j11 = Long.parseLong(a11);
                    } catch (NumberFormatException e11) {
                        Logger.w(f48837i, "convert expire time from String to Long catch NumberFormatException.", (Throwable) e11);
                    }
                }
                String substring = next.substring(0, next.length() - 4);
                String str = substring + HttpHeaders.ETAG;
                if (!b(j11) || !keySet.contains(substring) || !keySet.contains(str)) {
                    Logger.i(f48837i, "init interface auto clear some invalid sp's data: " + next);
                    this.f48844e.a(substring);
                    this.f48844e.a(next);
                    this.f48844e.a(str);
                }
            }
        }
    }

    private boolean b(long j11) {
        return System.currentTimeMillis() - j11 <= 604800000;
    }

    private boolean e() {
        String str;
        String str2;
        FutureTask<Boolean> futureTask = this.f48847h;
        if (futureTask == null) {
            return false;
        }
        try {
            return futureTask.get(8, TimeUnit.SECONDS).booleanValue();
        } catch (CancellationException unused) {
            Logger.i(f48837i, "init compute task canceled.");
            return false;
        } catch (ExecutionException e11) {
            e = e11;
            str2 = f48837i;
            str = "init compute task failed.";
            Logger.w(str2, str, e);
            return false;
        } catch (InterruptedException e12) {
            e = e12;
            str2 = f48837i;
            str = "init compute task interrupted.";
            Logger.w(str2, str, e);
            return false;
        } catch (TimeoutException unused2) {
            Logger.w(f48837i, "init compute task timed out");
            return false;
        } catch (Exception e13) {
            e = e13;
            str2 = f48837i;
            str = "init compute task occur unknown Exception";
            Logger.w(str2, str, e);
            return false;
        }
    }

    public String a(String str, String str2, int i11) {
        if (this.f48840a == null || str == null || str2 == null) {
            Logger.w(f48837i, "invalid para!");
            return null;
        } else if (e()) {
            return this.f48846g.a(str, str2, this.f48841b, i11);
        } else {
            return null;
        }
    }

    public Map<String, String> a(String str, int i11) {
        if (this.f48840a != null && str != null) {
            return e() ? this.f48846g.a(str, this.f48841b, i11) : new HashMap();
        }
        Logger.w(f48837i, "invalid para!");
        return new HashMap();
    }

    public void a() {
        if (e()) {
            String grsParasKey = this.f48840a.getGrsParasKey(true, true, this.f48841b);
            this.f48844e.a(grsParasKey);
            com.huawei.hms.framework.network.grs.e.c cVar = this.f48844e;
            cVar.a(grsParasKey + "time");
            com.huawei.hms.framework.network.grs.e.c cVar2 = this.f48844e;
            cVar2.a(grsParasKey + HttpHeaders.ETAG);
            this.f48842c.a(grsParasKey);
        }
    }

    public void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, int i11) {
        if (iQueryUrlsCallBack == null) {
            Logger.w(f48837i, "IQueryUrlsCallBack is must not null for process continue.");
        } else if (this.f48840a == null || str == null) {
            iQueryUrlsCallBack.onCallBackFail(-6);
        } else if (e()) {
            this.f48846g.a(str, iQueryUrlsCallBack, this.f48841b, i11);
        } else {
            Logger.i(f48837i, "grs init task has not completed.");
            iQueryUrlsCallBack.onCallBackFail(-7);
        }
    }

    public void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, int i11) {
        if (iQueryUrlCallBack == null) {
            Logger.w(f48837i, "IQueryUrlCallBack is must not null for process continue.");
        } else if (this.f48840a == null || str == null || str2 == null) {
            iQueryUrlCallBack.onCallBackFail(-6);
        } else if (e()) {
            this.f48846g.a(str, str2, iQueryUrlCallBack, this.f48841b, i11);
        } else {
            Logger.i(f48837i, "grs init task has not completed.");
            iQueryUrlCallBack.onCallBackFail(-7);
        }
    }

    public boolean a(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass() || !(obj instanceof c)) {
            return false;
        }
        return this.f48840a.compare(((c) obj).f48840a);
    }

    public boolean b() {
        GrsBaseInfo grsBaseInfo;
        Context context;
        if (!e() || (grsBaseInfo = this.f48840a) == null || (context = this.f48841b) == null) {
            return false;
        }
        this.f48843d.a(grsBaseInfo, context);
        return true;
    }
}
