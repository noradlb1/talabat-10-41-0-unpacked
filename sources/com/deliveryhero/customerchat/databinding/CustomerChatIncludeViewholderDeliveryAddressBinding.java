package com.deliveryhero.customerchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.deliveryhero.customerchat.R;

public final class CustomerChatIncludeViewholderDeliveryAddressBinding implements ViewBinding {
    @NonNull
    public final LinearLayout layoutDeliveryAddress;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final AppCompatTextView textViewAddress;

    private CustomerChatIncludeViewholderDeliveryAddressBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull AppCompatTextView appCompatTextView) {
        this.rootView = linearLayout;
        this.layoutDeliveryAddress = linearLayout2;
        this.textViewAddress = appCompatTextView;
    }

    @NonNull
    public static CustomerChatIncludeViewholderDeliveryAddressBinding bind(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i11 = R.id.text_view_address;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
        if (appCompatTextView != null) {
            return new CustomerChatIncludeViewholderDeliveryAddressBinding(linearLayout, linearLayout, appCompatTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CustomerChatIncludeViewholderDeliveryAddressBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CustomerChatIncludeViewholderDeliveryAddressBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.customer_chat_include_viewholder_delivery_address, viewGroup, false);
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
