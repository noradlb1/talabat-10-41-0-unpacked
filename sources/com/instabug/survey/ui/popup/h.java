package com.instabug.survey.ui.popup;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.instabug.library.core.ui.InstabugBaseFragment;
import com.instabug.survey.R;
import com.instabug.survey.models.Survey;
import com.instabug.survey.models.b;
import com.instabug.survey.utils.e;

public abstract class h extends InstabugBaseFragment implements m {
    @Nullable
    public q G;

    /* renamed from: b  reason: collision with root package name */
    private com.instabug.survey.ui.h f52540b;

    public void a(Survey survey) {
        this.f52540b.a(survey);
    }

    public void b(Survey survey) {
        this.f52540b.b(survey);
    }

    public void c(Survey survey) {
        b secondaryNegativeQuestion = survey.getSecondaryNegativeQuestion();
        if (getFragmentManager() != null && secondaryNegativeQuestion != null) {
            k0(survey, secondaryNegativeQuestion);
        }
    }

    public void d(Survey survey) {
        this.f52540b.a(survey);
    }

    public void e(Survey survey) {
        this.f52540b.a(survey);
    }

    public void g(Survey survey) {
        if (getContext() != null) {
            e.b(getContext());
            this.f52540b.a(survey);
        }
    }

    public int i0() {
        return R.layout.instabug_dialog_popup_survey;
    }

    public void j0(View view, @Nullable Bundle bundle) {
        Survey survey = getArguments() != null ? (Survey) getArguments().getSerializable("KEY_SURVEY_ARGUMENT") : null;
        if (survey != null) {
            q qVar = new q(this, survey);
            this.G = qVar;
            qVar.i();
        }
    }

    public abstract void k0(Survey survey, b bVar);

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.f52540b = (com.instabug.survey.ui.h) context;
        } catch (IllegalStateException unused) {
            throw new IllegalStateException("Survey Activity must implement SurveyActivityCallback");
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }
}
