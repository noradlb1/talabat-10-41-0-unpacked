package com.instabug.survey.ui;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.TimeUtils;
import com.instabug.library.util.threading.PoolProvider;
import com.instabug.survey.callbacks.OnFinishCallback;
import com.instabug.survey.common.f;
import com.instabug.survey.models.State;
import com.instabug.survey.models.Survey;
import com.instabug.survey.network.util.a;
import com.instabug.survey.settings.b;
import com.instabug.survey.settings.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONException;

public class l extends BasePresenter {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private n f52523a;

    public l(i iVar) {
        super(iVar);
    }

    private void a(Survey survey, String str) {
        OnFinishCallback h11 = c.h();
        if (h11 != null) {
            try {
                h11.onFinish(Long.toString(survey.getId()), str, a.a(survey, str));
            } catch (JSONException e11) {
                InstabugSDKLogger.e("IBG-Surveys", "Something went wrong during parsing Survey object in onFinishCallback", e11);
            }
        }
    }

    private boolean c(Survey survey) {
        return !survey.isGooglePlayAppRating() && !TextUtils.isEmpty(survey.getQuestions().get(2).a());
    }

    @Nullable
    public n a() {
        return this.f52523a;
    }

    public void a(Survey survey) {
        i iVar;
        if (survey != null) {
            survey.setDismissed();
            if (survey.isCancelled() && survey.getSessionCounter() >= c.j()) {
                if (survey.isOptInSurvey()) {
                    survey.setShouldShowAgain(true);
                    survey.resetSessionsCounter();
                } else if (survey.getSessionCounter() != 0) {
                    survey.setShouldShowAgain(false);
                }
            }
            a(survey, b(survey));
            com.instabug.survey.cache.l.c(survey);
            if (b.c() != null) {
                b.c().c(TimeUtils.currentTimeMillis());
            }
            if (this.f34200f.get() != null && (iVar = (i) this.f34200f.get()) != null && iVar.getViewContext() != null) {
                com.instabug.survey.network.service.c.a().start();
                iVar.c(false);
            }
        }
    }

    public void a(n nVar, boolean z11) {
        i iVar;
        FragmentActivity fragmentActivity;
        this.f52523a = nVar;
        WeakReference<V> weakReference = this.f34200f;
        if (weakReference != null && (iVar = (i) weakReference.get()) != null && iVar.getViewContext() != null && (fragmentActivity = (FragmentActivity) iVar.getViewContext()) != null) {
            int a11 = f.a(fragmentActivity, nVar);
            if (z11) {
                iVar.a(a11);
            } else {
                iVar.b(a11);
            }
        }
    }

    @VisibleForTesting
    public String b(Survey survey) {
        if (survey.getType() == 0 || survey.getType() == 1) {
            return State.DISMISSED;
        }
        ArrayList<com.instabug.survey.models.b> questions = survey.getQuestions();
        int i11 = 0;
        while (i11 < questions.size()) {
            String a11 = questions.get(i11).a();
            if (a11 == null || a11.equals("")) {
                return i11 == 0 ? State.DISMISSED : State.ENDED;
            }
            i11++;
        }
        return State.SUBMITTED;
    }

    public void b() {
        i iVar;
        FragmentActivity fragmentActivity;
        if (this.f34200f.get() != null && (iVar = (i) this.f34200f.get()) != null && iVar.getViewContext() != null && (fragmentActivity = (FragmentActivity) iVar.getViewContext()) != null && fragmentActivity.getSupportFragmentManager().getFragments().size() > 0) {
            for (Fragment next : fragmentActivity.getSupportFragmentManager().getFragments()) {
                if (next instanceof com.instabug.survey.ui.survey.l) {
                    ((com.instabug.survey.ui.survey.l) next).o();
                    return;
                }
            }
        }
    }

    public boolean c() {
        return c.r().booleanValue();
    }

    public void d(Survey survey) {
        i iVar;
        survey.setSubmitted();
        PoolProvider.postIOTask(new k(this, survey));
        if (b.c() != null) {
            b.c().c(TimeUtils.currentTimeMillis());
        }
        a(survey, State.SUBMITTED);
        if (this.f34200f.get() != null && (iVar = (i) this.f34200f.get()) != null && iVar.getViewContext() != null) {
            com.instabug.survey.network.service.c.a().start();
            boolean z11 = true;
            if (survey.isNPSSurvey()) {
                if (!survey.isAppStoreRatingEnabled() || !c.l()) {
                    z11 = false;
                }
                iVar.b(z11);
            } else if (survey.isStoreRatingSurvey()) {
                iVar.c(c(survey));
            } else {
                iVar.c(true);
            }
        }
    }
}
