package com.deliveryhero.customerchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.deliveryhero.customerchat.R;

public final class CustomerChatViewholderAttachmentViewBinding implements ViewBinding {
    @NonNull
    public final ImageView ivAttachmentIcon;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView tvAttachmentTitle;

    private CustomerChatViewholderAttachmentViewBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.rootView = linearLayout;
        this.ivAttachmentIcon = imageView;
        this.tvAttachmentTitle = textView;
    }

    @NonNull
    public static CustomerChatViewholderAttachmentViewBinding bind(@NonNull View view) {
        int i11 = R.id.iv_attachment_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.tv_attachment_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                return new CustomerChatViewholderAttachmentViewBinding((LinearLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CustomerChatViewholderAttachmentViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CustomerChatViewholderAttachmentViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.customer_chat_viewholder_attachment_view, viewGroup, false);
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
