package com.talabat.talabatlife.databinding;

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
import com.talabat.talabatlife.R;

public final class RewardPointWidgetBinding implements ViewBinding {
    @NonNull
    public final ImageView imageView;
    @NonNull
    public final CardView loyaltyBurnOptionImageRelativeLayout;
    @NonNull
    public final ImageView parallaxImageView;
    @NonNull
    public final ConstraintLayout rewardPointWidgetView;
    @NonNull
    private final CardView rootView;
    @NonNull
    public final TextView textView;
    @NonNull
    public final TextView textView2;

    private RewardPointWidgetBinding(@NonNull CardView cardView, @NonNull ImageView imageView2, @NonNull CardView cardView2, @NonNull ImageView imageView3, @NonNull ConstraintLayout constraintLayout, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.rootView = cardView;
        this.imageView = imageView2;
        this.loyaltyBurnOptionImageRelativeLayout = cardView2;
        this.parallaxImageView = imageView3;
        this.rewardPointWidgetView = constraintLayout;
        this.textView = textView3;
        this.textView2 = textView4;
    }

    @NonNull
    public static RewardPointWidgetBinding bind(@NonNull View view) {
        int i11 = R.id.imageView;
        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView2 != null) {
            CardView cardView = (CardView) view;
            i11 = R.id.parallaxImageView;
            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView3 != null) {
                i11 = R.id.reward_point_widget_view;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i11);
                if (constraintLayout != null) {
                    i11 = R.id.textView;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView3 != null) {
                        i11 = R.id.textView2;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView4 != null) {
                            return new RewardPointWidgetBinding(cardView, imageView2, cardView, imageView3, constraintLayout, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static RewardPointWidgetBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static RewardPointWidgetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.reward_point_widget, viewGroup, false);
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
