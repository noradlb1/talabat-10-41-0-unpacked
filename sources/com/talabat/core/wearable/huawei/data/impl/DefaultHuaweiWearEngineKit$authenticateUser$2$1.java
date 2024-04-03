package com.talabat.core.wearable.huawei.data.impl;

import com.huawei.hmf.tasks.OnSuccessListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "onSuccess"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DefaultHuaweiWearEngineKit$authenticateUser$2$1<TResult> implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultHuaweiWearEngineKit f56009a;

    public DefaultHuaweiWearEngineKit$authenticateUser$2$1(DefaultHuaweiWearEngineKit defaultHuaweiWearEngineKit) {
        this.f56009a = defaultHuaweiWearEngineKit;
    }

    public final void onSuccess(Void voidR) {
        this.f56009a.logInfo("requestPermission successfully");
    }
}
