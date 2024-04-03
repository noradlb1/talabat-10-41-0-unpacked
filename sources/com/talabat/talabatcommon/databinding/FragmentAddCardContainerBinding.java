package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.talabatcommon.R;

public final class FragmentAddCardContainerBinding implements ViewBinding {
    @NonNull
    public final FrameLayout fragmentContainer;
    @NonNull
    private final FrameLayout rootView;

    private FragmentAddCardContainerBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.fragmentContainer = frameLayout2;
    }

    @NonNull
    public static FragmentAddCardContainerBinding bind(@NonNull View view) {
        if (view != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            return new FragmentAddCardContainerBinding(frameLayout, frameLayout);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static FragmentAddCardContainerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentAddCardContainerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_add_card_container, viewGroup, false);
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
