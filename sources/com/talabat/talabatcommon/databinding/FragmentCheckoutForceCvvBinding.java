package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.materialedittext.MaterialEditText;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class FragmentCheckoutForceCvvBinding implements ViewBinding {
    @NonNull
    public final ImageView cancelButton;
    @NonNull
    public final MaterialEditText checkoutSecurityCode;
    @NonNull
    public final TextView forceCvvMessage;
    @NonNull
    public final TextView header;
    @NonNull
    public final ImageView icCvvSample;
    @NonNull
    public final TalabatFillButton payButton;
    @NonNull
    private final ConstraintLayout rootView;

    private FragmentCheckoutForceCvvBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull MaterialEditText materialEditText, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView2, @NonNull TalabatFillButton talabatFillButton) {
        this.rootView = constraintLayout;
        this.cancelButton = imageView;
        this.checkoutSecurityCode = materialEditText;
        this.forceCvvMessage = textView;
        this.header = textView2;
        this.icCvvSample = imageView2;
        this.payButton = talabatFillButton;
    }

    @NonNull
    public static FragmentCheckoutForceCvvBinding bind(@NonNull View view) {
        int i11 = R.id.cancel_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.checkout_security_code;
            MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view, i11);
            if (materialEditText != null) {
                i11 = R.id.force_cvv_message;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView != null) {
                    i11 = R.id.header;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView2 != null) {
                        i11 = R.id.ic_cvv_sample;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
                        if (imageView2 != null) {
                            i11 = R.id.pay_button;
                            TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view, i11);
                            if (talabatFillButton != null) {
                                return new FragmentCheckoutForceCvvBinding((ConstraintLayout) view, imageView, materialEditText, textView, textView2, imageView2, talabatFillButton);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragmentCheckoutForceCvvBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentCheckoutForceCvvBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_checkout_force_cvv, viewGroup, false);
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
