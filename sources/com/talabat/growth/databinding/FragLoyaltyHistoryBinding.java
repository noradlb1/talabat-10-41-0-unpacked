package com.talabat.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_empty_state_v2.DSEmptyState;
import com.designsystem.ds_navigation_bar.DSNavigationBar;
import com.designsystem.ds_tabs.DSTabBar;
import com.talabat.growth.R;
import com.talabat.growth.ui.loyalty.views.LoyaltyPointsSummaryView;

public final class FragLoyaltyHistoryBinding implements ViewBinding {
    @NonNull
    public final DSEmptyState loyaltyHistoryEmptyView;
    @NonNull
    public final RecyclerView loyaltyHistoryRecyclerView;
    @NonNull
    public final LoyaltyPointsSummaryView loyaltyHistorySummaryView;
    @NonNull
    public final DSNavigationBar loyaltyPointsHistoryNavigationBar;
    @NonNull
    public final DSTabBar pointsHistoryTabs;
    @NonNull
    private final RelativeLayout rootView;

    private FragLoyaltyHistoryBinding(@NonNull RelativeLayout relativeLayout, @NonNull DSEmptyState dSEmptyState, @NonNull RecyclerView recyclerView, @NonNull LoyaltyPointsSummaryView loyaltyPointsSummaryView, @NonNull DSNavigationBar dSNavigationBar, @NonNull DSTabBar dSTabBar) {
        this.rootView = relativeLayout;
        this.loyaltyHistoryEmptyView = dSEmptyState;
        this.loyaltyHistoryRecyclerView = recyclerView;
        this.loyaltyHistorySummaryView = loyaltyPointsSummaryView;
        this.loyaltyPointsHistoryNavigationBar = dSNavigationBar;
        this.pointsHistoryTabs = dSTabBar;
    }

    @NonNull
    public static FragLoyaltyHistoryBinding bind(@NonNull View view) {
        int i11 = R.id.loyaltyHistoryEmptyView;
        DSEmptyState dSEmptyState = (DSEmptyState) ViewBindings.findChildViewById(view, i11);
        if (dSEmptyState != null) {
            i11 = R.id.loyaltyHistoryRecyclerView;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
            if (recyclerView != null) {
                i11 = R.id.loyaltyHistorySummaryView;
                LoyaltyPointsSummaryView loyaltyPointsSummaryView = (LoyaltyPointsSummaryView) ViewBindings.findChildViewById(view, i11);
                if (loyaltyPointsSummaryView != null) {
                    i11 = R.id.loyaltyPointsHistoryNavigationBar;
                    DSNavigationBar dSNavigationBar = (DSNavigationBar) ViewBindings.findChildViewById(view, i11);
                    if (dSNavigationBar != null) {
                        i11 = R.id.pointsHistoryTabs;
                        DSTabBar dSTabBar = (DSTabBar) ViewBindings.findChildViewById(view, i11);
                        if (dSTabBar != null) {
                            return new FragLoyaltyHistoryBinding((RelativeLayout) view, dSEmptyState, recyclerView, loyaltyPointsSummaryView, dSNavigationBar, dSTabBar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragLoyaltyHistoryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragLoyaltyHistoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.frag_loyalty_history, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
