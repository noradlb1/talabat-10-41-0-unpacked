package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class WalletCreditAddCardLayoutBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView label;
    @NonNull
    private final LinearLayout rootView;

    private WalletCreditAddCardLayoutBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView) {
        this.rootView = linearLayout;
        this.label = talabatTextView;
    }

    @NonNull
    public static WalletCreditAddCardLayoutBinding bind(@NonNull View view) {
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.label);
        if (talabatTextView != null) {
            return new WalletCreditAddCardLayoutBinding((LinearLayout) view, talabatTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.label)));
    }

    @NonNull
    public static WalletCreditAddCardLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static WalletCreditAddCardLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.wallet_credit_add_card_layout, viewGroup, false);
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
