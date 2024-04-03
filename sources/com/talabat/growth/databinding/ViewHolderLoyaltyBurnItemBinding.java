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
import com.talabat.talabatcommon.views.TalabatImageView;

public final class ViewHolderLoyaltyBurnItemBinding implements ViewBinding {
    @NonNull
    public final LabelExclusiveToProBinding cvProExclusive;
    @NonNull
    public final ImageView ivPro;
    @NonNull
    public final LabelVoucherTypeBinding labelVoucherType;
    @NonNull
    public final CardView loyaltyBurnOptionImageRelativeLayout;
    @NonNull
    public final TalabatImageView loyaltyBurnOptionImageView;
    @NonNull
    public final TextView loyaltyBurnOptionPointTextView;
    @NonNull
    public final TextView loyaltyBurnOptionTitleTextView;
    @NonNull
    private final ConstraintLayout rootView;

    private ViewHolderLoyaltyBurnItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LabelExclusiveToProBinding labelExclusiveToProBinding, @NonNull ImageView imageView, @NonNull LabelVoucherTypeBinding labelVoucherTypeBinding, @NonNull CardView cardView, @NonNull TalabatImageView talabatImageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.cvProExclusive = labelExclusiveToProBinding;
        this.ivPro = imageView;
        this.labelVoucherType = labelVoucherTypeBinding;
        this.loyaltyBurnOptionImageRelativeLayout = cardView;
        this.loyaltyBurnOptionImageView = talabatImageView;
        this.loyaltyBurnOptionPointTextView = textView;
        this.loyaltyBurnOptionTitleTextView = textView2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0017, code lost:
        r0 = com.talabat.growth.R.id.label_voucher_type;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.growth.databinding.ViewHolderLoyaltyBurnItemBinding bind(@androidx.annotation.NonNull android.view.View r11) {
        /*
            int r0 = com.talabat.growth.R.id.cv_pro_exclusive
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r1 == 0) goto L_0x0059
            com.talabat.growth.databinding.LabelExclusiveToProBinding r4 = com.talabat.growth.databinding.LabelExclusiveToProBinding.bind(r1)
            int r0 = com.talabat.growth.R.id.iv_pro
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0059
            int r0 = com.talabat.growth.R.id.label_voucher_type
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r1 == 0) goto L_0x0059
            com.talabat.growth.databinding.LabelVoucherTypeBinding r6 = com.talabat.growth.databinding.LabelVoucherTypeBinding.bind(r1)
            int r0 = com.talabat.growth.R.id.loyaltyBurnOptionImageRelativeLayout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r7 = r1
            androidx.cardview.widget.CardView r7 = (androidx.cardview.widget.CardView) r7
            if (r7 == 0) goto L_0x0059
            int r0 = com.talabat.growth.R.id.loyaltyBurnOptionImageView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r8 = r1
            com.talabat.talabatcommon.views.TalabatImageView r8 = (com.talabat.talabatcommon.views.TalabatImageView) r8
            if (r8 == 0) goto L_0x0059
            int r0 = com.talabat.growth.R.id.loyaltyBurnOptionPointTextView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0059
            int r0 = com.talabat.growth.R.id.loyaltyBurnOptionTitleTextView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0059
            com.talabat.growth.databinding.ViewHolderLoyaltyBurnItemBinding r0 = new com.talabat.growth.databinding.ViewHolderLoyaltyBurnItemBinding
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.growth.databinding.ViewHolderLoyaltyBurnItemBinding.bind(android.view.View):com.talabat.growth.databinding.ViewHolderLoyaltyBurnItemBinding");
    }

    @NonNull
    public static ViewHolderLoyaltyBurnItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewHolderLoyaltyBurnItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_holder_loyalty_burn_item, viewGroup, false);
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
