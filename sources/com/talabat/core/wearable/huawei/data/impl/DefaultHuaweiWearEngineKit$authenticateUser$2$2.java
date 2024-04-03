package com.talabat.core.wearable.huawei.data.impl;

import com.huawei.hmf.tasks.OnFailureListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/Exception;", "kotlin.jvm.PlatformType", "onFailure"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DefaultHuaweiWearEngineKit$authenticateUser$2$2 implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultHuaweiWearEngineKit f56010a;

    public DefaultHuaweiWearEngineKit$authenticateUser$2$2(DefaultHuaweiWearEngineKit defaultHuaweiWearEngineKit) {
        this.f56010a = defaultHuaweiWearEngineKit;
    }

    public final void onFailure(Exception exc) {
        this.f56010a.logInfo("requestPermission failed");
    }
}
