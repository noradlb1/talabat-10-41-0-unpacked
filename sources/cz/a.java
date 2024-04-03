package cz;

import android.view.View;
import com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemDisplayModel;
import com.talabat.wallet.ui.walletTopUp.view.walletTopUpCardList.adapter.WalletTopUpCardListAdapter;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletTopUpCardListAdapter f13812b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel f13813c;

    public /* synthetic */ a(WalletTopUpCardListAdapter walletTopUpCardListAdapter, WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel walletCardAdapterDisplayModel) {
        this.f13812b = walletTopUpCardListAdapter;
        this.f13813c = walletCardAdapterDisplayModel;
    }

    public final void onClick(View view) {
        WalletTopUpCardListAdapter.m6065addCardDetails$lambda1(this.f13812b, this.f13813c, view);
    }
}
