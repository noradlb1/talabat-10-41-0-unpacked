package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.talabatcommon.R;
import io.supercharge.shimmerlayout.ShimmerLayout;

public final class LayoutPromotionsWidgetBinding implements ViewBinding {
    @NonNull
    public final ImageView btnPromoClose;
    @NonNull
    public final View dividerVerticalImage;
    @NonNull
    public final View dividerVerticalStart;
    @NonNull
    public final AppCompatTextView promoBody;
    @NonNull
    public final ImageView promoImg;
    @NonNull
    public final AppCompatTextView promoTitle;
    @NonNull
    public final AppCompatTextView promoView;
    @NonNull
    public final ConstraintLayout promoWidget;
    @NonNull
    public final ShimmerLayout promoWidgetShimmerLayout;
    @NonNull
    public final ImageView promotionLogo;
    @NonNull
    private final CardView rootView;

    private LayoutPromotionsWidgetBinding(@NonNull CardView cardView, @NonNull ImageView imageView, @NonNull View view, @NonNull View view2, @NonNull AppCompatTextView appCompatTextView, @NonNull ImageView imageView2, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull ConstraintLayout constraintLayout, @NonNull ShimmerLayout shimmerLayout, @NonNull ImageView imageView3) {
        this.rootView = cardView;
        this.btnPromoClose = imageView;
        this.dividerVerticalImage = view;
        this.dividerVerticalStart = view2;
        this.promoBody = appCompatTextView;
        this.promoImg = imageView2;
        this.promoTitle = appCompatTextView2;
        this.promoView = appCompatTextView3;
        this.promoWidget = constraintLayout;
        this.promoWidgetShimmerLayout = shimmerLayout;
        this.promotionLogo = imageView3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.talabat.talabatcommon.R.id.divider_vertical_image;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r0 = com.talabat.talabatcommon.R.id.divider_vertical_start;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.talabatcommon.databinding.LayoutPromotionsWidgetBinding bind(@androidx.annotation.NonNull android.view.View r14) {
        /*
            int r0 = com.talabat.talabatcommon.R.id.btn_promo_close
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0072
            int r0 = com.talabat.talabatcommon.R.id.divider_vertical_image
            android.view.View r5 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            if (r5 == 0) goto L_0x0072
            int r0 = com.talabat.talabatcommon.R.id.divider_vertical_start
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            if (r6 == 0) goto L_0x0072
            int r0 = com.talabat.talabatcommon.R.id.promo_body
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r7 = r1
            androidx.appcompat.widget.AppCompatTextView r7 = (androidx.appcompat.widget.AppCompatTextView) r7
            if (r7 == 0) goto L_0x0072
            int r0 = com.talabat.talabatcommon.R.id.promo_img
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0072
            int r0 = com.talabat.talabatcommon.R.id.promo_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r9 = r1
            androidx.appcompat.widget.AppCompatTextView r9 = (androidx.appcompat.widget.AppCompatTextView) r9
            if (r9 == 0) goto L_0x0072
            int r0 = com.talabat.talabatcommon.R.id.promo_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r10 = r1
            androidx.appcompat.widget.AppCompatTextView r10 = (androidx.appcompat.widget.AppCompatTextView) r10
            if (r10 == 0) goto L_0x0072
            int r0 = com.talabat.talabatcommon.R.id.promoWidget
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r11 = r1
            androidx.constraintlayout.widget.ConstraintLayout r11 = (androidx.constraintlayout.widget.ConstraintLayout) r11
            if (r11 == 0) goto L_0x0072
            int r0 = com.talabat.talabatcommon.R.id.promoWidgetShimmerLayout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r12 = r1
            io.supercharge.shimmerlayout.ShimmerLayout r12 = (io.supercharge.shimmerlayout.ShimmerLayout) r12
            if (r12 == 0) goto L_0x0072
            int r0 = com.talabat.talabatcommon.R.id.promotion_logo
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r13 = r1
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            if (r13 == 0) goto L_0x0072
            com.talabat.talabatcommon.databinding.LayoutPromotionsWidgetBinding r0 = new com.talabat.talabatcommon.databinding.LayoutPromotionsWidgetBinding
            r3 = r14
            androidx.cardview.widget.CardView r3 = (androidx.cardview.widget.CardView) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r0
        L_0x0072:
            android.content.res.Resources r14 = r14.getResources()
            java.lang.String r14 = r14.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r14 = r1.concat(r14)
            r0.<init>(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.databinding.LayoutPromotionsWidgetBinding.bind(android.view.View):com.talabat.talabatcommon.databinding.LayoutPromotionsWidgetBinding");
    }

    @NonNull
    public static LayoutPromotionsWidgetBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LayoutPromotionsWidgetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.layout_promotions_widget, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public CardView getRoot() {
        return this.rootView;
    }
}
