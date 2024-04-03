package vy;

import android.view.MenuItem;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.wallet.ui.walletCardManagement.view.walletCardList.adapter.WalletCardListAdapter;

public final /* synthetic */ class b implements PopupMenu.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WalletCardListAdapter f24154a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f24155b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f24156c;

    public /* synthetic */ b(WalletCardListAdapter walletCardListAdapter, int i11, RecyclerView.ViewHolder viewHolder) {
        this.f24154a = walletCardListAdapter;
        this.f24155b = i11;
        this.f24156c = viewHolder;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return WalletCardListAdapter.m6049showPopup$lambda3(this.f24154a, this.f24155b, this.f24156c, menuItem);
    }
}
