package com.instabug.survey.ui.survey;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.facebook.internal.security.CertificateUtil;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.InstabugBaseFragment;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.ui.custom.InstabugViewPager;
import com.instabug.library.util.AccessibilityUtils;
import com.instabug.library.util.DisplayUtils;
import com.instabug.library.util.DrawableUtils;
import com.instabug.library.util.LocaleHelper;
import com.instabug.survey.R;
import com.instabug.survey.models.Survey;
import com.instabug.survey.models.b;
import com.instabug.survey.settings.c;
import com.instabug.survey.ui.SurveyActivity;
import com.instabug.survey.ui.h;
import com.instabug.survey.ui.survey.adapter.a;
import com.instabug.survey.utils.e;
import java.util.ArrayList;
import java.util.List;

public abstract class l extends InstabugBaseFragment implements o, View.OnClickListener, n {
    @Nullable
    public Survey G;
    @Nullable
    public Button H;
    @Nullable
    public InstabugViewPager I;
    public int J = -1;
    public List K = new ArrayList();
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public a f52560d;

    /* renamed from: f  reason: collision with root package name */
    private String f52561f = "CURRENT_QUESTION_POSITION";
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private h f52562g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f52563h = false;

    /* renamed from: i  reason: collision with root package name */
    private long f52564i;

    private int a(long j11) {
        Survey survey = this.G;
        if (!(survey == null || survey.getQuestions() == null || this.G.getQuestions().size() <= 0)) {
            for (int i11 = 0; i11 < this.G.getQuestions().size(); i11++) {
                if (this.G.getQuestions().get(i11).c() == j11) {
                    return i11;
                }
            }
        }
        return 0;
    }

    private void a(@Nullable Bundle bundle) {
        InstabugViewPager instabugViewPager;
        int i11;
        if (this.G != null && this.C != null && (instabugViewPager = this.I) != null) {
            if (bundle == null) {
                i11 = instabugViewPager.getCurrentItem();
            } else if (bundle.getInt(this.f52561f) != -1) {
                i11 = bundle.getInt(this.f52561f);
            } else {
                return;
            }
            this.J = i11;
            d(((p) this.C).a(this.G, i11));
        }
    }

    private void a(View view) {
        InstabugViewPager instabugViewPager;
        if (this.G != null && this.f52560d != null && (instabugViewPager = this.I) != null) {
            int currentItem = instabugViewPager.getCurrentItem();
            FragmentManager childFragmentManager = getChildFragmentManager();
            Fragment findFragmentByTag = childFragmentManager.findFragmentByTag("android:switcher:" + R.id.instabug_survey_pager + CertificateUtil.DELIMITER + currentItem);
            String str = null;
            if (this.G.isNPSSurvey()) {
                g(currentItem);
            } else {
                if (findFragmentByTag != null) {
                    str = ((a) findFragmentByTag).f();
                }
                if (str != null) {
                    e(currentItem + 1);
                    instabugViewPager.postDelayed(new h(this, instabugViewPager), 300);
                } else if (k() && !this.G.isStoreRatingSurvey()) {
                    return;
                }
                Survey survey = this.G;
                if (survey != null && survey.getQuestions() != null) {
                    if (!this.G.isStoreRatingSurvey() && this.G.getQuestions().size() > currentItem) {
                        this.G.getQuestions().get(currentItem).a(str);
                    }
                } else {
                    return;
                }
            }
            if (str != null && currentItem >= this.f52560d.getCount() - 1) {
                i();
            }
        }
    }

    private void b() {
        Button button = this.H;
        if (button != null && button.getVisibility() == 4) {
            this.H.setVisibility(0);
        }
        InstabugViewPager instabugViewPager = this.I;
        if (instabugViewPager != null && instabugViewPager.getVisibility() == 4) {
            this.I.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void e(int i11) {
        InstabugViewPager instabugViewPager = this.I;
        if (instabugViewPager != null) {
            instabugViewPager.postDelayed(new g(this, i11), 100);
        }
    }

    private void f() {
        if (this.G != null && this.I != null && this.f52562g != null) {
            if (t0()) {
                this.f52562g.b(this.G);
            } else if (!this.G.isNPSSurvey() || !this.G.hasPositiveNpsAnswer()) {
                this.I.scrollBackward(true);
            } else if (this.I.getAdapter() != null) {
                InstabugViewPager instabugViewPager = this.I;
                instabugViewPager.setCurrentItem(instabugViewPager.getAdapter().getCount() > 2 ? this.I.getCurrentItem() - 2 : this.I.getCurrentItem() - 1);
            }
        }
    }

    private void f(int i11) {
        h(i11);
    }

    private void g(int i11) {
        if (this.G != null && this.f52562g != null) {
            if (u0()) {
                if (this.G.isAppStoreRatingEnabled()) {
                    this.G.addRateEvent();
                    if (Instabug.getApplicationContext() != null) {
                        e.b(Instabug.getApplicationContext());
                    } else {
                        return;
                    }
                }
                this.f52562g.a(this.G);
                return;
            }
            f(i11);
        }
    }

    private void h() {
        if (this.G != null && this.H != null && this.f52562g != null) {
            j();
            Button button = this.H;
            if (button == null) {
                return;
            }
            if (!this.G.isAppStoreRatingEnabled() || !c.l()) {
                button.setVisibility(8);
                h hVar = this.f52562g;
                if (hVar != null) {
                    hVar.a(this.G);
                }
            } else if (this.G.getRatingCTATitle() != null) {
                button.setText(this.G.getRatingCTATitle());
            } else {
                button.setText(R.string.surveys_nps_btn_rate_us);
            }
        }
    }

    private void h(int i11) {
        e(i11);
        InstabugViewPager instabugViewPager = this.I;
        if (instabugViewPager != null) {
            instabugViewPager.postDelayed(new i(this), 300);
        }
    }

    private void i() {
        h hVar;
        if (getActivity() != null && this.G != null && (hVar = this.f52562g) != null) {
            com.instabug.survey.utils.c.a(getActivity());
            s0(4);
            j();
            hVar.a(this.G);
        }
    }

    private boolean k() {
        h hVar;
        Survey survey = this.G;
        if (survey == null || (hVar = this.f52562g) == null || !survey.isNPSSurvey()) {
            return true;
        }
        s0(4);
        j();
        hVar.a(this.G);
        return false;
    }

    public static Bundle k0(Survey survey, boolean z11) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("survey", survey);
        bundle.putBoolean("should_show_keyboard", z11);
        return bundle;
    }

    private boolean n() {
        Survey survey = this.G;
        return survey != null && this.f52560d != null && survey.isNPSSurvey() && this.J == (this.f52560d.getCount() - 1) - 1;
    }

    private void r() {
        Survey survey = this.G;
        if (survey != null && this.H != null && this.I != null) {
            if (this.J == 0 && survey.getQuestions().get(0).a() != null) {
                InstabugViewPager instabugViewPager = this.I;
                instabugViewPager.setCurrentItem(instabugViewPager.getCurrentItem() + 1, true);
                this.H.setText(R.string.instabug_str_action_submit);
            } else if (this.I.getCurrentItem() < 1 && this.G.getQuestions().get(0).a() != null) {
                this.I.setCurrentItem(1, true);
                u();
            }
        }
    }

    public void a() {
        if (InstabugCore.getFeatureState(Feature.WHITE_LABELING) == Feature.State.ENABLED && !SettingsManager.getInstance().isCustomBrandingEnabled()) {
            InstabugCore.handlePbiFooter(getView());
        } else if (this.H != null) {
            InstabugCore.handlePbiFooter(getView());
            InstabugCore.handlePbiFooterThemeColor(getView(), R.color.pbi_footer_color_dark, R.color.pbi_footer_color_light);
            ((LinearLayout.LayoutParams) this.H.getLayoutParams()).bottomMargin = DisplayUtils.dpToPxIntRounded(getResources(), 8);
            this.H.requestLayout();
        }
    }

    @CallSuper
    public void a(int i11, Survey survey) {
        Button button = this.H;
        if (button != null) {
            m0(i11, survey.getQuestions().size());
            boolean z11 = false;
            if (!survey.isNPSSurvey()) {
                button.setText((!t0() && u0()) ? R.string.instabug_str_action_submit : R.string.instabug_str_survey_next);
                String a11 = survey.getQuestions().get(i11).a();
                if (a11 == null || a11.trim().isEmpty()) {
                    z11 = true;
                }
                d(!z11);
            } else if (!survey.isNPSSurvey()) {
            } else {
                if (u0()) {
                    h();
                } else if (t0()) {
                    button.setText(R.string.instabug_str_survey_next);
                } else {
                    button.setVisibility(0);
                    button.setText(R.string.instabug_str_action_submit);
                    d(true);
                }
            }
        }
    }

    public void a(b bVar) {
        Survey survey = this.G;
        if (survey != null && survey.getQuestions() != null) {
            this.G.getQuestions().get(a(bVar.c())).a(bVar.a());
            d(true);
        }
    }

    public void b(b bVar) {
        Survey survey = this.G;
        if (survey != null && survey.getQuestions() != null) {
            this.G.getQuestions().get(a(bVar.c())).a(bVar.a());
            d(true);
        }
    }

    public void c(int i11) {
        a aVar;
        if (AccessibilityUtils.isAccessibilityServiceEnabled() && (aVar = this.f52560d) != null) {
            a a11 = aVar.getItem(i11);
            a11.a((View) a11.I);
        }
    }

    public void c(b bVar) {
        if (this.G != null) {
            if (bVar.a() == null || Integer.parseInt(bVar.a()) < 1) {
                d(false);
                return;
            }
            d(true);
            if (this.G.getQuestions() != null) {
                this.G.getQuestions().get(a(bVar.c())).a(bVar.a());
            }
        }
    }

    public void d(int i11) {
    }

    public void d(b bVar) {
        Survey survey = this.G;
        if (survey != null && survey.getQuestions() != null) {
            this.G.getQuestions().get(a(bVar.c())).a(bVar.a());
            String a11 = bVar.a();
            boolean z11 = a11 == null || a11.trim().isEmpty();
            if (!this.G.isNPSSurvey()) {
                d(!z11);
            }
        }
    }

    public void d(boolean z11) {
        FragmentActivity activity;
        int i11;
        Survey survey;
        int parseColor;
        int i12;
        int i13;
        Survey survey2;
        Button button = this.H;
        if (button != null) {
            button.setEnabled(z11);
            if (getActivity() != null) {
                if (z11) {
                    if (!c.n() || (survey2 = this.G) == null || survey2.getType() != 2) {
                        i13 = q0();
                    } else if (InstabugCore.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
                        i13 = ViewCompat.MEASURED_STATE_MASK;
                    } else {
                        DrawableUtils.setColor(button, -1);
                        i12 = ContextCompat.getColor(getActivity(), 17170444);
                        button.setTextColor(i12);
                        return;
                    }
                    DrawableUtils.setColor(button, i13);
                    i12 = ContextCompat.getColor(getActivity(), 17170443);
                    button.setTextColor(i12);
                    return;
                }
                if (InstabugCore.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
                    activity = getActivity();
                    i11 = R.color.survey_btn_disabled_color_light;
                } else if (!c.n() || (survey = this.G) == null || survey.getType() != 2) {
                    button.setTextColor(ContextCompat.getColor(getActivity(), R.color.survey_btn_txt_color_dark));
                    activity = getActivity();
                    i11 = R.color.survey_btn_disabled_color_dark;
                } else {
                    button.setTextColor(-1);
                    parseColor = Color.parseColor("#d9d9d9");
                    DrawableUtils.setColor(button, parseColor);
                }
                parseColor = ContextCompat.getColor(activity, i11);
                DrawableUtils.setColor(button, parseColor);
            }
        }
    }

    public void f(Survey survey) {
        Button button = this.H;
        InstabugViewPager instabugViewPager = this.I;
        if (button != null && instabugViewPager != null) {
            this.K = r0(survey);
            this.f52560d = new a(getChildFragmentManager(), this.K);
            instabugViewPager.addOnPageChangeListener(new e(this));
            instabugViewPager.setOffscreenPageLimit(0);
            instabugViewPager.setAdapter(this.f52560d);
            this.J = 0;
            if (this.f52560d.getCount() <= 1 || survey.getType() == 2) {
                s0(8);
            } else {
                button.setText(n() ? R.string.instabug_str_action_submit : R.string.instabug_str_survey_next);
                m0(0, survey.getQuestions().size());
                instabugViewPager.addOnPageChangeListener(new f(this, survey));
            }
            if (survey.getType() == 2 || (survey.getQuestions().get(0).a() != null && !survey.getQuestions().get(0).a().isEmpty())) {
                d(true);
            } else {
                d(false);
            }
        }
    }

    public void g() {
    }

    public int i0() {
        return R.layout.instabug_dialog_survey;
    }

    public abstract void j();

    @CallSuper
    public void j0(View view, @Nullable Bundle bundle) {
        InstabugViewPager instabugViewPager;
        view.setOnKeyListener(new d(this));
        this.H = (Button) view.findViewById(R.id.instabug_btn_submit);
        this.I = (InstabugViewPager) i(R.id.instabug_survey_pager);
        Button button = this.H;
        if (button != null) {
            button.setOnClickListener(this);
        }
        Survey survey = this.G;
        if (survey != null && survey.getQuestions() != null && (instabugViewPager = this.I) != null) {
            instabugViewPager.setSwipeable(false);
            instabugViewPager.setOffscreenPageLimit(this.G.getQuestions().size());
            if (getActivity() != null && LocaleHelper.isRTL((Context) getActivity())) {
                instabugViewPager.setRotation(180.0f);
            }
        }
    }

    @VisibleForTesting
    public abstract void m0(int i11, int i12);

    public void o() {
        if (this.I != null && !(((Fragment) this.K.get(this.J)) instanceof com.instabug.survey.ui.survey.rateus.b)) {
            this.I.scrollBackward(true);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof SurveyActivity) {
            try {
                this.f52562g = (h) getActivity();
            } catch (Exception unused) {
                throw new RuntimeException("Must implement SurveyActivityCallback ");
            }
        }
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.instabug_btn_submit) {
            a(view);
        } else if (id2 == R.id.instabug_ic_survey_close && SystemClock.elapsedRealtime() - this.f52564i >= 1000) {
            this.f52564i = SystemClock.elapsedRealtime();
            f();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (getArguments() != null) {
            this.G = (Survey) getArguments().getSerializable("survey");
            this.f52563h = getArguments().getBoolean("should_show_keyboard");
        }
        Survey survey = this.G;
        if (survey != null) {
            this.C = new p(this, survey);
        }
    }

    public void onDetach() {
        this.f52562g = null;
        super.onDetach();
    }

    public void onResume() {
        super.onResume();
        if (this.I != null && v0()) {
            e(this.I.getCurrentItem());
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(this.f52561f, this.J);
        super.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
        b();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setFocusableInTouchMode(true);
        p pVar = (p) this.C;
        if (pVar != null) {
            if (w0()) {
                pVar.a();
            }
            pVar.b();
        }
        a(bundle);
    }

    public void p() {
        Survey survey;
        InstabugViewPager instabugViewPager;
        if (getContext() != null && (survey = this.G) != null && (instabugViewPager = this.I) != null) {
            if (!survey.isNPSSurvey()) {
                instabugViewPager.postDelayed(new k(this, instabugViewPager), 200);
            } else if (!LocaleHelper.isRTL(getContext())) {
                r();
            } else if (this.J == 1) {
                instabugViewPager.setCurrentItem(0, true);
            }
        }
    }

    public void q() {
        Survey survey;
        InstabugViewPager instabugViewPager = this.I;
        if (getContext() != null && (survey = this.G) != null && this.H != null && instabugViewPager != null) {
            if (!survey.isNPSSurvey()) {
                instabugViewPager.postDelayed(new j(this, instabugViewPager), 300);
            } else if (LocaleHelper.isRTL(getContext())) {
                r();
            } else if (instabugViewPager.getCurrentItem() != 2) {
                instabugViewPager.setCurrentItem(instabugViewPager.getCurrentItem() - 1, true);
                j();
            }
        }
    }

    public abstract int q0();

    @VisibleForTesting
    public List r0(Survey survey) {
        Object a11;
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 < survey.getQuestions().size()) {
            b bVar = survey.getQuestions().get(i11);
            if (!survey.isNPSSurvey() || bVar.h()) {
                boolean z11 = true;
                boolean z12 = i11 == 0;
                if (bVar.f() == 1) {
                    a11 = com.instabug.survey.ui.survey.mcq.a.a(z12, bVar, this);
                } else if (bVar.f() == 0) {
                    if (survey.getType() != 2 && !z12) {
                        z11 = false;
                    }
                    a11 = c.n() ? com.instabug.survey.ui.survey.text.customized.a.b(z11, bVar, this) : com.instabug.survey.ui.survey.text.b.a(z11, bVar, this);
                } else if (bVar.f() == 2) {
                    a11 = com.instabug.survey.ui.survey.starrating.a.a(z12, bVar, (n) this);
                } else if (bVar.f() == 3) {
                    s0(8);
                    a11 = com.instabug.survey.ui.survey.nps.a.a(z12, bVar, this);
                }
                arrayList.add(a11);
            }
            i11++;
        }
        if (survey.isNPSSurvey()) {
            arrayList.add(com.instabug.survey.ui.survey.rateus.a.a(survey, this));
        }
        return arrayList;
    }

    public abstract void s0(int i11);

    public boolean t0() {
        InstabugViewPager instabugViewPager = this.I;
        return instabugViewPager != null && instabugViewPager.getCurrentItem() == 0;
    }

    public abstract void u();

    public boolean u0() {
        InstabugViewPager instabugViewPager = this.I;
        return (instabugViewPager == null || this.f52560d == null || instabugViewPager.getCurrentItem() != this.f52560d.getCount() - 1) ? false : true;
    }

    public abstract boolean v0();

    public boolean w0() {
        return true;
    }
}
