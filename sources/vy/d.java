package vy;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.wallet.ui.walletCardManagement.view.walletCardList.adapter.WalletCardListAdapter;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletCardListAdapter f24160b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f24161c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f24162d;

    public /* synthetic */ d(WalletCardListAdapter walletCardListAdapter, int i11, RecyclerView.ViewHolder viewHolder) {
        this.f24160b = walletCardListAdapter;
        this.f24161c = i11;
        this.f24162d = viewHolder;
    }

    public final void onClick(View view) {
        WalletCardListAdapter.m6048showCardDetail$lambda2(this.f24160b, this.f24161c, this.f24162d, view);
    }
}
