package com.talabat.wallet.ui.walletDashboard.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import com.talabat.wallet.features.walletTransactionList.GetWalletDashboardFlagEnabledUseCase;
import com.talabat.wallet.ui.walletDashboard.model.OnboardingType;
import com.talabat.wallet.ui.walletDashboard.model.WalletOnboardingDisplayModel;
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
@DebugMetadata(c = "com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl$onShowCreditInformationButtonClicked$1", f = "WalletDashboardViewModelImpl.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {})
public final class WalletDashboardViewModelImpl$onShowCreditInformationButtonClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12784h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ WalletDashboardViewModelImpl f12785i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDashboardViewModelImpl$onShowCreditInformationButtonClicked$1(WalletDashboardViewModelImpl walletDashboardViewModelImpl, Continuation<? super WalletDashboardViewModelImpl$onShowCreditInformationButtonClicked$1> continuation) {
        super(2, continuation);
        this.f12785i = walletDashboardViewModelImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WalletDashboardViewModelImpl$onShowCreditInformationButtonClicked$1(this.f12785i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WalletDashboardViewModelImpl$onShowCreditInformationButtonClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12784h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            GetWalletDashboardFlagEnabledUseCase access$getGetWalletDashboardFlagEnabledUseCase$p = this.f12785i.getWalletDashboardFlagEnabledUseCase;
            this.f12784h = 1;
            obj = access$getGetWalletDashboardFlagEnabledUseCase$p.invoke(PayFeatureFlagConstants.TOP_UP, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            MutableLiveData<WalletOnboardingDisplayModel> shouldShowOnBoardingData = this.f12785i.getShouldShowOnBoardingData();
            WalletOnboardingDisplayModel walletOnboardingDisplayModel = new WalletOnboardingDisplayModel();
            walletOnboardingDisplayModel.setOnboardingType(OnboardingType.WithTopUp.INSTANCE);
            shouldShowOnBoardingData.setValue(walletOnboardingDisplayModel);
        } else {
            MutableLiveData<WalletOnboardingDisplayModel> shouldShowOnBoardingData2 = this.f12785i.getShouldShowOnBoardingData();
            WalletOnboardingDisplayModel walletOnboardingDisplayModel2 = new WalletOnboardingDisplayModel();
            walletOnboardingDisplayModel2.setOnboardingType(OnboardingType.WithoutTopUp.INSTANCE);
            shouldShowOnBoardingData2.setValue(walletOnboardingDisplayModel2);
        }
        return Unit.INSTANCE;
    }
}
