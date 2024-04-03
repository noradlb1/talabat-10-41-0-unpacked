package com.instabug.survey.network.service;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.IBGNetworkWorker;
import com.instabug.library.InstabugNetworkJob;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.cache.l;
import com.instabug.survey.common.models.f;
import com.instabug.survey.di.a;
import com.instabug.survey.models.Survey;
import java.util.ArrayList;
import java.util.List;

public class c extends InstabugNetworkJob {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private static c f52413a;

    private c() {
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (f52413a == null) {
                f52413a = new c();
            }
            cVar = f52413a;
        }
        return cVar;
    }

    private static void a(@NonNull Context context, @NonNull Survey survey) {
        g.a().a(context, survey, new a(survey));
    }

    /* access modifiers changed from: private */
    public static void b(@NonNull Context context) {
        InstabugSDKLogger.d("IBG-Surveys", "submitSurveys started");
        List<Survey> a11 = l.a();
        InstabugSDKLogger.d("IBG-Surveys", "ready to send surveys size: " + a11.size());
        if (a.b().d()) {
            for (Survey b11 : a11) {
                b(b11);
            }
            l.b((List) a11);
            return;
        }
        for (Survey a12 : a11) {
            a(context, a12);
        }
    }

    /* access modifiers changed from: private */
    public static void b(@NonNull Survey survey) {
        survey.setSurveyState(f.SYNCED);
        if (survey.isLastEventSubmit()) {
            survey.clearAnswers();
        }
        if (survey.getSurveyEvents() != null) {
            ArrayList<com.instabug.survey.common.models.a> surveyEvents = survey.getSurveyEvents();
            if (!surveyEvents.isEmpty()) {
                com.instabug.survey.common.models.a aVar = surveyEvents.get(surveyEvents.size() - 1);
                aVar.a(true);
                survey.getSurveyEvents().clear();
                survey.getSurveyEvents().add(aVar);
            }
        }
    }

    public void start() {
        b(IBGNetworkWorker.SURVEYS, new b(this));
    }
}
