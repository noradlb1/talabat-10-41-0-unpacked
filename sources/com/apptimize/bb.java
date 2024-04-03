package com.apptimize;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class bb {

    /* renamed from: a  reason: collision with root package name */
    private final be f41357a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Object> f41358b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Object> f41359c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Set<String>> f41360d;

    /* renamed from: e  reason: collision with root package name */
    private final cj f41361e;

    /* renamed from: f  reason: collision with root package name */
    private final int f41362f;

    /* renamed from: g  reason: collision with root package name */
    private final dy f41363g;

    public bb(be beVar, Map<String, Object> map, Map<String, Object> map2, dy dyVar, Map<String, Set<String>> map3, cj cjVar, int i11) {
        this.f41357a = beVar;
        this.f41358b = Collections.unmodifiableMap(new HashMap(map));
        this.f41359c = Collections.unmodifiableMap(new HashMap(map2));
        this.f41360d = Collections.unmodifiableMap(new HashMap(map3));
        this.f41361e = cjVar;
        this.f41362f = i11;
        this.f41363g = dyVar;
    }

    public bb a(dy dyVar) {
        return new bb(this.f41357a, this.f41358b, this.f41359c, dyVar, this.f41360d, this.f41361e, this.f41362f);
    }

    public Map<String, Object> b() {
        return this.f41358b;
    }

    public Map<String, Object> c() {
        return this.f41359c;
    }

    public Map<String, Set<String>> d() {
        return this.f41360d;
    }

    public cj e() {
        return this.f41361e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof bb)) {
            return false;
        }
        bb bbVar = (bb) obj;
        if (!this.f41357a.equals(bbVar.a()) || !ey.a(this.f41358b, bbVar.b()) || !ey.a(this.f41359c, bbVar.c()) || !this.f41363g.a().equals(bbVar.f41363g.a()) || !this.f41361e.equals(bbVar.e()) || this.f41362f != bbVar.f()) {
            return false;
        }
        return true;
    }

    public int f() {
        return this.f41362f;
    }

    public String toString() {
        return String.format("<%s: deviceProperties:%s, userAttributes:%s, customAttributes:%s, namedFilters:%s, metadataSequenceNumber:%d", new Object[]{super.toString(), this.f41357a, this.f41358b, this.f41359c, this.f41363g.a(), Integer.valueOf(this.f41362f)});
    }

    public bb a(Map<String, Set<String>> map) {
        return new bb(this.f41357a, this.f41358b, this.f41359c, this.f41363g, map, this.f41361e, this.f41362f);
    }

    public bb a(int i11) {
        return new bb(this.f41357a, this.f41358b, this.f41359c, this.f41363g, this.f41360d, this.f41361e, i11);
    }

    public Boolean a(String str) {
        return this.f41363g.a(str, this);
    }

    public be a() {
        return this.f41357a;
    }
}
