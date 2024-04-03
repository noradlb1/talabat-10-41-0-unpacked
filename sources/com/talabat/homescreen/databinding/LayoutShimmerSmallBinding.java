package com.talabat.homescreen.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.homescreen.R;

public final class LayoutShimmerSmallBinding implements ViewBinding {
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final View shimmerBoxFirst;
    @NonNull
    public final View shimmerBoxSecond;
    @NonNull
    public final View shimmerHeaderFirst;

    private LayoutShimmerSmallBinding(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull View view2, @NonNull View view3) {
        this.rootView = constraintLayout;
        this.shimmerBoxFirst = view;
        this.shimmerBoxSecond = view2;
        this.shimmerHeaderFirst = view3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = com.talabat.homescreen.R.id.shimmerBoxSecond;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r0 = com.talabat.homescreen.R.id.shimmerHeaderFirst;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.homescreen.databinding.LayoutShimmerSmallBinding bind(@androidx.annotation.NonNull android.view.View r4) {
        /*
            int r0 = com.talabat.homescreen.R.id.shimmerBoxFirst
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            if (r1 == 0) goto L_0x0020
            int r0 = com.talabat.homescreen.R.id.shimmerBoxSecond
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            if (r2 == 0) goto L_0x0020
            int r0 = com.talabat.homescreen.R.id.shimmerHeaderFirst
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            if (r3 == 0) goto L_0x0020
            com.talabat.homescreen.databinding.LayoutShimmerSmallBinding r0 = new com.talabat.homescreen.databinding.LayoutShimmerSmallBinding
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r0.<init>(r4, r1, r2, r3)
            return r0
        L_0x0020:
            android.content.res.Resources r4 = r4.getResources()
            java.lang.String r4 = r4.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r4 = r1.concat(r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.homescreen.databinding.LayoutShimmerSmallBinding.bind(android.view.View):com.talabat.homescreen.databinding.LayoutShimmerSmallBinding");
    }

    @NonNull
    public static LayoutShimmerSmallBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LayoutShimmerSmallBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.layout_shimmer_small, viewGroup, false);
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
