package com.huawei.hms.dtm.core;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.dtm.core.util.Logger;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class B {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f48259a = Pattern.compile("version=(\\d)+");

    /* renamed from: b  reason: collision with root package name */
    private long f48260b = 6;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f48261c = "";
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final F f48262d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f48263e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final C0462y f48264f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final C f48265g;

    /* renamed from: h  reason: collision with root package name */
    private String f48266h;

    /* renamed from: i  reason: collision with root package name */
    private ScheduledExecutorService f48267i;

    public B(Executor executor, Nc nc2, W w11, C c11) {
        this.f48263e = executor;
        this.f48262d = new F(nc2, w11);
        this.f48264f = new C0462y();
        this.f48265g = c11;
    }

    /* access modifiers changed from: private */
    public String a(Context context, boolean z11) {
        String b11 = C0421pd.b();
        if (TextUtils.isEmpty(b11)) {
            Logger.info("DTM-Decode", "failed to get url from GRS");
            b11 = this.f48264f.c(context);
            if (TextUtils.isEmpty(b11)) {
                Logger.info("DTM-Decode", "failed to get url from file");
                return "";
            }
        }
        if (z11) {
            return b11 + "/preview/android?id=" + this.f48266h + "&sdkversion=" + 60600302;
        }
        return b11 + "/download/android?id=" + this.f48261c + "&digest=" + this.f48264f.b(context) + "&sdkversion=" + 60600302;
    }

    /* access modifiers changed from: private */
    public String a(Context context, boolean z11, boolean z12, String str) {
        return z11 ? this.f48264f.a(str) : this.f48264f.a(context, str, z12);
    }

    /* access modifiers changed from: private */
    public void a(boolean z11, boolean z12) {
        this.f48263e.execute(new A(this, z11, z12));
    }

    /* access modifiers changed from: private */
    public boolean a(boolean z11, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!z11) {
            return z11;
        }
        String g11 = g();
        String b11 = b(str);
        if (TextUtils.isEmpty(g11) || g11.equals(b11)) {
            return z11;
        }
        Logger.error("DTM-Decode", "disable preview mode");
        return false;
    }

    private String b(String str) {
        try {
            return new JSONObject(str).getJSONObject("resources").getString("version");
        } catch (JSONException unused) {
            Logger.error("DTM-Decode", "get json version failed");
            return "";
        }
    }

    private void b(long j11) {
        C0467z zVar = new C0467z(this);
        Logger.debug("DTM-Execute", "json load interval is:" + j11);
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new C0442u("DTM-JsonManager"));
        this.f48267i = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.scheduleWithFixedDelay(zVar, j11, j11, TimeUnit.HOURS);
    }

    private String g() {
        if (TextUtils.isEmpty(this.f48266h)) {
            return "";
        }
        Matcher matcher = f48259a.matcher(this.f48266h);
        String group = matcher.find() ? matcher.group(0) : "";
        if (TextUtils.isEmpty(group)) {
            return "";
        }
        String[] split = group.split("=");
        return split.length == 2 ? split[1] : "";
    }

    public String a() {
        return this.f48261c;
    }

    public void a(String str) {
        this.f48266h = str;
    }

    public boolean a(long j11) {
        if (j11 < 6) {
            Logger.error("HMS-DTM", "json schedule interval cannot be less than 6 hours");
            return false;
        }
        this.f48260b = j11;
        new C0457x(J.a()).b(this.f48260b);
        Logger.debug("DTM-Execute", "set json schedule interval:" + this.f48260b);
        return true;
    }

    public boolean b() {
        return this.f48262d.a();
    }

    public void c() {
        a(false, false);
    }

    public void d() {
        a(true, false);
    }

    public void e() {
        ScheduledExecutorService scheduledExecutorService = this.f48267i;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            this.f48267i.shutdown();
        }
        b(this.f48260b);
    }

    public void f() {
        b(this.f48260b);
    }
}
