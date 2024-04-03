package com.talabat.core.flutter.engine.data.di;

import android.content.Context;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.core.flutter.engine.data.FlutterEngineProvider;
import com.talabat.core.flutter.engine.domain.IFlutterEngineProvider;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import io.flutter.embedding.engine.FlutterEngineGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/flutter/engine/data/di/FlutterEngineCoreLibModule;", "", "flutterEngineProvider", "Lcom/talabat/core/flutter/engine/domain/IFlutterEngineProvider;", "impl", "Lcom/talabat/core/flutter/engine/data/FlutterEngineProvider;", "Companion", "com_talabat_core_flutter-engine_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface FlutterEngineCoreLibModule {
    @NotNull
    public static final Companion Companion = Companion.f55937a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/flutter/engine/data/di/FlutterEngineCoreLibModule$Companion;", "", "()V", "flutterEngineGroup", "Lio/flutter/embedding/engine/FlutterEngineGroup;", "context", "Landroid/content/Context;", "com_talabat_core_flutter-engine_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f55937a = new Companion();

        private Companion() {
        }

        @NotNull
        @Provides
        public final FlutterEngineGroup flutterEngineGroup(@NotNull @ApplicationContext Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new FlutterEngineGroup(context);
        }
    }

    @NotNull
    @Binds
    @Reusable
    IFlutterEngineProvider flutterEngineProvider(@NotNull FlutterEngineProvider flutterEngineProvider);
}
