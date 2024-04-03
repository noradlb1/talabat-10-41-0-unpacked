package com.huawei.hms.dtm.core.util;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.dtm.core.J;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final a f48615a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f48616b = false;

    /* renamed from: c  reason: collision with root package name */
    private static String f48617c = "";

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f48618a;

        /* renamed from: b  reason: collision with root package name */
        private String f48619b;

        /* renamed from: c  reason: collision with root package name */
        private String f48620c;

        private a() {
        }

        public a a(String str) {
            this.f48618a = str;
            return this;
        }

        public String a() {
            return this.f48618a;
        }

        public a b(String str) {
            this.f48619b = str;
            return this;
        }

        public String b() {
            return this.f48619b;
        }

        public a c(String str) {
            if (!TextUtils.isEmpty(b.b())) {
                str = b.b();
            }
            this.f48620c = str;
            return this;
        }

        public String c() {
            return this.f48620c;
        }

        public boolean d() {
            return TextUtils.isEmpty(this.f48618a) || TextUtils.isEmpty(this.f48619b) || TextUtils.isEmpty(this.f48620c);
        }
    }

    public static String a() {
        if (!f48616b) {
            i();
        }
        return f48615a.a();
    }

    public static void a(String str) {
        f48617c = str;
        Logger.debug("DTM-Execute", "set default region:" + str);
    }

    public static String b() {
        return f48617c;
    }

    public static String c() {
        if (!f48616b) {
            i();
        }
        return f48615a.b();
    }

    public static String d() {
        if (!f48616b) {
            i();
        }
        return f48615a.c();
    }

    private static void e() {
        AGConnectServicesConfig fromContext;
        Logger.debug("DTM-Decode", "get agc info from config");
        if (J.a() != null && (fromContext = AGConnectServicesConfig.fromContext(J.a())) != null) {
            f48615a.a(fromContext.getString("client/app_id")).b(fromContext.getString("client/product_id")).c(fromContext.getString("region"));
        }
    }

    private static void f() {
        Logger.debug("DTM-Decode", "get agc info from options");
        AGConnectInstance instance = AGConnectInstance.getInstance();
        if (instance == null) {
            Logger.debug("DTM-Decode", "agConnectInstance is null");
            return;
        }
        AGConnectOptions options = instance.getOptions();
        if (options == null) {
            Logger.debug("DTM-Decode", "agConnectOptions is null");
        } else {
            f48615a.a(options.getString("client/app_id")).b(options.getString("client/product_id")).c(options.getString("region"));
        }
    }

    private static void g() {
        Context a11 = J.a();
        if (a11 != null) {
            try {
                Logger.debug("DTM-Decode", "get agc info from sdk by config");
                Class<?> loadClass = a11.getClassLoader().loadClass("com.huawei.agconnect.config.AGConnectServicesConfig");
                Object[] objArr = {a11};
                String str = null;
                Object invoke = loadClass.getMethod("fromContext", new Class[]{Context.class}).invoke((Object) null, objArr);
                Method method = loadClass.getMethod("getString", new Class[]{String.class});
                Object[] objArr2 = new Object[1];
                objArr2[0] = "client/app_id";
                Object invoke2 = method.invoke(invoke, objArr2);
                Object[] objArr3 = new Object[1];
                objArr3[0] = "client/product_id";
                Object invoke3 = method.invoke(invoke, objArr3);
                Object[] objArr4 = new Object[1];
                objArr4[0] = "region";
                Object invoke4 = method.invoke(invoke, objArr4);
                a b11 = f48615a.a(invoke2 != null ? (String) invoke2 : null).b(invoke3 != null ? (String) invoke3 : null);
                if (invoke4 != null) {
                    str = (String) invoke4;
                }
                b11.c(str);
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e11) {
                Logger.error("DTM-Decode", "get agc info from sdk by config failed." + e11.getMessage());
            }
        }
    }

    private static void h() {
        Context a11 = J.a();
        if (a11 != null) {
            try {
                Logger.debug("DTM-Decode", "get agc info from sdk by options");
                Class<?> loadClass = a11.getClassLoader().loadClass("com.huawei.agconnect.AGConnectInstance");
                String str = null;
                Object invoke = loadClass.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
                if (invoke != null) {
                    Object invoke2 = loadClass.getMethod("getOptions", new Class[0]).invoke(invoke, new Object[0]);
                    if (invoke2 != null) {
                        Method method = invoke2.getClass().getMethod("getString", new Class[]{String.class});
                        Object[] objArr = new Object[1];
                        objArr[0] = "client/app_id";
                        Object invoke3 = method.invoke(invoke2, objArr);
                        Object[] objArr2 = new Object[1];
                        objArr2[0] = "client/product_id";
                        Object invoke4 = method.invoke(invoke2, objArr2);
                        Object[] objArr3 = new Object[1];
                        objArr3[0] = "region";
                        Object invoke5 = method.invoke(invoke2, objArr3);
                        a b11 = f48615a.a(invoke3 != null ? (String) invoke3 : null).b(invoke4 != null ? (String) invoke4 : null);
                        if (invoke5 != null) {
                            str = (String) invoke5;
                        }
                        b11.c(str);
                    }
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e11) {
                Logger.error("DTM-Decode", "get agc info from sdk by options failed." + e11.getMessage());
            }
        }
    }

    private static synchronized void i() {
        synchronized (b.class) {
            if (!f48616b) {
                Logger.info("DTM-Decode", "begin to init agc info");
                e();
                a aVar = f48615a;
                if (aVar.d()) {
                    g();
                }
                if (aVar.d()) {
                    f();
                }
                if (aVar.d()) {
                    h();
                }
                if (aVar.d()) {
                    Logger.error("DTM-Decode", "failed to init agc info");
                }
                f48616b = true;
            }
        }
    }
}
