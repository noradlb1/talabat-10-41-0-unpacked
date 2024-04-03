package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputLayout;
import com.talabat.talabatcommon.R;

public final class ViewWalletAddCardBinding implements ViewBinding {
    @NonNull
    public final EditText cardExpiryDate;
    @NonNull
    public final TextInputLayout cardExpiryDateContainer;
    @NonNull
    public final EditText cardNumberEditText;
    @NonNull
    public final TextView cardNumberError;
    @NonNull
    public final TextInputLayout cardNumberInputLayout;
    @NonNull
    public final ImageView creditCardLogo;
    @NonNull
    public final TextView expiryDateError;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final EditText securityCode;
    @NonNull
    public final TextInputLayout securityCodeContainer;
    @NonNull
    public final TextView securityCodeError;

    private ViewWalletAddCardBinding(@NonNull ConstraintLayout constraintLayout, @NonNull EditText editText, @NonNull TextInputLayout textInputLayout, @NonNull EditText editText2, @NonNull TextView textView, @NonNull TextInputLayout textInputLayout2, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull EditText editText3, @NonNull TextInputLayout textInputLayout3, @NonNull TextView textView3) {
        this.rootView = constraintLayout;
        this.cardExpiryDate = editText;
        this.cardExpiryDateContainer = textInputLayout;
        this.cardNumberEditText = editText2;
        this.cardNumberError = textView;
        this.cardNumberInputLayout = textInputLayout2;
        this.creditCardLogo = imageView;
        this.expiryDateError = textView2;
        this.securityCode = editText3;
        this.securityCodeContainer = textInputLayout3;
        this.securityCodeError = textView3;
    }

    @NonNull
    public static ViewWalletAddCardBinding bind(@NonNull View view) {
        int i11 = R.id.card_expiry_date;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, i11);
        if (editText != null) {
            i11 = R.id.card_expiry_date_container;
            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, i11);
            if (textInputLayout != null) {
                i11 = R.id.card_number_edit_text;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i11);
                if (editText2 != null) {
                    i11 = R.id.card_number_error;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView != null) {
                        i11 = R.id.card_number_input_layout;
                        TextInputLayout textInputLayout2 = (TextInputLayout) ViewBindings.findChildViewById(view, i11);
                        if (textInputLayout2 != null) {
                            i11 = R.id.credit_card_logo;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                            if (imageView != null) {
                                i11 = R.id.expiry_date_error;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                                if (textView2 != null) {
                                    i11 = R.id.security_code;
                                    EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i11);
                                    if (editText3 != null) {
                                        i11 = R.id.security_code_container;
                                        TextInputLayout textInputLayout3 = (TextInputLayout) ViewBindings.findChildViewById(view, i11);
                                        if (textInputLayout3 != null) {
                                            i11 = R.id.security_code_error;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                                            if (textView3 != null) {
                                                return new ViewWalletAddCardBinding((ConstraintLayout) view, editText, textInputLayout, editText2, textView, textInputLayout2, imageView, textView2, editText3, textInputLayout3, textView3);
                                            }
                                        }
                                    }
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
    public static ViewWalletAddCardBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewWalletAddCardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_wallet_add_card, viewGroup, false);
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
