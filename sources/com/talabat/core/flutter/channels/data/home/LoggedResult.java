package com.talabat.core.flutter.channels.data.home;

import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0016\u0010\u000b\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u0010"}, d2 = {"Lcom/talabat/core/flutter/channels/data/home/LoggedResult;", "Lio/flutter/plugin/common/MethodChannel$Result;", "()V", "error", "", "errorCode", "", "errorMessage", "errorDetails", "", "notImplemented", "onDebugBuild", "action", "Lkotlin/Function0;", "success", "result", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoggedResult implements MethodChannel.Result {
    @NotNull
    public static final LoggedResult INSTANCE = new LoggedResult();

    private LoggedResult() {
    }

    private final void onDebugBuild(Function0<Unit> function0) {
    }

    public void error(@NotNull String str, @Nullable String str2, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(str, "errorCode");
        onDebugBuild(new LoggedResult$error$1(str, str2, obj));
    }

    public void notImplemented() {
        onDebugBuild(LoggedResult$notImplemented$1.INSTANCE);
    }

    public void success(@Nullable Object obj) {
        onDebugBuild(new LoggedResult$success$1(obj));
    }
}
