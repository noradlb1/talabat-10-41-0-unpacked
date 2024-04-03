package com.instabug.survey.cache;

import androidx.annotation.Nullable;
import com.instabug.library.apichecker.ReturnableRunnable;

class c implements ReturnableRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f52309a;

    public c(long j11) {
        this.f52309a = j11;
    }

    @Nullable
    /* renamed from: a */
    public Boolean run() {
        return Boolean.valueOf(m.b(this.f52309a) != null);
    }
}
