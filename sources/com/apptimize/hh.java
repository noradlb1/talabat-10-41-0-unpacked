package com.apptimize;

import android.view.View;
import android.view.ViewGroup;
import com.apptimize.bq;
import com.apptimize.gn;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class hh {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f42928a = "hh";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public hg f42929b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public gp f42930c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Map<Object, Integer> f42931d = new WeakHashMap();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final List<a> f42932e = new CopyOnWriteArrayList();

    /* renamed from: f  reason: collision with root package name */
    private boolean f42933f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f42934g = false;

    public interface a {
        void a(Object obj, int i11);
    }

    public hh(hg hgVar, ClassLoader classLoader, au auVar) {
        this.f42929b = hgVar;
        this.f42930c = hgVar.b();
        a(auVar);
        a(classLoader);
    }

    public synchronized void b(View view) {
        if (a(view)) {
            gn.a(view.getClass(), "populate", (gk) new gk() {
                public void a(Method method, Object obj, Object[] objArr) {
                    if (!(obj instanceof View)) {
                        bo.e(hh.f42928a, String.format("Unexpected %s; expecting View", new Object[]{obj}));
                        return;
                    }
                    final hf b11 = hh.this.f42929b.b((View) obj);
                    if (b11 != null) {
                        hh.this.f42930c.a((fi) new fi() {
                            public void run() {
                                b11.f();
                            }
                        });
                    }
                }
            }, gn.b.f42666d);
        }
    }

    private static void a(au auVar) {
        try {
            Class.forName("android.support.v4.view.ViewPager");
            bo.a(f42928a, "Found ViewPager class");
        } catch (ClassNotFoundException unused) {
            auVar.a().a(bq.b.CouldNotFindViewPager);
        }
    }

    private void b() {
        if (!this.f42933f) {
            bo.j(f42928a, "Apptimize had difficulty processing this application's Fragments within ViewPagers. Some viewpager-related features will not be available. If you are using FragmentPagerAdapter via the Android Support V4 or V13 library, the most likely cause is ProGuard. Consult the Apptimize docs for information on how to adjust your ProGuard configuration");
            this.f42933f = true;
        }
    }

    public static boolean a(View view) {
        return fn.a((Object) view, "android.support.v4.view.ViewPager");
    }

    private void a(ClassLoader classLoader) {
        if (!this.f42934g) {
            this.f42934g = true;
            String[] strArr = {"android.support.v4.app.FragmentPagerAdapter", "android.support.v4.app.FragmentStatePagerAdapter", "android.support.v13.app.FragmentPagerAdapter", "android.support.v13.app.FragmentStatePagerAdapter"};
            for (int i11 = 0; i11 < 4; i11++) {
                try {
                    a(classLoader.loadClass(strArr[i11]));
                } catch (ClassNotFoundException unused) {
                }
            }
        }
    }

    private void a(Class<?> cls) {
        try {
            gn.d(fn.b(cls, "instantiateItem", ViewGroup.class, Integer.TYPE), new gk() {
                public void a(Method method, Object obj, Object[] objArr, Object obj2) {
                    Object obj3;
                    if (obj2 != null && objArr.length >= 2 && (obj3 = objArr[1]) != null && (obj3 instanceof Integer)) {
                        hh.this.f42931d.put(obj2, objArr[1]);
                        for (a a11 : hh.this.f42932e) {
                            a11.a(obj2, objArr[1].intValue());
                        }
                    }
                }
            }, gn.b.f42666d);
        } catch (NoSuchMethodException e11) {
            b();
            bo.b(f42928a, "Could not find method", e11);
        }
    }

    public void a(a aVar) {
        this.f42932e.add(aVar);
    }

    public Integer a(Object obj) {
        return this.f42931d.get(obj);
    }
}
