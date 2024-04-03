package bw;

import android.widget.CompoundButton;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentOptionView;

public final /* synthetic */ class f implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletPaymentOptionView f11683b;

    public /* synthetic */ f(WalletPaymentOptionView walletPaymentOptionView) {
        this.f11683b = walletPaymentOptionView;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        WalletPaymentOptionView.m5816setupView$lambda11(this.f11683b, compoundButton, z11);
    }
}
