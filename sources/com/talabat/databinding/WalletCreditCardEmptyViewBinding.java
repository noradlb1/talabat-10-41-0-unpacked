package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.R;

public final class WalletCreditCardEmptyViewBinding implements ViewBinding {
    @NonNull
    public final ConstraintLayout emptyView;
    @NonNull
    private final ConstraintLayout rootView;

    private WalletCreditCardEmptyViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.emptyView = constraintLayout2;
    }

    @NonNull
    public static WalletCreditCardEmptyViewBinding bind(@NonNull View view) {
        if (view != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            return new WalletCreditCardEmptyViewBinding(constraintLayout, constraintLayout);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static WalletCreditCardEmptyViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static WalletCreditCardEmptyViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.wallet_credit_card_empty_view, viewGroup, false);
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
