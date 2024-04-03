package com.instabug.survey.ui.survey;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import com.instabug.library.core.ui.InstabugBaseFragment;
import com.instabug.library.util.AccessibilityUtils;
import com.instabug.library.util.LocaleHelper;
import com.instabug.library.util.OrientationUtils;
import com.instabug.survey.R;
import com.instabug.survey.models.Survey;
import com.instabug.survey.models.b;
import com.instabug.survey.ui.SurveyActivity;
import com.instabug.survey.ui.gestures.d;
import com.instabug.survey.ui.gestures.e;
import com.instabug.survey.ui.h;
import com.instabug.survey.ui.n;
import java.util.Iterator;

public abstract class a extends InstabugBaseFragment implements View.OnClickListener, d {
    @Nullable
    public b G;
    @Nullable
    public n H;
    @Nullable
    public TextView I;
    @Nullable
    public View J;
    @Nullable
    public RelativeLayout K;
    @Nullable
    public Survey L;

    public void a(@Nullable View view) {
        if (view != null) {
            view.performAccessibilityAction(64, new Bundle());
            view.sendAccessibilityEvent(4);
        }
    }

    public void a(@NonNull n nVar) {
        this.H = nVar;
    }

    public void b() {
        Survey survey = this.L;
        if (survey != null) {
            l0(survey, false);
        }
    }

    public void e() {
        Survey survey = this.L;
        if (survey != null) {
            if (!survey.isNPSSurvey() || !(this instanceof com.instabug.survey.ui.survey.rateus.b)) {
                if (getActivity() instanceof h) {
                    ((h) getActivity()).b(this.L);
                }
            } else if (getActivity() instanceof h) {
                ((h) getActivity()).a(this.L);
            }
        }
    }

    @Nullable
    public abstract String f();

    public void g() {
        TextView textView;
        if (getActivity() != null && (textView = this.I) != null && OrientationUtils.isInLandscape(getActivity())) {
            textView.setMaxLines(3);
        }
    }

    public abstract boolean h();

    @CallSuper
    public void j0(View view, @Nullable Bundle bundle) {
        RelativeLayout relativeLayout;
        if (getActivity() != null) {
            if (getActivity() instanceof SurveyActivity) {
                ((SurveyActivity) getActivity()).d(false);
            }
            if (getContext() != null) {
                this.J = i(R.id.survey_shadow);
                this.I = (TextView) view.findViewById(R.id.instabug_text_view_question);
                this.K = (RelativeLayout) i(R.id.instabug_survey_dialog_container);
                if (AccessibilityUtils.isAccessibilityServiceEnabled() && (relativeLayout = this.K) != null) {
                    int i11 = Build.VERSION.SDK_INT;
                    relativeLayout.setImportantForAccessibility(2);
                    if (i11 >= 28) {
                        this.K.setScreenReaderFocusable(false);
                    }
                }
                if (getContext() != null && !h() && LocaleHelper.isRTL(getContext())) {
                    view.setRotation(180.0f);
                }
                if (!(this instanceof com.instabug.survey.ui.survey.rateus.a)) {
                    k0(this.I);
                }
            }
        }
    }

    public void k0(@Nullable TextView textView) {
        Survey survey;
        if (AccessibilityUtils.isAccessibilityServiceEnabled() && (survey = this.L) != null && survey.getQuestions().size() > 1 && this.G != null && textView != null) {
            int size = this.L.getQuestions().size();
            textView.setContentDescription(getString(R.string.ibg_surveys_question_order_content_description, Integer.valueOf(this.L.getQuestions().indexOf(this.G) + 1), Integer.valueOf(size), this.G.e()));
        }
    }

    public void l0(Survey survey, boolean z11) {
        n nVar;
        SurveyActivity surveyActivity;
        if (getActivity() != null && (getActivity() instanceof SurveyActivity)) {
            if (survey != null && survey.getQuestions() != null && survey.getQuestions().size() > 0) {
                if (survey.getType() == 2 || survey.getQuestions().get(0).f() == 3) {
                    surveyActivity = (SurveyActivity) getActivity();
                    nVar = n.PRIMARY;
                } else {
                    if (survey.getQuestions().get(0).f() == 2) {
                        ((SurveyActivity) getActivity()).a(n.PRIMARY, true);
                        Iterator<b> it = survey.getQuestions().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (it.next().f() != 2) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    surveyActivity = (SurveyActivity) getActivity();
                    nVar = n.SECONDARY;
                }
                surveyActivity.a(nVar, true);
            }
            if (getActivity() != null && getActivity().getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) {
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(0, 0).replace(R.id.instabug_fragment_container, m.b(survey, z11)).commit();
            }
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        if (getActivity() != null) {
            if (getActivity() instanceof SurveyActivity) {
                this.L = ((SurveyActivity) getActivity()).e();
            }
            super.onCreate(bundle);
        }
    }

    public void onDestroy() {
        e.a();
        super.onDestroy();
    }
}
