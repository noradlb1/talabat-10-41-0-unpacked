package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.R;

public final class V2GemCheckoutFooterBinding implements ViewBinding {
    @NonNull
    private final View rootView;

    private V2GemCheckoutFooterBinding(@NonNull View view) {
        this.rootView = view;
    }

    @NonNull
    public static V2GemCheckoutFooterBinding bind(@NonNull View view) {
        if (view != null) {
            return new V2GemCheckoutFooterBinding(view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static V2GemCheckoutFooterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }

    @NonNull
    public static V2GemCheckoutFooterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.v2_gem_checkout_footer, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }
}
