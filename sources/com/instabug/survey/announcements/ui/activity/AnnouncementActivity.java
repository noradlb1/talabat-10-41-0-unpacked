package com.instabug.survey.announcements.ui.activity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BackPressHandler;
import com.instabug.library.core.ui.BaseContract;
import com.instabug.library.core.ui.BaseFragmentActivity;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.StatusBarUtils;
import com.instabug.survey.R;
import com.instabug.survey.SurveyPlugin;
import com.instabug.survey.announcements.ui.fragment.versionupdate.e;
import com.instabug.survey.h;
import com.instabug.survey.utils.p;

public class AnnouncementActivity extends BaseFragmentActivity implements c, b {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f52272b;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.instabug.survey.announcements.models.a f52273c;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public Handler f52274d;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public Runnable f52275e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Runnable f52276f;

    /* renamed from: j  reason: collision with root package name */
    public boolean f52277j = false;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Bundle f52278b;

        public a(Bundle bundle) {
            this.f52278b = bundle;
        }

        public void run() {
            if (InstabugCore.getStartedActivitiesCount() <= 1) {
                InstabugSDKLogger.d("IBG-Surveys", "Announcement Error: StartedActivitiesCount <= 1");
                AnnouncementActivity.this.finish();
                return;
            }
            try {
                if (!AnnouncementActivity.this.isFinishing()) {
                    AnnouncementActivity announcementActivity = AnnouncementActivity.this;
                    if (announcementActivity.f52277j) {
                        com.instabug.survey.announcements.models.a aVar = (com.instabug.survey.announcements.models.a) announcementActivity.getIntent().getSerializableExtra(InstabugDbContract.AnnouncementEntry.COLUMN_ANNOUNCEMENT);
                        com.instabug.survey.announcements.models.a unused = AnnouncementActivity.this.f52273c = aVar;
                        if (this.f52278b == null && aVar != null) {
                            d.a(AnnouncementActivity.this.getSupportFragmentManager(), aVar);
                            return;
                        }
                        return;
                    }
                    announcementActivity.finish();
                }
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Surveys", "Announcement has not been shown due to this error: " + e11.getMessage());
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            if (AnnouncementActivity.this.getSupportFragmentManager() != null) {
                Fragment findFragmentById = AnnouncementActivity.this.getSupportFragmentManager().findFragmentById(R.id.instabug_fragment_container);
                if (findFragmentById != null) {
                    AnnouncementActivity announcementActivity = AnnouncementActivity.this;
                    if (announcementActivity.f52277j) {
                        announcementActivity.getSupportFragmentManager().beginTransaction().setCustomAnimations(0, R.anim.instabug_anim_flyout_to_bottom).remove(findFragmentById).commit();
                    }
                }
                Handler unused = AnnouncementActivity.this.f52274d = new Handler();
                Runnable unused2 = AnnouncementActivity.this.f52275e = new a(this);
                AnnouncementActivity.this.f52274d.postDelayed(AnnouncementActivity.this.f52275e, 300);
            }
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewGroup.LayoutParams layoutParams = AnnouncementActivity.this.f52272b.getLayoutParams();
            layoutParams.height = intValue;
            AnnouncementActivity.this.f52272b.setLayoutParams(layoutParams);
        }
    }

    private boolean b() {
        Fragment f11 = f();
        if (f11 instanceof BackPressHandler) {
            return ((BackPressHandler) f11).onBackPress();
        }
        return false;
    }

    @Nullable
    private Fragment f() {
        return getSupportFragmentManager().findFragmentById(R.id.instabug_fragment_container);
    }

    public void a(int i11) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f52272b.getMeasuredHeight(), i11});
        ofInt.addUpdateListener(new c());
        ofInt.setDuration(300);
        ofInt.start();
    }

    public void a(com.instabug.survey.announcements.models.a aVar) {
        BaseContract.Presenter presenter = this.f34199i;
        if (presenter != null) {
            ((f) presenter).a(aVar);
        }
    }

    public void a(boolean z11) {
        runOnUiThread(new b());
    }

    public void b(int i11) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f52272b.getLayoutParams();
        layoutParams.height = i11;
        this.f52272b.setLayoutParams(layoutParams);
    }

    public void b(com.instabug.survey.announcements.models.a aVar) {
        BaseContract.Presenter presenter = this.f34199i;
        if (presenter != null) {
            ((f) presenter).c(aVar);
        }
    }

    public void d(boolean z11) {
        getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(this, z11 ? R.color.instabug_transparent_color : R.color.instabug_dialog_bg_color));
    }

    @Nullable
    public com.instabug.survey.announcements.models.a e() {
        return this.f52273c;
    }

    public void e(boolean z11) {
        BaseContract.Presenter presenter = this.f34199i;
        if (presenter != null) {
            ((f) presenter).a(z11);
        }
    }

    public int getLayout() {
        return R.layout.instabug_survey_activity;
    }

    public void initViews() {
    }

    public void onBackPressed() {
        if (!b()) {
            super.onBackPressed();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setTheme(p.b(InstabugCore.getTheme()));
        StatusBarUtils.setStatusBarForDialog(this);
        this.f52272b = (FrameLayout) findViewById(R.id.instabug_fragment_container);
        ((RelativeLayout) findViewById(R.id.survey_activity_container)).setFocusableInTouchMode(true);
        f fVar = new f(this);
        this.f34199i = fVar;
        fVar.a(false);
        a aVar = new a(bundle);
        this.f52276f = aVar;
        this.f52272b.postDelayed(aVar, 500);
    }

    public void onDestroy() {
        Runnable runnable;
        Handler handler;
        super.onDestroy();
        SurveyPlugin surveyPlugin = (SurveyPlugin) InstabugCore.getXPlugin(SurveyPlugin.class);
        if (surveyPlugin != null) {
            surveyPlugin.setState(0);
        }
        Runnable runnable2 = this.f52275e;
        if (!(runnable2 == null || (handler = this.f52274d) == null)) {
            handler.removeCallbacks(runnable2);
            this.f52274d = null;
            this.f52275e = null;
        }
        FrameLayout frameLayout = this.f52272b;
        if (!(frameLayout == null || (runnable = this.f52276f) == null)) {
            frameLayout.removeCallbacks(runnable);
            this.f52276f = null;
            this.f52272b.clearAnimation();
        }
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.instabug_fragment_container);
        if (findFragmentById instanceof e) {
            ((e) findFragmentById).onDestroy();
        }
        if (h.e() != null) {
            h.e().i();
        }
        BaseContract.Presenter presenter = this.f34199i;
        if (presenter != null) {
            ((f) presenter).onDestroy();
        }
    }

    public void onPause() {
        this.f52277j = false;
        super.onPause();
        overridePendingTransition(0, 0);
    }

    public void onResume() {
        super.onResume();
        this.f52277j = true;
        SurveyPlugin surveyPlugin = (SurveyPlugin) InstabugCore.getXPlugin(SurveyPlugin.class);
        if (surveyPlugin != null) {
            surveyPlugin.setState(1);
        }
    }
}
