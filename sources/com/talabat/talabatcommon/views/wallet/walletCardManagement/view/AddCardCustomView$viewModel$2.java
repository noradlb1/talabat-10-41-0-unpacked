package com.talabat.talabatcommon.views.wallet.walletCardManagement.view;

import com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.WalletCardManagementViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/viewModel/WalletCardManagementViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AddCardCustomView$viewModel$2 extends Lambda implements Function0<WalletCardManagementViewModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AddCardCustomView f11952g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddCardCustomView$viewModel$2(AddCardCustomView addCardCustomView) {
        super(0);
        this.f11952g = addCardCustomView;
    }

    @NotNull
    public final WalletCardManagementViewModel invoke() {
        AddCardCustomView addCardCustomView = this.f11952g;
        return addCardCustomView.setupCardManagementViewModel(addCardCustomView.getGenerateCardTokenUseCase(), this.f11952g.getPaymentConfigurationRepository());
    }
}
