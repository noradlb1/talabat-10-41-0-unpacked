package com.apptimize;

import com.apptimize.ap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ag {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f41091a = "ag";

    /* renamed from: b  reason: collision with root package name */
    private b f41092b;

    /* renamed from: c  reason: collision with root package name */
    private ap f41093c;

    public void b(String str, Object... objArr) {
        if (!this.f41093c.b()) {
            String str2 = f41091a;
            bo.k(str2, "sendToMain:" + str);
            this.f41093c.a("shepherd", this.f41092b.a(), str, objArr);
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Object f41094a;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, Method> f41095b = new HashMap();

        public a(Object obj) {
            this.f41094a = obj;
        }

        public a a(String str, Method method) {
            method.setAccessible(true);
            this.f41095b.put(str, method);
            return this;
        }

        public ag a(ak akVar) {
            try {
                b bVar = new b(this.f41094a, this.f41095b);
                ap.a aVar = new ap.a(bVar);
                return new ag(bVar, aVar.a(this.f41094a.getClass().getName() + "_shepherder-eb1a8f1b-da18-41ce-b209-43b3936bc8ba").a("shepherd", b.class.getDeclaredMethod("a", new Class[]{String.class, Object[].class})).a(akVar));
            } catch (NoSuchMethodException e11) {
                bo.e(ag.f41091a, "Error binding", e11);
                return null;
            }
        }
    }

    private ag(b bVar, ap apVar) {
        this.f41092b = bVar;
        this.f41093c = apVar;
    }

    public void a(String str, Object... objArr) {
        String str2 = f41091a;
        bo.k(str2, "performOnMainProcess:" + str);
        this.f41093c.a("shepherd", this.f41092b.a(), str, objArr);
    }

    public static class b implements ao {

        /* renamed from: a  reason: collision with root package name */
        private Object f41096a;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, Method> f41097b;

        public b(Object obj, Map<String, Method> map) {
            this.f41096a = obj;
            this.f41097b = Collections.unmodifiableMap(new HashMap(map));
        }

        private void a(String str, Object[] objArr) {
            try {
                this.f41097b.get(str).invoke(this.f41096a, objArr);
            } catch (IllegalAccessException e11) {
                bo.b(ag.f41091a, "Error: ", e11);
            } catch (InvocationTargetException e12) {
                bo.b(ag.f41091a, "Error performing state change: ", e12);
            }
        }

        public void b() {
        }

        public void c() {
        }

        public void d() {
        }

        public ft<Long> a() {
            return new ft<Long>() {
                /* renamed from: a */
                public Long b() {
                    return 0L;
                }
            };
        }
    }
}
