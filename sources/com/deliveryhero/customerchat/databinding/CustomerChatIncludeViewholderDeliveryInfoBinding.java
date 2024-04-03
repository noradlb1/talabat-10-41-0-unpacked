package com.deliveryhero.customerchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.deliveryhero.customerchat.R;

public final class CustomerChatIncludeViewholderDeliveryInfoBinding implements ViewBinding {
    @NonNull
    public final AppCompatImageView imageViewDelivery;
    @NonNull
    public final ConstraintLayout layoutDeliveryInfos;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final AppCompatTextView textViewDelivery;
    @NonNull
    public final AppCompatTextView textViewDeliveryAmount;

    private CustomerChatIncludeViewholderDeliveryInfoBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull ConstraintLayout constraintLayout2, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2) {
        this.rootView = constraintLayout;
        this.imageViewDelivery = appCompatImageView;
        this.layoutDeliveryInfos = constraintLayout2;
        this.textViewDelivery = appCompatTextView;
        this.textViewDeliveryAmount = appCompatTextView2;
    }

    @NonNull
    public static CustomerChatIncludeViewholderDeliveryInfoBinding bind(@NonNull View view) {
        int i11 = R.id.image_view_delivery;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
        if (appCompatImageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i11 = R.id.text_view_delivery;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
            if (appCompatTextView != null) {
                i11 = R.id.text_view_delivery_amount;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
                if (appCompatTextView2 != null) {
                    return new CustomerChatIncludeViewholderDeliveryInfoBinding(constraintLayout, appCompatImageView, constraintLayout, appCompatTextView, appCompatTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CustomerChatIncludeViewholderDeliveryInfoBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CustomerChatIncludeViewholderDeliveryInfoBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.customer_chat_include_viewholder_delivery_info, viewGroup, false);
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
