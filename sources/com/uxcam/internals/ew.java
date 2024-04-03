package com.uxcam.internals;

public class ew {

    /* renamed from: a  reason: collision with root package name */
    public final int f13301a;

    /* renamed from: b  reason: collision with root package name */
    public final int f13302b;

    public ew(int i11, int i12) {
        this.f13301a = i11;
        this.f13302b = i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ew.class != obj.getClass()) {
            return false;
        }
        ew ewVar = (ew) obj;
        if (this.f13302b != ewVar.f13302b) {
            return false;
        }
        if (this.f13301a == ewVar.f13301a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f13302b + 31) * 31) + this.f13301a;
    }
}
