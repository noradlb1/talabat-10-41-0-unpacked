package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.customScrollingViews.CustomVerticalCoordinatorLayout;
import com.talabat.darkstores.common.view.BlockableAppBarLayout;

public final class DarkstoresFragmentHomeBinding implements ViewBinding {
    @NonNull
    public final BlockableAppBarLayout appBar;
    @NonNull
    public final DarkstoresFragmentHomeContentBinding content;
    @NonNull
    public final ImageView homeLogo;
    @NonNull
    public final TextView homeSubtitle;
    @NonNull
    public final TextView homeTitle;
    @NonNull
    public final TextView homeTitleOnly;
    @NonNull
    public final LinearLayout logoAndTitleContainer;
    @NonNull
    private final CustomVerticalCoordinatorLayout rootView;
    @NonNull
    public final Toolbar toolbar;

    private DarkstoresFragmentHomeBinding(@NonNull CustomVerticalCoordinatorLayout customVerticalCoordinatorLayout, @NonNull BlockableAppBarLayout blockableAppBarLayout, @NonNull DarkstoresFragmentHomeContentBinding darkstoresFragmentHomeContentBinding, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout, @NonNull Toolbar toolbar2) {
        this.rootView = customVerticalCoordinatorLayout;
        this.appBar = blockableAppBarLayout;
        this.content = darkstoresFragmentHomeContentBinding;
        this.homeLogo = imageView;
        this.homeSubtitle = textView;
        this.homeTitle = textView2;
        this.homeTitleOnly = textView3;
        this.logoAndTitleContainer = linearLayout;
        this.toolbar = toolbar2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.talabat.darkstores.R.id.content;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.darkstores.databinding.DarkstoresFragmentHomeBinding bind(@androidx.annotation.NonNull android.view.View r12) {
        /*
            int r0 = com.talabat.darkstores.R.id.appBar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r4 = r1
            com.talabat.darkstores.common.view.BlockableAppBarLayout r4 = (com.talabat.darkstores.common.view.BlockableAppBarLayout) r4
            if (r4 == 0) goto L_0x0063
            int r0 = com.talabat.darkstores.R.id.content
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r1 == 0) goto L_0x0063
            com.talabat.darkstores.databinding.DarkstoresFragmentHomeContentBinding r5 = com.talabat.darkstores.databinding.DarkstoresFragmentHomeContentBinding.bind(r1)
            int r0 = com.talabat.darkstores.R.id.home_logo
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r6 = r1
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x0063
            int r0 = com.talabat.darkstores.R.id.home_subtitle
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0063
            int r0 = com.talabat.darkstores.R.id.home_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0063
            int r0 = com.talabat.darkstores.R.id.home_title_only
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0063
            int r0 = com.talabat.darkstores.R.id.logo_and_title_container
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r10 = r1
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            if (r10 == 0) goto L_0x0063
            int r0 = com.talabat.darkstores.R.id.toolbar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r11 = r1
            androidx.appcompat.widget.Toolbar r11 = (androidx.appcompat.widget.Toolbar) r11
            if (r11 == 0) goto L_0x0063
            com.talabat.darkstores.databinding.DarkstoresFragmentHomeBinding r0 = new com.talabat.darkstores.databinding.DarkstoresFragmentHomeBinding
            r3 = r12
            com.talabat.darkstores.common.customScrollingViews.CustomVerticalCoordinatorLayout r3 = (com.talabat.darkstores.common.customScrollingViews.CustomVerticalCoordinatorLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r0
        L_0x0063:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.databinding.DarkstoresFragmentHomeBinding.bind(android.view.View):com.talabat.darkstores.databinding.DarkstoresFragmentHomeBinding");
    }

    @NonNull
    public static DarkstoresFragmentHomeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresFragmentHomeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_fragment_home, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public CustomVerticalCoordinatorLayout getRoot() {
        return this.rootView;
    }
}
