package bw;

import android.view.View;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentOptionView;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletPaymentOptionView f11685b;

    public /* synthetic */ h(WalletPaymentOptionView walletPaymentOptionView) {
        this.f11685b = walletPaymentOptionView;
    }

    public final void onClick(View view) {
        WalletPaymentOptionView.m5811addAddCardListener$lambda13(this.f11685b, view);
    }
}
