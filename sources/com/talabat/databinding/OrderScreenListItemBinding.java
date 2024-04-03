package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.volley.toolbox.NetworkImageView;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class OrderScreenListItemBinding implements ViewBinding {
    @NonNull
    public final LinearLayout buttonsView;
    @NonNull
    public final RelativeLayout convertView;
    @NonNull
    public final LinearLayout detailsContainer;
    @NonNull
    public final TalabatTextView orderId;
    @NonNull
    public final ImageView orderScreenArrow;
    @NonNull
    public final LinearLayout orderScreenLivetrackingView;
    @NonNull
    public final LinearLayout orderScreenRateView;
    @NonNull
    public final LinearLayout orderScreenReorderView;
    @NonNull
    public final NetworkImageView orderScreenRestImage;
    @NonNull
    public final LinearLayout orderScreenRestImageView;
    @NonNull
    public final TalabatTextView orderScreenRestaurantName;
    @NonNull
    public final TalabatTextView orderScreenResult;
    @NonNull
    public final TalabatTextView orderScreenTime;
    @NonNull
    private final CardView rootView;

    private OrderScreenListItemBinding(@NonNull CardView cardView, @NonNull LinearLayout linearLayout, @NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout2, @NonNull TalabatTextView talabatTextView, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull LinearLayout linearLayout5, @NonNull NetworkImageView networkImageView, @NonNull LinearLayout linearLayout6, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4) {
        this.rootView = cardView;
        this.buttonsView = linearLayout;
        this.convertView = relativeLayout;
        this.detailsContainer = linearLayout2;
        this.orderId = talabatTextView;
        this.orderScreenArrow = imageView;
        this.orderScreenLivetrackingView = linearLayout3;
        this.orderScreenRateView = linearLayout4;
        this.orderScreenReorderView = linearLayout5;
        this.orderScreenRestImage = networkImageView;
        this.orderScreenRestImageView = linearLayout6;
        this.orderScreenRestaurantName = talabatTextView2;
        this.orderScreenResult = talabatTextView3;
        this.orderScreenTime = talabatTextView4;
    }

    @NonNull
    public static OrderScreenListItemBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.buttons_view;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.buttons_view);
        if (linearLayout != null) {
            i11 = R.id.convertView;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.convertView);
            if (relativeLayout != null) {
                i11 = R.id.details_container;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.details_container);
                if (linearLayout2 != null) {
                    i11 = R.id.order_id;
                    TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_id);
                    if (talabatTextView != null) {
                        i11 = R.id.order_screen_arrow;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.order_screen_arrow);
                        if (imageView != null) {
                            i11 = R.id.order_screen_livetracking_view;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.order_screen_livetracking_view);
                            if (linearLayout3 != null) {
                                i11 = R.id.order_screen_rate_view;
                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.order_screen_rate_view);
                                if (linearLayout4 != null) {
                                    i11 = R.id.order_screen_reorder_view;
                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.order_screen_reorder_view);
                                    if (linearLayout5 != null) {
                                        i11 = R.id.order_screen_rest_image;
                                        NetworkImageView networkImageView = (NetworkImageView) ViewBindings.findChildViewById(view2, R.id.order_screen_rest_image);
                                        if (networkImageView != null) {
                                            i11 = R.id.order_screen_rest_image_view;
                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.order_screen_rest_image_view);
                                            if (linearLayout6 != null) {
                                                i11 = R.id.order_screen_restaurant_name;
                                                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_screen_restaurant_name);
                                                if (talabatTextView2 != null) {
                                                    i11 = R.id.order_screen_result;
                                                    TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_screen_result);
                                                    if (talabatTextView3 != null) {
                                                        i11 = R.id.order_screen_time;
                                                        TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_screen_time);
                                                        if (talabatTextView4 != null) {
                                                            return new OrderScreenListItemBinding((CardView) view2, linearLayout, relativeLayout, linearLayout2, talabatTextView, imageView, linearLayout3, linearLayout4, linearLayout5, networkImageView, linearLayout6, talabatTextView2, talabatTextView3, talabatTextView4);
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
    public static OrderScreenListItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static OrderScreenListItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.order_screen_list_item, viewGroup, false);
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
