package com.talabat;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import buisnessmodels.Cart;
import buisnessmodels.GEMEngine;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.pay.DaggerPaymentErrorScreenComponent;
import com.talabat.geminterfaces.OnGemAlertDialogClickListener;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import datamodels.Restaurant;
import javax.inject.Inject;
import library.talabat.gemengine.GemView;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.paymenterror.IPaymentErrorPresenter;
import library.talabat.mvp.paymenterror.PaymentErrorPresenter;
import library.talabat.mvp.paymenterror.PaymentErrorView;
import net.bytebuddy.utility.JavaConstant;
import tracking.AppTracker;
import tracking.ScreenNames;
import yq.a;

public class PaymentErrorScreen extends TalabatBase implements PaymentErrorView, GemView, OnGemAlertDialogClickListener {
    public static String ERROR_REASON_MESSAGE_EXTRA = "errorReasonMessage";
    public static final int PAYMENT_METHOD_ERROR = 100;
    private TextView amount;
    private TextView authorizationId;
    private Button backtoCheckout;
    private TextView date;
    private View detailsView;
    private String encryptedTransactionId;
    private TextView errorDescription;
    private TextView errorTitle;
    private LinearLayout gatewayDownContainer;
    private LinearLayout gatewayDownTipsContainer;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public AppVersionProvider f54525i;
    private boolean isFromCheckoutDotCom;
    private boolean isFromVisaCheckout;
    private boolean isGateWayError;
    private boolean isPayforPermissionDeny;
    private GemDialogSwitcher mGemDialogSwitcher;
    private Toolbar mToolbar;
    private LinearLayout paymentDeclinedDetailsContainer;
    private LinearLayout paymentDeclinedTipsContainer;
    private TextView paymentErrorGateWayDownTxt;
    private TextView paymentErrorTitle;
    private TextView paymentId;
    private LinearLayout paymentIdContainer;
    private int paymentMethod;
    private IPaymentErrorPresenter presenter;
    private View progressLayout;
    private TextView referenceId;
    private LinearLayout referenceIdContainer;
    private TextView result;
    private TextView trackId;
    private LinearLayout trackIdContainer;
    private String trackerErrorMessage = "";
    private int trackerPaymentMethod;
    private TextView transactionId;
    private LinearLayout transationIdContainer;

    private void pageTitle(boolean z11) {
        if (z11) {
            this.paymentErrorTitle.setText(getResources().getString(R.string.payment_error_down_title));
        } else {
            this.paymentErrorTitle.setText(getResources().getString(R.string.payment_error_declined_title));
        }
    }

    private void setResult(String str) {
        Intent intent = new Intent();
        intent.putExtra(ERROR_REASON_MESSAGE_EXTRA, str);
        setResult(100, intent);
    }

    public void destroyPresenter() {
        this.presenter = null;
    }

    public void dismissProgressLayout() {
        this.progressLayout.setVisibility(8);
    }

    public Context getGemContext() {
        return this;
    }

    public String getGemScreenType() {
        return ScreenNames.getScreenType(getScreenName());
    }

    public IGlobalPresenter getPresenter() {
        return this.presenter;
    }

    public String getScreenName() {
        return ScreenNames.PAYMENTERRORSCREEN;
    }

    public /* synthetic */ void onAddMoreItemClicked() {
        a.a(this);
    }

    public void onAuthError() {
    }

    public void onBackToCheckoutPage(Dialog dialog) {
        dialog.dismiss();
        this.backtoCheckout.performClick();
    }

    public void onBackToRestaurantMenuPage(Dialog dialog) {
        backToRestaurantMenuPage(dialog, this.mGemDialogSwitcher, "");
    }

    public /* synthetic */ void onBackToRestaurantPage(Dialog dialog) {
        a.d(this, dialog);
    }

    public void onCloseButtonClicked(Dialog dialog) {
        dialog.dismiss();
    }

    public /* synthetic */ void onContinueToCheckout() {
        a.f(this);
    }

    public void onCreate(@Nullable Bundle bundle) {
        DaggerPaymentErrorScreenComponent.factory().create((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.payment_error_new);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setToolbarPadding(this.mToolbar);
            setBackButton(R.id.back);
            this.date = (TextView) findViewById(R.id.knet_payment_date);
            this.amount = (TextView) findViewById(R.id.knet_payment_amount);
            this.result = (TextView) findViewById(R.id.knet_payment_result);
            this.transactionId = (TextView) findViewById(R.id.knet_payment_transaction_id);
            this.authorizationId = (TextView) findViewById(R.id.knet_payment_authorization_id);
            this.trackId = (TextView) findViewById(R.id.knet_payment_track_id);
            this.referenceId = (TextView) findViewById(R.id.knet_payment_reference_id);
            this.paymentId = (TextView) findViewById(R.id.knet_payment_payment_id);
            this.detailsView = findViewById(R.id.detailsView);
            this.errorTitle = (TextView) findViewById(R.id.error_title);
            this.errorDescription = (TextView) findViewById(R.id.payment_error_description);
            this.paymentErrorTitle = (TextView) findViewById(R.id.title);
            this.gatewayDownTipsContainer = (LinearLayout) findViewById(R.id.knet_gateway_down_container);
            this.paymentDeclinedTipsContainer = (LinearLayout) findViewById(R.id.transaction_declined_container);
            this.paymentDeclinedDetailsContainer = (LinearLayout) findViewById(R.id.payment_error_description_container);
            this.paymentErrorGateWayDownTxt = (TextView) findViewById(R.id.payment_error_description_payment_down);
            View findViewById = findViewById(R.id.progress_layout);
            this.progressLayout = findViewById;
            findViewById.setVisibility(0);
            this.presenter = new PaymentErrorPresenter(this.f54525i, this);
            this.isFromCheckoutDotCom = getIntent().getBooleanExtra("isFromCheckoutDotCom", false);
            this.paymentMethod = getIntent().getIntExtra("paymentMethod", 200);
            this.isGateWayError = getIntent().getBooleanExtra("isGateWayError", false);
            this.isPayforPermissionDeny = getIntent().getBooleanExtra("isPayfortPermissionDenined", false);
            this.isFromVisaCheckout = getIntent().getBooleanExtra("isFromVisaCheckout", false);
            pageTitle(this.isGateWayError);
            this.encryptedTransactionId = getIntent().getStringExtra("encryptedTransactionIdError");
            this.presenter.setUpViews(getIntent().getStringExtra("url"), getIntent().getStringExtra("errorSlug"), this.isGateWayError, this.isFromCheckoutDotCom, this.encryptedTransactionId, this.isFromVisaCheckout);
            this.transationIdContainer = (LinearLayout) findViewById(R.id.transation_id_container);
            this.trackIdContainer = (LinearLayout) findViewById(R.id.transation_id_container);
            this.referenceIdContainer = (LinearLayout) findViewById(R.id.reference_id_container);
            this.paymentIdContainer = (LinearLayout) findViewById(R.id.payment_id_container);
            Button button = (Button) findViewById(R.id.knet_payment_back_to_checkout);
            this.backtoCheckout = button;
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AppTracker.backToCheckout(PaymentErrorScreen.this);
                    if (Cart.getInstance() != null) {
                        Cart.getInstance().removeBinDiscountIfApplied();
                    }
                    PaymentErrorScreen.this.finish();
                }
            });
        } catch (Exception unused) {
            finish();
        }
    }

    public void onError() {
    }

    public /* synthetic */ void onInterestClicked(Restaurant restaurant) {
        a.g(this, restaurant);
    }

    public /* synthetic */ void onLeaveOfferClicked(boolean z11) {
        a.h(this, z11);
    }

    public void onPause() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            GEMEngine.getInstance();
            GEMEngine.stopListening();
        }
        super.onPause();
    }

    public void onRedirectToPaymentScreen(String str, int i11) {
        Intent intent = new Intent(this, PaymentWebViewScreen.class);
        intent.putExtra("url", str);
        intent.setFlags(33554432);
        startActivity(intent);
        finish();
    }

    public void onResume() {
        if (GEMEngine.getInstance() != null) {
            GEMEngine.getInstance().startListening(this, true);
        }
        super.onResume();
    }

    public void onStop() {
        super.onStop();
        if (this.isGateWayError) {
            AppTracker.paymentErrorClosed(this, this.trackerPaymentMethod);
        } else {
            AppTracker.paymentFailedClosed(this, this.trackerErrorMessage);
        }
    }

    public void setDetailsVisibility(boolean z11) {
        if (z11) {
            this.detailsView.setVisibility(0);
        } else {
            this.detailsView.setVisibility(8);
        }
    }

    public void setPaymentErrorDescription(boolean z11, String str) {
        CharSequence charSequence;
        String str2;
        pageTitle(z11);
        String string = getResources().getString(R.string.payment_gateway_down_description);
        if (z11) {
            this.errorTitle.setVisibility(0);
            this.paymentDeclinedTipsContainer.setVisibility(8);
            this.gatewayDownTipsContainer.setVisibility(0);
            this.paymentDeclinedDetailsContainer.setVisibility(8);
            this.errorTitle.setText(getResources().getString(R.string.payment_gateway_down_error_title));
            this.paymentErrorGateWayDownTxt.setVisibility(0);
            int i11 = this.paymentMethod;
            if (i11 == 1) {
                if (GlobalDataModel.SelectedCountryId == Country.KUWAIT.getCountryId()) {
                    str2 = getResources().getString(R.string.knet);
                } else if (GlobalDataModel.SelectedCountryId == Country.BAHRAIN.getCountryId()) {
                    str2 = getResources().getString(R.string.benefit);
                } else if (GlobalDataModel.SelectedCountryId != Country.KSA.getCountryId()) {
                    str2 = getResources().getString(R.string.debit_card);
                } else if (this.paymentMethod == 2) {
                    str2 = getResources().getString(R.string.credit_card);
                }
                charSequence = string.replace("###", str2);
                this.paymentErrorGateWayDownTxt.setText(charSequence);
                int i12 = this.paymentMethod;
                this.trackerPaymentMethod = i12;
                AppTracker.paymentErrorShown(this, i12, str, str2.toLowerCase().replace(" ", JavaConstant.Dynamic.DEFAULT_NAME));
            } else if (i11 == 2) {
                str2 = getResources().getString(R.string.credit_card);
                charSequence = string.replace("###", str2);
                this.paymentErrorGateWayDownTxt.setText(charSequence);
                int i122 = this.paymentMethod;
                this.trackerPaymentMethod = i122;
                AppTracker.paymentErrorShown(this, i122, str, str2.toLowerCase().replace(" ", JavaConstant.Dynamic.DEFAULT_NAME));
            }
            str2 = "";
            charSequence = string.replace("###", str2);
            this.paymentErrorGateWayDownTxt.setText(charSequence);
            int i1222 = this.paymentMethod;
            this.trackerPaymentMethod = i1222;
            AppTracker.paymentErrorShown(this, i1222, str, str2.toLowerCase().replace(" ", JavaConstant.Dynamic.DEFAULT_NAME));
        } else {
            this.paymentDeclinedTipsContainer.setVisibility(0);
            this.gatewayDownTipsContainer.setVisibility(8);
            this.paymentDeclinedDetailsContainer.setVisibility(0);
            this.paymentErrorGateWayDownTxt.setVisibility(8);
            if (this.isFromCheckoutDotCom) {
                this.trackerErrorMessage = str;
                this.errorTitle.setVisibility(0);
                this.errorTitle.setText(R.string.transaction_declined_title_new);
                this.errorDescription.setText(this.trackerErrorMessage);
            } else {
                this.trackerErrorMessage = str;
                this.errorTitle.setVisibility(0);
                this.errorTitle.setText(R.string.transaction_declined_title_new);
                if (!TalabatUtils.isNullOrEmpty(str)) {
                    this.errorDescription.setText(str);
                } else {
                    this.errorDescription.setText(R.string.make_sure_card_not_expired);
                }
            }
            AppTracker.paymentFailedShown(this, this.trackerErrorMessage);
            charSequence = this.errorDescription.getText();
        }
        if (TalabatUtils.isNullOrEmpty(str)) {
            if (charSequence != null) {
                str = charSequence.toString();
            } else {
                str = "";
            }
        }
        setResult(str);
    }

    public void setTransactionAmount(String str) {
        this.amount.setText(str);
    }

    public void setTransactionAuthID(String str) {
        this.authorizationId.setText(str);
    }

    public void setTransactionDate(String str) {
        this.date.setText(str);
    }

    public void setTransactionID(String str) {
        if (!TalabatUtils.isNullOrEmpty(str)) {
            this.transationIdContainer.setVisibility(0);
            this.transactionId.setText(str);
            return;
        }
        this.transationIdContainer.setVisibility(8);
    }

    public void setTransactionPaymentID(String str) {
        if (!TalabatUtils.isNullOrEmpty(str)) {
            this.paymentIdContainer.setVisibility(0);
            this.paymentId.setText(str);
            return;
        }
        this.paymentIdContainer.setVisibility(8);
    }

    public void setTransactionReferenceID(String str) {
        if (!TalabatUtils.isNullOrEmpty(str)) {
            this.referenceIdContainer.setVisibility(0);
            this.referenceId.setText(str);
            return;
        }
        this.referenceIdContainer.setVisibility(8);
    }

    public void setTransactionResult(String str) {
        this.result.setText(str);
    }

    public void setTransactionTrackID(String str) {
        if (!TalabatUtils.isNullOrEmpty(str)) {
            this.trackIdContainer.setVisibility(0);
            this.trackId.setText(str);
            return;
        }
        this.trackIdContainer.setVisibility(8);
    }

    public /* synthetic */ void showGemDialog() {
        v00.a.a(this);
    }

    public /* synthetic */ void showInAppReminder(int i11) {
        v00.a.b(this, i11);
    }

    public void showTimeOutDialog() {
        if (GEMEngine.getInstance().getCurrentGemIndex() > 0) {
            showGemTimeOutDialog((GemDialogSwitcher) null, (GemFooterCartView) null, this, this);
        }
    }

    public /* synthetic */ void showTimerView(boolean z11, String str) {
        v00.a.d(this, z11, str);
    }

    public /* synthetic */ void stopLoading() {
        v00.a.e(this);
    }
}
