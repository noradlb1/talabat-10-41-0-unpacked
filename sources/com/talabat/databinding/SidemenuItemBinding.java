package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class SidemenuItemBinding implements ViewBinding {
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final ImageView sideMenuItemIcon;
    @NonNull
    public final TalabatTextView sideMenuItemIconTitle;
    @NonNull
    public final RelativeLayout sideMenuItemIconView;

    private SidemenuItemBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView, @NonNull RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.sideMenuItemIcon = imageView;
        this.sideMenuItemIconTitle = talabatTextView;
        this.sideMenuItemIconView = relativeLayout2;
    }

    @NonNull
    public static SidemenuItemBinding bind(@NonNull View view) {
        int i11 = R.id.side_menu_item_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.side_menu_item_icon);
        if (imageView != null) {
            i11 = R.id.side_menu_item_icon_title;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.side_menu_item_icon_title);
            if (talabatTextView != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                return new SidemenuItemBinding(relativeLayout, imageView, talabatTextView, relativeLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static SidemenuItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static SidemenuItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.sidemenu_item, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
