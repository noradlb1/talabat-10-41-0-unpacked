package com.instabug.survey.common;

import com.instabug.library.util.threading.PoolProvider;
import com.instabug.survey.models.Survey;

class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Survey f52318b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f52319c;

    public c(d dVar, Survey survey) {
        this.f52319c = dVar;
        this.f52318b = survey;
    }

    public synchronized void run() {
        PoolProvider.postIOTaskWithCheck(new b(this));
    }
}
