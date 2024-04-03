package com.talabat.adscreen;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.rd.animation.type.ColorAnimation;
import com.talabat.R;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.di.ApiContainer;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import com.talabat.designhelpers.CustomSquareProgree.SquareProgressBar;
import com.talabat.di.DaggerAdScreenComponent;
import com.talabat.helpers.BitmapLruCache;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.home.HomeScreenActivity;
import com.talabat.talabatcommon.helpers.GlideApp;
import java.util.Timer;
import java.util.TimerTask;
import javax.inject.Inject;
import library.talabat.mvp.IGlobalPresenter;
import tracking.AppTracker;
import tracking.ScreenNames;
import tracking.deeplink.DeepLinkStatusListener;
import tracking.deeplink.IDeepLinkPresenter;

public class AdScreen extends TalabatBase {
    private static final String TAG = "AdScreen";
    private String bannerType;
    /* access modifiers changed from: private */
    public String clickLink;
    /* access modifiers changed from: private */
    public NativeCustomTemplateAd customTemplateAd;
    private Button enter;
    private View enter_button;
    private String from = "";
    private boolean goneToNext = false;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public ConfigurationLocalRepository f55363i;
    /* access modifiers changed from: private */
    public ImageView imageView;

    /* renamed from: j  reason: collision with root package name */
    public ProgressBar f55364j;

    /* renamed from: k  reason: collision with root package name */
    public ImageLoader f55365k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f55366l = false;
    /* access modifiers changed from: private */
    public String linkType;

    /* renamed from: m  reason: collision with root package name */
    public boolean f55367m = false;
    private RelativeLayout mAddressLayoutView;

    /* renamed from: n  reason: collision with root package name */
    public boolean f55368n = false;

    /* renamed from: o  reason: collision with root package name */
    public int f55369o = 0;
    private SquareProgressBar squareProgressBar;
    private Timer timer;
    private String url;
    /* access modifiers changed from: private */
    public WebView webView;

    public class AdTimerTask extends TimerTask {
        private final Handler handler = new Handler();

        public AdTimerTask() {
        }

        public void run() {
            this.handler.post(new Runnable() {
                public void run() {
                    AdScreen adScreen = AdScreen.this;
                    if (!adScreen.f55366l) {
                        adScreen.StopTimer();
                    }
                }
            });
        }
    }

    public class TalabatWc extends WebViewClient {
        private TalabatWc() {
        }

        public void onLoadResource(WebView webView, String str) {
            AdScreen.this.f55369o = webView.getProgress();
            AdScreen adScreen = AdScreen.this;
            if (!adScreen.f55368n) {
                adScreen.f55364j.setVisibility(0);
            }
            AdScreen adScreen2 = AdScreen.this;
            if (adScreen2.f55369o > 70) {
                adScreen2.StartTimer();
            }
        }

        public void onPageFinished(WebView webView, String str) {
            try {
                AdScreen adScreen = AdScreen.this;
                adScreen.f55368n = true;
                adScreen.f55364j.setVisibility(8);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            AdScreen.this.f55368n = false;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            AdScreen adScreen = AdScreen.this;
            adScreen.f55368n = true;
            adScreen.startLodingPopup();
            if (!str.startsWith("talabat:")) {
                return false;
            }
            AdScreen.this.webView.setVisibility(8);
            AdScreen.this.getDeepLinkPresenter().deepLinkRecived(AdScreen.this.getQueryString(str));
            AdScreen.this.getDeepLinkPresenter().redirectToDeepLink();
            AdScreen.this.getDeepLinkPresenter().setDeepLinkStatusListener(new DeepLinkStatusListener() {
                public void onDataRetrieved() {
                    AdScreen adScreen = AdScreen.this;
                    adScreen.f55368n = false;
                    adScreen.StopTimer();
                }
            });
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void StartTimer() {
        Timer timer2 = new Timer();
        this.timer = timer2;
        timer2.schedule(new AdTimerTask(), 5000);
    }

    /* access modifiers changed from: private */
    public void StopTimer() {
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
            this.timer.purge();
        }
        if (!this.goneToNext) {
            gotoNext();
        }
        this.goneToNext = true;
    }

    public static Intent callingIntent(Context context) {
        return new Intent(context, AdScreen.class);
    }

    /* access modifiers changed from: private */
    public String getQueryString(String str) {
        try {
            String[] split = str.split("\\?");
            if (split.length > 0) {
                return split[1];
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private void gotoNext() {
        if (this.from.equals(ScreenNames.SPLASHSCREEN)) {
            Intent intent = new Intent(this, HomeScreenActivity.class);
            intent.putExtra("fromSplash", true);
            startActivity(intent);
            finish();
            return;
        }
        finish();
    }

    /* access modifiers changed from: private */
    public void showAd() {
        this.customTemplateAd.recordImpression();
        this.url = this.customTemplateAd.getText("url").toString();
        this.linkType = this.customTemplateAd.getText(GlobalConstants.BANNER.LINKTYPE).toString();
        this.bannerType = this.customTemplateAd.getText("bannerType").toString();
        this.clickLink = this.customTemplateAd.getText("link").toString();
        if (this.bannerType.equalsIgnoreCase(GlobalConstants.BANNER.BANNERTYPE_WEB)) {
            this.webView.setVisibility(0);
            this.imageView.setVisibility(8);
            this.webView.loadUrl(this.url);
            return;
        }
        StartTimer();
        this.f55364j.setVisibility(8);
        if (isValidContextForGlide(this)) {
            GlideApp.with((FragmentActivity) this).load(this.url).centerInside().into(this.imageView);
        }
        this.imageView.setVisibility(0);
    }

    public void destroyPresenter() {
    }

    public IGlobalPresenter getPresenter() {
        return null;
    }

    public String getScreenName() {
        return "Ad Screen";
    }

    public void onAuthError() {
    }

    public void onCreate(Bundle bundle) {
        String str;
        DaggerAdScreenComponent.factory().create((ConfigurationLocalCoreLibApi) ((ApiContainer) getApplication()).getFeature(ConfigurationLocalCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.ad_screen);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 > 23) {
            TalabatUtils.changeLocale(this, GlobalDataModel.SelectedLanguage);
        }
        if (getIntent().hasExtra("from")) {
            str = getIntent().getStringExtra("from");
        } else {
            str = "";
        }
        this.from = str;
        this.imageView = (ImageView) findViewById(R.id.ad_image_view);
        this.webView = (WebView) findViewById(R.id.ad_webview);
        this.mAddressLayoutView = (RelativeLayout) findViewById(R.id.address_layout_view);
        this.webView.setWebViewClient(new TalabatWc());
        WebSettings settings = this.webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(true);
        settings.setBuiltInZoomControls(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        this.enter = (Button) findViewById(R.id.enter_button);
        this.enter_button = findViewById(R.id.enter_layout);
        SquareProgressBar squareProgressBar2 = (SquareProgressBar) findViewById(R.id.square_progress_bar);
        this.squareProgressBar = squareProgressBar2;
        squareProgressBar2.setRoundedCorners(true, 10.0f);
        this.squareProgressBar.setWidth(3);
        this.squareProgressBar.setColor(ColorAnimation.DEFAULT_SELECTED_COLOR);
        this.f55364j = (ProgressBar) findViewById(R.id.progress);
        this.f55365k = new ImageLoader(Volley.newRequestQueue(this), new BitmapLruCache());
        populateNativeAd(this);
        if (i11 > 23) {
            this.enter.setText(getResources().getString(R.string.skip_ad_arabic));
        } else {
            this.enter.setText(getResources().getString(R.string.skip_ad));
        }
        this.enter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AppTracker.onBannerEnterButtonClicked(AdScreen.this);
                AdScreen.this.StopTimer();
            }
        });
        this.enter_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AdScreen.this.StopTimer();
            }
        });
        this.imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!(AdScreen.this.customTemplateAd == null || AdScreen.this.customTemplateAd.getAvailableAssetNames() == null || AdScreen.this.customTemplateAd.getAvailableAssetNames().get(0) == null)) {
                    AdScreen.this.customTemplateAd.performClick(AdScreen.this.customTemplateAd.getAvailableAssetNames().get(0));
                }
                if (TalabatUtils.isNullOrEmpty(AdScreen.this.clickLink)) {
                    return;
                }
                if (AdScreen.this.linkType.equals(GlobalConstants.BANNER.LINKTYPE_WEBLINK)) {
                    AdScreen.this.imageView.setVisibility(8);
                    AdScreen.this.webView.setVisibility(0);
                    AdScreen.this.webView.loadUrl(AdScreen.this.clickLink);
                    AdScreen.this.f55366l = true;
                    return;
                }
                AdScreen adScreen = AdScreen.this;
                adScreen.f55366l = true;
                adScreen.startLodingPopup();
                IDeepLinkPresenter deepLinkPresenter = AdScreen.this.getDeepLinkPresenter();
                AdScreen adScreen2 = AdScreen.this;
                deepLinkPresenter.deepLinkRecived(adScreen2.getQueryString(adScreen2.clickLink));
                AdScreen.this.getDeepLinkPresenter().redirectToDeepLink();
                AdScreen.this.getDeepLinkPresenter().setDeepLinkStatusListener(new DeepLinkStatusListener() {
                    public void onDataRetrieved() {
                        AdScreen.this.StopTimer();
                    }
                });
            }
        });
        this.webView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AdScreen.this.f55366l = true;
            }
        });
        this.webView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                AdScreen.this.f55366l = true;
                return false;
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        RelativeLayout relativeLayout = this.mAddressLayoutView;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.destroy();
        }
    }

    public void onError() {
    }

    public void onPause() {
        super.onPause();
        stopLodingPopup();
    }

    public void onResume() {
        startProgressTimer();
        super.onResume();
    }

    public void populateNativeAd(Context context) {
        String mainBanner = AdUnitHelper.getMainBanner(this.f55363i.selectedCountry().twoLetterCodeUpperCase());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("populateNativeAd: ");
        sb2.append(mainBanner);
        new AdLoader.Builder(context, mainBanner).forCustomTemplateAd(GlobalConstants.BANNER.TEMPLATEID, new NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener() {
            public void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd) {
                AdScreen.this.customTemplateAd = nativeCustomTemplateAd;
                AdScreen.this.showAd();
            }
        }, new NativeCustomTemplateAd.OnCustomClickListener() {
            public void onCustomClick(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
            }
        }).withAdListener(new AdListener() {
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                Log.e(AdScreen.TAG, "onAdFailedToLoad: " + loadAdError.getCause(), (Throwable) null);
                AdScreen.this.StartTimer();
            }
        }).withNativeAdOptions(new NativeAdOptions.Builder().build()).build().loadAd(new AdManagerAdRequest.Builder().addCustomTargeting(BindingAdaptersKt.QUERY_SIZE, GlobalDataModel.deviceSize).build());
    }

    public void startProgressTimer() {
        this.squareProgressBar.setProgress(0, 100, new SquareProgressBar.ProgressAnimationListener() {
            public void onAnimationFinish() {
            }

            public void onAnimationProgress(int i11) {
            }

            public void onAnimationStart() {
            }
        });
    }
}
