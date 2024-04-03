package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.CancellationToken;
import java.util.ArrayList;
import java.util.List;

public final class c extends CancellationToken {

    /* renamed from: a  reason: collision with root package name */
    public final List<Runnable> f47673a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final Object f47674b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public boolean f47675c = false;

    public final boolean isCancellationRequested() {
        return this.f47675c;
    }

    public final CancellationToken register(Runnable runnable) {
        synchronized (this.f47674b) {
            if (this.f47675c) {
                runnable.run();
            } else {
                this.f47673a.add(runnable);
            }
        }
        return this;
    }
}
