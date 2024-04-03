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

public final class LabelExclusiveToProBinding implements ViewBinding {
    @NonNull
    public final ImageView ivExclusivePro;
    @NonNull
    private final CardView rootView;
    @NonNull
    public final TextView tvExclusiveTo;

    private LabelExclusiveToProBinding(@NonNull CardView cardView, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.rootView = cardView;
        this.ivExclusivePro = imageView;
        this.tvExclusiveTo = textView;
    }

    @NonNull
    public static LabelExclusiveToProBinding bind(@NonNull View view) {
        int i11 = R.id.iv_exclusive_pro;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.tv_exclusive_to;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                return new LabelExclusiveToProBinding((CardView) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LabelExclusiveToProBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LabelExclusiveToProBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.label_exclusive_to_pro, viewGroup, false);
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
