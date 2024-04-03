package bw;

import android.view.View;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.PaymentWidgetBottomSheetFragment;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PaymentWidgetBottomSheetFragment f11679b;

    public /* synthetic */ a(PaymentWidgetBottomSheetFragment paymentWidgetBottomSheetFragment) {
        this.f11679b = paymentWidgetBottomSheetFragment;
    }

    public final void onClick(View view) {
        PaymentWidgetBottomSheetFragment.m5808addPaymentListener$lambda0(this.f11679b, view);
    }
}
