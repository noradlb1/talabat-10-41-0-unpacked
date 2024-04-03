package com.instabug.apm.cache.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f45243a = {"ac_on_c_mus", "ac_on_st_mus", "ac_on_r_mus", "ac_on_c_mus_st", "ac_on_st_mus_st", "ac_on_r_mus_st"};

    /* renamed from: b  reason: collision with root package name */
    private long f45244b;

    /* renamed from: c  reason: collision with root package name */
    private long f45245c = -1;

    /* renamed from: d  reason: collision with root package name */
    private long f45246d = -1;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Map f45247e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private String f45248f = "cold";

    private boolean a() {
        if (this.f45247e == null) {
            return false;
        }
        for (String str : this.f45243a) {
            Long l11 = (Long) this.f45247e.get(str);
            if (l11 == null || l11.longValue() <= 0) {
                return false;
            }
        }
        return true;
    }

    public void a(long j11) {
        this.f45245c = j11;
    }

    public void a(String str) {
        this.f45248f = str;
    }

    public void a(@NonNull String str, Long l11) {
        Map map = this.f45247e;
        if (map != null) {
            map.put(str, l11);
        }
    }

    public void a(@Nullable Map map) {
        this.f45247e = map;
    }

    public long b() {
        return this.f45245c;
    }

    public void b(long j11) {
        this.f45244b = j11;
    }

    public long c() {
        return this.f45244b;
    }

    public void c(long j11) {
        this.f45246d = j11;
    }

    @Nullable
    public Map d() {
        return this.f45247e;
    }

    public long e() {
        return this.f45246d;
    }

    public String f() {
        return this.f45248f;
    }

    public boolean g() {
        return this.f45245c > 0 && this.f45246d > 0 && a();
    }
}
