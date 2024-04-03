package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class LoginWithEmailContainerBinding implements ViewBinding {
    @NonNull
    public final TalabatFillButton btnLogin;
    @NonNull
    public final MaterialEditText eTEmail;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TalabatTextView talabatTextView9;
    @NonNull
    public final TalabatTextView txtCreateAccount;
    @NonNull
    public final TalabatTextView txtForgot;

    private LoginWithEmailContainerBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatFillButton talabatFillButton, @NonNull MaterialEditText materialEditText, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3) {
        this.rootView = linearLayout;
        this.btnLogin = talabatFillButton;
        this.eTEmail = materialEditText;
        this.talabatTextView9 = talabatTextView;
        this.txtCreateAccount = talabatTextView2;
        this.txtForgot = talabatTextView3;
    }

    @NonNull
    public static LoginWithEmailContainerBinding bind(@NonNull View view) {
        int i11 = R.id.btnLogin;
        TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view, R.id.btnLogin);
        if (talabatFillButton != null) {
            i11 = R.id.eTEmail;
            MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view, R.id.eTEmail);
            if (materialEditText != null) {
                i11 = R.id.talabatTextView9;
                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.talabatTextView9);
                if (talabatTextView != null) {
                    i11 = R.id.txtCreateAccount;
                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.txtCreateAccount);
                    if (talabatTextView2 != null) {
                        i11 = R.id.txtForgot;
                        TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.txtForgot);
                        if (talabatTextView3 != null) {
                            return new LoginWithEmailContainerBinding((LinearLayout) view, talabatFillButton, materialEditText, talabatTextView, talabatTextView2, talabatTextView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LoginWithEmailContainerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LoginWithEmailContainerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.login_with_email_container, viewGroup, false);
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
