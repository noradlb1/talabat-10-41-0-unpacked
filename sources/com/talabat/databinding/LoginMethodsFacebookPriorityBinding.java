package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.login.widget.LoginButton;
import com.talabat.R;

public final class LoginMethodsFacebookPriorityBinding implements ViewBinding {
    @NonNull
    public final LoginButton authButton;
    @NonNull
    public final Button btnEmail;
    @NonNull
    public final Button btnFacebook;
    @NonNull
    public final Button btnGoogle;
    @NonNull
    public final Button btnMobile;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final LinearLayout socialBtnContainer;

    private LoginMethodsFacebookPriorityBinding(@NonNull LinearLayout linearLayout, @NonNull LoginButton loginButton, @NonNull Button button, @NonNull Button button2, @NonNull Button button3, @NonNull Button button4, @NonNull LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.authButton = loginButton;
        this.btnEmail = button;
        this.btnFacebook = button2;
        this.btnGoogle = button3;
        this.btnMobile = button4;
        this.socialBtnContainer = linearLayout2;
    }

    @NonNull
    public static LoginMethodsFacebookPriorityBinding bind(@NonNull View view) {
        int i11 = R.id.authButton;
        LoginButton loginButton = (LoginButton) ViewBindings.findChildViewById(view, R.id.authButton);
        if (loginButton != null) {
            i11 = R.id.btn_email;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.btn_email);
            if (button != null) {
                i11 = R.id.btn_facebook;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.btn_facebook);
                if (button2 != null) {
                    i11 = R.id.btn_google;
                    Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.btn_google);
                    if (button3 != null) {
                        i11 = R.id.btn_mobile;
                        Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.btn_mobile);
                        if (button4 != null) {
                            LinearLayout linearLayout = (LinearLayout) view;
                            return new LoginMethodsFacebookPriorityBinding(linearLayout, loginButton, button, button2, button3, button4, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LoginMethodsFacebookPriorityBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LoginMethodsFacebookPriorityBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.login_methods_facebook_priority, viewGroup, false);
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
