package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class UserAccountHeaderBinding implements ViewBinding {
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final FrameLayout settingsContainer;
    @NonNull
    public final ImageView sideMenuUserAvtarIcon;
    @NonNull
    public final ImageView sideMenuUserCountryIcon;
    @NonNull
    public final TalabatTextView sideMenuUserCountryName;
    @NonNull
    public final ImageView sideMenuUserSettings;
    @NonNull
    public final TalabatTextView sideMenuUserTitle;
    @NonNull
    public final ConstraintLayout sidemenuContentView;

    private UserAccountHeaderBinding(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TalabatTextView talabatTextView, @NonNull ImageView imageView3, @NonNull TalabatTextView talabatTextView2, @NonNull ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.settingsContainer = frameLayout;
        this.sideMenuUserAvtarIcon = imageView;
        this.sideMenuUserCountryIcon = imageView2;
        this.sideMenuUserCountryName = talabatTextView;
        this.sideMenuUserSettings = imageView3;
        this.sideMenuUserTitle = talabatTextView2;
        this.sidemenuContentView = constraintLayout2;
    }

    @NonNull
    public static UserAccountHeaderBinding bind(@NonNull View view) {
        int i11 = R.id.settings_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.settings_container);
        if (frameLayout != null) {
            i11 = R.id.side_menu_user_avtar_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.side_menu_user_avtar_icon);
            if (imageView != null) {
                i11 = R.id.side_menu_user_country_icon;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.side_menu_user_country_icon);
                if (imageView2 != null) {
                    i11 = R.id.side_menu_user_country_name;
                    TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.side_menu_user_country_name);
                    if (talabatTextView != null) {
                        i11 = R.id.side_menu_user_settings;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.side_menu_user_settings);
                        if (imageView3 != null) {
                            i11 = R.id.side_menu_user_title;
                            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.side_menu_user_title);
                            if (talabatTextView2 != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                return new UserAccountHeaderBinding(constraintLayout, frameLayout, imageView, imageView2, talabatTextView, imageView3, talabatTextView2, constraintLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static UserAccountHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static UserAccountHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.user_account_header, viewGroup, false);
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
