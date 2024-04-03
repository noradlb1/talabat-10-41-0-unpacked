package com.talabat.wallet.ui.walletDashboard.view;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.talabat.wallet.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"com/talabat/wallet/ui/walletDashboard/view/WalletDashboardFragment$addAppBarOffsetChangedListener$1", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "isToolbarShown", "", "()Z", "setToolbarShown", "(Z)V", "scrollRange", "", "getScrollRange", "()I", "setScrollRange", "(I)V", "onOffsetChanged", "", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "verticalOffset", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletDashboardFragment$addAppBarOffsetChangedListener$1 implements AppBarLayout.OnOffsetChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WalletDashboardFragment f12747a;
    private boolean isToolbarShown;
    private int scrollRange = -1;

    public WalletDashboardFragment$addAppBarOffsetChangedListener$1(WalletDashboardFragment walletDashboardFragment) {
        this.f12747a = walletDashboardFragment;
    }

    public final int getScrollRange() {
        return this.scrollRange;
    }

    public final boolean isToolbarShown() {
        return this.isToolbarShown;
    }

    public void onOffsetChanged(@NotNull AppBarLayout appBarLayout, int i11) {
        Intrinsics.checkNotNullParameter(appBarLayout, "appBarLayout");
        float totalScrollRange = ((float) (i11 * -1)) / ((float) appBarLayout.getTotalScrollRange());
        if (this.scrollRange == -1) {
            this.scrollRange = appBarLayout.getTotalScrollRange();
        }
        boolean z11 = true;
        if (this.scrollRange + i11 == 0) {
            this.isToolbarShown = true;
            this.f12747a.showStickyBar();
        } else if (this.isToolbarShown) {
            this.f12747a.hideStickyBar();
        }
        this.f12747a.adjustAppBarChildrenViewsAlpha(totalScrollRange);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.f12747a._$_findCachedViewById(R.id.swipeRefresh);
        if (i11 != 0 || WalletDashboardFragment.access$getViewModel(this.f12747a).isFirstResponse()) {
            z11 = false;
        }
        swipeRefreshLayout.setEnabled(z11);
    }

    public final void setScrollRange(int i11) {
        this.scrollRange = i11;
    }

    public final void setToolbarShown(boolean z11) {
        this.isToolbarShown = z11;
    }
}
