package com.talabat.core.flutter.engine.data;

import android.content.Context;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.core.flutter.engine.domain.IFlutterEngineProvider;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineGroup;
import io.flutter.embedding.engine.dart.DartExecutor;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\u001c\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/core/flutter/engine/data/FlutterEngineProvider;", "Lcom/talabat/core/flutter/engine/domain/IFlutterEngineProvider;", "context", "Landroid/content/Context;", "engines", "Lio/flutter/embedding/engine/FlutterEngineGroup;", "(Landroid/content/Context;Lio/flutter/embedding/engine/FlutterEngineGroup;)V", "getDartEntrypoint", "Lio/flutter/embedding/engine/dart/DartExecutor$DartEntrypoint;", "entrypointName", "", "provideDeepLinkEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "deeplink", "provideEngine", "initialRoute", "provideUiLessEngine", "Companion", "com_talabat_core_flutter-engine_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterEngineProvider implements IFlutterEngineProvider {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String DEEP_LINK_MAIN_ENTER_POINT_NAME = "deeplinkMain";
    @NotNull
    private static final String UI_LESS_MAIN_ENTER_POINT_NAME = "uiLessMain";
    @NotNull
    private final Context context;
    @NotNull
    private final FlutterEngineGroup engines;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/flutter/engine/data/FlutterEngineProvider$Companion;", "", "()V", "DEEP_LINK_MAIN_ENTER_POINT_NAME", "", "UI_LESS_MAIN_ENTER_POINT_NAME", "com_talabat_core_flutter-engine_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public FlutterEngineProvider(@NotNull @ApplicationContext Context context2, @NotNull FlutterEngineGroup flutterEngineGroup) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(flutterEngineGroup, "engines");
        this.context = context2;
        this.engines = flutterEngineGroup;
    }

    public static /* synthetic */ FlutterEngine a(FlutterEngineProvider flutterEngineProvider, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        return flutterEngineProvider.provideEngine(str, str2);
    }

    private final DartExecutor.DartEntrypoint getDartEntrypoint(String str) {
        return new DartExecutor.DartEntrypoint(FlutterInjector.instance().flutterLoader().findAppBundlePath(), str);
    }

    private final FlutterEngine provideEngine(String str, String str2) {
        FlutterEngine createAndRunEngine = this.engines.createAndRunEngine(this.context, getDartEntrypoint(str), str2);
        Intrinsics.checkNotNullExpressionValue(createAndRunEngine, "engines.createAndRunEngi…Entrypoint, initialRoute)");
        return createAndRunEngine;
    }

    @NotNull
    public FlutterEngine provideDeepLinkEngine(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "deeplink");
        return provideEngine(DEEP_LINK_MAIN_ENTER_POINT_NAME, str);
    }

    @NotNull
    public FlutterEngine provideUiLessEngine() {
        return a(this, UI_LESS_MAIN_ENTER_POINT_NAME, (String) null, 2, (Object) null);
    }
}
