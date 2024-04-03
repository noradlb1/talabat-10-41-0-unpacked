package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Barrier;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.talabatcommon.views.ratings.SmallStarRatingView;

public final class ItemHeroRecommendationRestaurantBinding implements ViewBinding {
    @NonNull
    public final ImageView deliveryBikeIcon;
    @NonNull
    public final ImageView deliveryTimeIcon;
    @NonNull
    public final Barrier deliveryTimeInfo;
    @NonNull
    public final ImageView imageViewRestaurantImage;
    @NonNull
    public final ViewPreOrderOverlayBinding layoutPreOrder;
    @NonNull
    public final FrameLayout layoutRestaurantImage;
    @NonNull
    public final CardView linearLayoutContainer;
    @NonNull
    private final CardView rootView;
    @NonNull
    public final SmallStarRatingView starRating;
    @NonNull
    public final TextView textViewAverageDeliveryTime;
    @NonNull
    public final TextView textViewDeliveryCost;
    @NonNull
    public final TextView textViewRestaurantCuisine;
    @NonNull
    public final TextView textViewRestaurantName;
    @NonNull
    public final ImageView vendorRateAvatar;
    @NonNull
    public final TextView vendorRateStatus;

    private ItemHeroRecommendationRestaurantBinding(@NonNull CardView cardView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull Barrier barrier, @NonNull ImageView imageView3, @NonNull ViewPreOrderOverlayBinding viewPreOrderOverlayBinding, @NonNull FrameLayout frameLayout, @NonNull CardView cardView2, @NonNull SmallStarRatingView smallStarRatingView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull ImageView imageView4, @NonNull TextView textView5) {
        this.rootView = cardView;
        this.deliveryBikeIcon = imageView;
        this.deliveryTimeIcon = imageView2;
        this.deliveryTimeInfo = barrier;
        this.imageViewRestaurantImage = imageView3;
        this.layoutPreOrder = viewPreOrderOverlayBinding;
        this.layoutRestaurantImage = frameLayout;
        this.linearLayoutContainer = cardView2;
        this.starRating = smallStarRatingView;
        this.textViewAverageDeliveryTime = textView;
        this.textViewDeliveryCost = textView2;
        this.textViewRestaurantCuisine = textView3;
        this.textViewRestaurantName = textView4;
        this.vendorRateAvatar = imageView4;
        this.vendorRateStatus = textView5;
    }

    @NonNull
    public static ItemHeroRecommendationRestaurantBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.deliveryBikeIcon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.deliveryBikeIcon);
        if (imageView != null) {
            i11 = R.id.deliveryTimeIcon;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.deliveryTimeIcon);
            if (imageView2 != null) {
                i11 = R.id.deliveryTimeInfo;
                Barrier barrier = (Barrier) ViewBindings.findChildViewById(view2, R.id.deliveryTimeInfo);
                if (barrier != null) {
                    i11 = R.id.imageView_restaurantImage;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.imageView_restaurantImage);
                    if (imageView3 != null) {
                        i11 = R.id.layout_preOrder;
                        View findChildViewById = ViewBindings.findChildViewById(view2, R.id.layout_preOrder);
                        if (findChildViewById != null) {
                            ViewPreOrderOverlayBinding bind = ViewPreOrderOverlayBinding.bind(findChildViewById);
                            i11 = R.id.layout_restaurantImage;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.layout_restaurantImage);
                            if (frameLayout != null) {
                                CardView cardView = (CardView) view2;
                                i11 = R.id.starRating;
                                SmallStarRatingView smallStarRatingView = (SmallStarRatingView) ViewBindings.findChildViewById(view2, R.id.starRating);
                                if (smallStarRatingView != null) {
                                    i11 = R.id.textView_averageDeliveryTime;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.textView_averageDeliveryTime);
                                    if (textView != null) {
                                        i11 = R.id.textView_deliveryCost;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView_deliveryCost);
                                        if (textView2 != null) {
                                            i11 = R.id.textView_restaurantCuisine;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView_restaurantCuisine);
                                            if (textView3 != null) {
                                                i11 = R.id.textView_restaurantName;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView_restaurantName);
                                                if (textView4 != null) {
                                                    i11 = R.id.vendorRateAvatar;
                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.vendorRateAvatar);
                                                    if (imageView4 != null) {
                                                        i11 = R.id.vendorRateStatus;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.vendorRateStatus);
                                                        if (textView5 != null) {
                                                            return new ItemHeroRecommendationRestaurantBinding(cardView, imageView, imageView2, barrier, imageView3, bind, frameLayout, cardView, smallStarRatingView, textView, textView2, textView3, textView4, imageView4, textView5);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemHeroRecommendationRestaurantBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemHeroRecommendationRestaurantBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_hero_recommendation_restaurant, viewGroup, false);
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
