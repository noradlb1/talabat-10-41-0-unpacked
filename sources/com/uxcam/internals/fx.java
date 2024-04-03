package com.uxcam.internals;

import java.util.HashMap;

public class fx {

    /* renamed from: a  reason: collision with root package name */
    public String f13424a = "[ #event# ]";

    /* renamed from: b  reason: collision with root package name */
    public HashMap f13425b = new HashMap();

    public fx a(String str, String str2) {
        if (this.f13425b == null) {
            this.f13425b = new HashMap();
        }
        this.f13425b.put(str, str2);
        return this;
    }

    public fx a(String str) {
        this.f13424a = this.f13424a.replace("#event#", str);
        return this;
    }

    public fx a(String str, float f11) {
        a(str, "" + f11);
        return this;
    }

    public void a(int i11) {
        if (i11 == 2) {
            hu.c(this.f13424a, this.f13425b);
        } else if (i11 == 4) {
            hu.d(this.f13424a, this.f13425b);
        } else if (i11 == 1) {
            hu.b(this.f13424a, this.f13425b);
        } else if (i11 == 3) {
            hu.a(this.f13424a, this.f13425b);
        }
    }
}
