package com.talabat.homescreen.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.growth.ui.vouchers.entrypoint.HomeScreenHeaderVouchersView;
import com.talabat.homescreen.R;
import com.talabat.homescreen.widget.HomeScreenHeaderRewardsView;

public final class HomeScreenHeaderBinding implements ViewBinding {
    @NonNull
    public final Barrier actionButtonBarrier;
    @NonNull
    public final ConstraintLayout actionButtonContainer;
    @NonNull
    public final ConstraintLayout addressContainer;
    @NonNull
    public final LinearLayout addressTextContainer;
    @NonNull
    public final ConstraintLayout basketContainer;
    @NonNull
    public final AppCompatTextView captionTextView;
    @NonNull
    public final AppCompatTextView cartCountTextView;
    @NonNull
    public final LinearLayout cartCountTextViewContainer;
    @NonNull
    public final RelativeLayout entryPointContainer;
    @NonNull
    public final ConstraintLayout fluidHomeToolbar;
    @NonNull
    public final AppCompatImageView ivHomeToolbarCart;
    @NonNull
    public final AppCompatImageView ivToolbarAddressArrow;
    @NonNull
    public final HomeScreenHeaderRewardsView rewards;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final AppCompatTextView tvToolbarAddressDelivery;
    @NonNull
    public final HomeScreenHeaderVouchersView vouchersEntryPoint;

    private HomeScreenHeaderBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Barrier barrier, @NonNull ConstraintLayout constraintLayout2, @NonNull ConstraintLayout constraintLayout3, @NonNull LinearLayout linearLayout, @NonNull ConstraintLayout constraintLayout4, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull LinearLayout linearLayout2, @NonNull RelativeLayout relativeLayout, @NonNull ConstraintLayout constraintLayout5, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull HomeScreenHeaderRewardsView homeScreenHeaderRewardsView, @NonNull AppCompatTextView appCompatTextView3, @NonNull HomeScreenHeaderVouchersView homeScreenHeaderVouchersView) {
        this.rootView = constraintLayout;
        this.actionButtonBarrier = barrier;
        this.actionButtonContainer = constraintLayout2;
        this.addressContainer = constraintLayout3;
        this.addressTextContainer = linearLayout;
        this.basketContainer = constraintLayout4;
        this.captionTextView = appCompatTextView;
        this.cartCountTextView = appCompatTextView2;
        this.cartCountTextViewContainer = linearLayout2;
        this.entryPointContainer = relativeLayout;
        this.fluidHomeToolbar = constraintLayout5;
        this.ivHomeToolbarCart = appCompatImageView;
        this.ivToolbarAddressArrow = appCompatImageView2;
        this.rewards = homeScreenHeaderRewardsView;
        this.tvToolbarAddressDelivery = appCompatTextView3;
        this.vouchersEntryPoint = homeScreenHeaderVouchersView;
    }

    @NonNull
    public static HomeScreenHeaderBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.actionButtonBarrier;
        Barrier barrier = (Barrier) ViewBindings.findChildViewById(view2, i11);
        if (barrier != null) {
            i11 = R.id.actionButtonContainer;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i11);
            if (constraintLayout != null) {
                i11 = R.id.addressContainer;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i11);
                if (constraintLayout2 != null) {
                    i11 = R.id.address_text_container;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i11);
                    if (linearLayout != null) {
                        i11 = R.id.basket_container;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i11);
                        if (constraintLayout3 != null) {
                            i11 = R.id.captionTextView;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view2, i11);
                            if (appCompatTextView != null) {
                                i11 = R.id.cartCountTextView;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view2, i11);
                                if (appCompatTextView2 != null) {
                                    i11 = R.id.cartCountTextViewContainer;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, i11);
                                    if (linearLayout2 != null) {
                                        i11 = R.id.entry_point_container;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, i11);
                                        if (relativeLayout != null) {
                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) view2;
                                            i11 = R.id.ivHomeToolbarCart;
                                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view2, i11);
                                            if (appCompatImageView != null) {
                                                i11 = R.id.ivToolbarAddressArrow;
                                                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view2, i11);
                                                if (appCompatImageView2 != null) {
                                                    i11 = R.id.rewards;
                                                    HomeScreenHeaderRewardsView homeScreenHeaderRewardsView = (HomeScreenHeaderRewardsView) ViewBindings.findChildViewById(view2, i11);
                                                    if (homeScreenHeaderRewardsView != null) {
                                                        i11 = R.id.tvToolbarAddressDelivery;
                                                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(view2, i11);
                                                        if (appCompatTextView3 != null) {
                                                            i11 = R.id.vouchersEntryPoint;
                                                            HomeScreenHeaderVouchersView homeScreenHeaderVouchersView = (HomeScreenHeaderVouchersView) ViewBindings.findChildViewById(view2, i11);
                                                            if (homeScreenHeaderVouchersView != null) {
                                                                return new HomeScreenHeaderBinding(constraintLayout4, barrier, constraintLayout, constraintLayout2, linearLayout, constraintLayout3, appCompatTextView, appCompatTextView2, linearLayout2, relativeLayout, constraintLayout4, appCompatImageView, appCompatImageView2, homeScreenHeaderRewardsView, appCompatTextView3, homeScreenHeaderVouchersView);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static HomeScreenHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static HomeScreenHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.home_screen_header, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
