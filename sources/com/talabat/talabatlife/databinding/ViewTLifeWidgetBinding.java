package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatlife.R;
import io.supercharge.shimmerlayout.ShimmerLayout;

public final class ViewTLifeWidgetBinding implements ViewBinding {
    @NonNull
    public final TextView restaurantCount;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final RelativeLayout tLifeWidget;
    @NonNull
    public final CardView tLifeWidgetCardPlaceHolderLinearLayout;
    @NonNull
    public final CardView tLifeWidgetCircle;
    @NonNull
    public final RelativeLayout tLifeWidgetContent;
    @NonNull
    public final ImageView tLifeWidgetIconImageView;
    @NonNull
    public final ImageView tLifeWidgetImageView;
    @NonNull
    public final RelativeLayout tLifeWidgetRestaurantsRelativeLayout;
    @NonNull
    public final CardView tLifeWidgetScanPlaceHolderLinearLayout;
    @NonNull
    public final ShimmerLayout tLifeWidgetShimmerLayout;
    @NonNull
    public final RelativeLayout tLifeWidgetShimmerLayoutRelativeLayout;
    @NonNull
    public final TextView tLifeWidgetTextAction;
    @NonNull
    public final ImageView tProWidgetIconImageView;

    private ViewTLifeWidgetBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout2, @NonNull CardView cardView, @NonNull CardView cardView2, @NonNull RelativeLayout relativeLayout3, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull RelativeLayout relativeLayout4, @NonNull CardView cardView3, @NonNull ShimmerLayout shimmerLayout, @NonNull RelativeLayout relativeLayout5, @NonNull TextView textView2, @NonNull ImageView imageView3) {
        this.rootView = relativeLayout;
        this.restaurantCount = textView;
        this.tLifeWidget = relativeLayout2;
        this.tLifeWidgetCardPlaceHolderLinearLayout = cardView;
        this.tLifeWidgetCircle = cardView2;
        this.tLifeWidgetContent = relativeLayout3;
        this.tLifeWidgetIconImageView = imageView;
        this.tLifeWidgetImageView = imageView2;
        this.tLifeWidgetRestaurantsRelativeLayout = relativeLayout4;
        this.tLifeWidgetScanPlaceHolderLinearLayout = cardView3;
        this.tLifeWidgetShimmerLayout = shimmerLayout;
        this.tLifeWidgetShimmerLayoutRelativeLayout = relativeLayout5;
        this.tLifeWidgetTextAction = textView2;
        this.tProWidgetIconImageView = imageView3;
    }

    @NonNull
    public static ViewTLifeWidgetBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.restaurant_count;
        TextView textView = (TextView) ViewBindings.findChildViewById(view2, i11);
        if (textView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view2;
            i11 = R.id.tLifeWidgetCardPlaceHolderLinearLayout;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view2, i11);
            if (cardView != null) {
                i11 = R.id.tLifeWidgetCircle;
                CardView cardView2 = (CardView) ViewBindings.findChildViewById(view2, i11);
                if (cardView2 != null) {
                    i11 = R.id.tLifeWidgetContent;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, i11);
                    if (relativeLayout2 != null) {
                        i11 = R.id.tLifeWidgetIconImageView;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i11);
                        if (imageView != null) {
                            i11 = R.id.tLifeWidgetImageView;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, i11);
                            if (imageView2 != null) {
                                i11 = R.id.tLifeWidgetRestaurantsRelativeLayout;
                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, i11);
                                if (relativeLayout3 != null) {
                                    i11 = R.id.tLifeWidgetScanPlaceHolderLinearLayout;
                                    CardView cardView3 = (CardView) ViewBindings.findChildViewById(view2, i11);
                                    if (cardView3 != null) {
                                        i11 = R.id.tLifeWidgetShimmerLayout;
                                        ShimmerLayout shimmerLayout = (ShimmerLayout) ViewBindings.findChildViewById(view2, i11);
                                        if (shimmerLayout != null) {
                                            i11 = R.id.tLifeWidgetShimmerLayoutRelativeLayout;
                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, i11);
                                            if (relativeLayout4 != null) {
                                                i11 = R.id.tLifeWidgetTextAction;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                if (textView2 != null) {
                                                    i11 = R.id.tProWidgetIconImageView;
                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, i11);
                                                    if (imageView3 != null) {
                                                        return new ViewTLifeWidgetBinding(relativeLayout, textView, relativeLayout, cardView, cardView2, relativeLayout2, imageView, imageView2, relativeLayout3, cardView3, shimmerLayout, relativeLayout4, textView2, imageView3);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewTLifeWidgetBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewTLifeWidgetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_t_life_widget, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
