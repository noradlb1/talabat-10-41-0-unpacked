package com.talabat.wallet.ui.walletTopUp.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.wallet.features.walletCashBack.WalletTopUpListFormatterParam;
import com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemDisplayModel;
import com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemWithTypeDisplayModel;
import java.util.List;
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
@DebugMetadata(c = "com.talabat.wallet.ui.walletTopUp.viewModel.WalletTopUpViewModelImpl$populateWalletTopUpListData$1", f = "WalletTopUpViewModelImpl.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
public final class WalletTopUpViewModelImpl$populateWalletTopUpListData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f12821h;

    /* renamed from: i  reason: collision with root package name */
    public int f12822i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ WalletTopUpViewModelImpl f12823j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletTopUpViewModelImpl$populateWalletTopUpListData$1(WalletTopUpViewModelImpl walletTopUpViewModelImpl, Continuation<? super WalletTopUpViewModelImpl$populateWalletTopUpListData$1> continuation) {
        super(2, continuation);
        this.f12823j = walletTopUpViewModelImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WalletTopUpViewModelImpl$populateWalletTopUpListData$1(this.f12823j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WalletTopUpViewModelImpl$populateWalletTopUpListData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData<WalletCreditCardListDataItemWithTypeDisplayModel> mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12822i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            List<WalletCreditCardListDataItemDisplayModel> invoke = this.f12823j.getFormattedWalletTopUpListUseCase.invoke(new WalletTopUpListFormatterParam(this.f12823j.getCashBackCampaignData().getValue(), this.f12823j.getTopUpCardListData().getValue()));
            MutableLiveData<WalletCreditCardListDataItemWithTypeDisplayModel> topUpItemsListDataCredit = this.f12823j.getTopUpItemsListDataCredit();
            SetDebitCardsDeflectionUseCase access$getSetDebitCardsDeflectionUseCase$p = this.f12823j.setDebitCardsDeflectionUseCase;
            this.f12821h = topUpItemsListDataCredit;
            this.f12822i = 1;
            obj = access$getSetDebitCardsDeflectionUseCase$p.invoke(invoke, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = topUpItemsListDataCredit;
        } else if (i11 == 1) {
            mutableLiveData = (MutableLiveData) this.f12821h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableLiveData.setValue(obj);
        return Unit.INSTANCE;
    }
}
