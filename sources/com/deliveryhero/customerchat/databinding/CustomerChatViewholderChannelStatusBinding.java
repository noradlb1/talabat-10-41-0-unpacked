package com.deliveryhero.customerchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.deliveryhero.customerchat.R;

public final class CustomerChatViewholderChannelStatusBinding implements ViewBinding {
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final TextView tvChatEndedBubble;

    private CustomerChatViewholderChannelStatusBinding(@NonNull FrameLayout frameLayout, @NonNull TextView textView) {
        this.rootView = frameLayout;
        this.tvChatEndedBubble = textView;
    }

    @NonNull
    public static CustomerChatViewholderChannelStatusBinding bind(@NonNull View view) {
        int i11 = R.id.tv_chat_ended_bubble;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            return new CustomerChatViewholderChannelStatusBinding((FrameLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CustomerChatViewholderChannelStatusBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CustomerChatViewholderChannelStatusBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.customer_chat_viewholder_channel_status, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
