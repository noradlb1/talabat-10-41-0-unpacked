package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.chip.Chip;
import com.talabat.darkstores.R;

public final class DarkstoresItemSearchCategoryBinding implements ViewBinding {
    @NonNull
    private final Chip rootView;
    @NonNull
    public final Chip searchCategoryChip;

    private DarkstoresItemSearchCategoryBinding(@NonNull Chip chip, @NonNull Chip chip2) {
        this.rootView = chip;
        this.searchCategoryChip = chip2;
    }

    @NonNull
    public static DarkstoresItemSearchCategoryBinding bind(@NonNull View view) {
        if (view != null) {
            Chip chip = (Chip) view;
            return new DarkstoresItemSearchCategoryBinding(chip, chip);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DarkstoresItemSearchCategoryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemSearchCategoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_search_category, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public Chip getRoot() {
        return this.rootView;
    }
}
