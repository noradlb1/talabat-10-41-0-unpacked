package com.talabat;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import buisnessmodels.Cart;
import buisnessmodels.GEMEngine;
import com.talabat.checkoutdotcom.CheckoutTokenScreen;
import com.talabat.configuration.country.Country;
import com.talabat.geminterfaces.OnGemAlertDialogClickListener;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import datamodels.Restaurant;
import library.talabat.gemengine.GemView;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.paymentwebview.IPaymentWebViewPresenter;
import library.talabat.mvp.paymentwebview.PaymentWebView;
import library.talabat.mvp.paymentwebview.PaymentWebViewPresenter;
import tracking.ScreenNames;
import yq.a;

public class PaymentWebViewScreen extends TalabatBase implements PaymentWebView, GemView, OnGemAlertDialogClickListener {
    private ImageButton backButton;

    /* renamed from: i  reason: collision with root package name */
    public GemFooterCartView f54527i;
    private boolean isCreditCard;
    /* access modifiers changed from: private */
    public boolean isFromCheckout = false;
    private boolean isFromVisaCheckout;
    /* access modifiers changed from: private */
    public boolean isTimedOut;
    /* access modifiers changed from: private */
    public boolean loadingFinished = true;
    private GemDialogSwitcher mGemDialogSwitcher;
    private Toolbar mToolbar;
    public WebView mwebview;
    private String pageTitle;
    /* access modifiers changed from: private */
    public IPaymentWebViewPresenter presenter;
    /* access modifiers changed from: private */
    public boolean redirect = false;
    private String transactionIdConfirm;
    private String url;
    private ProgressBar webview_progress;

    public class PaymentWebviewClient extends WebViewClient {
        private PaymentWebviewClient() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!PaymentWebViewScreen.this.redirect) {
                PaymentWebViewScreen.this.loadingFinished = true;
            }
            if (!PaymentWebViewScreen.this.loadingFinished || PaymentWebViewScreen.this.redirect) {
                PaymentWebViewScreen.this.redirect = false;
            } else {
                PaymentWebViewScreen.this.dismissProgressBarOnView();
            }
            PaymentWebViewScreen.this.mwebview.setVisibility(0);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            webView.clearCache(false);
            super.onPageStarted(webView, str, bitmap);
            PaymentWebViewScreen.this.loadingFinished = false;
            PaymentWebViewScreen.this.isTimedOut = false;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!PaymentWebViewScreen.this.loadingFinished) {
                PaymentWebViewScreen.this.redirect = true;
            }
            PaymentWebViewScreen.this.loadingFinished = false;
            webView.loadUrl(str);
            if (PaymentWebViewScreen.this.presenter != null) {
                PaymentWebViewScreen.this.presenter.onUrlChanged(str);
            }
            return true;
        }
    }

    public class PaymentWebviewClientForOmanNet extends WebViewClient {
        private PaymentWebviewClientForOmanNet() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            PaymentWebViewScreen.this.dismissProgressBarOnView();
            PaymentWebViewScreen.this.mwebview.setVisibility(0);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            webView.clearCache(false);
            super.onPageStarted(webView, str, bitmap);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (PaymentWebViewScreen.this.presenter == null) {
                return false;
            }
            PaymentWebViewScreen.this.presenter.onUrlChanged(str);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void goToCheckoutPage() {
        String str = "";
        CheckoutTokenScreen.binNumber = str;
        Cart.getInstance().removeBinDiscountIfApplied();
        Cart.getInstance().recalcualteTotal();
        Intent intent = new Intent(this, CheckOutScreen.class);
        intent.putExtra("map_compulsory", getIntent().getBooleanExtra("map_compulsory", false));
        intent.putExtra("nineCookiesEnabled", getIntent().getBooleanExtra("nineCookiesEnabled", false));
        intent.putExtra("isAddressFromCartOrderFlow", getIntent().getBooleanExtra("isAddressFromCartOrderFlow", false));
        intent.putExtra("talabatDeliveryAvailable", getIntent().getBooleanExtra("talabatDeliveryAvailable", false));
        intent.putExtra("newaddressCreation", getIntent().getBooleanExtra("newaddressCreation", false));
        intent.putExtra(GlobalConstants.FORCE_MAP.CHECKOUT_SUCCESS, getIntent().getBooleanExtra(GlobalConstants.FORCE_MAP.CHECKOUT_SUCCESS, false));
        intent.putExtra("isFromAptimize", getIntent().getBooleanExtra("isFromAptimize", false));
        intent.putExtra("isGlrEnabledRes", getIntent().getBooleanExtra("isGlrEnabledRes", false));
        intent.putExtra("isNewAddressCreationFromGrlFlow", getIntent().getBooleanExtra("isNewAddressCreationFromGrlFlow", false));
        intent.putExtra("isQuick", getIntent().getBooleanExtra("isQuick", false));
        if (getIntent().hasExtra("value")) {
            str = getIntent().getStringExtra("value");
        }
        intent.putExtra("value", str);
        intent.putExtra("appendedName", getIntent().getStringExtra("appendedName"));
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    private void killCart() {
        sendBroadcast(new Intent(GlobalConstants.BROADCAST_KILL_CART));
    }

    private void killMenuScreen() {
        sendBroadcast(new Intent(GlobalConstants.BROADCAST_KILL_MENU));
    }

    public void destroyPresenter() {
        this.presenter = null;
    }

    public void dismissLoadingPopup() {
    }

    public void dismissProgressBarOnView() {
        this.webview_progress.setVisibility(8);
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
        return ScreenNames.PAYMENT_WEBVIEW_SCREEN;
    }

    public void inflateGemFooter() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow && GEMEngine.getInstance() != null) {
            GEMEngine.getInstance().startListening(this, true);
        }
    }

    public /* synthetic */ void onAddMoreItemClicked() {
        a.a(this);
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        if (this.isFromCheckout) {
            this.backButton.performClick();
        } else if (this.mwebview.canGoBack()) {
            this.mwebview.goBack();
        }
    }

    public void onBackToCheckoutPage(Dialog dialog) {
        dialog.dismiss();
        finish();
    }

    public void onBackToRestaurantMenuPage(Dialog dialog) {
        finish();
        Intent intent = new Intent();
        Restaurant restaurant = GlobalDataModel.SELECTED.restaurant;
        if (restaurant != null) {
            if (restaurant.shopType == 1) {
                intent = new Intent(this, GroceryMenuScreen.class);
            } else {
                intent = new Intent(this, RestaurantMenuScreenR.class);
            }
        }
        intent.setFlags(67108864);
        startActivity(intent);
    }

    public void onBackToRestaurantPage(Dialog dialog) {
    }

    public void onCloseButtonClicked(Dialog dialog) {
        dialog.dismiss();
    }

    public /* synthetic */ void onContinueToCheckout() {
        a.f(this);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(8192, 8192);
        setContentView((int) R.layout.paymentwebview);
        if (Build.VERSION.SDK_INT > 23) {
            TalabatUtils.changeLocale(this, GlobalDataModel.SelectedLanguage);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.mToolbar = toolbar;
        setSupportActionBar(toolbar);
        this.mwebview = (WebView) findViewById(R.id.webview);
        this.webview_progress = (ProgressBar) findViewById(R.id.webview_progress);
        this.isCreditCard = getIntent().getBooleanExtra("isCreditCard", false);
        this.isFromVisaCheckout = getIntent().getBooleanExtra("isFromVisaCheckout", false);
        this.url = getIntent().getStringExtra("url");
        this.mwebview.getSettings().setJavaScriptEnabled(true);
        String stringExtra = getIntent().getStringExtra("title");
        if (TalabatUtils.isNullOrEmpty(stringExtra)) {
            stringExtra = "";
        }
        this.pageTitle = stringExtra;
        setTitle(R.id.title, stringExtra);
        this.transactionIdConfirm = getIntent().getStringExtra("paymenttransactionId");
        this.isFromCheckout = getIntent().getBooleanExtra("isFromCheckout", false);
        ImageButton imageButton = (ImageButton) findViewById(R.id.back);
        this.backButton = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (PaymentWebViewScreen.this.isFromCheckout) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(PaymentWebViewScreen.this, R.style.AlertDialogTheme);
                    builder.create().requestWindowFeature(1);
                    builder.setTitle((CharSequence) null);
                    builder.setMessage((CharSequence) PaymentWebViewScreen.this.getResources().getString(R.string.pf_cancel_payment_msg));
                    builder.setPositiveButton((CharSequence) PaymentWebViewScreen.this.getResources().getString(R.string.yes), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i11) {
                            PaymentWebViewScreen.this.goToCheckoutPage();
                        }
                    });
                    builder.setNegativeButton((CharSequence) PaymentWebViewScreen.this.getResources().getString(R.string.f54880no), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i11) {
                            dialogInterface.dismiss();
                        }
                    });
                    builder.setCancelable(false);
                    builder.show();
                    return;
                }
                PaymentWebViewScreen.this.finish();
            }
        });
        this.mwebview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.mwebview.getSettings().setCacheMode(2);
        this.mwebview.setLayerType(1, (Paint) null);
        if (bundle != null) {
            this.mwebview.restoreState(bundle);
        }
        PaymentWebViewPresenter paymentWebViewPresenter = new PaymentWebViewPresenter(this);
        this.presenter = paymentWebViewPresenter;
        paymentWebViewPresenter.setUpViews(this.url);
        this.presenter.setTransatcionId(this.transactionIdConfirm);
        if (GlobalDataModel.SelectedCountryId == Country.OMAN.getCountryId()) {
            this.mwebview.setWebViewClient(new PaymentWebviewClientForOmanNet());
        } else {
            this.mwebview.setWebViewClient(new PaymentWebviewClient());
        }
        inflateGemFooter();
    }

    public void onError() {
    }

    public /* synthetic */ void onInterestClicked(Restaurant restaurant) {
        a.g(this, restaurant);
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (i11 != 4 || !this.mwebview.canGoBack()) {
            return super.onKeyDown(i11, keyEvent);
        }
        this.mwebview.goBack();
        return true;
    }

    public /* synthetic */ void onLeaveOfferClicked(boolean z11) {
        a.h(this, z11);
    }

    public void onNavigationToGiftVoucherThankyouPage() {
        setResult(-1);
        finish();
    }

    public void onNavigationToOrderThankyouPage() {
        killCart();
        killMenuScreen();
        setResult(-1);
        finish();
    }

    public void onNavigationToPaymentError(String str, int i11, boolean z11, String str2) {
        Intent intent = new Intent(this, PaymentErrorScreen.class);
        intent.putExtra("url", str);
        intent.putExtra("isGateWayError", z11);
        intent.putExtra("paymentMethod", i11);
        intent.putExtra("isFromVisaCheckout", this.isFromVisaCheckout);
        if (!TalabatUtils.isNullOrEmpty(str2)) {
            intent.putExtra("errorSlug", str2);
        }
        if (this.isFromVisaCheckout) {
            intent.putExtra("encryptedTransactionIdError", this.transactionIdConfirm);
        }
        intent.setFlags(33554432);
        startActivity(intent);
        finish();
    }

    public void onNavigationToTalabatCreditThankyouPage() {
        setResult(-1);
        finish();
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
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mwebview.saveState(bundle);
    }

    public void onStop() {
        boolean z11 = GlobalDataModel.GEMCONSTANTS.isGemFlow;
        super.onStop();
    }

    public void setPaymentUrl(String str) {
        this.mwebview.loadUrl(str);
    }

    public /* synthetic */ void showGemDialog() {
        v00.a.a(this);
    }

    public /* synthetic */ void showInAppReminder(int i11) {
        v00.a.b(this, i11);
    }

    public void showTimeOutDialog() {
        if (GEMEngine.getInstance().getCurrentGemIndex() > 0) {
            showGemTimeOutDialog(this.mGemDialogSwitcher, this.f54527i, this, this);
        }
    }

    public /* synthetic */ void showTimerView(boolean z11, String str) {
        v00.a.d(this, z11, str);
    }

    public /* synthetic */ void stopLoading() {
        v00.a.e(this);
    }
}
