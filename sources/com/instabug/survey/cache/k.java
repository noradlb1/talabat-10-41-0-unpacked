package com.instabug.survey.cache;

import com.instabug.survey.models.Survey;

class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Survey f52314b;

    public k(Survey survey) {
        this.f52314b = survey;
    }

    public void run() {
        m.c(this.f52314b);
    }
}
