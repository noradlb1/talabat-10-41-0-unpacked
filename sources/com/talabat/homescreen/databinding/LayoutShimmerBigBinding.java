package com.talabat.homescreen.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.talabat.homescreen.R;

public final class LayoutShimmerBigBinding implements ViewBinding {
    @NonNull
    public final Guideline guidelineShimmerBigEnd;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final View shimmerBoxFirst;
    @NonNull
    public final View shimmerBoxSecond;
    @NonNull
    public final View shimmerHeaderFirst;

    private LayoutShimmerBigBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Guideline guideline, @NonNull View view, @NonNull View view2, @NonNull View view3) {
        this.rootView = constraintLayout;
        this.guidelineShimmerBigEnd = guideline;
        this.shimmerBoxFirst = view;
        this.shimmerBoxSecond = view2;
        this.shimmerHeaderFirst = view3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.talabat.homescreen.R.id.shimmerBoxFirst;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r0 = com.talabat.homescreen.R.id.shimmerBoxSecond;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        r0 = com.talabat.homescreen.R.id.shimmerHeaderFirst;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.homescreen.databinding.LayoutShimmerBigBinding bind(@androidx.annotation.NonNull android.view.View r8) {
        /*
            int r0 = com.talabat.homescreen.R.id.guidelineShimmerBigEnd
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r4 = r1
            androidx.constraintlayout.widget.Guideline r4 = (androidx.constraintlayout.widget.Guideline) r4
            if (r4 == 0) goto L_0x002d
            int r0 = com.talabat.homescreen.R.id.shimmerBoxFirst
            android.view.View r5 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            if (r5 == 0) goto L_0x002d
            int r0 = com.talabat.homescreen.R.id.shimmerBoxSecond
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            if (r6 == 0) goto L_0x002d
            int r0 = com.talabat.homescreen.R.id.shimmerHeaderFirst
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            if (r7 == 0) goto L_0x002d
            com.talabat.homescreen.databinding.LayoutShimmerBigBinding r0 = new com.talabat.homescreen.databinding.LayoutShimmerBigBinding
            r3 = r8
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            return r0
        L_0x002d:
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r8 = r8.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r8 = r1.concat(r8)
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.homescreen.databinding.LayoutShimmerBigBinding.bind(android.view.View):com.talabat.homescreen.databinding.LayoutShimmerBigBinding");
    }

    @NonNull
    public static LayoutShimmerBigBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LayoutShimmerBigBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.layout_shimmer_big, viewGroup, false);
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
