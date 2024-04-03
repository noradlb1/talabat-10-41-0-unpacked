package com.talabat;

import JsonModels.parser.UniversalGson;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.TalabatFormatter;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.country.Country;
import com.talabat.domain.address.Address;
import com.talabat.domain.address.AddressesKt;
import com.talabat.helpers.BitmapLruCache;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.OrderDetails;
import datamodels.OrderDetailsItem;
import java.util.ArrayList;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.orderdetails.IOrderDetailsPresenter;
import library.talabat.mvp.orderdetails.OrderDetailsPresenter;
import library.talabat.mvp.orderdetails.OrderDetailsView;
import tracking.ScreenNames;

@Instrumented
public class OrderDetailsScreen extends TalabatBase implements OrderDetailsView {
    public static final String ENCRYPTED_ORDER_ID_KEY = "ENCRYPTED_ORDER_ID";
    public static final String ORDER_STATUS_KEY = "statusBoolean";
    private View addressContainer;
    private TextView addressDescription;
    private TextView altDeliveryCharges;
    private TextView altMuncipalityTax;
    private TextView altTouristTax;
    private TextView areaName;
    private TextView couponDiscount;
    private TextView couponDiscount_currency;
    private View couponDiscount_view;
    private String currencySymbol;
    private TextView delCharges;
    private TextView delCharges_currency;
    private View delCharges_view;
    private TextView delTime;
    private View deliveryTimeContainer;
    private TextView directions;
    private TextView firstName;
    private TextView gemSavingAmntTxt;
    private View gemSavingView;
    private TextView generalRequestText;
    private View generalRequestView;
    private TextView getGemSavingCurrencyAmntTxt;
    private ImageLoader imageLoader;
    private RecyclerView itemRecycularView;
    private ProgressBar loadingIndicator;
    private Toolbar mToolbar;
    private TextView mobileNumber;
    private TextView muncipalityTax;
    private TextView muncipalityTax_currency;
    private View muncipalityTax_view;
    private NestedScrollView nestedScrollView;
    private IOrderDetailsPresenter orderDetailsPresenter;
    private TextView orderId;
    private TextView orderStatus;
    private TextView orderTime;
    private TextView paymentMethod;
    private TextView phoneNumber;
    private TextView restaurantName;
    private NetworkImageView restaurant_logo;
    private TextView riderTip;
    private View riderTip_view;
    private View serviceFeeContainer;
    private TextView serviceFeeLabel;
    private TextView serviceFeeValue;
    private View smallOrderFeeContainer;
    private TextView smallOrderFeeLabel;
    private TextView smallOrderFeeValue;
    public boolean statusBoolean;
    private TextView subtotal;
    private TextView subtotal_currency;
    private TextView total;
    private TextView total_currency;
    private TextView touristTax;
    private TextView touristTax_currency;
    private View touristTax_view;
    private TextView voucherDiscount;
    private TextView voucherDiscount_currency;
    private View voucherDiscount_view;

    public class ThankyouItemsRecycularViewAdpater extends RecyclerView.Adapter<ThankyouItemsViewHolder> {
        private ArrayList<OrderDetailsItem> items;

        public ThankyouItemsRecycularViewAdpater(ArrayList<OrderDetailsItem> arrayList) {
            this.items = arrayList;
        }

        public int getItemCount() {
            return this.items.size();
        }

        public void onBindViewHolder(ThankyouItemsViewHolder thankyouItemsViewHolder, int i11) {
            OrderDetailsItem orderDetailsItem = this.items.get(i11);
            thankyouItemsViewHolder.itemName.setText(orderDetailsItem.itemName);
            if (orderDetailsItem.itemPrice == 0.0f) {
                thankyouItemsViewHolder.itemPrice.setText(R.string.free);
            } else {
                thankyouItemsViewHolder.itemPrice.setText(orderDetailsItem.getItemPriceWithoutCurrency());
            }
            TextView textView = thankyouItemsViewHolder.itemQuantity;
            textView.setText("" + orderDetailsItem.itemQuantity);
            if (!TalabatUtils.isNullOrEmpty(orderDetailsItem.itemChoices)) {
                thankyouItemsViewHolder.itemChoices.setVisibility(0);
                thankyouItemsViewHolder.itemChoices.setText(orderDetailsItem.itemChoices);
            } else {
                thankyouItemsViewHolder.itemChoices.setVisibility(8);
            }
            if (!TalabatUtils.isNullOrEmpty(orderDetailsItem.specialRequest)) {
                thankyouItemsViewHolder.itemSpecialRequest.setVisibility(0);
                thankyouItemsViewHolder.itemSpecialRequest.setText(orderDetailsItem.specialRequest);
            }
        }

        public ThankyouItemsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new ThankyouItemsViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.order_details_cart_items, viewGroup, false));
        }
    }

    public class ThankyouItemsViewHolder extends RecyclerView.ViewHolder {
        public TextView itemChoices;
        public TextView itemName;
        public TextView itemPrice;
        public TextView itemQuantity;
        public TextView itemSpecialRequest;

        public ThankyouItemsViewHolder(View view) {
            super(view);
            this.itemName = (TextView) view.findViewById(R.id.item_name);
            this.itemQuantity = (TextView) view.findViewById(R.id.item_quantity);
            this.itemPrice = (TextView) view.findViewById(R.id.item_price);
            this.itemChoices = (TextView) view.findViewById(R.id.item_choices_name);
            this.itemSpecialRequest = (TextView) view.findViewById(R.id.item_special_request);
        }
    }

    private int getStatus(Boolean bool) {
        return bool.booleanValue() ? R.string.successful : R.string.delivered;
    }

    private void initServiceFeeViews() {
        View findViewById = findViewById(R.id.service_fee_container);
        this.serviceFeeContainer = findViewById;
        this.serviceFeeLabel = (TextView) findViewById.findViewById(R.id.service_fee_label);
        this.serviceFeeValue = (TextView) this.serviceFeeContainer.findViewById(R.id.service_fee_value_text);
        View findViewById2 = this.serviceFeeContainer.findViewById(R.id.service_fee_tooltip_icon);
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
    }

    private void initSmallOrderFeeViews() {
        View findViewById = findViewById(R.id.small_order_fee_container);
        this.smallOrderFeeContainer = findViewById;
        this.smallOrderFeeLabel = (TextView) findViewById.findViewById(R.id.service_fee_label);
        this.smallOrderFeeValue = (TextView) this.smallOrderFeeContainer.findViewById(R.id.service_fee_value_text);
        View findViewById2 = this.smallOrderFeeContainer.findViewById(R.id.service_fee_tooltip_icon);
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
    }

    public void destroyPresenter() {
    }

    public Context getContext() {
        return this;
    }

    public IGlobalPresenter getPresenter() {
        return this.orderDetailsPresenter;
    }

    public String getScreenName() {
        return ScreenNames.ORDERDETAILS;
    }

    public void hideLoading() {
        this.loadingIndicator.setVisibility(8);
    }

    public void onAuthError() {
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        super.onCreate(bundle);
        setContentView((int) R.layout.order_details_screen);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setBackButton(R.id.back);
            setTitle(R.id.title, getString(R.string.title_activity_order_details));
            Gson gson = UniversalGson.INSTANCE.gson;
            this.nestedScrollView = (NestedScrollView) findViewById(R.id.scrollView1);
            String stringExtra = getIntent().getStringExtra("value");
            String stringExtra2 = getIntent().getStringExtra(ENCRYPTED_ORDER_ID_KEY);
            this.statusBoolean = getIntent().getBooleanExtra("statusBoolean", false);
            Class cls = OrderDetails.class;
            if (!(gson instanceof Gson)) {
                obj = gson.fromJson(stringExtra, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson, stringExtra, cls);
            }
            this.currencySymbol = TalabatFormatter.getInstance().getCurrencySymbol();
            this.restaurantName = (TextView) findViewById(R.id.order_details_restaurant_name);
            this.restaurant_logo = (NetworkImageView) findViewById(R.id.rest_logo);
            this.imageLoader = new ImageLoader(Volley.newRequestQueue(this), new BitmapLruCache());
            this.orderStatus = (TextView) findViewById(R.id.order_details_status);
            this.orderTime = (TextView) findViewById(R.id.order_time);
            this.orderId = (TextView) findViewById(R.id.order_details_orderId);
            this.firstName = (TextView) findViewById(R.id.txtfirstName);
            this.addressContainer = findViewById(R.id.address_container);
            this.deliveryTimeContainer = findViewById(R.id.delivery_time_container);
            this.areaName = (TextView) findViewById(R.id.txtAddressAreaname);
            this.addressDescription = (TextView) findViewById(R.id.txtAddressDescription);
            this.mobileNumber = (TextView) findViewById(R.id.txtAddresMobile);
            this.phoneNumber = (TextView) findViewById(R.id.txtAddresPhone);
            this.directions = (TextView) findViewById(R.id.txtAdditionalDirections);
            this.subtotal = (TextView) findViewById(R.id.order_details_sub_total);
            this.subtotal_currency = (TextView) findViewById(R.id.sub_total_currency);
            this.delCharges = (TextView) findViewById(R.id.order_details_rest_del_charges);
            this.delCharges_currency = (TextView) findViewById(R.id.order_details_rest_del_charges_currency);
            this.altDeliveryCharges = (TextView) findViewById(R.id.restaurant_delivery_charges_alt);
            this.delCharges_view = findViewById(R.id.order_details_delivery_charges_view);
            initServiceFeeViews();
            initSmallOrderFeeViews();
            this.total = (TextView) findViewById(R.id.order_details_total);
            this.total_currency = (TextView) findViewById(R.id.order_details_total_currency);
            this.paymentMethod = (TextView) findViewById(R.id.payment_method);
            this.delTime = (TextView) findViewById(R.id.order_details_delivery_time);
            this.muncipalityTax_currency = (TextView) findViewById(R.id.order_details_muncipality_tax_currency);
            this.muncipalityTax = (TextView) findViewById(R.id.order_details_muncipality_tax);
            this.altMuncipalityTax = (TextView) findViewById(R.id.muncipality_tax_alt);
            this.muncipalityTax_view = findViewById(R.id.muncipality_tax_view);
            this.touristTax = (TextView) findViewById(R.id.order_details_tourist_tax);
            this.altTouristTax = (TextView) findViewById(R.id.order_details_tourist_tax_alt);
            this.touristTax_currency = (TextView) findViewById(R.id.order_details_tourist_tax_currency);
            this.touristTax_view = findViewById(R.id.order_details_tourist_tax_view);
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.items_recyclerView);
            this.itemRecycularView = recyclerView;
            recyclerView.setNestedScrollingEnabled(false);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(1);
            this.itemRecycularView.setLayoutManager(linearLayoutManager);
            this.couponDiscount_view = findViewById(R.id.order_details_coupon_view);
            this.couponDiscount_currency = (TextView) findViewById(R.id.order_details_coupon_currency);
            this.couponDiscount = (TextView) findViewById(R.id.order_details_coupon_discount);
            this.voucherDiscount_view = findViewById(R.id.order_voucher_view);
            this.voucherDiscount = (TextView) findViewById(R.id.voucher_discount);
            this.voucherDiscount_currency = (TextView) findViewById(R.id.voucher_discount_currency);
            this.riderTip_view = findViewById(R.id.order_ridertip_view);
            this.riderTip = (TextView) findViewById(R.id.ridertip);
            this.generalRequestView = findViewById(R.id.general_request_view);
            this.generalRequestText = (TextView) findViewById(R.id.general_request_text);
            this.gemSavingView = findViewById(R.id.order_details_gem_saving_view);
            this.gemSavingAmntTxt = (TextView) findViewById(R.id.order_details_gem_saving_view_amount_txt);
            this.getGemSavingCurrencyAmntTxt = (TextView) findViewById(R.id.order_details_gem_saving_view_currency_txt);
            this.loadingIndicator = (ProgressBar) findViewById(R.id.order_details_loading_indicator);
            OrderDetailsPresenter initialize = OrderDetailsPresenter.initialize(this);
            this.orderDetailsPresenter = initialize;
            initialize.onAttach((OrderDetails) obj, stringExtra2);
        } catch (Exception e11) {
            LogManager.logException(e11);
            e11.printStackTrace();
            finish();
        }
    }

    public void onDestroy() {
        this.orderDetailsPresenter.onDestroy();
        super.onDestroy();
    }

    public void onError() {
    }

    public void showCouponDiscount(String str) {
        this.couponDiscount_view.setVisibility(0);
        this.couponDiscount.setText(str);
        this.couponDiscount_currency.setText(TalabatFormatter.getInstance().getCurrencySymbol());
    }

    public void showDeliveryAddress(Address address) {
        String str;
        String str2;
        boolean z11;
        if (TalabatUtils.isNullOrEmpty(address.profileName)) {
            str = "";
        } else {
            str = address.profileName;
        }
        if (TalabatUtils.isNullOrEmpty(str)) {
            str2 = address.areaName;
        } else {
            str2 = str + " (" + address.areaName + ")";
        }
        this.areaName.setText(str2);
        TextView textView = this.addressDescription;
        if (GlobalDataModel.SelectedCountryId == Country.LEBANON.getCountryId()) {
            z11 = true;
        } else {
            z11 = false;
        }
        textView.setText(AddressesKt.description(address, z11));
        if (GlobalDataModel.SelectedCountryId != Country.UAE.getCountryId()) {
            this.mobileNumber.setText(getString(R.string.address_mobile) + address.mobileNumber);
        } else if (!TalabatUtils.isNullOrEmpty(address.mobilNumberCountryCode)) {
            this.mobileNumber.setText(getString(R.string.address_mobile) + " +" + address.mobilNumberCountryCode + "  " + address.mobileNumber);
        } else {
            this.mobileNumber.setText(getString(R.string.address_mobile) + address.mobileNumber);
        }
        if (TalabatUtils.isNullOrEmpty(address.phoneNumber)) {
            this.phoneNumber.setVisibility(8);
        } else {
            this.phoneNumber.setText(getString(R.string.address_phone) + " " + address.phoneNumber);
        }
        if (TalabatUtils.isNullOrEmpty(address.extraDirections)) {
            this.directions.setVisibility(8);
            return;
        }
        this.directions.setVisibility(0);
        this.directions.setText(address.extraDirections);
    }

    public void showDeliveryTime(String str) {
        this.delTime.setText(str);
    }

    public void showError() {
        Toast.makeText(this, R.string.order_details_error_message, 1).show();
    }

    public void showFirstName(String str) {
        this.firstName.setText(str);
    }

    public void showGemDiscountView(boolean z11, float f11) {
        if (!z11) {
            this.gemSavingView.setVisibility(8);
        } else if (f11 > 0.0f) {
            this.gemSavingView.setVisibility(0);
            TextView textView = this.gemSavingAmntTxt;
            textView.setText(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + TalabatFormatter.getInstance().getFormattedCurrency(f11, true));
        } else {
            this.gemSavingView.setVisibility(8);
        }
    }

    public void showGeneralRequest(boolean z11, String str) {
        if (z11) {
            this.generalRequestView.setVisibility(0);
            String string = getString(R.string.general_request_order_details);
            TextView textView = this.generalRequestText;
            textView.setText(Html.fromHtml("<b>" + string + "</b> " + str));
            return;
        }
        this.generalRequestView.setVisibility(8);
    }

    public void showLoading() {
        this.loadingIndicator.setVisibility(0);
    }

    public void showMunicipalityCharges(String str) {
        this.muncipalityTax_view.setVisibility(0);
        this.muncipalityTax.setText(str);
        this.muncipalityTax_currency.setText(TalabatFormatter.getInstance().getCurrencySymbol());
    }

    public void showMunicipalityTaxAltText(String str) {
        this.altMuncipalityTax.setText(str);
    }

    public void showOrderDate(String str) {
        this.orderTime.setText(str);
    }

    public void showOrderDetails() {
        this.nestedScrollView.setVisibility(0);
    }

    public void showOrderId(String str) {
        this.orderId.setText(str);
    }

    public void showOrderItems(ArrayList<OrderDetailsItem> arrayList) {
        this.itemRecycularView.setAdapter(new ThankyouItemsRecycularViewAdpater(arrayList));
        this.nestedScrollView.smoothScrollTo(0, 0);
        this.nestedScrollView.scrollTo(0, 0);
    }

    public void showOrderStatus(OrderDetails orderDetails) {
        if (this.statusBoolean) {
            int newOrderStatus = orderDetails.getNewOrderStatus();
            if (newOrderStatus == 1) {
                this.orderStatus.setText(getString(R.string.ordered));
                this.orderStatus.setTextColor(getResources().getColor(R.color.success));
            } else if (newOrderStatus == 2) {
                this.orderStatus.setText(getString(R.string.preparing));
                this.orderStatus.setTextColor(getResources().getColor(R.color.success));
            } else if (newOrderStatus == 3) {
                this.orderStatus.setText(getString(R.string.delivering));
                this.orderStatus.setTextColor(getResources().getColor(R.color.success));
            } else if (newOrderStatus == 4) {
                this.orderStatus.setText(getString(getStatus(Boolean.valueOf(orderDetails.isPickup()))));
                this.orderStatus.setTextColor(getResources().getColor(R.color.success));
            } else if (this.statusBoolean) {
                this.orderStatus.setTextColor(getResources().getColor(R.color.success));
                this.orderStatus.setText(getString(R.string.successful));
            } else {
                this.orderStatus.setTextColor(getResources().getColor(R.color.rdanger));
                this.orderStatus.setText(getString(R.string.cancelled));
            }
        } else {
            this.orderStatus.setTextColor(getResources().getColor(R.color.rdanger));
            this.orderStatus.setText(getString(R.string.cancelled));
        }
        this.orderStatus.setMaxLines(1);
        this.orderStatus.setLines(1);
        this.orderStatus.setSingleLine(true);
        this.orderStatus.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void showPaymentMethod(String str) {
        this.paymentMethod.setText(str);
    }

    public void showPickupScreen() {
        this.addressContainer.setVisibility(8);
        this.delCharges_view.setVisibility(8);
        this.deliveryTimeContainer.setVisibility(8);
    }

    public void showRestaurantDeliveryCharges(String str, String str2) {
        this.delCharges_view.setVisibility(0);
        this.delCharges_currency.setText(TalabatFormatter.getInstance().getCurrencySymbol());
        if (str.equals("d")) {
            str = getString(R.string.restaurant_del_charges);
        } else if (str.equals("t")) {
            str = getString(R.string.talabat_charges);
        }
        this.altDeliveryCharges.setText(str);
        this.delCharges.setText(str2);
    }

    public void showRestaurantDeliveryChargesAltText(String str) {
        this.altDeliveryCharges.setText(str);
    }

    public void showRestaurantImage(String str) {
        this.restaurant_logo.setImageUrl(str, this.imageLoader);
    }

    public void showRestaurantName(String str) {
        this.restaurantName.setText(str);
    }

    public void showRiderTip(@NonNull String str) {
        this.riderTip_view.setVisibility(0);
        this.riderTip.setText(str);
    }

    public void showServiceFee(@Nullable String str, @Nullable String str2) {
        int i11;
        if (str == null || str2 == null) {
            i11 = 8;
        } else {
            i11 = 0;
        }
        this.serviceFeeContainer.setVisibility(i11);
        this.serviceFeeLabel.setText(str);
        this.serviceFeeValue.setText(str2);
    }

    public void showSmallOrderFee(@Nullable String str, @Nullable String str2) {
        int i11;
        if (str == null || str2 == null) {
            i11 = 8;
        } else {
            i11 = 0;
        }
        this.smallOrderFeeContainer.setVisibility(i11);
        this.smallOrderFeeLabel.setText(str);
        this.smallOrderFeeValue.setText(str2);
    }

    public void showSubTotal(String str) {
        this.subtotal.setText(str);
        this.subtotal_currency.setText(this.currencySymbol);
    }

    public void showTotal(String str) {
        this.total.setText(str);
    }

    public void showTouristTax(String str) {
        this.touristTax_view.setVisibility(0);
        this.touristTax.setText(str);
        this.touristTax_currency.setText(TalabatFormatter.getInstance().getCurrencySymbol());
    }

    public void showTouristTaxAltTax(String str) {
        this.altTouristTax.setText(str);
    }

    public void showVoucherDiscount(String str) {
        this.voucherDiscount_view.setVisibility(0);
        this.voucherDiscount.setText(str);
        this.voucherDiscount_currency.setText(TalabatFormatter.getInstance().getCurrencySymbol());
    }
}
