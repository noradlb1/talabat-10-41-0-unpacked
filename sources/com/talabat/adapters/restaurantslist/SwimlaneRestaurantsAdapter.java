package com.talabat.adapters.restaurantslist;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import bf.h;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.talabat.R;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.designhelpers.GlideActivityExceptionHandler;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcommon.helpers.GlideApp;
import com.talabat.talabatcommon.views.ratings.SmallStarRatingView;
import datamodels.Restaurant;
import datamodels.Swimlane;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.apache.commons.lang3.ArrayUtils;

public class SwimlaneRestaurantsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String PAST_ORDER_SLUG = "Past Orders";

    /* renamed from: i  reason: collision with root package name */
    public Context f55343i;

    /* renamed from: j  reason: collision with root package name */
    public int f55344j = 0;

    /* renamed from: k  reason: collision with root package name */
    public Swimlane f55345k;
    private OnRestaurantClick mListiner;

    public enum CellType {
        RECOMMENDATION,
        PAST_ORDER
    }

    public class PastOrderRestaurantViewHolder extends RecyclerView.ViewHolder {
        private final TextView deliveryTime;
        private final ImageView restaurantImage;
        private final TextView restaurantName;

        public PastOrderRestaurantViewHolder(View view) {
            super(view);
            this.restaurantImage = (ImageView) view.findViewById(R.id.restaurantImage);
            this.restaurantName = (TextView) view.findViewById(R.id.restaurantName);
            this.deliveryTime = (TextView) view.findViewById(R.id.deliveryTimeLabel);
        }

        public void bind(PastOrderRestaurantViewHolder pastOrderRestaurantViewHolder, Restaurant restaurant, int i11) {
            GlideApp.with(pastOrderRestaurantViewHolder.restaurantImage.getContext()).clear((View) pastOrderRestaurantViewHolder.restaurantImage);
            GlideApp.with(pastOrderRestaurantViewHolder.restaurantImage.getContext()).load(restaurant.getLogo()).placeholder((int) R.drawable.glide_placeholder).into(pastOrderRestaurantViewHolder.restaurantImage);
            pastOrderRestaurantViewHolder.restaurantName.setText(restaurant.getName().trim());
            pastOrderRestaurantViewHolder.deliveryTime.setText(String.format("%s %s", new Object[]{restaurant.deliveryTimeInteger, pastOrderRestaurantViewHolder.itemView.getContext().getString(R.string.mins_)}));
            pastOrderRestaurantViewHolder.itemView.setOnClickListener(SwimlaneRestaurantsAdapter.this.restaurantClickListener(restaurant, i11));
        }
    }

    public class RecommendationRestaurantViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public ImageView mImageViewRestaurantImage;
        /* access modifiers changed from: private */
        public CardView mLinearLayoutContainer;
        /* access modifiers changed from: private */
        public TextView mTextViewRestaurantCuisines;
        /* access modifiers changed from: private */
        public TextView mTextViewRestaurantName;
        /* access modifiers changed from: private */
        public View preOrderLayout;
        /* access modifiers changed from: private */
        public SmallStarRatingView smallStarRatingView;
        /* access modifiers changed from: private */
        public TextView textView_averageDeliveryTime;
        /* access modifiers changed from: private */
        public TextView textView_deliveryCost;
        /* access modifiers changed from: private */
        public ImageView vendorRateAvatar;
        /* access modifiers changed from: private */
        public TextView vendorRateStatus;

        public RecommendationRestaurantViewHolder(View view) {
            super(view);
            this.mImageViewRestaurantImage = (ImageView) view.findViewById(R.id.imageView_restaurantImage);
            this.vendorRateAvatar = (ImageView) view.findViewById(R.id.vendorRateAvatar);
            this.mTextViewRestaurantName = (TextView) view.findViewById(R.id.textView_restaurantName);
            this.mTextViewRestaurantCuisines = (TextView) view.findViewById(R.id.textView_restaurantCuisine);
            this.vendorRateStatus = (TextView) view.findViewById(R.id.vendorRateStatus);
            this.textView_deliveryCost = (TextView) view.findViewById(R.id.textView_deliveryCost);
            this.textView_averageDeliveryTime = (TextView) view.findViewById(R.id.textView_averageDeliveryTime);
            this.mLinearLayoutContainer = (CardView) view.findViewById(R.id.linearLayout_container);
            this.preOrderLayout = view.findViewById(R.id.layout_preOrder);
            this.smallStarRatingView = (SmallStarRatingView) view.findViewById(R.id.starRating);
        }
    }

    public SwimlaneRestaurantsAdapter(Context context, Swimlane swimlane) {
        this.f55343i = context;
        this.f55345k = swimlane;
    }

    private Boolean canShowNewPastOrderCard() {
        return Boolean.valueOf(this.f55345k.getSlug() != null && this.f55345k.getSlug().equals(PAST_ORDER_SLUG));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$restaurantClickListener$0(Restaurant restaurant, int i11, View view) {
        GlobalDataModel.ShopClickOrigin = "swimlane";
        GlobalDataModel.SelectedSwimlane = this.f55345k;
        int i12 = i11 + 1;
        restaurant.swimlanePosition = i12;
        restaurant.itemPosition = i12;
        this.mListiner.onRestaurantClick(restaurant, i11);
    }

    /* access modifiers changed from: private */
    public View.OnClickListener restaurantClickListener(Restaurant restaurant, int i11) {
        return new h(this, restaurant, i11);
    }

    public int getItemCount() {
        ArrayList<Restaurant> arrayList = this.f55345k.restaurants;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public int getItemViewType(int i11) {
        if (Boolean.TRUE.equals(canShowNewPastOrderCard())) {
            return CellType.PAST_ORDER.ordinal();
        }
        return CellType.RECOMMENDATION.ordinal();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        int i12;
        this.f55344j++;
        final Restaurant restaurant = this.f55345k.restaurants.get(i11);
        restaurant.itemDisplayed = this.f55344j;
        if (viewHolder instanceof PastOrderRestaurantViewHolder) {
            PastOrderRestaurantViewHolder pastOrderRestaurantViewHolder = (PastOrderRestaurantViewHolder) viewHolder;
            pastOrderRestaurantViewHolder.bind(pastOrderRestaurantViewHolder, restaurant, i11);
            return;
        }
        final RecommendationRestaurantViewHolder recommendationRestaurantViewHolder = (RecommendationRestaurantViewHolder) viewHolder;
        if (restaurant.statusType == 5) {
            recommendationRestaurantViewHolder.preOrderLayout.setVisibility(0);
        } else {
            recommendationRestaurantViewHolder.preOrderLayout.setVisibility(8);
        }
        recommendationRestaurantViewHolder.mTextViewRestaurantName.setText(restaurant.getName().trim());
        if (restaurant.getTalabatCoverLogo() == null) {
            recommendationRestaurantViewHolder.mImageViewRestaurantImage.setBackgroundColor(this.f55343i.getResources().getColor(R.color.tgo_list_place_holder_color));
            recommendationRestaurantViewHolder.mImageViewRestaurantImage.setVisibility(0);
        } else if (GlideActivityExceptionHandler.INSTANCE.isValidContextForGlide(recommendationRestaurantViewHolder.mImageViewRestaurantImage.getContext())) {
            GlideApp.with(recommendationRestaurantViewHolder.mImageViewRestaurantImage.getContext()).clear((View) recommendationRestaurantViewHolder.mImageViewRestaurantImage);
            GlideApp.with(recommendationRestaurantViewHolder.mImageViewRestaurantImage.getContext()).load(restaurant.getTalabatCoverLogo()).transform((Transformation) new MultiTransformation((Transformation<T>[]) new Transformation[]{new CenterCrop(), new RoundedCorners((int) TypedValue.applyDimension(1, 8.0f, this.f55343i.getResources().getDisplayMetrics()))})).listener((RequestListener) new RequestListener<Drawable>() {
                public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
                    String trim = restaurant.getTalabatCoverLogo().toString().trim();
                    if (TalabatUtils.isNullOrEmpty(trim.substring(trim.lastIndexOf("/") + 1, trim.length()))) {
                        recommendationRestaurantViewHolder.mImageViewRestaurantImage.setBackgroundColor(SwimlaneRestaurantsAdapter.this.f55343i.getResources().getColor(R.color.tgo_list_place_holder_color));
                        recommendationRestaurantViewHolder.mImageViewRestaurantImage.setVisibility(0);
                    }
                    return false;
                }

                public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
                    return false;
                }
            }).placeholder((int) R.drawable.glide_placeholder).into(recommendationRestaurantViewHolder.mImageViewRestaurantImage);
        }
        recommendationRestaurantViewHolder.textView_averageDeliveryTime.setText(restaurant.deliveryTime);
        recommendationRestaurantViewHolder.mTextViewRestaurantCuisines.setText(restaurant.getCuisineString());
        if (restaurant.isFirstOrderFree && restaurant.getDeliveryCharges() != 0.0f) {
            SpannableString spannableString = new SpannableString(restaurant.getDisplayDeliveryCharges());
            spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, spannableString.length(), 33);
            spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            recommendationRestaurantViewHolder.textView_deliveryCost.append(spannableString);
            SpannableString spannableString2 = new SpannableString(" " + this.f55343i.getResources().getString(R.string.free));
            spannableString2.setSpan(new ForegroundColorSpan(this.f55343i.getResources().getColor(R.color.neutral_black)), 0, spannableString2.length(), 33);
            recommendationRestaurantViewHolder.textView_deliveryCost.append(spannableString2);
        } else if (restaurant.getDeliveryCharges() == 0.0f) {
            recommendationRestaurantViewHolder.textView_deliveryCost.setText(this.f55343i.getResources().getString(R.string.free_caps));
        } else if (restaurant.isTalabatGo) {
            recommendationRestaurantViewHolder.textView_deliveryCost.setText(restaurant.getDisplayDeliveryCharges(), TextView.BufferType.SPANNABLE);
        } else {
            recommendationRestaurantViewHolder.textView_deliveryCost.setText(restaurant.getDisplayDeliveryCharges());
        }
        if (restaurant.getRating() <= 2.7f) {
            recommendationRestaurantViewHolder.vendorRateAvatar.setImageResource(R.drawable.ds_rating_okay);
            recommendationRestaurantViewHolder.vendorRateStatus.setText(R.string.rate_fair);
        } else if (restaurant.getRating() <= 3.7f) {
            recommendationRestaurantViewHolder.vendorRateAvatar.setImageResource(R.drawable.ds_rating_good);
            recommendationRestaurantViewHolder.vendorRateStatus.setText(R.string.rate_okay);
        } else if (restaurant.getRating() <= 4.5f) {
            recommendationRestaurantViewHolder.vendorRateAvatar.setImageResource(R.drawable.ds_rating_very_good);
            recommendationRestaurantViewHolder.vendorRateStatus.setText(R.string.rate_very_good);
        } else {
            recommendationRestaurantViewHolder.vendorRateAvatar.setImageResource(R.drawable.ds_rating_very_good_filled);
            ImageViewCompat.setImageTintList(recommendationRestaurantViewHolder.vendorRateAvatar, ColorStateList.valueOf(ContextCompat.getColor(this.f55343i, R.color.alert_100)));
            recommendationRestaurantViewHolder.vendorRateStatus.setText(R.string.rate_amazing);
        }
        if (TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.CAN_SHOW_STAR_RATING, false, TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            recommendationRestaurantViewHolder.vendorRateAvatar.setVisibility(8);
            recommendationRestaurantViewHolder.vendorRateStatus.setVisibility(8);
            recommendationRestaurantViewHolder.smallStarRatingView.setVisibility(0);
            recommendationRestaurantViewHolder.smallStarRatingView.setRating(restaurant.getRating());
            try {
                i12 = Integer.parseInt(restaurant.getTotalRatingNonformatted());
            } catch (NumberFormatException unused) {
                i12 = 0;
            }
            recommendationRestaurantViewHolder.smallStarRatingView.setReviewsAmount(i12);
            if (TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.SHOW_STAR_RATING_WITH_COLORS, false, TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
                recommendationRestaurantViewHolder.smallStarRatingView.setColors(Arrays.asList(ArrayUtils.toObject(this.f55343i.getResources().getIntArray(R.array.colors))));
            } else {
                recommendationRestaurantViewHolder.smallStarRatingView.setColors(Collections.singletonList(Integer.valueOf(ContextCompat.getColor(this.f55343i, R.color.alert_100))));
            }
        } else {
            recommendationRestaurantViewHolder.vendorRateAvatar.setVisibility(0);
            recommendationRestaurantViewHolder.vendorRateStatus.setVisibility(0);
            recommendationRestaurantViewHolder.smallStarRatingView.setVisibility(8);
        }
        recommendationRestaurantViewHolder.mLinearLayoutContainer.setOnClickListener(restaurantClickListener(restaurant, i11));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        if (i11 == CellType.PAST_ORDER.ordinal()) {
            return new PastOrderRestaurantViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_past_order, viewGroup, false));
        }
        return new RecommendationRestaurantViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_hero_recommendation_restaurant, viewGroup, false));
    }

    public void setOnRestaurantClickListener(OnRestaurantClick onRestaurantClick) {
        this.mListiner = onRestaurantClick;
    }
}
