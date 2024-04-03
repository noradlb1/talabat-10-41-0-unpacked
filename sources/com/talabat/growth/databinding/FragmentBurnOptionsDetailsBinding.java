package com.talabat.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.designsystem.ds_icon_button.DSIconButton;
import com.marshmallow.TalabatTag;
import com.talabat.growth.R;
import com.talabat.talabatcommon.views.TalabatImageView;

public final class FragmentBurnOptionsDetailsBinding implements ViewBinding {
    @NonNull
    public final TextView burnDetailsAvailablePointsTextView;
    @NonNull
    public final LinearLayout burnDetailsCurrentPointsLinearLayout;
    @NonNull
    public final TextView burnDetailsDetailTextView;
    @NonNull
    public final TalabatImageView burnDetailsImageView;
    @NonNull
    public final TextView burnDetailsItemPointsTextView;
    @NonNull
    public final DSPrimaryButton burnDetailsRedeemButton;
    @NonNull
    public final DSPrimaryButton burnDetailsTProButton;
    @NonNull
    public final TextView burnDetailsTitleTextView;
    @NonNull
    public final DSIconButton dsIconButtonClose;
    @NonNull
    public final TextView pointsTv;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final View separatorV;
    @NonNull
    public final TalabatTag ttTag;

    private FragmentBurnOptionsDetailsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull TalabatImageView talabatImageView, @NonNull TextView textView3, @NonNull DSPrimaryButton dSPrimaryButton, @NonNull DSPrimaryButton dSPrimaryButton2, @NonNull TextView textView4, @NonNull DSIconButton dSIconButton, @NonNull TextView textView5, @NonNull View view, @NonNull TalabatTag talabatTag) {
        this.rootView = constraintLayout;
        this.burnDetailsAvailablePointsTextView = textView;
        this.burnDetailsCurrentPointsLinearLayout = linearLayout;
        this.burnDetailsDetailTextView = textView2;
        this.burnDetailsImageView = talabatImageView;
        this.burnDetailsItemPointsTextView = textView3;
        this.burnDetailsRedeemButton = dSPrimaryButton;
        this.burnDetailsTProButton = dSPrimaryButton2;
        this.burnDetailsTitleTextView = textView4;
        this.dsIconButtonClose = dSIconButton;
        this.pointsTv = textView5;
        this.separatorV = view;
        this.ttTag = talabatTag;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r1 = com.talabat.growth.R.id.separatorV;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.growth.databinding.FragmentBurnOptionsDetailsBinding bind(@androidx.annotation.NonNull android.view.View r17) {
        /*
            r0 = r17
            int r1 = com.talabat.growth.R.id.burnDetailsAvailablePointsTextView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x008e
            int r1 = com.talabat.growth.R.id.burnDetailsCurrentPointsLinearLayout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            if (r6 == 0) goto L_0x008e
            int r1 = com.talabat.growth.R.id.burnDetailsDetailTextView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x008e
            int r1 = com.talabat.growth.R.id.burnDetailsImageView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            com.talabat.talabatcommon.views.TalabatImageView r8 = (com.talabat.talabatcommon.views.TalabatImageView) r8
            if (r8 == 0) goto L_0x008e
            int r1 = com.talabat.growth.R.id.burnDetailsItemPointsTextView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x008e
            int r1 = com.talabat.growth.R.id.burnDetailsRedeemButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            com.designsystem.ds_button_v2.DSPrimaryButton r10 = (com.designsystem.ds_button_v2.DSPrimaryButton) r10
            if (r10 == 0) goto L_0x008e
            int r1 = com.talabat.growth.R.id.burnDetailsTProButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            com.designsystem.ds_button_v2.DSPrimaryButton r11 = (com.designsystem.ds_button_v2.DSPrimaryButton) r11
            if (r11 == 0) goto L_0x008e
            int r1 = com.talabat.growth.R.id.burnDetailsTitleTextView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x008e
            int r1 = com.talabat.growth.R.id.dsIconButtonClose
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            com.designsystem.ds_icon_button.DSIconButton r13 = (com.designsystem.ds_icon_button.DSIconButton) r13
            if (r13 == 0) goto L_0x008e
            int r1 = com.talabat.growth.R.id.pointsTv
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x008e
            int r1 = com.talabat.growth.R.id.separatorV
            android.view.View r15 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r15 == 0) goto L_0x008e
            int r1 = com.talabat.growth.R.id.ttTag
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            com.marshmallow.TalabatTag r16 = (com.marshmallow.TalabatTag) r16
            if (r16 == 0) goto L_0x008e
            com.talabat.growth.databinding.FragmentBurnOptionsDetailsBinding r1 = new com.talabat.growth.databinding.FragmentBurnOptionsDetailsBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r1
        L_0x008e:
            android.content.res.Resources r0 = r17.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.growth.databinding.FragmentBurnOptionsDetailsBinding.bind(android.view.View):com.talabat.growth.databinding.FragmentBurnOptionsDetailsBinding");
    }

    @NonNull
    public static FragmentBurnOptionsDetailsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentBurnOptionsDetailsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_burn_options_details, viewGroup, false);
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
