package com.talabat.wallet.checkoutpaymentmanager.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import buisnessmodels.Cart;
import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.viewmodel.mapper.DebitCardBinsDetailDisplayModelMapper;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRequestDto;
import com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLEligiblePlanUseCase;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLEligiblePlanDetail;
import com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase.GetPaymentMethodUpdate;
import com.talabat.wallet.checkoutpaymentmanager.domain.entity.CheckoutPaymentUpdateResult;
import com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel.BNPLPlanEligibilityState;
import com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel.CheckoutPaymentUpdateDisplayModel;
import com.talabat.wallet.checkoutpaymentmanager.presentation.viewmodel.mapper.CheckoutPaymentUpdateMapper;
import datamodels.Restaurant;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.wallet.checkoutpaymentmanager.presentation.viewmodel.CheckoutPaymentUpdateViewModel$onPaymentMethodUpdated$1", f = "CheckoutPaymentUpdateViewModel.kt", i = {}, l = {63, 73}, m = "invokeSuspend", n = {}, s = {})
public final class CheckoutPaymentUpdateViewModel$onPaymentMethodUpdated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f12551h;

    /* renamed from: i  reason: collision with root package name */
    public Object f12552i;

    /* renamed from: j  reason: collision with root package name */
    public int f12553j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ CheckoutPaymentUpdateViewModel f12554k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ BNPLEligibilityRequestDto f12555l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Cart f12556m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ String f12557n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ List<TokenisationCreditCard> f12558o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckoutPaymentUpdateViewModel$onPaymentMethodUpdated$1(CheckoutPaymentUpdateViewModel checkoutPaymentUpdateViewModel, BNPLEligibilityRequestDto bNPLEligibilityRequestDto, Cart cart, String str, List<? extends TokenisationCreditCard> list, Continuation<? super CheckoutPaymentUpdateViewModel$onPaymentMethodUpdated$1> continuation) {
        super(2, continuation);
        this.f12554k = checkoutPaymentUpdateViewModel;
        this.f12555l = bNPLEligibilityRequestDto;
        this.f12556m = cart;
        this.f12557n = str;
        this.f12558o = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CheckoutPaymentUpdateViewModel$onPaymentMethodUpdated$1(this.f12554k, this.f12555l, this.f12556m, this.f12557n, this.f12558o, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CheckoutPaymentUpdateViewModel$onPaymentMethodUpdated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData<CheckoutPaymentUpdateDisplayModel> mutableLiveData;
        CheckoutPaymentUpdateMapper checkoutPaymentUpdateMapper;
        CheckoutPaymentUpdateViewModel checkoutPaymentUpdateViewModel;
        Float f11;
        Restaurant restaurant;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12553j;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            this.f12554k.getCheckoutPaymentUpdateDisplayModel().postValue(CheckoutPaymentUpdateDisplayModel.Loading.INSTANCE);
            checkoutPaymentUpdateViewModel = this.f12554k;
            GetBNPLEligiblePlanUseCase access$getGetBNPLEligiblePlanUseCase$p = checkoutPaymentUpdateViewModel.getBNPLEligiblePlanUseCase;
            BNPLEligibilityRequestDto bNPLEligibilityRequestDto = this.f12555l;
            this.f12551h = checkoutPaymentUpdateViewModel;
            this.f12553j = 1;
            obj = access$getGetBNPLEligiblePlanUseCase$p.invoke(bNPLEligibilityRequestDto, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            checkoutPaymentUpdateViewModel = (CheckoutPaymentUpdateViewModel) this.f12551h;
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            checkoutPaymentUpdateMapper = (CheckoutPaymentUpdateMapper) this.f12552i;
            mutableLiveData = (MutableLiveData) this.f12551h;
            ResultKt.throwOnFailure(obj);
            mutableLiveData.postValue(checkoutPaymentUpdateMapper.mapToPaymentMethodUpdateToDisplayModel((CheckoutPaymentUpdateResult) obj));
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        checkoutPaymentUpdateViewModel.setBNPLEligiblePlanDetail((BNPLEligiblePlanDetail) obj);
        MutableLiveData<BNPLPlanEligibilityState> bNPLPlanEligibilityDisplayModel = this.f12554k.getBNPLPlanEligibilityDisplayModel();
        CheckoutPaymentUpdateMapper checkoutPaymentUpdateMapper2 = CheckoutPaymentUpdateMapper.INSTANCE;
        LocationConfigurationRepository access$getLocationConfigurationRepository$p = this.f12554k.locationConfigurationRepository;
        BNPLEligiblePlanDetail bNPLEligiblePlanDetail = this.f12554k.getBNPLEligiblePlanDetail();
        Cart cart = this.f12556m;
        Boolean bool = null;
        if (cart != null) {
            f11 = Boxing.boxFloat(cart.getCartTotalPaymentPrice());
        } else {
            f11 = null;
        }
        bNPLPlanEligibilityDisplayModel.postValue(checkoutPaymentUpdateMapper2.mapToBNPLPlanEligibilityDisplayModel(access$getLocationConfigurationRepository$p, bNPLEligiblePlanDetail, f11));
        MutableLiveData<CheckoutPaymentUpdateDisplayModel> checkoutPaymentUpdateDisplayModel = this.f12554k.getCheckoutPaymentUpdateDisplayModel();
        GetPaymentMethodUpdate access$getGetPaymentMethodUpdate$p = this.f12554k.getPaymentMethodUpdate;
        Cart cart2 = this.f12556m;
        if (!(cart2 == null || (restaurant = cart2.getRestaurant()) == null)) {
            bool = Boxing.boxBoolean(restaurant.acceptsDebit);
        }
        boolean orFalse = BooleanKt.orFalse(bool);
        Cart cart3 = this.f12556m;
        String str = this.f12557n;
        String formatBinsToRequiredInput = DebitCardBinsDetailDisplayModelMapper.INSTANCE.formatBinsToRequiredInput(this.f12558o);
        boolean isHideBNPLPaymentMethod = this.f12554k.getBNPLEligiblePlanDetail().getBNPLEligibilityDetail().isHideBNPLPaymentMethod();
        this.f12551h = checkoutPaymentUpdateDisplayModel;
        this.f12552i = checkoutPaymentUpdateMapper2;
        this.f12553j = 2;
        Object invoke = access$getGetPaymentMethodUpdate$p.invoke(orFalse, cart3, str, formatBinsToRequiredInput, isHideBNPLPaymentMethod, this);
        if (invoke == coroutine_suspended) {
            return coroutine_suspended;
        }
        checkoutPaymentUpdateMapper = checkoutPaymentUpdateMapper2;
        mutableLiveData = checkoutPaymentUpdateDisplayModel;
        obj = invoke;
        mutableLiveData.postValue(checkoutPaymentUpdateMapper.mapToPaymentMethodUpdateToDisplayModel((CheckoutPaymentUpdateResult) obj));
        return Unit.INSTANCE;
    }
}
