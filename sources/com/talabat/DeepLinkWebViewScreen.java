package com.talabat;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.browser.customtabs.CustomTabsIntent;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.DaggerDeepLinkWebViewScreenComponent;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.home.HomeScreenActivity;
import com.talabat.sidemenu.SideMenuPresenter;
import javax.inject.Inject;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.twebview.ITWebViewPresenter;
import library.talabat.mvp.twebview.TWebViewPresenter;
import library.talabat.mvp.twebview.TWebview;
import tracking.ScreenNames;

public class DeepLinkWebViewScreen extends TalabatBase implements TWebview {
    private static final int CUSTOM_TAB_PERMISSION_REQUEST_CODE = 3001;
    private static final String RESET_PASSWORD = "reset-password";
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public ConfigurationLocalRepository f54012i;
    private String initialUrl;
    /* access modifiers changed from: private */
    public boolean isTimedOut;
    private boolean isWebSurveyRedirection;
    /* access modifiers changed from: private */
    public boolean isresetpassword;

    /* renamed from: j  reason: collision with root package name */
    public String f54013j = "";
    /* access modifiers changed from: private */
    public boolean loadingFinished = true;
    private LinearLayout mMainLayout;
    private Toolbar mToolbar;
    private ITWebViewPresenter presenter;
    /* access modifiers changed from: private */
    public boolean redirect = false;
    private TextView title;
    /* access modifiers changed from: private */
    public WebView webView;
    /* access modifiers changed from: private */
    public ProgressBar webviewProgress;

    public class TalabatWc extends WebViewClient {
        private TalabatWc() {
        }

        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }

        public void onPageFinished(WebView webView, String str) {
            DeepLinkWebViewScreen.this.webView.setVisibility(0);
            if (!DeepLinkWebViewScreen.this.redirect) {
                DeepLinkWebViewScreen.this.loadingFinished = true;
            }
            if (!DeepLinkWebViewScreen.this.loadingFinished || DeepLinkWebViewScreen.this.redirect) {
                DeepLinkWebViewScreen.this.redirect = false;
            } else {
                DeepLinkWebViewScreen.this.webviewProgress.setVisibility(8);
            }
            DeepLinkWebViewScreen.this.webView.setVisibility(0);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            webView.clearCache(false);
            super.onPageStarted(webView, str, bitmap);
            DeepLinkWebViewScreen.this.loadingFinished = false;
            DeepLinkWebViewScreen.this.isTimedOut = false;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!DeepLinkWebViewScreen.this.loadingFinished) {
                DeepLinkWebViewScreen.this.redirect = true;
            }
            DeepLinkWebViewScreen.this.loadingFinished = false;
            if (DeepLinkWebViewScreen.this.isresetpassword) {
                if (!str.contains(DeepLinkWebViewScreen.RESET_PASSWORD)) {
                    DeepLinkWebViewScreen.this.startActivity(new Intent(DeepLinkWebViewScreen.this, LoginScreen.class));
                    DeepLinkWebViewScreen.this.finish();
                }
            } else if (!str.startsWith("http:") && !str.startsWith("https:")) {
                if (str.startsWith("tel:")) {
                    try {
                        Intent intent = new Intent("android.intent.action.DIAL");
                        intent.setData(Uri.parse(str));
                        DeepLinkWebViewScreen.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                    }
                    return true;
                } else if (str.startsWith("talabat:")) {
                    if (!TalabatUtils.isNullOrEmpty(str)) {
                        Uri parse = Uri.parse(str);
                        DeepLinkWebViewScreen.this.disableBrandMenu(true);
                        DeepLinkWebViewScreen deepLinkWebViewScreen = DeepLinkWebViewScreen.this;
                        deepLinkWebViewScreen.deepLinkRecived(deepLinkWebViewScreen, parse);
                        DeepLinkWebViewScreen.this.getDeepLinkPresenter().redirectToDeepLink();
                    }
                    return true;
                }
            }
            return false;
        }
    }

    private void launchHomeScreen() {
        startActivity(new Intent(this, HomeScreenActivity.class));
        finish();
    }

    private void redirectChromeTab(String str) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(getResources().getColor(R.color.colorPrimary));
        builder.setToolbarColor(getResources().getColor(R.color.talabat_off_white));
        builder.setStartAnimations(this, R.anim.fade_in, R.anim.fade_in);
        builder.setExitAnimations(this, R.anim.fade_out, R.anim.fade_out);
        CustomTabsIntent build = builder.build();
        build.intent.setData(Uri.parse(str));
        startActivityForResult(build.intent, 3001);
    }

    public void destroyPresenter() {
        this.presenter = null;
    }

    public IGlobalPresenter getPresenter() {
        return this.presenter;
    }

    public String getScreenName() {
        return ScreenNames.TALABAT_DEEP_LINK_WEBVIEW;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 == 3001) {
            pauseBannerForNextScreen();
            launchHomeScreen();
        }
    }

    public void onAuthError() {
    }

    public void onCreate(@Nullable Bundle bundle) {
        boolean z11;
        DaggerDeepLinkWebViewScreenComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.deep_link_webview);
        if (Build.VERSION.SDK_INT > 23) {
            TalabatUtils.changeLocale(this, GlobalDataModel.SelectedLanguage);
        }
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setToolbarPadding(this.mToolbar);
            this.webView = (WebView) findViewById(R.id.webview);
            this.webviewProgress = (ProgressBar) findViewById(R.id.webview_progress);
            this.title = (TextView) findViewById(R.id.title);
            this.initialUrl = getIntent().getStringExtra("url");
            this.isWebSurveyRedirection = getIntent().getBooleanExtra("isWebViewRedirection", false);
            this.isresetpassword = getIntent().getBooleanExtra("isresetpassword", false);
            if (this.initialUrl.contains("tracking.")) {
                z11 = true;
            } else {
                z11 = false;
            }
            setInitialUrlAndTitle(z11);
            this.webView.setWebChromeClient(new WebChromeClient() {
                public void onProgressChanged(WebView webView, int i11) {
                    if (DeepLinkWebViewScreen.this.webView.getVisibility() == 0 && i11 > 50) {
                        DeepLinkWebViewScreen.this.webviewProgress.setVisibility(8);
                    }
                }
            });
            this.webView.setWebViewClient(new TalabatWc());
            WebSettings settings = this.webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setAllowContentAccess(true);
            settings.setBuiltInZoomControls(true);
            settings.setLoadsImagesAutomatically(true);
            settings.setLoadWithOverviewMode(true);
            settings.setSupportZoom(true);
            TWebViewPresenter tWebViewPresenter = new TWebViewPresenter(this);
            this.presenter = tWebViewPresenter;
            if (this.isWebSurveyRedirection) {
                redirectChromeTab(this.initialUrl);
            } else {
                tWebViewPresenter.setUpView(this.initialUrl);
            }
            this.mMainLayout = (LinearLayout) findViewById(R.id.main_layout);
            setMenu(R.id.sidemenu_button, new SideMenuPresenter(this, this.f54012i), false, (View) null);
        } catch (Exception e11) {
            e11.printStackTrace();
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        LinearLayout linearLayout = this.mMainLayout;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.destroy();
        }
    }

    public void onError() {
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (i11 != 4) {
            return super.onKeyDown(i11, keyEvent);
        }
        if (this.webView.canGoBack()) {
            this.webView.goBack();
            return true;
        }
        startActivity(new Intent(this, HomeScreenActivity.class));
        finish();
        return true;
    }

    public void onLoadUrl(String str) {
        Log.e("fff1111f", "" + this.initialUrl);
        this.webView.loadUrl(str);
    }

    public void setInitialUrlAndTitle(boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        String str = "";
        sb2.append(str);
        sb2.append(this.initialUrl);
        Log.e("Initial", sb2.toString());
        if (z11) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.initialUrl);
            if (!TalabatUtils.isArabic()) {
                str = "?lang=en";
            }
            sb3.append(str);
            sb3.append("&embedded=true");
            this.initialUrl = sb3.toString();
            this.title.setText(getResources().getString(R.string.res_track_order));
            return;
        }
        this.title.setText(str);
    }
}
