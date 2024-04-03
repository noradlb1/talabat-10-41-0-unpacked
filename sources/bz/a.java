package bz;

import android.view.View;
import com.talabat.wallet.ui.walletTopUp.view.walletTopUpCardList.WalletTopUpCardListFragment;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletTopUpCardListFragment f11693b;

    public /* synthetic */ a(WalletTopUpCardListFragment walletTopUpCardListFragment) {
        this.f11693b = walletTopUpCardListFragment;
    }

    public final void onClick(View view) {
        WalletTopUpCardListFragment.m6063addCardListener$lambda3(this.f11693b, view);
    }
}
