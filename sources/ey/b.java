package ey;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.wallet.screens.walletManageCard.view.WalletManageCreditCardsAdapter;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletManageCreditCardsAdapter f14032b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f14033c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f14034d;

    public /* synthetic */ b(WalletManageCreditCardsAdapter walletManageCreditCardsAdapter, int i11, RecyclerView.ViewHolder viewHolder) {
        this.f14032b = walletManageCreditCardsAdapter;
        this.f14033c = i11;
        this.f14034d = viewHolder;
    }

    public final void onClick(View view) {
        WalletManageCreditCardsAdapter.m5982onBindViewHolder$lambda0(this.f14032b, this.f14033c, this.f14034d, view);
    }
}
