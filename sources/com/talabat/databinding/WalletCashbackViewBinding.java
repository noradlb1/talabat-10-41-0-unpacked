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

public final class WalletCashbackViewBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView cashbackAmount;
    @NonNull
    public final TalabatTextView cashbackStringPlaceholder;
    @NonNull
    public final View dividerView;
    @NonNull
    private final ConstraintLayout rootView;

    private WalletCashbackViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull View view) {
        this.rootView = constraintLayout;
        this.cashbackAmount = talabatTextView;
        this.cashbackStringPlaceholder = talabatTextView2;
        this.dividerView = view;
    }

    @NonNull
    public static WalletCashbackViewBinding bind(@NonNull View view) {
        int i11 = R.id.cashback_amount;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.cashback_amount);
        if (talabatTextView != null) {
            i11 = R.id.cashback_string_placeholder;
            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.cashback_string_placeholder);
            if (talabatTextView2 != null) {
                i11 = R.id.divider_view;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.divider_view);
                if (findChildViewById != null) {
                    return new WalletCashbackViewBinding((ConstraintLayout) view, talabatTextView, talabatTextView2, findChildViewById);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static WalletCashbackViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static WalletCashbackViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.wallet_cashback_view, viewGroup, false);
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
