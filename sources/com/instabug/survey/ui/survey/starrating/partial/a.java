package com.instabug.survey.ui.survey.starrating.partial;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.instabug.library.util.OrientationUtils;
import com.instabug.survey.models.Survey;
import com.instabug.survey.ui.SurveyActivity;
import com.instabug.survey.ui.custom.j;
import com.instabug.survey.ui.survey.starrating.b;

public class a extends b {
    public static a i(Survey survey) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("survey", survey);
        bundle.putSerializable("question", survey.getQuestions().get(0));
        a aVar = new a();
        aVar.setArguments(bundle);
        return aVar;
    }

    public void a(j jVar, float f11, boolean z11) {
        Survey survey;
        if (this.N != null && (survey = this.L) != null && survey.getQuestions() != null && this.L.getQuestions().size() != 0) {
            this.N.a(f11, false);
            this.L.getQuestions().get(0).a(String.valueOf((int) f11));
            l0(this.L, false);
        }
    }

    public void j0(View view, @Nullable Bundle bundle) {
        View view2;
        j jVar;
        super.j0(view, bundle);
        if (getActivity() != null) {
            ((SurveyActivity) getActivity()).d(true);
            if (this.M != null && (view2 = this.J) != null) {
                view2.setVisibility(0);
                j jVar2 = this.N;
                if (jVar2 != null) {
                    d(jVar2.getId());
                }
                if (OrientationUtils.isInLandscape(getActivity()) && (jVar = this.N) != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) jVar.getLayoutParams();
                    layoutParams.setMargins(0, 8, 0, 8);
                    this.N.setLayoutParams(layoutParams);
                    this.N.requestLayout();
                }
            }
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.L = (Survey) getArguments().getSerializable("survey");
        }
    }
}
