package yx;

import android.view.View;
import com.talabat.wallet.screens.walletDashboard.view.WalletCreditTransactionListAdapter;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletCreditTransactionListAdapter f24205b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f24206c;

    public /* synthetic */ a(WalletCreditTransactionListAdapter walletCreditTransactionListAdapter, int i11) {
        this.f24205b = walletCreditTransactionListAdapter;
        this.f24206c = i11;
    }

    public final void onClick(View view) {
        WalletCreditTransactionListAdapter.m5970onBindViewHolder$lambda0(this.f24205b, this.f24206c, view);
    }
}
