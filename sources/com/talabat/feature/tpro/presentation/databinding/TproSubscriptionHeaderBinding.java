package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.tpro.presentation.R;

public final class TproSubscriptionHeaderBinding implements ViewBinding {
    @NonNull
    public final TextView dotTextView;
    @NonNull
    public final TextView freeDeliveryText;
    @NonNull
    public final ImageView headerProTag;
    @NonNull
    public final TextView rewardPointsText;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final Button subscribeButton;

    private TproSubscriptionHeaderBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull TextView textView3, @NonNull Button button) {
        this.rootView = constraintLayout;
        this.dotTextView = textView;
        this.freeDeliveryText = textView2;
        this.headerProTag = imageView;
        this.rewardPointsText = textView3;
        this.subscribeButton = button;
    }

    @NonNull
    public static TproSubscriptionHeaderBinding bind(@NonNull View view) {
        int i11 = R.id.dot_text_view;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.free_delivery_text;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView2 != null) {
                i11 = R.id.header_pro_tag;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                if (imageView != null) {
                    i11 = R.id.reward_points_text;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView3 != null) {
                        i11 = R.id.subscribe_button;
                        Button button = (Button) ViewBindings.findChildViewById(view, i11);
                        if (button != null) {
                            return new TproSubscriptionHeaderBinding((ConstraintLayout) view, textView, textView2, imageView, textView3, button);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static TproSubscriptionHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static TproSubscriptionHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.tpro_subscription_header, viewGroup, false);
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
