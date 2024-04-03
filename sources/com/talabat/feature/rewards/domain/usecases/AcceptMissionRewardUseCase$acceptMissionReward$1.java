package com.talabat.feature.rewards.domain.usecases;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.rewards.domain.usecases.AcceptMissionRewardUseCase", f = "AcceptMissionRewardUseCase.kt", i = {}, l = {9}, m = "acceptMissionReward-0E7RQCE", n = {}, s = {})
public final class AcceptMissionRewardUseCase$acceptMissionReward$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f58754h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ AcceptMissionRewardUseCase f58755i;

    /* renamed from: j  reason: collision with root package name */
    public int f58756j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AcceptMissionRewardUseCase$acceptMissionReward$1(AcceptMissionRewardUseCase acceptMissionRewardUseCase, Continuation<? super AcceptMissionRewardUseCase$acceptMissionReward$1> continuation) {
        super(continuation);
        this.f58755i = acceptMissionRewardUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58754h = obj;
        this.f58756j |= Integer.MIN_VALUE;
        Object r32 = this.f58755i.m10280acceptMissionReward0E7RQCE(0, (String) null, this);
        return r32 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r32 : Result.m6328boximpl(r32);
    }
}
