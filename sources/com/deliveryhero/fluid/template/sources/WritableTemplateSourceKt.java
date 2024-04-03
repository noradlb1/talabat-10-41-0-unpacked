package com.deliveryhero.fluid.template.sources;

import com.deliveryhero.fluid.telemetry.log.ErrorTypes;
import com.deliveryhero.fluid.telemetry.log.LogLevel;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.telemetry.log.LoggerKt;
import com.deliveryhero.fluid.telemetry.profile.Profiler;
import com.deliveryhero.fluid.template.TemplateBuilder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0016\u0010\u0003\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"writeSafely", "", "Lcom/deliveryhero/fluid/template/sources/WritableTemplateSource;", "templates", "", "", "Lcom/deliveryhero/fluid/template/TemplateId;", "Lcom/deliveryhero/fluid/template/TemplateBuilder;", "logger", "Lcom/deliveryhero/fluid/telemetry/log/Logger;", "profiler", "Lcom/deliveryhero/fluid/telemetry/profile/Profiler;", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class WritableTemplateSourceKt {
    public static final void writeSafely(@NotNull WritableTemplateSource writableTemplateSource, @NotNull Map<String, TemplateBuilder> map, @NotNull Logger logger, @NotNull Profiler profiler) {
        Intrinsics.checkNotNullParameter(writableTemplateSource, "<this>");
        Intrinsics.checkNotNullParameter(map, "templates");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(profiler, "profiler");
        try {
            LogLevel logLevel = LogLevel.DEBUG;
            if (logLevel.compareTo(logger.getMinimumLevel()) >= 0) {
                String tag = logger.getTag();
                Logger.log$default(logger, tag, logLevel, writableTemplateSource.getDebugName() + " — writing templates: `" + map + '`', (Throwable) null, (Pair[]) null, 24, (Object) null);
            }
            profiler.trace(writableTemplateSource.getDebugName() + "_write", new WritableTemplateSourceKt$writeSafely$2(writableTemplateSource, map));
        } catch (Throwable th2) {
            LoggerKt.error(logger, th2, ErrorTypes.TEMPLATE_STORE, MapsKt__MapsKt.mapOf(TuplesKt.to("source", writableTemplateSource), TuplesKt.to("templates", map)));
        }
    }
}
