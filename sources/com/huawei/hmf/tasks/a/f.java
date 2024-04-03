package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

public final class f<TResult> implements ExecuteResult<TResult> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public OnFailureListener f47687a;

    /* renamed from: b  reason: collision with root package name */
    private Executor f47688b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Object f47689c = new Object();

    public f(Executor executor, OnFailureListener onFailureListener) {
        this.f47687a = onFailureListener;
        this.f47688b = executor;
    }

    public final void cancel() {
        synchronized (this.f47689c) {
            this.f47687a = null;
        }
    }

    public final void onComplete(final Task<TResult> task) {
        if (!task.isSuccessful() && !task.isCanceled()) {
            this.f47688b.execute(new Runnable() {
                public final void run() {
                    synchronized (f.this.f47689c) {
                        if (f.this.f47687a != null) {
                            f.this.f47687a.onFailure(task.getException());
                        }
                    }
                }
            });
        }
    }
}
