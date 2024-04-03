package bw;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentThreeDsDialogFragment;

public final /* synthetic */ class n implements DialogInterface.OnKeyListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletPaymentThreeDsDialogFragment f11690b;

    public /* synthetic */ n(WalletPaymentThreeDsDialogFragment walletPaymentThreeDsDialogFragment) {
        this.f11690b = walletPaymentThreeDsDialogFragment;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
        return WalletPaymentThreeDsDialogFragment.m5821onCreateDialog$lambda1(this.f11690b, dialogInterface, i11, keyEvent);
    }
}
