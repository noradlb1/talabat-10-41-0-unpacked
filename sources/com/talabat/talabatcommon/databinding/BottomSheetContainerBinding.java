package com.talabat.talabatcommon.databinding;

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
import com.talabat.talabatcommon.R;

public final class BottomSheetContainerBinding implements ViewBinding {
    @NonNull
    public final FrameLayout childFragmentContainer;
    @NonNull
    public final LinearLayout containerAll;
    @NonNull
    public final CoordinatorLayout rootView;
    @NonNull
    private final CoordinatorLayout rootView_;

    private BottomSheetContainerBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout, @NonNull CoordinatorLayout coordinatorLayout2) {
        this.rootView_ = coordinatorLayout;
        this.childFragmentContainer = frameLayout;
        this.containerAll = linearLayout;
        this.rootView = coordinatorLayout2;
    }

    @NonNull
    public static BottomSheetContainerBinding bind(@NonNull View view) {
        int i11 = R.id.child_fragment_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i11);
        if (frameLayout != null) {
            i11 = R.id.container_all;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
            if (linearLayout != null) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                return new BottomSheetContainerBinding(coordinatorLayout, frameLayout, linearLayout, coordinatorLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static BottomSheetContainerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static BottomSheetContainerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_container, viewGroup, false);
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
