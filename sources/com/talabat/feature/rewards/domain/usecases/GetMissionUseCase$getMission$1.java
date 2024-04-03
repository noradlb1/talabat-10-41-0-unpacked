package com.talabat.feature.rewards.domain.usecases;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.rewards.domain.usecases.GetMissionUseCase", f = "GetMissionUseCase.kt", i = {}, l = {10}, m = "getMission-0E7RQCE", n = {}, s = {})
public final class GetMissionUseCase$getMission$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f58760h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GetMissionUseCase f58761i;

    /* renamed from: j  reason: collision with root package name */
    public int f58762j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetMissionUseCase$getMission$1(GetMissionUseCase getMissionUseCase, Continuation<? super GetMissionUseCase$getMission$1> continuation) {
        super(continuation);
        this.f58761i = getMissionUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58760h = obj;
        this.f58762j |= Integer.MIN_VALUE;
        Object r22 = this.f58761i.m10282getMission0E7RQCE((Integer) null, (String) null, this);
        return r22 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r22 : Result.m6328boximpl(r22);
    }
}
