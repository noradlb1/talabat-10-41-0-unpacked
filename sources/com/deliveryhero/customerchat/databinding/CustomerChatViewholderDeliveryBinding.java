package com.deliveryhero.customerchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.deliveryhero.customerchat.R;

public final class CustomerChatViewholderDeliveryBinding implements ViewBinding {
    @NonNull
    private final CardView rootView;

    private CustomerChatViewholderDeliveryBinding(@NonNull CardView cardView) {
        this.rootView = cardView;
    }

    @NonNull
    public static CustomerChatViewholderDeliveryBinding bind(@NonNull View view) {
        if (view != null) {
            return new CustomerChatViewholderDeliveryBinding((CardView) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static CustomerChatViewholderDeliveryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CustomerChatViewholderDeliveryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.customer_chat_viewholder_delivery, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public CardView getRoot() {
        return this.rootView;
    }
}
