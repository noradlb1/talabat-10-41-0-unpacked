package com.talabat.wallet.ui.walletTransactionDetail.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.talabatcommon.feature.orderDetail.GetOrderDetailUseCase;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletOrderDetailModelState;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/viewModel/WalletTransactionDetailPaymentViewModel;", "Landroidx/lifecycle/ViewModel;", "getGetOrderDetailUseCase", "Lcom/talabat/talabatcommon/feature/orderDetail/GetOrderDetailUseCase;", "(Lcom/talabat/talabatcommon/feature/orderDetail/GetOrderDetailUseCase;)V", "orderDetailData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletOrderDetailModelState;", "getOrderDetailData", "()Landroidx/lifecycle/MutableLiveData;", "setOrderDetailData", "(Landroidx/lifecycle/MutableLiveData;)V", "onLoadOrderDetail", "", "transactionOrderId", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDetailPaymentViewModel extends ViewModel {
    /* access modifiers changed from: private */
    @NotNull
    public final GetOrderDetailUseCase getGetOrderDetailUseCase;
    @NotNull
    private MutableLiveData<WalletOrderDetailModelState> orderDetailData = new MutableLiveData<>();

    public WalletTransactionDetailPaymentViewModel(@NotNull GetOrderDetailUseCase getOrderDetailUseCase) {
        Intrinsics.checkNotNullParameter(getOrderDetailUseCase, "getGetOrderDetailUseCase");
        this.getGetOrderDetailUseCase = getOrderDetailUseCase;
    }

    @NotNull
    public final MutableLiveData<WalletOrderDetailModelState> getOrderDetailData() {
        return this.orderDetailData;
    }

    public final void onLoadOrderDetail(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "transactionOrderId");
        this.orderDetailData.setValue(WalletOrderDetailModelState.Loading.INSTANCE);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WalletTransactionDetailPaymentViewModel$onLoadOrderDetail$1(this, str, (Continuation<? super WalletTransactionDetailPaymentViewModel$onLoadOrderDetail$1>) null), 3, (Object) null);
    }

    public final void setOrderDetailData(@NotNull MutableLiveData<WalletOrderDetailModelState> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.orderDetailData = mutableLiveData;
    }
}
