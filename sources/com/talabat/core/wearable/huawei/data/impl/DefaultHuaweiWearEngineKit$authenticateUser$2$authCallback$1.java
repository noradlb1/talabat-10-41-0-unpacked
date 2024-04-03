package com.talabat.core.wearable.huawei.data.impl;

import com.huawei.wearengine.auth.AuthCallback;
import com.huawei.wearengine.auth.Permission;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001b\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"com/talabat/core/wearable/huawei/data/impl/DefaultHuaweiWearEngineKit$authenticateUser$2$authCallback$1", "Lcom/huawei/wearengine/auth/AuthCallback;", "onCancel", "", "onOk", "permissions", "", "Lcom/huawei/wearengine/auth/Permission;", "([Lcom/huawei/wearengine/auth/Permission;)V", "com_talabat_core_wearable_huawei_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultHuaweiWearEngineKit$authenticateUser$2$authCallback$1 implements AuthCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultHuaweiWearEngineKit f56011a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Continuation<Boolean> f56012b;

    public DefaultHuaweiWearEngineKit$authenticateUser$2$authCallback$1(DefaultHuaweiWearEngineKit defaultHuaweiWearEngineKit, Continuation<? super Boolean> continuation) {
        this.f56011a = defaultHuaweiWearEngineKit;
        this.f56012b = continuation;
    }

    public void onCancel() {
        this.f56011a.logInfo("Auth cancel");
        Continuation<Boolean> continuation = this.f56012b;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m6329constructorimpl(Boolean.FALSE));
    }

    public void onOk(@NotNull Permission[] permissionArr) {
        boolean z11;
        Intrinsics.checkNotNullParameter(permissionArr, "permissions");
        if (permissionArr.length == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            Permission permission = permissionArr[0];
            this.f56011a.logInfo("permission successfully granted :" + permission);
            Continuation<Boolean> continuation = this.f56012b;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m6329constructorimpl(Boolean.TRUE));
            return;
        }
        this.f56011a.logInfo("Auth failed");
        Continuation<Boolean> continuation2 = this.f56012b;
        Result.Companion companion2 = Result.Companion;
        continuation2.resumeWith(Result.m6329constructorimpl(Boolean.FALSE));
    }
}
