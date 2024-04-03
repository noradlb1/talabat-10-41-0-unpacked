package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import java.util.concurrent.ExecutionException;

final class e<TResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f47681a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final int f47682b;

    /* renamed from: c  reason: collision with root package name */
    private final i<Void> f47683c;

    /* renamed from: d  reason: collision with root package name */
    private int f47684d;

    /* renamed from: e  reason: collision with root package name */
    private Exception f47685e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f47686f;

    public e(int i11, i<Void> iVar) {
        this.f47682b = i11;
        this.f47683c = iVar;
    }

    private void a() {
        if (this.f47684d < this.f47682b) {
            return;
        }
        if (this.f47685e != null) {
            this.f47683c.a((Exception) new ExecutionException("a task failed", this.f47685e));
        } else if (this.f47686f) {
            this.f47683c.a();
        } else {
            this.f47683c.a(null);
        }
    }

    public final void onCanceled() {
        synchronized (this.f47681a) {
            this.f47684d++;
            this.f47686f = true;
            a();
        }
    }

    public final void onFailure(Exception exc) {
        synchronized (this.f47681a) {
            this.f47684d++;
            this.f47685e = exc;
            a();
        }
    }

    public final void onSuccess(TResult tresult) {
        synchronized (this.f47681a) {
            this.f47684d++;
            a();
        }
    }
}
