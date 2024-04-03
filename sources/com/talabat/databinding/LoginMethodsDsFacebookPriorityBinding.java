package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_branded_button.DSBrandedButton;
import com.designsystem.ds_branded_button.DSFacebookBrandedButton;
import com.designsystem.ds_branded_button.DSGoogleBrandedButton;
import com.facebook.login.widget.LoginButton;
import com.talabat.R;

public final class LoginMethodsDsFacebookPriorityBinding implements ViewBinding {
    @NonNull
    public final LoginButton authButton;
    @NonNull
    public final DSBrandedButton btnEmail;
    @NonNull
    public final DSFacebookBrandedButton btnFacebook;
    @NonNull
    public final DSGoogleBrandedButton btnGoogle;
    @NonNull
    public final DSBrandedButton btnMobile;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final LinearLayout socialBtnContainer;

    private LoginMethodsDsFacebookPriorityBinding(@NonNull LinearLayout linearLayout, @NonNull LoginButton loginButton, @NonNull DSBrandedButton dSBrandedButton, @NonNull DSFacebookBrandedButton dSFacebookBrandedButton, @NonNull DSGoogleBrandedButton dSGoogleBrandedButton, @NonNull DSBrandedButton dSBrandedButton2, @NonNull LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.authButton = loginButton;
        this.btnEmail = dSBrandedButton;
        this.btnFacebook = dSFacebookBrandedButton;
        this.btnGoogle = dSGoogleBrandedButton;
        this.btnMobile = dSBrandedButton2;
        this.socialBtnContainer = linearLayout2;
    }

    @NonNull
    public static LoginMethodsDsFacebookPriorityBinding bind(@NonNull View view) {
        int i11 = R.id.authButton;
        LoginButton loginButton = (LoginButton) ViewBindings.findChildViewById(view, R.id.authButton);
        if (loginButton != null) {
            i11 = R.id.btn_email;
            DSBrandedButton dSBrandedButton = (DSBrandedButton) ViewBindings.findChildViewById(view, R.id.btn_email);
            if (dSBrandedButton != null) {
                i11 = R.id.btn_facebook;
                DSFacebookBrandedButton dSFacebookBrandedButton = (DSFacebookBrandedButton) ViewBindings.findChildViewById(view, R.id.btn_facebook);
                if (dSFacebookBrandedButton != null) {
                    i11 = R.id.btn_google;
                    DSGoogleBrandedButton dSGoogleBrandedButton = (DSGoogleBrandedButton) ViewBindings.findChildViewById(view, R.id.btn_google);
                    if (dSGoogleBrandedButton != null) {
                        i11 = R.id.btn_mobile;
                        DSBrandedButton dSBrandedButton2 = (DSBrandedButton) ViewBindings.findChildViewById(view, R.id.btn_mobile);
                        if (dSBrandedButton2 != null) {
                            LinearLayout linearLayout = (LinearLayout) view;
                            return new LoginMethodsDsFacebookPriorityBinding(linearLayout, loginButton, dSBrandedButton, dSFacebookBrandedButton, dSGoogleBrandedButton, dSBrandedButton2, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LoginMethodsDsFacebookPriorityBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LoginMethodsDsFacebookPriorityBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.login_methods_ds_facebook_priority, viewGroup, false);
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
