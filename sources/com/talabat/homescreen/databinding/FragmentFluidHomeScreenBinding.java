package com.talabat.homescreen.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.deliveryhero.fluid.widgets.collections.list.ListWidget;
import com.talabat.homescreen.R;

public final class FragmentFluidHomeScreenBinding implements ViewBinding {
    @NonNull
    public final ListWidget componentList;
    @NonNull
    public final FluidHomeLoadingBinding loadingLayout;
    @NonNull
    private final LinearLayout rootView;

    private FragmentFluidHomeScreenBinding(@NonNull LinearLayout linearLayout, @NonNull ListWidget listWidget, @NonNull FluidHomeLoadingBinding fluidHomeLoadingBinding) {
        this.rootView = linearLayout;
        this.componentList = listWidget;
        this.loadingLayout = fluidHomeLoadingBinding;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.talabat.homescreen.R.id.loadingLayout;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.homescreen.databinding.FragmentFluidHomeScreenBinding bind(@androidx.annotation.NonNull android.view.View r3) {
        /*
            int r0 = com.talabat.homescreen.R.id.componentList
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            com.deliveryhero.fluid.widgets.collections.list.ListWidget r1 = (com.deliveryhero.fluid.widgets.collections.list.ListWidget) r1
            if (r1 == 0) goto L_0x001e
            int r0 = com.talabat.homescreen.R.id.loadingLayout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            if (r2 == 0) goto L_0x001e
            com.talabat.homescreen.databinding.FluidHomeLoadingBinding r0 = com.talabat.homescreen.databinding.FluidHomeLoadingBinding.bind(r2)
            com.talabat.homescreen.databinding.FragmentFluidHomeScreenBinding r2 = new com.talabat.homescreen.databinding.FragmentFluidHomeScreenBinding
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2.<init>(r3, r1, r0)
            return r2
        L_0x001e:
            android.content.res.Resources r3 = r3.getResources()
            java.lang.String r3 = r3.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r3 = r1.concat(r3)
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.homescreen.databinding.FragmentFluidHomeScreenBinding.bind(android.view.View):com.talabat.homescreen.databinding.FragmentFluidHomeScreenBinding");
    }

    @NonNull
    public static FragmentFluidHomeScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentFluidHomeScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_fluid_home_screen, viewGroup, false);
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
