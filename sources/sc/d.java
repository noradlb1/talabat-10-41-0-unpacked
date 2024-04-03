package sc;

import com.instabug.library.apichecker.APIChecker;
import com.instabug.library.apichecker.VoidRunnable;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VoidRunnable f34675b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34676c;

    public /* synthetic */ d(VoidRunnable voidRunnable, String str) {
        this.f34675b = voidRunnable;
        this.f34676c = str;
    }

    public final void run() {
        APIChecker.lambda$checkAndRunOrThrow$4(this.f34675b, this.f34676c);
    }
}
