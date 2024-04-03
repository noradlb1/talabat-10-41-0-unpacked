package com.talabat.core.maps.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.core.maps.presentation.R;

public final class FragmentMapContainerBinding implements ViewBinding {
    @NonNull
    public final FrameLayout fragmentMapContainerRoot;
    @NonNull
    private final FrameLayout rootView;

    private FragmentMapContainerBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.fragmentMapContainerRoot = frameLayout2;
    }

    @NonNull
    public static FragmentMapContainerBinding bind(@NonNull View view) {
        int i11 = R.id.fragment_map_container_root;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i11);
        if (frameLayout != null) {
            return new FragmentMapContainerBinding((FrameLayout) view, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragmentMapContainerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentMapContainerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_map_container, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
