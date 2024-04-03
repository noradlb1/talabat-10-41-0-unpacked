package com.talabat.wallet.ui.walletCardManagement.view.walletCardList;

import com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.WalletCardManagementViewModel;
import com.talabat.talabatcore.viewmodel.BaseViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/talabat/talabatcore/viewmodel/BaseViewModelFactory;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/viewModel/WalletCardManagementViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WalletCardManagementFragment$factory$2 extends Lambda implements Function0<BaseViewModelFactory<WalletCardManagementViewModel>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WalletCardManagementFragment f12733g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletCardManagementFragment$factory$2(WalletCardManagementFragment walletCardManagementFragment) {
        super(0);
        this.f12733g = walletCardManagementFragment;
    }

    @NotNull
    public final BaseViewModelFactory<WalletCardManagementViewModel> invoke() {
        return new BaseViewModelFactory<>(new Function0<WalletCardManagementViewModel>(this.f12733g) {
            @NotNull
            public final WalletCardManagementViewModel invoke() {
                return ((WalletCardManagementFragment) this.receiver).viewModelBuilder();
            }
        });
    }
}
