package com.instabug.survey.ui.survey.mcq.partial;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import androidx.annotation.Nullable;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.core.InstabugCore;
import com.instabug.survey.R;
import com.instabug.survey.models.Survey;
import com.instabug.survey.ui.SurveyActivity;
import org.jetbrains.annotations.NotNull;

public class b extends com.instabug.survey.ui.survey.mcq.b {
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private View f52579k;

    public static b i(Survey survey) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("survey", survey);
        bundle.putSerializable("question", survey.getQuestions().get(0));
        b bVar = new b();
        bVar.setArguments(bundle);
        return bVar;
    }

    public void a(View view, String str) {
        Survey survey = this.L;
        if (survey != null && survey.getQuestions() != null && this.L.getQuestions().size() != 0) {
            this.L.getQuestions().get(0).a(str);
            l0(this.L, false);
        }
    }

    public void j0(View view, @Nullable Bundle bundle) {
        int i11;
        View view2;
        super.j0(view, bundle);
        this.f52579k = i(R.id.survey_mcq_fade);
        if (getActivity() != null) {
            ((SurveyActivity) getActivity()).d(true);
            View view3 = this.J;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            GridView gridView = this.O;
            if (gridView != null) {
                gridView.setEnabled(true);
                this.O.setVerticalScrollBarEnabled(false);
            }
            if (this.f52579k != null) {
                if (InstabugCore.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
                    view2 = this.f52579k;
                    i11 = R.drawable.ibg_survey_mcq_fade_light;
                } else {
                    view2 = this.f52579k;
                    i11 = R.drawable.ibg_survey_mcq_fade_dark;
                }
                view2.setBackgroundResource(i11);
                this.f52579k.setVisibility(0);
                d(R.id.instabug_survey_mcq_grid_container);
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
        GridView gridView = this.O;
        if (gridView != null) {
            gridView.setOnScrollListener(new a(this));
        }
    }
}
