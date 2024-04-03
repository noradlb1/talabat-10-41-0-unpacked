package com.talabat.feature.ridertips.domain.usecases;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.ridertips.domain.usecases.GetRiderTipUseCase", f = "GetRiderTipUseCase.kt", i = {}, l = {13}, m = "getRiderTip", n = {}, s = {})
public final class GetRiderTipUseCase$getRiderTip$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f58796h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GetRiderTipUseCase f58797i;

    /* renamed from: j  reason: collision with root package name */
    public int f58798j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetRiderTipUseCase$getRiderTip$1(GetRiderTipUseCase getRiderTipUseCase, Continuation<? super GetRiderTipUseCase$getRiderTip$1> continuation) {
        super(continuation);
        this.f58797i = getRiderTipUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58796h = obj;
        this.f58798j |= Integer.MIN_VALUE;
        return this.f58797i.getRiderTip(this);
    }
}
