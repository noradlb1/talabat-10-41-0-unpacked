package hd;

import com.instabug.library.screenshot.ExtraScreenshotHelper;
import com.instabug.library.tracking.ActivityLifeCycleEvent;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExtraScreenshotHelper f56864b;

    public /* synthetic */ a(ExtraScreenshotHelper extraScreenshotHelper) {
        this.f56864b = extraScreenshotHelper;
    }

    public final void accept(Object obj) {
        this.f56864b.lambda$subscribeToCurranActivityLifeCycle$1((ActivityLifeCycleEvent) obj);
    }
}
