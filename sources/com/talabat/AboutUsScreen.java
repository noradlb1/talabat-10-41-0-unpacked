package com.talabat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import buisnessmodels.Customer;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.di.ApiContainer;
import com.talabat.di.about.DaggerAboutUsScreenComponent;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.talabatnavigation.legacyTalabat.LegacyTalabatActions;
import javax.inject.Inject;
import library.talabat.mvp.IGlobalPresenter;
import tracking.ScreenNames;
import ue.a;

public class AboutUsScreen extends TalabatBase {
    private static final int PERMISSION_REQUEST_CODE = 60;
    private View aboutUs;
    private TextView appversion;
    private View facebook;
    private View faq;
    private View feedback;
    private View instagram;
    private Toolbar mToolbar;
    private View nestedScrollview;
    private View privacy;
    private View socialResponsibility;
    @Inject
    public TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository;
    private View termsOfUse;
    private View twitter;
    private View versionView;

    private void hideAboutUsAndSocialRes() {
        this.socialResponsibility.setVisibility(8);
        this.aboutUs.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        Intent intent = new Intent(this, AppFeedBackScreen.class);
        intent.putExtra("feedbackScreenName", getScreenName());
        startActivity(intent);
    }

    private void setMargin() {
        try {
            ((LinearLayout.LayoutParams) this.nestedScrollview.getLayoutParams()).setMargins(0, 0, 0, 0);
        } catch (Exception unused) {
        }
    }

    public void destroyPresenter() {
    }

    public IGlobalPresenter getPresenter() {
        return null;
    }

    public String getScreenName() {
        return ScreenNames.ABOUT_SCREEN;
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (!shouldDisableSideMenu()) {
            effectiveNavigation();
        }
    }

    public void onCreate(Bundle bundle) {
        DaggerAboutUsScreenComponent.factory().create((ConfigurationRemoteCoreLibApi) ((ApiContainer) getApplication()).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.about_us_screen);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            setToolbarPadding(this.mToolbar);
            this.versionView = findViewById(R.id.version_view);
            this.appversion = (TextView) findViewById(R.id.app_version_text);
            this.appversion.setText(getString(R.string.version) + " " + BuildConfig.VERSION_NAME + " (" + BuildConfig.VERSION_CODE + ")");
            if (Customer.getInstance().isLoggedIn(getContext())) {
                this.versionView.setVisibility(0);
            } else {
                this.versionView.setVisibility(0);
            }
            this.aboutUs = findViewById(R.id.about_us_view);
            this.socialResponsibility = findViewById(R.id.about_us_soc_resp_view);
            this.faq = findViewById(R.id.about_us_faq_view);
            this.feedback = findViewById(R.id.about_us_feedback_view);
            this.privacy = findViewById(R.id.about_us_privacy_policy_view);
            this.termsOfUse = findViewById(R.id.about_us_use_terms_view);
            this.facebook = findViewById(R.id.about_us_facebook_view);
            this.twitter = findViewById(R.id.about_us_twitter_view);
            this.instagram = findViewById(R.id.about_us_use_instagram_view);
            this.nestedScrollview = findViewById(R.id.nested_scrollview);
            setTitle(R.id.title, getString(R.string.title_activity_about_us));
            notificationFeedCount(this);
            handleToolBarButton();
            hideAboutUsAndSocialRes();
            this.aboutUs.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(AboutUsScreen.this, TWebViewScreen.class);
                    intent.putExtra(LegacyTalabatActions.EXTRA_MAIN_FAQ_SCREEN_TITLE, AboutUsScreen.this.getResources().getString(R.string.about_us));
                    intent.putExtra("url", AboutUsScreen.this.termsAndConditionsConfigurationRepository.config().aboutUrl());
                    AboutUsScreen.this.startActivity(intent);
                }
            });
            this.socialResponsibility.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(AboutUsScreen.this, TWebViewScreen.class);
                    intent.putExtra(LegacyTalabatActions.EXTRA_MAIN_FAQ_SCREEN_TITLE, AboutUsScreen.this.getResources().getString(R.string.social));
                    intent.putExtra("url", GlobalDataModel.USERINFO.getSocialInitiativesLink());
                    AboutUsScreen.this.startActivity(intent);
                }
            });
            this.faq.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(AboutUsScreen.this, TWebViewScreen.class);
                    intent.putExtra("url", AboutUsScreen.this.termsAndConditionsConfigurationRepository.config().faqUrl());
                    intent.putExtra(LegacyTalabatActions.EXTRA_MAIN_FAQ_SCREEN_TITLE, AboutUsScreen.this.getResources().getString(R.string.faq));
                    AboutUsScreen.this.startActivity(intent);
                }
            });
            this.feedback.setOnClickListener(new a(this));
            this.privacy.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(AboutUsScreen.this, TWebViewScreen.class);
                    intent.putExtra("url", AboutUsScreen.this.termsAndConditionsConfigurationRepository.config().privacyPolicyUrl());
                    intent.putExtra(LegacyTalabatActions.EXTRA_MAIN_FAQ_SCREEN_TITLE, AboutUsScreen.this.getResources().getString(R.string.privacy_policy));
                    AboutUsScreen.this.startActivity(intent);
                }
            });
            this.termsOfUse.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(AboutUsScreen.this, TWebViewScreen.class);
                    intent.putExtra("url", AboutUsScreen.this.termsAndConditionsConfigurationRepository.config().termsOfUseUrl());
                    intent.putExtra(LegacyTalabatActions.EXTRA_MAIN_FAQ_SCREEN_TITLE, AboutUsScreen.this.getResources().getString(R.string.about_us_terms_of_use));
                    AboutUsScreen.this.startActivity(intent);
                }
            });
            this.facebook.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(AboutUsScreen.this, TWebViewScreen.class);
                    intent.putExtra("url", GlobalDataModel.USERINFO.FACEBOOKLINK);
                    intent.putExtra(LegacyTalabatActions.EXTRA_MAIN_FAQ_SCREEN_TITLE, AboutUsScreen.this.getResources().getString(R.string.facebook));
                    AboutUsScreen.this.startActivity(intent);
                }
            });
            this.twitter.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(AboutUsScreen.this, TWebViewScreen.class);
                    intent.putExtra("url", GlobalDataModel.USERINFO.TWITTERLINK);
                    intent.putExtra(LegacyTalabatActions.EXTRA_MAIN_FAQ_SCREEN_TITLE, AboutUsScreen.this.getResources().getString(R.string.twitter));
                    AboutUsScreen.this.startActivity(intent);
                }
            });
            this.instagram.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(AboutUsScreen.this, TWebViewScreen.class);
                    intent.putExtra("url", GlobalDataModel.USERINFO.INSTAGRAMLINK);
                    intent.putExtra(LegacyTalabatActions.EXTRA_MAIN_FAQ_SCREEN_TITLE, AboutUsScreen.this.getResources().getString(R.string.instagram));
                    AboutUsScreen.this.startActivity(intent);
                }
            });
            GlobalConstants.isSideMenuInitialSelection = false;
            setMargin();
        } catch (Exception e11) {
            e11.printStackTrace();
            finish();
        }
    }

    public void onError() {
    }
}
