package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

public final class b<TResult> implements ExecuteResult<TResult> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public OnCanceledListener f47669a;

    /* renamed from: b  reason: collision with root package name */
    private Executor f47670b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Object f47671c = new Object();

    public b(Executor executor, OnCanceledListener onCanceledListener) {
        this.f47669a = onCanceledListener;
        this.f47670b = executor;
    }

    public final void cancel() {
        synchronized (this.f47671c) {
            this.f47669a = null;
        }
    }

    public final void onComplete(Task<TResult> task) {
        if (task.isCanceled()) {
            this.f47670b.execute(new Runnable() {
                public final void run() {
                    synchronized (b.this.f47671c) {
                        if (b.this.f47669a != null) {
                            b.this.f47669a.onCanceled();
                        }
                    }
                }
            });
        }
    }
}
