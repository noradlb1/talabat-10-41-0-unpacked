package com.talabat.homescreen.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.gem.adapters.presentation.home.entrypoint.GemHomeEntryPointView;
import com.talabat.homescreen.R;

public final class LayoutGemWidgetBinding implements ViewBinding {
    @NonNull
    public final GemHomeEntryPointView gemHomeEntryPoint;
    @NonNull
    private final View rootView;

    private LayoutGemWidgetBinding(@NonNull View view, @NonNull GemHomeEntryPointView gemHomeEntryPointView) {
        this.rootView = view;
        this.gemHomeEntryPoint = gemHomeEntryPointView;
    }

    @NonNull
    public static LayoutGemWidgetBinding bind(@NonNull View view) {
        int i11 = R.id.gemHomeEntryPoint;
        GemHomeEntryPointView gemHomeEntryPointView = (GemHomeEntryPointView) ViewBindings.findChildViewById(view, i11);
        if (gemHomeEntryPointView != null) {
            return new LayoutGemWidgetBinding(view, gemHomeEntryPointView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LayoutGemWidgetBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.layout_gem_widget, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
