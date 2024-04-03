package com.talabat.wallet.ui.walletDashboard.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.wallet.features.cobrandedcc.GetWalletDashboardCobrandedCCEnabledUseCase;
import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionEmptyListDisplayModel;
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
@DebugMetadata(c = "com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl$handleWalletTransactionListSuccess$1", f = "WalletDashboardViewModelImpl.kt", i = {}, l = {285}, m = "invokeSuspend", n = {}, s = {})
public final class WalletDashboardViewModelImpl$handleWalletTransactionListSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f12777h;

    /* renamed from: i  reason: collision with root package name */
    public Object f12778i;

    /* renamed from: j  reason: collision with root package name */
    public Object f12779j;

    /* renamed from: k  reason: collision with root package name */
    public int f12780k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ WalletDashboardViewModelImpl f12781l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDashboardViewModelImpl$handleWalletTransactionListSuccess$1(WalletDashboardViewModelImpl walletDashboardViewModelImpl, Continuation<? super WalletDashboardViewModelImpl$handleWalletTransactionListSuccess$1> continuation) {
        super(2, continuation);
        this.f12781l = walletDashboardViewModelImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WalletDashboardViewModelImpl$handleWalletTransactionListSuccess$1(this.f12781l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WalletDashboardViewModelImpl$handleWalletTransactionListSuccess$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        WalletTransactionEmptyListDisplayModel walletTransactionEmptyListDisplayModel;
        WalletTransactionEmptyListDisplayModel walletTransactionEmptyListDisplayModel2;
        MutableLiveData<WalletTransactionEmptyListDisplayModel> mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12780k;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData<WalletTransactionEmptyListDisplayModel> walletTransactionEmptyListDisplayModelData = this.f12781l.getWalletTransactionEmptyListDisplayModelData();
            walletTransactionEmptyListDisplayModel2 = new WalletTransactionEmptyListDisplayModel();
            WalletDashboardViewModelImpl walletDashboardViewModelImpl = this.f12781l;
            walletTransactionEmptyListDisplayModel2.setShouldShowEmptyList(true);
            GetWalletDashboardCobrandedCCEnabledUseCase access$getGetWalletDashboardCobrandedCCEnabledUseCase$p = walletDashboardViewModelImpl.getWalletDashboardCobrandedCCEnabledUseCase;
            this.f12777h = walletTransactionEmptyListDisplayModel2;
            this.f12778i = walletTransactionEmptyListDisplayModel2;
            this.f12779j = walletTransactionEmptyListDisplayModelData;
            this.f12780k = 1;
            Object invoke = access$getGetWalletDashboardCobrandedCCEnabledUseCase$p.invoke(this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = walletTransactionEmptyListDisplayModelData;
            obj = invoke;
            walletTransactionEmptyListDisplayModel = walletTransactionEmptyListDisplayModel2;
        } else if (i11 == 1) {
            mutableLiveData = (MutableLiveData) this.f12779j;
            walletTransactionEmptyListDisplayModel2 = (WalletTransactionEmptyListDisplayModel) this.f12778i;
            walletTransactionEmptyListDisplayModel = (WalletTransactionEmptyListDisplayModel) this.f12777h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        walletTransactionEmptyListDisplayModel2.setShouldDisplayCobrandedCCBanner(((Boolean) obj).booleanValue());
        mutableLiveData.setValue(walletTransactionEmptyListDisplayModel);
        return Unit.INSTANCE;
    }
}
