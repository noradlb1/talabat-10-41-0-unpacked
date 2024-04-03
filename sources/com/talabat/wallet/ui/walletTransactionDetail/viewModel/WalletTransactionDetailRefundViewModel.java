package com.talabat.wallet.ui.walletTransactionDetail.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.wallet.features.refund.GetWalletCanRevertRefundToBankUseCase;
import com.talabat.wallet.features.refund.GetWalletRevertRefundToBankUseCase;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletRefundDisplayModelState;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/viewModel/WalletTransactionDetailRefundViewModel;", "Landroidx/lifecycle/ViewModel;", "walletCanRevertRefundToBankUseCase", "Lcom/talabat/wallet/features/refund/GetWalletCanRevertRefundToBankUseCase;", "walletRevertRefundToBankUseCase", "Lcom/talabat/wallet/features/refund/GetWalletRevertRefundToBankUseCase;", "(Lcom/talabat/wallet/features/refund/GetWalletCanRevertRefundToBankUseCase;Lcom/talabat/wallet/features/refund/GetWalletRevertRefundToBankUseCase;)V", "walletCanRevertRefundToBankData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletRefundDisplayModelState;", "getWalletCanRevertRefundToBankData", "()Landroidx/lifecycle/MutableLiveData;", "setWalletCanRevertRefundToBankData", "(Landroidx/lifecycle/MutableLiveData;)V", "walletRevertRefundToBankData", "getWalletRevertRefundToBankData", "setWalletRevertRefundToBankData", "onLoadCanRevertRefundToBank", "", "orderId", "", "onLoadRevertRefundToBank", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDetailRefundViewModel extends ViewModel {
    @NotNull
    private MutableLiveData<WalletRefundDisplayModelState> walletCanRevertRefundToBankData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final GetWalletCanRevertRefundToBankUseCase walletCanRevertRefundToBankUseCase;
    @NotNull
    private MutableLiveData<WalletRefundDisplayModelState> walletRevertRefundToBankData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final GetWalletRevertRefundToBankUseCase walletRevertRefundToBankUseCase;

    public WalletTransactionDetailRefundViewModel(@NotNull GetWalletCanRevertRefundToBankUseCase getWalletCanRevertRefundToBankUseCase, @NotNull GetWalletRevertRefundToBankUseCase getWalletRevertRefundToBankUseCase) {
        Intrinsics.checkNotNullParameter(getWalletCanRevertRefundToBankUseCase, "walletCanRevertRefundToBankUseCase");
        Intrinsics.checkNotNullParameter(getWalletRevertRefundToBankUseCase, "walletRevertRefundToBankUseCase");
        this.walletCanRevertRefundToBankUseCase = getWalletCanRevertRefundToBankUseCase;
        this.walletRevertRefundToBankUseCase = getWalletRevertRefundToBankUseCase;
    }

    @NotNull
    public final MutableLiveData<WalletRefundDisplayModelState> getWalletCanRevertRefundToBankData() {
        return this.walletCanRevertRefundToBankData;
    }

    @NotNull
    public final MutableLiveData<WalletRefundDisplayModelState> getWalletRevertRefundToBankData() {
        return this.walletRevertRefundToBankData;
    }

    public final void onLoadCanRevertRefundToBank(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        this.walletCanRevertRefundToBankData.setValue(WalletRefundDisplayModelState.Loading.INSTANCE);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WalletTransactionDetailRefundViewModel$onLoadCanRevertRefundToBank$1(this, str, (Continuation<? super WalletTransactionDetailRefundViewModel$onLoadCanRevertRefundToBank$1>) null), 3, (Object) null);
    }

    public final void onLoadRevertRefundToBank(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        this.walletRevertRefundToBankData.setValue(WalletRefundDisplayModelState.Loading.INSTANCE);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WalletTransactionDetailRefundViewModel$onLoadRevertRefundToBank$1(this, str, (Continuation<? super WalletTransactionDetailRefundViewModel$onLoadRevertRefundToBank$1>) null), 3, (Object) null);
    }

    public final void setWalletCanRevertRefundToBankData(@NotNull MutableLiveData<WalletRefundDisplayModelState> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletCanRevertRefundToBankData = mutableLiveData;
    }

    public final void setWalletRevertRefundToBankData(@NotNull MutableLiveData<WalletRefundDisplayModelState> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletRevertRefundToBankData = mutableLiveData;
    }
}
