package com.huawei.hms.dtm.core;

import java.util.HashMap;
import java.util.Map;

public class Hc {

    /* renamed from: a  reason: collision with root package name */
    private int f48313a;

    /* renamed from: b  reason: collision with root package name */
    private String f48314b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f48315c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private String f48316d;

    public String a() {
        return this.f48316d;
    }

    public void a(int i11) {
        this.f48313a = i11;
    }

    public void a(String str) {
        this.f48316d = str;
    }

    public void a(String str, String str2) {
        this.f48315c.put(str, str2);
    }

    public String b() {
        return this.f48314b;
    }

    public void b(String str) {
        this.f48314b = str;
    }

    public int c() {
        return this.f48313a;
    }
}
