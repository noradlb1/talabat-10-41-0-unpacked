package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.view.GridSwimlaneView;

public final class DarkstoresItemCategoryGridBinding implements ViewBinding {
    @NonNull
    public final GridSwimlaneView gridCategoriesSwimlane;
    @NonNull
    private final ConstraintLayout rootView;

    private DarkstoresItemCategoryGridBinding(@NonNull ConstraintLayout constraintLayout, @NonNull GridSwimlaneView gridSwimlaneView) {
        this.rootView = constraintLayout;
        this.gridCategoriesSwimlane = gridSwimlaneView;
    }

    @NonNull
    public static DarkstoresItemCategoryGridBinding bind(@NonNull View view) {
        int i11 = R.id.gridCategoriesSwimlane;
        GridSwimlaneView gridSwimlaneView = (GridSwimlaneView) ViewBindings.findChildViewById(view, i11);
        if (gridSwimlaneView != null) {
            return new DarkstoresItemCategoryGridBinding((ConstraintLayout) view, gridSwimlaneView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresItemCategoryGridBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemCategoryGridBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_category_grid, viewGroup, false);
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
