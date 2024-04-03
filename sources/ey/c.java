package ey;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.wallet.screens.walletManageCard.view.WalletManageCreditCardsAdapter;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletManageCreditCardsAdapter f14035b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f14036c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f14037d;

    public /* synthetic */ c(WalletManageCreditCardsAdapter walletManageCreditCardsAdapter, int i11, RecyclerView.ViewHolder viewHolder) {
        this.f14035b = walletManageCreditCardsAdapter;
        this.f14036c = i11;
        this.f14037d = viewHolder;
    }

    public final void onClick(View view) {
        WalletManageCreditCardsAdapter.m5983onBindViewHolder$lambda1(this.f14035b, this.f14036c, this.f14037d, view);
    }
}
