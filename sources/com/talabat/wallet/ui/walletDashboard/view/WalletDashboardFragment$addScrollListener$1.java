package com.talabat.wallet.ui.walletDashboard.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.wallet.R;
import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDataItemDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/talabat/wallet/ui/walletDashboard/view/WalletDashboardFragment$addScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletDashboardFragment$addScrollListener$1 extends RecyclerView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WalletDashboardFragment f12751a;

    public WalletDashboardFragment$addScrollListener$1(WalletDashboardFragment walletDashboardFragment) {
        this.f12751a = walletDashboardFragment;
    }

    public void onScrolled(@NotNull RecyclerView recyclerView, int i11, int i12) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            ((SwipeRefreshLayout) this.f12751a._$_findCachedViewById(R.id.swipeRefresh)).setRefreshing(false);
            if (findFirstVisibleItemPosition > 0 && (this.f12751a.getTransactionListAdapter().getItems().get(findFirstVisibleItemPosition) instanceof WalletTransactionListDataItemDisplayModel.TransactionGroupHeaderModel)) {
                this.f12751a.addAppBarInfo(((WalletTransactionListDataItemDisplayModel.TransactionGroupHeaderModel) this.f12751a.getTransactionListAdapter().getItems().get(findFirstVisibleItemPosition)).getDate());
            } else if (findFirstVisibleItemPosition <= 0 || !(this.f12751a.getTransactionListAdapter().getItems().get(findFirstVisibleItemPosition) instanceof WalletTransactionListDataItemDisplayModel.TransactionDisplayModel)) {
                LogManager.debug("unsupported view type");
            } else {
                this.f12751a.addAppBarInfo(((WalletTransactionListDataItemDisplayModel.TransactionDisplayModel) this.f12751a.getTransactionListAdapter().getItems().get(findFirstVisibleItemPosition)).getDate());
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
    }
}
