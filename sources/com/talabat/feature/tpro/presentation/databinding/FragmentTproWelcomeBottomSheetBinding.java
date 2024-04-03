package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.tpro.presentation.R;

public final class FragmentTproWelcomeBottomSheetBinding implements ViewBinding {
    @NonNull
    public final TextView actionButtonText;
    @NonNull
    public final ImageView cancelButton;
    @NonNull
    public final ConstraintLayout container;
    @NonNull
    public final ConstraintLayout getRestaurantCoffeeLayout;
    @NonNull
    public final Guideline guidelineMid;
    @NonNull
    public final TextView ibProRestaurants;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final LinearLayout seeRestaurantsLayout;
    @NonNull
    public final TextView tvWelcomeDescription;
    @NonNull
    public final TextView tvWelcomeHeader;
    @NonNull
    public final ImageView welcomeImage;

    private FragmentTproWelcomeBottomSheetBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout2, @NonNull ConstraintLayout constraintLayout3, @NonNull Guideline guideline, @NonNull TextView textView2, @NonNull LinearLayout linearLayout, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull ImageView imageView2) {
        this.rootView = constraintLayout;
        this.actionButtonText = textView;
        this.cancelButton = imageView;
        this.container = constraintLayout2;
        this.getRestaurantCoffeeLayout = constraintLayout3;
        this.guidelineMid = guideline;
        this.ibProRestaurants = textView2;
        this.seeRestaurantsLayout = linearLayout;
        this.tvWelcomeDescription = textView3;
        this.tvWelcomeHeader = textView4;
        this.welcomeImage = imageView2;
    }

    @NonNull
    public static FragmentTproWelcomeBottomSheetBinding bind(@NonNull View view) {
        int i11 = R.id.action_button_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.cancel_button;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i11 = R.id.get_restaurant_coffee_layout;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i11);
                if (constraintLayout2 != null) {
                    i11 = R.id.guideline_mid;
                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i11);
                    if (guideline != null) {
                        i11 = R.id.ib_pro_restaurants;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView2 != null) {
                            i11 = R.id.see_restaurants_layout;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                            if (linearLayout != null) {
                                i11 = R.id.tv_welcome_description;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                                if (textView3 != null) {
                                    i11 = R.id.tv_welcome_header;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i11);
                                    if (textView4 != null) {
                                        i11 = R.id.welcome_image;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
                                        if (imageView2 != null) {
                                            return new FragmentTproWelcomeBottomSheetBinding(constraintLayout, textView, imageView, constraintLayout, constraintLayout2, guideline, textView2, linearLayout, textView3, textView4, imageView2);
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
    public static FragmentTproWelcomeBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentTproWelcomeBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tpro_welcome_bottom_sheet, viewGroup, false);
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
