package com.huawei.hms.dtm.core;

import java.util.ArrayList;
import java.util.List;

public class Oc {

    /* renamed from: a  reason: collision with root package name */
    private final List<Rc> f48378a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<Qc<?>> f48379b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final List<Qc<?>> f48380c = new ArrayList();

    public List<Qc<?>> a() {
        return this.f48379b;
    }

    public void a(Qc<?> qc2) {
        this.f48379b.add(qc2);
    }

    public void a(Rc rc2) {
        this.f48378a.add(rc2);
    }

    public void a(List<Qc<?>> list) {
        this.f48379b.addAll(list);
    }

    public boolean a(X x11) {
        for (Rc a11 : this.f48378a) {
            if (!a11.a(x11.a())) {
                return false;
            }
        }
        return true;
    }

    public List<Qc<?>> b() {
        return this.f48380c;
    }

    public void b(Qc<?> qc2) {
        this.f48380c.add(qc2);
    }

    public void b(List<Qc<?>> list) {
        this.f48380c.addAll(list);
    }

    public List<Rc> c() {
        return this.f48378a;
    }

    public boolean d() {
        return this.f48378a.isEmpty() && this.f48379b.isEmpty() && this.f48380c.isEmpty();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Oc)) {
            return false;
        }
        List<Rc> list = ((Oc) obj).f48378a;
        if (list.size() != this.f48378a.size()) {
            return false;
        }
        return this.f48378a.containsAll(list);
    }

    public int hashCode() {
        return this.f48378a.hashCode();
    }
}
