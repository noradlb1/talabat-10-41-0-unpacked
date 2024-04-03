package fc;

import com.instabug.crash.CrashReporting;
import com.instabug.crash.models.IBGNonFatalException;
import com.instabug.library.apichecker.VoidRunnable;
import java.util.Map;

public final /* synthetic */ class c implements VoidRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f47090a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f47091b;

    public /* synthetic */ c(Throwable th2, String str) {
        this.f47090a = th2;
        this.f47091b = str;
    }

    public final void run() {
        CrashReporting.reportHandledException(this.f47090a, this.f47091b, (Map<String, String>) null, (String) null, IBGNonFatalException.Level.ERROR);
    }
}
