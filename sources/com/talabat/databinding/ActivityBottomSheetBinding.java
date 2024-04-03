package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_button.DSPrimaryButton;
import com.talabat.R;

public final class ActivityBottomSheetBinding implements ViewBinding {
    @NonNull
    public final DSPrimaryButton bottomSheetButton;
    @NonNull
    private final ConstraintLayout rootView;

    private ActivityBottomSheetBinding(@NonNull ConstraintLayout constraintLayout, @NonNull DSPrimaryButton dSPrimaryButton) {
        this.rootView = constraintLayout;
        this.bottomSheetButton = dSPrimaryButton;
    }

    @NonNull
    public static ActivityBottomSheetBinding bind(@NonNull View view) {
        DSPrimaryButton dSPrimaryButton = (DSPrimaryButton) ViewBindings.findChildViewById(view, R.id.bottom_sheet_button);
        if (dSPrimaryButton != null) {
            return new ActivityBottomSheetBinding((ConstraintLayout) view, dSPrimaryButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.bottom_sheet_button)));
    }

    @NonNull
    public static ActivityBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_bottom_sheet, viewGroup, false);
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
