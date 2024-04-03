package i9;

import com.google.common.util.concurrent.ClosingFuture;
import java.io.Closeable;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Closeable f47118b;

    public /* synthetic */ g(Closeable closeable) {
        this.f47118b = closeable;
    }

    public final void run() {
        ClosingFuture.lambda$closeQuietly$0(this.f47118b);
    }
}
