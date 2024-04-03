package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.designsystem.ds_stepper.DSCollapsibleQuantityStepper;
import com.google.android.material.imageview.ShapeableImageView;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.view.ItemCounterNew;
import com.talabat.talabatcommon.views.ShimmerLayout;

public final class DarkstoresProductTileNewBinding implements ViewBinding {
    @NonNull
    public final ShimmerLayout loadingMask;
    @NonNull
    public final ViewSponsoredChipBinding productSponsorTag;
    @NonNull
    public final TextView productTileAgeRestriction;
    @NonNull
    public final PromoTagBinding productTileCampaign;
    @NonNull
    public final ItemCounterNew productTileCounter;
    @NonNull
    public final DSCollapsibleQuantityStepper productTileCounterDs;
    @NonNull
    public final ShapeableImageView productTileImage;
    @NonNull
    public final FrameLayout productTileImageContainer;
    @NonNull
    public final TextView productTileName;
    @NonNull
    public final TextView productTileOldPrice;
    @NonNull
    public final TextView productTileOutOfStock;
    @NonNull
    public final TextView productTilePrice;
    @NonNull
    public final ConstraintLayout productTileRoot;
    @NonNull
    public final TextView productTileUsageLabel;
    @NonNull
    private final ConstraintLayout rootView;

    private DarkstoresProductTileNewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ShimmerLayout shimmerLayout, @NonNull ViewSponsoredChipBinding viewSponsoredChipBinding, @NonNull TextView textView, @NonNull PromoTagBinding promoTagBinding, @NonNull ItemCounterNew itemCounterNew, @NonNull DSCollapsibleQuantityStepper dSCollapsibleQuantityStepper, @NonNull ShapeableImageView shapeableImageView, @NonNull FrameLayout frameLayout, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView6) {
        this.rootView = constraintLayout;
        this.loadingMask = shimmerLayout;
        this.productSponsorTag = viewSponsoredChipBinding;
        this.productTileAgeRestriction = textView;
        this.productTileCampaign = promoTagBinding;
        this.productTileCounter = itemCounterNew;
        this.productTileCounterDs = dSCollapsibleQuantityStepper;
        this.productTileImage = shapeableImageView;
        this.productTileImageContainer = frameLayout;
        this.productTileName = textView2;
        this.productTileOldPrice = textView3;
        this.productTileOutOfStock = textView4;
        this.productTilePrice = textView5;
        this.productTileRoot = constraintLayout2;
        this.productTileUsageLabel = textView6;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = com.talabat.darkstores.R.id.product_sponsor_tag;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        r1 = com.talabat.darkstores.R.id.product_tile_campaign;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.darkstores.databinding.DarkstoresProductTileNewBinding bind(@androidx.annotation.NonNull android.view.View r19) {
        /*
            r0 = r19
            int r1 = com.talabat.darkstores.R.id.loading_mask
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.talabat.talabatcommon.views.ShimmerLayout r5 = (com.talabat.talabatcommon.views.ShimmerLayout) r5
            if (r5 == 0) goto L_0x00a2
            int r1 = com.talabat.darkstores.R.id.product_sponsor_tag
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x00a2
            com.talabat.darkstores.databinding.ViewSponsoredChipBinding r6 = com.talabat.darkstores.databinding.ViewSponsoredChipBinding.bind(r2)
            int r1 = com.talabat.darkstores.R.id.product_tile_age_restriction
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x00a2
            int r1 = com.talabat.darkstores.R.id.product_tile_campaign
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x00a2
            com.talabat.darkstores.databinding.PromoTagBinding r8 = com.talabat.darkstores.databinding.PromoTagBinding.bind(r2)
            int r1 = com.talabat.darkstores.R.id.product_tile_counter
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            com.talabat.darkstores.common.view.ItemCounterNew r9 = (com.talabat.darkstores.common.view.ItemCounterNew) r9
            if (r9 == 0) goto L_0x00a2
            int r1 = com.talabat.darkstores.R.id.product_tile_counter_ds
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            com.designsystem.ds_stepper.DSCollapsibleQuantityStepper r10 = (com.designsystem.ds_stepper.DSCollapsibleQuantityStepper) r10
            if (r10 == 0) goto L_0x00a2
            int r1 = com.talabat.darkstores.R.id.product_tile_image
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            com.google.android.material.imageview.ShapeableImageView r11 = (com.google.android.material.imageview.ShapeableImageView) r11
            if (r11 == 0) goto L_0x00a2
            int r1 = com.talabat.darkstores.R.id.product_tile_image_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.FrameLayout r12 = (android.widget.FrameLayout) r12
            if (r12 == 0) goto L_0x00a2
            int r1 = com.talabat.darkstores.R.id.product_tile_name
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x00a2
            int r1 = com.talabat.darkstores.R.id.product_tile_old_price
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x00a2
            int r1 = com.talabat.darkstores.R.id.product_tile_out_of_stock
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00a2
            int r1 = com.talabat.darkstores.R.id.product_tile_price
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x00a2
            r17 = r0
            androidx.constraintlayout.widget.ConstraintLayout r17 = (androidx.constraintlayout.widget.ConstraintLayout) r17
            int r1 = com.talabat.darkstores.R.id.product_tile_usage_label
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00a2
            com.talabat.darkstores.databinding.DarkstoresProductTileNewBinding r0 = new com.talabat.darkstores.databinding.DarkstoresProductTileNewBinding
            r3 = r0
            r4 = r17
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r0
        L_0x00a2:
            android.content.res.Resources r0 = r19.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.databinding.DarkstoresProductTileNewBinding.bind(android.view.View):com.talabat.darkstores.databinding.DarkstoresProductTileNewBinding");
    }

    @NonNull
    public static DarkstoresProductTileNewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresProductTileNewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_product_tile_new, viewGroup, false);
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
