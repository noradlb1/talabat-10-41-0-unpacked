package com.talabat.wallet.ui.expiringCard.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import com.talabat.wallet.ui.expiringCard.model.ExpiringCardDetailDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H&R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001a\u0010\u000e\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u00020\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/talabat/wallet/ui/expiringCard/viewModel/ExpiringCardViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "expiringCardData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/wallet/ui/expiringCard/model/ExpiringCardDetailDisplayModel;", "getExpiringCardData", "()Landroidx/lifecycle/MutableLiveData;", "setExpiringCardData", "(Landroidx/lifecycle/MutableLiveData;)V", "expiringCreditErrorData", "", "getExpiringCreditErrorData", "setExpiringCreditErrorData", "isExpiringCardViewDisplayed", "()Z", "setExpiringCardViewDisplayed", "(Z)V", "shouldDisplayWalletExpiringCardView", "getShouldDisplayWalletExpiringCardView", "setShouldDisplayWalletExpiringCardView", "getExpiringCardDetail", "", "country", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ExpiringCardViewModel extends BaseViewModel {
    @NotNull
    private MutableLiveData<ExpiringCardDetailDisplayModel> expiringCardData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Boolean> expiringCreditErrorData = new MutableLiveData<>();
    private boolean isExpiringCardViewDisplayed;

    @NotNull
    public final MutableLiveData<ExpiringCardDetailDisplayModel> getExpiringCardData() {
        return this.expiringCardData;
    }

    public abstract void getExpiringCardDetail(int i11);

    @NotNull
    public final MutableLiveData<Boolean> getExpiringCreditErrorData() {
        return this.expiringCreditErrorData;
    }

    public abstract boolean getShouldDisplayWalletExpiringCardView();

    public final boolean isExpiringCardViewDisplayed() {
        return this.isExpiringCardViewDisplayed;
    }

    public final void setExpiringCardData(@NotNull MutableLiveData<ExpiringCardDetailDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.expiringCardData = mutableLiveData;
    }

    public final void setExpiringCardViewDisplayed(boolean z11) {
        this.isExpiringCardViewDisplayed = z11;
    }

    public final void setExpiringCreditErrorData(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.expiringCreditErrorData = mutableLiveData;
    }

    public abstract void setShouldDisplayWalletExpiringCardView(boolean z11);
}
