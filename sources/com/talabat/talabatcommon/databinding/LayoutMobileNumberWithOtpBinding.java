package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.views.MobileNumberEditText;

public final class LayoutMobileNumberWithOtpBinding implements ViewBinding {
    @NonNull
    public final MobileNumberEditText edtMobileNumber;
    @NonNull
    private final View rootView;
    @NonNull
    public final AppCompatTextView txtGetOTP;

    private LayoutMobileNumberWithOtpBinding(@NonNull View view, @NonNull MobileNumberEditText mobileNumberEditText, @NonNull AppCompatTextView appCompatTextView) {
        this.rootView = view;
        this.edtMobileNumber = mobileNumberEditText;
        this.txtGetOTP = appCompatTextView;
    }

    @NonNull
    public static LayoutMobileNumberWithOtpBinding bind(@NonNull View view) {
        int i11 = R.id.edtMobileNumber;
        MobileNumberEditText mobileNumberEditText = (MobileNumberEditText) ViewBindings.findChildViewById(view, i11);
        if (mobileNumberEditText != null) {
            i11 = R.id.txtGetOTP;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
            if (appCompatTextView != null) {
                return new LayoutMobileNumberWithOtpBinding(view, mobileNumberEditText, appCompatTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LayoutMobileNumberWithOtpBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.layout_mobile_number_with_otp, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
