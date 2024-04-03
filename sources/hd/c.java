package hd;

import com.instabug.library.screenshot.ScreenshotProvider;
import java.util.concurrent.Callable;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScreenshotProvider.ScreenshotCapturingListener f56867b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Callable f56868c;

    public /* synthetic */ c(ScreenshotProvider.ScreenshotCapturingListener screenshotCapturingListener, Callable callable) {
        this.f56867b = screenshotCapturingListener;
        this.f56868c = callable;
    }

    public final void run() {
        ScreenshotProvider.a(this.f56867b, this.f56868c);
    }
}
