package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.designsystem.ds_alert.DSAlert;
import com.talabat.R;

public final class CheckoutLocationFarMessageDsBinding implements ViewBinding {
    @NonNull
    private final DSAlert rootView;

    private CheckoutLocationFarMessageDsBinding(@NonNull DSAlert dSAlert) {
        this.rootView = dSAlert;
    }

    @NonNull
    public static CheckoutLocationFarMessageDsBinding bind(@NonNull View view) {
        if (view != null) {
            return new CheckoutLocationFarMessageDsBinding((DSAlert) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static CheckoutLocationFarMessageDsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CheckoutLocationFarMessageDsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.checkout_location_far_message_ds, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public DSAlert getRoot() {
        return this.rootView;
    }
}
