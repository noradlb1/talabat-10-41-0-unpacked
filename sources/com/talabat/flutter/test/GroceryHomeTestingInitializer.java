package com.talabat.flutter.test;

import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u0007\u001a\u00020\b2*\u0010\u0003\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\n0\t\"\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/flutter/test/GroceryHomeTestingInitializer;", "", "()V", "methodHandlers", "", "", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "setTestingMethodHandlers", "", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)V", "setUp", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryHomeTestingInitializer {
    @NotNull
    public static final GroceryHomeTestingInitializer INSTANCE = new GroceryHomeTestingInitializer();
    @NotNull
    private static Map<String, ? extends MethodChannel.MethodCallHandler> methodHandlers = MapsKt__MapsKt.emptyMap();

    private GroceryHomeTestingInitializer() {
    }

    public final void setTestingMethodHandlers(@NotNull Pair<String, ? extends MethodChannel.MethodCallHandler>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "methodHandlers");
        methodHandlers = MapsKt__MapsKt.mapOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    public final void setUp(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        for (Map.Entry next : methodHandlers.entrySet()) {
            new MethodChannel(flutterEngine.getDartExecutor(), (String) next.getKey()).setMethodCallHandler((MethodChannel.MethodCallHandler) next.getValue());
        }
    }
}
