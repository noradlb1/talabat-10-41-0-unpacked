package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputLayout;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class ActivityWalletAddCreditCardScreenBinding implements ViewBinding {
    @NonNull
    public final ImageButton back;
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
    public final ConstraintLayout header;
    @NonNull
    public final TextView learnMore;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    public final CoordinatorLayout rootView;
    @NonNull
    private final CoordinatorLayout rootView_;
    @NonNull
    public final TalabatFillButton saveButton;
    @NonNull
    public final EditText securityCode;
    @NonNull
    public final TextInputLayout securityCodeContainer;
    @NonNull
    public final TextView securityCodeError;
    @NonNull
    public final RelativeLayout talabatToolbar;
    @NonNull
    public final TalabatTextView title;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final TalabatTextView yourPaymentInfo;

    private ActivityWalletAddCreditCardScreenBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ImageButton imageButton, @NonNull EditText editText, @NonNull TextInputLayout textInputLayout, @NonNull EditText editText2, @NonNull TextView textView, @NonNull TextInputLayout textInputLayout2, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull ConstraintLayout constraintLayout, @NonNull TextView textView3, @NonNull ProgressBar progressBar2, @NonNull CoordinatorLayout coordinatorLayout2, @NonNull TalabatFillButton talabatFillButton, @NonNull EditText editText3, @NonNull TextInputLayout textInputLayout3, @NonNull TextView textView4, @NonNull RelativeLayout relativeLayout, @NonNull TalabatTextView talabatTextView, @NonNull Toolbar toolbar2, @NonNull TalabatTextView talabatTextView2) {
        this.rootView_ = coordinatorLayout;
        this.back = imageButton;
        this.cardExpiryDate = editText;
        this.cardExpiryDateContainer = textInputLayout;
        this.cardNumberEditText = editText2;
        this.cardNumberError = textView;
        this.cardNumberInputLayout = textInputLayout2;
        this.creditCardLogo = imageView;
        this.expiryDateError = textView2;
        this.header = constraintLayout;
        this.learnMore = textView3;
        this.progressBar = progressBar2;
        this.rootView = coordinatorLayout2;
        this.saveButton = talabatFillButton;
        this.securityCode = editText3;
        this.securityCodeContainer = textInputLayout3;
        this.securityCodeError = textView4;
        this.talabatToolbar = relativeLayout;
        this.title = talabatTextView;
        this.toolbar = toolbar2;
        this.yourPaymentInfo = talabatTextView2;
    }

    @NonNull
    public static ActivityWalletAddCreditCardScreenBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.back;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view2, R.id.back);
        if (imageButton != null) {
            i11 = R.id.card_expiry_date;
            EditText editText = (EditText) ViewBindings.findChildViewById(view2, R.id.card_expiry_date);
            if (editText != null) {
                i11 = R.id.card_expiry_date_container;
                TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view2, R.id.card_expiry_date_container);
                if (textInputLayout != null) {
                    i11 = R.id.card_number_edit_text;
                    EditText editText2 = (EditText) ViewBindings.findChildViewById(view2, R.id.card_number_edit_text);
                    if (editText2 != null) {
                        i11 = R.id.card_number_error;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.card_number_error);
                        if (textView != null) {
                            i11 = R.id.card_number_input_layout;
                            TextInputLayout textInputLayout2 = (TextInputLayout) ViewBindings.findChildViewById(view2, R.id.card_number_input_layout);
                            if (textInputLayout2 != null) {
                                i11 = R.id.credit_card_logo;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.credit_card_logo);
                                if (imageView != null) {
                                    i11 = R.id.expiry_date_error;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.expiry_date_error);
                                    if (textView2 != null) {
                                        i11 = R.id.header;
                                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, R.id.header);
                                        if (constraintLayout != null) {
                                            i11 = R.id.learn_more;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.learn_more);
                                            if (textView3 != null) {
                                                i11 = R.id.progress_bar;
                                                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.progress_bar);
                                                if (progressBar2 != null) {
                                                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view2;
                                                    i11 = R.id.save_button;
                                                    TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.save_button);
                                                    if (talabatFillButton != null) {
                                                        i11 = R.id.security_code;
                                                        EditText editText3 = (EditText) ViewBindings.findChildViewById(view2, R.id.security_code);
                                                        if (editText3 != null) {
                                                            i11 = R.id.security_code_container;
                                                            TextInputLayout textInputLayout3 = (TextInputLayout) ViewBindings.findChildViewById(view2, R.id.security_code_container);
                                                            if (textInputLayout3 != null) {
                                                                i11 = R.id.security_code_error;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.security_code_error);
                                                                if (textView4 != null) {
                                                                    i11 = R.id.talabat_toolbar;
                                                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.talabat_toolbar);
                                                                    if (relativeLayout != null) {
                                                                        i11 = R.id.title;
                                                                        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                                        if (talabatTextView != null) {
                                                                            i11 = R.id.toolbar;
                                                                            Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                            if (toolbar2 != null) {
                                                                                i11 = R.id.your_payment_info;
                                                                                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.your_payment_info);
                                                                                if (talabatTextView2 != null) {
                                                                                    return new ActivityWalletAddCreditCardScreenBinding(coordinatorLayout, imageButton, editText, textInputLayout, editText2, textView, textInputLayout2, imageView, textView2, constraintLayout, textView3, progressBar2, coordinatorLayout, talabatFillButton, editText3, textInputLayout3, textView4, relativeLayout, talabatTextView, toolbar2, talabatTextView2);
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
    public static ActivityWalletAddCreditCardScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityWalletAddCreditCardScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_wallet_add_credit_card_screen, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public CoordinatorLayout getRoot() {
        return this.rootView_;
    }
}
