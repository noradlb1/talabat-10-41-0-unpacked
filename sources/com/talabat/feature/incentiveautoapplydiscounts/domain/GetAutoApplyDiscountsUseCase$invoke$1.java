package com.talabat.feature.incentiveautoapplydiscounts.domain;

import com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscount;
import com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscountsRequest;
import com.talabat.feature.incentiveautoapplydiscounts.domain.repository.IncentiveAutoApplyDiscountsRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcom/talabat/feature/incentiveautoapplydiscounts/domain/entity/AutoApplyDiscount;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.incentiveautoapplydiscounts.domain.GetAutoApplyDiscountsUseCase$invoke$1", f = "GetAutoApplyDiscountsUseCase.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
public final class GetAutoApplyDiscountsUseCase$invoke$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AutoApplyDiscount[]>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f58566h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GetAutoApplyDiscountsUseCase f58567i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ AutoApplyDiscountsRequest f58568j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetAutoApplyDiscountsUseCase$invoke$1(GetAutoApplyDiscountsUseCase getAutoApplyDiscountsUseCase, AutoApplyDiscountsRequest autoApplyDiscountsRequest, Continuation<? super GetAutoApplyDiscountsUseCase$invoke$1> continuation) {
        super(2, continuation);
        this.f58567i = getAutoApplyDiscountsUseCase;
        this.f58568j = autoApplyDiscountsRequest;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GetAutoApplyDiscountsUseCase$invoke$1(this.f58567i, this.f58568j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super AutoApplyDiscount[]> continuation) {
        return ((GetAutoApplyDiscountsUseCase$invoke$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f58566h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            IncentiveAutoApplyDiscountsRepository access$getIncentiveBookingRepository$p = this.f58567i.incentiveBookingRepository;
            AutoApplyDiscountsRequest autoApplyDiscountsRequest = this.f58568j;
            this.f58566h = 1;
            obj = access$getIncentiveBookingRepository$p.getAutoApplyDiscounts(autoApplyDiscountsRequest, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
