package com.talabat.databinding;

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
import com.talabat.R;

public final class ViewExpiringCardBinding implements ViewBinding {
    @NonNull
    public final ConstraintLayout container;
    @NonNull
    public final TextView expiringAmount;
    @NonNull
    public final ImageView expiringCardInfoIcon;
    @NonNull
    public final TextView expiryDate;
    @NonNull
    private final ConstraintLayout rootView;

    private ViewExpiringCardBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.container = constraintLayout2;
        this.expiringAmount = textView;
        this.expiringCardInfoIcon = imageView;
        this.expiryDate = textView2;
    }

    @NonNull
    public static ViewExpiringCardBinding bind(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i11 = R.id.expiring_amount;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.expiring_amount);
        if (textView != null) {
            i11 = R.id.expiring_card_info_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.expiring_card_info_icon);
            if (imageView != null) {
                i11 = R.id.expiry_date;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.expiry_date);
                if (textView2 != null) {
                    return new ViewExpiringCardBinding(constraintLayout, constraintLayout, textView, imageView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewExpiringCardBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewExpiringCardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_expiring_card, viewGroup, false);
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
