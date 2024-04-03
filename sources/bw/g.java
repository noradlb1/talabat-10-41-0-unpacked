package bw;

import android.view.View;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentOptionView;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletPaymentOptionView f11684b;

    public /* synthetic */ g(WalletPaymentOptionView walletPaymentOptionView) {
        this.f11684b = walletPaymentOptionView;
    }

    public final void onClick(View view) {
        WalletPaymentOptionView.m5810addAddCardListener$lambda12(this.f11684b, view);
    }
}
