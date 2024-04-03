package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.R;

public final class WalletErrorViewBinding implements ViewBinding {
    @NonNull
    private final ConstraintLayout rootView;

    private WalletErrorViewBinding(@NonNull ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    @NonNull
    public static WalletErrorViewBinding bind(@NonNull View view) {
        if (view != null) {
            return new WalletErrorViewBinding((ConstraintLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static WalletErrorViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static WalletErrorViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.wallet_error_view, viewGroup, false);
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
