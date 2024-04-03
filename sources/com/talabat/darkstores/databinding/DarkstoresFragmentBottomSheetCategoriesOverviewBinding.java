package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;
import com.talabat.talabatcommon.views.ShimmerLayout;

public final class DarkstoresFragmentBottomSheetCategoriesOverviewBinding implements ViewBinding {
    @NonNull
    public final ImageView categoryOverviewClose;
    @NonNull
    public final ShimmerLayout loadingLayout;
    @NonNull
    public final LinearLayout noResultsLayout;
    @NonNull
    public final RecyclerView recyclerView;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final SearchView searchView;

    private DarkstoresFragmentBottomSheetCategoriesOverviewBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull ShimmerLayout shimmerLayout, @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView2, @NonNull SearchView searchView2) {
        this.rootView = relativeLayout;
        this.categoryOverviewClose = imageView;
        this.loadingLayout = shimmerLayout;
        this.noResultsLayout = linearLayout;
        this.recyclerView = recyclerView2;
        this.searchView = searchView2;
    }

    @NonNull
    public static DarkstoresFragmentBottomSheetCategoriesOverviewBinding bind(@NonNull View view) {
        int i11 = R.id.category_overview_close;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.loading_layout;
            ShimmerLayout shimmerLayout = (ShimmerLayout) ViewBindings.findChildViewById(view, i11);
            if (shimmerLayout != null) {
                i11 = R.id.no_results_layout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                if (linearLayout != null) {
                    i11 = R.id.recyclerView;
                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i11);
                    if (recyclerView2 != null) {
                        i11 = R.id.searchView;
                        SearchView searchView2 = (SearchView) ViewBindings.findChildViewById(view, i11);
                        if (searchView2 != null) {
                            return new DarkstoresFragmentBottomSheetCategoriesOverviewBinding((RelativeLayout) view, imageView, shimmerLayout, linearLayout, recyclerView2, searchView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresFragmentBottomSheetCategoriesOverviewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresFragmentBottomSheetCategoriesOverviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_fragment_bottom_sheet_categories_overview, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
