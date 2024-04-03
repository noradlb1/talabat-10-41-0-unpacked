package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.designsystem.ds_simple_card.DSSimpleCard;
import com.talabat.R;

public final class CheckoutPostDateDeliveryCardDsBinding implements ViewBinding {
    @NonNull
    public final DSSimpleCard postDateDelivery;
    @NonNull
    private final DSSimpleCard rootView;

    private CheckoutPostDateDeliveryCardDsBinding(@NonNull DSSimpleCard dSSimpleCard, @NonNull DSSimpleCard dSSimpleCard2) {
        this.rootView = dSSimpleCard;
        this.postDateDelivery = dSSimpleCard2;
    }

    @NonNull
    public static CheckoutPostDateDeliveryCardDsBinding bind(@NonNull View view) {
        if (view != null) {
            DSSimpleCard dSSimpleCard = (DSSimpleCard) view;
            return new CheckoutPostDateDeliveryCardDsBinding(dSSimpleCard, dSSimpleCard);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static CheckoutPostDateDeliveryCardDsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CheckoutPostDateDeliveryCardDsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.checkout_post_date_delivery_card_ds, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public DSSimpleCard getRoot() {
        return this.rootView;
    }
}
