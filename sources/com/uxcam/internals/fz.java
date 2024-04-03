package com.uxcam.internals;

import java.util.HashMap;

public class fz {

    /* renamed from: a  reason: collision with root package name */
    public String f13427a = "[#status#] #method#";

    /* renamed from: b  reason: collision with root package name */
    public HashMap f13428b = null;

    public fz a(String str) {
        this.f13427a = this.f13427a.replace("#method#", str);
        return this;
    }

    public fz b() {
        this.f13427a = this.f13427a.replace("#status#", "START");
        return this;
    }

    public fz c() {
        this.f13427a = this.f13427a.replace("#status#", "SUCCESS");
        return this;
    }

    public fz a(String str, String str2) {
        if (this.f13428b == null) {
            this.f13428b = new HashMap();
        }
        this.f13428b.put(str, str2);
        return this;
    }

    public fz a() {
        this.f13427a = this.f13427a.replace("#status#", "FAIL");
        return this;
    }

    public void a(int i11) {
        if (i11 == 2) {
            hu.c(this.f13427a, this.f13428b);
        } else if (i11 == 4) {
            hu.d(this.f13427a, this.f13428b);
        } else if (i11 == 1) {
            hu.b(this.f13427a, this.f13428b);
        } else if (i11 == 3) {
            hu.a(this.f13427a, this.f13428b);
        }
    }
}
