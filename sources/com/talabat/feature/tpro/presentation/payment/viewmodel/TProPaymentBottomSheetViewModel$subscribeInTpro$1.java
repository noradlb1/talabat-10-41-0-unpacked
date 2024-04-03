package com.talabat.feature.tpro.presentation.payment.viewmodel;

import com.talabat.feature.subscriptions.domain.model.SubscriptionPaymentStatus;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionPaymentUseCase;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
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
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.payment.viewmodel.TProPaymentBottomSheetViewModel$subscribeInTpro$1", f = "TProPaymentBottomSheetViewModel.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
public final class TProPaymentBottomSheetViewModel$subscribeInTpro$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59374h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TProPaymentBottomSheetViewModel f59375i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f59376j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ WalletCardDisplayModel f59377k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TProPaymentBottomSheetViewModel$subscribeInTpro$1(TProPaymentBottomSheetViewModel tProPaymentBottomSheetViewModel, String str, WalletCardDisplayModel walletCardDisplayModel, Continuation<? super TProPaymentBottomSheetViewModel$subscribeInTpro$1> continuation) {
        super(2, continuation);
        this.f59375i = tProPaymentBottomSheetViewModel;
        this.f59376j = str;
        this.f59377k = walletCardDisplayModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TProPaymentBottomSheetViewModel$subscribeInTpro$1(this.f59375i, this.f59376j, this.f59377k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TProPaymentBottomSheetViewModel$subscribeInTpro$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        String str2;
        String str3;
        Integer num;
        String str4;
        String str5;
        PaymentMethod paymentMethod;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59374h;
        boolean z11 = true;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            GetSubscriptionPaymentUseCase access$getGetSubscriptionPaymentUseCase$p = this.f59375i.getSubscriptionPaymentUseCase;
            String str6 = this.f59376j;
            WalletCardDisplayModel walletCardDisplayModel = this.f59377k;
            if (walletCardDisplayModel != null) {
                str = walletCardDisplayModel.getTokenId();
            } else {
                str = null;
            }
            WalletCardDisplayModel walletCardDisplayModel2 = this.f59377k;
            if (walletCardDisplayModel2 != null) {
                str2 = walletCardDisplayModel2.getCard4Digits();
            } else {
                str2 = null;
            }
            WalletCardDisplayModel walletCardDisplayModel3 = this.f59377k;
            if (walletCardDisplayModel3 != null) {
                str3 = walletCardDisplayModel3.getCardType();
            } else {
                str3 = null;
            }
            WalletCardDisplayModel walletCardDisplayModel4 = this.f59377k;
            if (walletCardDisplayModel4 == null || (paymentMethod = walletCardDisplayModel4.getPaymentMethod()) == null) {
                num = null;
            } else {
                num = Boxing.boxInt(paymentMethod.getValue());
            }
            WalletCardDisplayModel walletCardDisplayModel5 = this.f59377k;
            if (walletCardDisplayModel5 != null) {
                str4 = walletCardDisplayModel5.getExpiryMonth();
            } else {
                str4 = null;
            }
            WalletCardDisplayModel walletCardDisplayModel6 = this.f59377k;
            if (walletCardDisplayModel6 != null) {
                str5 = walletCardDisplayModel6.getExpiryYear();
            } else {
                str5 = null;
            }
            GetSubscriptionPaymentUseCase.Params params = new GetSubscriptionPaymentUseCase.Params(str6, str, str2, str3, num, str4, str5);
            this.f59374h = 1;
            obj = access$getGetSubscriptionPaymentUseCase$p.invoke(params, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        SubscriptionPaymentStatus subscriptionPaymentStatus = (SubscriptionPaymentStatus) obj;
        String redirectURL = subscriptionPaymentStatus.getResult().getRedirectURL();
        if (redirectURL != null && !StringsKt__StringsJVMKt.isBlank(redirectURL)) {
            z11 = false;
        }
        if (!z11) {
            this.f59375i.getVerification3ds$com_talabat_feature_tpro_presentation_presentation().postValue(subscriptionPaymentStatus.getResult().getRedirectURL());
        } else if (subscriptionPaymentStatus.getResult().isSubscribed()) {
            this.f59375i.updateCustomerInfo();
        } else {
            this.f59375i.getFailedSubscription$com_talabat_feature_tpro_presentation_presentation().postValue(Unit.INSTANCE);
        }
        return Unit.INSTANCE;
    }
}
