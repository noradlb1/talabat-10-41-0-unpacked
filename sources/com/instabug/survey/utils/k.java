package com.instabug.survey.utils;

import com.instabug.survey.models.Survey;
import java.util.Comparator;

class k implements Comparator {
    public k(m mVar) {
    }

    /* renamed from: a */
    public int compare(Survey survey, Survey survey2) {
        return Long.compare(survey.getDismissedAt(), survey2.getDismissedAt());
    }
}
