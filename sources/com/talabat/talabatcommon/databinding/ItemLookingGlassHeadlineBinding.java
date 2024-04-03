package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.chip.Chip;
import com.talabat.talabatcommon.R;

public final class ItemLookingGlassHeadlineBinding implements ViewBinding {
    @NonNull
    public final Chip glassHeadline;
    @NonNull
    private final Chip rootView;

    private ItemLookingGlassHeadlineBinding(@NonNull Chip chip, @NonNull Chip chip2) {
        this.rootView = chip;
        this.glassHeadline = chip2;
    }

    @NonNull
    public static ItemLookingGlassHeadlineBinding bind(@NonNull View view) {
        if (view != null) {
            Chip chip = (Chip) view;
            return new ItemLookingGlassHeadlineBinding(chip, chip);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ItemLookingGlassHeadlineBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemLookingGlassHeadlineBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_looking_glass_headline, viewGroup, false);
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
