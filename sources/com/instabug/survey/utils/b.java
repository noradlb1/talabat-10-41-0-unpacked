package com.instabug.survey.utils;

import com.instabug.library.util.TimeUtils;
import com.instabug.survey.common.models.d;
import com.instabug.survey.models.Survey;
import java.util.concurrent.TimeUnit;

public class b {
    public int a(long j11, long j12) {
        return (int) TimeUnit.DAYS.convert(j12 - j11, TimeUnit.MILLISECONDS);
    }

    public boolean b(Survey survey) {
        d d11 = survey.getTarget().d();
        int c11 = d11.c();
        boolean shouldReshowAfterDismiss = survey.shouldReshowAfterDismiss();
        if (c11 == 1) {
            return shouldReshowAfterDismiss || (!survey.isPaused() && !survey.isAnswered() && !survey.isCancelled() && !survey.isLastEventDismiss());
        }
        int b11 = d11.b();
        return shouldReshowAfterDismiss || ((d11.c() == 0) && a(survey.getShownAt() * 1000, TimeUtils.currentTimeMillis()) >= b11);
    }

    public boolean c(Survey survey) {
        return b(survey);
    }
}
