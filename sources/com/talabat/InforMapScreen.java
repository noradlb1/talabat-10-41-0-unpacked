package com.talabat;

import JsonModels.Response.InforMapAddressResponse;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import buisnessmodels.McdMapTempAddress;
import buisnessmodels.ShowCaseViewLogic;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.Area;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.map.DaggerInforMapScreenComponent;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.home.HomeScreenActivity;
import com.talabat.observability.ObservabilityManager;
import com.talabat.talabatcore.logger.LogManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.informap.IInforMapPresenter;
import library.talabat.mvp.informap.InforMapWebView;
import library.talabat.mvp.informap.InforMapWebViewPresenter;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import tracking.AppTracker;
import tracking.ScreenNames;
import ue.g9;
import ue.h9;
import ue.i9;

public class InforMapScreen extends TalabatBase implements InforMapWebView {
    public static final String URL = "https://www.grl.ae/apa_talabat_v2/genericAndroid.html";
    private ImageButton back;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public AppVersionProvider f54209i;
    /* access modifiers changed from: private */
    public boolean isFromReorder;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    public LocationConfigurationRepository f54210j;
    /* access modifiers changed from: private */
    public boolean loadingFinished = true;
    private Toolbar mToolbar;
    public WebView mwebview;
    /* access modifiers changed from: private */
    public IInforMapPresenter presenter;
    /* access modifiers changed from: private */
    public boolean redirect = false;
    /* access modifiers changed from: private */
    public int restaurantID = -1;
    private String restaurantName;
    /* access modifiers changed from: private */
    public int selectedAreaId;
    private String selectedAreaNameForUserGuide = null;
    private View showCaseView;
    private TextView tapHere;
    public Toast toast = null;
    private TextView userGuideText;
    private ProgressBar webview_progress;

    @Instrumented
    public class WebAppInterface {

        /* renamed from: a  reason: collision with root package name */
        public Context f54212a;

        public WebAppInterface(Context context) {
            this.f54212a = context;
        }

        @JavascriptInterface
        public String getInitApaFrameJsonMessage() {
            Integer num;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("RequestID", Math.floor((Math.random() * 20.0d) + 1.0d));
                jSONObject.put("MessageType", 1);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("AddressElementTypeCode", 1);
                jSONObject2.put("Value", (Object) InforMapScreen.this.getCityNameToRedirect());
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("AddressElementTypeCode", 2);
                int i11 = GlobalDataModel.SelectedAreaId;
                if (i11 > 0) {
                    num = Integer.valueOf(i11);
                } else {
                    num = "";
                }
                jSONObject3.put("Value", (Object) num);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("AddressElementTypeCode", 3);
                jSONObject4.put("Value", (Object) "");
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("AddressElementTypeCode", 4);
                jSONObject5.put("Value", (Object) "");
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("AddressElementTypeCode", 5);
                jSONObject6.put("Value", (Object) "");
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("AddressElementTypeCode", 6);
                jSONObject7.put("Value", (Object) "");
                JSONObject jSONObject8 = new JSONObject();
                jSONObject8.put("AddressElementTypeCode", 7);
                jSONObject8.put("Value", (Object) "");
                JSONObject jSONObject9 = new JSONObject();
                jSONObject9.put("AddressElementTypeCode", 8);
                jSONObject9.put("Value", (Object) "");
                JSONObject jSONObject10 = new JSONObject();
                jSONObject9.put("AddressElementTypeCode", 9);
                jSONObject9.put("Value", (Object) "");
                JSONObject jSONObject11 = new JSONObject();
                jSONObject9.put("AddressElementTypeCode", 10);
                jSONObject9.put("Value", (Object) "");
                JSONArray jSONArray = new JSONArray();
                jSONArray.put((Object) jSONObject2);
                jSONArray.put((Object) jSONObject3);
                jSONArray.put((Object) jSONObject4);
                jSONArray.put((Object) jSONObject5);
                jSONArray.put((Object) jSONObject6);
                jSONArray.put((Object) jSONObject7);
                jSONArray.put((Object) jSONObject8);
                jSONArray.put((Object) jSONObject9);
                jSONArray.put((Object) jSONObject10);
                jSONArray.put((Object) jSONObject11);
                jSONObject.put("AddressElements", (Object) jSONArray);
            } catch (Exception e11) {
                LogManager.logException(e11);
            }
            LogManager.debug("data received: getInitApaFrameJsonMessage: " + JSONObjectInstrumentation.toString(jSONObject));
            return JSONObjectInstrumentation.toString(jSONObject);
        }

        @JavascriptInterface
        public void pushApaJsonMessage(String str) {
            Log.e("informap", "pushApaJsonMessage: " + str);
            InforMapScreen.this.showLoadingPopup();
            InforMapScreen.this.presenter.informapAddressReceived(str, InforMapScreen.this.isFromReorder, InforMapScreen.this.restaurantID, InforMapScreen.this.selectedAreaId);
        }
    }

    @NotNull
    private Map<String, String> createCommonAttributesForTracking() {
        HashMap hashMap = new HashMap();
        hashMap.put("selectedCountryId", "" + GlobalDataModel.SelectedCountryId);
        hashMap.put("isFromReOrder", Boolean.toString(this.isFromReorder));
        hashMap.put("restaurantID", "" + this.restaurantID);
        hashMap.put(GlobalConstants.ExtraNames.SELECTED_AREA_ID, "" + this.selectedAreaId);
        hashMap.put("restaurantName", this.restaurantName);
        return hashMap;
    }

    private String getAreaName(int i11) {
        List<Area> areas = this.f54210j.areas();
        if (areas == null) {
            return "";
        }
        for (Area next : areas) {
            if (next.getId() == i11) {
                String areaName = next.getAreaName();
                this.selectedAreaNameForUserGuide = areaName;
                return areaName;
            }
        }
        return "";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        if (getIntent().getBooleanExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, false)) {
            startActivity(new Intent(this, HomeScreenActivity.class));
        }
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        this.showCaseView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void trackOnReceivedError(int i11, String str) {
        Map<String, String> createCommonAttributesForTracking = createCommonAttributesForTracking();
        createCommonAttributesForTracking.put("errorCode", "" + i11);
        createCommonAttributesForTracking.put("description", str);
        ObservabilityManager.trackUnExpectedScenario("InforMapOnReceivedError", createCommonAttributesForTracking);
    }

    /* access modifiers changed from: private */
    public void trackOnReceivedErrorWithUrl(int i11, String str, String str2) {
        Map<String, String> createCommonAttributesForTracking = createCommonAttributesForTracking();
        createCommonAttributesForTracking.put("errorCode", "" + i11);
        createCommonAttributesForTracking.put("description", str);
        createCommonAttributesForTracking.put("failingUrl", str2);
        ObservabilityManager.trackUnExpectedScenario("InforMapOnReceivedErrorWithUrl", createCommonAttributesForTracking);
    }

    /* access modifiers changed from: private */
    public void trackOnReceivedHttpError(String str, int i11) {
        Map<String, String> createCommonAttributesForTracking = createCommonAttributesForTracking();
        createCommonAttributesForTracking.put("url", str);
        createCommonAttributesForTracking.put("statusCode", "" + i11);
        ObservabilityManager.trackUnExpectedScenario("InforMapOnReceivedHttpError", createCommonAttributesForTracking);
    }

    /* access modifiers changed from: private */
    public void trackOnReceivedSslError(String str) {
        Map<String, String> createCommonAttributesForTracking = createCommonAttributesForTracking();
        createCommonAttributesForTracking.put("error", str);
        ObservabilityManager.trackUnExpectedScenario("InforMapOnReceivedSslError", createCommonAttributesForTracking);
    }

    private void trackScreenOnCreateError(Exception exc) {
        Map<String, String> createCommonAttributesForTracking = createCommonAttributesForTracking();
        createCommonAttributesForTracking.put("errorMessage", exc.getMessage());
        ObservabilityManager.trackUnExpectedScenario("InforMapScreenOnCreateError", createCommonAttributesForTracking);
    }

    public void destroyPresenter() {
        this.presenter = null;
    }

    public void dismissProgressBarOnView() {
        this.webview_progress.setVisibility(8);
    }

    public String getCityNameToRedirect() {
        int i11 = -1;
        for (Area next : this.f54210j.areas()) {
            if (next.getId() == GlobalDataModel.SelectedAreaId) {
                i11 = next.getCityId();
                Log.e("global", "area" + i11);
            }
        }
        if (i11 == 35) {
            return "Dubai";
        }
        if (i11 == 96) {
            return "Fujairah";
        }
        if (i11 == 43) {
            return "Abu Dhabi";
        }
        if (i11 == 44) {
            return "Sharjah";
        }
        switch (i11) {
            case 48:
                return "Ras Al Khaima";
            case 49:
                return "Al Ain";
            case 50:
                return "Ajman";
            default:
                return "";
        }
    }

    public Context getContext() {
        return this;
    }

    public IGlobalPresenter getPresenter() {
        return this.presenter;
    }

    public String getScreenName() {
        return ScreenNames.INFOR_MAP_SCREEN;
    }

    public void infoMapConvertedAddressFailed() {
    }

    public void infoMapConvertedAddressReceived(InforMapAddressResponse inforMapAddressResponse) {
        stopLodingPopup();
        McdMapTempAddress instance = McdMapTempAddress.getInstance();
        instance.setSelectedTempGrlAddress(inforMapAddressResponse.infoAddress);
        if (!TalabatUtils.isNullOrEmpty(inforMapAddressResponse.McdBranchId)) {
            instance.setSelectedGrlBranchId(inforMapAddressResponse.McdBranchId);
        }
        Intent intent = new Intent();
        intent.putExtra(GlobalConstants.INFOR_MAP.INFORMAP_GLR_ID, inforMapAddressResponse.infoAddress.getGrlId());
        intent.putExtra(GlobalConstants.INFOR_MAP.TB_BRANCH_ID_MENU, inforMapAddressResponse.talabatResBranchId);
        intent.putExtra(GlobalConstants.INFOR_MAP.MCD_BRANCH_ID_MENU, inforMapAddressResponse.McdBranchId);
        intent.putExtra("isFromMcdAddressFlow", true);
        setResult(-1, intent);
        finish();
    }

    public void onAreaMismatched(String str, String str2) {
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        if (TalabatUtils.isNullOrEmpty(str2)) {
            str2 = getResources().getString(R.string.info_location_mis_match);
        }
        builder.setTitle((CharSequence) str2).setMessage((CharSequence) str.replace(RichContentLoadTimeRecorder.DELIMETER, GlobalDataModel.SelectedAreaName)).setNeutralButton((int) R.string.close_dialog, (DialogInterface.OnClickListener) null).create().show();
        AppTracker.onInformapAreaMismatchShown(this);
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        this.back.performClick();
    }

    public void onCreate(@Nullable Bundle bundle) {
        DaggerInforMapScreenComponent.factory().create((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        try {
            setContentView((int) R.layout.informap_web_screen);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            ImageButton imageButton = (ImageButton) findViewById(R.id.webview_back);
            this.back = imageButton;
            imageButton.setOnClickListener(new g9(this));
            this.mwebview = (WebView) findViewById(R.id.webview);
            this.webview_progress = (ProgressBar) findViewById(R.id.webview_progress);
            this.isFromReorder = getIntent().getBooleanExtra(GlobalConstants.INFOR_MAP.IS_FROM_REORDER_FLOW, false);
            this.restaurantID = getIntent().getIntExtra(GlobalConstants.INFOR_MAP.RESTAURANT_ID, -1);
            this.selectedAreaId = getIntent().getIntExtra(GlobalConstants.INFOR_MAP.INFORMAP_SELECTED_AREA_ID, -1);
            this.restaurantName = getIntent().getStringExtra(GlobalConstants.INFOR_MAP.RESTAURANT_NAME);
            this.mwebview.setLayerType(1, (Paint) null);
            if (bundle != null) {
                this.mwebview.restoreState(bundle);
            }
            this.mwebview.setOnTouchListener(new h9());
            this.showCaseView = findViewById(R.id.show_case_view);
            this.tapHere = (TextView) findViewById(R.id.tap_here);
            this.userGuideText = (TextView) findViewById(R.id.text_user_guide);
            if (ShowCaseViewLogic.getInstance().showInformap()) {
                int i11 = this.selectedAreaId;
                if (i11 > 0) {
                    this.selectedAreaNameForUserGuide = getAreaName(i11);
                }
                TextView textView = this.userGuideText;
                String string = getResources().getString(R.string.informap_userguide_new_content);
                textView.setText(Html.fromHtml(string.replace(RichContentLoadTimeRecorder.DELIMETER, "<b>" + this.selectedAreaNameForUserGuide + "</b>").replace("$$", this.restaurantName)));
                this.showCaseView.setVisibility(0);
                ShowCaseViewLogic.getInstance().setInformap();
                ShowCaseViewLogic.getInstance().saveToPrefs(this);
            }
            this.tapHere.setOnClickListener(new i9(this));
            this.mwebview.getSettings().setJavaScriptEnabled(true);
            this.mwebview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.mwebview.getSettings().setAllowContentAccess(true);
            this.mwebview.getSettings().setMixedContentMode(0);
            this.mwebview.getSettings().setDomStorageEnabled(true);
            this.mwebview.addJavascriptInterface(new WebAppInterface(this), "AddressInterface");
            this.mwebview.setWebViewClient(new InforWebviewClient());
            InforMapWebViewPresenter inforMapWebViewPresenter = new InforMapWebViewPresenter(this.f54209i, this);
            this.presenter = inforMapWebViewPresenter;
            inforMapWebViewPresenter.setUpViews(URL);
            AppTracker.onMcdMapShown(this);
        } catch (Exception e11) {
            LogManager.logException(e11);
            trackScreenOnCreateError(e11);
        }
    }

    public void onError() {
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mwebview.saveState(bundle);
    }

    public void onStop() {
        AppTracker.onMcdMapClosed(this);
        super.onStop();
    }

    public void setInformMapUrl(String str) {
        this.mwebview.loadUrl(str);
    }

    public void showLoadingPopup() {
        startLodingPopup();
    }

    public class InforWebviewClient extends WebViewClient {
        private InforWebviewClient() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!InforMapScreen.this.redirect) {
                InforMapScreen.this.loadingFinished = true;
            }
            if (!InforMapScreen.this.loadingFinished || InforMapScreen.this.redirect) {
                InforMapScreen.this.redirect = false;
            } else {
                InforMapScreen.this.dismissProgressBarOnView();
            }
            InforMapScreen.this.mwebview.setVisibility(0);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            webView.clearCache(false);
            super.onPageStarted(webView, str, bitmap);
            InforMapScreen.this.loadingFinished = false;
        }

        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            super.onReceivedError(webView, i11, str, str2);
            InforMapScreen.this.trackOnReceivedErrorWithUrl(i11, str, str2);
        }

        @RequiresApi(api = 21)
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            InforMapScreen.this.trackOnReceivedHttpError(webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            InforMapScreen.this.trackOnReceivedSslError(sslError.toString());
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!InforMapScreen.this.loadingFinished) {
                InforMapScreen.this.redirect = true;
            }
            InforMapScreen.this.loadingFinished = false;
            webView.loadUrl(str);
            if (InforMapScreen.this.presenter != null) {
                InforMapScreen.this.presenter.onUrlChanged(str);
            }
            return true;
        }

        @RequiresApi(api = 23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            InforMapScreen.this.trackOnReceivedError(webResourceError.getErrorCode(), webResourceError.getDescription().toString());
        }
    }
}
