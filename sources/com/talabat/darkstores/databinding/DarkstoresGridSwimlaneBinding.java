package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.Barrier;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.home.categories.CategoriesMissionView;

public final class DarkstoresGridSwimlaneBinding implements ViewBinding {
    @NonNull
    public final Barrier barrier;
    @NonNull
    public final AppCompatImageButton btnViewAll;
    @NonNull
    public final RecyclerView recyclerView;
    @NonNull
    private final View rootView;
    @NonNull
    public final CategoriesMissionView topTwoCategoriesView;
    @NonNull
    public final TextView tvTitle;

    private DarkstoresGridSwimlaneBinding(@NonNull View view, @NonNull Barrier barrier2, @NonNull AppCompatImageButton appCompatImageButton, @NonNull RecyclerView recyclerView2, @NonNull CategoriesMissionView categoriesMissionView, @NonNull TextView textView) {
        this.rootView = view;
        this.barrier = barrier2;
        this.btnViewAll = appCompatImageButton;
        this.recyclerView = recyclerView2;
        this.topTwoCategoriesView = categoriesMissionView;
        this.tvTitle = textView;
    }

    @NonNull
    public static DarkstoresGridSwimlaneBinding bind(@NonNull View view) {
        int i11 = R.id.barrier;
        Barrier barrier2 = (Barrier) ViewBindings.findChildViewById(view, i11);
        if (barrier2 != null) {
            i11 = R.id.btnViewAll;
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i11);
            if (appCompatImageButton != null) {
                i11 = R.id.recyclerView;
                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i11);
                if (recyclerView2 != null) {
                    i11 = R.id.topTwoCategoriesView;
                    CategoriesMissionView categoriesMissionView = (CategoriesMissionView) ViewBindings.findChildViewById(view, i11);
                    if (categoriesMissionView != null) {
                        i11 = R.id.tvTitle;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView != null) {
                            return new DarkstoresGridSwimlaneBinding(view, barrier2, appCompatImageButton, recyclerView2, categoriesMissionView, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresGridSwimlaneBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.darkstores_grid_swimlane, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
