package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatlife.R;

public final class BottomSheetVendorLocationFilterBinding implements ViewBinding {
    @NonNull
    public final FrameLayout childFragmentContainer;
    @NonNull
    public final LinearLayout containerAll;
    @NonNull
    public final CoordinatorLayout rootView;
    @NonNull
    private final CoordinatorLayout rootView_;

    private BottomSheetVendorLocationFilterBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout, @NonNull CoordinatorLayout coordinatorLayout2) {
        this.rootView_ = coordinatorLayout;
        this.childFragmentContainer = frameLayout;
        this.containerAll = linearLayout;
        this.rootView = coordinatorLayout2;
    }

    @NonNull
    public static BottomSheetVendorLocationFilterBinding bind(@NonNull View view) {
        int i11 = R.id.child_fragment_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i11);
        if (frameLayout != null) {
            i11 = R.id.container_all;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
            if (linearLayout != null) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                return new BottomSheetVendorLocationFilterBinding(coordinatorLayout, frameLayout, linearLayout, coordinatorLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static BottomSheetVendorLocationFilterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static BottomSheetVendorLocationFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_vendor_location_filter, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public CoordinatorLayout getRoot() {
        return this.rootView_;
    }
}
