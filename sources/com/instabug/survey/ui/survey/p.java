package com.instabug.survey.ui.survey;

import android.text.TextUtils;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.survey.models.Survey;
import java.lang.ref.WeakReference;

public class p extends BasePresenter {

    /* renamed from: a  reason: collision with root package name */
    private Survey f52580a;

    public p(o oVar, Survey survey) {
        super(oVar);
        this.f52580a = survey;
    }

    public void a() {
        o oVar;
        WeakReference<V> weakReference = this.f34200f;
        if (weakReference != null && (oVar = (o) weakReference.get()) != null) {
            oVar.a();
        }
    }

    public boolean a(Survey survey) {
        return survey.getType() == 2;
    }

    public boolean a(Survey survey, int i11) {
        if (a(survey)) {
            i11 = survey.isGooglePlayAppRating() ? 1 : 2;
        }
        if (i11 < survey.getQuestions().size()) {
            try {
                return !TextUtils.isEmpty(survey.getQuestions().get(i11).a());
            } catch (Exception e11) {
                IBGDiagnostics.reportNonFatal(e11, "Error while getting question from survey questions list");
            }
        }
        return false;
    }

    public void b() {
        o oVar;
        WeakReference<V> weakReference = this.f34200f;
        if (weakReference != null && weakReference.get() != null && (oVar = (o) this.f34200f.get()) != null) {
            oVar.f(this.f52580a);
        }
    }
}
