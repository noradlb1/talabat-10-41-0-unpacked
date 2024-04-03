package com.deliveryhero.customerchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.deliveryhero.customerchat.R;

public final class CustomerChatViewholderMessageSentBinding implements ViewBinding {
    @NonNull
    public final AppCompatImageView iconMessageReceivedIndicator;
    @NonNull
    public final ImageView imageMessageBody;
    @NonNull
    public final CustomerChatIncludeLocationBinding locationMessageContent;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView textMessageBody;
    @NonNull
    public final TextView textMessageDateTime;

    private CustomerChatViewholderMessageSentBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull ImageView imageView, @NonNull CustomerChatIncludeLocationBinding customerChatIncludeLocationBinding, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.iconMessageReceivedIndicator = appCompatImageView;
        this.imageMessageBody = imageView;
        this.locationMessageContent = customerChatIncludeLocationBinding;
        this.textMessageBody = textView;
        this.textMessageDateTime = textView2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.deliveryhero.customerchat.R.id.location_message_content;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.deliveryhero.customerchat.databinding.CustomerChatViewholderMessageSentBinding bind(@androidx.annotation.NonNull android.view.View r9) {
        /*
            int r0 = com.deliveryhero.customerchat.R.id.icon_message_received_indicator
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            androidx.appcompat.widget.AppCompatImageView r4 = (androidx.appcompat.widget.AppCompatImageView) r4
            if (r4 == 0) goto L_0x0042
            int r0 = com.deliveryhero.customerchat.R.id.image_message_body
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0042
            int r0 = com.deliveryhero.customerchat.R.id.location_message_content
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r1 == 0) goto L_0x0042
            com.deliveryhero.customerchat.databinding.CustomerChatIncludeLocationBinding r6 = com.deliveryhero.customerchat.databinding.CustomerChatIncludeLocationBinding.bind(r1)
            int r0 = com.deliveryhero.customerchat.R.id.text_message_body
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0042
            int r0 = com.deliveryhero.customerchat.R.id.text_message_date_time
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0042
            com.deliveryhero.customerchat.databinding.CustomerChatViewholderMessageSentBinding r0 = new com.deliveryhero.customerchat.databinding.CustomerChatViewholderMessageSentBinding
            r3 = r9
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L_0x0042:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.databinding.CustomerChatViewholderMessageSentBinding.bind(android.view.View):com.deliveryhero.customerchat.databinding.CustomerChatViewholderMessageSentBinding");
    }

    @NonNull
    public static CustomerChatViewholderMessageSentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CustomerChatViewholderMessageSentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.customer_chat_viewholder_message_sent, viewGroup, false);
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
