package com.talabat.homescreen.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.talabat.homescreen.R;
import com.talabat.talabatcommon.views.ShimmerLayout;

public final class LayoutBaseHorizontalRecyclerViewBinding implements ViewBinding {
    @NonNull
    public final View bottomDivider;
    @NonNull
    public final ImageView ivHomeBaseHorizontalArrow;
    @NonNull
    private final View rootView;
    @NonNull
    public final RecyclerView rvHomeBaseHorizontal;
    @NonNull
    public final LayoutShimmerBigBinding shimmerLayoutBaseHorizontalBig;
    @NonNull
    public final LayoutShimmerSmallBinding shimmerLayoutBaseHorizontalSmall;
    @NonNull
    public final LinearLayout titleLayout;
    @NonNull
    public final TextView tvHomeBaseHorizontalTitle;
    @NonNull
    public final ShimmerLayout verticalsShimmer;

    private LayoutBaseHorizontalRecyclerViewBinding(@NonNull View view, @NonNull View view2, @NonNull ImageView imageView, @NonNull RecyclerView recyclerView, @NonNull LayoutShimmerBigBinding layoutShimmerBigBinding, @NonNull LayoutShimmerSmallBinding layoutShimmerSmallBinding, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ShimmerLayout shimmerLayout) {
        this.rootView = view;
        this.bottomDivider = view2;
        this.ivHomeBaseHorizontalArrow = imageView;
        this.rvHomeBaseHorizontal = recyclerView;
        this.shimmerLayoutBaseHorizontalBig = layoutShimmerBigBinding;
        this.shimmerLayoutBaseHorizontalSmall = layoutShimmerSmallBinding;
        this.titleLayout = linearLayout;
        this.tvHomeBaseHorizontalTitle = textView;
        this.verticalsShimmer = shimmerLayout;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        r0 = com.talabat.homescreen.R.id.shimmerLayoutBaseHorizontalBig;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.homescreen.databinding.LayoutBaseHorizontalRecyclerViewBinding bind(@androidx.annotation.NonNull android.view.View r11) {
        /*
            int r0 = com.talabat.homescreen.R.id.bottomDivider
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r3 == 0) goto L_0x005f
            int r0 = com.talabat.homescreen.R.id.ivHomeBaseHorizontalArrow
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x005f
            int r0 = com.talabat.homescreen.R.id.rvHomeBaseHorizontal
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r5 = r1
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
            if (r5 == 0) goto L_0x005f
            int r0 = com.talabat.homescreen.R.id.shimmerLayoutBaseHorizontalBig
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r1 == 0) goto L_0x005f
            com.talabat.homescreen.databinding.LayoutShimmerBigBinding r6 = com.talabat.homescreen.databinding.LayoutShimmerBigBinding.bind(r1)
            int r0 = com.talabat.homescreen.R.id.shimmerLayoutBaseHorizontalSmall
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r1 == 0) goto L_0x005f
            com.talabat.homescreen.databinding.LayoutShimmerSmallBinding r7 = com.talabat.homescreen.databinding.LayoutShimmerSmallBinding.bind(r1)
            int r0 = com.talabat.homescreen.R.id.titleLayout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r8 = r1
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            if (r8 == 0) goto L_0x005f
            int r0 = com.talabat.homescreen.R.id.tvHomeBaseHorizontalTitle
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x005f
            int r0 = com.talabat.homescreen.R.id.verticalsShimmer
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r10 = r1
            com.talabat.talabatcommon.views.ShimmerLayout r10 = (com.talabat.talabatcommon.views.ShimmerLayout) r10
            if (r10 == 0) goto L_0x005f
            com.talabat.homescreen.databinding.LayoutBaseHorizontalRecyclerViewBinding r0 = new com.talabat.homescreen.databinding.LayoutBaseHorizontalRecyclerViewBinding
            r1 = r0
            r2 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x005f:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.homescreen.databinding.LayoutBaseHorizontalRecyclerViewBinding.bind(android.view.View):com.talabat.homescreen.databinding.LayoutBaseHorizontalRecyclerViewBinding");
    }

    @NonNull
    public static LayoutBaseHorizontalRecyclerViewBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.layout_base_horizontal_recycler_view, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
