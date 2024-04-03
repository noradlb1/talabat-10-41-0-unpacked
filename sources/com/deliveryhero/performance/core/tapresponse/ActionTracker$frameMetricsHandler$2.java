package com.deliveryhero.performance.core.tapresponse;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Handler;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ActionTracker$frameMetricsHandler$2 extends Lambda implements Function0<Handler> {
    public static final ActionTracker$frameMetricsHandler$2 INSTANCE = new ActionTracker$frameMetricsHandler$2();

    public ActionTracker$frameMetricsHandler$2() {
        super(0);
    }

    @NotNull
    public final Handler invoke() {
        HandlerThread handlerThread = new HandlerThread("frame_metrics");
        handlerThread.start();
        return new Handler(handlerThread.getLooper());
    }
}
