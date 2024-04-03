package com.talabat.databinding;

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
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class TalabatCreditThankyouBinding implements ViewBinding {
    @NonNull
    public final ImageButton back;
    @NonNull
    public final TalabatTextView resultPaymentId;
    @NonNull
    public final TalabatTextView resultReferenceId;
    @NonNull
    public final TalabatTextView resultStatus;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TalabatFillButton talabatCreditHomeButton;
    @NonNull
    public final TalabatTextView talabatCreditMessage;
    @NonNull
    public final TalabatTextView title;
    @NonNull
    public final Toolbar toolbar;

    private TalabatCreditThankyouBinding(@NonNull LinearLayout linearLayout, @NonNull ImageButton imageButton, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatFillButton talabatFillButton, @NonNull TalabatTextView talabatTextView4, @NonNull TalabatTextView talabatTextView5, @NonNull Toolbar toolbar2) {
        this.rootView = linearLayout;
        this.back = imageButton;
        this.resultPaymentId = talabatTextView;
        this.resultReferenceId = talabatTextView2;
        this.resultStatus = talabatTextView3;
        this.talabatCreditHomeButton = talabatFillButton;
        this.talabatCreditMessage = talabatTextView4;
        this.title = talabatTextView5;
        this.toolbar = toolbar2;
    }

    @NonNull
    public static TalabatCreditThankyouBinding bind(@NonNull View view) {
        int i11 = R.id.back;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.back);
        if (imageButton != null) {
            i11 = R.id.result_payment_id;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.result_payment_id);
            if (talabatTextView != null) {
                i11 = R.id.result_reference_id;
                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.result_reference_id);
                if (talabatTextView2 != null) {
                    i11 = R.id.result_status;
                    TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.result_status);
                    if (talabatTextView3 != null) {
                        i11 = R.id.talabat_credit_home_button;
                        TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view, R.id.talabat_credit_home_button);
                        if (talabatFillButton != null) {
                            i11 = R.id.talabat_credit_message;
                            TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.talabat_credit_message);
                            if (talabatTextView4 != null) {
                                i11 = R.id.title;
                                TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.title);
                                if (talabatTextView5 != null) {
                                    i11 = R.id.toolbar;
                                    Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                    if (toolbar2 != null) {
                                        return new TalabatCreditThankyouBinding((LinearLayout) view, imageButton, talabatTextView, talabatTextView2, talabatTextView3, talabatFillButton, talabatTextView4, talabatTextView5, toolbar2);
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
    public static TalabatCreditThankyouBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static TalabatCreditThankyouBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.talabat_credit_thankyou, viewGroup, false);
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
