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
import com.talabat.feature.referafriend.presentation.ui.PromoCodeBannerView;
import com.talabat.growth.R;

public final class FragVoucherListBinding implements ViewBinding {
    @NonNull
    public final PromoCodeBannerView getACodeComponentView;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final DSNavigationBar vouchersListNavigationBar;
    @NonNull
    public final RecyclerView vouchersListRecyclerView;
    @NonNull
    public final DSEmptyState vouchersNoResultFoundLinearLayout;
    @NonNull
    public final DSTabBar vouchersTabs;

    private FragVoucherListBinding(@NonNull RelativeLayout relativeLayout, @NonNull PromoCodeBannerView promoCodeBannerView, @NonNull DSNavigationBar dSNavigationBar, @NonNull RecyclerView recyclerView, @NonNull DSEmptyState dSEmptyState, @NonNull DSTabBar dSTabBar) {
        this.rootView = relativeLayout;
        this.getACodeComponentView = promoCodeBannerView;
        this.vouchersListNavigationBar = dSNavigationBar;
        this.vouchersListRecyclerView = recyclerView;
        this.vouchersNoResultFoundLinearLayout = dSEmptyState;
        this.vouchersTabs = dSTabBar;
    }

    @NonNull
    public static FragVoucherListBinding bind(@NonNull View view) {
        int i11 = R.id.getACodeComponentView;
        PromoCodeBannerView promoCodeBannerView = (PromoCodeBannerView) ViewBindings.findChildViewById(view, i11);
        if (promoCodeBannerView != null) {
            i11 = R.id.vouchersListNavigationBar;
            DSNavigationBar dSNavigationBar = (DSNavigationBar) ViewBindings.findChildViewById(view, i11);
            if (dSNavigationBar != null) {
                i11 = R.id.vouchersListRecyclerView;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
                if (recyclerView != null) {
                    i11 = R.id.vouchersNoResultFoundLinearLayout;
                    DSEmptyState dSEmptyState = (DSEmptyState) ViewBindings.findChildViewById(view, i11);
                    if (dSEmptyState != null) {
                        i11 = R.id.vouchersTabs;
                        DSTabBar dSTabBar = (DSTabBar) ViewBindings.findChildViewById(view, i11);
                        if (dSTabBar != null) {
                            return new FragVoucherListBinding((RelativeLayout) view, promoCodeBannerView, dSNavigationBar, recyclerView, dSEmptyState, dSTabBar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragVoucherListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragVoucherListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.frag_voucher_list, viewGroup, false);
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
