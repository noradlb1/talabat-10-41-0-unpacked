package fc;

import com.instabug.crash.CrashReporting;
import com.instabug.crash.models.IBGNonFatalException;
import com.instabug.library.apichecker.VoidRunnable;
import java.util.Map;

public final /* synthetic */ class e implements VoidRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f47093a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f47094b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f47095c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f47096d;

    public /* synthetic */ e(Throwable th2, String str, Map map, String str2) {
        this.f47093a = th2;
        this.f47094b = str;
        this.f47095c = map;
        this.f47096d = str2;
    }

    public final void run() {
        CrashReporting.reportHandledException(this.f47093a, this.f47094b, this.f47095c, this.f47096d, IBGNonFatalException.Level.ERROR);
    }
}
