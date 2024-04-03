package com.huawei.hms.common.internal;

import com.huawei.hmf.tasks.TaskCompletionSource;

public class TaskApiCallWrapper<TResult> extends BaseContentWrapper {

    /* renamed from: a  reason: collision with root package name */
    private final TaskApiCall<? extends AnyClient, TResult> f48197a;

    /* renamed from: b  reason: collision with root package name */
    private final TaskCompletionSource<TResult> f48198b;

    public TaskApiCallWrapper(TaskApiCall<? extends AnyClient, TResult> taskApiCall, TaskCompletionSource<TResult> taskCompletionSource) {
        super(1);
        this.f48197a = taskApiCall;
        this.f48198b = taskCompletionSource;
    }

    public TaskApiCall<? extends AnyClient, TResult> getTaskApiCall() {
        return this.f48197a;
    }

    public TaskCompletionSource<TResult> getTaskCompletionSource() {
        return this.f48198b;
    }
}
