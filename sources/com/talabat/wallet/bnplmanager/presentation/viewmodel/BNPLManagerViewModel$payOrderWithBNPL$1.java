package com.talabat.wallet.bnplmanager.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.wallet.bnplmanager.data.remote.dto.request.BNPLOrderPaymentRequestDto;
import com.talabat.wallet.bnplmanager.domain.business.usecase.GetPayOrderWithBNPLUseCase;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLOrderPaymentStatus;
import com.talabat.wallet.bnplmanager.presentation.displaymodel.BNPLOrderPaymentState;
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
@DebugMetadata(c = "com.talabat.wallet.bnplmanager.presentation.viewmodel.BNPLManagerViewModel$payOrderWithBNPL$1", f = "BNPLManagerViewModel.kt", i = {}, l = {176}, m = "invokeSuspend", n = {}, s = {})
public final class BNPLManagerViewModel$payOrderWithBNPL$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f12504h;

    /* renamed from: i  reason: collision with root package name */
    public Object f12505i;

    /* renamed from: j  reason: collision with root package name */
    public int f12506j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ BNPLManagerViewModel f12507k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ BNPLOrderPaymentRequestDto f12508l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BNPLManagerViewModel$payOrderWithBNPL$1(BNPLManagerViewModel bNPLManagerViewModel, BNPLOrderPaymentRequestDto bNPLOrderPaymentRequestDto, Continuation<? super BNPLManagerViewModel$payOrderWithBNPL$1> continuation) {
        super(2, continuation);
        this.f12507k = bNPLManagerViewModel;
        this.f12508l = bNPLOrderPaymentRequestDto;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BNPLManagerViewModel$payOrderWithBNPL$1(this.f12507k, this.f12508l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((BNPLManagerViewModel$payOrderWithBNPL$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData<BNPLOrderPaymentState> mutableLiveData;
        BNPLManagerMapper bNPLManagerMapper;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12506j;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableLiveData = this.f12507k.getBNPLOrderPaymentData();
            BNPLManagerMapper bNPLManagerMapper2 = BNPLManagerMapper.INSTANCE;
            GetPayOrderWithBNPLUseCase access$getGetPayOrderWithBNPLUseCase$p = this.f12507k.getPayOrderWithBNPLUseCase;
            BNPLOrderPaymentRequestDto bNPLOrderPaymentRequestDto = this.f12508l;
            this.f12504h = mutableLiveData;
            this.f12505i = bNPLManagerMapper2;
            this.f12506j = 1;
            Object invoke = access$getGetPayOrderWithBNPLUseCase$p.invoke(bNPLOrderPaymentRequestDto, this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            bNPLManagerMapper = bNPLManagerMapper2;
            obj = invoke;
        } else if (i11 == 1) {
            bNPLManagerMapper = (BNPLManagerMapper) this.f12505i;
            mutableLiveData = (MutableLiveData) this.f12504h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableLiveData.postValue(bNPLManagerMapper.mapToBNPLOrderPlacementState((BNPLOrderPaymentStatus) obj));
        return Unit.INSTANCE;
    }
}
