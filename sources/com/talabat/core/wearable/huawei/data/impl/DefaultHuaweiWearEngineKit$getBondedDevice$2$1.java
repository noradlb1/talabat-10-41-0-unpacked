package com.talabat.core.wearable.huawei.data.impl;

import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.wearengine.device.Device;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012b\u0010\u0002\u001a^\u0012(\u0012&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00070\u0004 \u0006*.\u0012(\u0012&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00070\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "task", "Lcom/huawei/hmf/tasks/Task;", "", "Lcom/huawei/wearengine/device/Device;", "kotlin.jvm.PlatformType", "", "onComplete"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DefaultHuaweiWearEngineKit$getBondedDevice$2$1<TResult> implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Continuation<Device> f56014a;

    public DefaultHuaweiWearEngineKit$getBondedDevice$2$1(Continuation<? super Device> continuation) {
        this.f56014a = continuation;
    }

    public final void onComplete(Task<List<Device>> task) {
        Object obj;
        Continuation<Device> continuation = this.f56014a;
        List<Device> result = task.getResult();
        Intrinsics.checkNotNullExpressionValue(result, "task.result");
        Iterator it = result.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Device) obj).isConnected()) {
                break;
            }
        }
        continuation.resumeWith(Result.m6329constructorimpl(obj));
    }
}
