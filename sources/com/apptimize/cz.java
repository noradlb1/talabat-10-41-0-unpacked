package com.apptimize;

public class cz extends cp {

    /* renamed from: a  reason: collision with root package name */
    private final co f41725a;

    public cz(co coVar) {
        this.f41725a = coVar;
    }

    public boolean a(cs csVar) {
        if (csVar.a(this.f41725a)) {
            return true;
        }
        for (cs a11 : csVar.e()) {
            if (a11.a(this)) {
                return true;
            }
        }
        return false;
    }
}
