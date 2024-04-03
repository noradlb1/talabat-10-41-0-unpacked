package sc;

import com.instabug.library.apichecker.APIChecker;
import com.instabug.library.apichecker.VoidRunnable;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VoidRunnable f34669b;

    public /* synthetic */ a(VoidRunnable voidRunnable) {
        this.f34669b = voidRunnable;
    }

    public final void run() {
        APIChecker.lambda$checkAndRunInExecutorThenPostOnMain$2(this.f34669b);
    }
}
