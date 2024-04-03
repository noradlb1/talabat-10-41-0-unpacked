package com.talabat.core.wearable.huawei.data.impl;

import com.huawei.wearengine.device.Device;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.core.wearable.huawei.data.impl.DefaultHuaweiWearEngineKit", f = "DefaultHuaweiWearEngineKit.kt", i = {}, l = {71, 70}, m = "ping", n = {}, s = {})
public final class DefaultHuaweiWearEngineKit$ping$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f56018h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f56019i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DefaultHuaweiWearEngineKit f56020j;

    /* renamed from: k  reason: collision with root package name */
    public int f56021k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultHuaweiWearEngineKit$ping$1(DefaultHuaweiWearEngineKit defaultHuaweiWearEngineKit, Continuation<? super DefaultHuaweiWearEngineKit$ping$1> continuation) {
        super(continuation);
        this.f56020j = defaultHuaweiWearEngineKit;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f56019i = obj;
        this.f56021k |= Integer.MIN_VALUE;
        return this.f56020j.ping((Device) null, this);
    }
}
