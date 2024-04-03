package com.talabat.wallet.ui.walletDashboard.view;

import androidx.recyclerview.widget.RecyclerView;
import com.talabat.talabatcommon.listeners.EndlessScrollListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/talabat/wallet/ui/walletDashboard/view/WalletDashboardFragment$addEndlessScrollListener$1$1", "Lcom/talabat/talabatcommon/listeners/EndlessScrollListener;", "onLoadMore", "", "currentPage", "", "totalItemCount", "onScroll", "firstVisibleItem", "dy", "scrollPosition", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletDashboardFragment$addEndlessScrollListener$1$1 extends EndlessScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WalletDashboardFragment f12749a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDashboardFragment$addEndlessScrollListener$1$1(RecyclerView.LayoutManager layoutManager, WalletDashboardFragment walletDashboardFragment) {
        super(layoutManager);
        this.f12749a = walletDashboardFragment;
        Intrinsics.checkNotNullExpressionValue(layoutManager, "it");
    }

    public void onLoadMore(int i11, int i12) {
        if (i12 > 0) {
            this.f12749a.showProgress();
            WalletDashboardFragment walletDashboardFragment = this.f12749a;
            walletDashboardFragment.pageNumber = walletDashboardFragment.pageNumber + 1;
            WalletDashboardFragment.access$getViewModel(this.f12749a).getWalletTransactionList(this.f12749a.getConfigurationLocalRepository().selectedCountry().getCountryId(), this.f12749a.numberOfItemsPerPage, this.f12749a.pageNumber * this.f12749a.numberOfItemsPerPage);
        }
    }

    public void onScroll(int i11, int i12, int i13) {
    }
}
