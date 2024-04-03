package com.instabug.featuresrequest.ui.newfeature;

import com.instabug.featuresrequest.R;

class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j f46824b;

    public i(j jVar) {
        this.f46824b = jVar;
    }

    public void run() {
        if (this.f46824b.f46826b.f46827a != null) {
            this.f46824b.f46826b.f46827a.r();
            this.f46824b.f46826b.f46827a.b(R.string.feature_request_str_add_comment_error);
        }
    }
}
