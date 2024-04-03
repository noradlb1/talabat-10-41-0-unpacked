package sc;

import com.instabug.library.apichecker.APIChecker;
import com.instabug.library.apichecker.VoidRunnable;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VoidRunnable f34677b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34678c;

    public /* synthetic */ e(VoidRunnable voidRunnable, String str) {
        this.f34677b = voidRunnable;
        this.f34678c = str;
    }

    public final void run() {
        APIChecker.lambda$checkAndRunInExecutor$1(this.f34677b, this.f34678c);
    }
}
