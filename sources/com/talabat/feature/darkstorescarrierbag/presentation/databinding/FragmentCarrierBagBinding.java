package com.talabat.feature.darkstorescarrierbag.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.talabat.feature.darkstorescarrierbag.presentation.R;

public final class FragmentCarrierBagBinding implements ViewBinding {
    @NonNull
    public final LayoutOptionSelectedBinding clSelectedOption;
    @NonNull
    public final AppCompatImageView ivClose;
    @NonNull
    public final LayoutOptionsBinding llOptions;
    @NonNull
    private final LinearLayout rootView;

    private FragmentCarrierBagBinding(@NonNull LinearLayout linearLayout, @NonNull LayoutOptionSelectedBinding layoutOptionSelectedBinding, @NonNull AppCompatImageView appCompatImageView, @NonNull LayoutOptionsBinding layoutOptionsBinding) {
        this.rootView = linearLayout;
        this.clSelectedOption = layoutOptionSelectedBinding;
        this.ivClose = appCompatImageView;
        this.llOptions = layoutOptionsBinding;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r1 = com.talabat.feature.darkstorescarrierbag.presentation.R.id.llOptions;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.feature.darkstorescarrierbag.presentation.databinding.FragmentCarrierBagBinding bind(@androidx.annotation.NonNull android.view.View r4) {
        /*
            int r0 = com.talabat.feature.darkstorescarrierbag.presentation.R.id.clSelectedOption
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            if (r1 == 0) goto L_0x002b
            com.talabat.feature.darkstorescarrierbag.presentation.databinding.LayoutOptionSelectedBinding r0 = com.talabat.feature.darkstorescarrierbag.presentation.databinding.LayoutOptionSelectedBinding.bind(r1)
            int r1 = com.talabat.feature.darkstorescarrierbag.presentation.R.id.ivClose
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r1)
            androidx.appcompat.widget.AppCompatImageView r2 = (androidx.appcompat.widget.AppCompatImageView) r2
            if (r2 == 0) goto L_0x002a
            int r1 = com.talabat.feature.darkstorescarrierbag.presentation.R.id.llOptions
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r1)
            if (r3 == 0) goto L_0x002a
            com.talabat.feature.darkstorescarrierbag.presentation.databinding.LayoutOptionsBinding r1 = com.talabat.feature.darkstorescarrierbag.presentation.databinding.LayoutOptionsBinding.bind(r3)
            com.talabat.feature.darkstorescarrierbag.presentation.databinding.FragmentCarrierBagBinding r3 = new com.talabat.feature.darkstorescarrierbag.presentation.databinding.FragmentCarrierBagBinding
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r3.<init>(r4, r0, r2, r1)
            return r3
        L_0x002a:
            r0 = r1
        L_0x002b:
            android.content.res.Resources r4 = r4.getResources()
            java.lang.String r4 = r4.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r4 = r1.concat(r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.darkstorescarrierbag.presentation.databinding.FragmentCarrierBagBinding.bind(android.view.View):com.talabat.feature.darkstorescarrierbag.presentation.databinding.FragmentCarrierBagBinding");
    }

    @NonNull
    public static FragmentCarrierBagBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentCarrierBagBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_carrier_bag, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
