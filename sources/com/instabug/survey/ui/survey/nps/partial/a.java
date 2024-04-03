package com.instabug.survey.ui.survey.nps.partial;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.instabug.survey.models.Survey;
import com.instabug.survey.ui.SurveyActivity;
import com.instabug.survey.ui.custom.NpsView;
import com.instabug.survey.ui.survey.nps.b;
import org.jetbrains.annotations.NotNull;

public class a extends b {
    public static a i(Survey survey) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("survey", survey);
        bundle.putSerializable("question", survey.getQuestions().get(0));
        a aVar = new a();
        aVar.setArguments(bundle);
        return aVar;
    }

    public void c(int i11) {
        Survey survey = this.L;
        if (survey != null && survey.getQuestions() != null && this.L.getQuestions().size() > 0) {
            this.L.getQuestions().get(0).a(String.valueOf(i11));
            l0(this.L, false);
        }
    }

    public void j0(View view, @Nullable Bundle bundle) {
        super.j0(view, bundle);
        if (getActivity() != null) {
            ((SurveyActivity) getActivity()).d(true);
            View view2 = this.J;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            NpsView npsView = this.N;
            if (npsView != null) {
                d(npsView.getId());
            }
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.L = (Survey) getArguments().getSerializable("survey");
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
