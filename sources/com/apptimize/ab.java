package com.apptimize;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.apptimize.gn;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ab {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f41041a = ac.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private List<af> f41042b = new CopyOnWriteArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f41043c;

    public ab(ClassLoader classLoader) {
        this.f41043c = false;
        if (!gn.a(gn.b.f42668f)) {
            bo.e(f41041a, String.format("Unable to monitor fragment lifecycle events", new Object[0]));
            return;
        }
        String[] strArr = {"android.support.v4.app.Fragment", "android.app.Fragment"};
        boolean z11 = false;
        for (int i11 = 0; i11 < 2; i11++) {
            String str = strArr[i11];
            try {
                a(classLoader.loadClass(str));
                z11 = true;
            } catch (ClassNotFoundException e11) {
                if (!z11 && !str.equals("android.support.v4.app.Fragment")) {
                    b();
                    bo.a(f41041a, "Did not find fragment class " + str, e11);
                }
            }
        }
    }

    private void b() {
        if (!this.f41043c) {
            bo.j(f41041a, "Apptimize had difficulty processing this application's Fragment's. Some fragment-related features will not be available. If you are using Fragment's via the Android Support V4 or V13 library, the most likely cause is ProGuard. Consult the Apptimize docs for information on how to adjust your ProGuard configuration");
            this.f41043c = true;
        }
    }

    /* access modifiers changed from: private */
    public void c(Object obj) {
        for (af a11 : this.f41042b) {
            a11.a(obj);
        }
    }

    /* access modifiers changed from: private */
    public void d(Object obj) {
        for (af c11 : this.f41042b) {
            c11.c(obj);
        }
    }

    private void a(Class<?> cls) {
        try {
            Method b11 = fn.b(cls, "onAttach", Activity.class);
            AnonymousClass1 r12 = new gk() {
                public void a(Method method, Object obj, Object[] objArr) {
                    ab.this.a(obj);
                    ab.this.a(obj, objArr[0]);
                }
            };
            gn.b bVar = gn.b.f42668f;
            gn.d(b11, r12, bVar);
            gn.c(fn.b(cls, "onResume", new Class[0]), new gk() {
                public void a(Method method, Object obj, Object[] objArr) {
                    ab.this.c(obj);
                }
            }, bVar);
            gn.c(fn.b(cls, "onPause", new Class[0]), new gk() {
                public void a(Method method, Object obj, Object[] objArr) {
                    ab.this.b(obj);
                }
            }, bVar);
            gn.c(fn.b(cls, "onStop", new Class[0]), new gk() {
                public void a(Method method, Object obj, Object[] objArr) {
                    ab.this.d(obj);
                }
            }, bVar);
        } catch (NoSuchMethodException e11) {
            b();
            bo.b(f41041a, "Could not find method", e11);
        }
    }

    /* access modifiers changed from: private */
    public void b(Object obj) {
        for (af b11 : this.f41042b) {
            b11.b(obj);
        }
    }

    /* access modifiers changed from: private */
    public void a(Object obj) {
        try {
            gn.c(fn.b(obj.getClass(), "onCreateView", LayoutInflater.class, ViewGroup.class, Bundle.class), new gk() {
                public void a(Method method, Object obj, Object[] objArr, Object obj2) {
                    if (obj2 == null || (obj2 instanceof View)) {
                        ab.this.a(obj, (View) obj2);
                        return;
                    }
                    bo.b(ab.f41041a, String.format("Unexpected %s; expecting View", new Object[]{obj2}));
                }
            }, gn.b.f42668f);
        } catch (NoSuchMethodException e11) {
            b();
            bo.b(f41041a, "Could not find method", e11);
        }
    }

    /* access modifiers changed from: private */
    public void a(Object obj, Activity activity) {
        for (af a11 : this.f41042b) {
            a11.a(obj, activity);
        }
    }

    /* access modifiers changed from: private */
    public void a(Object obj, View view) {
        for (af a11 : this.f41042b) {
            a11.a(obj, view);
        }
    }

    public void a(af afVar) {
        this.f41042b.add(afVar);
    }
}
