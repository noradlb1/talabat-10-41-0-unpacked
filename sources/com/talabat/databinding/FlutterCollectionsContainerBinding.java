package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class FlutterCollectionsContainerBinding implements ViewBinding {
    @NonNull
    public final FrameLayout collectionsFlutterFragment;
    @NonNull
    private final ConstraintLayout rootView;

    private FlutterCollectionsContainerBinding(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout) {
        this.rootView = constraintLayout;
        this.collectionsFlutterFragment = frameLayout;
    }

    @NonNull
    public static FlutterCollectionsContainerBinding bind(@NonNull View view) {
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.collectionsFlutterFragment);
        if (frameLayout != null) {
            return new FlutterCollectionsContainerBinding((ConstraintLayout) view, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.collectionsFlutterFragment)));
    }

    @NonNull
    public static FlutterCollectionsContainerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FlutterCollectionsContainerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.flutter_collections_container, viewGroup, false);
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
