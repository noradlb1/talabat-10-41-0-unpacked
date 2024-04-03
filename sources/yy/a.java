package yy;

import android.view.View;
import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDataItemDisplayModel;
import com.talabat.wallet.ui.walletDashboard.view.adapter.WalletTransactionListAdapter;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletTransactionListAdapter f24213b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WalletTransactionListDataItemDisplayModel.CobrandedCCModel f24214c;

    public /* synthetic */ a(WalletTransactionListAdapter walletTransactionListAdapter, WalletTransactionListDataItemDisplayModel.CobrandedCCModel cobrandedCCModel) {
        this.f24213b = walletTransactionListAdapter;
        this.f24214c = cobrandedCCModel;
    }

    public final void onClick(View view) {
        WalletTransactionListAdapter.m6062bindCobrandedCreditCardView$lambda3$lambda2(this.f24213b, this.f24214c, view);
    }
}
