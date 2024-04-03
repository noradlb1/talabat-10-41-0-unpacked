package com.talabat.sidemenu;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;

public class SideMenuBannerViewHolder extends RecyclerView.ViewHolder {
    public ImageView bannerImage;
    public WebView bannerWebView;

    public class TalabatWc extends WebViewClient {
        private TalabatWc() {
        }

        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }

        public void onPageFinished(WebView webView, String str) {
            SideMenuBannerViewHolder.this.bannerWebView.setVisibility(0);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            webView.clearCache(false);
            super.onPageStarted(webView, str, bitmap);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return false;
        }
    }

    public SideMenuBannerViewHolder(View view) {
        super(view);
        this.bannerImage = (ImageView) view.findViewById(R.id.image_banner);
        WebView webView = (WebView) view.findViewById(R.id.ad_webview);
        this.bannerWebView = webView;
        webView.setWebViewClient(new TalabatWc());
        WebSettings settings = this.bannerWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(true);
        settings.setBuiltInZoomControls(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
    }
}
