package xb;

import com.instabug.bug.BugReporting;
import com.instabug.library.OnUsageExceededReady;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OnUsageExceededReady f47265b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f47266c;

    public /* synthetic */ d(OnUsageExceededReady onUsageExceededReady, boolean z11) {
        this.f47265b = onUsageExceededReady;
        this.f47266c = z11;
    }

    public final void run() {
        BugReporting.lambda$getUsageExceeded$1(this.f47265b, this.f47266c);
    }
}
