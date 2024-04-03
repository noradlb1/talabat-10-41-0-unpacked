package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.talabatcommon.views.MobileNumberWithOTPView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class LayoutLoginWithMobileBinding implements ViewBinding {
    @NonNull
    public final TalabatFillButton btnLoginWithMobile;
    @NonNull
    public final MobileNumberWithOTPView eTMobileNumber;
    @NonNull
    public final MaterialEditText edtOTP;
    @NonNull
    public final FrameLayout mobilePasswordContainer;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TalabatTextView talabatTextView9;
    @NonNull
    public final TalabatTextView txtCreateAccountWithMobile;
    @NonNull
    public final TalabatTextView txtForgotMobilePassword;

    private LayoutLoginWithMobileBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatFillButton talabatFillButton, @NonNull MobileNumberWithOTPView mobileNumberWithOTPView, @NonNull MaterialEditText materialEditText, @NonNull FrameLayout frameLayout, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3) {
        this.rootView = linearLayout;
        this.btnLoginWithMobile = talabatFillButton;
        this.eTMobileNumber = mobileNumberWithOTPView;
        this.edtOTP = materialEditText;
        this.mobilePasswordContainer = frameLayout;
        this.talabatTextView9 = talabatTextView;
        this.txtCreateAccountWithMobile = talabatTextView2;
        this.txtForgotMobilePassword = talabatTextView3;
    }

    @NonNull
    public static LayoutLoginWithMobileBinding bind(@NonNull View view) {
        int i11 = R.id.btnLoginWithMobile;
        TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view, R.id.btnLoginWithMobile);
        if (talabatFillButton != null) {
            i11 = R.id.eTMobileNumber;
            MobileNumberWithOTPView mobileNumberWithOTPView = (MobileNumberWithOTPView) ViewBindings.findChildViewById(view, R.id.eTMobileNumber);
            if (mobileNumberWithOTPView != null) {
                i11 = R.id.edtOTP;
                MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view, R.id.edtOTP);
                if (materialEditText != null) {
                    i11 = R.id.mobilePasswordContainer;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.mobilePasswordContainer);
                    if (frameLayout != null) {
                        i11 = R.id.talabatTextView9;
                        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.talabatTextView9);
                        if (talabatTextView != null) {
                            i11 = R.id.txtCreateAccountWithMobile;
                            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.txtCreateAccountWithMobile);
                            if (talabatTextView2 != null) {
                                i11 = R.id.txtForgotMobilePassword;
                                TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.txtForgotMobilePassword);
                                if (talabatTextView3 != null) {
                                    return new LayoutLoginWithMobileBinding((LinearLayout) view, talabatFillButton, mobileNumberWithOTPView, materialEditText, frameLayout, talabatTextView, talabatTextView2, talabatTextView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LayoutLoginWithMobileBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LayoutLoginWithMobileBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.layout_login_with_mobile, viewGroup, false);
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
