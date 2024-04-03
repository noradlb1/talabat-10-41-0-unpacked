package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_counter.DSCounter;
import com.designsystem.ds_icon_button.DSIconButton;
import com.talabat.darkstores.R;

public final class DarkstoresNavigationBarTrailingIconsBinding implements ViewBinding {
    @NonNull
    public final DSIconButton bagIconButton;
    @NonNull
    public final DSCounter cartCounter;
    @NonNull
    private final View rootView;

    private DarkstoresNavigationBarTrailingIconsBinding(@NonNull View view, @NonNull DSIconButton dSIconButton, @NonNull DSCounter dSCounter) {
        this.rootView = view;
        this.bagIconButton = dSIconButton;
        this.cartCounter = dSCounter;
    }

    @NonNull
    public static DarkstoresNavigationBarTrailingIconsBinding bind(@NonNull View view) {
        int i11 = R.id.bagIconButton;
        DSIconButton dSIconButton = (DSIconButton) ViewBindings.findChildViewById(view, i11);
        if (dSIconButton != null) {
            i11 = R.id.cartCounter;
            DSCounter dSCounter = (DSCounter) ViewBindings.findChildViewById(view, i11);
            if (dSCounter != null) {
                return new DarkstoresNavigationBarTrailingIconsBinding(view, dSIconButton, dSCounter);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresNavigationBarTrailingIconsBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.darkstores_navigation_bar_trailing_icons, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
