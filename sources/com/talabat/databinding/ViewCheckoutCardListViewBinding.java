package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class ViewCheckoutCardListViewBinding implements ViewBinding {
    @NonNull
    public final View benefitInfo;
    @NonNull
    public final ImageView binDiscountIcon;
    @NonNull
    public final TextView binVoucherText;
    @NonNull
    public final TextView cardExpiryDate;
    @NonNull
    public final ImageView cardImg;
    @NonNull
    public final TextView cardNo;
    @NonNull
    public final RadioButton cardSelector;
    @NonNull
    public final FrameLayout convertView;
    @NonNull
    public final TextView expiresInText;
    @NonNull
    public final ConstraintLayout mainContainer;
    @NonNull
    public final View qpayInfo;
    @NonNull
    private final FrameLayout rootView;

    private ViewCheckoutCardListViewBinding(@NonNull FrameLayout frameLayout, @NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView2, @NonNull TextView textView3, @NonNull RadioButton radioButton, @NonNull FrameLayout frameLayout2, @NonNull TextView textView4, @NonNull ConstraintLayout constraintLayout, @NonNull View view2) {
        this.rootView = frameLayout;
        this.benefitInfo = view;
        this.binDiscountIcon = imageView;
        this.binVoucherText = textView;
        this.cardExpiryDate = textView2;
        this.cardImg = imageView2;
        this.cardNo = textView3;
        this.cardSelector = radioButton;
        this.convertView = frameLayout2;
        this.expiresInText = textView4;
        this.mainContainer = constraintLayout;
        this.qpayInfo = view2;
    }

    @NonNull
    public static ViewCheckoutCardListViewBinding bind(@NonNull View view) {
        int i11 = R.id.benefit_info;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.benefit_info);
        if (findChildViewById != null) {
            i11 = R.id.bin_discount_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.bin_discount_icon);
            if (imageView != null) {
                i11 = R.id.bin_voucher_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.bin_voucher_text);
                if (textView != null) {
                    i11 = R.id.card_expiry_date;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.card_expiry_date);
                    if (textView2 != null) {
                        i11 = R.id.card_img;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.card_img);
                        if (imageView2 != null) {
                            i11 = R.id.card_no;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.card_no);
                            if (textView3 != null) {
                                i11 = R.id.card_selector;
                                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.card_selector);
                                if (radioButton != null) {
                                    FrameLayout frameLayout = (FrameLayout) view;
                                    i11 = R.id.expires_in_text;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.expires_in_text);
                                    if (textView4 != null) {
                                        i11 = R.id.main_container;
                                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.main_container);
                                        if (constraintLayout != null) {
                                            i11 = R.id.qpay_info;
                                            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.qpay_info);
                                            if (findChildViewById2 != null) {
                                                return new ViewCheckoutCardListViewBinding(frameLayout, findChildViewById, imageView, textView, textView2, imageView2, textView3, radioButton, frameLayout, textView4, constraintLayout, findChildViewById2);
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
    public static ViewCheckoutCardListViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewCheckoutCardListViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_checkout_card_list_view, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
