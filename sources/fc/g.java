package fc;

import com.instabug.crash.CrashReporting;
import com.instabug.crash.models.IBGNonFatalException;
import com.instabug.library.apichecker.VoidRunnable;
import java.util.Map;

public final /* synthetic */ class g implements VoidRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f47098a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f47099b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f47100c;

    public /* synthetic */ g(Throwable th2, String str, Map map) {
        this.f47098a = th2;
        this.f47099b = str;
        this.f47100c = map;
    }

    public final void run() {
        CrashReporting.reportHandledException(this.f47098a, this.f47099b, this.f47100c, (String) null, IBGNonFatalException.Level.ERROR);
    }
}
