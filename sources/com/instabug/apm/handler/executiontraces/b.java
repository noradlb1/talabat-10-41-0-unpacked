package com.instabug.apm.handler.executiontraces;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.instabug.apm.cache.handler.executiontraces.c;
import com.instabug.apm.cache.handler.session.f;
import com.instabug.apm.di.a;
import com.instabug.library.model.common.Session;
import java.util.List;

@WorkerThread
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private c f45363a = a.z();

    /* renamed from: b  reason: collision with root package name */
    private com.instabug.apm.cache.handler.executiontraces.a f45364b = a.t();

    /* renamed from: c  reason: collision with root package name */
    private com.instabug.apm.logger.internal.a f45365c = a.f();

    /* renamed from: d  reason: collision with root package name */
    private com.instabug.apm.handler.session.c f45366d = a.W();
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private f f45367e = a.Y();

    /* renamed from: f  reason: collision with root package name */
    private com.instabug.apm.configuration.c f45368f = a.c();

    private int a(String str, long j11) {
        return this.f45363a.a(str, j11);
    }

    @Nullable
    public List a(String str) {
        return this.f45363a.a(str);
    }

    public void a() {
        this.f45363a.a();
        this.f45364b.a();
        f fVar = this.f45367e;
        if (fVar != null) {
            fVar.b();
        }
    }

    public void a(long j11) {
        this.f45363a.a(j11);
    }

    public boolean a(com.instabug.apm.cache.model.c cVar) {
        Session b11 = this.f45366d.b();
        if (b11 == null) {
            return this.f45364b.a(cVar);
        }
        boolean a11 = this.f45363a.a(b11.getId(), cVar);
        if (a11) {
            f fVar = this.f45367e;
            if (fVar != null) {
                fVar.h(b11.getId(), 1);
                int a12 = a(b11.getId(), this.f45368f.k());
                if (a12 > 0) {
                    this.f45367e.b(b11.getId(), a12);
                }
            }
            a(this.f45368f.x());
        } else {
            com.instabug.apm.logger.internal.a aVar = this.f45365c;
            aVar.g("Session meta data was not updated. Failed to insert custom trace " + cVar.e());
        }
        return a11;
    }

    public void b() {
        this.f45363a.b();
        this.f45364b.b();
    }
}
