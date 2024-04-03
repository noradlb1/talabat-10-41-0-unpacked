package com.apptimize;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ap {

    /* renamed from: a  reason: collision with root package name */
    private static final String f41198a = "ap";

    /* renamed from: b  reason: collision with root package name */
    private final ao f41199b;

    /* renamed from: c  reason: collision with root package name */
    private final ak f41200c;

    /* renamed from: d  reason: collision with root package name */
    private final String f41201d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Method> f41202e;

    /* renamed from: f  reason: collision with root package name */
    private ThreadLocal<b> f41203f;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private ao f41204a;

        /* renamed from: b  reason: collision with root package name */
        private String f41205b;

        /* renamed from: c  reason: collision with root package name */
        private Map<String, Method> f41206c = new HashMap();

        public a(ao aoVar) {
            this.f41204a = aoVar;
            this.f41205b = aoVar.getClass().getName();
        }

        public a a(String str) {
            this.f41205b = str;
            return this;
        }

        public a a(String str, Method method) {
            method.setAccessible(true);
            this.f41206c.put(str, method);
            return this;
        }

        public ap a(ak akVar) {
            ap apVar = new ap(this.f41204a, akVar, this.f41205b, this.f41206c);
            akVar.a(this.f41205b, apVar);
            return apVar;
        }
    }

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f41207a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Object[] f41208b;

        public b(String str, Object[] objArr) {
            this.f41207a = str;
            this.f41208b = objArr;
        }
    }

    public ao a() {
        return this.f41199b;
    }

    public boolean b() {
        return this.f41200c.c();
    }

    private ap(ao aoVar, ak akVar, String str, Map<String, Method> map) {
        this.f41203f = new ThreadLocal<>();
        this.f41199b = aoVar;
        this.f41200c = akVar;
        this.f41201d = str;
        this.f41202e = Collections.unmodifiableMap(new HashMap(map));
    }

    public Method a(String str) {
        return this.f41202e.get(str);
    }

    public void b(String str, ft<Long> ftVar, Object... objArr) {
        b bVar;
        if (!this.f41200c.b() || (bVar = this.f41203f.get()) == null || !bVar.f41207a.equals(str) || !Arrays.equals(bVar.f41208b, objArr)) {
            this.f41200c.b(this.f41201d, str, ftVar, objArr);
        }
    }

    public long a(String str, Object... objArr) {
        long longValue;
        long longValue2;
        if ("touch_502f898b-02ff-4db6-88ad-8c181499d383".equals(str)) {
            synchronized (this.f41199b) {
                longValue2 = this.f41199b.a().b().longValue();
            }
            return longValue2;
        }
        Method a11 = a(str);
        this.f41203f.set(new b(str, objArr));
        try {
            synchronized (this.f41199b) {
                a11.invoke(this.f41199b, objArr);
                longValue = this.f41199b.a().b().longValue();
            }
            this.f41203f.set((Object) null);
            return longValue;
        } catch (IllegalAccessException e11) {
            bo.b(f41198a, "Error: ", e11);
            this.f41203f.set((Object) null);
            return 0;
        } catch (InvocationTargetException e12) {
            try {
                bo.b(f41198a, "Error performing state change: ", e12);
                this.f41203f.set((Object) null);
                return 0;
            } catch (Throwable th2) {
                this.f41203f.set((Object) null);
                throw th2;
            }
        }
    }

    public void b(String str, Object... objArr) {
        this.f41200c.a(this.f41201d, str, objArr);
    }

    public void b(ft<Long> ftVar) {
        this.f41200c.a(this.f41201d, ftVar);
    }

    public void a(String str, ft<Long> ftVar, Object... objArr) {
        b bVar;
        if (!this.f41200c.b() || (bVar = this.f41203f.get()) == null || !bVar.f41207a.equals(str) || !Arrays.equals(bVar.f41208b, objArr)) {
            this.f41200c.a(this.f41201d, str, ftVar, objArr);
        }
    }

    public void a(ft<Long> ftVar) {
        this.f41200c.e();
        a("touch_502f898b-02ff-4db6-88ad-8c181499d383", ftVar, new Object[0]);
    }
}
