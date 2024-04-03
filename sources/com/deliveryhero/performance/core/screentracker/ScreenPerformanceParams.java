package com.deliveryhero.performance.core.screentracker;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/deliveryhero/performance/core/screentracker/ScreenPerformanceParams;", "", "screenName", "", "getScreenName", "()Ljava/lang/String;", "screenType", "getScreenType", "trace", "getTrace", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ScreenPerformanceParams {
    @NotNull
    String getScreenName();

    @NotNull
    String getScreenType();

    @NotNull
    String getTrace();
}
