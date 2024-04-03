package com.apptimize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class jp {

    /* renamed from: a  reason: collision with root package name */
    private List<a> f43126a;

    /* renamed from: b  reason: collision with root package name */
    private Map<a, Integer> f43127b;

    /* renamed from: c  reason: collision with root package name */
    private int f43128c;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f43131a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public db f43132b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public List<df> f43133c = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public jp f43134d = jp.a();

        public a(db dbVar) {
            this.f43132b = dbVar;
        }

        public static a a(List<db> list, List<df> list2, db dbVar, int i11) {
            a aVar = new a(dbVar);
            aVar.a(list, list2, 0, i11);
            return aVar;
        }

        private void a(List<df> list, int i11) {
            br.b("StyleTree updateWithAttachments version", Integer.valueOf(i11));
            for (df c11 : list) {
                br.b("StyleTree updateWithAttachments variantId", c11.c());
            }
            if (this.f43131a < i11) {
                this.f43133c = new ArrayList(list);
            } else {
                this.f43133c.addAll(list);
            }
        }

        public void a(List<db> list, List<df> list2, int i11, int i12) {
            if (i11 == list.size()) {
                a(list2, i12);
                this.f43131a = i12;
                return;
            }
            this.f43134d.a(list, list2, i11, i12);
        }

        public boolean a(int i11) {
            boolean z11;
            boolean z12 = true;
            if (i11 == this.f43131a) {
                z11 = true;
            } else {
                if (!this.f43133c.isEmpty()) {
                    this.f43133c = new ArrayList();
                }
                z11 = false;
            }
            if (!this.f43134d.a(i11) && !z11) {
                z12 = false;
            }
            if (z12) {
                this.f43131a = i11;
            }
            return z12;
        }
    }

    private jp(List<a> list, Map<a, Integer> map) {
        this.f43126a = list;
        this.f43127b = map;
        this.f43128c = 0;
    }

    private jp g() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        if (!this.f43126a.isEmpty()) {
            for (a next : this.f43126a) {
                for (a next2 : next.f43134d.f43126a) {
                    arrayList.add(next2);
                    hashMap.put(next2, this.f43127b.get(next));
                }
            }
        }
        return new jp(arrayList, hashMap);
    }

    public boolean b() {
        return this.f43126a.isEmpty();
    }

    public Integer c() {
        if (b()) {
            return null;
        }
        return Integer.valueOf(this.f43126a.get(0).f43131a);
    }

    public List<df> d() {
        ArrayList arrayList = new ArrayList();
        for (a b11 : this.f43126a) {
            arrayList.addAll(b11.f43133c);
        }
        return arrayList;
    }

    public List<di> e() {
        return a(di.class);
    }

    public List<dh> f() {
        return a(dh.class);
    }

    public jp b(db dbVar, bf bfVar) {
        return g().a(dbVar, bfVar);
    }

    public static jp a() {
        return new jp(new ArrayList());
    }

    private <T extends df> List<T> a(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        for (df next : d()) {
            if (cls.isInstance(next)) {
                arrayList.add(cls.cast(next));
            }
        }
        return arrayList;
    }

    private jp(List<a> list) {
        this(list, (Map<a, Integer>) null);
    }

    /* access modifiers changed from: private */
    public void a(List<db> list, List<df> list2, int i11, int i12) {
        db dbVar = list.get(i11);
        for (a next : this.f43126a) {
            if (next.f43132b.equals(dbVar)) {
                next.a(list, list2, i11 + 1, i12);
                return;
            }
        }
        this.f43126a.add(a.a(list.subList(i11 + 1, list.size()), list2, dbVar, i12));
    }

    private void a(List<db> list, List<df> list2, int i11) {
        a(list, list2, 0, i11);
    }

    /* access modifiers changed from: private */
    public boolean a(int i11) {
        ArrayList arrayList = new ArrayList();
        boolean z11 = false;
        for (a next : this.f43126a) {
            if (next.a(i11)) {
                arrayList.add(next);
                z11 = true;
            }
        }
        this.f43126a = arrayList;
        return z11;
    }

    public void a(List<dc> list) {
        this.f43128c++;
        for (dc next : list) {
            a(next.f41756b, next.f41755a, this.f43128c);
        }
        a(this.f43128c);
    }

    public jp a(db dbVar, bf bfVar) {
        ArrayList arrayList = new ArrayList();
        final HashMap hashMap = new HashMap();
        if (!this.f43126a.isEmpty()) {
            for (a next : this.f43126a) {
                Map<a, Integer> map = this.f43127b;
                int intValue = map != null ? map.get(next).intValue() : 0;
                int a11 = next.f43132b.a(dbVar, bfVar);
                if (a11 >= 0) {
                    arrayList.add(next);
                    hashMap.put(next, Integer.valueOf(intValue + a11));
                }
            }
            Collections.sort(arrayList, new Comparator<a>() {
                /* renamed from: a */
                public int compare(a aVar, a aVar2) {
                    return ((Integer) hashMap.get(aVar)).compareTo((Integer) hashMap.get(aVar2));
                }
            });
        }
        return new jp(arrayList, hashMap);
    }
}
