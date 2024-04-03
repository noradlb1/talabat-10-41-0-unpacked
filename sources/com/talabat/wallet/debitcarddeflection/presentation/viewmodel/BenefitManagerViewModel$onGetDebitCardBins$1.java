package com.talabat.wallet.debitcarddeflection.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.displaymodel.DebitCardBinsDetailDisplayModel;
import com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.viewmodel.mapper.DebitCardBinsDetailDisplayModelMapper;
import com.talabat.wallet.debitcarddeflection.domain.business.GetBinsDetailDisplayModelUseCase;
import java.util.List;
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
@DebugMetadata(c = "com.talabat.wallet.debitcarddeflection.presentation.viewmodel.BenefitManagerViewModel$onGetDebitCardBins$1", f = "DebitCardDeflectionViewModel.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
public final class BenefitManagerViewModel$onGetDebitCardBins$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f12574h;

    /* renamed from: i  reason: collision with root package name */
    public int f12575i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ BenefitManagerViewModel f12576j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ List<TokenisationCreditCard> f12577k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BenefitManagerViewModel$onGetDebitCardBins$1(BenefitManagerViewModel benefitManagerViewModel, List<? extends TokenisationCreditCard> list, Continuation<? super BenefitManagerViewModel$onGetDebitCardBins$1> continuation) {
        super(2, continuation);
        this.f12576j = benefitManagerViewModel;
        this.f12577k = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BenefitManagerViewModel$onGetDebitCardBins$1(this.f12576j, this.f12577k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((BenefitManagerViewModel$onGetDebitCardBins$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData<DebitCardBinsDetailDisplayModel> mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12575i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData<DebitCardBinsDetailDisplayModel> debitCardBinsData = this.f12576j.getDebitCardBinsData();
            GetBinsDetailDisplayModelUseCase access$getGetBinsDetailDisplayModelUseCase$p = this.f12576j.getBinsDetailDisplayModelUseCase;
            String formatBinsToRequiredInput = DebitCardBinsDetailDisplayModelMapper.INSTANCE.formatBinsToRequiredInput(this.f12577k);
            this.f12574h = debitCardBinsData;
            this.f12575i = 1;
            Object invoke = access$getGetBinsDetailDisplayModelUseCase$p.invoke(formatBinsToRequiredInput, this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = debitCardBinsData;
            obj = invoke;
        } else if (i11 == 1) {
            mutableLiveData = (MutableLiveData) this.f12574h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableLiveData.postValue(obj);
        return Unit.INSTANCE;
    }
}
