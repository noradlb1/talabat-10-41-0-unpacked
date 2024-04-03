package com.deliveryhero.customerchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.deliveryhero.customerchat.R;
import com.google.android.material.imageview.ShapeableImageView;

public final class CustomerChatLayoutImageConfirmationBinding implements ViewBinding {
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final TextView confirmText;
    @NonNull
    public final TextView dialogTitle;
    @NonNull
    public final ImageView infoIcon;
    @NonNull
    public final LinearLayout instructionView;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final ShapeableImageView selectedImage;
    @NonNull
    public final Button sendButton;

    private CustomerChatLayoutImageConfirmationBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Button button, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull ShapeableImageView shapeableImageView, @NonNull Button button2) {
        this.rootView = constraintLayout;
        this.cancelButton = button;
        this.confirmText = textView;
        this.dialogTitle = textView2;
        this.infoIcon = imageView;
        this.instructionView = linearLayout;
        this.selectedImage = shapeableImageView;
        this.sendButton = button2;
    }

    @NonNull
    public static CustomerChatLayoutImageConfirmationBinding bind(@NonNull View view) {
        int i11 = R.id.cancel_button;
        Button button = (Button) ViewBindings.findChildViewById(view, i11);
        if (button != null) {
            i11 = R.id.confirm_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.dialog_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    i11 = R.id.info_icon;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                    if (imageView != null) {
                        i11 = R.id.instruction_view;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                        if (linearLayout != null) {
                            i11 = R.id.selected_image;
                            ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(view, i11);
                            if (shapeableImageView != null) {
                                i11 = R.id.send_button;
                                Button button2 = (Button) ViewBindings.findChildViewById(view, i11);
                                if (button2 != null) {
                                    return new CustomerChatLayoutImageConfirmationBinding((ConstraintLayout) view, button, textView, textView2, imageView, linearLayout, shapeableImageView, button2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CustomerChatLayoutImageConfirmationBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CustomerChatLayoutImageConfirmationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.customer_chat_layout_image_confirmation, viewGroup, false);
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
