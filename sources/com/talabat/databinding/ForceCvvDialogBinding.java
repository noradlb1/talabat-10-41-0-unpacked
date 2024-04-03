package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.designhelpers.PinEntryEditText.PinView;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.TalabatStrokeButton;

public final class ForceCvvDialogBinding implements ViewBinding {
    @NonNull
    public final TalabatStrokeButton cancelCvv;
    @NonNull
    public final ImageView cvvIcon;
    @NonNull
    public final PinView cvvPin;
    @NonNull
    public final TalabatTextView headerPayWithString;
    @NonNull
    public final TalabatFillButton payCvv;
    @NonNull
    private final LinearLayout rootView;

    private ForceCvvDialogBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatStrokeButton talabatStrokeButton, @NonNull ImageView imageView, @NonNull PinView pinView, @NonNull TalabatTextView talabatTextView, @NonNull TalabatFillButton talabatFillButton) {
        this.rootView = linearLayout;
        this.cancelCvv = talabatStrokeButton;
        this.cvvIcon = imageView;
        this.cvvPin = pinView;
        this.headerPayWithString = talabatTextView;
        this.payCvv = talabatFillButton;
    }

    @NonNull
    public static ForceCvvDialogBinding bind(@NonNull View view) {
        int i11 = R.id.cancel_cvv;
        TalabatStrokeButton talabatStrokeButton = (TalabatStrokeButton) ViewBindings.findChildViewById(view, R.id.cancel_cvv);
        if (talabatStrokeButton != null) {
            i11 = R.id.cvv_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.cvv_icon);
            if (imageView != null) {
                i11 = R.id.cvv_pin;
                PinView pinView = (PinView) ViewBindings.findChildViewById(view, R.id.cvv_pin);
                if (pinView != null) {
                    i11 = R.id.header_pay_with_string;
                    TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.header_pay_with_string);
                    if (talabatTextView != null) {
                        i11 = R.id.pay_cvv;
                        TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view, R.id.pay_cvv);
                        if (talabatFillButton != null) {
                            return new ForceCvvDialogBinding((LinearLayout) view, talabatStrokeButton, imageView, pinView, talabatTextView, talabatFillButton);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ForceCvvDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ForceCvvDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.force_cvv_dialog, viewGroup, false);
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
