package com.talabat.talabatcommon.views.ridersTip.bottomSheet;

import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentWidgetDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class RiderTipFragment$observatory$4 extends FunctionReferenceImpl implements Function1<WalletPaymentWidgetDisplayModel, Unit> {
    public RiderTipFragment$observatory$4(Object obj) {
        super(1, obj, RiderTipFragment.class, "updateCtaButton", "updateCtaButton(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentWidgetDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletPaymentWidgetDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel) {
        ((RiderTipFragment) this.receiver).updateCtaButton(walletPaymentWidgetDisplayModel);
    }
}
