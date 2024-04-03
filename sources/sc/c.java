package sc;

import com.instabug.library.apichecker.APIChecker;
import com.instabug.library.apichecker.VoidRunnable;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VoidRunnable f34673b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34674c;

    public /* synthetic */ c(VoidRunnable voidRunnable, String str) {
        this.f34673b = voidRunnable;
        this.f34674c = str;
    }

    public final void run() {
        APIChecker.lambda$checkAndRunInExecutorThenPostOnMain$3(this.f34673b, this.f34674c);
    }
}
