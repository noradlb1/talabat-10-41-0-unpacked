package com.huawei.hms.dtm.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Rc {

    /* renamed from: a  reason: collision with root package name */
    private final String f48399a;

    /* renamed from: b  reason: collision with root package name */
    private Wc<?> f48400b;

    /* renamed from: c  reason: collision with root package name */
    private Wc<?> f48401c;

    /* renamed from: d  reason: collision with root package name */
    private List<Integer> f48402d;

    public Rc(String str, Wc<?> wc2, Wc<?> wc3, List<Integer> list) {
        this.f48399a = str;
        this.f48400b = wc2;
        this.f48401c = wc3;
        this.f48402d = list;
    }

    private List<C0435sc<?>> b(X x11) {
        Wc<?> wc2 = this.f48400b;
        if (wc2 == null || this.f48401c == null) {
            return null;
        }
        C0435sc<?> a11 = wc2.a(x11);
        C0435sc<?> a12 = this.f48401c.a(x11);
        if ((a11 instanceof C0470zc) || (a12 instanceof C0470zc)) {
            return null;
        }
        if ("$DTM_AT_CONTENT".equals(this.f48400b.getValue().toString())) {
            String scVar = a11.toString();
            Locale locale = Locale.ENGLISH;
            Cc cc2 = new Cc(scVar.toLowerCase(locale));
            a12 = new Cc(a12.toString().toLowerCase(locale));
            a11 = cc2;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(a11);
        arrayList.add(a12);
        return arrayList;
    }

    public String a() {
        return this.f48399a;
    }

    public boolean a(X x11) {
        C0348ba executable;
        List<C0435sc<?>> b11 = b(x11);
        if (!(b11 == null || (executable = DynamicTagManager.getInstance().getExecutable(this.f48399a)) == null)) {
            C0435sc<?> a11 = executable.a(x11.a(), b11);
            if (a11 instanceof C0430rc) {
                return ((Boolean) ((C0430rc) a11).value()).booleanValue();
            }
        }
        return false;
    }

    public Wc<?> b() {
        return this.f48400b;
    }

    public Wc<?> c() {
        return this.f48401c;
    }

    public List<Integer> d() {
        return this.f48402d;
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public int hashCode() {
        return this.f48399a.hashCode();
    }
}
