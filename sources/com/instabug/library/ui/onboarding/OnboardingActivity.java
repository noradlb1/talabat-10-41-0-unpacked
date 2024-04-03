package com.instabug.library.ui.onboarding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.graphics.ColorUtils;
import androidx.viewpager.widget.ViewPager;
import com.instabug.library.R;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BaseContract;
import com.instabug.library.core.ui.BaseFragmentActivity;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.ui.custom.InstabugViewPager;
import com.instabug.library.ui.custom.pagerindicator.DotIndicator;
import com.instabug.library.ui.onboarding.WelcomeMessage;
import com.instabug.library.util.AttrResolver;
import com.instabug.library.util.DrawableUtils;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.StatusBarUtils;
import java.util.List;

public class OnboardingActivity extends BaseFragmentActivity implements b, ViewPager.OnPageChangeListener, View.OnClickListener {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private InstabugViewPager f51974a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private a f51975b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private DotIndicator f51976c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Button f51977d;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public WelcomeMessage.State f51978j;

    public static Intent a(Context context, WelcomeMessage.State state) {
        Intent intent = new Intent(context, OnboardingActivity.class);
        intent.putExtra("welcome_state", state);
        return intent;
    }

    private void e() {
        Button button = this.f51977d;
        if (button != null) {
            button.setVisibility(8);
        }
        if (this.f51976c != null) {
            a aVar = this.f51975b;
            if (aVar == null || aVar.getCount() <= 1) {
                this.f51976c.setVisibility(8);
            } else {
                this.f51976c.setVisibility(0);
            }
        }
    }

    public void c() {
        findViewById(R.id.ib_core_onboarding_container).setOnClickListener(this);
    }

    public void dismiss() {
        finish();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.ib_core_anim_fade_in, R.anim.ib_core_anim_fade_out);
        SettingsManager.getInstance().setOnboardingShowing(false);
    }

    public int getLayout() {
        return R.layout.ib_core_lyt_onboarding_activity;
    }

    public String getLocalizedString(@StringRes int i11) {
        return LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(this), i11, this);
    }

    public void initViews() {
        InstabugViewPager instabugViewPager = (InstabugViewPager) findViewById(R.id.ib_core_onboarding_viewpager);
        this.f51974a = instabugViewPager;
        if (instabugViewPager != null) {
            DrawableUtils.setColor(instabugViewPager, AttrResolver.getColor(this, R.attr.instabug_background_color));
            instabugViewPager.addOnPageChangeListener(this);
            instabugViewPager.setOffscreenPageLimit(2);
            instabugViewPager.setAutoHeight(true);
        }
        Button button = (Button) findViewById(R.id.ib_core_onboarding_done);
        this.f51977d = button;
        if (button != null) {
            button.setOnClickListener(this);
            button.setTextColor(SettingsManager.getInstance().getPrimaryColor());
        }
        DotIndicator dotIndicator = (DotIndicator) findViewById(R.id.ib_core_onboarding_viewpager_indicator);
        this.f51976c = dotIndicator;
        if (dotIndicator != null) {
            dotIndicator.setSelectedDotColor(SettingsManager.getInstance().getPrimaryColor());
            this.f51976c.setUnselectedDotColor(ColorUtils.setAlphaComponent(SettingsManager.getInstance().getPrimaryColor(), 80));
        }
        if (!(instabugViewPager == null || button == null)) {
            if (LocaleUtils.isRTL(InstabugCore.getLocale(this))) {
                instabugViewPager.setRotation(180.0f);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) button.getLayoutParams();
                layoutParams.addRule(5, instabugViewPager.getId());
                button.setLayoutParams(layoutParams);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) button.getLayoutParams();
                layoutParams2.addRule(7, instabugViewPager.getId());
                button.setLayoutParams(layoutParams2);
            }
        }
        BaseContract.Presenter presenter = this.f34199i;
        if (presenter != null) {
            ((e) presenter).a(this.f51978j);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.ib_core_anim_fade_in, R.anim.ib_core_anim_fade_out);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.ib_core_onboarding_done) {
            finish();
        } else if (view.getId() == R.id.ib_core_onboarding_container) {
            finish();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        SettingsManager.getInstance().setOnboardingShowing(true);
        SettingsManager.getInstance().setShouldAutoShowOnboarding(false);
        this.f34199i = new e(this);
        this.f51978j = (WelcomeMessage.State) getIntent().getSerializableExtra("welcome_state");
        overridePendingTransition(R.anim.ib_core_anim_fade_in, R.anim.ib_core_anim_fade_out);
        super.onCreate(bundle);
        StatusBarUtils.setStatusBarColorForPrompt(this);
    }

    public void onPageScrollStateChanged(int i11) {
    }

    public void onPageScrolled(int i11, float f11, int i12) {
    }

    public void onPageSelected(int i11) {
        DotIndicator dotIndicator = this.f51976c;
        if (dotIndicator != null) {
            dotIndicator.setSelectedItem(i11, true);
        }
        if (this.f51977d != null) {
            a aVar = this.f51975b;
            if (aVar == null || i11 != aVar.getCount() - 1 || this.f51975b.getCount() <= 1) {
                this.f51977d.setVisibility(4);
                this.f51977d.requestFocus(0);
                return;
            }
            this.f51977d.setVisibility(0);
            this.f51977d.requestFocus();
        }
    }

    public void a(List list) {
        a aVar = new a(getSupportFragmentManager(), list);
        this.f51975b = aVar;
        InstabugViewPager instabugViewPager = this.f51974a;
        if (instabugViewPager != null) {
            instabugViewPager.setAdapter(aVar);
        }
        DotIndicator dotIndicator = this.f51976c;
        if (dotIndicator != null) {
            dotIndicator.setNumberOfItems(this.f51975b.getCount());
        }
        e();
    }

    public void a() {
        InstabugCore.handlePbiFooter(findViewById(16908290).getRootView());
    }
}
