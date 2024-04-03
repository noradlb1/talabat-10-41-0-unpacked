package com.talabat.talabatcommon.views.wallet.walletPaymentOption.view;

import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PaymentWidgetBottomSheet$attachSuccessScreen$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PaymentWidgetBottomSheet f11982g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentWidgetBottomSheet$attachSuccessScreen$1(PaymentWidgetBottomSheet paymentWidgetBottomSheet) {
        super(0);
        this.f11982g = paymentWidgetBottomSheet;
    }

    public final void invoke() {
        this.f11982g.closeBottomSheetFromDialog();
        PaymentWidgetBottomSheet.b(this.f11982g, WalletPaymentStatus.SUCCESS, (String) null, 2, (Object) null);
    }
}
