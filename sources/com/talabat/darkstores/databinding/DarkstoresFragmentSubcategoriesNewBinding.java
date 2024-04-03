package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.view.LoadingFailedView;
import com.talabat.darkstores.feature.categories.subcategories.shelf.ShelfView;
import com.talabat.darkstores.feature.product.views.NavigationBarTrailingIcons;
import com.talabat.feature.darkstorestooltip.presentation.TooltipView;

public final class DarkstoresFragmentSubcategoriesNewBinding implements ViewBinding {
    @NonNull
    public final ImageView allCategories;
    @NonNull
    public final TooltipView basketLifetimeTooltipView;
    @NonNull
    public final View btnSearch;
    @NonNull
    public final Group contentContainer;
    @NonNull
    public final LoadingFailedView errorView;
    @NonNull
    public final Guideline guidelineEnd;
    @NonNull
    public final Guideline guidelineStart;
    @NonNull
    public final RecyclerView headlinesChipsRv;
    @NonNull
    public final RecyclerView productsItemsRv;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final SearchView searchView;
    @NonNull
    public final ShelfView shelfView;
    @NonNull
    public final RecyclerView shelfViewProductsItems;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final TextView toolbarTitle;
    @NonNull
    public final NavigationBarTrailingIcons trailingIcons;

    private DarkstoresFragmentSubcategoriesNewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TooltipView tooltipView, @NonNull View view, @NonNull Group group, @NonNull LoadingFailedView loadingFailedView, @NonNull Guideline guideline, @NonNull Guideline guideline2, @NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2, @NonNull ProgressBar progressBar2, @NonNull SearchView searchView2, @NonNull ShelfView shelfView2, @NonNull RecyclerView recyclerView3, @NonNull Toolbar toolbar2, @NonNull TextView textView, @NonNull NavigationBarTrailingIcons navigationBarTrailingIcons) {
        this.rootView = constraintLayout;
        this.allCategories = imageView;
        this.basketLifetimeTooltipView = tooltipView;
        this.btnSearch = view;
        this.contentContainer = group;
        this.errorView = loadingFailedView;
        this.guidelineEnd = guideline;
        this.guidelineStart = guideline2;
        this.headlinesChipsRv = recyclerView;
        this.productsItemsRv = recyclerView2;
        this.progressBar = progressBar2;
        this.searchView = searchView2;
        this.shelfView = shelfView2;
        this.shelfViewProductsItems = recyclerView3;
        this.toolbar = toolbar2;
        this.toolbarTitle = textView;
        this.trailingIcons = navigationBarTrailingIcons;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r1 = com.talabat.darkstores.R.id.btnSearch;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.darkstores.databinding.DarkstoresFragmentSubcategoriesNewBinding bind(@androidx.annotation.NonNull android.view.View r21) {
        /*
            r0 = r21
            int r1 = com.talabat.darkstores.R.id.allCategories
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x00be
            int r1 = com.talabat.darkstores.R.id.basketLifetimeTooltipView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.talabat.feature.darkstorestooltip.presentation.TooltipView r6 = (com.talabat.feature.darkstorestooltip.presentation.TooltipView) r6
            if (r6 == 0) goto L_0x00be
            int r1 = com.talabat.darkstores.R.id.btnSearch
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r7 == 0) goto L_0x00be
            int r1 = com.talabat.darkstores.R.id.contentContainer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            androidx.constraintlayout.widget.Group r8 = (androidx.constraintlayout.widget.Group) r8
            if (r8 == 0) goto L_0x00be
            int r1 = com.talabat.darkstores.R.id.errorView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            com.talabat.darkstores.common.view.LoadingFailedView r9 = (com.talabat.darkstores.common.view.LoadingFailedView) r9
            if (r9 == 0) goto L_0x00be
            int r1 = com.talabat.darkstores.R.id.guideline_end
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            androidx.constraintlayout.widget.Guideline r10 = (androidx.constraintlayout.widget.Guideline) r10
            if (r10 == 0) goto L_0x00be
            int r1 = com.talabat.darkstores.R.id.guideline_start
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            androidx.constraintlayout.widget.Guideline r11 = (androidx.constraintlayout.widget.Guideline) r11
            if (r11 == 0) goto L_0x00be
            int r1 = com.talabat.darkstores.R.id.headlinesChipsRv
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            androidx.recyclerview.widget.RecyclerView r12 = (androidx.recyclerview.widget.RecyclerView) r12
            if (r12 == 0) goto L_0x00be
            int r1 = com.talabat.darkstores.R.id.productsItemsRv
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            androidx.recyclerview.widget.RecyclerView r13 = (androidx.recyclerview.widget.RecyclerView) r13
            if (r13 == 0) goto L_0x00be
            int r1 = com.talabat.darkstores.R.id.progressBar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.ProgressBar r14 = (android.widget.ProgressBar) r14
            if (r14 == 0) goto L_0x00be
            int r1 = com.talabat.darkstores.R.id.searchView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            androidx.appcompat.widget.SearchView r15 = (androidx.appcompat.widget.SearchView) r15
            if (r15 == 0) goto L_0x00be
            int r1 = com.talabat.darkstores.R.id.shelfView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            com.talabat.darkstores.feature.categories.subcategories.shelf.ShelfView r16 = (com.talabat.darkstores.feature.categories.subcategories.shelf.ShelfView) r16
            if (r16 == 0) goto L_0x00be
            int r1 = com.talabat.darkstores.R.id.shelfViewProductsItems
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            androidx.recyclerview.widget.RecyclerView r17 = (androidx.recyclerview.widget.RecyclerView) r17
            if (r17 == 0) goto L_0x00be
            int r1 = com.talabat.darkstores.R.id.toolbar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            androidx.appcompat.widget.Toolbar r18 = (androidx.appcompat.widget.Toolbar) r18
            if (r18 == 0) goto L_0x00be
            int r1 = com.talabat.darkstores.R.id.toolbar_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00be
            int r1 = com.talabat.darkstores.R.id.trailingIcons
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            com.talabat.darkstores.feature.product.views.NavigationBarTrailingIcons r20 = (com.talabat.darkstores.feature.product.views.NavigationBarTrailingIcons) r20
            if (r20 == 0) goto L_0x00be
            com.talabat.darkstores.databinding.DarkstoresFragmentSubcategoriesNewBinding r1 = new com.talabat.darkstores.databinding.DarkstoresFragmentSubcategoriesNewBinding
            r3 = r1
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r1
        L_0x00be:
            android.content.res.Resources r0 = r21.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.databinding.DarkstoresFragmentSubcategoriesNewBinding.bind(android.view.View):com.talabat.darkstores.databinding.DarkstoresFragmentSubcategoriesNewBinding");
    }

    @NonNull
    public static DarkstoresFragmentSubcategoriesNewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresFragmentSubcategoriesNewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_fragment_subcategories_new, viewGroup, false);
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
