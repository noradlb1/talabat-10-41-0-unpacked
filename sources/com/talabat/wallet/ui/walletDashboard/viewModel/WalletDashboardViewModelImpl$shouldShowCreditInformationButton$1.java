package com.talabat.wallet.ui.walletDashboard.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.wallet.features.walletonboarding.GetWalletDashboardOnboardingEnabledUseCase;
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
@DebugMetadata(c = "com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl$shouldShowCreditInformationButton$1", f = "WalletDashboardViewModelImpl.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
public final class WalletDashboardViewModelImpl$shouldShowCreditInformationButton$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f12790h;

    /* renamed from: i  reason: collision with root package name */
    public int f12791i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ WalletDashboardViewModelImpl f12792j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDashboardViewModelImpl$shouldShowCreditInformationButton$1(WalletDashboardViewModelImpl walletDashboardViewModelImpl, Continuation<? super WalletDashboardViewModelImpl$shouldShowCreditInformationButton$1> continuation) {
        super(2, continuation);
        this.f12792j = walletDashboardViewModelImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WalletDashboardViewModelImpl$shouldShowCreditInformationButton$1(this.f12792j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WalletDashboardViewModelImpl$shouldShowCreditInformationButton$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData<Boolean> mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12791i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData<Boolean> shouldShowOnBoardingInfoData = this.f12792j.getShouldShowOnBoardingInfoData();
            GetWalletDashboardOnboardingEnabledUseCase access$getGetWalletDashboardOnboardingEnabledUseCase$p = this.f12792j.getWalletDashboardOnboardingEnabledUseCase;
            this.f12790h = shouldShowOnBoardingInfoData;
            this.f12791i = 1;
            Object invoke = access$getGetWalletDashboardOnboardingEnabledUseCase$p.invoke(this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = shouldShowOnBoardingInfoData;
            obj = invoke;
        } else if (i11 == 1) {
            mutableLiveData = (MutableLiveData) this.f12790h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableLiveData.setValue(obj);
        return Unit.INSTANCE;
    }
}
