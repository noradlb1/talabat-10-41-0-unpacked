package com.talabat.fluttercore;

import com.talabat.core.buildconfig.TalabatEnvironment;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/fluttercore/FlutterApiInitializer;", "", "()V", "methodHandler", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "setMethodHandler", "", "setUp", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterApiInitializer {
    @NotNull
    public static final FlutterApiInitializer INSTANCE = new FlutterApiInitializer();
    @Nullable
    private static MethodChannel.MethodCallHandler methodHandler;

    private FlutterApiInitializer() {
    }

    public final void setMethodHandler(@NotNull MethodChannel.MethodCallHandler methodCallHandler) {
        Intrinsics.checkNotNullParameter(methodCallHandler, "methodHandler");
        methodHandler = methodCallHandler;
    }

    public final void setUp(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        if (Intrinsics.areEqual((Object) TalabatEnvironment.INSTANCE.getEnvironment(), (Object) "mock")) {
            MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/localhostMock");
            MethodChannel.MethodCallHandler methodCallHandler = methodHandler;
            Intrinsics.checkNotNull(methodCallHandler);
            methodChannel.setMethodCallHandler(methodCallHandler);
        }
    }
}
