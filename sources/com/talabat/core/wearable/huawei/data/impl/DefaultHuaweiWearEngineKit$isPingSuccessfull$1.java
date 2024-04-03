package com.talabat.core.wearable.huawei.data.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.core.wearable.huawei.data.impl.DefaultHuaweiWearEngineKit", f = "DefaultHuaweiWearEngineKit.kt", i = {}, l = {130, 135}, m = "isPingSuccessfull", n = {}, s = {})
public final class DefaultHuaweiWearEngineKit$isPingSuccessfull$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f56015h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DefaultHuaweiWearEngineKit f56016i;

    /* renamed from: j  reason: collision with root package name */
    public int f56017j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultHuaweiWearEngineKit$isPingSuccessfull$1(DefaultHuaweiWearEngineKit defaultHuaweiWearEngineKit, Continuation<? super DefaultHuaweiWearEngineKit$isPingSuccessfull$1> continuation) {
        super(continuation);
        this.f56016i = defaultHuaweiWearEngineKit;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f56015h = obj;
        this.f56017j |= Integer.MIN_VALUE;
        return this.f56016i.isPingSuccessfull(0, this);
    }
}
