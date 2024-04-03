package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.tpro.presentation.R;

public final class ItemLifetimeSavingsBinding implements ViewBinding {
    @NonNull
    public final ConstraintLayout headerContainer;
    @NonNull
    public final ImageView ivLifetimeSavings;
    @NonNull
    public final ConstraintLayout mainContainer;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final View separatorSubscriptionDetailsTop;
    @NonNull
    public final TextView tvLifetimeSavingsDescription;
    @NonNull
    public final TextView tvLifetimeSavingsTitle;

    private ItemLifetimeSavingsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout3, @NonNull View view, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.headerContainer = constraintLayout2;
        this.ivLifetimeSavings = imageView;
        this.mainContainer = constraintLayout3;
        this.separatorSubscriptionDetailsTop = view;
        this.tvLifetimeSavingsDescription = textView;
        this.tvLifetimeSavingsTitle = textView2;
    }

    @NonNull
    public static ItemLifetimeSavingsBinding bind(@NonNull View view) {
        int i11 = R.id.header_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i11);
        if (constraintLayout != null) {
            i11 = R.id.iv_lifetime_savings;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView != null) {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                i11 = R.id.separator_subscription_details_top;
                View findChildViewById = ViewBindings.findChildViewById(view, i11);
                if (findChildViewById != null) {
                    i11 = R.id.tv_lifetime_savings_description;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView != null) {
                        i11 = R.id.tv_lifetime_savings_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView2 != null) {
                            return new ItemLifetimeSavingsBinding(constraintLayout2, constraintLayout, imageView, constraintLayout2, findChildViewById, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemLifetimeSavingsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemLifetimeSavingsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_lifetime_savings, viewGroup, false);
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
