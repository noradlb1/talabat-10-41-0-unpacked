package com.talabat.userandlocation.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_bottom_sheet.DSBottomSheetContents;
import com.talabat.userandlocation.login.R;

public final class LayoutLoginBottomSheetBinding implements ViewBinding {
    @NonNull
    public final DSBottomSheetContents bottomSheetContents;
    @NonNull
    private final ConstraintLayout rootView;

    private LayoutLoginBottomSheetBinding(@NonNull ConstraintLayout constraintLayout, @NonNull DSBottomSheetContents dSBottomSheetContents) {
        this.rootView = constraintLayout;
        this.bottomSheetContents = dSBottomSheetContents;
    }

    @NonNull
    public static LayoutLoginBottomSheetBinding bind(@NonNull View view) {
        int i11 = R.id.bottom_sheet_contents;
        DSBottomSheetContents dSBottomSheetContents = (DSBottomSheetContents) ViewBindings.findChildViewById(view, i11);
        if (dSBottomSheetContents != null) {
            return new LayoutLoginBottomSheetBinding((ConstraintLayout) view, dSBottomSheetContents);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LayoutLoginBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LayoutLoginBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.layout_login_bottom_sheet, viewGroup, false);
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
