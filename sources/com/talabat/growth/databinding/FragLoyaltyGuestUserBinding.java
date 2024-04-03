package com.talabat.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.talabat.growth.R;

public final class FragLoyaltyGuestUserBinding implements ViewBinding {
    @NonNull
    public final ImageButton loyaltyGuestBackButton;
    @NonNull
    public final DSPrimaryButton loyaltyGuestLoginButton;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final Toolbar toolbar;

    private FragLoyaltyGuestUserBinding(@NonNull LinearLayout linearLayout, @NonNull ImageButton imageButton, @NonNull DSPrimaryButton dSPrimaryButton, @NonNull Toolbar toolbar2) {
        this.rootView = linearLayout;
        this.loyaltyGuestBackButton = imageButton;
        this.loyaltyGuestLoginButton = dSPrimaryButton;
        this.toolbar = toolbar2;
    }

    @NonNull
    public static FragLoyaltyGuestUserBinding bind(@NonNull View view) {
        int i11 = R.id.loyaltyGuestBackButton;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i11);
        if (imageButton != null) {
            i11 = R.id.loyaltyGuestLoginButton;
            DSPrimaryButton dSPrimaryButton = (DSPrimaryButton) ViewBindings.findChildViewById(view, i11);
            if (dSPrimaryButton != null) {
                i11 = R.id.toolbar;
                Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view, i11);
                if (toolbar2 != null) {
                    return new FragLoyaltyGuestUserBinding((LinearLayout) view, imageButton, dSPrimaryButton, toolbar2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragLoyaltyGuestUserBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragLoyaltyGuestUserBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.frag_loyalty_guest_user, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
