package com.talabat.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.growth.R;

public final class ViewHolderFeaturedListBinding implements ViewBinding {
    @NonNull
    public final LabelExclusiveToProBinding cvProExclusive;
    @NonNull
    public final CardView featuredListViewHolderImageRelativeLayout;
    @NonNull
    public final ImageView featuredListViewHolderImageView;
    @NonNull
    public final TextView featuredListViewHolderPointsTextView;
    @NonNull
    public final TextView featuredListViewHolderTitleTextView;
    @NonNull
    public final ImageView ivPro;
    @NonNull
    public final LabelVoucherTypeBinding labelVoucherType;
    @NonNull
    private final ConstraintLayout rootView;

    private ViewHolderFeaturedListBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LabelExclusiveToProBinding labelExclusiveToProBinding, @NonNull CardView cardView, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView2, @NonNull LabelVoucherTypeBinding labelVoucherTypeBinding) {
        this.rootView = constraintLayout;
        this.cvProExclusive = labelExclusiveToProBinding;
        this.featuredListViewHolderImageRelativeLayout = cardView;
        this.featuredListViewHolderImageView = imageView;
        this.featuredListViewHolderPointsTextView = textView;
        this.featuredListViewHolderTitleTextView = textView2;
        this.ivPro = imageView2;
        this.labelVoucherType = labelVoucherTypeBinding;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0043, code lost:
        r0 = com.talabat.growth.R.id.label_voucher_type;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.growth.databinding.ViewHolderFeaturedListBinding bind(@androidx.annotation.NonNull android.view.View r11) {
        /*
            int r0 = com.talabat.growth.R.id.cv_pro_exclusive
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r1 == 0) goto L_0x0059
            com.talabat.growth.databinding.LabelExclusiveToProBinding r4 = com.talabat.growth.databinding.LabelExclusiveToProBinding.bind(r1)
            int r0 = com.talabat.growth.R.id.featuredListViewHolderImageRelativeLayout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r5 = r1
            androidx.cardview.widget.CardView r5 = (androidx.cardview.widget.CardView) r5
            if (r5 == 0) goto L_0x0059
            int r0 = com.talabat.growth.R.id.featuredListViewHolderImageView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r6 = r1
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x0059
            int r0 = com.talabat.growth.R.id.featuredListViewHolderPointsTextView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0059
            int r0 = com.talabat.growth.R.id.featuredListViewHolderTitleTextView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0059
            int r0 = com.talabat.growth.R.id.iv_pro
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x0059
            int r0 = com.talabat.growth.R.id.label_voucher_type
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r1 == 0) goto L_0x0059
            com.talabat.growth.databinding.LabelVoucherTypeBinding r10 = com.talabat.growth.databinding.LabelVoucherTypeBinding.bind(r1)
            com.talabat.growth.databinding.ViewHolderFeaturedListBinding r0 = new com.talabat.growth.databinding.ViewHolderFeaturedListBinding
            r3 = r11
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x0059:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.growth.databinding.ViewHolderFeaturedListBinding.bind(android.view.View):com.talabat.growth.databinding.ViewHolderFeaturedListBinding");
    }

    @NonNull
    public static ViewHolderFeaturedListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewHolderFeaturedListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_holder_featured_list, viewGroup, false);
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
