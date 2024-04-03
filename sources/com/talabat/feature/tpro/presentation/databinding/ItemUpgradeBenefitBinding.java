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

public final class ItemUpgradeBenefitBinding implements ViewBinding {
    @NonNull
    public final ImageView ivUpgradeIcon;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView tvUpgradeContent;
    @NonNull
    public final TextView tvUpgradeHeader;

    private ItemUpgradeBenefitBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.ivUpgradeIcon = imageView;
        this.tvUpgradeContent = textView;
        this.tvUpgradeHeader = textView2;
    }

    @NonNull
    public static ItemUpgradeBenefitBinding bind(@NonNull View view) {
        int i11 = R.id.iv_upgrade_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.tv_upgrade_content;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.tv_upgrade_header;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    return new ItemUpgradeBenefitBinding((ConstraintLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemUpgradeBenefitBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemUpgradeBenefitBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_upgrade_benefit, viewGroup, false);
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
