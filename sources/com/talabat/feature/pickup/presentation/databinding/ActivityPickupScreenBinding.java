package com.talabat.feature.pickup.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.designsystem.ds_small_button.DSSecondarySmallButton;
import com.talabat.cuisines.navigation.CuisineView;
import com.talabat.feature.pickup.presentation.R;
import com.talabat.feature.pickup.presentation.customview.ShimmerView;
import com.talabat.talabatcommon.views.tabBarWithTag.TabBarWithTagView;

public final class ActivityPickupScreenBinding implements ViewBinding {
    @NonNull
    public final ImageButton backButton;
    @NonNull
    public final ConnectionErrorLayoutBinding connectionErrorView;
    @NonNull
    public final CuisineView cuisineViewLayout;
    @NonNull
    public final View filtersBottomSeparator;
    @NonNull
    public final View filtersTopSeparator;
    @NonNull
    public final ImageView imageViewNoRestaurants;
    @NonNull
    public final LinearLayout linearLayoutFiltersContainer;
    @NonNull
    public final LinearLayout linearLayoutSearchButton;
    @NonNull
    public final TabBarWithTagView orderModeTabBar;
    @NonNull
    public final ConstraintLayout pickupCoordinator;
    @NonNull
    public final RecyclerView pickupRecycler;
    @NonNull
    public final Toolbar pickupToolbar;
    @NonNull
    public final ShimmerView progressShimmer;
    @NonNull
    public final DSSecondarySmallButton resetFiltersBtn;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final LinearLayout scrollViewNoRestaurantsContainer;

    private ActivityPickupScreenBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageButton imageButton, @NonNull ConnectionErrorLayoutBinding connectionErrorLayoutBinding, @NonNull CuisineView cuisineView, @NonNull View view, @NonNull View view2, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TabBarWithTagView tabBarWithTagView, @NonNull ConstraintLayout constraintLayout2, @NonNull RecyclerView recyclerView, @NonNull Toolbar toolbar, @NonNull ShimmerView shimmerView, @NonNull DSSecondarySmallButton dSSecondarySmallButton, @NonNull LinearLayout linearLayout3) {
        this.rootView = constraintLayout;
        this.backButton = imageButton;
        this.connectionErrorView = connectionErrorLayoutBinding;
        this.cuisineViewLayout = cuisineView;
        this.filtersBottomSeparator = view;
        this.filtersTopSeparator = view2;
        this.imageViewNoRestaurants = imageView;
        this.linearLayoutFiltersContainer = linearLayout;
        this.linearLayoutSearchButton = linearLayout2;
        this.orderModeTabBar = tabBarWithTagView;
        this.pickupCoordinator = constraintLayout2;
        this.pickupRecycler = recyclerView;
        this.pickupToolbar = toolbar;
        this.progressShimmer = shimmerView;
        this.resetFiltersBtn = dSSecondarySmallButton;
        this.scrollViewNoRestaurantsContainer = linearLayout3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = com.talabat.feature.pickup.presentation.R.id.connectionErrorView;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        r1 = com.talabat.feature.pickup.presentation.R.id.filtersBottomSeparator;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r1 = com.talabat.feature.pickup.presentation.R.id.filtersTopSeparator;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.feature.pickup.presentation.databinding.ActivityPickupScreenBinding bind(@androidx.annotation.NonNull android.view.View r20) {
        /*
            r0 = r20
            int r1 = com.talabat.feature.pickup.presentation.R.id.backButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.ImageButton r5 = (android.widget.ImageButton) r5
            if (r5 == 0) goto L_0x00a6
            int r1 = com.talabat.feature.pickup.presentation.R.id.connectionErrorView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x00a6
            com.talabat.feature.pickup.presentation.databinding.ConnectionErrorLayoutBinding r6 = com.talabat.feature.pickup.presentation.databinding.ConnectionErrorLayoutBinding.bind(r2)
            int r1 = com.talabat.feature.pickup.presentation.R.id.cuisineViewLayout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            com.talabat.cuisines.navigation.CuisineView r7 = (com.talabat.cuisines.navigation.CuisineView) r7
            if (r7 == 0) goto L_0x00a6
            int r1 = com.talabat.feature.pickup.presentation.R.id.filtersBottomSeparator
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r8 == 0) goto L_0x00a6
            int r1 = com.talabat.feature.pickup.presentation.R.id.filtersTopSeparator
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r9 == 0) goto L_0x00a6
            int r1 = com.talabat.feature.pickup.presentation.R.id.imageView_noRestaurants
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00a6
            int r1 = com.talabat.feature.pickup.presentation.R.id.linearLayout_filtersContainer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            if (r11 == 0) goto L_0x00a6
            int r1 = com.talabat.feature.pickup.presentation.R.id.linearLayout_searchButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            if (r12 == 0) goto L_0x00a6
            int r1 = com.talabat.feature.pickup.presentation.R.id.orderModeTabBar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            com.talabat.talabatcommon.views.tabBarWithTag.TabBarWithTagView r13 = (com.talabat.talabatcommon.views.tabBarWithTag.TabBarWithTagView) r13
            if (r13 == 0) goto L_0x00a6
            r14 = r0
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            int r1 = com.talabat.feature.pickup.presentation.R.id.pickupRecycler
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            androidx.recyclerview.widget.RecyclerView r15 = (androidx.recyclerview.widget.RecyclerView) r15
            if (r15 == 0) goto L_0x00a6
            int r1 = com.talabat.feature.pickup.presentation.R.id.pickupToolbar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            androidx.appcompat.widget.Toolbar r16 = (androidx.appcompat.widget.Toolbar) r16
            if (r16 == 0) goto L_0x00a6
            int r1 = com.talabat.feature.pickup.presentation.R.id.progressShimmer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            com.talabat.feature.pickup.presentation.customview.ShimmerView r17 = (com.talabat.feature.pickup.presentation.customview.ShimmerView) r17
            if (r17 == 0) goto L_0x00a6
            int r1 = com.talabat.feature.pickup.presentation.R.id.resetFiltersBtn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            com.designsystem.ds_small_button.DSSecondarySmallButton r18 = (com.designsystem.ds_small_button.DSSecondarySmallButton) r18
            if (r18 == 0) goto L_0x00a6
            int r1 = com.talabat.feature.pickup.presentation.R.id.scrollView_noRestaurantsContainer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.LinearLayout r19 = (android.widget.LinearLayout) r19
            if (r19 == 0) goto L_0x00a6
            com.talabat.feature.pickup.presentation.databinding.ActivityPickupScreenBinding r0 = new com.talabat.feature.pickup.presentation.databinding.ActivityPickupScreenBinding
            r3 = r0
            r4 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r0
        L_0x00a6:
            android.content.res.Resources r0 = r20.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.pickup.presentation.databinding.ActivityPickupScreenBinding.bind(android.view.View):com.talabat.feature.pickup.presentation.databinding.ActivityPickupScreenBinding");
    }

    @NonNull
    public static ActivityPickupScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityPickupScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_pickup_screen, viewGroup, false);
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
