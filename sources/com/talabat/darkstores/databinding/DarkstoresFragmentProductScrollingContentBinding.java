package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.view.ExpandCollapseTextView;
import com.talabat.darkstores.common.view.SwimlaneView;
import com.talabat.darkstores.feature.product.imageSlider.ImageSliderView;
import com.talabat.darkstores.feature.product.views.AddToCartButton;
import com.talabat.darkstores.feature.product.views.BottomProductExtendedInfoView;
import com.talabat.darkstores.feature.product.views.CampaignProgressView;
import com.talabat.darkstores.feature.product.views.ProductTagsContainer;
import com.talabat.darkstores.feature.product.views.TopProductExtendedInfoView;

public final class DarkstoresFragmentProductScrollingContentBinding implements ViewBinding {
    @NonNull
    public final AddToCartButton addToCartButton;
    @NonNull
    public final BottomProductExtendedInfoView bottomExtendedInfo;
    @NonNull
    public final LinearLayout campaignContainer;
    @NonNull
    public final TextView campaignLabel;
    @NonNull
    public final CampaignProgressView campaignProgressView;
    @NonNull
    public final View emptyView;
    @NonNull
    public final ImageSliderView headerImageContainer;
    @NonNull
    public final CardView headerImageContainerOld;
    @NonNull
    public final ImageView imgProductPicture;
    @NonNull
    public final ConstraintLayout priceContainer;
    @NonNull
    public final TextView productAgeRestriction;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    private final NestedScrollView rootView;
    @NonNull
    public final ConstraintLayout scrollContainer;
    @NonNull
    public final TextView strikeThroughCampaignUsageLimit;
    @NonNull
    public final SwimlaneView suggestedProductsSwimlane;
    @NonNull
    public final ProductTagsContainer tagsContainerExt;
    @NonNull
    public final TopProductExtendedInfoView topExtendedInfo;
    @NonNull
    public final View topNormalView;
    @NonNull
    public final View topRoundedView;
    @NonNull
    public final Barrier topViewBarrier;
    @NonNull
    public final TextView tvPreviousPrice;
    @NonNull
    public final TextView tvPrice;
    @NonNull
    public final ExpandCollapseTextView tvProductDescription;
    @NonNull
    public final AppCompatTextView tvProductDescriptionStatic;
    @NonNull
    public final TextView tvProductName;

    private DarkstoresFragmentProductScrollingContentBinding(@NonNull NestedScrollView nestedScrollView, @NonNull AddToCartButton addToCartButton2, @NonNull BottomProductExtendedInfoView bottomProductExtendedInfoView, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull CampaignProgressView campaignProgressView2, @NonNull View view, @NonNull ImageSliderView imageSliderView, @NonNull CardView cardView, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout, @NonNull TextView textView2, @NonNull ProgressBar progressBar2, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView3, @NonNull SwimlaneView swimlaneView, @NonNull ProductTagsContainer productTagsContainer, @NonNull TopProductExtendedInfoView topProductExtendedInfoView, @NonNull View view2, @NonNull View view3, @NonNull Barrier barrier, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull ExpandCollapseTextView expandCollapseTextView, @NonNull AppCompatTextView appCompatTextView, @NonNull TextView textView6) {
        this.rootView = nestedScrollView;
        this.addToCartButton = addToCartButton2;
        this.bottomExtendedInfo = bottomProductExtendedInfoView;
        this.campaignContainer = linearLayout;
        this.campaignLabel = textView;
        this.campaignProgressView = campaignProgressView2;
        this.emptyView = view;
        this.headerImageContainer = imageSliderView;
        this.headerImageContainerOld = cardView;
        this.imgProductPicture = imageView;
        this.priceContainer = constraintLayout;
        this.productAgeRestriction = textView2;
        this.progressBar = progressBar2;
        this.scrollContainer = constraintLayout2;
        this.strikeThroughCampaignUsageLimit = textView3;
        this.suggestedProductsSwimlane = swimlaneView;
        this.tagsContainerExt = productTagsContainer;
        this.topExtendedInfo = topProductExtendedInfoView;
        this.topNormalView = view2;
        this.topRoundedView = view3;
        this.topViewBarrier = barrier;
        this.tvPreviousPrice = textView4;
        this.tvPrice = textView5;
        this.tvProductDescription = expandCollapseTextView;
        this.tvProductDescriptionStatic = appCompatTextView;
        this.tvProductName = textView6;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        r1 = com.talabat.darkstores.R.id.empty_view;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c0, code lost:
        r1 = com.talabat.darkstores.R.id.topNormalView;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c8, code lost:
        r1 = com.talabat.darkstores.R.id.topRoundedView;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.darkstores.databinding.DarkstoresFragmentProductScrollingContentBinding bind(@androidx.annotation.NonNull android.view.View r30) {
        /*
            r0 = r30
            int r1 = com.talabat.darkstores.R.id.addToCartButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.talabat.darkstores.feature.product.views.AddToCartButton r5 = (com.talabat.darkstores.feature.product.views.AddToCartButton) r5
            if (r5 == 0) goto L_0x0122
            int r1 = com.talabat.darkstores.R.id.bottomExtendedInfo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.talabat.darkstores.feature.product.views.BottomProductExtendedInfoView r6 = (com.talabat.darkstores.feature.product.views.BottomProductExtendedInfoView) r6
            if (r6 == 0) goto L_0x0122
            int r1 = com.talabat.darkstores.R.id.campaignContainer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            if (r7 == 0) goto L_0x0122
            int r1 = com.talabat.darkstores.R.id.campaignLabel
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0122
            int r1 = com.talabat.darkstores.R.id.campaignProgressView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            com.talabat.darkstores.feature.product.views.CampaignProgressView r9 = (com.talabat.darkstores.feature.product.views.CampaignProgressView) r9
            if (r9 == 0) goto L_0x0122
            int r1 = com.talabat.darkstores.R.id.empty_view
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r10 == 0) goto L_0x0122
            int r1 = com.talabat.darkstores.R.id.header_image_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            com.talabat.darkstores.feature.product.imageSlider.ImageSliderView r11 = (com.talabat.darkstores.feature.product.imageSlider.ImageSliderView) r11
            if (r11 == 0) goto L_0x0122
            int r1 = com.talabat.darkstores.R.id.header_image_containerOld
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            androidx.cardview.widget.CardView r12 = (androidx.cardview.widget.CardView) r12
            if (r12 == 0) goto L_0x0122
            int r1 = com.talabat.darkstores.R.id.imgProductPicture
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            if (r13 == 0) goto L_0x0122
            int r1 = com.talabat.darkstores.R.id.priceContainer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            if (r14 == 0) goto L_0x0122
            int r1 = com.talabat.darkstores.R.id.product_age_restriction
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x0122
            int r1 = com.talabat.darkstores.R.id.progressBar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.ProgressBar r16 = (android.widget.ProgressBar) r16
            if (r16 == 0) goto L_0x0122
            int r1 = com.talabat.darkstores.R.id.scrollContainer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            androidx.constraintlayout.widget.ConstraintLayout r17 = (androidx.constraintlayout.widget.ConstraintLayout) r17
            if (r17 == 0) goto L_0x0122
            int r1 = com.talabat.darkstores.R.id.strikeThroughCampaignUsageLimit
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x0122
            int r1 = com.talabat.darkstores.R.id.suggestedProductsSwimlane
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            com.talabat.darkstores.common.view.SwimlaneView r19 = (com.talabat.darkstores.common.view.SwimlaneView) r19
            if (r19 == 0) goto L_0x0122
            int r1 = com.talabat.darkstores.R.id.tagsContainerExt
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            com.talabat.darkstores.feature.product.views.ProductTagsContainer r20 = (com.talabat.darkstores.feature.product.views.ProductTagsContainer) r20
            if (r20 == 0) goto L_0x0122
            int r1 = com.talabat.darkstores.R.id.topExtendedInfo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            com.talabat.darkstores.feature.product.views.TopProductExtendedInfoView r21 = (com.talabat.darkstores.feature.product.views.TopProductExtendedInfoView) r21
            if (r21 == 0) goto L_0x0122
            int r1 = com.talabat.darkstores.R.id.topNormalView
            android.view.View r22 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r22 == 0) goto L_0x0122
            int r1 = com.talabat.darkstores.R.id.topRoundedView
            android.view.View r23 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r23 == 0) goto L_0x0122
            int r1 = com.talabat.darkstores.R.id.topViewBarrier
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            androidx.constraintlayout.widget.Barrier r24 = (androidx.constraintlayout.widget.Barrier) r24
            if (r24 == 0) goto L_0x0122
            int r1 = com.talabat.darkstores.R.id.tvPreviousPrice
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            android.widget.TextView r25 = (android.widget.TextView) r25
            if (r25 == 0) goto L_0x0122
            int r1 = com.talabat.darkstores.R.id.tvPrice
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            android.widget.TextView r26 = (android.widget.TextView) r26
            if (r26 == 0) goto L_0x0122
            int r1 = com.talabat.darkstores.R.id.tvProductDescription
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            com.talabat.darkstores.common.view.ExpandCollapseTextView r27 = (com.talabat.darkstores.common.view.ExpandCollapseTextView) r27
            if (r27 == 0) goto L_0x0122
            int r1 = com.talabat.darkstores.R.id.tvProductDescriptionStatic
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r28 = r2
            androidx.appcompat.widget.AppCompatTextView r28 = (androidx.appcompat.widget.AppCompatTextView) r28
            if (r28 == 0) goto L_0x0122
            int r1 = com.talabat.darkstores.R.id.tvProductName
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r29 = r2
            android.widget.TextView r29 = (android.widget.TextView) r29
            if (r29 == 0) goto L_0x0122
            com.talabat.darkstores.databinding.DarkstoresFragmentProductScrollingContentBinding r1 = new com.talabat.darkstores.databinding.DarkstoresFragmentProductScrollingContentBinding
            r3 = r1
            r4 = r0
            androidx.core.widget.NestedScrollView r4 = (androidx.core.widget.NestedScrollView) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            return r1
        L_0x0122:
            android.content.res.Resources r0 = r30.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.databinding.DarkstoresFragmentProductScrollingContentBinding.bind(android.view.View):com.talabat.darkstores.databinding.DarkstoresFragmentProductScrollingContentBinding");
    }

    @NonNull
    public static DarkstoresFragmentProductScrollingContentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresFragmentProductScrollingContentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_fragment_product_scrolling_content, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public NestedScrollView getRoot() {
        return this.rootView;
    }
}
