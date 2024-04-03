package com.talabat.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.growth.R;

public final class LabelVoucherTypeBinding implements ViewBinding {
    @NonNull
    public final ImageView ivTag;
    @NonNull
    private final CardView rootView;
    @NonNull
    public final TextView tvTag;

    private LabelVoucherTypeBinding(@NonNull CardView cardView, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.rootView = cardView;
        this.ivTag = imageView;
        this.tvTag = textView;
    }

    @NonNull
    public static LabelVoucherTypeBinding bind(@NonNull View view) {
        int i11 = R.id.iv_tag;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.tv_tag;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                return new LabelVoucherTypeBinding((CardView) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LabelVoucherTypeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LabelVoucherTypeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.label_voucher_type, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public CardView getRoot() {
        return this.rootView;
    }
}
