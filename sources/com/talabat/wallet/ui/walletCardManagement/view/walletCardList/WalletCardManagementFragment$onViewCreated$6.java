package com.talabat.wallet.ui.walletCardManagement.view.walletCardList;

import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.IconStateDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletCardManagementFragment$onViewCreated$6 extends FunctionReferenceImpl implements Function1<IconStateDisplayModel, Unit> {
    public WalletCardManagementFragment$onViewCreated$6(Object obj) {
        super(1, obj, WalletCardManagementFragment.class, "updateShowEditActionText", "updateShowEditActionText(Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/IconStateDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IconStateDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable IconStateDisplayModel iconStateDisplayModel) {
        ((WalletCardManagementFragment) this.receiver).updateShowEditActionText(iconStateDisplayModel);
    }
}
