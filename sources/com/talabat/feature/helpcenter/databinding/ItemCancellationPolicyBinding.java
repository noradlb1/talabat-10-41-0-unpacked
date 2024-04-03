package com.talabat.feature.helpcenter.databinding;

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
import com.talabat.feature.helpcenter.R;

public final class ItemCancellationPolicyBinding implements ViewBinding {
    @NonNull
    public final ImageView ivCancellationPolicyIcon;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView tvItemCancellationPolicy;
    @NonNull
    public final TextView tvItemCancellationPolicyDesc;

    private ItemCancellationPolicyBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = linearLayout;
        this.ivCancellationPolicyIcon = imageView;
        this.tvItemCancellationPolicy = textView;
        this.tvItemCancellationPolicyDesc = textView2;
    }

    @NonNull
    public static ItemCancellationPolicyBinding bind(@NonNull View view) {
        int i11 = R.id.ivCancellationPolicyIcon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.tvItemCancellationPolicy;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.tvItemCancellationPolicyDesc;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    return new ItemCancellationPolicyBinding((LinearLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemCancellationPolicyBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemCancellationPolicyBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_cancellation_policy, viewGroup, false);
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
