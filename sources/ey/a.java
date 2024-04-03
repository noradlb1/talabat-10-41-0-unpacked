package ey;

import android.view.MenuItem;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.wallet.screens.walletManageCard.view.WalletManageCreditCardsAdapter;

public final /* synthetic */ class a implements PopupMenu.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WalletManageCreditCardsAdapter f14029a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f14030b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f14031c;

    public /* synthetic */ a(WalletManageCreditCardsAdapter walletManageCreditCardsAdapter, int i11, RecyclerView.ViewHolder viewHolder) {
        this.f14029a = walletManageCreditCardsAdapter;
        this.f14030b = i11;
        this.f14031c = viewHolder;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return WalletManageCreditCardsAdapter.m5985showPopup$lambda4(this.f14029a, this.f14030b, this.f14031c, menuItem);
    }
}
