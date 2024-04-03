package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.view.LoadingFailedView;

public final class DarkstoresFragmentSubcategoriesBinding implements ViewBinding {
    @NonNull
    public final RecyclerView headlinesRecyclerView;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final LoadingFailedView subcategoriesErrorView;
    @NonNull
    public final ProgressBar subcategoriesProgress;
    @NonNull
    public final RecyclerView subcategoriesRecyclerView;

    private DarkstoresFragmentSubcategoriesBinding(@NonNull ConstraintLayout constraintLayout, @NonNull RecyclerView recyclerView, @NonNull LoadingFailedView loadingFailedView, @NonNull ProgressBar progressBar, @NonNull RecyclerView recyclerView2) {
        this.rootView = constraintLayout;
        this.headlinesRecyclerView = recyclerView;
        this.subcategoriesErrorView = loadingFailedView;
        this.subcategoriesProgress = progressBar;
        this.subcategoriesRecyclerView = recyclerView2;
    }

    @NonNull
    public static DarkstoresFragmentSubcategoriesBinding bind(@NonNull View view) {
        int i11 = R.id.headlines_recycler_view;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
        if (recyclerView != null) {
            i11 = R.id.subcategories_error_view;
            LoadingFailedView loadingFailedView = (LoadingFailedView) ViewBindings.findChildViewById(view, i11);
            if (loadingFailedView != null) {
                i11 = R.id.subcategories_progress;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i11);
                if (progressBar != null) {
                    i11 = R.id.subcategories_recycler_view;
                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i11);
                    if (recyclerView2 != null) {
                        return new DarkstoresFragmentSubcategoriesBinding((ConstraintLayout) view, recyclerView, loadingFailedView, progressBar, recyclerView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresFragmentSubcategoriesBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresFragmentSubcategoriesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_fragment_subcategories, viewGroup, false);
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
