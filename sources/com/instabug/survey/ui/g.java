package com.instabug.survey.ui;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.exoplayer2.C;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BaseContract;
import com.instabug.library.core.ui.BaseFragmentActivity;
import com.instabug.library.util.AccessibilityUtils;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.StatusBarUtils;
import com.instabug.survey.R;
import com.instabug.survey.SurveyPlugin;
import com.instabug.survey.common.d;
import com.instabug.survey.h;
import com.instabug.survey.models.Survey;
import com.instabug.survey.settings.c;
import com.instabug.survey.ui.survey.l;
import com.instabug.survey.ui.survey.rateus.b;
import com.instabug.survey.ui.survey.welcomepage.a;
import com.instabug.survey.utils.j;
import com.instabug.survey.utils.p;
import java.util.Iterator;

public abstract class g extends BaseFragmentActivity implements i, h {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private Handler f52505b;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private GestureDetector f52506f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Handler f52507g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private Runnable f52508h;

    /* renamed from: j  reason: collision with root package name */
    public boolean f52509j = false;

    /* renamed from: k  reason: collision with root package name */
    public FrameLayout f52510k;

    /* renamed from: l  reason: collision with root package name */
    public RelativeLayout f52511l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    public Survey f52512m;

    private void a(Fragment fragment) {
        Handler handler = new Handler();
        this.f52505b = handler;
        handler.postDelayed(new d(this, fragment), C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }

    /* access modifiers changed from: private */
    public void b(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().setCustomAnimations(0, R.anim.instabug_anim_flyout_to_bottom).remove(fragment).commitAllowingStateLoss();
            new Handler().postDelayed(new c(this), 400);
        }
    }

    private void g() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.instabug_fragment_container);
        if (findFragmentById instanceof l) {
            Iterator<Fragment> it = findFragmentById.getChildFragmentManager().getFragments().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Fragment next = it.next();
                if ((next instanceof b) && next.isVisible()) {
                    if (this.f52512m == null) {
                        b(findFragmentById);
                    } else if (!c.l() || !this.f52512m.isAppStoreRatingEnabled()) {
                        a(findFragmentById);
                    }
                }
            }
        }
        if (getSupportFragmentManager() != null && getSupportFragmentManager().findFragmentByTag("THANKS_FRAGMENT") != null) {
            b(getSupportFragmentManager().findFragmentByTag("THANKS_FRAGMENT"));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h() {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("THANKS_FRAGMENT");
        if (findFragmentByTag != null) {
            a(findFragmentByTag);
        }
    }

    /* access modifiers changed from: private */
    public void i(Survey survey) {
        o(a.h(survey));
    }

    public void a(int i11) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f52510k.getMeasuredHeight(), i11});
        ofInt.addUpdateListener(new e(this));
        ofInt.setDuration(300);
        ofInt.start();
    }

    public void a(Survey survey) {
        BaseContract.Presenter presenter = this.f34199i;
        if (presenter != null) {
            ((l) presenter).d(survey);
        }
    }

    public void a(n nVar, boolean z11) {
        BaseContract.Presenter presenter = this.f34199i;
        if (presenter != null) {
            ((l) presenter).a(nVar, z11);
        }
    }

    @Nullable
    public n b() {
        BaseContract.Presenter presenter = this.f34199i;
        return presenter != null ? ((l) presenter).a() : n.PRIMARY;
    }

    public void b(int i11) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f52510k.getLayoutParams();
        layoutParams.height = i11;
        this.f52510k.setLayoutParams(layoutParams);
    }

    public void b(Survey survey) {
        BaseContract.Presenter presenter = this.f34199i;
        if (presenter != null) {
            ((l) presenter).a(survey);
        }
    }

    public void b(boolean z11) {
        Fragment fragment = getSupportFragmentManager().getFragments().get(getSupportFragmentManager().getFragments().size() - 1);
        if (z11) {
            b(fragment);
        } else if (!AccessibilityUtils.isAccessibilityServiceEnabled()) {
            a(fragment);
        }
    }

    public void c(boolean z11) {
        Runnable runnable;
        long j11;
        if (getSupportFragmentManager() != null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            int i11 = R.id.instabug_fragment_container;
            Fragment findFragmentById = supportFragmentManager.findFragmentById(i11);
            if (findFragmentById != null) {
                getSupportFragmentManager().beginTransaction().setCustomAnimations(0, R.anim.instabug_anim_flyout_to_bottom).remove(findFragmentById).commitAllowingStateLoss();
            }
            Handler handler = new Handler();
            if (z11) {
                getSupportFragmentManager().beginTransaction().setCustomAnimations(0, 0).replace(i11, (Fragment) com.instabug.survey.ui.survey.thankspage.a.h(this.f52512m), "THANKS_FRAGMENT").commitAllowingStateLoss();
                if (!AccessibilityUtils.isAccessibilityServiceEnabled()) {
                    runnable = new vd.a(this);
                    this.f52508h = runnable;
                    j11 = 600;
                }
                this.f52507g = handler;
                j.a();
            }
            runnable = new b(this);
            this.f52508h = runnable;
            j11 = 300;
            handler.postDelayed(runnable, j11);
            this.f52507g = handler;
            j.a();
        }
    }

    public void d(boolean z11) {
        getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(this, z11 ? R.color.instabug_transparent_color : R.color.instabug_dialog_bg_color));
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f52506f == null) {
            this.f52506f = new GestureDetector(this, new com.instabug.survey.ui.gestures.b(new f(this)));
        }
        this.f52506f.onTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Nullable
    public Survey e() {
        return this.f52512m;
    }

    @Nullable
    public n f() {
        BaseContract.Presenter presenter = this.f34199i;
        return presenter != null ? ((l) presenter).a() : n.PRIMARY;
    }

    public int getLayout() {
        return R.layout.instabug_survey_activity;
    }

    public void h(Survey survey) {
        BaseContract.Presenter presenter = this.f34199i;
        if (presenter != null) {
            ((l) presenter).a(survey);
        }
    }

    public abstract void i(@Nullable Bundle bundle);

    public void initViews() {
    }

    public void j(Fragment fragment, int i11, int i12) {
        getSupportFragmentManager().beginTransaction().setCustomAnimations(i11, i12).replace(R.id.instabug_fragment_container, fragment).commitAllowingStateLoss();
    }

    public void o(Fragment fragment) {
        j(fragment, R.anim.instabug_anim_flyin_from_bottom, R.anim.instabug_anim_flyout_to_bottom);
    }

    public void onBackPressed() {
        BaseContract.Presenter presenter = this.f34199i;
        if (presenter != null) {
            ((l) presenter).b();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setTheme(p.b(InstabugCore.getTheme()));
        StatusBarUtils.setStatusBarForDialog(this);
        this.f52510k = (FrameLayout) findViewById(R.id.instabug_fragment_container);
        this.f52511l = (RelativeLayout) findViewById(R.id.survey_activity_container);
        this.f34199i = new l(this);
        if (getIntent() != null) {
            this.f52512m = (Survey) getIntent().getSerializableExtra("survey");
        }
        if (this.f52512m != null) {
            i(bundle);
            this.f52510k.postDelayed(new a(this, bundle), 500);
            return;
        }
        InstabugSDKLogger.w("IBG-Surveys", "survey activity will be finished the survey is null");
        finish();
    }

    public void onDestroy() {
        Handler handler = this.f52507g;
        if (handler != null) {
            Runnable runnable = this.f52508h;
            if (runnable != null) {
                handler.removeCallbacks(runnable);
            }
            this.f52507g = null;
            this.f52508h = null;
        }
        super.onDestroy();
        InstabugCore.setPluginState(SurveyPlugin.class, 0);
        if (h.e() != null) {
            h.e().i();
        }
        d.a().b(false);
    }

    public void onPageSelected(int i11) {
    }

    public void onPause() {
        this.f52509j = false;
        super.onPause();
        overridePendingTransition(0, 0);
    }

    public void onResume() {
        super.onResume();
        InstabugCore.setPluginState(SurveyPlugin.class, 1);
        this.f52509j = true;
        g();
        d.a().b(true);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        try {
            BaseContract.Presenter presenter = this.f34199i;
            if (presenter != null && ((l) presenter).a() != null) {
                bundle.putInt("viewType", ((l) this.f34199i).a().a());
            }
        } catch (IllegalStateException e11) {
            InstabugSDKLogger.e("IBG-Surveys", "Something went wrong while saving survey state", e11);
        }
    }
}
