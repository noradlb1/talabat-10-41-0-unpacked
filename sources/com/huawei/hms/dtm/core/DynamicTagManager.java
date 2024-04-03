package com.huawei.hms.dtm.core;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.dtm.DTMConfig;
import com.huawei.hms.dtm.core.report.f;
import com.huawei.hms.dtm.core.report.h;
import com.huawei.hms.dtm.core.report.j;
import com.huawei.hms.dtm.core.util.Logger;
import com.huawei.hms.dtm.core.util.b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class DynamicTagManager implements K {

    /* renamed from: a  reason: collision with root package name */
    private static final Executor f48274a = Executors.newSingleThreadExecutor(new C0442u("DTM-TagManager"));

    /* renamed from: b  reason: collision with root package name */
    private static final DynamicTagManager f48275b = new DynamicTagManager();

    /* renamed from: m  reason: collision with root package name */
    public static final /* synthetic */ int f48276m = 0;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Nc f48277c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final U f48278d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final com.huawei.hms.dtm.core.report.a f48279e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final W f48280f;

    /* renamed from: g  reason: collision with root package name */
    private final B f48281g;

    /* renamed from: h  reason: collision with root package name */
    private Object f48282h;

    /* renamed from: i  reason: collision with root package name */
    private Method f48283i;

    /* renamed from: j  reason: collision with root package name */
    private Method f48284j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f48285k = true;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public boolean f48286l = false;

    public class a implements C {
        public a() {
        }

        private void a() {
            h.b();
            DynamicTagManager.this.f48280f.a();
            DynamicTagManager.this.f48279e.a(J.a());
        }

        private boolean b() {
            return !TextUtils.isEmpty(DynamicTagManager.this.f48277c.e()) && DynamicTagManager.this.f48277c.i();
        }

        private void c() {
            if (DynamicTagManager.this.f48277c.d().containsKey("$DTM_AT_TARGET") || !DynamicTagManager.this.f48277c.g().isEmpty() || !DynamicTagManager.this.f48277c.h().isEmpty()) {
                Logger.info("DTM-AutoTrace", "enable visual trace");
                C0352c.a(J.a());
            }
        }

        private void c(boolean z11) {
            h.a(J.a(), DynamicTagManager.this.f48279e);
            DynamicTagManager.this.f48279e.b(J.a());
            c();
            d(z11);
            DynamicTagManager.this.f48278d.a("CONFIGURATION_LOADED", new Bundle(), false);
        }

        private void d(boolean z11) {
            if (z11) {
                Lc.a(J.a());
            }
        }

        public void a(boolean z11) {
            if (!z11) {
                Lc.b();
            }
        }

        public void b(boolean z11) {
            Logger.info("DTM-Decode", "config version:" + DynamicTagManager.this.f48277c.e());
            boolean unused = DynamicTagManager.this.f48286l = b();
            new C0457x(J.a()).a(DynamicTagManager.this.f48286l);
            if (DynamicTagManager.this.f48286l || z11) {
                c(z11);
                return;
            }
            Logger.info("DTM-Decode", "no dtm tags.");
            a();
        }
    }

    private DynamicTagManager() {
        Nc nc2 = new Nc();
        this.f48277c = nc2;
        f fVar = new f();
        this.f48279e = fVar;
        W w11 = new W(new j(fVar));
        this.f48280f = w11;
        this.f48278d = new U(this, nc2);
        this.f48281g = new B(f48274a, nc2, w11, new a());
    }

    private void a(Object obj) {
        if (((obj instanceof Long) || (obj instanceof Integer)) && this.f48281g.a(Long.parseLong(obj.toString()))) {
            this.f48281g.e();
        }
    }

    private void b(Object obj) {
        if (obj instanceof Boolean) {
            Logger.info("HMS-DTM", "aiops enabled:" + obj);
            C0406md.a().a(((Boolean) obj).booleanValue());
        }
    }

    private void c(Object obj) {
        if (obj instanceof Boolean) {
            Logger.info("HMS-DTM", "analyticsEnabled:" + obj);
            this.f48285k = ((Boolean) obj).booleanValue();
        }
    }

    public static DynamicTagManager getInstance() {
        return f48275b;
    }

    public void flush() {
        this.f48279e.a();
    }

    public String getConfigurationID() {
        return this.f48281g.a();
    }

    public Executor getCoreExecutor() {
        return f48274a;
    }

    public Qc<?> getExecNode(String str) {
        return this.f48277c.d().get(str);
    }

    public C0348ba getExecutable(String str) {
        return this.f48280f.b().get(str);
    }

    public String getResourceVersion() {
        return this.f48277c.e();
    }

    public String getUserProfile(String str) {
        Method method;
        Object obj = this.f48282h;
        if (!(obj == null || (method = this.f48284j) == null)) {
            try {
                Object invoke = method.invoke(obj, new Object[]{str});
                return invoke != null ? (String) invoke : "";
            } catch (IllegalAccessException | InvocationTargetException e11) {
                Logger.error("DTM-Execute", "getUserProfile error#" + e11.getMessage());
            }
        }
        return "";
    }

    public List<C0361dd> getVisualPointList() {
        return this.f48277c.g();
    }

    public List<String> getWebPages() {
        return this.f48277c.h();
    }

    public void initialize(Context context, Context context2) {
        initialize(context, context2, (Map<Object, Object>) null);
    }

    public void initialize(Context context, Context context2, Map<Object, Object> map) {
        Logger.info("HMS-DTM", "initialize dtm core" + System.lineSeparator() + "--------------------------------------" + System.lineSeparator() + "------  Version Name " + "6.6.0.302" + "  ------" + System.lineSeparator() + "--------------------------------------");
        J.a(context, context2);
        setDtmConfigBeforeInit(map);
        C0406md.a().a(context2);
        this.f48279e.a();
        this.f48281g.c();
        this.f48281g.f();
        Logger.info("HMS-DTM", "initialize dtm core#success");
    }

    public boolean isReportToHwAnalytics() {
        return this.f48281g.b();
    }

    public boolean isVisualPage(String str) {
        return this.f48277c.a(str);
    }

    public void logAutoEvent(String str, Bundle bundle) {
        if (this.f48285k && this.f48286l) {
            this.f48278d.a(str, bundle, false);
        }
    }

    public void logEvent(String str, Bundle bundle) {
        if (this.f48285k) {
            if (this.f48286l) {
                this.f48278d.a(str, bundle, true);
            } else {
                onEventExecuted(str, bundle);
            }
        }
    }

    public void onEventExecuted(String str, Bundle bundle) {
        Method method;
        Object obj = this.f48282h;
        if (obj != null && (method = this.f48283i) != null) {
            try {
                method.invoke(obj, new Object[]{str, bundle});
            } catch (IllegalAccessException | InvocationTargetException e11) {
                Logger.error("DTM-Execute", "onEventExecuted error#" + e11.getMessage());
            }
        }
    }

    public void preview(String str) {
        if (Ed.d().f()) {
            Ed.d().b();
        }
        if (TextUtils.isEmpty(str)) {
            this.f48281g.c();
            return;
        }
        this.f48281g.a(str);
        this.f48281g.d();
    }

    public void setDtmConfigBeforeInit(Map<Object, Object> map) {
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                Object key = next.getKey();
                Object value = next.getValue();
                if (key instanceof String) {
                    if (key.equals("region")) {
                        b.a((String) value);
                    } else if (key.equals(DTMConfig.AIOPS_ENABLED)) {
                        b(value);
                    } else if (key.equals(DTMConfig.JSON_SCHEDULE_INTERVAL)) {
                        this.f48281g.a(Long.parseLong(value.toString()));
                    } else if (key.equals(DTMConfig.ANALYTICS_ENABLED)) {
                        c(value);
                    }
                }
            }
        }
    }

    public void setDtmFilter(Object obj) {
        Class<String> cls = String.class;
        if (obj != null) {
            try {
                this.f48282h = obj;
                Class<?> cls2 = obj.getClass();
                this.f48283i = cls2.getMethod("onFiltered", new Class[]{cls, Bundle.class});
                this.f48284j = cls2.getMethod("getUserProfile", new Class[]{cls});
                Logger.info("HMS-DTM", "set dtm filter success");
            } catch (NoSuchMethodException e11) {
                Logger.error("HMS-DTM", "setDtmFilter error#" + e11.getMessage());
            }
        }
    }

    public void setParameter(Map<Object, Object> map) {
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                Object key = next.getKey();
                Object value = next.getValue();
                if (key instanceof String) {
                    if (key.equals(DTMConfig.ANALYTICS_ENABLED)) {
                        c(value);
                    } else if (key.equals(DTMConfig.AIOPS_ENABLED)) {
                        b(value);
                    } else if (key.equals(DTMConfig.JSON_SCHEDULE_INTERVAL)) {
                        a(value);
                    }
                }
            }
        }
    }

    public void startVisualTrace(String str) {
        if (Lc.c()) {
            preview((String) null);
        }
        new Yd().a();
        Gd c11 = Gd.c();
        c11.a(str + "&sdkversion=" + 60600302);
    }
}
