package com.talabat.gem.samples;

import android.util.Log;
import com.talabat.gem.GemCoreIntegrator;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.ports.logging.LoggerPort;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/gem/GemCoreIntegrator;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SampleDataSourcesKt$updateDataSources$1 extends Lambda implements Function1<GemCoreIntegrator, Unit> {
    public static final SampleDataSourcesKt$updateDataSources$1 INSTANCE = new SampleDataSourcesKt$updateDataSources$1();

    public SampleDataSourcesKt$updateDataSources$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GemCoreIntegrator) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GemCoreIntegrator gemCoreIntegrator) {
        Intrinsics.checkNotNullParameter(gemCoreIntegrator, "$this$GemCoreIntegration");
        IntegrationKt.dataSources(IntegrationKt.getSet(gemCoreIntegrator), new SampleDataSourcesAdapter());
        IntegrationKt.logger(IntegrationKt.getSet(gemCoreIntegrator), new LoggerPort() {
            public void a(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "throwable");
                Log.e("Gem", th2.getMessage(), th2);
            }

            public void b(@NotNull String str, @NotNull Object obj) {
                Intrinsics.checkNotNullParameter(str, "tag");
                Intrinsics.checkNotNullParameter(obj, "message");
                Log.w(str, obj.toString());
            }
        });
    }
}
