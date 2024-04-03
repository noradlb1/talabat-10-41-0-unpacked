package fc;

import com.instabug.crash.CrashReporting;
import com.instabug.crash.models.IBGNonFatalException;
import com.instabug.library.apichecker.VoidRunnable;
import java.util.Map;

public final /* synthetic */ class f implements VoidRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f47097a;

    public /* synthetic */ f(Throwable th2) {
        this.f47097a = th2;
    }

    public final void run() {
        CrashReporting.reportHandledException(this.f47097a, (String) null, (Map<String, String>) null, (String) null, IBGNonFatalException.Level.ERROR);
    }
}
