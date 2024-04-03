package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.talabat.feature.tpro.presentation.R;

public final class ItemTagRewardsBinding implements ViewBinding {
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final Guideline separationGuideLine;
    @NonNull
    public final View separator;
    @NonNull
    public final ImageView toolTip;
    @NonNull
    public final TextView tvTitle;
    @NonNull
    public final AppCompatImageView voucherImage;
    @NonNull
    public final ConstraintLayout voucherRoot;

    private ItemTagRewardsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Guideline guideline, @NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull AppCompatImageView appCompatImageView, @NonNull ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.separationGuideLine = guideline;
        this.separator = view;
        this.toolTip = imageView;
        this.tvTitle = textView;
        this.voucherImage = appCompatImageView;
        this.voucherRoot = constraintLayout2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.talabat.feature.tpro.presentation.R.id.separator;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.feature.tpro.presentation.databinding.ItemTagRewardsBinding bind(@androidx.annotation.NonNull android.view.View r10) {
        /*
            int r0 = com.talabat.feature.tpro.presentation.R.id.separation_guide_line
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r4 = r1
            androidx.constraintlayout.widget.Guideline r4 = (androidx.constraintlayout.widget.Guideline) r4
            if (r4 == 0) goto L_0x003f
            int r0 = com.talabat.feature.tpro.presentation.R.id.separator
            android.view.View r5 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            if (r5 == 0) goto L_0x003f
            int r0 = com.talabat.feature.tpro.presentation.R.id.tool_tip
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r6 = r1
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x003f
            int r0 = com.talabat.feature.tpro.presentation.R.id.tv_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x003f
            int r0 = com.talabat.feature.tpro.presentation.R.id.voucher_image
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r8 = r1
            androidx.appcompat.widget.AppCompatImageView r8 = (androidx.appcompat.widget.AppCompatImageView) r8
            if (r8 == 0) goto L_0x003f
            r9 = r10
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            com.talabat.feature.tpro.presentation.databinding.ItemTagRewardsBinding r10 = new com.talabat.feature.tpro.presentation.databinding.ItemTagRewardsBinding
            r2 = r10
            r3 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return r10
        L_0x003f:
            android.content.res.Resources r10 = r10.getResources()
            java.lang.String r10 = r10.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r10 = r1.concat(r10)
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.databinding.ItemTagRewardsBinding.bind(android.view.View):com.talabat.feature.tpro.presentation.databinding.ItemTagRewardsBinding");
    }

    @NonNull
    public static ItemTagRewardsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemTagRewardsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_tag_rewards, viewGroup, false);
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
