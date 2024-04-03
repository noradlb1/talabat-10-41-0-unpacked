package com.talabat.core.wearable.huawei.data.impl;

import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "task", "Lcom/huawei/hmf/tasks/Task;", "", "kotlin.jvm.PlatformType", "onComplete"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DefaultHuaweiWearEngineKit$await$2$1<TResult> implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Continuation<Boolean> f56013a;

    public DefaultHuaweiWearEngineKit$await$2$1(Continuation<? super Boolean> continuation) {
        this.f56013a = continuation;
    }

    public final void onComplete(Task<Boolean> task) {
        if (task.isSuccessful()) {
            Continuation<Boolean> continuation = this.f56013a;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m6329constructorimpl(task.getResult()));
            return;
        }
        Continuation<Boolean> continuation2 = this.f56013a;
        Result.Companion companion2 = Result.Companion;
        continuation2.resumeWith(Result.m6329constructorimpl(Boolean.FALSE));
    }
}
