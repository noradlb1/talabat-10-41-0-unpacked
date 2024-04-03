package ky;

import android.view.View;
import com.talabat.wallet.screens.walletTopupCardList.view.WalletCreditCardAdapter;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletCreditCardAdapter f23907b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f23908c;

    public /* synthetic */ a(WalletCreditCardAdapter walletCreditCardAdapter, int i11) {
        this.f23907b = walletCreditCardAdapter;
        this.f23908c = i11;
    }

    public final void onClick(View view) {
        WalletCreditCardAdapter.m6006onBindViewHolder$lambda1(this.f23907b, this.f23908c, view);
    }
}
