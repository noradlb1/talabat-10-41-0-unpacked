package fc;

import com.instabug.crash.CrashReporting;
import com.instabug.crash.models.IBGNonFatalException;
import com.instabug.library.apichecker.VoidRunnable;

public final /* synthetic */ class d implements VoidRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IBGNonFatalException f47092a;

    public /* synthetic */ d(IBGNonFatalException iBGNonFatalException) {
        this.f47092a = iBGNonFatalException;
    }

    public final void run() {
        CrashReporting.reportHandledException(this.f47092a.getThrowable(), (String) null, this.f47092a.getUserAttributes(), this.f47092a.getFingerprint(), this.f47092a.getLevel());
    }
}
