package com.apptimize;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewTreeObserver;
import com.apptimize.bg;
import com.apptimize.dt;
import com.apptimize.gn;
import com.apptimize.gy;
import com.apptimize.hh;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class gr {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f42748a = "gr";

    /* renamed from: b  reason: collision with root package name */
    private hl f42749b;

    /* renamed from: c  reason: collision with root package name */
    private final jr<Activity> f42750c = new jr<>(true);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final jr<Object> f42751d = new jr<>(true);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final gp f42752e;

    /* renamed from: f  reason: collision with root package name */
    private gy f42753f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public jr<gy.a> f42754g = new jr<>(false);
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final Map<Object, Boolean> f42755h = new WeakHashMap();

    /* renamed from: i  reason: collision with root package name */
    private final gx f42756i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final hg f42757j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final dt f42758k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final gq f42759l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public ii f42760m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public jp f42761n = jp.a();

    /* renamed from: o  reason: collision with root package name */
    private c f42762o = null;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final boolean f42763p;

    public class a implements hh.a {
        private a() {
        }

        public void a(final Object obj, final int i11) {
            final hc a11 = gr.this.f42751d.a(obj);
            if (a11 != null) {
                gr.this.f42752e.a((fi) new fi() {
                    public void run() {
                        a11.a(da.a("fragmentClass", obj.getClass(), (Class<?>) null, Integer.valueOf(i11)), gr.this.f42761n);
                    }
                });
                gr.this.f42759l.c();
            }
        }
    }

    public class b implements gy.b {
        private b() {
        }

        public void a(gy.a aVar, View view) {
            gr.this.a(aVar, view);
        }

        public void a(gy.a aVar) {
            gr.this.a(aVar);
        }
    }

    public class c implements d {
        private c() {
        }

        public void a(JSONObject jSONObject) {
            gr.this.f42759l.a(jSONObject);
        }

        public void b(JSONObject jSONObject) {
            gr.this.f42759l.a();
        }

        public void c(final JSONObject jSONObject) {
            gr.this.f42752e.a((fj) new fj() {
                public void a(Activity activity) {
                    gr.this.a(activity, jSONObject);
                }
            });
        }

        public void d(JSONObject jSONObject) {
            gr.this.f();
        }

        public void e(final JSONObject jSONObject) {
            gr.this.f42752e.c((fi) new fi() {
                public void run() {
                    gr.this.a(jSONObject);
                }
            });
        }

        public void f(JSONObject jSONObject) {
            gr.this.f42760m.a(jSONObject);
        }

        public void a() {
            gr.this.f42759l.b();
        }

        public void b() {
            gr.this.f();
            gr.this.f42759l.e();
        }
    }

    public interface d {
        void a();

        void a(JSONObject jSONObject);

        void b();

        void b(JSONObject jSONObject);

        void c(JSONObject jSONObject);

        void d(JSONObject jSONObject);

        void e(JSONObject jSONObject);

        void f(JSONObject jSONObject);
    }

    public class e implements af {
        private e() {
        }

        public void a(Object obj, Activity activity) {
            gr.this.a(obj, activity);
        }

        public void b(Object obj) {
            gr.this.b(obj);
        }

        public void c(Object obj) {
        }

        public void a(Object obj) {
            gr.this.a(obj);
        }

        public void a(Object obj, View view) {
            if (view != null) {
                gr grVar = gr.this;
                grVar.b(obj, view, grVar.f42757j.d().a(obj));
            }
        }
    }

    public class f implements w {
        private f() {
        }

        public void a(Activity activity) {
            gr.this.d(activity);
        }

        public void b(Activity activity) {
            gr.this.e(activity);
        }

        public void c(Activity activity) {
        }

        public void d(Activity activity) {
        }

        public void e(Activity activity) {
        }

        public void f(Activity activity) {
        }

        public void g(Activity activity) {
            gr.this.f(activity);
        }
    }

    public class g implements gx {
        public g() {
        }

        public void a(Long l11) {
            if (l11 != null) {
                gr.this.f42758k.b(l11.longValue());
            }
        }

        public void a(String str) {
            gr.this.f42758k.e(str);
        }
    }

    public class h implements dt.d {
        private h() {
        }

        public void a() {
            gr.this.a(false);
        }
    }

    public gr(ClassLoader classLoader, x xVar, ge geVar, au auVar, dt dtVar, gp gpVar, ii iiVar, boolean z11) {
        x xVar2 = xVar;
        ge geVar2 = geVar;
        dt dtVar2 = dtVar;
        gp gpVar2 = gpVar;
        ii iiVar2 = iiVar;
        this.f42752e = gpVar2;
        this.f42760m = iiVar2;
        this.f42758k = dtVar2;
        gy gyVar = new gy(gpVar2, auVar);
        this.f42753f = gyVar;
        gyVar.a((gy.b) new b());
        this.f42749b = new hl();
        g gVar = new g();
        this.f42756i = gVar;
        hg hgVar = new hg(classLoader, this.f42749b, gpVar, gVar, auVar);
        this.f42757j = hgVar;
        this.f42763p = z11;
        this.f42749b.a(hgVar);
        a(this.f42749b, iiVar2);
        gq gqVar = new gq(this, geVar2, auVar.b(), gpVar2);
        this.f42759l = gqVar;
        if (xVar2 != null) {
            xVar2.a((w) new f());
        }
        if (geVar2 != null) {
            geVar2.a(b());
        }
        iiVar2.a(gqVar);
        ed y11 = dtVar.y();
        if (y11 != null) {
            iiVar2.a(bg.a.REPROCESS, y11.k(), (bb) null, (ez) null);
            a(false);
        }
        dtVar2.a((dt.d) new h());
        if (gn.a(gn.b.f42666d)) {
            if (xVar2 != null) {
                xVar2.a((af) new e());
            }
            hgVar.d().a((hh.a) new a());
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        this.f42759l.c();
    }

    /* access modifiers changed from: private */
    public List<hc> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f42750c.a());
        arrayList.addAll(this.f42754g.a());
        arrayList.addAll(this.f42751d.a());
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void e() {
        this.f42752e.a();
        a(true);
    }

    /* access modifiers changed from: private */
    public void f() {
        this.f42752e.c((fi) new fi() {
            public void run() {
                gr.this.e();
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean g(Activity activity) {
        return !this.f42763p || c.a(activity);
    }

    /* access modifiers changed from: private */
    public List<db> c(Activity activity) {
        this.f42752e.c(activity);
        this.f42752e.b();
        List<db> b11 = this.f42750c.b(activity);
        if (b11 != null) {
            return b11;
        }
        AnonymousClass5 r12 = new ArrayList<db>(da.a("activityClass", activity.getClass(), (Class<?>) null)) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ db f42779a;

            {
                this.f42779a = r2;
                add(r2);
            }
        };
        this.f42750c.a(activity, (List<db>) r12);
        return r12;
    }

    /* access modifiers changed from: private */
    public void f(Activity activity) {
        this.f42752e.b(activity);
    }

    /* access modifiers changed from: private */
    public hc b(Activity activity) {
        this.f42752e.c(activity);
        this.f42752e.b();
        hc a11 = this.f42750c.a(activity);
        if (a11 != null) {
            return a11;
        }
        hc a12 = hc.a(activity, this.f42761n, this.f42757j);
        this.f42750c.a(activity, a12);
        return a12;
    }

    /* access modifiers changed from: private */
    public void e(Activity activity) {
        List<db> b11 = this.f42750c.b(activity);
        if (b11 != null) {
            this.f42758k.b(b11);
        }
    }

    /* access modifiers changed from: private */
    public void d(Activity activity) {
        this.f42752e.a(activity);
        this.f42752e.a((fj) new fj() {
            public void a(Activity activity) {
                if (gr.this.g(activity)) {
                    gn.g();
                    gr.this.f42758k.a(gr.this.b(activity).h());
                    gr grVar = gr.this;
                    grVar.a(grVar.b(activity), js.a(activity));
                    return;
                }
                gn.f();
                gr.this.f42758k.a((List<db>) gr.this.c(activity));
                gr.this.a((hc) null, js.a(activity));
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(final Object obj, final View view, final Integer num) {
        this.f42752e.c((fi) new fi() {
            public void run() {
                gr.this.f42751d.c(obj);
                Boolean bool = (Boolean) gr.this.f42755h.get(obj);
                if (!gr.this.f42763p || (bool != null && bool.booleanValue())) {
                    gr grVar = gr.this;
                    grVar.a(grVar.a(obj, view, num), view);
                    return;
                }
                List unused = gr.this.a(obj, num);
                gr.this.a((hc) null, view);
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(Object obj) {
        List<db> b11 = this.f42751d.b(obj);
        if (b11 != null) {
            this.f42758k.b(b11);
        }
    }

    public d b() {
        if (this.f42762o == null) {
            this.f42762o = new c();
        }
        return this.f42762o;
    }

    private static void a(hl hlVar, ii iiVar) {
        Resources e11 = iiVar.e();
        ib.a(hlVar, e11);
        ic.a(hlVar, e11, iiVar);
        ia.a(hlVar);
        hz.a(hlVar);
        hv.a(hlVar);
        hr.a(hlVar);
        hs.a(hlVar);
        ht.a(hlVar);
        hx.a(hlVar);
        hy.a(hlVar);
        hw.a(hlVar);
        hu.a(hlVar, iiVar);
    }

    /* access modifiers changed from: private */
    public void a(final boolean z11) {
        this.f42752e.a((fi) new fi() {
            public void run() {
                List<dc> q11 = gr.this.f42758k.q();
                if (!gr.this.f42760m.a(q11)) {
                    bo.h(gr.f42748a, "Images unexpectedly missing from cache; cannot apply styles");
                    return;
                }
                gr.this.f42761n.a(q11);
                if (z11) {
                    gr.this.f42752e.c((fi) new fi() {
                        public void run() {
                            for (hc a11 : gr.this.d()) {
                                a11.a(gr.this.f42761n);
                            }
                        }
                    });
                }
            }
        });
    }

    public JSONArray a(Activity activity) throws JSONException {
        this.f42752e.c(activity);
        this.f42752e.b();
        JSONArray jSONArray = new JSONArray();
        if (g(activity)) {
            jSONArray.put((Object) b(activity).e());
            for (hc e11 : this.f42754g.a()) {
                jSONArray.put((Object) e11.e());
            }
        }
        return jSONArray;
    }

    /* access modifiers changed from: private */
    public hc a(Activity activity, gy.a aVar, View view) {
        this.f42752e.b();
        hc a11 = this.f42754g.a(aVar);
        if (a11 != null) {
            return a11;
        }
        hc a12 = hc.a(aVar, activity, view, this.f42761n, this.f42757j);
        this.f42754g.a(aVar, a12);
        return a12;
    }

    /* access modifiers changed from: private */
    public hc a(Object obj, View view, Integer num) {
        this.f42752e.b();
        hc a11 = this.f42751d.a(obj);
        if (a11 != null) {
            return a11;
        }
        hc a12 = hc.a(obj, view, num, this.f42761n, this.f42757j);
        this.f42751d.a(obj, a12);
        return a12;
    }

    /* access modifiers changed from: private */
    public List<db> a(Activity activity, gy.a aVar) {
        this.f42752e.b();
        List<db> b11 = this.f42754g.b(aVar);
        if (b11 != null) {
            return b11;
        }
        AnonymousClass6 r02 = new ArrayList<db>(da.a("popupClass", aVar.a().getClass(), activity.getClass())) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ db f42781a;

            {
                this.f42781a = r2;
                add(r2);
            }
        };
        this.f42754g.a(aVar, (List<db>) r02);
        return r02;
    }

    /* access modifiers changed from: private */
    public List<db> a(Object obj, Integer num) {
        this.f42752e.b();
        List<db> b11 = this.f42751d.b(obj);
        if (b11 != null) {
            return b11;
        }
        AnonymousClass7 r02 = new ArrayList<db>(da.a("fragmentClass", obj.getClass(), (Class<?>) null, num)) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ db f42783a;

            {
                this.f42783a = r2;
                add(r2);
            }
        };
        this.f42751d.a(obj, (List<db>) r02);
        return r02;
    }

    public List<Object> a() {
        ArrayList arrayList = new ArrayList();
        for (gy.a a11 : this.f42754g.b()) {
            arrayList.add(a11.a());
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void a(Activity activity, JSONObject jSONObject) {
        this.f42752e.c(activity);
        this.f42752e.b();
        this.f42759l.a(jSONObject.optString("updateSequenceData"));
        try {
            final List<dc> a11 = dc.a(jSONObject.getJSONArray("styles"));
            final Integer c11 = this.f42761n.c();
            this.f42760m.a(a11, (ez) new ez() {
                public void a() {
                    gr.this.f42752e.a((fj) new fj() {
                        public void a(Activity activity) {
                            if (ey.b(gr.this.f42761n.c(), c11)) {
                                gr.this.f42761n.a((List<dc>) a11);
                                for (hc a11 : gr.this.d()) {
                                    a11.a(gr.this.f42761n);
                                }
                            }
                        }
                    });
                }

                public void b() {
                }
            });
        } catch (JSONException e11) {
            bo.f(f42748a, "Unexpected error when updating styles: ", e11);
        }
        this.f42759l.c();
    }

    /* access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        this.f42759l.b(jSONObject);
    }

    /* access modifiers changed from: private */
    public void a(hc hcVar, View view) {
        this.f42752e.b();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    gr.this.f42759l.c();
                }
            });
            viewTreeObserver.addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                public void onScrollChanged() {
                    gr.this.f42759l.c();
                }
            });
        }
        if (hcVar != null) {
            hcVar.a(this.f42761n);
        }
        this.f42759l.c();
    }

    /* access modifiers changed from: private */
    public void a(Object obj, Activity activity) {
        this.f42755h.put(obj, Boolean.valueOf(g(activity)));
    }

    /* access modifiers changed from: private */
    public void a(Object obj) {
        List<db> b11 = this.f42751d.b(obj);
        if (b11 != null) {
            this.f42758k.a(b11);
        }
    }

    /* access modifiers changed from: private */
    public void a(final gy.a aVar, final View view) {
        this.f42752e.a((fj) new fj() {
            public void a(Activity activity) {
                if (gr.this.g(activity)) {
                    gr.this.f42758k.a(gr.this.a(activity, aVar, view).h());
                    gr grVar = gr.this;
                    grVar.a(grVar.a(activity, aVar, view), view);
                    return;
                }
                gr.this.f42758k.a((List<db>) gr.this.a(activity, aVar));
                gr.this.a((hc) null, view);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(final gy.a aVar) {
        List<db> b11 = this.f42754g.b(aVar);
        if (b11 != null) {
            this.f42758k.b(b11);
        }
        this.f42752e.a((fj) new fj() {
            public void a(Activity activity) {
                gr.this.f42754g.c(aVar);
                gr.this.g();
            }
        });
    }
}
