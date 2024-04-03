package com.uxcam.internals;

public class ac implements be {

    /* renamed from: a  reason: collision with root package name */
    public final String f12973a;

    public ac(String str) {
        this.f12973a = str;
    }

    public int a() {
        return 1;
    }

    public String b() {
        return this.f12973a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ac) || !((ac) obj).f12973a.equalsIgnoreCase(this.f12973a)) {
            return super.equals(obj);
        }
        return true;
    }

    public int hashCode() {
        return this.f12973a.hashCode();
    }
}
