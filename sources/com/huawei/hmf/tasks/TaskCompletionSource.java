package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.i;

public class TaskCompletionSource<TResult> {
    /* access modifiers changed from: private */
    public final i<TResult> task = new i<>();

    public TaskCompletionSource() {
    }

    public TaskCompletionSource(CancellationToken cancellationToken) {
        cancellationToken.register(new Runnable() {
            public void run() {
                TaskCompletionSource.this.task.a();
            }
        });
    }

    public Task<TResult> getTask() {
        return this.task;
    }

    public void setException(Exception exc) {
        this.task.a(exc);
    }

    public void setResult(TResult tresult) {
        this.task.a(tresult);
    }
}
