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

public final class CustomerChatReceivedMessageBubbleBinding implements ViewBinding {
    @NonNull
    public final View line;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView textMessageBody;
    @NonNull
    public final TextView textMessageFaded;

    private CustomerChatReceivedMessageBubbleBinding(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.line = view;
        this.textMessageBody = textView;
        this.textMessageFaded = textView2;
    }

    @NonNull
    public static CustomerChatReceivedMessageBubbleBinding bind(@NonNull View view) {
        int i11 = R.id.line;
        View findChildViewById = ViewBindings.findChildViewById(view, i11);
        if (findChildViewById != null) {
            i11 = R.id.text_message_body;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.text_message_faded;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    return new CustomerChatReceivedMessageBubbleBinding((ConstraintLayout) view, findChildViewById, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CustomerChatReceivedMessageBubbleBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CustomerChatReceivedMessageBubbleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.customer_chat_received_message_bubble, viewGroup, false);
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
