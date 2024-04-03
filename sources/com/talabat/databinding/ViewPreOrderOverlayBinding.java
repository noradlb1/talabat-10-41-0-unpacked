package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class ViewPreOrderOverlayBinding implements ViewBinding {
    @NonNull
    public final ImageView imageViewPreOrderIcon;
    @NonNull
    public final LinearLayout layoutPreOrder;
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final TextView textViewPreOrderLabel;

    private ViewPreOrderOverlayBinding(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull TextView textView) {
        this.rootView = frameLayout;
        this.imageViewPreOrderIcon = imageView;
        this.layoutPreOrder = linearLayout;
        this.textViewPreOrderLabel = textView;
    }

    @NonNull
    public static ViewPreOrderOverlayBinding bind(@NonNull View view) {
        int i11 = R.id.imageView_preOrderIcon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView_preOrderIcon);
        if (imageView != null) {
            i11 = R.id.layout_preOrder;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_preOrder);
            if (linearLayout != null) {
                i11 = R.id.textView_preOrderLabel;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.textView_preOrderLabel);
                if (textView != null) {
                    return new ViewPreOrderOverlayBinding((FrameLayout) view, imageView, linearLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewPreOrderOverlayBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewPreOrderOverlayBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_pre_order_overlay, viewGroup, false);
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
