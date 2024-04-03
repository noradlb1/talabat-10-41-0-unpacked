package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class ItemSearchRestuarantBinding implements ViewBinding {
    @NonNull
    public final FrameLayout frameLayoutStatusContainer;
    @NonNull
    public final TextView imageViewNewTag;
    @NonNull
    public final ImageView imageViewOverlay;
    @NonNull
    public final ImageView imageViewRestaurantLogo;
    @NonNull
    public final ViewPreOrderLabelBinding layoutPreOrder;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView textViewAverageDeliveryTime;
    @NonNull
    public final TextView textViewCuisines;
    @NonNull
    public final TalabatTextView textViewDeliveryCost;
    @NonNull
    public final TalabatTextView textViewMinimumCost;
    @NonNull
    public final TextView textViewRestaurantName;
    @NonNull
    public final TextView textViewStatus;
    @NonNull
    public final ImageView vendorRateAvatar;
    @NonNull
    public final TextView vendorRateStatus;

    private ItemSearchRestuarantBinding(@NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ViewPreOrderLabelBinding viewPreOrderLabelBinding, @NonNull ProgressBar progressBar2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull ImageView imageView3, @NonNull TextView textView6) {
        this.rootView = linearLayout;
        this.frameLayoutStatusContainer = frameLayout;
        this.imageViewNewTag = textView;
        this.imageViewOverlay = imageView;
        this.imageViewRestaurantLogo = imageView2;
        this.layoutPreOrder = viewPreOrderLabelBinding;
        this.progressBar = progressBar2;
        this.textViewAverageDeliveryTime = textView2;
        this.textViewCuisines = textView3;
        this.textViewDeliveryCost = talabatTextView;
        this.textViewMinimumCost = talabatTextView2;
        this.textViewRestaurantName = textView4;
        this.textViewStatus = textView5;
        this.vendorRateAvatar = imageView3;
        this.vendorRateStatus = textView6;
    }

    @NonNull
    public static ItemSearchRestuarantBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.frameLayout_statusContainer;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.frameLayout_statusContainer);
        if (frameLayout != null) {
            i11 = R.id.imageView_newTag;
            TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.imageView_newTag);
            if (textView != null) {
                i11 = R.id.imageView_overlay;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.imageView_overlay);
                if (imageView != null) {
                    i11 = R.id.imageView_restaurantLogo;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.imageView_restaurantLogo);
                    if (imageView2 != null) {
                        i11 = R.id.layout_preOrder;
                        View findChildViewById = ViewBindings.findChildViewById(view2, R.id.layout_preOrder);
                        if (findChildViewById != null) {
                            ViewPreOrderLabelBinding bind = ViewPreOrderLabelBinding.bind(findChildViewById);
                            i11 = R.id.progressBar;
                            ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.progressBar);
                            if (progressBar2 != null) {
                                i11 = R.id.textView_averageDeliveryTime;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView_averageDeliveryTime);
                                if (textView2 != null) {
                                    i11 = R.id.textView_cuisines;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView_cuisines);
                                    if (textView3 != null) {
                                        i11 = R.id.textView_deliveryCost;
                                        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.textView_deliveryCost);
                                        if (talabatTextView != null) {
                                            i11 = R.id.textView_minimumCost;
                                            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.textView_minimumCost);
                                            if (talabatTextView2 != null) {
                                                i11 = R.id.textView_restaurantName;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView_restaurantName);
                                                if (textView4 != null) {
                                                    i11 = R.id.textView_status;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView_status);
                                                    if (textView5 != null) {
                                                        i11 = R.id.vendorRateAvatar;
                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.vendorRateAvatar);
                                                        if (imageView3 != null) {
                                                            i11 = R.id.vendorRateStatus;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.vendorRateStatus);
                                                            if (textView6 != null) {
                                                                return new ItemSearchRestuarantBinding((LinearLayout) view2, frameLayout, textView, imageView, imageView2, bind, progressBar2, textView2, textView3, talabatTextView, talabatTextView2, textView4, textView5, imageView3, textView6);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemSearchRestuarantBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemSearchRestuarantBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_search_restuarant, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
