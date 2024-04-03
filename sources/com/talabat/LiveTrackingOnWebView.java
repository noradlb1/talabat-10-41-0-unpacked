package com.talabat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.twebview.ITWebViewPresenter;
import library.talabat.mvp.twebview.TWebViewPresenter;
import library.talabat.mvp.twebview.TWebview;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import tracking.ScreenNames;

public class LiveTrackingOnWebView extends TalabatBase implements TWebview {
    private static final String TEL_PREFIX = "tel:";
    private ImageButton back;
    private boolean fromThankyouPage = false;

    /* renamed from: i  reason: collision with root package name */
    public String f54284i = "";
    private String initialUrl;
    /* access modifiers changed from: private */
    public boolean isTimedOut = false;
    /* access modifiers changed from: private */
    public boolean loadingFinished = true;
    private LinearLayout mMainLayout;
    private Toolbar mToolbar;
    private ITWebViewPresenter presenter;
    /* access modifiers changed from: private */
    public boolean redirect = false;
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
            if (!LiveTrackingOnWebView.this.redirect) {
                LiveTrackingOnWebView.this.loadingFinished = true;
            }
            if (!LiveTrackingOnWebView.this.loadingFinished || LiveTrackingOnWebView.this.redirect) {
                LiveTrackingOnWebView.this.redirect = false;
            } else {
                LiveTrackingOnWebView.this.webviewProgress.setVisibility(8);
            }
            LiveTrackingOnWebView.this.webView.setVisibility(0);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            webView.clearCache(false);
            super.onPageStarted(webView, str, bitmap);
            LiveTrackingOnWebView.this.loadingFinished = false;
            LiveTrackingOnWebView.this.isTimedOut = false;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!LiveTrackingOnWebView.this.loadingFinished) {
                LiveTrackingOnWebView.this.redirect = true;
            }
            LiveTrackingOnWebView.this.loadingFinished = false;
            if (str.startsWith(LiveTrackingOnWebView.TEL_PREFIX)) {
                LiveTrackingOnWebView.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                return true;
            }
            webView.loadUrl(str);
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
        return ScreenNames.TRACKORDER_WEBVIEW_SCREEN;
    }

    public void onAuthError() {
    }

    public void onCreate(@Nullable Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView((int) R.layout.livetrackonweb);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setToolbarPadding(this.mToolbar);
            this.fromThankyouPage = getIntent().getBooleanExtra("fromThankyouPage", false);
            this.webView = (WebView) findViewById(R.id.webview);
            this.webviewProgress = (ProgressBar) findViewById(R.id.webview_progress);
            ImageButton imageButton = (ImageButton) findViewById(R.id.webview_back);
            this.back = imageButton;
            imageButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    LiveTrackingOnWebView.this.finish();
                }
            });
            this.initialUrl = getIntent().getStringExtra("url");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.initialUrl);
            sb2.append("?lang=");
            if (TalabatUtils.isArabic()) {
                str = ArchiveStreamFactory.AR;
            } else {
                str = "en";
            }
            sb2.append(str);
            sb2.append("&embedded=true");
            this.initialUrl = sb2.toString();
            this.webView.setWebViewClient(new TalabatWc());
            WebSettings settings = this.webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setAllowContentAccess(true);
            settings.setLoadsImagesAutomatically(true);
            settings.setLoadWithOverviewMode(true);
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
        if (i11 == 4) {
            finish();
        }
        return super.onKeyDown(i11, keyEvent);
    }

    public void onLoadUrl(String str) {
        this.webView.loadUrl(str);
    }

    public void onStop() {
        super.onStop();
    }
}
