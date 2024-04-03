package com.instabug.survey.ui.survey.text.customized;

import android.os.Bundle;
import com.instabug.survey.models.Survey;
import com.instabug.survey.settings.c;
import com.instabug.survey.ui.SurveyActivity;
import com.instabug.survey.ui.h;
import com.instabug.survey.ui.survey.n;
import com.instabug.survey.ui.survey.text.b;

public class a extends b {
    public static a b(boolean z11, com.instabug.survey.models.b bVar, n nVar) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("question", bVar);
        bundle.putBoolean("should_change_container_height", z11);
        a aVar = new a();
        aVar.setArguments(bundle);
        aVar.a(nVar);
        return aVar;
    }

    public void e() {
        if (this.L != null) {
            if (c.n()) {
                if (getActivity() instanceof h) {
                    com.instabug.survey.models.b bVar = this.G;
                    if (bVar != null) {
                        bVar.a((String) null);
                    }
                    ((h) getActivity()).a(this.L);
                }
            } else if (getActivity() instanceof h) {
                ((h) getActivity()).b(this.L);
            }
        }
    }

    public void h(Survey survey) {
        if (getActivity() != null && (getActivity() instanceof SurveyActivity)) {
            ((SurveyActivity) getActivity()).a(survey);
        }
    }
}
