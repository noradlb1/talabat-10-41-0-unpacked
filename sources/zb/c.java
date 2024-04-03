package zb;

import com.instabug.bug.view.reporting.i0;
import com.instabug.library.model.Attachment;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i0 f47289b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Attachment f47290c;

    public /* synthetic */ c(i0 i0Var, Attachment attachment) {
        this.f47289b = i0Var;
        this.f47290c = attachment;
    }

    public final void run() {
        this.f47289b.a(this.f47290c);
    }
}
