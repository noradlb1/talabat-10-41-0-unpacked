package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;

public final class DarkstoresItemCategoryTileFitBinding implements ViewBinding {
    @NonNull
    private final ConstraintLayout rootView;

    private DarkstoresItemCategoryTileFitBinding(@NonNull ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    @NonNull
    public static DarkstoresItemCategoryTileFitBinding bind(@NonNull View view) {
        if (view != null) {
            return new DarkstoresItemCategoryTileFitBinding((ConstraintLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DarkstoresItemCategoryTileFitBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemCategoryTileFitBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_category_tile_fit, viewGroup, false);
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
