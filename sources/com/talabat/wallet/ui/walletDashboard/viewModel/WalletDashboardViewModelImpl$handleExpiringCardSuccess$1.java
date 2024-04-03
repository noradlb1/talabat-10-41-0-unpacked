package com.talabat.wallet.ui.walletDashboard.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.wallet.features.cobrandedcc.GetWalletDashboardCobrandedCCEnabledUseCase;
import com.talabat.wallet.ui.expiringCard.model.ExpiringCardDetailDisplayModel;
import com.talabat.wallet.ui.transactionslistheader.TransactionsListHeaderDisplayModel;
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
@DebugMetadata(c = "com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl$handleExpiringCardSuccess$1", f = "WalletDashboardViewModelImpl.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
public final class WalletDashboardViewModelImpl$handleExpiringCardSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f12771h;

    /* renamed from: i  reason: collision with root package name */
    public Object f12772i;

    /* renamed from: j  reason: collision with root package name */
    public Object f12773j;

    /* renamed from: k  reason: collision with root package name */
    public int f12774k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ WalletDashboardViewModelImpl f12775l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ ExpiringCardDetailDisplayModel f12776m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDashboardViewModelImpl$handleExpiringCardSuccess$1(WalletDashboardViewModelImpl walletDashboardViewModelImpl, ExpiringCardDetailDisplayModel expiringCardDetailDisplayModel, Continuation<? super WalletDashboardViewModelImpl$handleExpiringCardSuccess$1> continuation) {
        super(2, continuation);
        this.f12775l = walletDashboardViewModelImpl;
        this.f12776m = expiringCardDetailDisplayModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WalletDashboardViewModelImpl$handleExpiringCardSuccess$1(this.f12775l, this.f12776m, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WalletDashboardViewModelImpl$handleExpiringCardSuccess$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        TransactionsListHeaderDisplayModel transactionsListHeaderDisplayModel;
        TransactionsListHeaderDisplayModel transactionsListHeaderDisplayModel2;
        MutableLiveData<TransactionsListHeaderDisplayModel> mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12774k;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData<TransactionsListHeaderDisplayModel> transactionsListHeaderDisplayModelData = this.f12775l.getTransactionsListHeaderDisplayModelData();
            transactionsListHeaderDisplayModel2 = new TransactionsListHeaderDisplayModel();
            ExpiringCardDetailDisplayModel expiringCardDetailDisplayModel = this.f12776m;
            WalletDashboardViewModelImpl walletDashboardViewModelImpl = this.f12775l;
            transactionsListHeaderDisplayModel2.setExpiringCardDetailDisplayModel(expiringCardDetailDisplayModel);
            GetWalletDashboardCobrandedCCEnabledUseCase access$getGetWalletDashboardCobrandedCCEnabledUseCase$p = walletDashboardViewModelImpl.getWalletDashboardCobrandedCCEnabledUseCase;
            this.f12771h = transactionsListHeaderDisplayModel2;
            this.f12772i = transactionsListHeaderDisplayModel2;
            this.f12773j = transactionsListHeaderDisplayModelData;
            this.f12774k = 1;
            Object invoke = access$getGetWalletDashboardCobrandedCCEnabledUseCase$p.invoke(this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = transactionsListHeaderDisplayModelData;
            obj = invoke;
            transactionsListHeaderDisplayModel = transactionsListHeaderDisplayModel2;
        } else if (i11 == 1) {
            mutableLiveData = (MutableLiveData) this.f12773j;
            transactionsListHeaderDisplayModel2 = (TransactionsListHeaderDisplayModel) this.f12772i;
            transactionsListHeaderDisplayModel = (TransactionsListHeaderDisplayModel) this.f12771h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        transactionsListHeaderDisplayModel2.setShouldDisplayCobrandedCCBanner(((Boolean) obj).booleanValue());
        mutableLiveData.setValue(transactionsListHeaderDisplayModel);
        return Unit.INSTANCE;
    }
}
