package com.instabug.survey.cache;

import com.instabug.survey.models.Survey;

class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Survey f52305b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f52306c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f52307d;

    public a(Survey survey, boolean z11, boolean z12) {
        this.f52305b = survey;
        this.f52306c = z11;
        this.f52307d = z12;
    }

    public void run() {
        m.a(this.f52305b, this.f52306c, this.f52307d);
    }
}
