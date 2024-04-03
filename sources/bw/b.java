package bw;

import android.view.View;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.PaymentWidgetBottomSheetFragment;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PaymentWidgetBottomSheetFragment f11680b;

    public /* synthetic */ b(PaymentWidgetBottomSheetFragment paymentWidgetBottomSheetFragment) {
        this.f11680b = paymentWidgetBottomSheetFragment;
    }

    public final void onClick(View view) {
        PaymentWidgetBottomSheetFragment.m5809addPaymentListener$lambda1(this.f11680b, view);
    }
}
