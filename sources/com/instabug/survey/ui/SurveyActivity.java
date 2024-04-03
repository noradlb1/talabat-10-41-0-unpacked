package com.instabug.survey.ui;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.instabug.survey.models.Survey;

public class SurveyActivity extends g {
    public void i(@Nullable Bundle bundle) {
        if (this.f34199i == null) {
            return;
        }
        if (bundle != null) {
            n nVar = n.PARTIAL;
            ((l) this.f34199i).a(n.a(bundle.getInt("viewType", nVar.a()), nVar), false);
            return;
        }
        Survey survey = this.f52512m;
        if (survey == null || !survey.isStoreRatingSurvey()) {
            ((l) this.f34199i).a(n.PARTIAL, false);
        } else {
            ((l) this.f34199i).a(n.PRIMARY, true);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f52511l.setFocusableInTouchMode(true);
    }
}
