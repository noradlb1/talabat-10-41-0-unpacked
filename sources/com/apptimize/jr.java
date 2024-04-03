package com.apptimize;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class jr<K> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<K, a> f43139a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final hc f43140a;

        /* renamed from: b  reason: collision with root package name */
        private final List<db> f43141b;

        public a(hc hcVar, List<db> list) {
            this.f43140a = hcVar;
            if (list == null) {
                this.f43141b = null;
            } else {
                this.f43141b = new ArrayList(list);
            }
        }

        public static a a(hc hcVar) {
            return new a(hcVar, (List<db>) null);
        }

        public List<db> b() {
            hc hcVar = this.f43140a;
            if (hcVar != null) {
                return hcVar.h();
            }
            return this.f43141b;
        }

        public static a a(List<db> list) {
            return new a((hc) null, list);
        }

        public hc a() {
            return this.f43140a;
        }
    }

    public jr(boolean z11) {
        if (z11) {
            this.f43139a = new WeakHashMap();
        } else {
            this.f43139a = new HashMap();
        }
    }

    public synchronized hc a(K k11) {
        a aVar = this.f43139a.get(k11);
        if (aVar == null) {
            return null;
        }
        return aVar.a();
    }

    public synchronized List<db> b(K k11) {
        a aVar = this.f43139a.get(k11);
        if (aVar == null) {
            return null;
        }
        return aVar.b();
    }

    public synchronized void c(K k11) {
        this.f43139a.remove(k11);
    }

    public synchronized void a(K k11, hc hcVar) {
        this.f43139a.put(k11, a.a(hcVar));
    }

    public synchronized Set<K> b() {
        return this.f43139a.keySet();
    }

    public synchronized void a(K k11, List<db> list) {
        this.f43139a.put(k11, a.a(list));
    }

    public synchronized Collection<hc> a() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (a next : this.f43139a.values()) {
            if (next.a() != null) {
                arrayList.add(next.a());
            }
        }
        return arrayList;
    }
}
