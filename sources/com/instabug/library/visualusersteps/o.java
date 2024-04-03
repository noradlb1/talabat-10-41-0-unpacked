package com.instabug.library.visualusersteps;

import java.util.concurrent.Callable;

class o implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f52179b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f52180c;

    public o(p pVar, String str) {
        this.f52180c = pVar;
        this.f52179b = str;
    }

    /* renamed from: a */
    public Boolean call() {
        return Boolean.valueOf(this.f52180c.a(this.f52179b));
    }
}
