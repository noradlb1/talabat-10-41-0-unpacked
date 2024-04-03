package ld;

import com.instabug.library.sessionV3.sync.SessionBatchingFilter;
import com.instabug.library.sessionV3.sync.t;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SessionBatchingFilter f56989b;

    public /* synthetic */ i(SessionBatchingFilter sessionBatchingFilter) {
        this.f56989b = sessionBatchingFilter;
    }

    public final void run() {
        t.b(this.f56989b);
    }
}
