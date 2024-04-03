package com.talabat.wallet.screens.walletDashboard.view;

import androidx.recyclerview.widget.RecyclerView;
import com.talabat.wallet.screens.walletDashboard.presenter.WalletTransactionDashboardScreenPresenter;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/talabat/wallet/screens/walletDashboard/view/WalletTransactionDashboardScreen$addEndlessScollListener$1", "Lcom/talabat/wallet/screens/walletDashboard/view/EndlessScrollListener;", "onLoadMore", "", "currentPage", "", "totalItemCount", "onScroll", "firstVisibleItem", "dy", "scrollPosition", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDashboardScreen$addEndlessScollListener$1 extends EndlessScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WalletTransactionDashboardScreen f12685a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletTransactionDashboardScreen$addEndlessScollListener$1(WalletTransactionDashboardScreen walletTransactionDashboardScreen, RecyclerView.LayoutManager layoutManager) {
        super(layoutManager);
        this.f12685a = walletTransactionDashboardScreen;
    }

    public void onLoadMore(int i11, int i12) {
        if (i12 > 0) {
            WalletTransactionDashboardScreen walletTransactionDashboardScreen = this.f12685a;
            walletTransactionDashboardScreen.pageNumber = walletTransactionDashboardScreen.pageNumber + 1;
            WalletTransactionDashboardScreenPresenter access$getMWalletTransactionDashboardScreenPresenter$p = this.f12685a.mWalletTransactionDashboardScreenPresenter;
            if (access$getMWalletTransactionDashboardScreenPresenter$p != null) {
                access$getMWalletTransactionDashboardScreenPresenter$p.setWalletTransactionListInfo(this.f12685a.pageNumber, this.f12685a.numberOfItemsPerPage, this.f12685a.lastItem);
            }
        }
    }

    public void onScroll(int i11, int i12, int i13) {
    }
}
