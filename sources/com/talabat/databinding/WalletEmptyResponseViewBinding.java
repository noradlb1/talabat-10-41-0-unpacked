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

public final class WalletEmptyResponseViewBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView addCardTextview;
    @NonNull
    public final TalabatTextView addNewCardButton;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final ConstraintLayout walletEmptyView;

    private WalletEmptyResponseViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.addCardTextview = talabatTextView;
        this.addNewCardButton = talabatTextView2;
        this.walletEmptyView = constraintLayout2;
    }

    @NonNull
    public static WalletEmptyResponseViewBinding bind(@NonNull View view) {
        int i11 = R.id.add_card_textview;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.add_card_textview);
        if (talabatTextView != null) {
            i11 = R.id.add_new_card_button;
            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.add_new_card_button);
            if (talabatTextView2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                return new WalletEmptyResponseViewBinding(constraintLayout, talabatTextView, talabatTextView2, constraintLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static WalletEmptyResponseViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static WalletEmptyResponseViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.wallet_empty_response_view, viewGroup, false);
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
