package com.deliveryhero.impression.view;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/deliveryhero/impression/view/ImpressionTrackerCallback;", "", "onError", "", "tracker", "Lcom/deliveryhero/impression/view/Tracker;", "throwable", "", "onImpressionDetectionFinished", "onImpressionDetectionStarted", "impression-tracking_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface ImpressionTrackerCallback {
    void onError(@NotNull Tracker tracker, @NotNull Throwable th2);

    void onImpressionDetectionFinished(@NotNull Tracker tracker);

    void onImpressionDetectionStarted(@NotNull Tracker tracker);
}
