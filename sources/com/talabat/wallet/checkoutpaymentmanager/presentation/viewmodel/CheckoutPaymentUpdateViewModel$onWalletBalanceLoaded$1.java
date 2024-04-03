package com.talabat.wallet.checkoutpaymentmanager.presentation.viewmodel;

import com.talabat.wallet.checkoutpaymentmanager.domain.application.usecase.GetWalletBalanceApiEnabledUseCase;
import com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel.WalletBalanceDisplayModel;
import com.talabat.wallet.walletbalance.domain.business.usecase.WalletBalanceUseCase;
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
@DebugMetadata(c = "com.talabat.wallet.checkoutpaymentmanager.presentation.viewmodel.CheckoutPaymentUpdateViewModel$onWalletBalanceLoaded$1", f = "CheckoutPaymentUpdateViewModel.kt", i = {}, l = {89, 93}, m = "invokeSuspend", n = {}, s = {})
public final class CheckoutPaymentUpdateViewModel$onWalletBalanceLoaded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12559h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CheckoutPaymentUpdateViewModel f12560i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckoutPaymentUpdateViewModel$onWalletBalanceLoaded$1(CheckoutPaymentUpdateViewModel checkoutPaymentUpdateViewModel, Continuation<? super CheckoutPaymentUpdateViewModel$onWalletBalanceLoaded$1> continuation) {
        super(2, continuation);
        this.f12560i = checkoutPaymentUpdateViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CheckoutPaymentUpdateViewModel$onWalletBalanceLoaded$1(this.f12560i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CheckoutPaymentUpdateViewModel$onWalletBalanceLoaded$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12559h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            this.f12560i.getWalletBalanceDisplayModel().postValue(WalletBalanceDisplayModel.LoadingWalletBalance.INSTANCE);
            GetWalletBalanceApiEnabledUseCase access$getGetWalletBalanceApiEnabledUseCase$p = this.f12560i.getWalletBalanceApiEnabledUseCase;
            this.f12559h = 1;
            obj = access$getGetWalletBalanceApiEnabledUseCase$p.invoke(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            ResultKt.throwOnFailure(obj);
            this.f12560i.getWalletBalanceDisplayModel().postValue(WalletBalanceDisplayModel.ShowPaymentMethods.INSTANCE);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!((Boolean) obj).booleanValue()) {
            this.f12560i.getWalletBalanceDisplayModel().postValue(WalletBalanceDisplayModel.ShowPaymentMethods.INSTANCE);
            return Unit.INSTANCE;
        }
        WalletBalanceUseCase access$getGetWalletBalanceUseCase$p = this.f12560i.getWalletBalanceUseCase;
        this.f12559h = 2;
        if (access$getGetWalletBalanceUseCase$p.invoke(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.f12560i.getWalletBalanceDisplayModel().postValue(WalletBalanceDisplayModel.ShowPaymentMethods.INSTANCE);
        return Unit.INSTANCE;
    }
}
