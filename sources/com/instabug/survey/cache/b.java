package com.instabug.survey.cache;

import androidx.annotation.Nullable;
import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.survey.models.Survey;

class b implements ReturnableRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f52308a;

    public b(long j11) {
        this.f52308a = j11;
    }

    @Nullable
    /* renamed from: a */
    public Survey run() {
        return m.b(this.f52308a);
    }
}
