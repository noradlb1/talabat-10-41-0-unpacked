package com.apptimize;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class dx implements dy {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, Boolean> f42200a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, ce> f42201b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<String> f42202c;

    public dx() {
        this.f42200a = new HashMap<>();
        this.f42201b = new HashMap();
        this.f42202c = new HashSet();
    }

    public synchronized Boolean a(String str, bb bbVar) {
        if (this.f42200a.containsKey(str)) {
            return this.f42200a.get(str);
        } else if (this.f42202c.contains(str)) {
            String simpleName = dx.class.getSimpleName();
            bo.e(simpleName, "Found a circular reference on resolving " + str);
            return null;
        } else {
            ce ceVar = this.f42201b.get(str);
            if (ceVar == null) {
                String simpleName2 = dx.class.getSimpleName();
                bo.e(simpleName2, "Can't find a filter with name " + str);
                return null;
            }
            this.f42202c.add(str);
            Boolean a11 = ceVar.a(bbVar, (Map<String, Boolean>) this.f42200a);
            a(str, a11);
            this.f42202c.remove(str);
            return a11;
        }
    }

    public dx(Map<String, Boolean> map, Map<String, ce> map2) {
        this.f42200a = new HashMap<>(map);
        this.f42201b = map2;
        this.f42202c = new HashSet();
    }

    public synchronized void a(String str, Boolean bool) {
        this.f42200a.put(str, bool);
    }

    public synchronized Map<String, Boolean> a() {
        return Collections.unmodifiableMap(this.f42200a);
    }
}
