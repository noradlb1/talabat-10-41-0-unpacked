package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;

public final class ViewWalletPaymentWidgetNoCardBinding implements ViewBinding {
    @NonNull
    public final ImageView creditCardIcon;
    @NonNull
    public final TextView noCardTextView;
    @NonNull
    private final ConstraintLayout rootView;

    private ViewWalletPaymentWidgetNoCardBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.rootView = constraintLayout;
        this.creditCardIcon = imageView;
        this.noCardTextView = textView;
    }

    @NonNull
    public static ViewWalletPaymentWidgetNoCardBinding bind(@NonNull View view) {
        int i11 = R.id.credit_card_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.no_card_text_view;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                return new ViewWalletPaymentWidgetNoCardBinding((ConstraintLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewWalletPaymentWidgetNoCardBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewWalletPaymentWidgetNoCardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_wallet_payment_widget_no_card, viewGroup, false);
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
