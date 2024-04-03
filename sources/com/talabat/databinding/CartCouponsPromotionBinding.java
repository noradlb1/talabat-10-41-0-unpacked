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
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class CartCouponsPromotionBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView benefitItemDelete;
    @NonNull
    public final TalabatTextView benefitItemName;
    @NonNull
    public final TalabatTextView benefitItemNameChoiceNames;
    @NonNull
    public final TalabatTextView benefitItemPice;
    @NonNull
    public final RelativeLayout benefitItemView;
    @NonNull
    public final ImageView couponAdd;
    @NonNull
    public final TalabatTextView couponHint;
    @NonNull
    public final TalabatTextView couponTitle;
    @NonNull
    public final CardView couponView;
    @NonNull
    public final RelativeLayout freeItemHeaderView;
    @NonNull
    public final TalabatTextView mainCouponsHeading;
    @NonNull
    public final LinearLayout promotionContent;
    @NonNull
    public final ImageView promotionIcon;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final ImageView seperatorItem;
    @NonNull
    public final ImageView seperatorSection;

    private CartCouponsPromotionBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView5, @NonNull TalabatTextView talabatTextView6, @NonNull CardView cardView, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatTextView talabatTextView7, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4) {
        this.rootView = linearLayout;
        this.benefitItemDelete = talabatTextView;
        this.benefitItemName = talabatTextView2;
        this.benefitItemNameChoiceNames = talabatTextView3;
        this.benefitItemPice = talabatTextView4;
        this.benefitItemView = relativeLayout;
        this.couponAdd = imageView;
        this.couponHint = talabatTextView5;
        this.couponTitle = talabatTextView6;
        this.couponView = cardView;
        this.freeItemHeaderView = relativeLayout2;
        this.mainCouponsHeading = talabatTextView7;
        this.promotionContent = linearLayout2;
        this.promotionIcon = imageView2;
        this.seperatorItem = imageView3;
        this.seperatorSection = imageView4;
    }

    @NonNull
    public static CartCouponsPromotionBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.benefit_item_delete;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.benefit_item_delete);
        if (talabatTextView != null) {
            i11 = R.id.benefitItem_name;
            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.benefitItem_name);
            if (talabatTextView2 != null) {
                i11 = R.id.benefitItem_name_choice_names;
                TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.benefitItem_name_choice_names);
                if (talabatTextView3 != null) {
                    i11 = R.id.benefitItem_pice;
                    TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.benefitItem_pice);
                    if (talabatTextView4 != null) {
                        i11 = R.id.benefit_item_view;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.benefit_item_view);
                        if (relativeLayout != null) {
                            i11 = R.id.coupon_add;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.coupon_add);
                            if (imageView != null) {
                                i11 = R.id.coupon_hint;
                                TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.coupon_hint);
                                if (talabatTextView5 != null) {
                                    i11 = R.id.coupon_title;
                                    TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.coupon_title);
                                    if (talabatTextView6 != null) {
                                        i11 = R.id.coupon_view;
                                        CardView cardView = (CardView) ViewBindings.findChildViewById(view2, R.id.coupon_view);
                                        if (cardView != null) {
                                            i11 = R.id.free_item_header_view;
                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.free_item_header_view);
                                            if (relativeLayout2 != null) {
                                                i11 = R.id.main_coupons_heading;
                                                TalabatTextView talabatTextView7 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.main_coupons_heading);
                                                if (talabatTextView7 != null) {
                                                    i11 = R.id.promotion_content;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.promotion_content);
                                                    if (linearLayout != null) {
                                                        i11 = R.id.promotion_icon;
                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.promotion_icon);
                                                        if (imageView2 != null) {
                                                            i11 = R.id.seperator_item;
                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.seperator_item);
                                                            if (imageView3 != null) {
                                                                i11 = R.id.seperator_section;
                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.seperator_section);
                                                                if (imageView4 != null) {
                                                                    return new CartCouponsPromotionBinding((LinearLayout) view2, talabatTextView, talabatTextView2, talabatTextView3, talabatTextView4, relativeLayout, imageView, talabatTextView5, talabatTextView6, cardView, relativeLayout2, talabatTextView7, linearLayout, imageView2, imageView3, imageView4);
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
    public static CartCouponsPromotionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CartCouponsPromotionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.cart_coupons_promotion, viewGroup, false);
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
