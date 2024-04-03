package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_tag.DSTag;
import com.talabat.R;
import com.talabat.TalabatEditText;
import com.talabat.TalabatTextView;
import com.talabat.fees.ServiceFeeView;
import com.talabat.fees.SmallOrderFeeView;
import com.talabat.gem.adapters.presentation.checkout.GemCheckoutDiscountView;
import com.talabat.talabatcommon.views.banners.DisclaimerBannerView;

public final class CartCustomizationFooterBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView aboutFees;
    @NonNull
    public final ImageView additionalRequestsIcon;
    @NonNull
    public final RelativeLayout binDiscountLayout;
    @NonNull
    public final TalabatTextView binDiscountText;
    @NonNull
    public final TalabatTextView binDiscountValue;
    @NonNull
    public final FrameLayout cartFooterApplyVoucherLayout;
    @NonNull
    public final TalabatTextView couponDiscountTxt;
    @NonNull
    public final TalabatTextView deliveryChargesText;
    @NonNull
    public final TalabatTextView deliveryChargesValue;
    @NonNull
    public final LinearLayout deliveryFeeClickableArea;
    @NonNull
    public final ImageView deliveryFeeTooltipIcon;
    @NonNull
    public final DSTag deliveryFirstOrder;
    @NonNull
    public final TalabatTextView descriptionGoGreen;
    @NonNull
    public final LinearLayout detailsView;
    @NonNull
    public final RelativeLayout dicountVoucherLayout;
    @NonNull
    public final DisclaimerBannerView disclaimerBanner;
    @NonNull
    public final TalabatTextView disconut;
    @NonNull
    public final TextView discountTxt;
    @NonNull
    public final RelativeLayout discountView;
    @NonNull
    public final TextView discountVoucherValue;
    @NonNull
    public final GemCheckoutDiscountView gemCartDiscountView;
    @NonNull
    public final RelativeLayout gemDiscountView;
    @NonNull
    public final LinearLayout gemDiscountViewLayout;
    @NonNull
    public final TalabatTextView gemOfferPrice;
    @NonNull
    public final TalabatTextView gemOfferText;
    @NonNull
    public final TalabatEditText generalRequest;
    @NonNull
    public final RelativeLayout generalRequestDisabledView;
    @NonNull
    public final LinearLayout generalRequestView;
    @NonNull
    public final CheckBox goGreenCheckBox;
    @NonNull
    public final RelativeLayout goGreenContentView;
    @NonNull
    public final RelativeLayout goGreenView;
    @NonNull
    public final ImageView iconNoRequest;
    @NonNull
    public final LinearLayout moreCustomizationView;
    @NonNull
    public final TalabatTextView muncipalityChargesText;
    @NonNull
    public final TalabatTextView muncipalityChargesValue;
    @NonNull
    public final RelativeLayout muncipalityChargesView;
    @NonNull
    public final ImageView noCutleryIcon;
    @NonNull
    public final TalabatTextView noRequestContent;
    @NonNull
    public final TalabatTextView oldDeliveryCharges;
    @NonNull
    public final LinearLayout paymentSummaryView;
    @NonNull
    public final TextView removeVoucher;
    @NonNull
    public final RelativeLayout restaurantDeliveryChargesView;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final ServiceFeeView serviceFeeView;
    @NonNull
    public final SmallOrderFeeView smallOrderFeeView;
    @NonNull
    public final TextView specialRequestTitle;
    @NonNull
    public final TalabatTextView subTotal;
    @NonNull
    public final RelativeLayout subTotalView;
    @NonNull
    public final RelativeLayout talabatDeliveryVoucherDiscountLayout;
    @NonNull
    public final TalabatTextView talabatDeliveryVoucherDiscountValue;
    @NonNull
    public final TalabatTextView talabatTextView2;
    @NonNull
    public final TalabatTextView titleGoGreen;
    @NonNull
    public final TalabatTextView totalAmount;
    @NonNull
    public final RelativeLayout totalView;
    @NonNull
    public final TalabatTextView touristTaxText;
    @NonNull
    public final TalabatTextView touristTaxValue;
    @NonNull
    public final RelativeLayout touristTaxView;

    private CartCustomizationFooterBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView, @NonNull ImageView imageView, @NonNull RelativeLayout relativeLayout, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4, @NonNull FrameLayout frameLayout, @NonNull TalabatTextView talabatTextView5, @NonNull TalabatTextView talabatTextView6, @NonNull TalabatTextView talabatTextView7, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView2, @NonNull DSTag dSTag, @NonNull TalabatTextView talabatTextView8, @NonNull LinearLayout linearLayout3, @NonNull RelativeLayout relativeLayout2, @NonNull DisclaimerBannerView disclaimerBannerView, @NonNull TalabatTextView talabatTextView9, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout3, @NonNull TextView textView2, @NonNull GemCheckoutDiscountView gemCheckoutDiscountView, @NonNull RelativeLayout relativeLayout4, @NonNull LinearLayout linearLayout4, @NonNull TalabatTextView talabatTextView10, @NonNull TalabatTextView talabatTextView11, @NonNull TalabatEditText talabatEditText, @NonNull RelativeLayout relativeLayout5, @NonNull LinearLayout linearLayout5, @NonNull CheckBox checkBox, @NonNull RelativeLayout relativeLayout6, @NonNull RelativeLayout relativeLayout7, @NonNull ImageView imageView3, @NonNull LinearLayout linearLayout6, @NonNull TalabatTextView talabatTextView12, @NonNull TalabatTextView talabatTextView13, @NonNull RelativeLayout relativeLayout8, @NonNull ImageView imageView4, @NonNull TalabatTextView talabatTextView14, @NonNull TalabatTextView talabatTextView15, @NonNull LinearLayout linearLayout7, @NonNull TextView textView3, @NonNull RelativeLayout relativeLayout9, @NonNull ServiceFeeView serviceFeeView2, @NonNull SmallOrderFeeView smallOrderFeeView2, @NonNull TextView textView4, @NonNull TalabatTextView talabatTextView16, @NonNull RelativeLayout relativeLayout10, @NonNull RelativeLayout relativeLayout11, @NonNull TalabatTextView talabatTextView17, @NonNull TalabatTextView talabatTextView18, @NonNull TalabatTextView talabatTextView19, @NonNull TalabatTextView talabatTextView20, @NonNull RelativeLayout relativeLayout12, @NonNull TalabatTextView talabatTextView21, @NonNull TalabatTextView talabatTextView22, @NonNull RelativeLayout relativeLayout13) {
        this.rootView = linearLayout;
        this.aboutFees = talabatTextView;
        this.additionalRequestsIcon = imageView;
        this.binDiscountLayout = relativeLayout;
        this.binDiscountText = talabatTextView3;
        this.binDiscountValue = talabatTextView4;
        this.cartFooterApplyVoucherLayout = frameLayout;
        this.couponDiscountTxt = talabatTextView5;
        this.deliveryChargesText = talabatTextView6;
        this.deliveryChargesValue = talabatTextView7;
        this.deliveryFeeClickableArea = linearLayout2;
        this.deliveryFeeTooltipIcon = imageView2;
        this.deliveryFirstOrder = dSTag;
        this.descriptionGoGreen = talabatTextView8;
        this.detailsView = linearLayout3;
        this.dicountVoucherLayout = relativeLayout2;
        this.disclaimerBanner = disclaimerBannerView;
        this.disconut = talabatTextView9;
        this.discountTxt = textView;
        this.discountView = relativeLayout3;
        this.discountVoucherValue = textView2;
        this.gemCartDiscountView = gemCheckoutDiscountView;
        this.gemDiscountView = relativeLayout4;
        this.gemDiscountViewLayout = linearLayout4;
        this.gemOfferPrice = talabatTextView10;
        this.gemOfferText = talabatTextView11;
        this.generalRequest = talabatEditText;
        this.generalRequestDisabledView = relativeLayout5;
        this.generalRequestView = linearLayout5;
        this.goGreenCheckBox = checkBox;
        this.goGreenContentView = relativeLayout6;
        this.goGreenView = relativeLayout7;
        this.iconNoRequest = imageView3;
        this.moreCustomizationView = linearLayout6;
        this.muncipalityChargesText = talabatTextView12;
        this.muncipalityChargesValue = talabatTextView13;
        this.muncipalityChargesView = relativeLayout8;
        this.noCutleryIcon = imageView4;
        this.noRequestContent = talabatTextView14;
        this.oldDeliveryCharges = talabatTextView15;
        this.paymentSummaryView = linearLayout7;
        this.removeVoucher = textView3;
        this.restaurantDeliveryChargesView = relativeLayout9;
        this.serviceFeeView = serviceFeeView2;
        this.smallOrderFeeView = smallOrderFeeView2;
        this.specialRequestTitle = textView4;
        this.subTotal = talabatTextView16;
        this.subTotalView = relativeLayout10;
        this.talabatDeliveryVoucherDiscountLayout = relativeLayout11;
        this.talabatDeliveryVoucherDiscountValue = talabatTextView17;
        this.talabatTextView2 = talabatTextView18;
        this.titleGoGreen = talabatTextView19;
        this.totalAmount = talabatTextView20;
        this.totalView = relativeLayout12;
        this.touristTaxText = talabatTextView21;
        this.touristTaxValue = talabatTextView22;
        this.touristTaxView = relativeLayout13;
    }

    @NonNull
    public static CartCustomizationFooterBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.about_fees;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.about_fees);
        if (talabatTextView != null) {
            i11 = R.id.additional_requests_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.additional_requests_icon);
            if (imageView != null) {
                i11 = R.id.bin_discount_layout;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.bin_discount_layout);
                if (relativeLayout != null) {
                    i11 = R.id.bin_discount_text;
                    TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.bin_discount_text);
                    if (talabatTextView3 != null) {
                        i11 = R.id.bin_discount_value;
                        TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.bin_discount_value);
                        if (talabatTextView4 != null) {
                            i11 = R.id.cartFooterApplyVoucherLayout;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.cartFooterApplyVoucherLayout);
                            if (frameLayout != null) {
                                i11 = R.id.coupon_discount_txt;
                                TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.coupon_discount_txt);
                                if (talabatTextView5 != null) {
                                    i11 = R.id.delivery_charges_text;
                                    TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.delivery_charges_text);
                                    if (talabatTextView6 != null) {
                                        i11 = R.id.delivery_charges_value;
                                        TalabatTextView talabatTextView7 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.delivery_charges_value);
                                        if (talabatTextView7 != null) {
                                            i11 = R.id.delivery_fee_clickable_area;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.delivery_fee_clickable_area);
                                            if (linearLayout != null) {
                                                i11 = R.id.delivery_fee_tooltip_icon;
                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.delivery_fee_tooltip_icon);
                                                if (imageView2 != null) {
                                                    i11 = R.id.delivery_first_order;
                                                    DSTag dSTag = (DSTag) ViewBindings.findChildViewById(view2, R.id.delivery_first_order);
                                                    if (dSTag != null) {
                                                        i11 = R.id.description_go_green;
                                                        TalabatTextView talabatTextView8 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.description_go_green);
                                                        if (talabatTextView8 != null) {
                                                            LinearLayout linearLayout2 = (LinearLayout) view2;
                                                            i11 = R.id.dicount_voucher_layout;
                                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.dicount_voucher_layout);
                                                            if (relativeLayout2 != null) {
                                                                i11 = R.id.disclaimerBanner;
                                                                DisclaimerBannerView disclaimerBannerView = (DisclaimerBannerView) ViewBindings.findChildViewById(view2, R.id.disclaimerBanner);
                                                                if (disclaimerBannerView != null) {
                                                                    i11 = R.id.disconut;
                                                                    TalabatTextView talabatTextView9 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.disconut);
                                                                    if (talabatTextView9 != null) {
                                                                        i11 = R.id.discount_txt;
                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.discount_txt);
                                                                        if (textView != null) {
                                                                            i11 = R.id.discount_view;
                                                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.discount_view);
                                                                            if (relativeLayout3 != null) {
                                                                                i11 = R.id.discount_voucher_value;
                                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.discount_voucher_value);
                                                                                if (textView2 != null) {
                                                                                    i11 = R.id.gemCartDiscountView;
                                                                                    GemCheckoutDiscountView gemCheckoutDiscountView = (GemCheckoutDiscountView) ViewBindings.findChildViewById(view2, R.id.gemCartDiscountView);
                                                                                    if (gemCheckoutDiscountView != null) {
                                                                                        i11 = R.id.gem_discount_view;
                                                                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.gem_discount_view);
                                                                                        if (relativeLayout4 != null) {
                                                                                            i11 = R.id.gem_discount_view_layout;
                                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.gem_discount_view_layout);
                                                                                            if (linearLayout3 != null) {
                                                                                                i11 = R.id.gem_offer_price;
                                                                                                TalabatTextView talabatTextView10 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.gem_offer_price);
                                                                                                if (talabatTextView10 != null) {
                                                                                                    i11 = R.id.gem_offer_text;
                                                                                                    TalabatTextView talabatTextView11 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.gem_offer_text);
                                                                                                    if (talabatTextView11 != null) {
                                                                                                        i11 = R.id.general_request;
                                                                                                        TalabatEditText talabatEditText = (TalabatEditText) ViewBindings.findChildViewById(view2, R.id.general_request);
                                                                                                        if (talabatEditText != null) {
                                                                                                            i11 = R.id.general_request_disabled_view;
                                                                                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.general_request_disabled_view);
                                                                                                            if (relativeLayout5 != null) {
                                                                                                                i11 = R.id.general_request_view;
                                                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.general_request_view);
                                                                                                                if (linearLayout4 != null) {
                                                                                                                    i11 = R.id.go_green_check_box;
                                                                                                                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view2, R.id.go_green_check_box);
                                                                                                                    if (checkBox != null) {
                                                                                                                        i11 = R.id.go_green_content_view;
                                                                                                                        RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.go_green_content_view);
                                                                                                                        if (relativeLayout6 != null) {
                                                                                                                            i11 = R.id.go_green_view;
                                                                                                                            RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.go_green_view);
                                                                                                                            if (relativeLayout7 != null) {
                                                                                                                                i11 = R.id.icon_no_request;
                                                                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.icon_no_request);
                                                                                                                                if (imageView3 != null) {
                                                                                                                                    i11 = R.id.more_customization_view;
                                                                                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.more_customization_view);
                                                                                                                                    if (linearLayout5 != null) {
                                                                                                                                        i11 = R.id.muncipality_charges_text;
                                                                                                                                        TalabatTextView talabatTextView12 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.muncipality_charges_text);
                                                                                                                                        if (talabatTextView12 != null) {
                                                                                                                                            i11 = R.id.muncipality_charges_value;
                                                                                                                                            TalabatTextView talabatTextView13 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.muncipality_charges_value);
                                                                                                                                            if (talabatTextView13 != null) {
                                                                                                                                                i11 = R.id.muncipality_charges_view;
                                                                                                                                                RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.muncipality_charges_view);
                                                                                                                                                if (relativeLayout8 != null) {
                                                                                                                                                    i11 = R.id.no_cutlery_icon;
                                                                                                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.no_cutlery_icon);
                                                                                                                                                    if (imageView4 != null) {
                                                                                                                                                        i11 = R.id.no_request_content;
                                                                                                                                                        TalabatTextView talabatTextView14 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.no_request_content);
                                                                                                                                                        if (talabatTextView14 != null) {
                                                                                                                                                            i11 = R.id.old_delivery_charges;
                                                                                                                                                            TalabatTextView talabatTextView15 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.old_delivery_charges);
                                                                                                                                                            if (talabatTextView15 != null) {
                                                                                                                                                                i11 = R.id.payment_summary_view;
                                                                                                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.payment_summary_view);
                                                                                                                                                                if (linearLayout6 != null) {
                                                                                                                                                                    i11 = R.id.remove_voucher;
                                                                                                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.remove_voucher);
                                                                                                                                                                    if (textView3 != null) {
                                                                                                                                                                        i11 = R.id.restaurant_delivery_charges_view;
                                                                                                                                                                        RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.restaurant_delivery_charges_view);
                                                                                                                                                                        if (relativeLayout9 != null) {
                                                                                                                                                                            i11 = R.id.service_fee_view;
                                                                                                                                                                            ServiceFeeView serviceFeeView2 = (ServiceFeeView) ViewBindings.findChildViewById(view2, R.id.service_fee_view);
                                                                                                                                                                            if (serviceFeeView2 != null) {
                                                                                                                                                                                i11 = R.id.small_order_fee_view;
                                                                                                                                                                                SmallOrderFeeView smallOrderFeeView2 = (SmallOrderFeeView) ViewBindings.findChildViewById(view2, R.id.small_order_fee_view);
                                                                                                                                                                                if (smallOrderFeeView2 != null) {
                                                                                                                                                                                    i11 = R.id.special_request_title;
                                                                                                                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.special_request_title);
                                                                                                                                                                                    if (textView4 != null) {
                                                                                                                                                                                        i11 = R.id.sub_total;
                                                                                                                                                                                        TalabatTextView talabatTextView16 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.sub_total);
                                                                                                                                                                                        if (talabatTextView16 != null) {
                                                                                                                                                                                            i11 = R.id.sub_total_view;
                                                                                                                                                                                            RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.sub_total_view);
                                                                                                                                                                                            if (relativeLayout10 != null) {
                                                                                                                                                                                                i11 = R.id.talabat_delivery_voucher_discount_layout;
                                                                                                                                                                                                RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.talabat_delivery_voucher_discount_layout);
                                                                                                                                                                                                if (relativeLayout11 != null) {
                                                                                                                                                                                                    i11 = R.id.talabat_delivery_voucher_discount_value;
                                                                                                                                                                                                    TalabatTextView talabatTextView17 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.talabat_delivery_voucher_discount_value);
                                                                                                                                                                                                    if (talabatTextView17 != null) {
                                                                                                                                                                                                        i11 = R.id.talabatTextView2;
                                                                                                                                                                                                        TalabatTextView talabatTextView18 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.talabatTextView2);
                                                                                                                                                                                                        if (talabatTextView18 != null) {
                                                                                                                                                                                                            i11 = R.id.title_go_green;
                                                                                                                                                                                                            TalabatTextView talabatTextView19 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.title_go_green);
                                                                                                                                                                                                            if (talabatTextView19 != null) {
                                                                                                                                                                                                                i11 = R.id.total_amount;
                                                                                                                                                                                                                TalabatTextView talabatTextView20 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.total_amount);
                                                                                                                                                                                                                if (talabatTextView20 != null) {
                                                                                                                                                                                                                    i11 = R.id.total_view;
                                                                                                                                                                                                                    RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.total_view);
                                                                                                                                                                                                                    if (relativeLayout12 != null) {
                                                                                                                                                                                                                        i11 = R.id.tourist_tax_text;
                                                                                                                                                                                                                        TalabatTextView talabatTextView21 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tourist_tax_text);
                                                                                                                                                                                                                        if (talabatTextView21 != null) {
                                                                                                                                                                                                                            i11 = R.id.tourist_tax_value;
                                                                                                                                                                                                                            TalabatTextView talabatTextView22 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tourist_tax_value);
                                                                                                                                                                                                                            if (talabatTextView22 != null) {
                                                                                                                                                                                                                                i11 = R.id.tourist_tax_view;
                                                                                                                                                                                                                                RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.tourist_tax_view);
                                                                                                                                                                                                                                if (relativeLayout13 != null) {
                                                                                                                                                                                                                                    return new CartCustomizationFooterBinding(linearLayout2, talabatTextView, imageView, relativeLayout, talabatTextView3, talabatTextView4, frameLayout, talabatTextView5, talabatTextView6, talabatTextView7, linearLayout, imageView2, dSTag, talabatTextView8, linearLayout2, relativeLayout2, disclaimerBannerView, talabatTextView9, textView, relativeLayout3, textView2, gemCheckoutDiscountView, relativeLayout4, linearLayout3, talabatTextView10, talabatTextView11, talabatEditText, relativeLayout5, linearLayout4, checkBox, relativeLayout6, relativeLayout7, imageView3, linearLayout5, talabatTextView12, talabatTextView13, relativeLayout8, imageView4, talabatTextView14, talabatTextView15, linearLayout6, textView3, relativeLayout9, serviceFeeView2, smallOrderFeeView2, textView4, talabatTextView16, relativeLayout10, relativeLayout11, talabatTextView17, talabatTextView18, talabatTextView19, talabatTextView20, relativeLayout12, talabatTextView21, talabatTextView22, relativeLayout13);
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
    public static CartCustomizationFooterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CartCustomizationFooterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.cart_customization_footer, viewGroup, false);
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
