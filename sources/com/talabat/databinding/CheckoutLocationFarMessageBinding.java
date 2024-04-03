package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class CheckoutLocationFarMessageBinding implements ViewBinding {
    @NonNull
    private final TalabatTextView rootView;

    private CheckoutLocationFarMessageBinding(@NonNull TalabatTextView talabatTextView) {
        this.rootView = talabatTextView;
    }

    @NonNull
    public static CheckoutLocationFarMessageBinding bind(@NonNull View view) {
        if (view != null) {
            return new CheckoutLocationFarMessageBinding((TalabatTextView) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static CheckoutLocationFarMessageBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CheckoutLocationFarMessageBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.checkout_location_far_message, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public TalabatTextView getRoot() {
        return this.rootView;
    }
}
