package com.apptimize;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class au {

    /* renamed from: a  reason: collision with root package name */
    private final bq f41230a;

    /* renamed from: b  reason: collision with root package name */
    private final fv f41231b;

    /* renamed from: c  reason: collision with root package name */
    private final h f41232c;

    /* renamed from: d  reason: collision with root package name */
    private final ak f41233d;

    /* renamed from: e  reason: collision with root package name */
    private final eu f41234e;

    /* renamed from: f  reason: collision with root package name */
    private final bz f41235f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicBoolean f41236g;

    /* renamed from: h  reason: collision with root package name */
    private final List<fi> f41237h;

    public au(bq bqVar, fv fvVar, ak akVar) {
        this(bqVar, fvVar, (h) null, akVar, (eu) null, new bz());
    }

    public bq a() {
        return this.f41230a;
    }

    public fv b() {
        return this.f41231b;
    }

    public h c() {
        return this.f41232c;
    }

    public ak d() {
        return this.f41233d;
    }

    public eu e() {
        return this.f41234e;
    }

    public bz f() {
        return this.f41235f;
    }

    public void g() {
        if (!this.f41236g.compareAndSet(false, true)) {
            throw new IllegalStateException("Entering while already in setup");
        }
    }

    public boolean h() {
        return this.f41236g.get();
    }

    public void i() {
        if (this.f41236g.compareAndSet(true, false)) {
            for (fi run : this.f41237h) {
                run.run();
            }
            return;
        }
        throw new IllegalStateException("Exiting while not in setup");
    }

    public au(bq bqVar, fv fvVar, h hVar, ak akVar, eu euVar, bz bzVar) {
        this.f41236g = new AtomicBoolean(false);
        this.f41237h = new CopyOnWriteArrayList();
        this.f41230a = bqVar;
        this.f41231b = fvVar;
        this.f41232c = hVar == null ? new h() : hVar;
        this.f41233d = akVar;
        euVar = euVar == null ? new eu() : euVar;
        this.f41234e = euVar;
        fvVar.a(euVar);
        this.f41235f = bzVar;
    }

    public void a(fi fiVar) {
        this.f41237h.add(fiVar);
    }
}
