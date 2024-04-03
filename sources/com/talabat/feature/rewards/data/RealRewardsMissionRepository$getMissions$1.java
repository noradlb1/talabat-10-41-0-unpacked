package com.talabat.feature.rewards.data;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.rewards.data.RealRewardsMissionRepository", f = "RealRewardsMissionRepository.kt", i = {}, l = {17}, m = "getMissions-0E7RQCE", n = {}, s = {})
public final class RealRewardsMissionRepository$getMissions$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f58746h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RealRewardsMissionRepository f58747i;

    /* renamed from: j  reason: collision with root package name */
    public int f58748j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealRewardsMissionRepository$getMissions$1(RealRewardsMissionRepository realRewardsMissionRepository, Continuation<? super RealRewardsMissionRepository$getMissions$1> continuation) {
        super(continuation);
        this.f58747i = realRewardsMissionRepository;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58746h = obj;
        this.f58748j |= Integer.MIN_VALUE;
        Object r22 = this.f58747i.m10276getMissions0E7RQCE((Integer) null, (String) null, this);
        return r22 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r22 : Result.m6328boximpl(r22);
    }
}
