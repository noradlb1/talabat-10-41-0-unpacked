package com.apptimize;

import java.util.ArrayList;
import java.util.List;

public class cy extends cq {

    /* renamed from: a  reason: collision with root package name */
    private final co f41723a;

    /* renamed from: b  reason: collision with root package name */
    private final List<ct<?, ?>> f41724b = new ArrayList();

    public cy(co coVar) {
        this.f41723a = coVar;
    }

    public cy a(ct<?, ?> ctVar) {
        this.f41724b.add(ctVar);
        return this;
    }

    public void a(cs csVar) {
        for (ct<?, ?> a11 : this.f41724b) {
            a11.a(csVar);
        }
        csVar.a(this.f41723a);
        for (cs a12 : csVar.e()) {
            a12.a(this);
        }
        for (ct<?, ?> b11 : this.f41724b) {
            b11.b(csVar);
        }
    }
}
