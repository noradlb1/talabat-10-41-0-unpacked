package com.deliveryhero.customerchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.deliveryhero.customerchat.R;

public final class CustomerChatIncludeViewholderDeliveryCommentsBinding implements ViewBinding {
    @NonNull
    public final AppCompatImageView imageViewComments;
    @NonNull
    public final LinearLayout layoutDeliveryComments;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final AppCompatTextView textViewComments;

    private CustomerChatIncludeViewholderDeliveryCommentsBinding(@NonNull LinearLayout linearLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull LinearLayout linearLayout2, @NonNull AppCompatTextView appCompatTextView) {
        this.rootView = linearLayout;
        this.imageViewComments = appCompatImageView;
        this.layoutDeliveryComments = linearLayout2;
        this.textViewComments = appCompatTextView;
    }

    @NonNull
    public static CustomerChatIncludeViewholderDeliveryCommentsBinding bind(@NonNull View view) {
        int i11 = R.id.image_view_comments;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
        if (appCompatImageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            int i12 = R.id.text_view_comments;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i12);
            if (appCompatTextView != null) {
                return new CustomerChatIncludeViewholderDeliveryCommentsBinding(linearLayout, appCompatImageView, linearLayout, appCompatTextView);
            }
            i11 = i12;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CustomerChatIncludeViewholderDeliveryCommentsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CustomerChatIncludeViewholderDeliveryCommentsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.customer_chat_include_viewholder_delivery_comments, viewGroup, false);
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
