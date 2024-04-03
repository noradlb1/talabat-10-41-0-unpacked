package com.instabug.apm.handler.applaunch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.instabug.apm.cache.handler.applaunch.a;
import com.instabug.apm.cache.handler.session.f;
import com.instabug.apm.configuration.c;
import java.util.List;

@WorkerThread
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private a f45359a = com.instabug.apm.di.a.j();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private f f45360b = com.instabug.apm.di.a.Y();

    /* renamed from: c  reason: collision with root package name */
    private c f45361c = com.instabug.apm.di.a.c();

    private int a(String str, long j11) {
        return this.f45359a.a(str, j11);
    }

    public long a(String str, com.instabug.apm.cache.model.b bVar) {
        long a11 = this.f45359a.a(str, bVar);
        if (a11 != -1) {
            f fVar = this.f45360b;
            if (fVar != null) {
                fVar.c(str, 1);
                int a12 = a(str, this.f45361c.m());
                if (a12 > 0) {
                    this.f45360b.j(str, a12);
                }
            }
            a(this.f45361c.S());
        }
        return a11;
    }

    public void a() {
        this.f45359a.a();
        f fVar = this.f45360b;
        if (fVar != null) {
            fVar.f();
        }
    }

    public void a(long j11) {
        this.f45359a.a(j11);
    }

    public void a(com.instabug.apm.cache.model.b bVar) {
        this.f45359a.a(bVar);
    }

    public void a(@NonNull String str) {
        this.f45359a.a(str);
    }

    @Nullable
    public List b(String str) {
        return this.f45359a.b(str);
    }
}
