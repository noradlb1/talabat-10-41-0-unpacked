package com.instabug.survey.ui.survey.text.partial;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.Nullable;
import com.instabug.survey.R;
import com.instabug.survey.models.Survey;
import com.instabug.survey.models.b;
import com.instabug.survey.ui.SurveyActivity;
import com.instabug.survey.ui.survey.text.c;

public class a extends c {
    public static a a(Survey survey, b bVar) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("survey", survey);
        bundle.putSerializable("question", bVar);
        a aVar = new a();
        aVar.setArguments(bundle);
        return aVar;
    }

    public static a i(Survey survey) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("survey", survey);
        bundle.putSerializable("question", survey.getQuestions().get(0));
        a aVar = new a();
        aVar.setArguments(bundle);
        return aVar;
    }

    public void j0(View view, @Nullable Bundle bundle) {
        super.j0(view, bundle);
        if (getActivity() != null && (getActivity() instanceof SurveyActivity)) {
            ((SurveyActivity) getActivity()).d(true);
        }
        EditText editText = this.N;
        if (this.M != null && editText != null) {
            editText.setFocusable(false);
            this.M.setOnClickListener(this);
            editText.setOnClickListener(this);
            d(editText.getId());
            View view2 = this.J;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            Survey survey = this.L;
            if (survey != null && survey.isStoreRatingSurvey()) {
                l0(this.L, true);
            }
        }
    }

    public void onClick(View view) {
        if (this.L != null) {
            if (view.getId() == R.id.instabug_edit_text_answer) {
                l0(this.L, true);
            } else {
                super.onClick(view);
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
