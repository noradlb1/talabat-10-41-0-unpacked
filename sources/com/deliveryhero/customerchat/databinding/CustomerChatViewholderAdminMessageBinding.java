package com.deliveryhero.customerchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.deliveryhero.customerchat.R;

public final class CustomerChatViewholderAdminMessageBinding implements ViewBinding {
    @NonNull
    private final TextView rootView;
    @NonNull
    public final TextView textMessageBody;

    private CustomerChatViewholderAdminMessageBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = textView;
        this.textMessageBody = textView2;
    }

    @NonNull
    public static CustomerChatViewholderAdminMessageBinding bind(@NonNull View view) {
        if (view != null) {
            TextView textView = (TextView) view;
            return new CustomerChatViewholderAdminMessageBinding(textView, textView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static CustomerChatViewholderAdminMessageBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CustomerChatViewholderAdminMessageBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.customer_chat_viewholder_admin_message, viewGroup, false);
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
