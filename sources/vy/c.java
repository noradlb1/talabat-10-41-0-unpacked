package vy;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.wallet.ui.walletCardManagement.view.walletCardList.adapter.WalletCardListAdapter;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletCardListAdapter f24157b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f24158c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f24159d;

    public /* synthetic */ c(WalletCardListAdapter walletCardListAdapter, RecyclerView.ViewHolder viewHolder, int i11) {
        this.f24157b = walletCardListAdapter;
        this.f24158c = viewHolder;
        this.f24159d = i11;
    }

    public final void onClick(View view) {
        WalletCardListAdapter.m6047showCardDetail$lambda1(this.f24157b, this.f24158c, this.f24159d, view);
    }
}
