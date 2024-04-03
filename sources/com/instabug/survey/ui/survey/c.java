package com.instabug.survey.ui.survey;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.instabug.library.util.AccessibilityUtils;
import com.instabug.survey.R;
import com.instabug.survey.models.Survey;
import com.instabug.survey.ui.SurveyActivity;
import com.instabug.survey.ui.gestures.e;
import com.instabug.survey.ui.n;
import com.instabug.survey.ui.survey.rateus.b;
import com.instabug.survey.ui.survey.text.partial.a;

public abstract class c extends a implements View.OnTouchListener {
    @Nullable
    public ImageView M;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private GestureDetector f52548h;

    public void d(int i11) {
        ImageView imageView;
        if (AccessibilityUtils.isAccessibilityServiceEnabled() && (imageView = this.M) != null) {
            imageView.setAccessibilityTraversalAfter(i11);
        }
    }

    public void h(Survey survey) {
        if (getActivity() == null) {
            return;
        }
        if (!survey.isNPSSurvey() || !(this instanceof b)) {
            ((SurveyActivity) getActivity()).h(survey);
        } else {
            ((SurveyActivity) getActivity()).a(survey);
        }
    }

    public boolean h() {
        return (this instanceof a) || (this instanceof com.instabug.survey.ui.survey.mcq.partial.b) || (this instanceof com.instabug.survey.ui.survey.starrating.partial.a) || (this instanceof com.instabug.survey.ui.survey.nps.partial.a);
    }

    public void j0(View view, @Nullable Bundle bundle) {
        super.j0(view, bundle);
        ImageView imageView = (ImageView) i(R.id.survey_partial_close_btn);
        this.M = imageView;
        if (!(imageView == null || this.L == null)) {
            d(imageView.getRootView().getId());
            if (this.L.isDismissible()) {
                imageView.setVisibility(0);
                imageView.setOnClickListener(this);
            } else {
                imageView.setVisibility(8);
            }
        }
        RelativeLayout relativeLayout = this.K;
        if (relativeLayout != null) {
            Survey survey = this.L;
            if (survey != null && survey.isDismissible()) {
                relativeLayout.setOnTouchListener(this);
            }
            relativeLayout.setOnClickListener(this);
        }
    }

    public void onClick(View view) {
        if (this.L != null) {
            int id2 = view.getId();
            if (id2 == R.id.survey_partial_close_btn) {
                h(this.L);
            } else if (id2 == R.id.instabug_survey_dialog_container || !(id2 != R.id.instabug_text_view_question || getActivity() == null || ((SurveyActivity) getActivity()).b() == n.SECONDARY)) {
                l0(this.L, false);
            }
        }
    }

    public void onResume() {
        boolean z11;
        n nVar;
        SurveyActivity surveyActivity;
        super.onResume();
        if (this.L != null && getActivity() != null && (getActivity() instanceof SurveyActivity)) {
            if (this instanceof a) {
                if (this.L.isStoreRatingSurvey()) {
                    surveyActivity = (SurveyActivity) getActivity();
                    nVar = n.PRIMARY;
                    z11 = true;
                } else {
                    surveyActivity = (SurveyActivity) getActivity();
                    nVar = n.PARTIAL;
                    z11 = false;
                }
                surveyActivity.a(nVar, z11);
            }
            e.b();
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (getActivity() == null) {
            return false;
        }
        com.instabug.survey.utils.c.a(getActivity());
        e.a(view, motionEvent, h(), false, this);
        if (this.f52548h == null && getContext() != null) {
            this.f52548h = new GestureDetector(getContext(), new com.instabug.survey.ui.gestures.b(new b(this)));
        }
        GestureDetector gestureDetector = this.f52548h;
        if (gestureDetector == null) {
            return true;
        }
        gestureDetector.onTouchEvent(motionEvent);
        return true;
    }
}
