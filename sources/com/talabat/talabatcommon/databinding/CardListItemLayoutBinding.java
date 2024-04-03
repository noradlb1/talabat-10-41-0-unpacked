package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.talabatcommon.R;

public final class CardListItemLayoutBinding implements ViewBinding {
    @NonNull
    public final TextView addNewCard;
    @NonNull
    public final RadioButton cardCheckbox;
    @NonNull
    public final ImageView creditCardLogo;
    @NonNull
    public final TextView creditCardNumber;
    @NonNull
    public final View divider;
    @NonNull
    public final TextView expiryDate;
    @NonNull
    private final ConstraintLayout rootView;

    private CardListItemLayoutBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull RadioButton radioButton, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull View view, @NonNull TextView textView3) {
        this.rootView = constraintLayout;
        this.addNewCard = textView;
        this.cardCheckbox = radioButton;
        this.creditCardLogo = imageView;
        this.creditCardNumber = textView2;
        this.divider = view;
        this.expiryDate = textView3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.talabat.talabatcommon.R.id.divider;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.talabatcommon.databinding.CardListItemLayoutBinding bind(@androidx.annotation.NonNull android.view.View r10) {
        /*
            int r0 = com.talabat.talabatcommon.R.id.add_new_card
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0049
            int r0 = com.talabat.talabatcommon.R.id.card_checkbox
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r5 = r1
            android.widget.RadioButton r5 = (android.widget.RadioButton) r5
            if (r5 == 0) goto L_0x0049
            int r0 = com.talabat.talabatcommon.R.id.credit_card_logo
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r6 = r1
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x0049
            int r0 = com.talabat.talabatcommon.R.id.credit_card_number
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0049
            int r0 = com.talabat.talabatcommon.R.id.divider
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            if (r8 == 0) goto L_0x0049
            int r0 = com.talabat.talabatcommon.R.id.expiry_date
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0049
            com.talabat.talabatcommon.databinding.CardListItemLayoutBinding r0 = new com.talabat.talabatcommon.databinding.CardListItemLayoutBinding
            r3 = r10
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return r0
        L_0x0049:
            android.content.res.Resources r10 = r10.getResources()
            java.lang.String r10 = r10.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r10 = r1.concat(r10)
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.databinding.CardListItemLayoutBinding.bind(android.view.View):com.talabat.talabatcommon.databinding.CardListItemLayoutBinding");
    }

    @NonNull
    public static CardListItemLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CardListItemLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.card_list_item_layout, viewGroup, false);
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
