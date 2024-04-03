package com.apptimize;

import android.view.View;
import android.widget.AdapterView;
import com.apptimize.gn;
import java.lang.reflect.Method;

public class gv {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f42846a = "gv";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public hg f42847b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public gp f42848c;

    public class a extends gk {
        private a() {
        }

        public void a(Method method, Object obj, Object[] objArr) {
            if (!(obj instanceof View)) {
                bo.e(gv.f42846a, String.format("Unexpected %s; expecting View", new Object[]{obj}));
                return;
            }
            View view = (View) obj;
            final hf b11 = gv.this.f42847b.b(view);
            if (b11 == null) {
                String a11 = gv.f42846a;
                bo.a(a11, "No node for " + view);
                return;
            }
            gv.this.f42848c.b((fi) new fi() {
                public void run() {
                    b11.j();
                }
            });
        }
    }

    public class b extends gk {
        private b() {
        }

        public void a(Method method, Object obj, Object[] objArr) {
            if (!(obj instanceof View)) {
                bo.e(gv.f42846a, String.format("Unexpected %s; expecting View", new Object[]{obj}));
                return;
            }
            View view = (View) obj;
            final hf b11 = gv.this.f42847b.b(view);
            if (b11 == null) {
                String a11 = gv.f42846a;
                bo.a(a11, "No node for " + view);
                return;
            }
            gv.this.f42848c.b((fi) new fi() {
                public void run() {
                    b11.k();
                }
            });
        }
    }

    public gv(hg hgVar) {
        this.f42847b = hgVar;
        this.f42848c = hgVar.b();
        b();
    }

    private void b() {
        Class<View> cls = View.class;
        try {
            Method method = cls.getMethod("performClick", new Class[0]);
            a aVar = new a();
            gn.b bVar = gn.b.f42666d;
            gn.c(method, aVar, bVar);
            gn.c(AdapterView.class.getMethod("performItemClick", new Class[]{cls, Integer.TYPE, Long.TYPE}), new b(), bVar);
            gn.c(cls.getMethod("callOnClick", new Class[0]), new a(), bVar);
        } catch (NoSuchMethodException e11) {
            bo.d(f42846a, "No such method", e11);
        }
    }
}
