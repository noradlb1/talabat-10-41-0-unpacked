package com.talabat.wallet.ui.walletCardManagement.view.walletCardList;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletCardManagementFragment$onViewCreated$2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public WalletCardManagementFragment$onViewCreated$2(Object obj) {
        super(1, obj, WalletCardManagementFragment.class, "updateFailureNotification", "updateFailureNotification(Ljava/lang/Boolean;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Boolean bool) {
        ((WalletCardManagementFragment) this.receiver).updateFailureNotification(bool);
    }
}
