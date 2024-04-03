package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class WalletCreditTransactionLayoutBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView cashbackAmount;
    @NonNull
    public final View divider;
    @NonNull
    public final ImageView imageView;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TalabatTextView transactionAmount;
    @NonNull
    public final TalabatTextView transactionAmountWithoutCashback;
    @NonNull
    public final TalabatTextView transactionDate;
    @NonNull
    public final TalabatTextView vendorName;

    private WalletCreditTransactionLayoutBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TalabatTextView talabatTextView, @NonNull View view, @NonNull ImageView imageView2, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4, @NonNull TalabatTextView talabatTextView5) {
        this.rootView = constraintLayout;
        this.cashbackAmount = talabatTextView;
        this.divider = view;
        this.imageView = imageView2;
        this.transactionAmount = talabatTextView2;
        this.transactionAmountWithoutCashback = talabatTextView3;
        this.transactionDate = talabatTextView4;
        this.vendorName = talabatTextView5;
    }

    @NonNull
    public static WalletCreditTransactionLayoutBinding bind(@NonNull View view) {
        int i11 = R.id.cashback_amount;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.cashback_amount);
        if (talabatTextView != null) {
            i11 = R.id.divider;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.divider);
            if (findChildViewById != null) {
                i11 = R.id.imageView;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView);
                if (imageView2 != null) {
                    i11 = R.id.transaction_amount;
                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.transaction_amount);
                    if (talabatTextView2 != null) {
                        i11 = R.id.transaction_amount_without_cashback;
                        TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.transaction_amount_without_cashback);
                        if (talabatTextView3 != null) {
                            i11 = R.id.transaction_date;
                            TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.transaction_date);
                            if (talabatTextView4 != null) {
                                i11 = R.id.vendor_name;
                                TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.vendor_name);
                                if (talabatTextView5 != null) {
                                    return new WalletCreditTransactionLayoutBinding((ConstraintLayout) view, talabatTextView, findChildViewById, imageView2, talabatTextView2, talabatTextView3, talabatTextView4, talabatTextView5);
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
    public static WalletCreditTransactionLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static WalletCreditTransactionLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.wallet_credit_transaction_layout, viewGroup, false);
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
