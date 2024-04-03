package com.instabug.survey.ui.popup;

import androidx.fragment.app.Fragment;
import com.instabug.survey.models.Survey;
import com.instabug.survey.models.b;
import com.instabug.survey.ui.j;
import com.instabug.survey.ui.survey.text.partial.a;

public abstract class n extends h {
    public void k0(Survey survey, b bVar) {
        j.a(getFragmentManager(), (Fragment) a.a(survey, bVar), 0, 0);
    }
}
