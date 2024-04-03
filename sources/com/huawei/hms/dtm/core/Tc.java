package com.huawei.hms.dtm.core;

public final class Tc extends Sc<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    private static final Tc f48419b = new Tc(Boolean.TRUE);

    /* renamed from: c  reason: collision with root package name */
    private static final Tc f48420c = new Tc(Boolean.FALSE);

    private Tc(Boolean bool) {
        super(bool);
    }

    public static Tc a(boolean z11) {
        return z11 ? f48419b : f48420c;
    }

    public C0435sc<?> a(X x11) {
        return C0430rc.a(((Boolean) this.f48409a).booleanValue());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Tc)) {
            return false;
        }
        return ((Boolean) ((Tc) obj).f48409a).equals(this.f48409a);
    }

    public int hashCode() {
        return ((Boolean) this.f48409a).hashCode();
    }
}
