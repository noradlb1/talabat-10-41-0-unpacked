package com.talabat.core.tracking.data.logger;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/tracking/data/logger/LogManager;", "", "()V", "debug", "", "message", "", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LogManager {
    @NotNull
    public static final LogManager INSTANCE = new LogManager();

    private LogManager() {
    }

    @JvmStatic
    public static final void debug(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        System.out.println(str);
    }
}
