package com.talabat.wallet.screens.walletDashboard.view;

import JsonModels.Response.WalletTransactionListDataItem;
import android.content.res.Resources;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.talabat.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/talabat/wallet/screens/walletDashboard/view/WalletTransactionDashboardScreen$addScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDashboardScreen$addScrollListener$1 extends RecyclerView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WalletTransactionDashboardScreen f12686a;

    public WalletTransactionDashboardScreen$addScrollListener$1(WalletTransactionDashboardScreen walletTransactionDashboardScreen) {
        this.f12686a = walletTransactionDashboardScreen;
    }

    public void onScrolled(@NotNull RecyclerView recyclerView, int i11, int i12) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            ((SwipeRefreshLayout) this.f12686a._$_findCachedViewById(R.id.swipeRefresh)).setRefreshing(false);
            if (findFirstVisibleItemPosition > 0 && (this.f12686a.getAdapter().getItem().get(findFirstVisibleItemPosition) instanceof WalletTransactionListDataItem.Header)) {
                String date = ((WalletTransactionListDataItem.Header) this.f12686a.getAdapter().getItem().get(findFirstVisibleItemPosition)).getDate();
                Intrinsics.checkNotNull(date);
                Resources resources = this.f12686a.getResources();
                WalletTransactionDashboardScreen walletTransactionDashboardScreen = this.f12686a;
                ((TextView) this.f12686a._$_findCachedViewById(R.id.sticky_toolbar_spent_in_month_string_text_view)).setText(resources.getString(R.string.spent_in_month_string, new Object[]{walletTransactionDashboardScreen.dateFormatter(date, walletTransactionDashboardScreen.DATE_INPUT_FORMAT, this.f12686a.DATE_OUTPUT_FORMAT)}));
                WalletTransactionDashboardScreen walletTransactionDashboardScreen2 = this.f12686a;
                ((TextView) this.f12686a._$_findCachedViewById(R.id.sticky_toolbar_spent_in_month_amount_text_view)).setText(walletTransactionDashboardScreen2.getAmountWithoutCurrency((Float) walletTransactionDashboardScreen2.monthAndAmountMap.get(this.f12686a.getMonthAndYearForMapingAndGrouping(date))));
            } else if (findFirstVisibleItemPosition > 0 && (this.f12686a.getAdapter().getItem().get(findFirstVisibleItemPosition) instanceof WalletTransactionListDataItem.TransactionModel)) {
                String date2 = ((WalletTransactionListDataItem.TransactionModel) this.f12686a.getAdapter().getItem().get(findFirstVisibleItemPosition)).getDate();
                Intrinsics.checkNotNull(date2);
                Resources resources2 = this.f12686a.getResources();
                WalletTransactionDashboardScreen walletTransactionDashboardScreen3 = this.f12686a;
                ((TextView) this.f12686a._$_findCachedViewById(R.id.sticky_toolbar_spent_in_month_string_text_view)).setText(resources2.getString(R.string.spent_in_month_string, new Object[]{walletTransactionDashboardScreen3.dateFormatter(date2, walletTransactionDashboardScreen3.DATE_INPUT_FORMAT, this.f12686a.DATE_OUTPUT_FORMAT)}));
                WalletTransactionDashboardScreen walletTransactionDashboardScreen4 = this.f12686a;
                ((TextView) this.f12686a._$_findCachedViewById(R.id.sticky_toolbar_spent_in_month_amount_text_view)).setText(walletTransactionDashboardScreen4.getAmountWithoutCurrency((Float) walletTransactionDashboardScreen4.monthAndAmountMap.get(this.f12686a.getMonthAndYearForMapingAndGrouping(date2))));
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
    }
}
