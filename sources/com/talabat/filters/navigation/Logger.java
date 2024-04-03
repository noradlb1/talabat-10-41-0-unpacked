package com.talabat.filters.navigation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/filters/navigation/Logger;", "Lcom/talabat/filters/navigation/FiltersLogger;", "()V", "displayErrorMessage", "", "throwable", "", "com_talabat_Components_filters_filters"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class Logger implements FiltersLogger {
    @NotNull
    public static final Logger INSTANCE = new Logger();

    private Logger() {
    }

    public void displayErrorMessage(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        th2.printStackTrace();
    }
}
