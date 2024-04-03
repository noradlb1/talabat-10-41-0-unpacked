package com.huawei.hms.dtm.core;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Gc {

    /* renamed from: a  reason: collision with root package name */
    private URL f48302a;

    /* renamed from: b  reason: collision with root package name */
    private String f48303b = "GET";

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f48304c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private String f48305d;

    public String a() {
        return this.f48305d;
    }

    public void a(String str) {
        this.f48305d = str;
    }

    public void a(URL url) {
        this.f48302a = url;
    }

    public void a(Map<String, String> map) {
        this.f48304c = map;
    }

    public Map<String, String> b() {
        return this.f48304c;
    }

    public void b(String str) {
        this.f48303b = str;
    }

    public String c() {
        return this.f48303b;
    }

    public URL d() {
        return this.f48302a;
    }
}
