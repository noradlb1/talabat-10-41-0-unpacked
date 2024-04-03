package com.uxcam.internals;

public class gp {

    /* renamed from: a  reason: collision with root package name */
    public final int f13486a;

    /* renamed from: b  reason: collision with root package name */
    public final int f13487b;

    public gp(int i11, int i12) {
        this.f13486a = i11;
        this.f13487b = i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || gp.class != obj.getClass()) {
            return false;
        }
        gp gpVar = (gp) obj;
        if (this.f13487b != gpVar.f13487b) {
            return false;
        }
        if (this.f13486a == gpVar.f13486a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f13487b + 31) * 31) + this.f13486a;
    }
}
