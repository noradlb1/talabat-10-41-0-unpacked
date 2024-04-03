package com.deliveryhero.customerchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.deliveryhero.customerchat.R;

public final class CustomerChatViewholderMessageReceivedBinding implements ViewBinding {
    @NonNull
    public final ImageView imageMessageBody;
    @NonNull
    public final CustomerChatIncludeLocationBinding locationMessageContent;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final CustomerChatReceivedMessageBubbleBinding textMessageContent;
    @NonNull
    public final TextView textMessageDateTime;
    @NonNull
    public final TextView textMessageSender;

    private CustomerChatViewholderMessageReceivedBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull CustomerChatIncludeLocationBinding customerChatIncludeLocationBinding, @NonNull CustomerChatReceivedMessageBubbleBinding customerChatReceivedMessageBubbleBinding, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.imageMessageBody = imageView;
        this.locationMessageContent = customerChatIncludeLocationBinding;
        this.textMessageContent = customerChatReceivedMessageBubbleBinding;
        this.textMessageDateTime = textView;
        this.textMessageSender = textView2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.deliveryhero.customerchat.R.id.location_message_content;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.deliveryhero.customerchat.databinding.CustomerChatViewholderMessageReceivedBinding bind(@androidx.annotation.NonNull android.view.View r9) {
        /*
            int r0 = com.deliveryhero.customerchat.R.id.image_message_body
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0043
            int r0 = com.deliveryhero.customerchat.R.id.location_message_content
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r1 == 0) goto L_0x0043
            com.deliveryhero.customerchat.databinding.CustomerChatIncludeLocationBinding r5 = com.deliveryhero.customerchat.databinding.CustomerChatIncludeLocationBinding.bind(r1)
            int r0 = com.deliveryhero.customerchat.R.id.text_message_content
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r1 == 0) goto L_0x0043
            com.deliveryhero.customerchat.databinding.CustomerChatReceivedMessageBubbleBinding r6 = com.deliveryhero.customerchat.databinding.CustomerChatReceivedMessageBubbleBinding.bind(r1)
            int r0 = com.deliveryhero.customerchat.R.id.text_message_date_time
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0043
            int r0 = com.deliveryhero.customerchat.R.id.text_message_sender
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0043
            com.deliveryhero.customerchat.databinding.CustomerChatViewholderMessageReceivedBinding r0 = new com.deliveryhero.customerchat.databinding.CustomerChatViewholderMessageReceivedBinding
            r3 = r9
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L_0x0043:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.databinding.CustomerChatViewholderMessageReceivedBinding.bind(android.view.View):com.deliveryhero.customerchat.databinding.CustomerChatViewholderMessageReceivedBinding");
    }

    @NonNull
    public static CustomerChatViewholderMessageReceivedBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CustomerChatViewholderMessageReceivedBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.customer_chat_viewholder_message_received, viewGroup, false);
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
