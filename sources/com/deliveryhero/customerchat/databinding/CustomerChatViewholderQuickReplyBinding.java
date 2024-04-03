package com.deliveryhero.customerchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.deliveryhero.customerchat.R;

public final class CustomerChatViewholderQuickReplyBinding implements ViewBinding {
    @NonNull
    private final TextView rootView;
    @NonNull
    public final TextView textQuickReply;

    private CustomerChatViewholderQuickReplyBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = textView;
        this.textQuickReply = textView2;
    }

    @NonNull
    public static CustomerChatViewholderQuickReplyBinding bind(@NonNull View view) {
        if (view != null) {
            TextView textView = (TextView) view;
            return new CustomerChatViewholderQuickReplyBinding(textView, textView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static CustomerChatViewholderQuickReplyBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CustomerChatViewholderQuickReplyBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.customer_chat_viewholder_quick_reply, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public TextView getRoot() {
        return this.rootView;
    }
}
