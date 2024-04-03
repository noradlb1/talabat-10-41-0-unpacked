package com.talabat.wallet.bnplmanager.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.wallet.bnplmanager.domain.business.usecase.IsUserEligibleForBNPLPaymentFallbackUseCase;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLPaymentFallbackEligibleStatus;
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
@DebugMetadata(c = "com.talabat.wallet.bnplmanager.presentation.viewmodel.BNPLManagerViewModel$onPlaceOrderFailedWithPaymentMethodError$1", f = "BNPLManagerViewModel.kt", i = {}, l = {198}, m = "invokeSuspend", n = {}, s = {})
public final class BNPLManagerViewModel$onPlaceOrderFailedWithPaymentMethodError$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f12500h;

    /* renamed from: i  reason: collision with root package name */
    public int f12501i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ BNPLManagerViewModel f12502j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f12503k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BNPLManagerViewModel$onPlaceOrderFailedWithPaymentMethodError$1(BNPLManagerViewModel bNPLManagerViewModel, int i11, Continuation<? super BNPLManagerViewModel$onPlaceOrderFailedWithPaymentMethodError$1> continuation) {
        super(2, continuation);
        this.f12502j = bNPLManagerViewModel;
        this.f12503k = i11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BNPLManagerViewModel$onPlaceOrderFailedWithPaymentMethodError$1(this.f12502j, this.f12503k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((BNPLManagerViewModel$onPlaceOrderFailedWithPaymentMethodError$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData<BNPLPaymentFallbackEligibleStatus> mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12501i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            IsUserEligibleForBNPLPaymentFallbackUseCase access$isUserEligibleForBNPLPaymentFallbackUseCase$p = this.f12502j.isUserEligibleForBNPLPaymentFallbackUseCase;
            if (access$isUserEligibleForBNPLPaymentFallbackUseCase$p != null) {
                BNPLManagerViewModel bNPLManagerViewModel = this.f12502j;
                int i12 = this.f12503k;
                MutableLiveData<BNPLPaymentFallbackEligibleStatus> bNPLPaymentFallbackEligibleStateData = bNPLManagerViewModel.getBNPLPaymentFallbackEligibleStateData();
                this.f12500h = bNPLPaymentFallbackEligibleStateData;
                this.f12501i = 1;
                obj = access$isUserEligibleForBNPLPaymentFallbackUseCase$p.invoke(i12, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = bNPLPaymentFallbackEligibleStateData;
            }
            return Unit.INSTANCE;
        } else if (i11 == 1) {
            mutableLiveData = (MutableLiveData) this.f12500h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableLiveData.postValue(obj);
        return Unit.INSTANCE;
    }
}
