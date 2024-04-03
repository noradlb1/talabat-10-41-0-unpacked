package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.R;

public final class SideMenuPaddingViewBinding implements ViewBinding {
    @NonNull
    private final ImageView rootView;
    @NonNull
    public final ImageView sideMenuPaddingView;

    private SideMenuPaddingViewBinding(@NonNull ImageView imageView, @NonNull ImageView imageView2) {
        this.rootView = imageView;
        this.sideMenuPaddingView = imageView2;
    }

    @NonNull
    public static SideMenuPaddingViewBinding bind(@NonNull View view) {
        if (view != null) {
            ImageView imageView = (ImageView) view;
            return new SideMenuPaddingViewBinding(imageView, imageView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static SideMenuPaddingViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static SideMenuPaddingViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.side_menu_padding_view, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ImageView getRoot() {
        return this.rootView;
    }
}
