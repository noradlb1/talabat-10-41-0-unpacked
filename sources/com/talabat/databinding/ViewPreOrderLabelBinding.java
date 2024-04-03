package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class ViewPreOrderLabelBinding implements ViewBinding {
    @NonNull
    public final ImageView imageViewPreOrderIcon;
    @NonNull
    public final LinearLayout layoutPreOrder;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView textViewPreOrderLabel;

    private ViewPreOrderLabelBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView) {
        this.rootView = linearLayout;
        this.imageViewPreOrderIcon = imageView;
        this.layoutPreOrder = linearLayout2;
        this.textViewPreOrderLabel = textView;
    }

    @NonNull
    public static ViewPreOrderLabelBinding bind(@NonNull View view) {
        int i11 = R.id.imageView_preOrderIcon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView_preOrderIcon);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.textView_preOrderLabel);
            if (textView != null) {
                return new ViewPreOrderLabelBinding(linearLayout, imageView, linearLayout, textView);
            }
            i11 = R.id.textView_preOrderLabel;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewPreOrderLabelBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewPreOrderLabelBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_pre_order_label, viewGroup, false);
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
