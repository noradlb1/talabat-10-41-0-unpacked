package com.iab.omid.library.deliveryhero3.walking;

import android.view.View;
import android.view.ViewParent;
import com.iab.omid.library.deliveryhero3.internal.c;
import com.iab.omid.library.deliveryhero3.internal.e;
import com.iab.omid.library.deliveryhero3.utils.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<View, String> f45019a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<View, C0052a> f45020b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, View> f45021c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<View> f45022d = new HashSet<>();

    /* renamed from: e  reason: collision with root package name */
    private final HashSet<String> f45023e = new HashSet<>();

    /* renamed from: f  reason: collision with root package name */
    private final HashSet<String> f45024f = new HashSet<>();

    /* renamed from: g  reason: collision with root package name */
    private final HashMap<String, String> f45025g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private final Map<View, Boolean> f45026h = new WeakHashMap();

    /* renamed from: i  reason: collision with root package name */
    private boolean f45027i;

    /* renamed from: com.iab.omid.library.deliveryhero3.walking.a$a  reason: collision with other inner class name */
    public static class C0052a {

        /* renamed from: a  reason: collision with root package name */
        private final e f45028a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<String> f45029b = new ArrayList<>();

        public C0052a(e eVar, String str) {
            this.f45028a = eVar;
            a(str);
        }

        public e a() {
            return this.f45028a;
        }

        public void a(String str) {
            this.f45029b.add(str);
        }

        public ArrayList<String> b() {
            return this.f45029b;
        }
    }

    private String a(View view) {
        if (!view.isAttachedToWindow()) {
            return "notAttached";
        }
        if (b(view).booleanValue()) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String a11 = h.a(view);
            if (a11 != null) {
                return a11;
            }
            hashSet.add(view);
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.f45022d.addAll(hashSet);
        return null;
    }

    private void a(com.iab.omid.library.deliveryhero3.adsession.a aVar) {
        for (e a11 : aVar.d()) {
            a(a11, aVar);
        }
    }

    private void a(e eVar, com.iab.omid.library.deliveryhero3.adsession.a aVar) {
        View view = (View) eVar.c().get();
        if (view != null) {
            C0052a aVar2 = this.f45020b.get(view);
            if (aVar2 != null) {
                aVar2.a(aVar.getAdSessionId());
            } else {
                this.f45020b.put(view, new C0052a(eVar, aVar.getAdSessionId()));
            }
        }
    }

    private Boolean b(View view) {
        if (view.hasWindowFocus()) {
            this.f45026h.remove(view);
            return Boolean.FALSE;
        } else if (this.f45026h.containsKey(view)) {
            return this.f45026h.get(view);
        } else {
            Map<View, Boolean> map = this.f45026h;
            Boolean bool = Boolean.FALSE;
            map.put(view, bool);
            return bool;
        }
    }

    public View a(String str) {
        return this.f45021c.get(str);
    }

    public void a() {
        this.f45019a.clear();
        this.f45020b.clear();
        this.f45021c.clear();
        this.f45022d.clear();
        this.f45023e.clear();
        this.f45024f.clear();
        this.f45025g.clear();
        this.f45027i = false;
    }

    public String b(String str) {
        return this.f45025g.get(str);
    }

    public HashSet<String> b() {
        return this.f45024f;
    }

    public C0052a c(View view) {
        C0052a aVar = this.f45020b.get(view);
        if (aVar != null) {
            this.f45020b.remove(view);
        }
        return aVar;
    }

    public HashSet<String> c() {
        return this.f45023e;
    }

    public String d(View view) {
        if (this.f45019a.size() == 0) {
            return null;
        }
        String str = this.f45019a.get(view);
        if (str != null) {
            this.f45019a.remove(view);
        }
        return str;
    }

    public void d() {
        this.f45027i = true;
    }

    public c e(View view) {
        return this.f45022d.contains(view) ? c.PARENT_VIEW : this.f45027i ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public void e() {
        c c11 = c.c();
        if (c11 != null) {
            for (com.iab.omid.library.deliveryhero3.adsession.a next : c11.a()) {
                View c12 = next.c();
                if (next.f()) {
                    String adSessionId = next.getAdSessionId();
                    if (c12 != null) {
                        String a11 = a(c12);
                        if (a11 == null) {
                            this.f45023e.add(adSessionId);
                            this.f45019a.put(c12, adSessionId);
                            a(next);
                        } else if (a11 != "noWindowFocus") {
                            this.f45024f.add(adSessionId);
                            this.f45021c.put(adSessionId, c12);
                            this.f45025g.put(adSessionId, a11);
                        }
                    } else {
                        this.f45024f.add(adSessionId);
                        this.f45025g.put(adSessionId, "noAdView");
                    }
                }
            }
        }
    }

    public boolean f(View view) {
        if (!this.f45026h.containsKey(view)) {
            return true;
        }
        this.f45026h.put(view, Boolean.TRUE);
        return false;
    }
}
