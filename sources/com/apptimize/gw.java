package com.apptimize;

import android.view.View;
import android.view.ViewGroup;
import com.apptimize.gn;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;

public class gw {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f42855a = "gw";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public hg f42856b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public gp f42857c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f42858d = false;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public HashSet<ViewGroup> f42859e = new HashSet<>();

    public class a extends gk {
        private a() {
        }

        public void a(Method method, Object obj, Object[] objArr) {
            if (!(obj instanceof ViewGroup)) {
                bo.e(gw.f42855a, String.format("Unexpected %s; expecting ViewGroup", new Object[]{obj}));
                return;
            }
            ViewGroup viewGroup = (ViewGroup) obj;
            hf b11 = gw.this.f42856b.b(viewGroup);
            if (b11 != null) {
                AnonymousClass1 r02 = new fi() {
                    public void run() {
                        fe.a(gw.f42855a, (fi) new fi() {
                            public void run() {
                                gw.this.f42857c.a((fi) new fi() {
                                    public void run() {
                                        HashSet b11;
                                        synchronized (gw.this.f42859e) {
                                            b11 = gw.this.f42859e;
                                            HashSet unused = gw.this.f42859e = new HashSet();
                                            boolean unused2 = gw.this.f42858d = false;
                                        }
                                        Iterator it = b11.iterator();
                                        while (it.hasNext()) {
                                            ViewGroup viewGroup = (ViewGroup) it.next();
                                            hf b12 = gw.this.f42856b.b(viewGroup);
                                            bs.a("Check viewNode:", b12, viewGroup);
                                            if (b12 != null) {
                                                b12.f();
                                            }
                                        }
                                    }
                                });
                            }
                        }, "Exception in processHierarchyChangedNodes");
                    }
                };
                synchronized (gw.this.f42859e) {
                    gw.this.f42859e.add(viewGroup);
                    bs.a("Queue viewNode:", (Object) b11);
                    if (!gw.this.f42858d) {
                        boolean unused = gw.this.f42858d = true;
                        gw.this.f42856b.a((fi) r02);
                    }
                }
            }
        }
    }

    public gw(hg hgVar) {
        this.f42856b = hgVar;
        this.f42857c = hgVar.b();
        b();
    }

    private void b() {
        Class<View> cls = View.class;
        Class<ViewGroup> cls2 = ViewGroup.class;
        if (this.f42856b.e()) {
            try {
                a aVar = new a();
                Method declaredMethod = cls2.getDeclaredMethod("dispatchViewAdded", new Class[]{cls});
                hg hgVar = this.f42856b;
                gn.b bVar = gn.b.f42666d;
                hgVar.a(declaredMethod, (gk) aVar, bVar);
                this.f42856b.a(cls2.getDeclaredMethod("dispatchViewRemoved", new Class[]{cls}), (gk) aVar, bVar);
            } catch (NoSuchMethodException e11) {
                bo.d(f42855a, "No such method", e11);
            } catch (Throwable th2) {
                this.f42856b.f();
                throw th2;
            }
            this.f42856b.f();
        }
    }
}
