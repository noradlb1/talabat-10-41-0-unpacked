package com.talabat.feature.rewards.data;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.rewards.data.RealRewardsMissionRepository", f = "RealRewardsMissionRepository.kt", i = {}, l = {24}, m = "acceptMissionReward-0E7RQCE", n = {}, s = {})
public final class RealRewardsMissionRepository$acceptMissionReward$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f58740h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RealRewardsMissionRepository f58741i;

    /* renamed from: j  reason: collision with root package name */
    public int f58742j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealRewardsMissionRepository$acceptMissionReward$1(RealRewardsMissionRepository realRewardsMissionRepository, Continuation<? super RealRewardsMissionRepository$acceptMissionReward$1> continuation) {
        super(continuation);
        this.f58741i = realRewardsMissionRepository;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58740h = obj;
        this.f58742j |= Integer.MIN_VALUE;
        Object r32 = this.f58741i.m10274acceptMissionReward0E7RQCE(0, (String) null, this);
        return r32 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r32 : Result.m6328boximpl(r32);
    }
}
