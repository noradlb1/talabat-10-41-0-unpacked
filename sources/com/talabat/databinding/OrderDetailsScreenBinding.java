package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.volley.toolbox.NetworkImageView;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarTextView;

public final class OrderDetailsScreenBinding implements ViewBinding {
    @NonNull
    public final CardView addressContainer;
    @NonNull
    public final LinearLayout addressLayoutView;
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    public final TalabatButton btnLogin;
    @NonNull
    public final LinearLayout couponDiscountPriceLabel;
    @NonNull
    public final TalabatTextView couponDiscountTitleTv;
    @NonNull
    public final ImageView deliverCurrentLocationImg;
    @NonNull
    public final TalabatTextView deliveryAddressTitle;
    @NonNull
    public final RelativeLayout deliveryTimeContainer;
    @NonNull
    public final TalabatTextView deliveryTimeTitleTv;
    @NonNull
    public final TalabatTextView generalRequestText;
    @NonNull
    public final LinearLayout generalRequestView;
    @NonNull
    public final TalabatTextView grandTotalTitleTv;
    @NonNull
    public final RecyclerView itemsRecyclerView;
    @NonNull
    public final TalabatTextView muncipalityTaxAlt;
    @NonNull
    public final RelativeLayout muncipalityTaxView;
    @NonNull
    public final TalabatTextView orderDetailsCouponCurrency;
    @NonNull
    public final TalabatTextView orderDetailsCouponDiscount;
    @NonNull
    public final RelativeLayout orderDetailsCouponView;
    @NonNull
    public final RelativeLayout orderDetailsDeliveryChargesView;
    @NonNull
    public final TalabatTextView orderDetailsDeliveryTime;
    @NonNull
    public final RelativeLayout orderDetailsGemSavingView;
    @NonNull
    public final TalabatTextView orderDetailsGemSavingViewAmountTxt;
    @NonNull
    public final TalabatTextView orderDetailsGemSavingViewCurrencyTxt;
    @NonNull
    public final TalabatTextView orderDetailsGemSavingViewTxt;
    @NonNull
    public final ProgressBar orderDetailsLoadingIndicator;
    @NonNull
    public final RelativeLayout orderDetailsLogoView;
    @NonNull
    public final TalabatTextView orderDetailsMuncipalityTax;
    @NonNull
    public final TalabatTextView orderDetailsMuncipalityTaxCurrency;
    @NonNull
    public final TalabatTextView orderDetailsOrderId;
    @NonNull
    public final TalabatTextView orderDetailsRestDelCharges;
    @NonNull
    public final TalabatTextView orderDetailsRestDelChargesCurrency;
    @NonNull
    public final TalabatTextView orderDetailsRestaurantName;
    @NonNull
    public final TalabatTextView orderDetailsStatus;
    @NonNull
    public final TalabatTextView orderDetailsSubTotal;
    @NonNull
    public final TalabatTextView orderDetailsTotal;
    @NonNull
    public final TalabatTextView orderDetailsTotalCurrency;
    @NonNull
    public final TalabatTextView orderDetailsTouristTax;
    @NonNull
    public final TalabatTextView orderDetailsTouristTaxAlt;
    @NonNull
    public final TalabatTextView orderDetailsTouristTaxCurrency;
    @NonNull
    public final RelativeLayout orderDetailsTouristTaxView;
    @NonNull
    public final LinearLayout orderDetailsView;
    @NonNull
    public final TalabatTextView orderIdTitleTv;
    @NonNull
    public final RelativeLayout orderRidertipView;
    @NonNull
    public final TalabatTextView orderSummaryTv;
    @NonNull
    public final TalabatTextView orderTime;
    @NonNull
    public final RelativeLayout orderVoucherView;
    @NonNull
    public final TalabatTextView paymentMethod;
    @NonNull
    public final TalabatTextView paymentMethodTitleTv;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    public final NetworkImageView restLogo;
    @NonNull
    public final TalabatTextView restaurantDeliveryChargesAlt;
    @NonNull
    public final TalabatTextView ridertip;
    @NonNull
    public final TalabatTextView ridertipTv;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final NestedScrollView scrollView1;
    @NonNull
    public final ViewServiceFeeBinding serviceFeeContainer;
    @NonNull
    public final ViewServiceFeeBinding smallOrderFeeContainer;
    @NonNull
    public final TalabatTextView subTotalCurrency;
    @NonNull
    public final TalabatTextView subTotalTitleTv;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;
    @NonNull
    public final LinearLayout totalLabel;
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
    public final TalabatTextView txtfirstName;
    @NonNull
    public final TalabatTextView voucherDiscount;
    @NonNull
    public final TalabatTextView voucherDiscountCurrency;
    @NonNull
    public final LinearLayout voucherDiscountPriceLabel;
    @NonNull
    public final TalabatTextView voucherDiscountTitleTv;

    private OrderDetailsScreenBinding(@NonNull LinearLayout linearLayout, @NonNull CardView cardView, @NonNull LinearLayout linearLayout2, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull TalabatButton talabatButton, @NonNull LinearLayout linearLayout3, @NonNull TalabatTextView talabatTextView, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView2, @NonNull RelativeLayout relativeLayout, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4, @NonNull LinearLayout linearLayout4, @NonNull TalabatTextView talabatTextView5, @NonNull RecyclerView recyclerView, @NonNull TalabatTextView talabatTextView6, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatTextView talabatTextView7, @NonNull TalabatTextView talabatTextView8, @NonNull RelativeLayout relativeLayout3, @NonNull RelativeLayout relativeLayout4, @NonNull TalabatTextView talabatTextView9, @NonNull RelativeLayout relativeLayout5, @NonNull TalabatTextView talabatTextView10, @NonNull TalabatTextView talabatTextView11, @NonNull TalabatTextView talabatTextView12, @NonNull ProgressBar progressBar2, @NonNull RelativeLayout relativeLayout6, @NonNull TalabatTextView talabatTextView13, @NonNull TalabatTextView talabatTextView14, @NonNull TalabatTextView talabatTextView15, @NonNull TalabatTextView talabatTextView16, @NonNull TalabatTextView talabatTextView17, @NonNull TalabatTextView talabatTextView18, @NonNull TalabatTextView talabatTextView19, @NonNull TalabatTextView talabatTextView20, @NonNull TalabatTextView talabatTextView21, @NonNull TalabatTextView talabatTextView22, @NonNull TalabatTextView talabatTextView23, @NonNull TalabatTextView talabatTextView24, @NonNull TalabatTextView talabatTextView25, @NonNull RelativeLayout relativeLayout7, @NonNull LinearLayout linearLayout5, @NonNull TalabatTextView talabatTextView26, @NonNull RelativeLayout relativeLayout8, @NonNull TalabatTextView talabatTextView27, @NonNull TalabatTextView talabatTextView28, @NonNull RelativeLayout relativeLayout9, @NonNull TalabatTextView talabatTextView29, @NonNull TalabatTextView talabatTextView30, @NonNull ProgressBar progressBar3, @NonNull NetworkImageView networkImageView, @NonNull TalabatTextView talabatTextView31, @NonNull TalabatTextView talabatTextView32, @NonNull TalabatTextView talabatTextView33, @NonNull NestedScrollView nestedScrollView, @NonNull ViewServiceFeeBinding viewServiceFeeBinding, @NonNull ViewServiceFeeBinding viewServiceFeeBinding2, @NonNull TalabatTextView talabatTextView34, @NonNull TalabatTextView talabatTextView35, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar, @NonNull LinearLayout linearLayout6, @NonNull TalabatTextView talabatTextView36, @NonNull TalabatTextView talabatTextView37, @NonNull TalabatTextView talabatTextView38, @NonNull TalabatTextView talabatTextView39, @NonNull TalabatTextView talabatTextView40, @NonNull TalabatTextView talabatTextView41, @NonNull TalabatTextView talabatTextView42, @NonNull TalabatTextView talabatTextView43, @NonNull LinearLayout linearLayout7, @NonNull TalabatTextView talabatTextView44) {
        this.rootView = linearLayout;
        this.addressContainer = cardView;
        this.addressLayoutView = linearLayout2;
        this.back = talabatToolBarImageButton;
        this.btnLogin = talabatButton;
        this.couponDiscountPriceLabel = linearLayout3;
        this.couponDiscountTitleTv = talabatTextView;
        this.deliverCurrentLocationImg = imageView;
        this.deliveryAddressTitle = talabatTextView2;
        this.deliveryTimeContainer = relativeLayout;
        this.deliveryTimeTitleTv = talabatTextView3;
        this.generalRequestText = talabatTextView4;
        this.generalRequestView = linearLayout4;
        this.grandTotalTitleTv = talabatTextView5;
        this.itemsRecyclerView = recyclerView;
        this.muncipalityTaxAlt = talabatTextView6;
        this.muncipalityTaxView = relativeLayout2;
        this.orderDetailsCouponCurrency = talabatTextView7;
        this.orderDetailsCouponDiscount = talabatTextView8;
        this.orderDetailsCouponView = relativeLayout3;
        this.orderDetailsDeliveryChargesView = relativeLayout4;
        this.orderDetailsDeliveryTime = talabatTextView9;
        this.orderDetailsGemSavingView = relativeLayout5;
        this.orderDetailsGemSavingViewAmountTxt = talabatTextView10;
        this.orderDetailsGemSavingViewCurrencyTxt = talabatTextView11;
        this.orderDetailsGemSavingViewTxt = talabatTextView12;
        this.orderDetailsLoadingIndicator = progressBar2;
        this.orderDetailsLogoView = relativeLayout6;
        this.orderDetailsMuncipalityTax = talabatTextView13;
        this.orderDetailsMuncipalityTaxCurrency = talabatTextView14;
        this.orderDetailsOrderId = talabatTextView15;
        this.orderDetailsRestDelCharges = talabatTextView16;
        this.orderDetailsRestDelChargesCurrency = talabatTextView17;
        this.orderDetailsRestaurantName = talabatTextView18;
        this.orderDetailsStatus = talabatTextView19;
        this.orderDetailsSubTotal = talabatTextView20;
        this.orderDetailsTotal = talabatTextView21;
        this.orderDetailsTotalCurrency = talabatTextView22;
        this.orderDetailsTouristTax = talabatTextView23;
        this.orderDetailsTouristTaxAlt = talabatTextView24;
        this.orderDetailsTouristTaxCurrency = talabatTextView25;
        this.orderDetailsTouristTaxView = relativeLayout7;
        this.orderDetailsView = linearLayout5;
        this.orderIdTitleTv = talabatTextView26;
        this.orderRidertipView = relativeLayout8;
        this.orderSummaryTv = talabatTextView27;
        this.orderTime = talabatTextView28;
        this.orderVoucherView = relativeLayout9;
        this.paymentMethod = talabatTextView29;
        this.paymentMethodTitleTv = talabatTextView30;
        this.progressBar = progressBar3;
        this.restLogo = networkImageView;
        this.restaurantDeliveryChargesAlt = talabatTextView31;
        this.ridertip = talabatTextView32;
        this.ridertipTv = talabatTextView33;
        this.scrollView1 = nestedScrollView;
        this.serviceFeeContainer = viewServiceFeeBinding;
        this.smallOrderFeeContainer = viewServiceFeeBinding2;
        this.subTotalCurrency = talabatTextView34;
        this.subTotalTitleTv = talabatTextView35;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
        this.totalLabel = linearLayout6;
        this.txtAdditionalDirections = talabatTextView36;
        this.txtAddresMobile = talabatTextView37;
        this.txtAddresPhone = talabatTextView38;
        this.txtAddressAreaname = talabatTextView39;
        this.txtAddressDescription = talabatTextView40;
        this.txtfirstName = talabatTextView41;
        this.voucherDiscount = talabatTextView42;
        this.voucherDiscountCurrency = talabatTextView43;
        this.voucherDiscountPriceLabel = linearLayout7;
        this.voucherDiscountTitleTv = talabatTextView44;
    }

    @NonNull
    public static OrderDetailsScreenBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.address_container;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view2, R.id.address_container);
        if (cardView != null) {
            i11 = R.id.address_layout_view;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.address_layout_view);
            if (linearLayout != null) {
                i11 = R.id.back;
                TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.back);
                if (talabatToolBarImageButton != null) {
                    i11 = R.id.btnLogin;
                    TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view2, R.id.btnLogin);
                    if (talabatButton != null) {
                        i11 = R.id.coupon_discount_price_label;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.coupon_discount_price_label);
                        if (linearLayout2 != null) {
                            i11 = R.id.coupon_discount_title_tv;
                            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.coupon_discount_title_tv);
                            if (talabatTextView != null) {
                                i11 = R.id.deliver_current_location_img;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.deliver_current_location_img);
                                if (imageView != null) {
                                    i11 = R.id.delivery_address_title;
                                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.delivery_address_title);
                                    if (talabatTextView2 != null) {
                                        i11 = R.id.delivery_time_container;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.delivery_time_container);
                                        if (relativeLayout != null) {
                                            i11 = R.id.delivery_time_title_tv;
                                            TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.delivery_time_title_tv);
                                            if (talabatTextView3 != null) {
                                                i11 = R.id.general_request_text;
                                                TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.general_request_text);
                                                if (talabatTextView4 != null) {
                                                    i11 = R.id.general_request_view;
                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.general_request_view);
                                                    if (linearLayout3 != null) {
                                                        i11 = R.id.grand_total_title_tv;
                                                        TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.grand_total_title_tv);
                                                        if (talabatTextView5 != null) {
                                                            i11 = R.id.items_recyclerView;
                                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.items_recyclerView);
                                                            if (recyclerView != null) {
                                                                i11 = R.id.muncipality_tax_alt;
                                                                TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.muncipality_tax_alt);
                                                                if (talabatTextView6 != null) {
                                                                    i11 = R.id.muncipality_tax_view;
                                                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.muncipality_tax_view);
                                                                    if (relativeLayout2 != null) {
                                                                        i11 = R.id.order_details_coupon_currency;
                                                                        TalabatTextView talabatTextView7 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_details_coupon_currency);
                                                                        if (talabatTextView7 != null) {
                                                                            i11 = R.id.order_details_coupon_discount;
                                                                            TalabatTextView talabatTextView8 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_details_coupon_discount);
                                                                            if (talabatTextView8 != null) {
                                                                                i11 = R.id.order_details_coupon_view;
                                                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.order_details_coupon_view);
                                                                                if (relativeLayout3 != null) {
                                                                                    i11 = R.id.order_details_delivery_charges_view;
                                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.order_details_delivery_charges_view);
                                                                                    if (relativeLayout4 != null) {
                                                                                        i11 = R.id.order_details_delivery_time;
                                                                                        TalabatTextView talabatTextView9 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_details_delivery_time);
                                                                                        if (talabatTextView9 != null) {
                                                                                            i11 = R.id.order_details_gem_saving_view;
                                                                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.order_details_gem_saving_view);
                                                                                            if (relativeLayout5 != null) {
                                                                                                i11 = R.id.order_details_gem_saving_view_amount_txt;
                                                                                                TalabatTextView talabatTextView10 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_details_gem_saving_view_amount_txt);
                                                                                                if (talabatTextView10 != null) {
                                                                                                    i11 = R.id.order_details_gem_saving_view_currency_txt;
                                                                                                    TalabatTextView talabatTextView11 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_details_gem_saving_view_currency_txt);
                                                                                                    if (talabatTextView11 != null) {
                                                                                                        i11 = R.id.order_details_gem_saving_view_txt;
                                                                                                        TalabatTextView talabatTextView12 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_details_gem_saving_view_txt);
                                                                                                        if (talabatTextView12 != null) {
                                                                                                            i11 = R.id.order_details_loading_indicator;
                                                                                                            ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.order_details_loading_indicator);
                                                                                                            if (progressBar2 != null) {
                                                                                                                i11 = R.id.order_details_logo_view;
                                                                                                                RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.order_details_logo_view);
                                                                                                                if (relativeLayout6 != null) {
                                                                                                                    i11 = R.id.order_details_muncipality_tax;
                                                                                                                    TalabatTextView talabatTextView13 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_details_muncipality_tax);
                                                                                                                    if (talabatTextView13 != null) {
                                                                                                                        i11 = R.id.order_details_muncipality_tax_currency;
                                                                                                                        TalabatTextView talabatTextView14 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_details_muncipality_tax_currency);
                                                                                                                        if (talabatTextView14 != null) {
                                                                                                                            i11 = R.id.order_details_orderId;
                                                                                                                            TalabatTextView talabatTextView15 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_details_orderId);
                                                                                                                            if (talabatTextView15 != null) {
                                                                                                                                i11 = R.id.order_details_rest_del_charges;
                                                                                                                                TalabatTextView talabatTextView16 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_details_rest_del_charges);
                                                                                                                                if (talabatTextView16 != null) {
                                                                                                                                    i11 = R.id.order_details_rest_del_charges_currency;
                                                                                                                                    TalabatTextView talabatTextView17 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_details_rest_del_charges_currency);
                                                                                                                                    if (talabatTextView17 != null) {
                                                                                                                                        i11 = R.id.order_details_restaurant_name;
                                                                                                                                        TalabatTextView talabatTextView18 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_details_restaurant_name);
                                                                                                                                        if (talabatTextView18 != null) {
                                                                                                                                            i11 = R.id.order_details_status;
                                                                                                                                            TalabatTextView talabatTextView19 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_details_status);
                                                                                                                                            if (talabatTextView19 != null) {
                                                                                                                                                i11 = R.id.order_details_sub_total;
                                                                                                                                                TalabatTextView talabatTextView20 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_details_sub_total);
                                                                                                                                                if (talabatTextView20 != null) {
                                                                                                                                                    i11 = R.id.order_details_total;
                                                                                                                                                    TalabatTextView talabatTextView21 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_details_total);
                                                                                                                                                    if (talabatTextView21 != null) {
                                                                                                                                                        i11 = R.id.order_details_total_currency;
                                                                                                                                                        TalabatTextView talabatTextView22 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_details_total_currency);
                                                                                                                                                        if (talabatTextView22 != null) {
                                                                                                                                                            i11 = R.id.order_details_tourist_tax;
                                                                                                                                                            TalabatTextView talabatTextView23 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_details_tourist_tax);
                                                                                                                                                            if (talabatTextView23 != null) {
                                                                                                                                                                i11 = R.id.order_details_tourist_tax_alt;
                                                                                                                                                                TalabatTextView talabatTextView24 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_details_tourist_tax_alt);
                                                                                                                                                                if (talabatTextView24 != null) {
                                                                                                                                                                    i11 = R.id.order_details_tourist_tax_currency;
                                                                                                                                                                    TalabatTextView talabatTextView25 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_details_tourist_tax_currency);
                                                                                                                                                                    if (talabatTextView25 != null) {
                                                                                                                                                                        i11 = R.id.order_details_tourist_tax_view;
                                                                                                                                                                        RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.order_details_tourist_tax_view);
                                                                                                                                                                        if (relativeLayout7 != null) {
                                                                                                                                                                            i11 = R.id.order_details_view;
                                                                                                                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.order_details_view);
                                                                                                                                                                            if (linearLayout4 != null) {
                                                                                                                                                                                i11 = R.id.order_id_title_tv;
                                                                                                                                                                                TalabatTextView talabatTextView26 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_id_title_tv);
                                                                                                                                                                                if (talabatTextView26 != null) {
                                                                                                                                                                                    i11 = R.id.order_ridertip_view;
                                                                                                                                                                                    RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.order_ridertip_view);
                                                                                                                                                                                    if (relativeLayout8 != null) {
                                                                                                                                                                                        i11 = R.id.order_summary_tv;
                                                                                                                                                                                        TalabatTextView talabatTextView27 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_summary_tv);
                                                                                                                                                                                        if (talabatTextView27 != null) {
                                                                                                                                                                                            i11 = R.id.order_time;
                                                                                                                                                                                            TalabatTextView talabatTextView28 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.order_time);
                                                                                                                                                                                            if (talabatTextView28 != null) {
                                                                                                                                                                                                i11 = R.id.order_voucher_view;
                                                                                                                                                                                                RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.order_voucher_view);
                                                                                                                                                                                                if (relativeLayout9 != null) {
                                                                                                                                                                                                    i11 = R.id.payment_method;
                                                                                                                                                                                                    TalabatTextView talabatTextView29 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.payment_method);
                                                                                                                                                                                                    if (talabatTextView29 != null) {
                                                                                                                                                                                                        i11 = R.id.payment_method_title_tv;
                                                                                                                                                                                                        TalabatTextView talabatTextView30 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.payment_method_title_tv);
                                                                                                                                                                                                        if (talabatTextView30 != null) {
                                                                                                                                                                                                            i11 = R.id.progressBar;
                                                                                                                                                                                                            ProgressBar progressBar3 = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.progressBar);
                                                                                                                                                                                                            if (progressBar3 != null) {
                                                                                                                                                                                                                i11 = R.id.rest_logo;
                                                                                                                                                                                                                NetworkImageView networkImageView = (NetworkImageView) ViewBindings.findChildViewById(view2, R.id.rest_logo);
                                                                                                                                                                                                                if (networkImageView != null) {
                                                                                                                                                                                                                    i11 = R.id.restaurant_delivery_charges_alt;
                                                                                                                                                                                                                    TalabatTextView talabatTextView31 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.restaurant_delivery_charges_alt);
                                                                                                                                                                                                                    if (talabatTextView31 != null) {
                                                                                                                                                                                                                        i11 = R.id.ridertip;
                                                                                                                                                                                                                        TalabatTextView talabatTextView32 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.ridertip);
                                                                                                                                                                                                                        if (talabatTextView32 != null) {
                                                                                                                                                                                                                            i11 = R.id.ridertip_tv;
                                                                                                                                                                                                                            TalabatTextView talabatTextView33 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.ridertip_tv);
                                                                                                                                                                                                                            if (talabatTextView33 != null) {
                                                                                                                                                                                                                                i11 = R.id.scrollView1;
                                                                                                                                                                                                                                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view2, R.id.scrollView1);
                                                                                                                                                                                                                                if (nestedScrollView != null) {
                                                                                                                                                                                                                                    i11 = R.id.service_fee_container;
                                                                                                                                                                                                                                    View findChildViewById = ViewBindings.findChildViewById(view2, R.id.service_fee_container);
                                                                                                                                                                                                                                    if (findChildViewById != null) {
                                                                                                                                                                                                                                        ViewServiceFeeBinding bind = ViewServiceFeeBinding.bind(findChildViewById);
                                                                                                                                                                                                                                        i11 = R.id.small_order_fee_container;
                                                                                                                                                                                                                                        View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.small_order_fee_container);
                                                                                                                                                                                                                                        if (findChildViewById2 != null) {
                                                                                                                                                                                                                                            ViewServiceFeeBinding bind2 = ViewServiceFeeBinding.bind(findChildViewById2);
                                                                                                                                                                                                                                            i11 = R.id.sub_total_currency;
                                                                                                                                                                                                                                            TalabatTextView talabatTextView34 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.sub_total_currency);
                                                                                                                                                                                                                                            if (talabatTextView34 != null) {
                                                                                                                                                                                                                                                i11 = R.id.sub_total_title_tv;
                                                                                                                                                                                                                                                TalabatTextView talabatTextView35 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.sub_total_title_tv);
                                                                                                                                                                                                                                                if (talabatTextView35 != null) {
                                                                                                                                                                                                                                                    i11 = R.id.title;
                                                                                                                                                                                                                                                    TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                                                                                                                                                                                                                    if (talabatToolBarTextView != null) {
                                                                                                                                                                                                                                                        i11 = R.id.toolbar;
                                                                                                                                                                                                                                                        TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                                                                                                                                                                                                        if (talabatToolBar != null) {
                                                                                                                                                                                                                                                            i11 = R.id.total_label;
                                                                                                                                                                                                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.total_label);
                                                                                                                                                                                                                                                            if (linearLayout5 != null) {
                                                                                                                                                                                                                                                                i11 = R.id.txtAdditionalDirections;
                                                                                                                                                                                                                                                                TalabatTextView talabatTextView36 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txtAdditionalDirections);
                                                                                                                                                                                                                                                                if (talabatTextView36 != null) {
                                                                                                                                                                                                                                                                    i11 = R.id.txtAddresMobile;
                                                                                                                                                                                                                                                                    TalabatTextView talabatTextView37 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txtAddresMobile);
                                                                                                                                                                                                                                                                    if (talabatTextView37 != null) {
                                                                                                                                                                                                                                                                        i11 = R.id.txtAddresPhone;
                                                                                                                                                                                                                                                                        TalabatTextView talabatTextView38 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txtAddresPhone);
                                                                                                                                                                                                                                                                        if (talabatTextView38 != null) {
                                                                                                                                                                                                                                                                            i11 = R.id.txtAddressAreaname;
                                                                                                                                                                                                                                                                            TalabatTextView talabatTextView39 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txtAddressAreaname);
                                                                                                                                                                                                                                                                            if (talabatTextView39 != null) {
                                                                                                                                                                                                                                                                                i11 = R.id.txtAddressDescription;
                                                                                                                                                                                                                                                                                TalabatTextView talabatTextView40 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txtAddressDescription);
                                                                                                                                                                                                                                                                                if (talabatTextView40 != null) {
                                                                                                                                                                                                                                                                                    i11 = R.id.txtfirstName;
                                                                                                                                                                                                                                                                                    TalabatTextView talabatTextView41 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txtfirstName);
                                                                                                                                                                                                                                                                                    if (talabatTextView41 != null) {
                                                                                                                                                                                                                                                                                        i11 = R.id.voucher_discount;
                                                                                                                                                                                                                                                                                        TalabatTextView talabatTextView42 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.voucher_discount);
                                                                                                                                                                                                                                                                                        if (talabatTextView42 != null) {
                                                                                                                                                                                                                                                                                            i11 = R.id.voucher_discount_currency;
                                                                                                                                                                                                                                                                                            TalabatTextView talabatTextView43 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.voucher_discount_currency);
                                                                                                                                                                                                                                                                                            if (talabatTextView43 != null) {
                                                                                                                                                                                                                                                                                                i11 = R.id.voucher_discount_price_label;
                                                                                                                                                                                                                                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.voucher_discount_price_label);
                                                                                                                                                                                                                                                                                                if (linearLayout6 != null) {
                                                                                                                                                                                                                                                                                                    i11 = R.id.voucher_discount_title_tv;
                                                                                                                                                                                                                                                                                                    TalabatTextView talabatTextView44 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.voucher_discount_title_tv);
                                                                                                                                                                                                                                                                                                    if (talabatTextView44 != null) {
                                                                                                                                                                                                                                                                                                        return new OrderDetailsScreenBinding((LinearLayout) view2, cardView, linearLayout, talabatToolBarImageButton, talabatButton, linearLayout2, talabatTextView, imageView, talabatTextView2, relativeLayout, talabatTextView3, talabatTextView4, linearLayout3, talabatTextView5, recyclerView, talabatTextView6, relativeLayout2, talabatTextView7, talabatTextView8, relativeLayout3, relativeLayout4, talabatTextView9, relativeLayout5, talabatTextView10, talabatTextView11, talabatTextView12, progressBar2, relativeLayout6, talabatTextView13, talabatTextView14, talabatTextView15, talabatTextView16, talabatTextView17, talabatTextView18, talabatTextView19, talabatTextView20, talabatTextView21, talabatTextView22, talabatTextView23, talabatTextView24, talabatTextView25, relativeLayout7, linearLayout4, talabatTextView26, relativeLayout8, talabatTextView27, talabatTextView28, relativeLayout9, talabatTextView29, talabatTextView30, progressBar3, networkImageView, talabatTextView31, talabatTextView32, talabatTextView33, nestedScrollView, bind, bind2, talabatTextView34, talabatTextView35, talabatToolBarTextView, talabatToolBar, linearLayout5, talabatTextView36, talabatTextView37, talabatTextView38, talabatTextView39, talabatTextView40, talabatTextView41, talabatTextView42, talabatTextView43, linearLayout6, talabatTextView44);
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
    public static OrderDetailsScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static OrderDetailsScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.order_details_screen, viewGroup, false);
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
