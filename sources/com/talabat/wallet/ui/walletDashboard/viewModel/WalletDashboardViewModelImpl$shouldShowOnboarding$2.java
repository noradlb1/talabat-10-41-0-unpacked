package com.talabat.wallet.ui.walletDashboard.viewModel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl$shouldShowOnboarding$2", f = "WalletDashboardViewModelImpl.kt", i = {}, l = {154, 154, 159}, m = "invokeSuspend", n = {}, s = {})
public final class WalletDashboardViewModelImpl$shouldShowOnboarding$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12793h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ WalletDashboardViewModelImpl f12794i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDashboardViewModelImpl$shouldShowOnboarding$2(WalletDashboardViewModelImpl walletDashboardViewModelImpl, Continuation<? super WalletDashboardViewModelImpl$shouldShowOnboarding$2> continuation) {
        super(2, continuation);
        this.f12794i = walletDashboardViewModelImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WalletDashboardViewModelImpl$shouldShowOnboarding$2(this.f12794i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WalletDashboardViewModelImpl$shouldShowOnboarding$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0084  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.f12793h
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0025
            if (r1 == r4) goto L_0x0021
            if (r1 == r3) goto L_0x001d
            if (r1 != r2) goto L_0x0015
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0068
        L_0x0015:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001d:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004e
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0037
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r6)
            com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl r6 = r5.f12794i
            com.talabat.wallet.features.walletonboarding.GetWalletDashboardOnboardingEnabledUseCase r6 = r6.getWalletDashboardOnboardingEnabledUseCase
            r5.f12793h = r4
            java.lang.Object r6 = r6.invoke(r5)
            if (r6 != r0) goto L_0x0037
            return r0
        L_0x0037:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0098
            com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl r6 = r5.f12794i
            com.talabat.wallet.features.walletonboarding.repository.GetWasWalletOnboardingShownUseCase r6 = r6.getWasWalletOnboardingShownUseCase
            r5.f12793h = r3
            java.lang.Object r6 = r6.invoke(r5)
            if (r6 != r0) goto L_0x004e
            return r0
        L_0x004e:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0057
            goto L_0x0098
        L_0x0057:
            com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl r6 = r5.f12794i
            com.talabat.wallet.features.walletTransactionList.GetWalletDashboardFlagEnabledUseCase r6 = r6.getWalletDashboardFlagEnabledUseCase
            r5.f12793h = r2
            java.lang.String r1 = "topup-"
            java.lang.Object r6 = r6.invoke(r1, r5)
            if (r6 != r0) goto L_0x0068
            return r0
        L_0x0068:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0084
            com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl r6 = r5.f12794i
            androidx.lifecycle.MutableLiveData r6 = r6.getShouldShowOnBoardingData()
            com.talabat.wallet.ui.walletDashboard.model.WalletOnboardingDisplayModel r0 = new com.talabat.wallet.ui.walletDashboard.model.WalletOnboardingDisplayModel
            r0.<init>()
            com.talabat.wallet.ui.walletDashboard.model.OnboardingType$WithTopUp r1 = com.talabat.wallet.ui.walletDashboard.model.OnboardingType.WithTopUp.INSTANCE
            r0.setOnboardingType(r1)
            r6.setValue(r0)
            goto L_0x00ab
        L_0x0084:
            com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl r6 = r5.f12794i
            androidx.lifecycle.MutableLiveData r6 = r6.getShouldShowOnBoardingData()
            com.talabat.wallet.ui.walletDashboard.model.WalletOnboardingDisplayModel r0 = new com.talabat.wallet.ui.walletDashboard.model.WalletOnboardingDisplayModel
            r0.<init>()
            com.talabat.wallet.ui.walletDashboard.model.OnboardingType$WithoutTopUp r1 = com.talabat.wallet.ui.walletDashboard.model.OnboardingType.WithoutTopUp.INSTANCE
            r0.setOnboardingType(r1)
            r6.setValue(r0)
            goto L_0x00ab
        L_0x0098:
            com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl r6 = r5.f12794i
            androidx.lifecycle.MutableLiveData r6 = r6.getShouldShowOnBoardingData()
            com.talabat.wallet.ui.walletDashboard.model.WalletOnboardingDisplayModel r0 = new com.talabat.wallet.ui.walletDashboard.model.WalletOnboardingDisplayModel
            r0.<init>()
            com.talabat.wallet.ui.walletDashboard.model.OnboardingType$None r1 = com.talabat.wallet.ui.walletDashboard.model.OnboardingType.None.INSTANCE
            r0.setOnboardingType(r1)
            r6.setValue(r0)
        L_0x00ab:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl$shouldShowOnboarding$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
