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

public final class CreditListItemBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView creditAmount;
    @NonNull
    public final TalabatTextView creditTime;
    @NonNull
    public final TalabatTextView creditTransaction;
    @NonNull
    public final TalabatTextView creditUsedAt;
    @NonNull
    private final LinearLayout rootView;

    private CreditListItemBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4) {
        this.rootView = linearLayout;
        this.creditAmount = talabatTextView;
        this.creditTime = talabatTextView2;
        this.creditTransaction = talabatTextView3;
        this.creditUsedAt = talabatTextView4;
    }

    @NonNull
    public static CreditListItemBinding bind(@NonNull View view) {
        int i11 = R.id.credit_amount;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.credit_amount);
        if (talabatTextView != null) {
            i11 = R.id.credit_time;
            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.credit_time);
            if (talabatTextView2 != null) {
                i11 = R.id.credit_transaction;
                TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.credit_transaction);
                if (talabatTextView3 != null) {
                    i11 = R.id.credit_used_at;
                    TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.credit_used_at);
                    if (talabatTextView4 != null) {
                        return new CreditListItemBinding((LinearLayout) view, talabatTextView, talabatTextView2, talabatTextView3, talabatTextView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CreditListItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CreditListItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.credit_list_item, viewGroup, false);
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
