package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class CompactSwimlaneItemButtonBinding implements ViewBinding {
    @NonNull
    public final ImageView compactSwimlaneItemButtonIcon;
    @NonNull
    private final View rootView;

    private CompactSwimlaneItemButtonBinding(@NonNull View view, @NonNull ImageView imageView) {
        this.rootView = view;
        this.compactSwimlaneItemButtonIcon = imageView;
    }

    @NonNull
    public static CompactSwimlaneItemButtonBinding bind(@NonNull View view) {
        int i11 = R.id.compact_swimlane_item_button_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            return new CompactSwimlaneItemButtonBinding(view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CompactSwimlaneItemButtonBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.compact_swimlane_item_button, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
