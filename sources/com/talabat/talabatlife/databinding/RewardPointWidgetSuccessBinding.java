package com.talabat.talabatlife.databinding;

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
import com.talabat.talabatlife.R;

public final class RewardPointWidgetSuccessBinding implements ViewBinding {
    @NonNull
    public final TextView message;
    @NonNull
    public final ImageView rewardIcon;
    @NonNull
    public final ConstraintLayout rewardPointWidgetView;
    @NonNull
    private final ConstraintLayout rootView;

    private RewardPointWidgetSuccessBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.message = textView;
        this.rewardIcon = imageView;
        this.rewardPointWidgetView = constraintLayout2;
    }

    @NonNull
    public static RewardPointWidgetSuccessBinding bind(@NonNull View view) {
        int i11 = R.id.message;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.reward_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                return new RewardPointWidgetSuccessBinding(constraintLayout, textView, imageView, constraintLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static RewardPointWidgetSuccessBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static RewardPointWidgetSuccessBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.reward_point_widget_success, viewGroup, false);
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
