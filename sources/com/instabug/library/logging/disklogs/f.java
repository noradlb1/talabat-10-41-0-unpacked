package com.instabug.library.logging.disklogs;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Nullable;
import com.instabug.library.Instabug;
import com.instabug.library.internal.resolver.c;
import com.instabug.library.model.g;
import com.instabug.library.util.threading.PoolProvider;
import java.util.concurrent.Executor;

public final class f {
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public a f51474a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public c f51475b;

    /* renamed from: c  reason: collision with root package name */
    private Executor f51476c = PoolProvider.getSingleThreadExecutor("LoggingExecutor");

    public f(Context context) {
        this.f51474a = new a(context);
        this.f51475b = c.a();
    }

    @SuppressLint({"THREAD_SAFETY_VIOLATION"})
    public void a(String str, String str2, String str3, long j11) {
        this.f51476c.execute(new b(this, str, str2, str3, j11));
    }

    public void b(String str, String str2, String str3, long j11) {
        this.f51476c.execute(new c(this, str, str2, str3, j11));
    }

    public void a(g gVar) {
        this.f51476c.execute(new d(this, gVar));
    }

    public void a(long j11) {
        this.f51476c.execute(new e(this, j11));
    }

    public void a(int i11) {
        if (i11 == 0) {
            a aVar = this.f51474a;
            if (aVar != null) {
                aVar.interrupt();
                this.f51474a = null;
            }
        } else if (this.f51474a == null && Instabug.getApplicationContext() != null) {
            this.f51474a = new a(Instabug.getApplicationContext());
        }
    }
}
