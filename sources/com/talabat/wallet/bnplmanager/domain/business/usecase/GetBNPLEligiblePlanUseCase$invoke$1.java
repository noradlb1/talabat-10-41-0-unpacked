package com.talabat.wallet.bnplmanager.domain.business.usecase;

import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRequestDto;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLEligiblePlanUseCase", f = "GetBNPLEligiblePlanUseCase.kt", i = {0, 0, 1, 1, 2, 2}, l = {17, 21, 23}, m = "invoke", n = {"this", "bNPLEligibilityRequestDto", "this", "bNPLEligiblePlanDetail", "bNPLEligiblePlanDetail", "eligibility"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
public final class GetBNPLEligiblePlanUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12471h;

    /* renamed from: i  reason: collision with root package name */
    public Object f12472i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f12473j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ GetBNPLEligiblePlanUseCase f12474k;

    /* renamed from: l  reason: collision with root package name */
    public int f12475l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetBNPLEligiblePlanUseCase$invoke$1(GetBNPLEligiblePlanUseCase getBNPLEligiblePlanUseCase, Continuation<? super GetBNPLEligiblePlanUseCase$invoke$1> continuation) {
        super(continuation);
        this.f12474k = getBNPLEligiblePlanUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12473j = obj;
        this.f12475l |= Integer.MIN_VALUE;
        return this.f12474k.invoke((BNPLEligibilityRequestDto) null, this);
    }
}
