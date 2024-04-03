package com.instabug.apm.handler.uitrace.uihang;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.instabug.apm.cache.model.h;
import com.instabug.apm.handler.uitrace.c;
import com.instabug.apm.uitrace.a;

@RequiresApi(api = 16)
public class b implements a, c {

    /* renamed from: a  reason: collision with root package name */
    private final com.instabug.apm.configuration.c f45444a;

    /* renamed from: b  reason: collision with root package name */
    private final a f45445b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private h f45446c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f45447d = false;

    public b() {
        com.instabug.apm.configuration.c c11 = com.instabug.apm.di.a.c();
        this.f45444a = c11;
        this.f45445b = com.instabug.apm.di.a.a(this, c11.d());
    }

    public void a() {
        if (!this.f45447d) {
            this.f45447d = true;
            this.f45446c = new h();
            this.f45445b.a();
        }
    }

    public void a(long j11) {
        h hVar = this.f45446c;
        if (hVar != null) {
            hVar.a(Long.valueOf(j11));
            com.instabug.apm.configuration.c cVar = this.f45444a;
            if (cVar != null && ((float) j11) > cVar.T()) {
                this.f45446c.a(j11);
            }
        }
    }

    public void b() {
        if (this.f45447d) {
            this.f45447d = false;
            this.f45445b.b();
        }
    }

    @Nullable
    public h c() {
        return this.f45446c;
    }

    public void d() {
        this.f45446c = null;
    }
}
