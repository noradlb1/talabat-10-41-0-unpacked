package com.instabug.apm.handler.session;

import com.instabug.apm.cache.model.f;
import com.instabug.apm.logger.internal.a;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.utils.stability.execution.Executable;
import java.util.concurrent.TimeUnit;

class e implements Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f45391a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j f45392b;

    public e(j jVar, int i11) {
        this.f45392b = jVar;
        this.f45391a = i11;
    }

    public void execute() {
        Runnable unused = this.f45392b.f45406f = null;
        f c11 = this.f45392b.b();
        if (c11 != null) {
            f fVar = new f(c11.getId(), c11.b(), c11.getOs(), c11.getAppVersion(), c11.getUuid(), TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - c11.getStartNanoTime()), c11.getStartTimestampMicros(), c11.getStartNanoTime(), c11.getVersion(), this.f45391a, -1);
            this.f45392b.b((f) null);
            this.f45392b.f45408h.execute(new d(this, fVar));
            this.f45392b.c(fVar);
            a f11 = this.f45392b.f45405e;
            f11.d("Ending session #" + fVar.getId());
        } else {
            this.f45392b.f45405e.g("Attempted to end session without calling start");
        }
        this.f45392b.f45401a.j(InstabugCore.isV3SessionEnabled());
    }
}
