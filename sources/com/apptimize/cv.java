package com.apptimize;

class cv {

    /* renamed from: a  reason: collision with root package name */
    final boolean f41708a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f41709b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f41710c;

    public enum a {
        FILTERS_PASSED,
        FILTERS_FAILED
    }

    public enum b {
        IS_OVERRIDDEN,
        NOT_OVERRIDDEN
    }

    public enum c {
        REQUIRES_OVERRIDE,
        NO_REQUIRED_OVERRIDE
    }

    public cv(c cVar, b bVar, a aVar) {
        boolean z11;
        boolean z12;
        boolean z13 = true;
        if (cVar == c.REQUIRES_OVERRIDE) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.f41708a = z11;
        if (bVar == b.IS_OVERRIDDEN) {
            z12 = true;
        } else {
            z12 = false;
        }
        this.f41709b = z12;
        this.f41710c = aVar != a.FILTERS_PASSED ? false : z13;
    }

    public static cv a() {
        return new cv(c.NO_REQUIRED_OVERRIDE, b.NOT_OVERRIDDEN, a.FILTERS_FAILED);
    }
}
