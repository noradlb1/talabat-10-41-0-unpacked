package com.apptimize;

import java.util.Set;

public class cw extends ct<cm, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Long> f41720a;

    public cw(Set<Long> set) {
        super(cm.class, Boolean.FALSE);
        this.f41720a = set;
    }

    public boolean b() {
        return ((Boolean) a()).booleanValue();
    }

    public boolean c() {
        return !this.f41720a.isEmpty();
    }

    public Boolean a(cm cmVar) {
        return Boolean.valueOf(this.f41720a.contains(Long.valueOf(cmVar.j())));
    }
}
