package com.apptimize;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.hms.flutter.map.constants.Param;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class gu implements hf {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f42818b = "gu";

    /* renamed from: a  reason: collision with root package name */
    public int f42819a = 0;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<View> f42820c;

    /* renamed from: d  reason: collision with root package name */
    private he f42821d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f42822e = false;

    /* renamed from: f  reason: collision with root package name */
    private Integer f42823f;

    /* renamed from: g  reason: collision with root package name */
    private final hg f42824g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final hl f42825h;

    /* renamed from: i  reason: collision with root package name */
    private final gp f42826i;

    /* renamed from: j  reason: collision with root package name */
    private final gx f42827j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public jp f42828k;

    /* renamed from: l  reason: collision with root package name */
    private Integer f42829l = null;

    /* renamed from: m  reason: collision with root package name */
    private List<dh> f42830m = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public Map<hj<?, ?, ?>, Object> f42831n;

    /* renamed from: o  reason: collision with root package name */
    private List<hf> f42832o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public boolean f42833p = false;

    /* renamed from: q  reason: collision with root package name */
    private Set<hj<?, ?, ?>> f42834q = new HashSet();

    public static class a {
        @SuppressLint({"NewApi"})
        public static boolean a(ViewGroup viewGroup) {
            return viewGroup.getClipChildren();
        }
    }

    public gu(View view, he heVar, Integer num, hg hgVar) {
        this.f42820c = new WeakReference<>(view);
        this.f42821d = heVar;
        this.f42823f = num;
        this.f42831n = new HashMap();
        this.f42824g = hgVar;
        this.f42825h = hgVar.a();
        this.f42826i = hgVar.b();
        this.f42827j = hgVar.c();
        this.f42832o = new ArrayList();
        this.f42828k = jp.a();
    }

    private jp m() {
        View view = this.f42820c.get();
        if (view == null) {
            return jp.a();
        }
        return this.f42821d.g().b(b(view), new jq(this.f42825h, view, this.f42831n));
    }

    private JSONObject n() throws JSONException {
        this.f42826i.b();
        View view = this.f42820c.get();
        if (view == null) {
            return new JSONObject();
        }
        JSONObject c11 = c(view);
        JSONArray jSONArray = new JSONArray();
        JSONArray a11 = this.f42825h.a(view);
        a(view, a11);
        if (a11.length() == 0) {
            String str = f42818b;
            bo.i(str, "Unsupported view hit with class name " + view.getClass().getName());
        }
        for (hf e11 : this.f42832o) {
            jSONArray.put((Object) e11.e());
        }
        c11.put("views", (Object) jSONArray);
        c11.put("parameters", (Object) a11);
        return c11;
    }

    private void o() {
        a((Collection<hj>) Collections.EMPTY_SET);
    }

    private void p() {
        final View view = this.f42820c.get();
        if (view != null) {
            this.f42826i.a(view, (fi) new fi() {
                public void run() {
                    HashSet hashSet = new HashSet();
                    for (di a11 : gu.this.f42828k.e()) {
                        hj<?, ?, ?> a12 = gu.this.f42825h.a((Object) view, a11.a());
                        if (a12 != null) {
                            hashSet.add(a12);
                        }
                    }
                    gu.this.a((Collection<hj>) hashSet);
                    boolean z11 = false;
                    for (di next : gu.this.f42828k.e()) {
                        hj<?, ?, ?> a13 = gu.this.f42825h.a((Object) view, next.a());
                        if (a13 == null) {
                            bo.e(gu.f42818b, String.format("View %s does not have property %s", new Object[]{view.toString(), next.a()}));
                        } else {
                            boolean d11 = gu.this.f42833p;
                            boolean unused = gu.this.f42833p = true;
                            try {
                                Object a14 = a13.a(view);
                                if (!gu.this.f42831n.containsKey(a13)) {
                                    gu.this.f42831n.put(a13, a14);
                                }
                                if (!fh.a((Object) a14, next.e())) {
                                    a13.a(view, next.e());
                                    z11 = true;
                                }
                            } catch (JSONException e11) {
                                bo.g(gu.f42818b, "Unexpected error when setting property " + a13.a(), e11);
                            } catch (hk e12) {
                                bo.g(gu.f42818b, "Unexpected error when setting property " + a13.a(), e12);
                            } catch (Throwable th2) {
                                boolean unused2 = gu.this.f42833p = d11;
                                throw th2;
                            }
                            boolean unused3 = gu.this.f42833p = d11;
                        }
                    }
                    if (!gu.this.f42831n.isEmpty() && z11) {
                        view.requestLayout();
                    }
                }
            });
        }
    }

    public JSONObject e() throws JSONException {
        return n();
    }

    public void f() {
        this.f42819a++;
        List<hf> list = this.f42832o;
        this.f42832o = a();
        HashSet hashSet = new HashSet();
        a((Set<he>) hashSet);
        for (hf a11 : list) {
            a11.a(false, hashSet);
        }
    }

    public jp g() {
        return this.f42828k;
    }

    public List<db> h() {
        View view = this.f42820c.get();
        if (view == null) {
            return new ArrayList();
        }
        List<db> h11 = this.f42821d.h();
        h11.add(b(view));
        return h11;
    }

    public WeakReference<View> i() {
        return this.f42820c;
    }

    public void j() {
        for (dh next : this.f42830m) {
            if (next.a().equals("click")) {
                this.f42827j.a(next.b());
            }
        }
    }

    public void k() {
        for (dh next : this.f42830m) {
            if (next.a().equals("itemClick")) {
                this.f42827j.a(next.b());
            }
        }
    }

    public void b() {
        d();
        this.f42832o = a();
    }

    public void c() {
        this.f42822e = true;
    }

    public void d() {
        a(m());
    }

    private JSONObject c(View view) throws JSONException {
        Point a11 = js.a(view);
        JSONObject jSONObject = new JSONObject();
        if (av.f41241d) {
            jSONObject.put("viewObject", (Object) JSONObject.quote(view.toString()));
        }
        jSONObject.put("left", view.getLeft() + a11.x);
        jSONObject.put("type", (Object) view.getClass().getName());
        jSONObject.put("persistentSelector", (Object) db.a(h()));
        jSONObject.put("availableEvents", (Object) a(view));
        jSONObject.put("contentOffset", (Object) d(view));
        jSONObject.put("width", view.getWidth());
        jSONObject.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, view.getTop() + a11.y);
        jSONObject.put("height", view.getHeight());
        jSONObject.put("hidden", js.b(view));
        if (view instanceof ViewGroup) {
            jSONObject.put("clipToBounds", a.a((ViewGroup) view));
        }
        return jSONObject;
    }

    private JSONObject d(View view) throws JSONException {
        return new JSONObject(view) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ View f42835a;

            {
                this.f42835a = r3;
                put(Param.X, r3.getScrollX());
                put(Param.Y, r3.getScrollY());
            }
        };
    }

    public void a(he heVar, Integer num) {
        if (!this.f42822e) {
            this.f42821d = heVar;
            this.f42823f = num;
        }
        d();
    }

    public db b(View view) {
        return dd.a(view.getClass(), FirebaseAnalytics.Param.INDEX, this.f42823f);
    }

    private void a(jp jpVar) {
        if (!this.f42828k.b() || !jpVar.b()) {
            br.b("setStyleForest index:" + this.f42823f + " attachments:" + this.f42828k.d().size(), this.f42820c.get());
            this.f42828k = jpVar;
            for (hf d11 : this.f42832o) {
                d11.d();
            }
            for (df next : this.f42828k.d()) {
                br.a("Attachment", (Object) next);
                this.f42827j.a(next.c());
            }
            this.f42830m = this.f42828k.f();
            p();
            this.f42829l = jpVar.c();
        }
    }

    public List<hf> a() {
        ArrayList arrayList = new ArrayList();
        View view = this.f42820c.get();
        if (view != null && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                if (this.f42824g.a(viewGroup.getChildAt(i11))) {
                    arrayList.add(this.f42824g.a(viewGroup.getChildAt(i11), (he) this, Integer.valueOf(i11)));
                }
            }
        }
        return arrayList;
    }

    public void a(Set<he> set) {
        for (hf next : this.f42832o) {
            set.add(next);
            next.a(set);
        }
    }

    private void a(View view, JSONArray jSONArray) throws JSONException {
        Object obj;
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i11);
            hj<?, ?, ?> a11 = this.f42825h.a((Object) view, jSONObject.getString("name"));
            if (this.f42831n.containsKey(a11)) {
                obj = this.f42831n.get(a11);
            } else {
                obj = jSONObject.get("value");
            }
            jSONObject.put("originalValue", (Object) obj);
        }
    }

    public JSONArray a(View view) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        if (view.isClickable()) {
            jSONArray.put((Object) "click");
        }
        return jSONArray;
    }

    public void a(boolean z11, Set<he> set) {
        if (!this.f42822e || z11) {
            if (!set.contains(this)) {
                o();
            }
            for (hf a11 : this.f42832o) {
                a11.a(false, set);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0086 A[Catch:{ hk -> 0x006a, JSONException -> 0x0050, all -> 0x0098 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0029 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.Collection<com.apptimize.hj> r12) {
        /*
            r11 = this;
            java.lang.String r0 = "Unexpected error when getting property "
            com.apptimize.gp r1 = r11.f42826i
            r1.a()
            java.lang.ref.WeakReference<android.view.View> r1 = r11.f42820c
            java.lang.Object r1 = r1.get()
            android.view.View r1 = (android.view.View) r1
            if (r1 != 0) goto L_0x0012
            return
        L_0x0012:
            boolean r2 = r11.f42833p
            r3 = 1
            r11.f42833p = r3
            java.util.Map<com.apptimize.hj<?, ?, ?>, java.lang.Object> r4 = r11.f42831n     // Catch:{ all -> 0x0098 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0098 }
            if (r4 != 0) goto L_0x0095
            java.util.Map<com.apptimize.hj<?, ?, ?>, java.lang.Object> r4 = r11.f42831n     // Catch:{ all -> 0x0098 }
            java.util.Set r4 = r4.entrySet()     // Catch:{ all -> 0x0098 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0098 }
        L_0x0029:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0098 }
            if (r5 == 0) goto L_0x0095
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0098 }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ all -> 0x0098 }
            java.lang.Object r6 = r5.getKey()     // Catch:{ all -> 0x0098 }
            com.apptimize.hj r6 = (com.apptimize.hj) r6     // Catch:{ all -> 0x0098 }
            boolean r7 = r12.contains(r6)     // Catch:{ all -> 0x0098 }
            if (r7 == 0) goto L_0x0042
            goto L_0x0029
        L_0x0042:
            java.lang.Object r7 = r6.a((android.view.View) r1)     // Catch:{ hk -> 0x006a, JSONException -> 0x0050 }
            java.lang.Object r8 = r5.getValue()     // Catch:{ hk -> 0x006a, JSONException -> 0x0050 }
            boolean r7 = com.apptimize.fh.a((java.lang.Object) r7, (java.lang.Object) r8)     // Catch:{ hk -> 0x006a, JSONException -> 0x0050 }
            r7 = r7 ^ r3
            goto L_0x0084
        L_0x0050:
            r7 = move-exception
            java.lang.String r8 = f42818b     // Catch:{ all -> 0x0098 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
            r9.<init>()     // Catch:{ all -> 0x0098 }
            r9.append(r0)     // Catch:{ all -> 0x0098 }
            java.lang.String r10 = r6.a()     // Catch:{ all -> 0x0098 }
            r9.append(r10)     // Catch:{ all -> 0x0098 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0098 }
            com.apptimize.bo.d(r8, r9, r7)     // Catch:{ all -> 0x0098 }
            goto L_0x0083
        L_0x006a:
            r7 = move-exception
            java.lang.String r8 = f42818b     // Catch:{ all -> 0x0098 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
            r9.<init>()     // Catch:{ all -> 0x0098 }
            r9.append(r0)     // Catch:{ all -> 0x0098 }
            java.lang.String r10 = r6.a()     // Catch:{ all -> 0x0098 }
            r9.append(r10)     // Catch:{ all -> 0x0098 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0098 }
            com.apptimize.bo.d(r8, r9, r7)     // Catch:{ all -> 0x0098 }
        L_0x0083:
            r7 = r3
        L_0x0084:
            if (r7 == 0) goto L_0x0029
            java.lang.Object r5 = r5.getValue()     // Catch:{ all -> 0x0098 }
            com.apptimize.gp r7 = r11.f42826i     // Catch:{ all -> 0x0098 }
            com.apptimize.gu$2 r8 = new com.apptimize.gu$2     // Catch:{ all -> 0x0098 }
            r8.<init>(r6, r1, r5)     // Catch:{ all -> 0x0098 }
            r7.b(r1, r8)     // Catch:{ all -> 0x0098 }
            goto L_0x0029
        L_0x0095:
            r11.f42833p = r2
            return
        L_0x0098:
            r12 = move-exception
            r11.f42833p = r2
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.gu.a(java.util.Collection):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000f, code lost:
        r0 = r3.f42820c.get();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(final com.apptimize.hj r4) {
        /*
            r3 = this;
            boolean r0 = com.apptimize.c.a()
            if (r0 == 0) goto L_0x0025
            java.util.Map<com.apptimize.hj<?, ?, ?>, java.lang.Object> r0 = r3.f42831n
            boolean r0 = r0.containsKey(r4)
            if (r0 != 0) goto L_0x000f
            return
        L_0x000f:
            java.lang.ref.WeakReference<android.view.View> r0 = r3.f42820c
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            if (r0 != 0) goto L_0x001a
            return
        L_0x001a:
            com.apptimize.gp r1 = r3.f42826i
            com.apptimize.gu$3 r2 = new com.apptimize.gu$3
            r2.<init>(r4, r0)
            r1.a((com.apptimize.fi) r2)
            return
        L_0x0025:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "Not on main thread"
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.gu.a(com.apptimize.hj):void");
    }

    public void a(hj hjVar, Method method) {
        if (!this.f42833p && !this.f42834q.contains(hjVar)) {
            try {
                this.f42834q.add(hjVar);
                if (av.f41253p) {
                    hn.a(hjVar, method);
                }
                a(hjVar);
                d();
            } finally {
                this.f42834q.remove(hjVar);
            }
        }
    }
}
