package com.talabat.wallet.ui.walletDashboard.viewModel;

import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionDetailsDisplayModel;
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
@DebugMetadata(c = "com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl$onTransactionDetailsClicked$1", f = "WalletDashboardViewModelImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WalletDashboardViewModelImpl$onTransactionDetailsClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12786h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ WalletDashboardViewModelImpl f12787i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f12788j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f12789k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDashboardViewModelImpl$onTransactionDetailsClicked$1(WalletDashboardViewModelImpl walletDashboardViewModelImpl, int i11, int i12, Continuation<? super WalletDashboardViewModelImpl$onTransactionDetailsClicked$1> continuation) {
        super(2, continuation);
        this.f12787i = walletDashboardViewModelImpl;
        this.f12788j = i11;
        this.f12789k = i12;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WalletDashboardViewModelImpl$onTransactionDetailsClicked$1(this.f12787i, this.f12788j, this.f12789k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WalletDashboardViewModelImpl$onTransactionDetailsClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f12786h == 0) {
            ResultKt.throwOnFailure(obj);
            this.f12787i.getShouldShowTransactionDetailsData().setValue(new WalletTransactionDetailsDisplayModel(this.f12787i.getShouldShowWalletTransactionDetailsInFlutterUseCase.invoke(), this.f12788j, this.f12789k));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
