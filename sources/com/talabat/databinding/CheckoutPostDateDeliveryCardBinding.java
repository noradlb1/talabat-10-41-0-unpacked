package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class CheckoutPostDateDeliveryCardBinding implements ViewBinding {
    @NonNull
    public final ImageView deliveryIcon;
    @NonNull
    public final CardView postDateDelivery;
    @NonNull
    public final TextView preorderTitle;
    @NonNull
    private final CardView rootView;
    @NonNull
    public final TalabatTextView scheduleOrder;

    private CheckoutPostDateDeliveryCardBinding(@NonNull CardView cardView, @NonNull ImageView imageView, @NonNull CardView cardView2, @NonNull TextView textView, @NonNull TalabatTextView talabatTextView) {
        this.rootView = cardView;
        this.deliveryIcon = imageView;
        this.postDateDelivery = cardView2;
        this.preorderTitle = textView;
        this.scheduleOrder = talabatTextView;
    }

    @NonNull
    public static CheckoutPostDateDeliveryCardBinding bind(@NonNull View view) {
        int i11 = R.id.delivery_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.delivery_icon);
        if (imageView != null) {
            CardView cardView = (CardView) view;
            i11 = R.id.preorder_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.preorder_title);
            if (textView != null) {
                i11 = R.id.schedule_order;
                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.schedule_order);
                if (talabatTextView != null) {
                    return new CheckoutPostDateDeliveryCardBinding(cardView, imageView, cardView, textView, talabatTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CheckoutPostDateDeliveryCardBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CheckoutPostDateDeliveryCardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.checkout_post_date_delivery_card, viewGroup, false);
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
