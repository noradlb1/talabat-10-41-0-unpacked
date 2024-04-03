package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.customScrollingViews.CustomVerticalNestedScrollView;
import com.talabat.darkstores.common.view.GridSwimlaneView;
import com.talabat.darkstores.feature.home.banner.BannerView;
import com.talabat.darkstores.feature.home.tpro.TProView;
import com.talabat.feature.mission.control.presentation.LifeStyleMissionV2View;
import com.talabat.feature.mission.control.presentation.LifeStyleMissionView;
import com.talabat.feature.mission.control.presentation.PrimaryMissionView;
import com.talabat.feature.rewards.presentation.mission.RewardsMissionView;
import com.talabat.feature.swimlanevoucherslist.presentation.databinding.DarkstoresViewCustomerVouchersSwimlaneBinding;
import com.talabat.feature.tpro.presentation.databinding.TproSubscriptionHeaderBinding;

public final class DarkstoresFragmentHomeContentBinding implements ViewBinding {
    @NonNull
    public final BannerView banner;
    @NonNull
    public final CustomVerticalNestedScrollView darkstoreHomeContainer;
    @NonNull
    public final AppCompatTextView deliveryCampaignInfo;
    @NonNull
    public final LinearLayout deliveryCampaignRow;
    @NonNull
    public final GridSwimlaneView gridCategoriesSwimlane;
    @NonNull
    public final LinearLayout headerTitleSearch;
    @NonNull
    public final BannerView heroBanner;
    @NonNull
    public final RecyclerView homeRecyclerView;
    @NonNull
    public final LifeStyleMissionView lifeStyleMission;
    @NonNull
    public final LifeStyleMissionV2View lifeStyleMissionV2;
    @NonNull
    public final LinearLayout linearLayout;
    @NonNull
    public final LinearLayout midCompactSwimlanesContainer;
    @NonNull
    public final AppCompatImageView parallelBinImage;
    @NonNull
    public final PrimaryMissionView primaryMissionView;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    public final RewardsMissionView rewardsMissionView;
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final LinearLayout searchBottomView;
    @NonNull
    public final TproSubscriptionHeaderBinding subscriptionHeader;
    @NonNull
    public final TProView subscriptionHeaderTop;
    @NonNull
    public final LinearLayout swimlanesContainer;
    @NonNull
    public final View talabatAiBottomOffset;
    @NonNull
    public final ImageView talabatAiButton;
    @NonNull
    public final LinearLayout topCompactSwimlanesContainer;
    @NonNull
    public final DarkstoresViewCustomerVouchersSwimlaneBinding vouchersSwimlane;

    private DarkstoresFragmentHomeContentBinding(@NonNull FrameLayout frameLayout, @NonNull BannerView bannerView, @NonNull CustomVerticalNestedScrollView customVerticalNestedScrollView, @NonNull AppCompatTextView appCompatTextView, @NonNull LinearLayout linearLayout2, @NonNull GridSwimlaneView gridSwimlaneView, @NonNull LinearLayout linearLayout3, @NonNull BannerView bannerView2, @NonNull RecyclerView recyclerView, @NonNull LifeStyleMissionView lifeStyleMissionView, @NonNull LifeStyleMissionV2View lifeStyleMissionV2View, @NonNull LinearLayout linearLayout4, @NonNull LinearLayout linearLayout5, @NonNull AppCompatImageView appCompatImageView, @NonNull PrimaryMissionView primaryMissionView2, @NonNull ProgressBar progressBar2, @NonNull RewardsMissionView rewardsMissionView2, @NonNull LinearLayout linearLayout6, @NonNull TproSubscriptionHeaderBinding tproSubscriptionHeaderBinding, @NonNull TProView tProView, @NonNull LinearLayout linearLayout7, @NonNull View view, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout8, @NonNull DarkstoresViewCustomerVouchersSwimlaneBinding darkstoresViewCustomerVouchersSwimlaneBinding) {
        this.rootView = frameLayout;
        this.banner = bannerView;
        this.darkstoreHomeContainer = customVerticalNestedScrollView;
        this.deliveryCampaignInfo = appCompatTextView;
        this.deliveryCampaignRow = linearLayout2;
        this.gridCategoriesSwimlane = gridSwimlaneView;
        this.headerTitleSearch = linearLayout3;
        this.heroBanner = bannerView2;
        this.homeRecyclerView = recyclerView;
        this.lifeStyleMission = lifeStyleMissionView;
        this.lifeStyleMissionV2 = lifeStyleMissionV2View;
        this.linearLayout = linearLayout4;
        this.midCompactSwimlanesContainer = linearLayout5;
        this.parallelBinImage = appCompatImageView;
        this.primaryMissionView = primaryMissionView2;
        this.progressBar = progressBar2;
        this.rewardsMissionView = rewardsMissionView2;
        this.searchBottomView = linearLayout6;
        this.subscriptionHeader = tproSubscriptionHeaderBinding;
        this.subscriptionHeaderTop = tProView;
        this.swimlanesContainer = linearLayout7;
        this.talabatAiBottomOffset = view;
        this.talabatAiButton = imageView;
        this.topCompactSwimlanesContainer = linearLayout8;
        this.vouchersSwimlane = darkstoresViewCustomerVouchersSwimlaneBinding;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c3, code lost:
        r1 = com.talabat.darkstores.R.id.subscription_header;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e7, code lost:
        r1 = com.talabat.darkstores.R.id.talabatAiBottomOffset;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0107, code lost:
        r1 = com.talabat.darkstores.R.id.vouchers_swimlane;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.darkstores.databinding.DarkstoresFragmentHomeContentBinding bind(@androidx.annotation.NonNull android.view.View r29) {
        /*
            r0 = r29
            int r1 = com.talabat.darkstores.R.id.banner
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.talabat.darkstores.feature.home.banner.BannerView r5 = (com.talabat.darkstores.feature.home.banner.BannerView) r5
            if (r5 == 0) goto L_0x011d
            int r1 = com.talabat.darkstores.R.id.darkstore_home_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.talabat.darkstores.common.customScrollingViews.CustomVerticalNestedScrollView r6 = (com.talabat.darkstores.common.customScrollingViews.CustomVerticalNestedScrollView) r6
            if (r6 == 0) goto L_0x011d
            int r1 = com.talabat.darkstores.R.id.delivery_campaign_info
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            androidx.appcompat.widget.AppCompatTextView r7 = (androidx.appcompat.widget.AppCompatTextView) r7
            if (r7 == 0) goto L_0x011d
            int r1 = com.talabat.darkstores.R.id.delivery_campaign_row
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            if (r8 == 0) goto L_0x011d
            int r1 = com.talabat.darkstores.R.id.gridCategoriesSwimlane
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            com.talabat.darkstores.common.view.GridSwimlaneView r9 = (com.talabat.darkstores.common.view.GridSwimlaneView) r9
            if (r9 == 0) goto L_0x011d
            int r1 = com.talabat.darkstores.R.id.header_title_search
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            if (r10 == 0) goto L_0x011d
            int r1 = com.talabat.darkstores.R.id.heroBanner
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            com.talabat.darkstores.feature.home.banner.BannerView r11 = (com.talabat.darkstores.feature.home.banner.BannerView) r11
            if (r11 == 0) goto L_0x011d
            int r1 = com.talabat.darkstores.R.id.homeRecyclerView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            androidx.recyclerview.widget.RecyclerView r12 = (androidx.recyclerview.widget.RecyclerView) r12
            if (r12 == 0) goto L_0x011d
            int r1 = com.talabat.darkstores.R.id.lifeStyleMission
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            com.talabat.feature.mission.control.presentation.LifeStyleMissionView r13 = (com.talabat.feature.mission.control.presentation.LifeStyleMissionView) r13
            if (r13 == 0) goto L_0x011d
            int r1 = com.talabat.darkstores.R.id.lifeStyleMissionV2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            com.talabat.feature.mission.control.presentation.LifeStyleMissionV2View r14 = (com.talabat.feature.mission.control.presentation.LifeStyleMissionV2View) r14
            if (r14 == 0) goto L_0x011d
            int r1 = com.talabat.darkstores.R.id.linearLayout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.LinearLayout r15 = (android.widget.LinearLayout) r15
            if (r15 == 0) goto L_0x011d
            int r1 = com.talabat.darkstores.R.id.midCompactSwimlanesContainer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.LinearLayout r16 = (android.widget.LinearLayout) r16
            if (r16 == 0) goto L_0x011d
            int r1 = com.talabat.darkstores.R.id.parallel_bin_image
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            androidx.appcompat.widget.AppCompatImageView r17 = (androidx.appcompat.widget.AppCompatImageView) r17
            if (r17 == 0) goto L_0x011d
            int r1 = com.talabat.darkstores.R.id.primaryMissionView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            com.talabat.feature.mission.control.presentation.PrimaryMissionView r18 = (com.talabat.feature.mission.control.presentation.PrimaryMissionView) r18
            if (r18 == 0) goto L_0x011d
            int r1 = com.talabat.darkstores.R.id.progressBar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.ProgressBar r19 = (android.widget.ProgressBar) r19
            if (r19 == 0) goto L_0x011d
            int r1 = com.talabat.darkstores.R.id.rewardsMissionView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            com.talabat.feature.rewards.presentation.mission.RewardsMissionView r20 = (com.talabat.feature.rewards.presentation.mission.RewardsMissionView) r20
            if (r20 == 0) goto L_0x011d
            int r1 = com.talabat.darkstores.R.id.search_bottom_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.LinearLayout r21 = (android.widget.LinearLayout) r21
            if (r21 == 0) goto L_0x011d
            int r1 = com.talabat.darkstores.R.id.subscription_header
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x011d
            com.talabat.feature.tpro.presentation.databinding.TproSubscriptionHeaderBinding r22 = com.talabat.feature.tpro.presentation.databinding.TproSubscriptionHeaderBinding.bind(r2)
            int r1 = com.talabat.darkstores.R.id.subscription_header_top
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            com.talabat.darkstores.feature.home.tpro.TProView r23 = (com.talabat.darkstores.feature.home.tpro.TProView) r23
            if (r23 == 0) goto L_0x011d
            int r1 = com.talabat.darkstores.R.id.swimlanesContainer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            android.widget.LinearLayout r24 = (android.widget.LinearLayout) r24
            if (r24 == 0) goto L_0x011d
            int r1 = com.talabat.darkstores.R.id.talabatAiBottomOffset
            android.view.View r25 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r25 == 0) goto L_0x011d
            int r1 = com.talabat.darkstores.R.id.talabatAiButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            android.widget.ImageView r26 = (android.widget.ImageView) r26
            if (r26 == 0) goto L_0x011d
            int r1 = com.talabat.darkstores.R.id.topCompactSwimlanesContainer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            android.widget.LinearLayout r27 = (android.widget.LinearLayout) r27
            if (r27 == 0) goto L_0x011d
            int r1 = com.talabat.darkstores.R.id.vouchers_swimlane
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x011d
            com.talabat.feature.swimlanevoucherslist.presentation.databinding.DarkstoresViewCustomerVouchersSwimlaneBinding r28 = com.talabat.feature.swimlanevoucherslist.presentation.databinding.DarkstoresViewCustomerVouchersSwimlaneBinding.bind(r2)
            com.talabat.darkstores.databinding.DarkstoresFragmentHomeContentBinding r1 = new com.talabat.darkstores.databinding.DarkstoresFragmentHomeContentBinding
            r3 = r1
            r4 = r0
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return r1
        L_0x011d:
            android.content.res.Resources r0 = r29.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.databinding.DarkstoresFragmentHomeContentBinding.bind(android.view.View):com.talabat.darkstores.databinding.DarkstoresFragmentHomeContentBinding");
    }

    @NonNull
    public static DarkstoresFragmentHomeContentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresFragmentHomeContentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_fragment_home_content, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
