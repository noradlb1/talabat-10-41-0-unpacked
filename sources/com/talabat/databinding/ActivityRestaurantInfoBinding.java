package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.TalabatTextView;
import com.talabat.helpers.BaseRatingBar;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarTextView;

public final class ActivityRestaurantInfoBinding implements ViewBinding {
    @NonNull
    public final ImageView amexIcon;
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    public final ImageView btnNewClose;
    @NonNull
    public final ImageView cashIcon;
    @NonNull
    public final ImageView debitCardIcon;
    @NonNull
    public final TalabatButton done;
    @NonNull
    public final RelativeLayout gemFooterView;
    @NonNull
    public final TalabatToolBarImageButton ibCart;
    @NonNull
    public final AppCompatImageView ivCoverImage;
    @NonNull
    public final AppCompatImageView ivRestLogo;
    @NonNull
    public final TalabatTextView llRate;
    @NonNull
    public final ImageView mastercardIcon;
    @NonNull
    public final View municipalitySeparator;
    @NonNull
    public final LinearLayout municipalityTaxView;
    @NonNull
    public final View preOrderSeperator;
    @NonNull
    public final RelativeLayout ratingView;
    @NonNull
    public final BaseRatingBar ratingbarRestaurantScreen;
    @NonNull
    public final RelativeLayout rlCartHolder;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final NestedScrollView scrollView1;
    @NonNull
    public final RelativeLayout talabatToolbar;
    @NonNull
    public final TalabatTextView textViewAreaTitle;
    @NonNull
    public final TalabatToolBar toolbar;
    @NonNull
    public final View touristSeparator;
    @NonNull
    public final LinearLayout touristTaxView;
    @NonNull
    public final TalabatToolBarTextView tvCartCount;
    @NonNull
    public final TalabatTextView tvDeliveryCharges;
    @NonNull
    public final TalabatTextView tvDeliveryTime;
    @NonNull
    public final TalabatTextView tvMinimumOrder;
    @NonNull
    public final TalabatTextView tvMunicipalityTax;
    @NonNull
    public final TalabatTextView tvMunicipalityTaxText;
    @NonNull
    public final TalabatTextView tvOpeningHours;
    @NonNull
    public final TalabatTextView tvOrderDetails;
    @NonNull
    public final TalabatTextView tvOtherInfo;
    @NonNull
    public final TalabatTextView tvPostDateDelivery;
    @NonNull
    public final TalabatTextView tvRatingCount;
    @NonNull
    public final TalabatTextView tvRestaurantArea;
    @NonNull
    public final TalabatTextView tvRestaurantCuisines;
    @NonNull
    public final TalabatTextView tvRestaurantDeliveryChargesText;
    @NonNull
    public final TalabatTextView tvRestaurantName;
    @NonNull
    public final TalabatTextView tvStatusLabel;
    @NonNull
    public final TalabatToolBarTextView tvTitle;
    @NonNull
    public final TalabatTextView tvTouristTax;
    @NonNull
    public final TalabatTextView tvTouristTaxText;
    @NonNull
    public final ImageView vendorRateAvatar;
    @NonNull
    public final TextView vendorRateStatus;
    @NonNull
    public final ImageView visaIcon;

    private ActivityRestaurantInfoBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull TalabatButton talabatButton, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatToolBarImageButton talabatToolBarImageButton2, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull TalabatTextView talabatTextView, @NonNull ImageView imageView5, @NonNull View view, @NonNull LinearLayout linearLayout, @NonNull View view2, @NonNull RelativeLayout relativeLayout3, @NonNull BaseRatingBar baseRatingBar, @NonNull RelativeLayout relativeLayout4, @NonNull NestedScrollView nestedScrollView, @NonNull RelativeLayout relativeLayout5, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatToolBar talabatToolBar, @NonNull View view3, @NonNull LinearLayout linearLayout2, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4, @NonNull TalabatTextView talabatTextView5, @NonNull TalabatTextView talabatTextView6, @NonNull TalabatTextView talabatTextView7, @NonNull TalabatTextView talabatTextView8, @NonNull TalabatTextView talabatTextView9, @NonNull TalabatTextView talabatTextView10, @NonNull TalabatTextView talabatTextView11, @NonNull TalabatTextView talabatTextView12, @NonNull TalabatTextView talabatTextView13, @NonNull TalabatTextView talabatTextView14, @NonNull TalabatTextView talabatTextView15, @NonNull TalabatTextView talabatTextView16, @NonNull TalabatTextView talabatTextView17, @NonNull TalabatToolBarTextView talabatToolBarTextView2, @NonNull TalabatTextView talabatTextView18, @NonNull TalabatTextView talabatTextView19, @NonNull ImageView imageView6, @NonNull TextView textView, @NonNull ImageView imageView7) {
        this.rootView = relativeLayout;
        this.amexIcon = imageView;
        this.back = talabatToolBarImageButton;
        this.btnNewClose = imageView2;
        this.cashIcon = imageView3;
        this.debitCardIcon = imageView4;
        this.done = talabatButton;
        this.gemFooterView = relativeLayout2;
        this.ibCart = talabatToolBarImageButton2;
        this.ivCoverImage = appCompatImageView;
        this.ivRestLogo = appCompatImageView2;
        this.llRate = talabatTextView;
        this.mastercardIcon = imageView5;
        this.municipalitySeparator = view;
        this.municipalityTaxView = linearLayout;
        this.preOrderSeperator = view2;
        this.ratingView = relativeLayout3;
        this.ratingbarRestaurantScreen = baseRatingBar;
        this.rlCartHolder = relativeLayout4;
        this.scrollView1 = nestedScrollView;
        this.talabatToolbar = relativeLayout5;
        this.textViewAreaTitle = talabatTextView2;
        this.toolbar = talabatToolBar;
        this.touristSeparator = view3;
        this.touristTaxView = linearLayout2;
        this.tvCartCount = talabatToolBarTextView;
        this.tvDeliveryCharges = talabatTextView3;
        this.tvDeliveryTime = talabatTextView4;
        this.tvMinimumOrder = talabatTextView5;
        this.tvMunicipalityTax = talabatTextView6;
        this.tvMunicipalityTaxText = talabatTextView7;
        this.tvOpeningHours = talabatTextView8;
        this.tvOrderDetails = talabatTextView9;
        this.tvOtherInfo = talabatTextView10;
        this.tvPostDateDelivery = talabatTextView11;
        this.tvRatingCount = talabatTextView12;
        this.tvRestaurantArea = talabatTextView13;
        this.tvRestaurantCuisines = talabatTextView14;
        this.tvRestaurantDeliveryChargesText = talabatTextView15;
        this.tvRestaurantName = talabatTextView16;
        this.tvStatusLabel = talabatTextView17;
        this.tvTitle = talabatToolBarTextView2;
        this.tvTouristTax = talabatTextView18;
        this.tvTouristTaxText = talabatTextView19;
        this.vendorRateAvatar = imageView6;
        this.vendorRateStatus = textView;
        this.visaIcon = imageView7;
    }

    @NonNull
    public static ActivityRestaurantInfoBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.amex_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.amex_icon);
        if (imageView != null) {
            i11 = R.id.back;
            TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.back);
            if (talabatToolBarImageButton != null) {
                i11 = R.id.btn_new_close;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.btn_new_close);
                if (imageView2 != null) {
                    i11 = R.id.cash_icon;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.cash_icon);
                    if (imageView3 != null) {
                        i11 = R.id.debit_card_icon;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.debit_card_icon);
                        if (imageView4 != null) {
                            i11 = R.id.done;
                            TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view2, R.id.done);
                            if (talabatButton != null) {
                                i11 = R.id.gem_footer_view;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.gem_footer_view);
                                if (relativeLayout != null) {
                                    i11 = R.id.ib_cart;
                                    TalabatToolBarImageButton talabatToolBarImageButton2 = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.ib_cart);
                                    if (talabatToolBarImageButton2 != null) {
                                        i11 = R.id.iv_cover_image;
                                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view2, R.id.iv_cover_image);
                                        if (appCompatImageView != null) {
                                            i11 = R.id.iv_rest_logo;
                                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view2, R.id.iv_rest_logo);
                                            if (appCompatImageView2 != null) {
                                                i11 = R.id.ll_rate;
                                                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.ll_rate);
                                                if (talabatTextView != null) {
                                                    i11 = R.id.mastercard_icon;
                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, R.id.mastercard_icon);
                                                    if (imageView5 != null) {
                                                        i11 = R.id.municipality_separator;
                                                        View findChildViewById = ViewBindings.findChildViewById(view2, R.id.municipality_separator);
                                                        if (findChildViewById != null) {
                                                            i11 = R.id.municipality_tax_view;
                                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.municipality_tax_view);
                                                            if (linearLayout != null) {
                                                                i11 = R.id.pre_order_seperator;
                                                                View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.pre_order_seperator);
                                                                if (findChildViewById2 != null) {
                                                                    i11 = R.id.rating_view;
                                                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rating_view);
                                                                    if (relativeLayout2 != null) {
                                                                        i11 = R.id.ratingbar_restaurant_screen;
                                                                        BaseRatingBar baseRatingBar = (BaseRatingBar) ViewBindings.findChildViewById(view2, R.id.ratingbar_restaurant_screen);
                                                                        if (baseRatingBar != null) {
                                                                            i11 = R.id.rl_cart_holder;
                                                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_cart_holder);
                                                                            if (relativeLayout3 != null) {
                                                                                i11 = R.id.scrollView1;
                                                                                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view2, R.id.scrollView1);
                                                                                if (nestedScrollView != null) {
                                                                                    i11 = R.id.talabat_toolbar;
                                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.talabat_toolbar);
                                                                                    if (relativeLayout4 != null) {
                                                                                        i11 = R.id.textView_area_title;
                                                                                        TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.textView_area_title);
                                                                                        if (talabatTextView2 != null) {
                                                                                            i11 = R.id.toolbar;
                                                                                            TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                                            if (talabatToolBar != null) {
                                                                                                i11 = R.id.tourist_separator;
                                                                                                View findChildViewById3 = ViewBindings.findChildViewById(view2, R.id.tourist_separator);
                                                                                                if (findChildViewById3 != null) {
                                                                                                    i11 = R.id.tourist_tax_view;
                                                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.tourist_tax_view);
                                                                                                    if (linearLayout2 != null) {
                                                                                                        i11 = R.id.tv_cart_count;
                                                                                                        TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.tv_cart_count);
                                                                                                        if (talabatToolBarTextView != null) {
                                                                                                            i11 = R.id.tv_delivery_charges;
                                                                                                            TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_delivery_charges);
                                                                                                            if (talabatTextView3 != null) {
                                                                                                                i11 = R.id.tv_delivery_time;
                                                                                                                TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_delivery_time);
                                                                                                                if (talabatTextView4 != null) {
                                                                                                                    i11 = R.id.tv_minimum_order;
                                                                                                                    TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_minimum_order);
                                                                                                                    if (talabatTextView5 != null) {
                                                                                                                        i11 = R.id.tv_municipality_tax;
                                                                                                                        TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_municipality_tax);
                                                                                                                        if (talabatTextView6 != null) {
                                                                                                                            i11 = R.id.tv_municipality_tax_text;
                                                                                                                            TalabatTextView talabatTextView7 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_municipality_tax_text);
                                                                                                                            if (talabatTextView7 != null) {
                                                                                                                                i11 = R.id.tv_opening_hours;
                                                                                                                                TalabatTextView talabatTextView8 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_opening_hours);
                                                                                                                                if (talabatTextView8 != null) {
                                                                                                                                    i11 = R.id.tv_order_details;
                                                                                                                                    TalabatTextView talabatTextView9 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_order_details);
                                                                                                                                    if (talabatTextView9 != null) {
                                                                                                                                        i11 = R.id.tv_other_info;
                                                                                                                                        TalabatTextView talabatTextView10 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_other_info);
                                                                                                                                        if (talabatTextView10 != null) {
                                                                                                                                            i11 = R.id.tv_post_dateDelivery;
                                                                                                                                            TalabatTextView talabatTextView11 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_post_dateDelivery);
                                                                                                                                            if (talabatTextView11 != null) {
                                                                                                                                                i11 = R.id.tv_rating_count;
                                                                                                                                                TalabatTextView talabatTextView12 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_rating_count);
                                                                                                                                                if (talabatTextView12 != null) {
                                                                                                                                                    i11 = R.id.tv_restaurant_area;
                                                                                                                                                    TalabatTextView talabatTextView13 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_restaurant_area);
                                                                                                                                                    if (talabatTextView13 != null) {
                                                                                                                                                        i11 = R.id.tv_restaurant_cuisines;
                                                                                                                                                        TalabatTextView talabatTextView14 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_restaurant_cuisines);
                                                                                                                                                        if (talabatTextView14 != null) {
                                                                                                                                                            i11 = R.id.tv_restaurant_delivery_charges_text;
                                                                                                                                                            TalabatTextView talabatTextView15 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_restaurant_delivery_charges_text);
                                                                                                                                                            if (talabatTextView15 != null) {
                                                                                                                                                                i11 = R.id.tv_restaurant_name;
                                                                                                                                                                TalabatTextView talabatTextView16 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_restaurant_name);
                                                                                                                                                                if (talabatTextView16 != null) {
                                                                                                                                                                    i11 = R.id.tv_status_label;
                                                                                                                                                                    TalabatTextView talabatTextView17 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_status_label);
                                                                                                                                                                    if (talabatTextView17 != null) {
                                                                                                                                                                        i11 = R.id.tv_title;
                                                                                                                                                                        TalabatToolBarTextView talabatToolBarTextView2 = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.tv_title);
                                                                                                                                                                        if (talabatToolBarTextView2 != null) {
                                                                                                                                                                            i11 = R.id.tv_tourist_tax;
                                                                                                                                                                            TalabatTextView talabatTextView18 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_tourist_tax);
                                                                                                                                                                            if (talabatTextView18 != null) {
                                                                                                                                                                                i11 = R.id.tv_tourist_tax_text;
                                                                                                                                                                                TalabatTextView talabatTextView19 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_tourist_tax_text);
                                                                                                                                                                                if (talabatTextView19 != null) {
                                                                                                                                                                                    i11 = R.id.vendor_rate_avatar;
                                                                                                                                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view2, R.id.vendor_rate_avatar);
                                                                                                                                                                                    if (imageView6 != null) {
                                                                                                                                                                                        i11 = R.id.vendor_rate_status;
                                                                                                                                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.vendor_rate_status);
                                                                                                                                                                                        if (textView != null) {
                                                                                                                                                                                            i11 = R.id.visa_icon;
                                                                                                                                                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view2, R.id.visa_icon);
                                                                                                                                                                                            if (imageView7 != null) {
                                                                                                                                                                                                return new ActivityRestaurantInfoBinding((RelativeLayout) view2, imageView, talabatToolBarImageButton, imageView2, imageView3, imageView4, talabatButton, relativeLayout, talabatToolBarImageButton2, appCompatImageView, appCompatImageView2, talabatTextView, imageView5, findChildViewById, linearLayout, findChildViewById2, relativeLayout2, baseRatingBar, relativeLayout3, nestedScrollView, relativeLayout4, talabatTextView2, talabatToolBar, findChildViewById3, linearLayout2, talabatToolBarTextView, talabatTextView3, talabatTextView4, talabatTextView5, talabatTextView6, talabatTextView7, talabatTextView8, talabatTextView9, talabatTextView10, talabatTextView11, talabatTextView12, talabatTextView13, talabatTextView14, talabatTextView15, talabatTextView16, talabatTextView17, talabatToolBarTextView2, talabatTextView18, talabatTextView19, imageView6, textView, imageView7);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ActivityRestaurantInfoBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityRestaurantInfoBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_restaurant_info, viewGroup, false);
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
