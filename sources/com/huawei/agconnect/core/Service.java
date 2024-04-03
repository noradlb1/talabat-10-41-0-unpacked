package com.huawei.agconnect.core;

import com.huawei.agconnect.annotation.AutoCreated;
import com.huawei.agconnect.annotation.SharedInstance;
import com.huawei.agconnect.annotation.Singleton;
import java.lang.reflect.Modifier;

public class Service {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f47517a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<?> f47518b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f47519c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f47520d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f47521e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f47522f;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        Class<?> f47523a;

        /* renamed from: b  reason: collision with root package name */
        Class<?> f47524b;

        /* renamed from: c  reason: collision with root package name */
        Object f47525c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f47526d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f47527e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f47528f;

        public Service build() {
            Class<?> cls = this.f47523a;
            if (cls != null) {
                Class<?> cls2 = this.f47524b;
                if (cls2 == null) {
                    Object obj = this.f47525c;
                    if (obj != null) {
                        Service service2 = new Service((Class) cls, obj);
                        boolean unused = service2.f47520d = this.f47526d;
                        return service2;
                    }
                    throw new IllegalArgumentException("the clazz or object parameter must set one");
                } else if (cls2.isInterface() || !Modifier.isPublic(this.f47524b.getModifiers())) {
                    throw new IllegalArgumentException("the clazz parameter cant be interface type or not public");
                } else {
                    Service service3 = new Service((Class) this.f47523a, (Class) this.f47524b);
                    boolean unused2 = service3.f47520d = this.f47526d;
                    boolean unused3 = service3.f47521e = this.f47527e;
                    boolean unused4 = service3.f47522f = this.f47528f;
                    return service3;
                }
            } else {
                throw new IllegalArgumentException("the interface parameter cannot be NULL");
            }
        }

        public Builder isAutoCreated(boolean z11) {
            this.f47528f = z11;
            return this;
        }

        public Builder isSharedInstance(boolean z11) {
            this.f47527e = z11;
            return this;
        }

        public Builder isSingleton(boolean z11) {
            this.f47526d = z11;
            return this;
        }

        public Builder setClass(Class<?> cls) {
            this.f47524b = cls;
            return this;
        }

        public Builder setInterface(Class<?> cls) {
            this.f47523a = cls;
            return this;
        }

        public Builder setObject(Object obj) {
            this.f47525c = obj;
            return this;
        }
    }

    private Service(Class<?> cls, Class<?> cls2) {
        this.f47517a = cls;
        this.f47518b = cls2;
        this.f47519c = null;
    }

    private Service(Class<?> cls, Object obj) {
        this.f47517a = cls;
        this.f47518b = null;
        this.f47519c = obj;
    }

    public static Builder builder(Class<?> cls) {
        return new Builder().setInterface(cls).setClass(cls).isSingleton(cls.isAnnotationPresent(Singleton.class)).isSharedInstance(cls.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls.isAnnotationPresent(AutoCreated.class));
    }

    public static Builder builder(Class<?> cls, Class<?> cls2) {
        return new Builder().setInterface(cls).setClass(cls2).isSingleton(cls2.isAnnotationPresent(Singleton.class)).isSharedInstance(cls2.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls2.isAnnotationPresent(AutoCreated.class));
    }

    public static Builder builder(Class<?> cls, Object obj) {
        return new Builder().setInterface(cls).setObject(obj).isSingleton(true).isSharedInstance(cls.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls.isAnnotationPresent(AutoCreated.class));
    }

    public Object getInstance() {
        return this.f47519c;
    }

    public Class<?> getInterface() {
        return this.f47517a;
    }

    public Class<?> getType() {
        return this.f47518b;
    }

    public boolean isAutoCreated() {
        return this.f47522f;
    }

    public boolean isSharedInstance() {
        return this.f47521e;
    }

    public boolean isSingleton() {
        return this.f47520d;
    }
}
