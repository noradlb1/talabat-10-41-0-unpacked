package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_tag.DSTag;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.designhelpers.expandableLayoutHelpers.ExpandableLinearLayout;
import com.talabat.feature.helpcenter.presentation.CancellationPolicyView;
import com.talabat.feature.tpro.presentation.checkout.SubscriptionAtCheckoutBannerView;
import com.talabat.fees.ServiceFeeView;
import com.talabat.fees.SmallOrderFeeView;
import com.talabat.gem.adapters.presentation.checkout.GemCheckoutDiscountView;
import com.talabat.gem.adapters.presentation.checkout.GemCheckoutFooterView;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.ApplyVouchersView;
import com.visa.checkout.CheckoutButton;

public final class CheckoutScreenBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView aboutFees;
    @NonNull
    public final LinearLayout addressLayoutView;
    @NonNull
    public final RelativeLayout addressViewContainer;
    @NonNull
    public final RelativeLayout addressViewContainerMap;
    @NonNull
    public final TalabatTextView availableCreditValue;
    @NonNull
    public final RelativeLayout availableCreditView;
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    public final ImageView binDiscountIcon;
    @NonNull
    public final RelativeLayout binView;
    @NonNull
    public final TalabatTextView binVoucherText;
    @NonNull
    public final TalabatTextView cashTotal;
    @NonNull
    public final FrameLayout checkoutApplyVoucherViewLayout;
    @NonNull
    public final ApplyVouchersView checkoutApplyVouchersView;
    @NonNull
    public final CardView checkoutDisclamerView;
    @NonNull
    public final RelativeLayout checkoutParent;
    @NonNull
    public final ImageView closeBinView;
    @NonNull
    public final RelativeLayout combinedDiscountLayout;
    @NonNull
    public final TalabatTextView combinedDiscountText;
    @NonNull
    public final TalabatTextView combinedDiscountValue;
    @NonNull
    public final LinearLayout contactlessContents;
    @NonNull
    public final RelativeLayout contactlessFeatureView;
    @NonNull
    public final AppCompatCheckBox contactlessSelector;
    @NonNull
    public final RelativeLayout couponDiscountLayout;
    @NonNull
    public final TalabatTextView couponDiscountValue;
    @NonNull
    public final LinearLayout deli;
    @NonNull
    public final TalabatTextView deliveryAddressTitle;
    @NonNull
    public final CardView deliveryAddressView;
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
    public final RelativeLayout dicountVoucherLayout;
    @NonNull
    public final TalabatTextView disclamerText;
    @NonNull
    public final TextView discountTxt;
    @NonNull
    public final TextView discountVoucherValue;
    @NonNull
    public final ImageView doorIcon;
    @NonNull
    public final CancellationPolicyView dsAlertCancellationPolicyNote;
    @NonNull
    public final ExpandableLinearLayout expandRelativeLayout;
    @NonNull
    public final GemCheckoutDiscountView gemCheckoutDiscountView;
    @NonNull
    public final GemCheckoutFooterView gemCheckoutFooterView;
    @NonNull
    public final RelativeLayout gemDiscountView;
    @NonNull
    public final FrameLayout gemDiscountViewLayout;
    @NonNull
    public final LinearLayout gemFooterLayout;
    @NonNull
    public final RelativeLayout gemFooterView;
    @NonNull
    public final FrameLayout gemFooterViewInnerLayout;
    @NonNull
    public final TalabatTextView gemOfferPrice;
    @NonNull
    public final TalabatTextView gemOfferText;
    @NonNull
    public final TalabatTextView grandTotalValue;
    @NonNull
    public final TalabatTextView knetTotal;
    @NonNull
    public final TalabatTextView muncipalityChargesText;
    @NonNull
    public final TalabatTextView muncipalityChargesValue;
    @NonNull
    public final RelativeLayout muncipalityChargesView;
    @NonNull
    public final TalabatTextView oldDeliveryCharges;
    @NonNull
    public final ImageView orderScreenArrow;
    @NonNull
    public final CardView payByCashView;
    @NonNull
    public final RelativeLayout payByKnetView;
    @NonNull
    public final TalabatTextView payByMethod;
    @NonNull
    public final TalabatTextView payMethod;
    @NonNull
    public final RelativeLayout payRemainingCreditCard;
    @NonNull
    public final TalabatTextView paymentOptionsTitle;
    @NonNull
    public final TalabatTextView paymentSummary;
    @NonNull
    public final TalabatTextView paymentTerms;
    @NonNull
    public final TextView pickupText;
    @NonNull
    public final TalabatFillButton placeorder;
    @NonNull
    public final ViewStub postDateDeliveryViewStub;
    @NonNull
    public final TalabatTextView remainingCreditAmount;
    @NonNull
    public final RelativeLayout remainingTalabatCreditView;
    @NonNull
    public final TextView removeVoucher;
    @NonNull
    public final RelativeLayout restaurantDeliveryChargesView;
    @NonNull
    public final TextView restaurantName;
    @NonNull
    public final TalabatTextView riderTipChargesText;
    @NonNull
    public final RelativeLayout riderTipChargesView;
    @NonNull
    public final FrameLayout riderTipContainer;
    @NonNull
    public final ViewStub riderTipStub;
    @NonNull
    public final NestedScrollView rootScrollView;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final ServiceFeeView serviceFeeView;
    @NonNull
    public final SmallOrderFeeView smallOrderFeeView;
    @NonNull
    public final SubscriptionAtCheckoutBannerView subscriptionAtCheckoutBanner;
    @NonNull
    public final TalabatTextView subtotalValue;
    @NonNull
    public final TalabatTextView talabatCreditBalanceAmount;
    @NonNull
    public final CardView talabatCreditDetailsView;
    @NonNull
    public final TalabatTextView talabatCreditTotal;
    @NonNull
    public final RelativeLayout talabatDeliveryVoucherDiscountLayout;
    @NonNull
    public final TalabatTextView talabatDeliveryVoucherDiscountValue;
    @NonNull
    public final TalabatTextView talabatTextView;
    @NonNull
    public final RelativeLayout talabatToolbar;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;
    @NonNull
    public final TalabatTextView touristTaxText;
    @NonNull
    public final TalabatTextView touristTaxValue;
    @NonNull
    public final RelativeLayout touristTaxView;
    @NonNull
    public final TalabatTextView txtAdditionalDirections;
    @NonNull
    public final TalabatTextView txtAddresMobile;
    @NonNull
    public final TalabatTextView txtAddresPhone;
    @NonNull
    public final TalabatTextView txtAddressAreaname;
    @NonNull
    public final TalabatTextView txtAddressDescription;
    @NonNull
    public final TalabatTextView txtAddressProfileName;
    @NonNull
    public final CheckoutButton visaCheckoutButton;
    @NonNull
    public final LinearLayout visaCheckoutExpandedView;
    @NonNull
    public final TalabatTextView visaCheckoutHint;

    private CheckoutScreenBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatTextView talabatTextView2, @NonNull LinearLayout linearLayout, @NonNull RelativeLayout relativeLayout2, @NonNull RelativeLayout relativeLayout3, @NonNull TalabatTextView talabatTextView3, @NonNull RelativeLayout relativeLayout4, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull ImageView imageView, @NonNull RelativeLayout relativeLayout5, @NonNull TalabatTextView talabatTextView4, @NonNull TalabatTextView talabatTextView5, @NonNull FrameLayout frameLayout, @NonNull ApplyVouchersView applyVouchersView, @NonNull CardView cardView, @NonNull RelativeLayout relativeLayout6, @NonNull ImageView imageView2, @NonNull RelativeLayout relativeLayout7, @NonNull TalabatTextView talabatTextView6, @NonNull TalabatTextView talabatTextView7, @NonNull LinearLayout linearLayout2, @NonNull RelativeLayout relativeLayout8, @NonNull AppCompatCheckBox appCompatCheckBox, @NonNull RelativeLayout relativeLayout9, @NonNull TalabatTextView talabatTextView8, @NonNull LinearLayout linearLayout3, @NonNull TalabatTextView talabatTextView9, @NonNull CardView cardView2, @NonNull TalabatTextView talabatTextView10, @NonNull TalabatTextView talabatTextView11, @NonNull LinearLayout linearLayout4, @NonNull ImageView imageView3, @NonNull DSTag dSTag, @NonNull RelativeLayout relativeLayout10, @NonNull TalabatTextView talabatTextView12, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView4, @NonNull CancellationPolicyView cancellationPolicyView, @NonNull ExpandableLinearLayout expandableLinearLayout, @NonNull GemCheckoutDiscountView gemCheckoutDiscountView2, @NonNull GemCheckoutFooterView gemCheckoutFooterView2, @NonNull RelativeLayout relativeLayout11, @NonNull FrameLayout frameLayout2, @NonNull LinearLayout linearLayout5, @NonNull RelativeLayout relativeLayout12, @NonNull FrameLayout frameLayout3, @NonNull TalabatTextView talabatTextView13, @NonNull TalabatTextView talabatTextView14, @NonNull TalabatTextView talabatTextView15, @NonNull TalabatTextView talabatTextView16, @NonNull TalabatTextView talabatTextView17, @NonNull TalabatTextView talabatTextView18, @NonNull RelativeLayout relativeLayout13, @NonNull TalabatTextView talabatTextView19, @NonNull ImageView imageView5, @NonNull CardView cardView3, @NonNull RelativeLayout relativeLayout14, @NonNull TalabatTextView talabatTextView20, @NonNull TalabatTextView talabatTextView21, @NonNull RelativeLayout relativeLayout15, @NonNull TalabatTextView talabatTextView22, @NonNull TalabatTextView talabatTextView23, @NonNull TalabatTextView talabatTextView24, @NonNull TextView textView3, @NonNull TalabatFillButton talabatFillButton, @NonNull ViewStub viewStub, @NonNull TalabatTextView talabatTextView25, @NonNull RelativeLayout relativeLayout16, @NonNull TextView textView4, @NonNull RelativeLayout relativeLayout17, @NonNull TextView textView5, @NonNull TalabatTextView talabatTextView26, @NonNull RelativeLayout relativeLayout18, @NonNull FrameLayout frameLayout4, @NonNull ViewStub viewStub2, @NonNull NestedScrollView nestedScrollView, @NonNull ServiceFeeView serviceFeeView2, @NonNull SmallOrderFeeView smallOrderFeeView2, @NonNull SubscriptionAtCheckoutBannerView subscriptionAtCheckoutBannerView, @NonNull TalabatTextView talabatTextView27, @NonNull TalabatTextView talabatTextView28, @NonNull CardView cardView4, @NonNull TalabatTextView talabatTextView29, @NonNull RelativeLayout relativeLayout19, @NonNull TalabatTextView talabatTextView30, @NonNull TalabatTextView talabatTextView31, @NonNull RelativeLayout relativeLayout20, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar, @NonNull TalabatTextView talabatTextView32, @NonNull TalabatTextView talabatTextView33, @NonNull RelativeLayout relativeLayout21, @NonNull TalabatTextView talabatTextView34, @NonNull TalabatTextView talabatTextView35, @NonNull TalabatTextView talabatTextView36, @NonNull TalabatTextView talabatTextView37, @NonNull TalabatTextView talabatTextView38, @NonNull TalabatTextView talabatTextView39, @NonNull CheckoutButton checkoutButton, @NonNull LinearLayout linearLayout6, @NonNull TalabatTextView talabatTextView40) {
        this.rootView = relativeLayout;
        this.aboutFees = talabatTextView2;
        this.addressLayoutView = linearLayout;
        this.addressViewContainer = relativeLayout2;
        this.addressViewContainerMap = relativeLayout3;
        this.availableCreditValue = talabatTextView3;
        this.availableCreditView = relativeLayout4;
        this.back = talabatToolBarImageButton;
        this.binDiscountIcon = imageView;
        this.binView = relativeLayout5;
        this.binVoucherText = talabatTextView4;
        this.cashTotal = talabatTextView5;
        this.checkoutApplyVoucherViewLayout = frameLayout;
        this.checkoutApplyVouchersView = applyVouchersView;
        this.checkoutDisclamerView = cardView;
        this.checkoutParent = relativeLayout6;
        this.closeBinView = imageView2;
        this.combinedDiscountLayout = relativeLayout7;
        this.combinedDiscountText = talabatTextView6;
        this.combinedDiscountValue = talabatTextView7;
        this.contactlessContents = linearLayout2;
        this.contactlessFeatureView = relativeLayout8;
        this.contactlessSelector = appCompatCheckBox;
        this.couponDiscountLayout = relativeLayout9;
        this.couponDiscountValue = talabatTextView8;
        this.deli = linearLayout3;
        this.deliveryAddressTitle = talabatTextView9;
        this.deliveryAddressView = cardView2;
        this.deliveryChargesText = talabatTextView10;
        this.deliveryChargesValue = talabatTextView11;
        this.deliveryFeeClickableArea = linearLayout4;
        this.deliveryFeeTooltipIcon = imageView3;
        this.deliveryFirstOrder = dSTag;
        this.dicountVoucherLayout = relativeLayout10;
        this.disclamerText = talabatTextView12;
        this.discountTxt = textView;
        this.discountVoucherValue = textView2;
        this.doorIcon = imageView4;
        this.dsAlertCancellationPolicyNote = cancellationPolicyView;
        this.expandRelativeLayout = expandableLinearLayout;
        this.gemCheckoutDiscountView = gemCheckoutDiscountView2;
        this.gemCheckoutFooterView = gemCheckoutFooterView2;
        this.gemDiscountView = relativeLayout11;
        this.gemDiscountViewLayout = frameLayout2;
        this.gemFooterLayout = linearLayout5;
        this.gemFooterView = relativeLayout12;
        this.gemFooterViewInnerLayout = frameLayout3;
        this.gemOfferPrice = talabatTextView13;
        this.gemOfferText = talabatTextView14;
        this.grandTotalValue = talabatTextView15;
        this.knetTotal = talabatTextView16;
        this.muncipalityChargesText = talabatTextView17;
        this.muncipalityChargesValue = talabatTextView18;
        this.muncipalityChargesView = relativeLayout13;
        this.oldDeliveryCharges = talabatTextView19;
        this.orderScreenArrow = imageView5;
        this.payByCashView = cardView3;
        this.payByKnetView = relativeLayout14;
        this.payByMethod = talabatTextView20;
        this.payMethod = talabatTextView21;
        this.payRemainingCreditCard = relativeLayout15;
        this.paymentOptionsTitle = talabatTextView22;
        this.paymentSummary = talabatTextView23;
        this.paymentTerms = talabatTextView24;
        this.pickupText = textView3;
        this.placeorder = talabatFillButton;
        this.postDateDeliveryViewStub = viewStub;
        this.remainingCreditAmount = talabatTextView25;
        this.remainingTalabatCreditView = relativeLayout16;
        this.removeVoucher = textView4;
        this.restaurantDeliveryChargesView = relativeLayout17;
        this.restaurantName = textView5;
        this.riderTipChargesText = talabatTextView26;
        this.riderTipChargesView = relativeLayout18;
        this.riderTipContainer = frameLayout4;
        this.riderTipStub = viewStub2;
        this.rootScrollView = nestedScrollView;
        this.serviceFeeView = serviceFeeView2;
        this.smallOrderFeeView = smallOrderFeeView2;
        this.subscriptionAtCheckoutBanner = subscriptionAtCheckoutBannerView;
        this.subtotalValue = talabatTextView27;
        this.talabatCreditBalanceAmount = talabatTextView28;
        this.talabatCreditDetailsView = cardView4;
        this.talabatCreditTotal = talabatTextView29;
        this.talabatDeliveryVoucherDiscountLayout = relativeLayout19;
        this.talabatDeliveryVoucherDiscountValue = talabatTextView30;
        this.talabatTextView = talabatTextView31;
        this.talabatToolbar = relativeLayout20;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
        this.touristTaxText = talabatTextView32;
        this.touristTaxValue = talabatTextView33;
        this.touristTaxView = relativeLayout21;
        this.txtAdditionalDirections = talabatTextView34;
        this.txtAddresMobile = talabatTextView35;
        this.txtAddresPhone = talabatTextView36;
        this.txtAddressAreaname = talabatTextView37;
        this.txtAddressDescription = talabatTextView38;
        this.txtAddressProfileName = talabatTextView39;
        this.visaCheckoutButton = checkoutButton;
        this.visaCheckoutExpandedView = linearLayout6;
        this.visaCheckoutHint = talabatTextView40;
    }

    @NonNull
    public static CheckoutScreenBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.about_fees;
        TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.about_fees);
        if (talabatTextView2 != null) {
            i11 = R.id.address_layout_view;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.address_layout_view);
            if (linearLayout != null) {
                i11 = R.id.address_view_container;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.address_view_container);
                if (relativeLayout != null) {
                    i11 = R.id.address_view_container_map;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.address_view_container_map);
                    if (relativeLayout2 != null) {
                        i11 = R.id.available_credit_value;
                        TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.available_credit_value);
                        if (talabatTextView3 != null) {
                            i11 = R.id.available_credit_view;
                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.available_credit_view);
                            if (relativeLayout3 != null) {
                                i11 = R.id.back;
                                TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.back);
                                if (talabatToolBarImageButton != null) {
                                    i11 = R.id.bin_discount_icon;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.bin_discount_icon);
                                    if (imageView != null) {
                                        i11 = R.id.bin_view;
                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.bin_view);
                                        if (relativeLayout4 != null) {
                                            i11 = R.id.bin_voucher_text;
                                            TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.bin_voucher_text);
                                            if (talabatTextView4 != null) {
                                                i11 = R.id.cash_total;
                                                TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.cash_total);
                                                if (talabatTextView5 != null) {
                                                    i11 = R.id.checkoutApplyVoucherViewLayout;
                                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.checkoutApplyVoucherViewLayout);
                                                    if (frameLayout != null) {
                                                        i11 = R.id.checkoutApplyVouchersView;
                                                        ApplyVouchersView applyVouchersView = (ApplyVouchersView) ViewBindings.findChildViewById(view2, R.id.checkoutApplyVouchersView);
                                                        if (applyVouchersView != null) {
                                                            i11 = R.id.checkout_disclamer_view;
                                                            CardView cardView = (CardView) ViewBindings.findChildViewById(view2, R.id.checkout_disclamer_view);
                                                            if (cardView != null) {
                                                                RelativeLayout relativeLayout5 = (RelativeLayout) view2;
                                                                i11 = R.id.close_bin_view;
                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.close_bin_view);
                                                                if (imageView2 != null) {
                                                                    i11 = R.id.combined_discount_layout;
                                                                    RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.combined_discount_layout);
                                                                    if (relativeLayout6 != null) {
                                                                        i11 = R.id.combined_discount_text;
                                                                        TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.combined_discount_text);
                                                                        if (talabatTextView6 != null) {
                                                                            i11 = R.id.combined_discount_value;
                                                                            TalabatTextView talabatTextView7 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.combined_discount_value);
                                                                            if (talabatTextView7 != null) {
                                                                                i11 = R.id.contactless_contents;
                                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.contactless_contents);
                                                                                if (linearLayout2 != null) {
                                                                                    i11 = R.id.contactless_feature_view;
                                                                                    RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.contactless_feature_view);
                                                                                    if (relativeLayout7 != null) {
                                                                                        i11 = R.id.contactless_selector;
                                                                                        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.findChildViewById(view2, R.id.contactless_selector);
                                                                                        if (appCompatCheckBox != null) {
                                                                                            i11 = R.id.coupon_discount_layout;
                                                                                            RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.coupon_discount_layout);
                                                                                            if (relativeLayout8 != null) {
                                                                                                i11 = R.id.coupon_discount_value;
                                                                                                TalabatTextView talabatTextView8 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.coupon_discount_value);
                                                                                                if (talabatTextView8 != null) {
                                                                                                    i11 = R.id.deli;
                                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.deli);
                                                                                                    if (linearLayout3 != null) {
                                                                                                        i11 = R.id.delivery_address_title;
                                                                                                        TalabatTextView talabatTextView9 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.delivery_address_title);
                                                                                                        if (talabatTextView9 != null) {
                                                                                                            i11 = R.id.delivery_address_view;
                                                                                                            CardView cardView2 = (CardView) ViewBindings.findChildViewById(view2, R.id.delivery_address_view);
                                                                                                            if (cardView2 != null) {
                                                                                                                i11 = R.id.delivery_charges_text;
                                                                                                                TalabatTextView talabatTextView10 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.delivery_charges_text);
                                                                                                                if (talabatTextView10 != null) {
                                                                                                                    i11 = R.id.delivery_charges_value;
                                                                                                                    TalabatTextView talabatTextView11 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.delivery_charges_value);
                                                                                                                    if (talabatTextView11 != null) {
                                                                                                                        i11 = R.id.delivery_fee_clickable_area;
                                                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.delivery_fee_clickable_area);
                                                                                                                        if (linearLayout4 != null) {
                                                                                                                            i11 = R.id.delivery_fee_tooltip_icon;
                                                                                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.delivery_fee_tooltip_icon);
                                                                                                                            if (imageView3 != null) {
                                                                                                                                i11 = R.id.delivery_first_order;
                                                                                                                                DSTag dSTag = (DSTag) ViewBindings.findChildViewById(view2, R.id.delivery_first_order);
                                                                                                                                if (dSTag != null) {
                                                                                                                                    i11 = R.id.dicount_voucher_layout;
                                                                                                                                    RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.dicount_voucher_layout);
                                                                                                                                    if (relativeLayout9 != null) {
                                                                                                                                        i11 = R.id.disclamer_text;
                                                                                                                                        TalabatTextView talabatTextView12 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.disclamer_text);
                                                                                                                                        if (talabatTextView12 != null) {
                                                                                                                                            i11 = R.id.discount_txt;
                                                                                                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.discount_txt);
                                                                                                                                            if (textView != null) {
                                                                                                                                                i11 = R.id.discount_voucher_value;
                                                                                                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.discount_voucher_value);
                                                                                                                                                if (textView2 != null) {
                                                                                                                                                    i11 = R.id.door_icon;
                                                                                                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.door_icon);
                                                                                                                                                    if (imageView4 != null) {
                                                                                                                                                        i11 = R.id.dsAlertCancellationPolicyNote;
                                                                                                                                                        CancellationPolicyView cancellationPolicyView = (CancellationPolicyView) ViewBindings.findChildViewById(view2, R.id.dsAlertCancellationPolicyNote);
                                                                                                                                                        if (cancellationPolicyView != null) {
                                                                                                                                                            i11 = R.id.expand_relative_layout;
                                                                                                                                                            ExpandableLinearLayout expandableLinearLayout = (ExpandableLinearLayout) ViewBindings.findChildViewById(view2, R.id.expand_relative_layout);
                                                                                                                                                            if (expandableLinearLayout != null) {
                                                                                                                                                                i11 = R.id.gemCheckoutDiscountView;
                                                                                                                                                                GemCheckoutDiscountView gemCheckoutDiscountView2 = (GemCheckoutDiscountView) ViewBindings.findChildViewById(view2, R.id.gemCheckoutDiscountView);
                                                                                                                                                                if (gemCheckoutDiscountView2 != null) {
                                                                                                                                                                    i11 = R.id.gemCheckoutFooterView;
                                                                                                                                                                    GemCheckoutFooterView gemCheckoutFooterView2 = (GemCheckoutFooterView) ViewBindings.findChildViewById(view2, R.id.gemCheckoutFooterView);
                                                                                                                                                                    if (gemCheckoutFooterView2 != null) {
                                                                                                                                                                        i11 = R.id.gem_discount_view;
                                                                                                                                                                        RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.gem_discount_view);
                                                                                                                                                                        if (relativeLayout10 != null) {
                                                                                                                                                                            i11 = R.id.gem_discount_view_layout;
                                                                                                                                                                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.gem_discount_view_layout);
                                                                                                                                                                            if (frameLayout2 != null) {
                                                                                                                                                                                i11 = R.id.gem_footer_layout;
                                                                                                                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.gem_footer_layout);
                                                                                                                                                                                if (linearLayout5 != null) {
                                                                                                                                                                                    i11 = R.id.gem_footer_view;
                                                                                                                                                                                    RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.gem_footer_view);
                                                                                                                                                                                    if (relativeLayout11 != null) {
                                                                                                                                                                                        i11 = R.id.gem_footer_view_inner_layout;
                                                                                                                                                                                        FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.gem_footer_view_inner_layout);
                                                                                                                                                                                        if (frameLayout3 != null) {
                                                                                                                                                                                            i11 = R.id.gem_offer_price;
                                                                                                                                                                                            TalabatTextView talabatTextView13 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.gem_offer_price);
                                                                                                                                                                                            if (talabatTextView13 != null) {
                                                                                                                                                                                                i11 = R.id.gem_offer_text;
                                                                                                                                                                                                TalabatTextView talabatTextView14 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.gem_offer_text);
                                                                                                                                                                                                if (talabatTextView14 != null) {
                                                                                                                                                                                                    i11 = R.id.grand_total_value;
                                                                                                                                                                                                    TalabatTextView talabatTextView15 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.grand_total_value);
                                                                                                                                                                                                    if (talabatTextView15 != null) {
                                                                                                                                                                                                        i11 = R.id.knet_total;
                                                                                                                                                                                                        TalabatTextView talabatTextView16 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.knet_total);
                                                                                                                                                                                                        if (talabatTextView16 != null) {
                                                                                                                                                                                                            i11 = R.id.muncipality_charges_text;
                                                                                                                                                                                                            TalabatTextView talabatTextView17 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.muncipality_charges_text);
                                                                                                                                                                                                            if (talabatTextView17 != null) {
                                                                                                                                                                                                                i11 = R.id.muncipality_charges_value;
                                                                                                                                                                                                                TalabatTextView talabatTextView18 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.muncipality_charges_value);
                                                                                                                                                                                                                if (talabatTextView18 != null) {
                                                                                                                                                                                                                    i11 = R.id.muncipality_charges_view;
                                                                                                                                                                                                                    RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.muncipality_charges_view);
                                                                                                                                                                                                                    if (relativeLayout12 != null) {
                                                                                                                                                                                                                        i11 = R.id.old_delivery_charges;
                                                                                                                                                                                                                        TalabatTextView talabatTextView19 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.old_delivery_charges);
                                                                                                                                                                                                                        if (talabatTextView19 != null) {
                                                                                                                                                                                                                            i11 = R.id.order_screen_arrow;
                                                                                                                                                                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, R.id.order_screen_arrow);
                                                                                                                                                                                                                            if (imageView5 != null) {
                                                                                                                                                                                                                                i11 = R.id.pay_by_cash_view;
                                                                                                                                                                                                                                CardView cardView3 = (CardView) ViewBindings.findChildViewById(view2, R.id.pay_by_cash_view);
                                                                                                                                                                                                                                if (cardView3 != null) {
                                                                                                                                                                                                                                    i11 = R.id.pay_by_knet_view;
                                                                                                                                                                                                                                    RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.pay_by_knet_view);
                                                                                                                                                                                                                                    if (relativeLayout13 != null) {
                                                                                                                                                                                                                                        i11 = R.id.pay_by_method;
                                                                                                                                                                                                                                        TalabatTextView talabatTextView20 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.pay_by_method);
                                                                                                                                                                                                                                        if (talabatTextView20 != null) {
                                                                                                                                                                                                                                            i11 = R.id.pay_method;
                                                                                                                                                                                                                                            TalabatTextView talabatTextView21 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.pay_method);
                                                                                                                                                                                                                                            if (talabatTextView21 != null) {
                                                                                                                                                                                                                                                i11 = R.id.pay_remaining_credit_card;
                                                                                                                                                                                                                                                RelativeLayout relativeLayout14 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.pay_remaining_credit_card);
                                                                                                                                                                                                                                                if (relativeLayout14 != null) {
                                                                                                                                                                                                                                                    i11 = R.id.payment_options_title;
                                                                                                                                                                                                                                                    TalabatTextView talabatTextView22 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.payment_options_title);
                                                                                                                                                                                                                                                    if (talabatTextView22 != null) {
                                                                                                                                                                                                                                                        i11 = R.id.payment_summary;
                                                                                                                                                                                                                                                        TalabatTextView talabatTextView23 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.payment_summary);
                                                                                                                                                                                                                                                        if (talabatTextView23 != null) {
                                                                                                                                                                                                                                                            i11 = R.id.payment_terms;
                                                                                                                                                                                                                                                            TalabatTextView talabatTextView24 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.payment_terms);
                                                                                                                                                                                                                                                            if (talabatTextView24 != null) {
                                                                                                                                                                                                                                                                i11 = R.id.pickupText;
                                                                                                                                                                                                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.pickupText);
                                                                                                                                                                                                                                                                if (textView3 != null) {
                                                                                                                                                                                                                                                                    i11 = R.id.placeorder;
                                                                                                                                                                                                                                                                    TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.placeorder);
                                                                                                                                                                                                                                                                    if (talabatFillButton != null) {
                                                                                                                                                                                                                                                                        i11 = R.id.post_dateDelivery_view_stub;
                                                                                                                                                                                                                                                                        ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view2, R.id.post_dateDelivery_view_stub);
                                                                                                                                                                                                                                                                        if (viewStub != null) {
                                                                                                                                                                                                                                                                            i11 = R.id.remaining_credit_amount;
                                                                                                                                                                                                                                                                            TalabatTextView talabatTextView25 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.remaining_credit_amount);
                                                                                                                                                                                                                                                                            if (talabatTextView25 != null) {
                                                                                                                                                                                                                                                                                i11 = R.id.remaining_talabat_credit_view;
                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout15 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.remaining_talabat_credit_view);
                                                                                                                                                                                                                                                                                if (relativeLayout15 != null) {
                                                                                                                                                                                                                                                                                    i11 = R.id.remove_voucher;
                                                                                                                                                                                                                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.remove_voucher);
                                                                                                                                                                                                                                                                                    if (textView4 != null) {
                                                                                                                                                                                                                                                                                        i11 = R.id.restaurant_delivery_charges_view;
                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout16 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.restaurant_delivery_charges_view);
                                                                                                                                                                                                                                                                                        if (relativeLayout16 != null) {
                                                                                                                                                                                                                                                                                            i11 = R.id.restaurantName;
                                                                                                                                                                                                                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.restaurantName);
                                                                                                                                                                                                                                                                                            if (textView5 != null) {
                                                                                                                                                                                                                                                                                                i11 = R.id.rider_tip_charges_text;
                                                                                                                                                                                                                                                                                                TalabatTextView talabatTextView26 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.rider_tip_charges_text);
                                                                                                                                                                                                                                                                                                if (talabatTextView26 != null) {
                                                                                                                                                                                                                                                                                                    i11 = R.id.rider_tip_charges_view;
                                                                                                                                                                                                                                                                                                    RelativeLayout relativeLayout17 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rider_tip_charges_view);
                                                                                                                                                                                                                                                                                                    if (relativeLayout17 != null) {
                                                                                                                                                                                                                                                                                                        i11 = R.id.rider_tip_container;
                                                                                                                                                                                                                                                                                                        FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.rider_tip_container);
                                                                                                                                                                                                                                                                                                        if (frameLayout4 != null) {
                                                                                                                                                                                                                                                                                                            i11 = R.id.rider_tip_stub;
                                                                                                                                                                                                                                                                                                            ViewStub viewStub2 = (ViewStub) ViewBindings.findChildViewById(view2, R.id.rider_tip_stub);
                                                                                                                                                                                                                                                                                                            if (viewStub2 != null) {
                                                                                                                                                                                                                                                                                                                i11 = R.id.root_scroll_view;
                                                                                                                                                                                                                                                                                                                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view2, R.id.root_scroll_view);
                                                                                                                                                                                                                                                                                                                if (nestedScrollView != null) {
                                                                                                                                                                                                                                                                                                                    i11 = R.id.service_fee_view;
                                                                                                                                                                                                                                                                                                                    ServiceFeeView serviceFeeView2 = (ServiceFeeView) ViewBindings.findChildViewById(view2, R.id.service_fee_view);
                                                                                                                                                                                                                                                                                                                    if (serviceFeeView2 != null) {
                                                                                                                                                                                                                                                                                                                        i11 = R.id.small_order_fee_view;
                                                                                                                                                                                                                                                                                                                        SmallOrderFeeView smallOrderFeeView2 = (SmallOrderFeeView) ViewBindings.findChildViewById(view2, R.id.small_order_fee_view);
                                                                                                                                                                                                                                                                                                                        if (smallOrderFeeView2 != null) {
                                                                                                                                                                                                                                                                                                                            i11 = R.id.subscription_at_checkout_banner;
                                                                                                                                                                                                                                                                                                                            SubscriptionAtCheckoutBannerView subscriptionAtCheckoutBannerView = (SubscriptionAtCheckoutBannerView) ViewBindings.findChildViewById(view2, R.id.subscription_at_checkout_banner);
                                                                                                                                                                                                                                                                                                                            if (subscriptionAtCheckoutBannerView != null) {
                                                                                                                                                                                                                                                                                                                                i11 = R.id.subtotal_value;
                                                                                                                                                                                                                                                                                                                                TalabatTextView talabatTextView27 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.subtotal_value);
                                                                                                                                                                                                                                                                                                                                if (talabatTextView27 != null) {
                                                                                                                                                                                                                                                                                                                                    i11 = R.id.talabat_credit_balance_amount;
                                                                                                                                                                                                                                                                                                                                    TalabatTextView talabatTextView28 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.talabat_credit_balance_amount);
                                                                                                                                                                                                                                                                                                                                    if (talabatTextView28 != null) {
                                                                                                                                                                                                                                                                                                                                        i11 = R.id.talabat_credit_details_view;
                                                                                                                                                                                                                                                                                                                                        CardView cardView4 = (CardView) ViewBindings.findChildViewById(view2, R.id.talabat_credit_details_view);
                                                                                                                                                                                                                                                                                                                                        if (cardView4 != null) {
                                                                                                                                                                                                                                                                                                                                            i11 = R.id.talabat_credit_total;
                                                                                                                                                                                                                                                                                                                                            TalabatTextView talabatTextView29 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.talabat_credit_total);
                                                                                                                                                                                                                                                                                                                                            if (talabatTextView29 != null) {
                                                                                                                                                                                                                                                                                                                                                i11 = R.id.talabat_delivery_voucher_discount_layout;
                                                                                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout18 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.talabat_delivery_voucher_discount_layout);
                                                                                                                                                                                                                                                                                                                                                if (relativeLayout18 != null) {
                                                                                                                                                                                                                                                                                                                                                    i11 = R.id.talabat_delivery_voucher_discount_value;
                                                                                                                                                                                                                                                                                                                                                    TalabatTextView talabatTextView30 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.talabat_delivery_voucher_discount_value);
                                                                                                                                                                                                                                                                                                                                                    if (talabatTextView30 != null) {
                                                                                                                                                                                                                                                                                                                                                        i11 = R.id.talabatTextView;
                                                                                                                                                                                                                                                                                                                                                        TalabatTextView talabatTextView31 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.talabatTextView);
                                                                                                                                                                                                                                                                                                                                                        if (talabatTextView31 != null) {
                                                                                                                                                                                                                                                                                                                                                            i11 = R.id.talabat_toolbar;
                                                                                                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout19 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.talabat_toolbar);
                                                                                                                                                                                                                                                                                                                                                            if (relativeLayout19 != null) {
                                                                                                                                                                                                                                                                                                                                                                i11 = R.id.title;
                                                                                                                                                                                                                                                                                                                                                                TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                                                                                                                                                                                                                                                                                                                                if (talabatToolBarTextView != null) {
                                                                                                                                                                                                                                                                                                                                                                    i11 = R.id.toolbar;
                                                                                                                                                                                                                                                                                                                                                                    TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                                                                                                                                                                                                                                                                                                                    if (talabatToolBar != null) {
                                                                                                                                                                                                                                                                                                                                                                        i11 = R.id.tourist_tax_text;
                                                                                                                                                                                                                                                                                                                                                                        TalabatTextView talabatTextView32 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tourist_tax_text);
                                                                                                                                                                                                                                                                                                                                                                        if (talabatTextView32 != null) {
                                                                                                                                                                                                                                                                                                                                                                            i11 = R.id.tourist_tax_value;
                                                                                                                                                                                                                                                                                                                                                                            TalabatTextView talabatTextView33 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tourist_tax_value);
                                                                                                                                                                                                                                                                                                                                                                            if (talabatTextView33 != null) {
                                                                                                                                                                                                                                                                                                                                                                                i11 = R.id.tourist_tax_view;
                                                                                                                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout20 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.tourist_tax_view);
                                                                                                                                                                                                                                                                                                                                                                                if (relativeLayout20 != null) {
                                                                                                                                                                                                                                                                                                                                                                                    i11 = R.id.txtAdditionalDirections;
                                                                                                                                                                                                                                                                                                                                                                                    TalabatTextView talabatTextView34 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txtAdditionalDirections);
                                                                                                                                                                                                                                                                                                                                                                                    if (talabatTextView34 != null) {
                                                                                                                                                                                                                                                                                                                                                                                        i11 = R.id.txtAddresMobile;
                                                                                                                                                                                                                                                                                                                                                                                        TalabatTextView talabatTextView35 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txtAddresMobile);
                                                                                                                                                                                                                                                                                                                                                                                        if (talabatTextView35 != null) {
                                                                                                                                                                                                                                                                                                                                                                                            i11 = R.id.txtAddresPhone;
                                                                                                                                                                                                                                                                                                                                                                                            TalabatTextView talabatTextView36 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txtAddresPhone);
                                                                                                                                                                                                                                                                                                                                                                                            if (talabatTextView36 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                i11 = R.id.txtAddressAreaname;
                                                                                                                                                                                                                                                                                                                                                                                                TalabatTextView talabatTextView37 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txtAddressAreaname);
                                                                                                                                                                                                                                                                                                                                                                                                if (talabatTextView37 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                    i11 = R.id.txtAddressDescription;
                                                                                                                                                                                                                                                                                                                                                                                                    TalabatTextView talabatTextView38 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txtAddressDescription);
                                                                                                                                                                                                                                                                                                                                                                                                    if (talabatTextView38 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                        i11 = R.id.txtAddressProfileName;
                                                                                                                                                                                                                                                                                                                                                                                                        TalabatTextView talabatTextView39 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txtAddressProfileName);
                                                                                                                                                                                                                                                                                                                                                                                                        if (talabatTextView39 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                            i11 = R.id.visa_checkout_button;
                                                                                                                                                                                                                                                                                                                                                                                                            CheckoutButton checkoutButton = (CheckoutButton) ViewBindings.findChildViewById(view2, R.id.visa_checkout_button);
                                                                                                                                                                                                                                                                                                                                                                                                            if (checkoutButton != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                i11 = R.id.visa_checkout_expanded_view;
                                                                                                                                                                                                                                                                                                                                                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.visa_checkout_expanded_view);
                                                                                                                                                                                                                                                                                                                                                                                                                if (linearLayout6 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                    i11 = R.id.visa_checkout_hint;
                                                                                                                                                                                                                                                                                                                                                                                                                    TalabatTextView talabatTextView40 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.visa_checkout_hint);
                                                                                                                                                                                                                                                                                                                                                                                                                    if (talabatTextView40 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                        return new CheckoutScreenBinding(relativeLayout5, talabatTextView2, linearLayout, relativeLayout, relativeLayout2, talabatTextView3, relativeLayout3, talabatToolBarImageButton, imageView, relativeLayout4, talabatTextView4, talabatTextView5, frameLayout, applyVouchersView, cardView, relativeLayout5, imageView2, relativeLayout6, talabatTextView6, talabatTextView7, linearLayout2, relativeLayout7, appCompatCheckBox, relativeLayout8, talabatTextView8, linearLayout3, talabatTextView9, cardView2, talabatTextView10, talabatTextView11, linearLayout4, imageView3, dSTag, relativeLayout9, talabatTextView12, textView, textView2, imageView4, cancellationPolicyView, expandableLinearLayout, gemCheckoutDiscountView2, gemCheckoutFooterView2, relativeLayout10, frameLayout2, linearLayout5, relativeLayout11, frameLayout3, talabatTextView13, talabatTextView14, talabatTextView15, talabatTextView16, talabatTextView17, talabatTextView18, relativeLayout12, talabatTextView19, imageView5, cardView3, relativeLayout13, talabatTextView20, talabatTextView21, relativeLayout14, talabatTextView22, talabatTextView23, talabatTextView24, textView3, talabatFillButton, viewStub, talabatTextView25, relativeLayout15, textView4, relativeLayout16, textView5, talabatTextView26, relativeLayout17, frameLayout4, viewStub2, nestedScrollView, serviceFeeView2, smallOrderFeeView2, subscriptionAtCheckoutBannerView, talabatTextView27, talabatTextView28, cardView4, talabatTextView29, relativeLayout18, talabatTextView30, talabatTextView31, relativeLayout19, talabatToolBarTextView, talabatToolBar, talabatTextView32, talabatTextView33, relativeLayout20, talabatTextView34, talabatTextView35, talabatTextView36, talabatTextView37, talabatTextView38, talabatTextView39, checkoutButton, linearLayout6, talabatTextView40);
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
    public static CheckoutScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CheckoutScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.checkout_screen, viewGroup, false);
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
