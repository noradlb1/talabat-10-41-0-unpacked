package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.chip.Chip;
import com.talabat.darkstores.R;

public final class DarkstoresItemSubcategoryChipNewBinding implements ViewBinding {
    @NonNull
    public final Chip chip;
    @NonNull
    private final Chip rootView;

    private DarkstoresItemSubcategoryChipNewBinding(@NonNull Chip chip2, @NonNull Chip chip3) {
        this.rootView = chip2;
        this.chip = chip3;
    }

    @NonNull
    public static DarkstoresItemSubcategoryChipNewBinding bind(@NonNull View view) {
        if (view != null) {
            Chip chip2 = (Chip) view;
            return new DarkstoresItemSubcategoryChipNewBinding(chip2, chip2);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DarkstoresItemSubcategoryChipNewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemSubcategoryChipNewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_subcategory_chip_new, viewGroup, false);
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
