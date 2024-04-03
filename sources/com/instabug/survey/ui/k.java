package com.instabug.survey.ui;

import com.instabug.survey.cache.l;
import com.instabug.survey.models.Survey;

class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Survey f52522b;

    public k(l lVar, Survey survey) {
        this.f52522b = survey;
    }

    public void run() {
        l.c(this.f52522b);
    }
}
