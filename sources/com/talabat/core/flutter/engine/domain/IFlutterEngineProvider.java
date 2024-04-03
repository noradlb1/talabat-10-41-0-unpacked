package com.talabat.core.flutter.engine.domain;

import io.flutter.embedding.engine.FlutterEngine;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/flutter/engine/domain/IFlutterEngineProvider;", "", "provideDeepLinkEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "deeplink", "", "provideUiLessEngine", "com_talabat_core_flutter-engine_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IFlutterEngineProvider {
    @NotNull
    FlutterEngine provideDeepLinkEngine(@NotNull String str);

    @NotNull
    FlutterEngine provideUiLessEngine();
}
