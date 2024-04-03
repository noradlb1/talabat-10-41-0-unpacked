package com.instabug.survey.ui.popup;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import com.google.android.play.core.review.ReviewInfo;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.survey.a;
import com.instabug.survey.models.Survey;
import com.instabug.survey.models.b;
import com.instabug.survey.settings.c;
import com.instabug.survey.utils.e;
import java.util.ArrayList;

public class q extends BasePresenter {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private Survey f52544a;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public ReviewInfo f52545g = null;

    public q(m mVar, @NonNull Survey survey) {
        super(mVar);
        this.f52544a = survey;
        if (survey.isGooglePlayAppRating() && mVar.getViewContext() != null && ((Fragment) mVar.getViewContext()).getActivity() != null) {
            e.a((Activity) ((Fragment) mVar.getViewContext()).getActivity(), (a) new o(this));
        }
    }

    public void a() {
        Survey survey;
        m mVar = (m) this.f34200f.get();
        if (mVar != null && (survey = this.f52544a) != null) {
            mVar.b(survey);
        }
    }

    @VisibleForTesting
    public void b() {
        ArrayList d11;
        ArrayList<b> questions = this.f52544a.getQuestions();
        if (questions != null && !questions.isEmpty() && (d11 = questions.get(0).d()) != null && !d11.isEmpty()) {
            questions.get(0).a((String) d11.get(0));
            m mVar = (m) this.f34200f.get();
            if (mVar != null) {
                mVar.e(this.f52544a);
            }
        }
    }

    public void c() {
        ArrayList d11;
        ArrayList<b> questions = this.f52544a.getQuestions();
        if (questions != null && questions.size() >= 2 && (d11 = this.f52544a.getQuestions().get(0).d()) != null && d11.size() >= 2 && this.f52544a.getQuestions().get(1).d() != null && this.f52544a.getQuestions().get(1).d().size() != 0) {
            this.f52544a.getQuestions().get(1).a((String) this.f52544a.getQuestions().get(1).d().get(1));
            m mVar = (m) this.f34200f.get();
            if (mVar != null) {
                mVar.d(this.f52544a);
            }
        }
    }

    public void d() {
        ArrayList d11 = this.f52544a.getQuestions().get(0).d();
        if (d11 != null) {
            this.f52544a.getQuestions().get(0).a((String) d11.get(0));
        }
        if (!c.l()) {
            b();
        } else if (!this.f52544a.isGooglePlayAppRating()) {
            h();
        } else {
            j();
            f();
        }
    }

    public void e() {
        ArrayList d11;
        ArrayList<b> questions = this.f52544a.getQuestions();
        if (questions != null && questions.size() >= 2 && (d11 = this.f52544a.getQuestions().get(0).d()) != null && !d11.isEmpty()) {
            if (this.f52544a.getQuestions().get(1).d() != null && this.f52544a.getQuestions().get(1).d().size() != 0) {
                this.f52544a.getQuestions().get(1).a((String) this.f52544a.getQuestions().get(1).d().get(0));
            } else {
                return;
            }
        }
        this.f52544a.addRateEvent();
        m mVar = (m) this.f34200f.get();
        if (mVar != null) {
            mVar.g(this.f52544a);
        }
    }

    public void f() {
        m mVar = (m) this.f34200f.get();
        if (mVar != null && this.f52545g != null && mVar.getViewContext() != null && ((Fragment) mVar.getViewContext()).getActivity() != null) {
            e.a(((Fragment) mVar.getViewContext()).getActivity(), this.f52545g, new p(this));
        }
    }

    public void g() {
        b bVar;
        ArrayList<b> questions = this.f52544a.getQuestions();
        if (questions != null && !questions.isEmpty() && (bVar = this.f52544a.getQuestions().get(0)) != null && bVar.d() != null && bVar.d().size() >= 2) {
            bVar.a((String) bVar.d().get(1));
            m mVar = (m) this.f34200f.get();
            if (mVar != null) {
                mVar.c(this.f52544a);
            }
        }
    }

    public void h() {
        ArrayList<b> questions = this.f52544a.getQuestions();
        if (questions != null && questions.size() >= 2) {
            b bVar = questions.get(1);
            m mVar = (m) this.f34200f.get();
            if (mVar != null && bVar != null && bVar.d() != null && bVar.d().size() >= 2) {
                mVar.b((String) null, bVar.e(), (String) bVar.d().get(0), (String) bVar.d().get(1));
            }
        }
    }

    public void i() {
        ArrayList<b> questions;
        ArrayList d11;
        Survey survey = this.f52544a;
        if (survey != null && (questions = survey.getQuestions()) != null && !questions.isEmpty()) {
            b bVar = this.f52544a.getQuestions().get(0);
            m mVar = (m) this.f34200f.get();
            if (mVar != null && bVar != null && (d11 = bVar.d()) != null && d11.size() >= 2) {
                mVar.a((String) null, bVar.e(), (String) d11.get(0), (String) d11.get(1));
            }
        }
    }

    public void j() {
        Survey survey;
        m mVar = (m) this.f34200f.get();
        if (mVar != null && (survey = this.f52544a) != null) {
            mVar.a(survey);
        }
    }
}
