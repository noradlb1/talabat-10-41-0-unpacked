package com.talabat;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import buisnessmodels.Cart;
import buisnessmodels.GEMEngine;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.di.ApiContainer;
import com.talabat.di.restaurant.DaggerRestaurantInfoActivityComponent;
import com.talabat.geminterfaces.OnGemAlertDialogClickListener;
import com.talabat.helpers.BaseRatingBar;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.restaurants.RestaurantsListScreenRefactor;
import com.talabat.talabatcommon.helpers.GlideApp;
import com.talabat.talabatcommon.helpers.RatingDataMapperV2;
import com.talabat.talabatcommon.helpers.TalabatGlideModule;
import datamodels.Restaurant;
import datamodels.RestaurantReview;
import javax.inject.Inject;
import library.talabat.gemengine.GemView;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.restaurantinfonew.IRestaurantInfoPresenter;
import library.talabat.mvp.restaurantinfonew.RestaurantInfoPresenter;
import library.talabat.mvp.restaurantinfonew.RestaurantInfoView;
import tracking.AppTracker;
import tracking.ScreenNames;
import yq.a;

public class RestaurantInfoActivity extends TalabatBase implements RestaurantInfoView, View.OnClickListener, GemView, OnGemAlertDialogClickListener {
    private ImageView americanExpressView;
    private TextView areaText;
    private ImageButton back;
    private TextView cartCount;
    private ImageButton cartImage;
    private ImageView cashView;
    private TextView cuisinesText;
    private ImageView debitCardView;
    private TextView deliveryCharges;
    private TextView deliveryChargesText;
    private TextView deliveryTime;
    private View fullSeperator;
    private String heroCoverImg;

    /* renamed from: i  reason: collision with root package name */
    public GemFooterCartView f54944i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f54945j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f54946k;
    @Inject

    /* renamed from: l  reason: collision with root package name */
    public PaymentConfigurationRepository f54947l;
    private ImageView mClose;
    private ImageView mCoverImg;
    private GemDialogSwitcher mGemDialogSwitcher;
    private ImageView mRatingAvatar;
    private TextView mRatingText;
    private View mRatingView;
    private IRestaurantInfoPresenter mRestaurantInfoPresenter;
    private ImageView masterCardView;
    private TextView minimumOrderText;
    private View municipalitySeparator;
    private TextView municipalityTaxText;
    private TextView municipalityTaxTextTax;
    private View municipalityTaxView;
    private TextView postDatedDelivery;
    private View preOrderSeperator;
    private ImageView restaurantLogoimageView;
    private TextView restaurantNameText;
    private TextView restaurantRating;
    private BaseRatingBar restaurantRatingBar;
    private RestaurantReview restaurantReview;
    private TextView restaurantStatus;
    private TextView textViewAreaTitle;
    private TextView titleText;
    private View touristTaxSeperator;
    private TextView touristTaxTax;
    private TextView touristTaxText;
    private View touristTaxView;
    private View viewRate;
    private ImageView visaView;
    private TextView workingHoursText;

    private void initializeControls() {
        this.titleText = (TextView) findViewById(R.id.tv_title);
        this.textViewAreaTitle = (TextView) findViewById(R.id.textView_area_title);
        this.areaText = (TextView) findViewById(R.id.tv_restaurant_area);
        this.cuisinesText = (TextView) findViewById(R.id.tv_restaurant_cuisines);
        this.workingHoursText = (TextView) findViewById(R.id.tv_opening_hours);
        this.restaurantNameText = (TextView) findViewById(R.id.tv_restaurant_name);
        this.restaurantStatus = (TextView) findViewById(R.id.tv_status_label);
        this.deliveryTime = (TextView) findViewById(R.id.tv_delivery_time);
        this.minimumOrderText = (TextView) findViewById(R.id.tv_minimum_order);
        this.deliveryCharges = (TextView) findViewById(R.id.tv_delivery_charges);
        this.postDatedDelivery = (TextView) findViewById(R.id.tv_post_dateDelivery);
        this.deliveryChargesText = (TextView) findViewById(R.id.tv_restaurant_delivery_charges_text);
        this.municipalityTaxView = findViewById(R.id.municipality_tax_view);
        this.municipalityTaxText = (TextView) findViewById(R.id.tv_municipality_tax_text);
        this.municipalityTaxTextTax = (TextView) findViewById(R.id.tv_municipality_tax);
        this.municipalitySeparator = findViewById(R.id.municipality_separator);
        this.touristTaxView = findViewById(R.id.tourist_tax_view);
        this.touristTaxText = (TextView) findViewById(R.id.tv_tourist_tax_text);
        this.touristTaxTax = (TextView) findViewById(R.id.tv_tourist_tax);
        this.touristTaxSeperator = findViewById(R.id.tourist_separator);
        this.preOrderSeperator = findViewById(R.id.pre_order_seperator);
        this.restaurantRating = (TextView) findViewById(R.id.tv_rating_count);
        this.restaurantRatingBar = (BaseRatingBar) findViewById(R.id.ratingbar_restaurant_screen);
        this.restaurantLogoimageView = (ImageView) findViewById(R.id.iv_rest_logo);
        this.cartCount = (TextView) findViewById(R.id.tv_cart_count);
        this.cartImage = (ImageButton) findViewById(R.id.ib_cart);
        this.mCoverImg = (ImageView) findViewById(R.id.iv_cover_image);
        this.mClose = (ImageView) findViewById(R.id.btn_new_close);
        this.visaView = (ImageView) findViewById(R.id.visa_icon);
        this.cashView = (ImageView) findViewById(R.id.cash_icon);
        this.masterCardView = (ImageView) findViewById(R.id.mastercard_icon);
        this.debitCardView = (ImageView) findViewById(R.id.debit_card_icon);
        this.americanExpressView = (ImageView) findViewById(R.id.amex_icon);
        this.viewRate = findViewById(R.id.ll_rate);
        this.mRatingAvatar = (ImageView) findViewById(R.id.vendor_rate_avatar);
        this.mRatingText = (TextView) findViewById(R.id.vendor_rate_status);
        this.mRatingView = findViewById(R.id.rating_view);
        this.viewRate.setOnClickListener(this);
        this.mRestaurantInfoPresenter = new RestaurantInfoPresenter(this);
        setCartVisibility(R.id.rl_cart_holder);
        refreshCartCount();
        setCartButton(R.id.rl_cart_holder, new TalabatBase.CartButtonClicked() {
            public void onCartButtonClicked() {
                if (Cart.getInstance().hasItems()) {
                    Intent intent = new Intent(RestaurantInfoActivity.this, CartScreen.class);
                    String string = RestaurantInfoActivity.this.getString(R.string.transition_view_cart_button);
                    ContextCompat.startActivity(RestaurantInfoActivity.this, intent, ActivityOptionsCompat.makeSceneTransitionAnimation(RestaurantInfoActivity.this, RestaurantInfoActivity.this.findViewById(R.id.rl_cart_holder), string).toBundle());
                    return;
                }
                RestaurantInfoActivity restaurantInfoActivity = RestaurantInfoActivity.this;
                Toast.makeText(restaurantInfoActivity, restaurantInfoActivity.getResources().getString(R.string.your_cart_is_empty), 0).show();
            }
        });
        setRestaurantInfoViews();
        ImageButton imageButton = (ImageButton) findViewById(R.id.back);
        this.back = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RestaurantInfoActivity.this.exitAnimation();
            }
        });
        if (this.mGemDialogSwitcher == null) {
            this.mGemDialogSwitcher = new GemDialogSwitcher(this, this, getScreenName());
        }
        this.mClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RestaurantInfoActivity.this.exitAnimation();
            }
        });
        inflateGemFooter();
    }

    private void setSeparators() {
        boolean z11 = this.f54945j;
        if (z11 && this.f54946k) {
            this.preOrderSeperator.setVisibility(0);
            this.municipalitySeparator.setVisibility(0);
            this.touristTaxSeperator.setVisibility(8);
        } else if (z11 && !this.f54946k) {
            this.preOrderSeperator.setVisibility(0);
            this.municipalitySeparator.setVisibility(8);
            this.touristTaxSeperator.setVisibility(8);
        } else if (!z11 && this.f54946k) {
            this.preOrderSeperator.setVisibility(0);
            this.municipalitySeparator.setVisibility(8);
            this.touristTaxSeperator.setVisibility(8);
        } else if (!z11 && !this.f54946k) {
            this.preOrderSeperator.setVisibility(8);
            this.municipalitySeparator.setVisibility(8);
            this.touristTaxSeperator.setVisibility(8);
        }
    }

    public void destroyPresenter() {
    }

    public Context getGemContext() {
        return this;
    }

    public String getGemScreenType() {
        return ScreenNames.getScreenType(getScreenName());
    }

    public IGlobalPresenter getPresenter() {
        return null;
    }

    public String getScreenName() {
        return ScreenNames.RESTAURANTINFO;
    }

    public void inflateGemFooter() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            this.f54944i = new GemFooterCartView();
            if (GEMEngine.getInstance() != null) {
                GEMEngine.getInstance().startListening(this, false);
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
            beginTransaction.add((int) R.id.gem_footer_view, (Fragment) this.f54944i, getScreenName());
            beginTransaction.commit();
        }
    }

    public /* synthetic */ void onAddMoreItemClicked() {
        a.a(this);
    }

    public void onAuthError() {
    }

    public /* synthetic */ void onBackToCheckoutPage(Dialog dialog) {
        a.b(this, dialog);
    }

    public /* synthetic */ void onBackToRestaurantMenuPage(Dialog dialog) {
        a.c(this, dialog);
    }

    public void onBackToRestaurantPage(Dialog dialog) {
        dialog.dismiss();
        finish();
        Intent intent = new Intent(this, RestaurantsListScreenRefactor.class);
        intent.setFlags(67108864);
        startActivity(intent);
    }

    public void onClick(View view) {
        Restaurant restaurant;
        if (view.getId() == R.id.ll_rate && (restaurant = GlobalDataModel.SELECTED.restaurant) != null && restaurant.shopType == 1) {
            AppTracker.onTabReviewsClicked(this, restaurant);
            startActivity(new Intent(this, RestaurantReviewActivity.class));
        }
    }

    public void onCloseButtonClicked(Dialog dialog) {
        dialog.dismiss();
    }

    public /* synthetic */ void onContinueToCheckout() {
        a.f(this);
    }

    public void onCreate(Bundle bundle) {
        DaggerRestaurantInfoActivityComponent.factory().create((ConfigurationRemoteCoreLibApi) ((ApiContainer) getApplication()).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_restaurant_info);
        this.restaurantReview = GlobalDataModel.REVIEWS.mRestaurantReviews;
        if (getIntent() != null && getIntent().hasExtra(GlobalConstants.ExtraNames.INFO_HERO_IMG)) {
            this.heroCoverImg = getIntent().getStringExtra(GlobalConstants.ExtraNames.INFO_HERO_IMG);
        }
        initializeControls();
    }

    public void onDestroy() {
        super.onDestroy();
        IRestaurantInfoPresenter iRestaurantInfoPresenter = this.mRestaurantInfoPresenter;
        if (iRestaurantInfoPresenter != null) {
            iRestaurantInfoPresenter.onDestroy();
        }
    }

    public void onError() {
    }

    public /* synthetic */ void onInterestClicked(Restaurant restaurant) {
        a.g(this, restaurant);
    }

    public void onLeaveOfferClicked(boolean z11) {
        showHideGemFooter(this.f54944i, this, false);
        if (!GlobalDataModel.GEMCONSTANTS.isGemFlow && GlobalDataModel.GEMCONSTANTS.reloadRequired) {
            GlobalDataModel.GEMCONSTANTS.reloadRequired = false;
        }
    }

    public void onNoRestaurantFound() {
        this.restaurantReview = GlobalDataModel.REVIEWS.mRestaurantReviews;
        initializeControls();
    }

    public void onPause() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            GEMEngine.getInstance();
            GEMEngine.stopListening();
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        showHideGemFooter(this.f54944i, this, false);
        if (!GlobalDataModel.GEMCONSTANTS.isGemFlow && GlobalDataModel.GEMCONSTANTS.reloadRequired) {
            GlobalDataModel.GEMCONSTANTS.reloadRequired = false;
        }
    }

    public void refreshCartCount() {
        Cart instance = Cart.getInstance();
        if (instance.hasItems()) {
            this.cartImage.setImageResource(R.drawable.ic_m_basket_filled);
            this.cartCount.setTextColor(getResources().getColor(R.color.white));
            this.cartCount.setVisibility(0);
            TextView textView = this.cartCount;
            textView.setText("" + instance.getCartCount());
            return;
        }
        this.cartImage.setImageResource(R.drawable.ic_m_basket_empty);
        this.cartCount.setVisibility(8);
    }

    public void setAlternateMunicipalityTaxText(String str) {
        this.municipalityTaxText.setText(str);
    }

    public void setAlternateTalabatChargeText(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 100:
                if (str.equals("d")) {
                    c11 = 0;
                    break;
                }
                break;
            case 115:
                if (str.equals("s")) {
                    c11 = 1;
                    break;
                }
                break;
            case 116:
                if (str.equals("t")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                str = getString(R.string.restaurant_del_charges);
                break;
            case 1:
                str = getString(R.string.service_fee);
                break;
            case 2:
                str = getString(R.string.talabat_charges);
                break;
        }
        this.deliveryChargesText.setText(str);
    }

    public void setAlternateTouristTaxText(String str) {
        this.touristTaxText.setText(str);
    }

    public void setAreaName(String str) {
        this.areaText.setText(str);
    }

    public void setDeliveryCharges() {
        boolean z11;
        if ((this.mRestaurantInfoPresenter.getRestaurant().getDeliveryCharges() > 0.0f || this.mRestaurantInfoPresenter.getRestaurant().talabatCharges > 0.0f) && this.mRestaurantInfoPresenter.getRestaurant().inclusiveVat) {
            z11 = true;
        } else {
            z11 = false;
        }
        String deliveryCharges2 = this.mRestaurantInfoPresenter.getDeliveryCharges();
        float deliveryChargeCompare = this.mRestaurantInfoPresenter.getDeliveryChargeCompare();
        if (z11) {
            deliveryCharges2 = deliveryCharges2 + " " + getString(R.string.inclusive_vat);
        }
        setmTextViewDeliveryCharges(deliveryCharges2, this.mRestaurantInfoPresenter.getRestaurant().isSubscriptionAvailable(), deliveryChargeCompare);
        String alternateDeliveryChargeText = this.mRestaurantInfoPresenter.getAlternateDeliveryChargeText();
        if (!TalabatUtils.isNullOrEmpty(alternateDeliveryChargeText)) {
            setAlternateTalabatChargeText(alternateDeliveryChargeText);
        }
    }

    public void setInfoCoverImage() {
        if (isValidContextForGlide(this)) {
            GlideApp.with((FragmentActivity) this).clear((View) this.mCoverImg);
            GlideApp.with((FragmentActivity) this).load(this.heroCoverImg).centerInside().apply(TalabatGlideModule.requestOptions().transform((Transformation<Bitmap>[]) new Transformation[]{new CenterCrop(), new RoundedCorners(getResources().getDimensionPixelSize(R.dimen.card_corner_radius))})).into(this.mCoverImg);
        }
    }

    public void setMunicipalityTax() {
        boolean municipalityTaxVisibility = this.mRestaurantInfoPresenter.getMunicipalityTaxVisibility();
        this.f54945j = municipalityTaxVisibility;
        if (municipalityTaxVisibility) {
            this.municipalityTaxView.setVisibility(0);
            this.municipalityTaxTextTax.setText(this.mRestaurantInfoPresenter.getMunicipalityTax());
            String alternateMunicipalityTaxText = this.mRestaurantInfoPresenter.getAlternateMunicipalityTaxText();
            if (!TalabatUtils.isNullOrEmpty(alternateMunicipalityTaxText)) {
                setAlternateMunicipalityTaxText(alternateMunicipalityTaxText);
                return;
            }
            return;
        }
        this.municipalityTaxView.setVisibility(8);
    }

    public void setPaymentMethods(boolean z11, boolean z12, boolean z13) {
        if (z12) {
            this.masterCardView.setVisibility(0);
            this.visaView.setVisibility(0);
            if (this.f54947l.walletConfig().isAmexAvailable()) {
                this.americanExpressView.setVisibility(0);
            } else {
                this.americanExpressView.setVisibility(8);
            }
        } else {
            this.masterCardView.setVisibility(8);
            this.visaView.setVisibility(8);
            this.americanExpressView.setVisibility(8);
        }
        if (z13) {
            this.cashView.setVisibility(0);
        } else {
            this.cashView.setVisibility(8);
        }
        if (z11) {
            this.debitCardView.setVisibility(0);
            if (GlobalDataModel.SelectedCountryId == Country.KUWAIT.getCountryId()) {
                this.debitCardView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_m_knet));
            }
            if (GlobalDataModel.SelectedCountryId == Country.BAHRAIN.getCountryId()) {
                this.debitCardView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_icon_bahrainbenefit));
                return;
            }
            return;
        }
        this.debitCardView.setVisibility(8);
    }

    public void setRate(float f11, String str) {
        this.restaurantRatingBar.setRating(f11);
        if (f11 == 0.0f) {
            this.mRatingView.setVisibility(8);
        } else {
            this.mRatingView.setVisibility(0);
            TextView textView = this.restaurantRating;
            String string = getResources().getString(R.string.info_rating_text);
            textView.setText(string.replace(RichContentLoadTimeRecorder.DELIMETER, "" + str));
        }
        ImageView imageView = this.mRatingAvatar;
        RatingDataMapperV2 ratingDataMapperV2 = RatingDataMapperV2.INSTANCE;
        imageView.setImageResource(ratingDataMapperV2.drawableResourceFromRating(f11));
        this.mRatingText.setText(getResources().getString(ratingDataMapperV2.textFromRating(f11)));
    }

    public void setRestaurantInfoViews() {
        if (GlobalDataModel.SELECTED.restaurant.shopType == 1) {
            this.viewRate.setVisibility(0);
            this.titleText.setText(getString(R.string.shop_info_title));
            this.textViewAreaTitle.setText(getString(R.string.shop_area));
        } else {
            this.viewRate.setVisibility(8);
            this.textViewAreaTitle.setText(getString(R.string.restaurant_area));
        }
        setRestaurantLogoimageView(this.mRestaurantInfoPresenter.getRestaurantLogo());
        setInfoCoverImage();
        setmTextViewRestaurantName(this.mRestaurantInfoPresenter.getRestaurantName());
        setRate(this.mRestaurantInfoPresenter.getRate(), this.mRestaurantInfoPresenter.getRateCount());
        setAreaName(this.mRestaurantInfoPresenter.getAreaName());
        setmTextViewCuisines(this.mRestaurantInfoPresenter.getCuisines());
        setWorkingHrs(this.mRestaurantInfoPresenter.getWorkinghrs());
        setmTextViewDeliveryTime(this.mRestaurantInfoPresenter.getDeliveryTime());
        setmTextViewMinimumOrder(this.mRestaurantInfoPresenter.getMinimumOrder());
        setDeliveryCharges();
        setMunicipalityTax();
        setTouristTax();
        setSeparators();
        setPaymentMethods(this.mRestaurantInfoPresenter.isAcceptDebitCard(), this.mRestaurantInfoPresenter.isAcceptCreditCard(), this.mRestaurantInfoPresenter.isAcceptCash());
        setmTextViewPostDatedDelivery(this.mRestaurantInfoPresenter.isPostDatedDelivery());
    }

    public void setRestaurantLogoimageView(String str) {
        if (isValidContextForGlide(this)) {
            GlideApp.with((FragmentActivity) this).clear((View) this.restaurantLogoimageView);
            GlideApp.with((FragmentActivity) this).load(str).centerInside().into(this.restaurantLogoimageView);
        }
    }

    public void setTouristTax() {
        boolean touristTaxVisibility = this.mRestaurantInfoPresenter.getTouristTaxVisibility();
        this.f54946k = touristTaxVisibility;
        if (touristTaxVisibility) {
            this.touristTaxView.setVisibility(0);
            this.touristTaxTax.setText(this.mRestaurantInfoPresenter.getTouristTax());
            String alternateTouristTaxText = this.mRestaurantInfoPresenter.getAlternateTouristTaxText();
            if (!TalabatUtils.isNullOrEmpty(alternateTouristTaxText)) {
                setAlternateTouristTaxText(alternateTouristTaxText);
                return;
            }
            return;
        }
        this.touristTaxView.setVisibility(8);
    }

    public void setWorkingHrs(String str) {
        if (TalabatUtils.isRTL()) {
            this.workingHoursText.setTextDirection(4);
        } else {
            this.workingHoursText.setTextDirection(3);
        }
        this.workingHoursText.setText(str);
    }

    public void setmTextViewCuisines(String str) {
        this.cuisinesText.setText(str);
    }

    public void setmTextViewDeliveryCharges(String str, boolean z11, float f11) {
        this.deliveryCharges.setText(str);
    }

    public void setmTextViewDeliveryTime(String str) {
        this.deliveryTime.setText(str);
    }

    public void setmTextViewMinimumOrder(String str) {
        this.minimumOrderText.setText(str);
    }

    public void setmTextViewPostDatedDelivery(boolean z11) {
        if (z11) {
            this.postDatedDelivery.setText(R.string.yes);
        } else {
            this.postDatedDelivery.setText(R.string.f54880no);
        }
    }

    public void setmTextViewRestaurantName(String str) {
        this.restaurantNameText.setText(str);
    }

    public /* synthetic */ void showGemDialog() {
        v00.a.a(this);
    }

    public void showInAppReminder(int i11) {
        Context context = getContext();
        String string = getResources().getString(R.string.gem_order_notification);
        Toast.makeText(context, string.replace("#", "" + i11), 0).show();
    }

    public void showTimeOutDialog() {
        if (this.mGemDialogSwitcher.isDialogShowing()) {
            onCloseButtonClicked(this.mGemDialogSwitcher.dialog);
        }
        showGemTimeOutDialog(this.mGemDialogSwitcher, this.f54944i, this, this);
    }

    public void showTimerView(boolean z11, String str) {
        this.f54944i.setTimerText(str);
    }

    public /* synthetic */ void stopLoading() {
        v00.a.e(this);
    }
}
