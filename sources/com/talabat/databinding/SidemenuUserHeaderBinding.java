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

public final class SidemenuUserHeaderBinding implements ViewBinding {
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final ImageView sideMenuUserAvtarIcon;
    @NonNull
    public final ImageView sideMenuUserCountryIcon;
    @NonNull
    public final TalabatTextView sideMenuUserCountryName;
    @NonNull
    public final ImageView sideMenuUserSettings;
    @NonNull
    public final RelativeLayout sideMenuUserSettingsContainer;
    @NonNull
    public final TalabatTextView sideMenuUserTitle;
    @NonNull
    public final RelativeLayout sidemenuContentView;

    private SidemenuUserHeaderBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TalabatTextView talabatTextView, @NonNull ImageView imageView3, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatTextView talabatTextView2, @NonNull RelativeLayout relativeLayout3) {
        this.rootView = relativeLayout;
        this.sideMenuUserAvtarIcon = imageView;
        this.sideMenuUserCountryIcon = imageView2;
        this.sideMenuUserCountryName = talabatTextView;
        this.sideMenuUserSettings = imageView3;
        this.sideMenuUserSettingsContainer = relativeLayout2;
        this.sideMenuUserTitle = talabatTextView2;
        this.sidemenuContentView = relativeLayout3;
    }

    @NonNull
    public static SidemenuUserHeaderBinding bind(@NonNull View view) {
        int i11 = R.id.side_menu_user_avtar_icon;
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
                        i11 = R.id.side_menu_user_settings_container;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.side_menu_user_settings_container);
                        if (relativeLayout != null) {
                            i11 = R.id.side_menu_user_title;
                            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.side_menu_user_title);
                            if (talabatTextView2 != null) {
                                RelativeLayout relativeLayout2 = (RelativeLayout) view;
                                return new SidemenuUserHeaderBinding(relativeLayout2, imageView, imageView2, talabatTextView, imageView3, relativeLayout, talabatTextView2, relativeLayout2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static SidemenuUserHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static SidemenuUserHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.sidemenu_user_header, viewGroup, false);
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
