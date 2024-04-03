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

public final class TransactionMonthHeaderBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView headerTitle;
    @NonNull
    private final ConstraintLayout rootView;

    private TransactionMonthHeaderBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TalabatTextView talabatTextView) {
        this.rootView = constraintLayout;
        this.headerTitle = talabatTextView;
    }

    @NonNull
    public static TransactionMonthHeaderBinding bind(@NonNull View view) {
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.header_title);
        if (talabatTextView != null) {
            return new TransactionMonthHeaderBinding((ConstraintLayout) view, talabatTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.header_title)));
    }

    @NonNull
    public static TransactionMonthHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static TransactionMonthHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.transaction_month_header, viewGroup, false);
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
