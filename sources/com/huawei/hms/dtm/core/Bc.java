package com.huawei.hms.dtm.core;

import java.util.List;

public class Bc implements C0435sc<String> {

    /* renamed from: a  reason: collision with root package name */
    private String f48268a;

    /* renamed from: b  reason: collision with root package name */
    private List<C0435sc<?>> f48269b;

    public Bc(Bc bc2) {
        this(bc2.f48268a, bc2.f48269b);
    }

    public Bc(String str, List<C0435sc<?>> list) {
        this.f48268a = str;
        this.f48269b = list;
    }

    public String a() {
        throw new V("segment to json");
    }

    public boolean b() {
        throw new V("segment not empty");
    }

    public Double c() {
        throw new V("segment to double");
    }

    public Object d() {
        return this.f48268a;
    }

    public List<C0435sc<?>> e() {
        return this.f48269b;
    }

    public String toString() {
        return this.f48268a;
    }

    public String value() {
        return this.f48268a;
    }
}
