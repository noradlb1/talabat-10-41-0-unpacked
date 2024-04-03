package yx;

import android.view.View;
import com.talabat.wallet.screens.walletDashboard.view.WalletTransactionDashboardScreen;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletTransactionDashboardScreen f24207b;

    public /* synthetic */ b(WalletTransactionDashboardScreen walletTransactionDashboardScreen) {
        this.f24207b = walletTransactionDashboardScreen;
    }

    public final void onClick(View view) {
        WalletTransactionDashboardScreen.m5976redirectWalletToLoginScreen$lambda5(this.f24207b, view);
    }
}
