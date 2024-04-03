package com.talabat.wallet.bnplmanager.presentation.viewmodel;

import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLInstallmentRequestModel;
import com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLInstallmentsUseCase;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLInstallments;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLPlan;
import com.talabat.wallet.bnplmanager.presentation.viewmodel.mapper.BNPLManagerMapper;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.wallet.bnplmanager.presentation.viewmodel.BNPLManagerViewModel$onFetchBNPLPaymentDetails$1", f = "BNPLManagerViewModel.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
public final class BNPLManagerViewModel$onFetchBNPLPaymentDetails$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12496h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ BNPLManagerViewModel f12497i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ BNPLPlan f12498j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f12499k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BNPLManagerViewModel$onFetchBNPLPaymentDetails$1(BNPLManagerViewModel bNPLManagerViewModel, BNPLPlan bNPLPlan, float f11, Continuation<? super BNPLManagerViewModel$onFetchBNPLPaymentDetails$1> continuation) {
        super(2, continuation);
        this.f12497i = bNPLManagerViewModel;
        this.f12498j = bNPLPlan;
        this.f12499k = f11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BNPLManagerViewModel$onFetchBNPLPaymentDetails$1(this.f12497i, this.f12498j, this.f12499k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((BNPLManagerViewModel$onFetchBNPLPaymentDetails$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12496h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            GetBNPLInstallmentsUseCase access$getGetBNPLInstallmentsUseCase$p = this.f12497i.getBNPLInstallmentsUseCase;
            BNPLInstallmentRequestModel bNPLInstallmentRequestModel = new BNPLInstallmentRequestModel(this.f12498j.getId(), this.f12499k);
            this.f12496h = 1;
            obj = access$getGetBNPLInstallmentsUseCase$p.invoke(bNPLInstallmentRequestModel, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f12497i.getBNPLPaymentDetailsStateData().postValue(BNPLManagerMapper.INSTANCE.mapToBNPLPaymentDetailsDisplayModel(this.f12497i.locationConfigurationRepository, this.f12499k, (BNPLInstallments) obj, this.f12498j, "dd LLLL yyyy"));
        return Unit.INSTANCE;
    }
}
