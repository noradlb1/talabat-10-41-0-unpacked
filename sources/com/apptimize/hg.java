package com.apptimize;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.apptimize.bq;
import com.apptimize.gn;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class hg {

    /* renamed from: a  reason: collision with root package name */
    private static final String f42917a = "hg";

    /* renamed from: b  reason: collision with root package name */
    private final Map<View, hf> f42918b = new WeakHashMap();

    /* renamed from: c  reason: collision with root package name */
    private final hl f42919c;

    /* renamed from: d  reason: collision with root package name */
    private final gp f42920d;

    /* renamed from: e  reason: collision with root package name */
    private final gx f42921e;

    /* renamed from: f  reason: collision with root package name */
    private final gs f42922f;

    /* renamed from: g  reason: collision with root package name */
    private final hb f42923g;

    /* renamed from: h  reason: collision with root package name */
    private final gv f42924h;

    /* renamed from: i  reason: collision with root package name */
    private final gw f42925i;

    /* renamed from: j  reason: collision with root package name */
    private final hh f42926j;

    /* renamed from: k  reason: collision with root package name */
    private final au f42927k;

    public hg(ClassLoader classLoader, hl hlVar, gp gpVar, gx gxVar, au auVar) {
        this.f42919c = hlVar;
        this.f42920d = gpVar;
        this.f42921e = gxVar;
        this.f42922f = new gs(this, auVar);
        this.f42923g = new hb(auVar);
        this.f42924h = new gv(this);
        this.f42925i = new gw(this);
        this.f42926j = new hh(this, classLoader, auVar);
        this.f42927k = auVar;
    }

    public boolean a(View view) {
        try {
            return !Class.forName("com.android.internal.widget.ActionBarContainer").isInstance(view);
        } catch (ClassNotFoundException e11) {
            bo.d(f42917a, "Could not find ActionBarContainer class", e11);
            return true;
        }
    }

    public hf b(View view, he heVar, Integer num) {
        hf b11 = b(view);
        if (b11 == null || !(b11 instanceof gz)) {
            if ((view instanceof AdapterView) || hb.a(view)) {
                this.f42927k.a().a(bq.b.NestedAdapterViews);
            }
            gz gzVar = new gz(view, heVar, num, this);
            a(view, gzVar);
            gzVar.b();
            return gzVar;
        }
        b11.a(heVar, (Integer) null);
        ((gz) b11).a(num);
        return b11;
    }

    public gx c() {
        return this.f42921e;
    }

    public hh d() {
        return this.f42926j;
    }

    public boolean e() {
        return gn.w();
    }

    public void f() {
        gn.x();
    }

    public hf a(View view, he heVar, Integer num) {
        gt gtVar;
        this.f42926j.b(view);
        hf b11 = b(view);
        if (b11 == null) {
            if (view instanceof AdapterView) {
                AdapterView adapterView = (AdapterView) view;
                gt gtVar2 = new gt(adapterView, heVar, num, this);
                this.f42922f.a(adapterView, gtVar2);
                gtVar = gtVar2;
            } else if (hb.a(view)) {
                gtVar = new ha((ViewGroup) view, heVar, num, this);
            } else if (hh.a(view)) {
                gtVar = new hi(view, heVar, num, this);
            } else {
                gtVar = new gu(view, heVar, num, this);
            }
            a(view, gtVar);
            gtVar.b();
            return gtVar;
        }
        b11.a(heVar, num);
        return b11;
    }

    public synchronized hf b(View view) {
        return this.f42918b.get(view);
    }

    public gp b() {
        return this.f42920d;
    }

    public synchronized void a(View view, hf hfVar) {
        this.f42918b.put(view, hfVar);
    }

    public hl a() {
        return this.f42919c;
    }

    public void a(fi fiVar) {
        c.a(fiVar);
    }

    public void a(Method method, gk gkVar, gn.b bVar) {
        gn.c(method, gkVar, bVar);
    }
}
