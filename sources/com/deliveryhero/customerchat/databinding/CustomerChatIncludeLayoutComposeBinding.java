package com.deliveryhero.customerchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.deliveryhero.chatui.view.chatroom.customview.AttachmentView;
import com.deliveryhero.customerchat.R;

public final class CustomerChatIncludeLayoutComposeBinding implements ViewBinding {
    @NonNull
    public final AttachmentView attachmentView;
    @NonNull
    public final AppCompatImageButton buttonComposeSend;
    @NonNull
    public final EditText editTextComposeMessage;
    @NonNull
    private final ConstraintLayout rootView;

    private CustomerChatIncludeLayoutComposeBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AttachmentView attachmentView2, @NonNull AppCompatImageButton appCompatImageButton, @NonNull EditText editText) {
        this.rootView = constraintLayout;
        this.attachmentView = attachmentView2;
        this.buttonComposeSend = appCompatImageButton;
        this.editTextComposeMessage = editText;
    }

    @NonNull
    public static CustomerChatIncludeLayoutComposeBinding bind(@NonNull View view) {
        int i11 = R.id.attachment_view;
        AttachmentView attachmentView2 = (AttachmentView) ViewBindings.findChildViewById(view, i11);
        if (attachmentView2 != null) {
            i11 = R.id.button_compose_send;
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i11);
            if (appCompatImageButton != null) {
                i11 = R.id.edit_text_compose_message;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, i11);
                if (editText != null) {
                    return new CustomerChatIncludeLayoutComposeBinding((ConstraintLayout) view, attachmentView2, appCompatImageButton, editText);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CustomerChatIncludeLayoutComposeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CustomerChatIncludeLayoutComposeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.customer_chat_include_layout_compose, viewGroup, false);
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
