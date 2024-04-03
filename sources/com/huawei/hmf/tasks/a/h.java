package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

public final class h<TResult> implements ExecuteResult<TResult> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public OnSuccessListener<TResult> f47694a;

    /* renamed from: b  reason: collision with root package name */
    private Executor f47695b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Object f47696c = new Object();

    public h(Executor executor, OnSuccessListener<TResult> onSuccessListener) {
        this.f47694a = onSuccessListener;
        this.f47695b = executor;
    }

    public final void cancel() {
        synchronized (this.f47696c) {
            this.f47694a = null;
        }
    }

    public final void onComplete(final Task<TResult> task) {
        if (task.isSuccessful() && !task.isCanceled()) {
            this.f47695b.execute(new Runnable() {
                public final void run() {
                    synchronized (h.this.f47696c) {
                        if (h.this.f47694a != null) {
                            h.this.f47694a.onSuccess(task.getResult());
                        }
                    }
                }
            });
        }
    }
}
