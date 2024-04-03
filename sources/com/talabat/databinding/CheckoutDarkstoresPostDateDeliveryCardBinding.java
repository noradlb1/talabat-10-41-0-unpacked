package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.CheckoutOrderTimeSelectorView;
import com.talabat.R;

public final class CheckoutDarkstoresPostDateDeliveryCardBinding implements ViewBinding {
    @NonNull
    public final CheckoutOrderTimeSelectorView postDateDelivery;
    @NonNull
    private final CheckoutOrderTimeSelectorView rootView;

    private CheckoutDarkstoresPostDateDeliveryCardBinding(@NonNull CheckoutOrderTimeSelectorView checkoutOrderTimeSelectorView, @NonNull CheckoutOrderTimeSelectorView checkoutOrderTimeSelectorView2) {
        this.rootView = checkoutOrderTimeSelectorView;
        this.postDateDelivery = checkoutOrderTimeSelectorView2;
    }

    @NonNull
    public static CheckoutDarkstoresPostDateDeliveryCardBinding bind(@NonNull View view) {
        if (view != null) {
            CheckoutOrderTimeSelectorView checkoutOrderTimeSelectorView = (CheckoutOrderTimeSelectorView) view;
            return new CheckoutDarkstoresPostDateDeliveryCardBinding(checkoutOrderTimeSelectorView, checkoutOrderTimeSelectorView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static CheckoutDarkstoresPostDateDeliveryCardBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CheckoutDarkstoresPostDateDeliveryCardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.checkout_darkstores_post_date_delivery_card, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public CheckoutOrderTimeSelectorView getRoot() {
        return this.rootView;
    }
}
