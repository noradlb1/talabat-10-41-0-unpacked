package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.tpro.presentation.R;

public final class ItemCapsuleViewBinding implements ViewBinding {
    @NonNull
    public final ConstraintLayout clView;
    @NonNull
    public final CardView cvParentView;
    @NonNull
    public final ImageView ivCapsule;
    @NonNull
    private final CardView rootView;
    @NonNull
    public final TextView tvTitle;

    private ItemCapsuleViewBinding(@NonNull CardView cardView, @NonNull ConstraintLayout constraintLayout, @NonNull CardView cardView2, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.rootView = cardView;
        this.clView = constraintLayout;
        this.cvParentView = cardView2;
        this.ivCapsule = imageView;
        this.tvTitle = textView;
    }

    @NonNull
    public static ItemCapsuleViewBinding bind(@NonNull View view) {
        int i11 = R.id.cl_view;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i11);
        if (constraintLayout != null) {
            CardView cardView = (CardView) view;
            i11 = R.id.iv_capsule;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView != null) {
                i11 = R.id.tv_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView != null) {
                    return new ItemCapsuleViewBinding(cardView, constraintLayout, cardView, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemCapsuleViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemCapsuleViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_capsule_view, viewGroup, false);
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
