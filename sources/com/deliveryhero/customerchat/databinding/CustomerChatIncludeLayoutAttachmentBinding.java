package com.deliveryhero.customerchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.deliveryhero.customerchat.R;

public final class CustomerChatIncludeLayoutAttachmentBinding implements ViewBinding {
    @NonNull
    public final AppCompatImageButton buttonAddAttachment;
    @NonNull
    public final AppCompatImageButton buttonComposeCamera;
    @NonNull
    public final AppCompatImageButton buttonComposeGallery;
    @NonNull
    public final AppCompatImageButton buttonShareLocation;
    @NonNull
    private final LinearLayout rootView;

    private CustomerChatIncludeLayoutAttachmentBinding(@NonNull LinearLayout linearLayout, @NonNull AppCompatImageButton appCompatImageButton, @NonNull AppCompatImageButton appCompatImageButton2, @NonNull AppCompatImageButton appCompatImageButton3, @NonNull AppCompatImageButton appCompatImageButton4) {
        this.rootView = linearLayout;
        this.buttonAddAttachment = appCompatImageButton;
        this.buttonComposeCamera = appCompatImageButton2;
        this.buttonComposeGallery = appCompatImageButton3;
        this.buttonShareLocation = appCompatImageButton4;
    }

    @NonNull
    public static CustomerChatIncludeLayoutAttachmentBinding bind(@NonNull View view) {
        int i11 = R.id.button_add_attachment;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i11);
        if (appCompatImageButton != null) {
            i11 = R.id.button_compose_camera;
            AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) ViewBindings.findChildViewById(view, i11);
            if (appCompatImageButton2 != null) {
                i11 = R.id.button_compose_gallery;
                AppCompatImageButton appCompatImageButton3 = (AppCompatImageButton) ViewBindings.findChildViewById(view, i11);
                if (appCompatImageButton3 != null) {
                    i11 = R.id.button_share_location;
                    AppCompatImageButton appCompatImageButton4 = (AppCompatImageButton) ViewBindings.findChildViewById(view, i11);
                    if (appCompatImageButton4 != null) {
                        return new CustomerChatIncludeLayoutAttachmentBinding((LinearLayout) view, appCompatImageButton, appCompatImageButton2, appCompatImageButton3, appCompatImageButton4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CustomerChatIncludeLayoutAttachmentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CustomerChatIncludeLayoutAttachmentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.customer_chat_include_layout_attachment, viewGroup, false);
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
