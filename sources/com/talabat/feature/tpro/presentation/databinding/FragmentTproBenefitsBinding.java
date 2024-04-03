package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.talabat.feature.tpro.presentation.R;

public final class FragmentTproBenefitsBinding implements ViewBinding {
    @NonNull
    public final LinearLayout errorNotifyLinearLayout;
    @NonNull
    public final IncludePaymentSectionBinding includePaymentSection;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final RecyclerView rvOnBoardingContent;
    @NonNull
    public final ViewBenefitsShimmerBinding shimmer;

    private FragmentTproBenefitsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull IncludePaymentSectionBinding includePaymentSectionBinding, @NonNull RecyclerView recyclerView, @NonNull ViewBenefitsShimmerBinding viewBenefitsShimmerBinding) {
        this.rootView = constraintLayout;
        this.errorNotifyLinearLayout = linearLayout;
        this.includePaymentSection = includePaymentSectionBinding;
        this.rvOnBoardingContent = recyclerView;
        this.shimmer = viewBenefitsShimmerBinding;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.talabat.feature.tpro.presentation.R.id.include_payment_section;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0022, code lost:
        r0 = com.talabat.feature.tpro.presentation.R.id.shimmer;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.feature.tpro.presentation.databinding.FragmentTproBenefitsBinding bind(@androidx.annotation.NonNull android.view.View r8) {
        /*
            int r0 = com.talabat.feature.tpro.presentation.R.id.errorNotifyLinearLayout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r4 = r1
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            if (r4 == 0) goto L_0x0038
            int r0 = com.talabat.feature.tpro.presentation.R.id.include_payment_section
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            if (r1 == 0) goto L_0x0038
            com.talabat.feature.tpro.presentation.databinding.IncludePaymentSectionBinding r5 = com.talabat.feature.tpro.presentation.databinding.IncludePaymentSectionBinding.bind(r1)
            int r0 = com.talabat.feature.tpro.presentation.R.id.rv_on_boarding_content
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r6 = r1
            androidx.recyclerview.widget.RecyclerView r6 = (androidx.recyclerview.widget.RecyclerView) r6
            if (r6 == 0) goto L_0x0038
            int r0 = com.talabat.feature.tpro.presentation.R.id.shimmer
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            if (r1 == 0) goto L_0x0038
            com.talabat.feature.tpro.presentation.databinding.ViewBenefitsShimmerBinding r7 = com.talabat.feature.tpro.presentation.databinding.ViewBenefitsShimmerBinding.bind(r1)
            com.talabat.feature.tpro.presentation.databinding.FragmentTproBenefitsBinding r0 = new com.talabat.feature.tpro.presentation.databinding.FragmentTproBenefitsBinding
            r3 = r8
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            return r0
        L_0x0038:
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r8 = r8.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r8 = r1.concat(r8)
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.databinding.FragmentTproBenefitsBinding.bind(android.view.View):com.talabat.feature.tpro.presentation.databinding.FragmentTproBenefitsBinding");
    }

    @NonNull
    public static FragmentTproBenefitsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentTproBenefitsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tpro_benefits, viewGroup, false);
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
