package com.talabat.wallet.ui.walletTopUp.view.walletTopUpCardList;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletTopUpCardListFragment$observatory$2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public WalletTopUpCardListFragment$observatory$2(Object obj) {
        super(1, obj, WalletTopUpCardListFragment.class, "updateEmptyCardListView", "updateEmptyCardListView(Ljava/lang/Boolean;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Boolean bool) {
        ((WalletTopUpCardListFragment) this.receiver).updateEmptyCardListView(bool);
    }
}
