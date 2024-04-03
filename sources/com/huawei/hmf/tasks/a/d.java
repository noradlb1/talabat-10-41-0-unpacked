package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

public final class d<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public Executor f47676a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public OnCompleteListener<TResult> f47677b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Object f47678c = new Object();

    public d(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.f47677b = onCompleteListener;
        this.f47676a = executor;
    }

    public final void cancel() {
        synchronized (this.f47678c) {
            this.f47677b = null;
        }
    }

    public final void onComplete(final Task<TResult> task) {
        this.f47676a.execute(new Runnable() {
            public final void run() {
                synchronized (d.this.f47678c) {
                    if (d.this.f47677b != null) {
                        d.this.f47677b.onComplete(task);
                    }
                }
            }
        });
    }
}
