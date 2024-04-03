package com.talabat.wallet.ui.walletTransactionDetail.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.wallet.features.walletTransactionDetail.GetWalletTransactionDetailUseCase;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionDetailHeaderDisplayModel;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionDisplayModelState;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/viewModel/WalletTransactionDetailViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "getWalletTransactionDetailUseCase", "Lcom/talabat/wallet/features/walletTransactionDetail/GetWalletTransactionDetailUseCase;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lcom/talabat/wallet/features/walletTransactionDetail/GetWalletTransactionDetailUseCase;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "walletTransactionDetailData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState;", "getWalletTransactionDetailData", "()Landroidx/lifecycle/MutableLiveData;", "setWalletTransactionDetailData", "(Landroidx/lifecycle/MutableLiveData;)V", "walletTransactionDetailHeaderData", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;", "getWalletTransactionDetailHeaderData", "setWalletTransactionDetailHeaderData", "onLoadWalletTransactionDetail", "", "transactionType", "", "transactionId", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDetailViewModelImpl extends ViewModel {
    /* access modifiers changed from: private */
    @NotNull
    public final ConfigurationLocalRepository configurationLocalRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final GetWalletTransactionDetailUseCase getWalletTransactionDetailUseCase;
    @NotNull
    private MutableLiveData<WalletTransactionDisplayModelState> walletTransactionDetailData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletTransactionDetailHeaderDisplayModel> walletTransactionDetailHeaderData = new MutableLiveData<>();

    public WalletTransactionDetailViewModelImpl(@NotNull GetWalletTransactionDetailUseCase getWalletTransactionDetailUseCase2, @NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(getWalletTransactionDetailUseCase2, "getWalletTransactionDetailUseCase");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.getWalletTransactionDetailUseCase = getWalletTransactionDetailUseCase2;
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    @NotNull
    public final MutableLiveData<WalletTransactionDisplayModelState> getWalletTransactionDetailData() {
        return this.walletTransactionDetailData;
    }

    @NotNull
    public final MutableLiveData<WalletTransactionDetailHeaderDisplayModel> getWalletTransactionDetailHeaderData() {
        return this.walletTransactionDetailHeaderData;
    }

    public final void onLoadWalletTransactionDetail(int i11, int i12) {
        this.walletTransactionDetailData.setValue(WalletTransactionDisplayModelState.Loading.INSTANCE);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WalletTransactionDetailViewModelImpl$onLoadWalletTransactionDetail$1(this, i11, i12, (Continuation<? super WalletTransactionDetailViewModelImpl$onLoadWalletTransactionDetail$1>) null), 3, (Object) null);
    }

    public final void setWalletTransactionDetailData(@NotNull MutableLiveData<WalletTransactionDisplayModelState> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletTransactionDetailData = mutableLiveData;
    }

    public final void setWalletTransactionDetailHeaderData(@NotNull MutableLiveData<WalletTransactionDetailHeaderDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletTransactionDetailHeaderData = mutableLiveData;
    }
}
