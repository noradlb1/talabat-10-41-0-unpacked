package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatRadioButton;
import com.talabat.TalabatTextView;

public final class CheckoutCardListItemBinding implements ViewBinding {
    @NonNull
    public final ImageView binDiscountIcon;
    @NonNull
    public final TalabatTextView binVoucherText;
    @NonNull
    public final RelativeLayout binVoucherView;
    @NonNull
    public final TalabatTextView cardExpiryDate;
    @NonNull
    public final ImageView cardImg;
    @NonNull
    public final TalabatTextView cardNo;
    @NonNull
    public final TalabatRadioButton cardSelector;
    @NonNull
    public final RelativeLayout convertView;
    @NonNull
    public final TalabatTextView expiresInText;
    @NonNull
    public final LinearLayout expiryLayout;
    @NonNull
    public final LinearLayout mainContainer;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final RelativeLayout topPortion;

    private CheckoutCardListItemBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatTextView talabatTextView2, @NonNull ImageView imageView2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatRadioButton talabatRadioButton, @NonNull RelativeLayout relativeLayout3, @NonNull TalabatTextView talabatTextView4, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull RelativeLayout relativeLayout4) {
        this.rootView = relativeLayout;
        this.binDiscountIcon = imageView;
        this.binVoucherText = talabatTextView;
        this.binVoucherView = relativeLayout2;
        this.cardExpiryDate = talabatTextView2;
        this.cardImg = imageView2;
        this.cardNo = talabatTextView3;
        this.cardSelector = talabatRadioButton;
        this.convertView = relativeLayout3;
        this.expiresInText = talabatTextView4;
        this.expiryLayout = linearLayout;
        this.mainContainer = linearLayout2;
        this.topPortion = relativeLayout4;
    }

    @NonNull
    public static CheckoutCardListItemBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.bin_discount_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.bin_discount_icon);
        if (imageView != null) {
            i11 = R.id.bin_voucher_text;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.bin_voucher_text);
            if (talabatTextView != null) {
                i11 = R.id.bin_voucher_View;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.bin_voucher_View);
                if (relativeLayout != null) {
                    i11 = R.id.card_expiry_date;
                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.card_expiry_date);
                    if (talabatTextView2 != null) {
                        i11 = R.id.card_img;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.card_img);
                        if (imageView2 != null) {
                            i11 = R.id.card_no;
                            TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.card_no);
                            if (talabatTextView3 != null) {
                                i11 = R.id.card_selector;
                                TalabatRadioButton talabatRadioButton = (TalabatRadioButton) ViewBindings.findChildViewById(view2, R.id.card_selector);
                                if (talabatRadioButton != null) {
                                    RelativeLayout relativeLayout2 = (RelativeLayout) view2;
                                    i11 = R.id.expires_in_text;
                                    TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.expires_in_text);
                                    if (talabatTextView4 != null) {
                                        i11 = R.id.expiry_layout;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.expiry_layout);
                                        if (linearLayout != null) {
                                            i11 = R.id.main_container;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.main_container);
                                            if (linearLayout2 != null) {
                                                i11 = R.id.top_portion;
                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.top_portion);
                                                if (relativeLayout3 != null) {
                                                    return new CheckoutCardListItemBinding(relativeLayout2, imageView, talabatTextView, relativeLayout, talabatTextView2, imageView2, talabatTextView3, talabatRadioButton, relativeLayout2, talabatTextView4, linearLayout, linearLayout2, relativeLayout3);
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
    public static CheckoutCardListItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CheckoutCardListItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.checkout_card_list_item, viewGroup, false);
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
