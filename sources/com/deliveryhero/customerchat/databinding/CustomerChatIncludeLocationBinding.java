package com.deliveryhero.customerchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.deliveryhero.customerchat.R;
import com.google.android.material.imageview.ShapeableImageView;

public final class CustomerChatIncludeLocationBinding implements ViewBinding {
    @NonNull
    public final ShapeableImageView locationMessageBody;
    @NonNull
    public final TextView locationMessageHelper;
    @NonNull
    private final ConstraintLayout rootView;

    private CustomerChatIncludeLocationBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ShapeableImageView shapeableImageView, @NonNull TextView textView) {
        this.rootView = constraintLayout;
        this.locationMessageBody = shapeableImageView;
        this.locationMessageHelper = textView;
    }

    @NonNull
    public static CustomerChatIncludeLocationBinding bind(@NonNull View view) {
        int i11 = R.id.location_message_body;
        ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(view, i11);
        if (shapeableImageView != null) {
            i11 = R.id.location_message_helper;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                return new CustomerChatIncludeLocationBinding((ConstraintLayout) view, shapeableImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CustomerChatIncludeLocationBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CustomerChatIncludeLocationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.customer_chat_include_location, viewGroup, false);
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
