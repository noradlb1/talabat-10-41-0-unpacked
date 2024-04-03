package com.instabug.apm.handler.session;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.instabug.apm.cache.handler.session.a;
import com.instabug.apm.cache.model.f;
import com.instabug.apm.configuration.c;
import com.instabug.apm.configuration.g;
import com.instabug.library.internal.utils.stability.handler.exception.ExceptionHandler;
import com.instabug.library.model.common.Session;
import com.instabug.library.model.common.SessionVersion;
import java.util.List;
import java.util.concurrent.Executor;

public class j implements c {
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final c f45401a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final g f45402b;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final a f45403c;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ExceptionHandler f45404d;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final com.instabug.apm.logger.internal.a f45405e;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Runnable f45406f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private volatile f f45407g;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final Executor f45408h = com.instabug.apm.di.a.c0();

    public j(@NonNull c cVar, @NonNull g gVar, @NonNull a aVar, @NonNull ExceptionHandler exceptionHandler, @NonNull com.instabug.apm.logger.internal.a aVar2) {
        this.f45401a = cVar;
        this.f45402b = gVar;
        this.f45403c = aVar;
        this.f45404d = exceptionHandler;
        this.f45405e = aVar2;
    }

    @NonNull
    private Runnable b(@NonNull Session session) {
        return new i(this, session);
    }

    /* access modifiers changed from: private */
    public synchronized void b(@Nullable f fVar) {
        this.f45407g = fVar;
    }

    /* access modifiers changed from: private */
    public void c(f fVar) {
        com.instabug.apm.handler.experiment.a D;
        if (!fVar.getVersion().equals(SessionVersion.V3) && (D = com.instabug.apm.di.a.D()) != null) {
            D.a(fVar.getId());
        }
    }

    @Nullable
    public f a(String str) {
        return this.f45403c.a(str);
    }

    @NonNull
    public List a() {
        return this.f45403c.a();
    }

    @NonNull
    public List a(@NonNull List list) {
        return this.f45403c.a(list);
    }

    public void a(int i11) {
        this.f45403c.a(i11);
    }

    @WorkerThread
    public void a(@NonNull f fVar) {
        g gVar;
        if ("1".equals(fVar.getId()) && (gVar = this.f45402b) != null) {
            gVar.M();
        }
    }

    public void a(@NonNull Session session) {
        if (this.f45401a.H() && b() == null && this.f45406f == null) {
            this.f45406f = b(session);
            if (this.f45401a.H()) {
                this.f45406f.run();
            }
        }
    }

    public void a(@NonNull String str, long j11, int i11) {
        com.instabug.apm.di.a.N().execute(new f(this, str, j11, i11));
    }

    public void a(@NonNull List list, int i11) {
        this.f45403c.a(list, i11);
    }

    public void b(int i11) {
        this.f45404d.execute(new e(this, i11));
    }

    public void b(@NonNull List list) {
        this.f45403c.b(list);
    }

    @Nullable
    /* renamed from: c */
    public synchronized f b() {
        return this.f45407g;
    }

    @WorkerThread
    public void d() {
        c cVar;
        int b11;
        if (this.f45402b != null && (cVar = this.f45401a) != null && cVar.g0() && (b11 = this.f45403c.b(this.f45401a.L())) > 0) {
            this.f45402b.b(b11);
        }
    }
}
