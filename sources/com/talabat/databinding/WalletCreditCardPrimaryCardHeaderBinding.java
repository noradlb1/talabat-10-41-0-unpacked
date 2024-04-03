package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class WalletCreditCardPrimaryCardHeaderBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView cardHeaderTitle;
    @NonNull
    private final ConstraintLayout rootView;

    private WalletCreditCardPrimaryCardHeaderBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TalabatTextView talabatTextView) {
        this.rootView = constraintLayout;
        this.cardHeaderTitle = talabatTextView;
    }

    @NonNull
    public static WalletCreditCardPrimaryCardHeaderBinding bind(@NonNull View view) {
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.card_header_title);
        if (talabatTextView != null) {
            return new WalletCreditCardPrimaryCardHeaderBinding((ConstraintLayout) view, talabatTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.card_header_title)));
    }

    @NonNull
    public static WalletCreditCardPrimaryCardHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static WalletCreditCardPrimaryCardHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.wallet_credit_card_primary_card_header, viewGroup, false);
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
