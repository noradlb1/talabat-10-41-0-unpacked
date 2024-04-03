package yy;

import android.view.View;
import com.talabat.wallet.ui.walletDashboard.view.adapter.WalletTransactionListAdapter;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletTransactionListAdapter f24215b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f24216c;

    public /* synthetic */ b(WalletTransactionListAdapter walletTransactionListAdapter, int i11) {
        this.f24215b = walletTransactionListAdapter;
        this.f24216c = i11;
    }

    public final void onClick(View view) {
        WalletTransactionListAdapter.m6061addTransactionModelListener$lambda4(this.f24215b, this.f24216c, view);
    }
}
