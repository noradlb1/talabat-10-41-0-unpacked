package com.apptimize;

import java.util.Timer;

public class fv {

    /* renamed from: a  reason: collision with root package name */
    private eu f42474a = new eu();

    public synchronized void a(eu euVar) {
        this.f42474a = euVar;
    }

    public synchronized long b() {
        return this.f42474a.a();
    }

    public synchronized long c() {
        return this.f42474a.e();
    }

    public Timer a() {
        return new Timer();
    }

    public fm a(fi fiVar, Long l11) {
        return new fm(fg.f42427b, fiVar, l11, this.f42474a);
    }

    public fo a(fi fiVar) {
        return new fo(fg.f42427b, fiVar);
    }
}
