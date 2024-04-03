package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatlife.R;

public final class BottomSheetVendorBranchesBinding implements ViewBinding {
    @NonNull
    public final ConstraintLayout bottomSheet;
    @NonNull
    public final LinearLayout containerAll;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final RecyclerView vendorBottomSheetBranchesRecyclerView;

    private BottomSheetVendorBranchesBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.bottomSheet = constraintLayout2;
        this.containerAll = linearLayout;
        this.vendorBottomSheetBranchesRecyclerView = recyclerView;
    }

    @NonNull
    public static BottomSheetVendorBranchesBinding bind(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i11 = R.id.container_all;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
        if (linearLayout != null) {
            i11 = R.id.vendorBottomSheetBranchesRecyclerView;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
            if (recyclerView != null) {
                return new BottomSheetVendorBranchesBinding(constraintLayout, constraintLayout, linearLayout, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static BottomSheetVendorBranchesBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static BottomSheetVendorBranchesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_vendor_branches, viewGroup, false);
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
