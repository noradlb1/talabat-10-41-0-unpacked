package com.talabat.wallet.ui.expiringCard.viewModel;

import com.talabat.talabatcore.exception.Failure;
import com.talabat.wallet.features.expiringCard.GetExpiringCardDetailUseCase;
import com.talabat.wallet.ui.expiringCard.model.ExpiringCardDetailDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/talabat/wallet/ui/expiringCard/viewModel/ExpiringCardViewModelImpl;", "Lcom/talabat/wallet/ui/expiringCard/viewModel/ExpiringCardViewModel;", "getExpiringCardDetailUseCase", "Lcom/talabat/wallet/features/expiringCard/GetExpiringCardDetailUseCase;", "(Lcom/talabat/wallet/features/expiringCard/GetExpiringCardDetailUseCase;)V", "shouldDisplayWalletExpiringCardView", "", "getShouldDisplayWalletExpiringCardView", "()Z", "setShouldDisplayWalletExpiringCardView", "(Z)V", "getExpiringCardDetail", "", "country", "", "handleExpiringCardSuccess", "expiringCardDetailDisplayModel", "Lcom/talabat/wallet/ui/expiringCard/model/ExpiringCardDetailDisplayModel;", "handleExpiringCreditFailure", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "ignoreRemoteLoading", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExpiringCardViewModelImpl extends ExpiringCardViewModel {
    @NotNull
    private final GetExpiringCardDetailUseCase getExpiringCardDetailUseCase;
    private boolean shouldDisplayWalletExpiringCardView;

    public ExpiringCardViewModelImpl(@NotNull GetExpiringCardDetailUseCase getExpiringCardDetailUseCase2) {
        Intrinsics.checkNotNullParameter(getExpiringCardDetailUseCase2, "getExpiringCardDetailUseCase");
        this.getExpiringCardDetailUseCase = getExpiringCardDetailUseCase2;
    }

    /* access modifiers changed from: private */
    public final void handleExpiringCardSuccess(ExpiringCardDetailDisplayModel expiringCardDetailDisplayModel) {
        getExpiringCardData().setValue(expiringCardDetailDisplayModel);
    }

    /* access modifiers changed from: private */
    public final void handleExpiringCreditFailure(Failure failure) {
        getExpiringCreditErrorData().setValue(Boolean.TRUE);
    }

    private final void ignoreRemoteLoading() {
        ExpiringCardDetailDisplayModel expiringCardDetailDisplayModel = new ExpiringCardDetailDisplayModel();
        expiringCardDetailDisplayModel.setLoadingCompleted(true);
        getExpiringCardData().setValue(expiringCardDetailDisplayModel);
    }

    public void getExpiringCardDetail(int i11) {
        if (getShouldDisplayWalletExpiringCardView()) {
            this.getExpiringCardDetailUseCase.invoke(Integer.valueOf(i11), new ExpiringCardViewModelImpl$getExpiringCardDetail$1(this));
        } else {
            ignoreRemoteLoading();
        }
    }

    public boolean getShouldDisplayWalletExpiringCardView() {
        return this.shouldDisplayWalletExpiringCardView;
    }

    public void setShouldDisplayWalletExpiringCardView(boolean z11) {
        this.shouldDisplayWalletExpiringCardView = z11;
    }
}
