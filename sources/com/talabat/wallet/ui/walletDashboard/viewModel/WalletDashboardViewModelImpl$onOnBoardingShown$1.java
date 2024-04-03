package com.talabat.wallet.ui.walletDashboard.viewModel;

import com.talabat.wallet.features.walletonboarding.repository.UpdateWasWalletOnboardingShownUseCase;
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
@DebugMetadata(c = "com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl$onOnBoardingShown$1", f = "WalletDashboardViewModelImpl.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, s = {})
public final class WalletDashboardViewModelImpl$onOnBoardingShown$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12782h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ WalletDashboardViewModelImpl f12783i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDashboardViewModelImpl$onOnBoardingShown$1(WalletDashboardViewModelImpl walletDashboardViewModelImpl, Continuation<? super WalletDashboardViewModelImpl$onOnBoardingShown$1> continuation) {
        super(2, continuation);
        this.f12783i = walletDashboardViewModelImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WalletDashboardViewModelImpl$onOnBoardingShown$1(this.f12783i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WalletDashboardViewModelImpl$onOnBoardingShown$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12782h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            UpdateWasWalletOnboardingShownUseCase access$getUpdateWasWalletOnboardingShownUseCase$p = this.f12783i.updateWasWalletOnboardingShownUseCase;
            this.f12782h = 1;
            if (access$getUpdateWasWalletOnboardingShownUseCase$p.invoke(true, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
