package com.talabat;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatnavigation.legacyTalabat.LegacyTalabatActions;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.twebview.ITWebViewPresenter;
import library.talabat.mvp.twebview.TWebViewPresenter;
import library.talabat.mvp.twebview.TWebview;
import tracking.ScreenNames;

public class TWebViewScreen extends TalabatBase implements TWebview {

    /* renamed from: i  reason: collision with root package name */
    public String f55070i = "";
    private String initialUrl;
    private LinearLayout mMainLayout;
    private Toolbar mToolbar;
    private ITWebViewPresenter presenter;
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
            TWebViewScreen.this.webView.setVisibility(0);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            webView.clearCache(false);
            super.onPageStarted(webView, str, bitmap);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith("fb://")) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    TWebViewScreen.this.startActivity(intent);
                } catch (ActivityNotFoundException unused) {
                }
                return true;
            }
            if (!str.startsWith("http:") && !str.startsWith("https:") && str.startsWith("tel:")) {
                try {
                    Intent intent2 = new Intent("android.intent.action.DIAL");
                    intent2.setData(Uri.parse(str));
                    TWebViewScreen.this.startActivity(intent2);
                    return true;
                } catch (ActivityNotFoundException unused2) {
                }
            }
            return false;
        }
    }

    public void destroyPresenter() {
        this.presenter = null;
    }

    public IGlobalPresenter getPresenter() {
        return this.presenter;
    }

    public String getScreenName() {
        return ScreenNames.TALABATWEBVIEW;
    }

    public void onAuthError() {
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.talabatwebview);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setBackButton(R.id.webview_back);
            String stringExtra = getIntent().getStringExtra(LegacyTalabatActions.EXTRA_MAIN_FAQ_SCREEN_TITLE);
            if (TalabatUtils.isNullOrEmpty(stringExtra)) {
                stringExtra = "";
            }
            this.f55070i = stringExtra;
            setTitle(R.id.webview_title, stringExtra);
            this.webView = (WebView) findViewById(R.id.webview);
            this.webviewProgress = (ProgressBar) findViewById(R.id.webview_progress);
            this.initialUrl = getIntent().getStringExtra("url");
            this.webView.setWebChromeClient(new WebChromeClient() {
                public void onProgressChanged(WebView webView, int i11) {
                    if (TWebViewScreen.this.webView.getVisibility() == 0 && i11 > 50) {
                        TWebViewScreen.this.webviewProgress.setVisibility(8);
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
            tWebViewPresenter.setUpView(this.initialUrl);
            this.mMainLayout = (LinearLayout) findViewById(R.id.main_layout);
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
        finish();
        return true;
    }

    public void onLoadUrl(String str) {
        this.webView.loadUrl(str);
    }
}
