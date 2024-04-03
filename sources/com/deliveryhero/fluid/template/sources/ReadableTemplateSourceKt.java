package com.deliveryhero.fluid.template.sources;

import com.deliveryhero.fluid.telemetry.log.ErrorTypes;
import com.deliveryhero.fluid.telemetry.log.LogLevel;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.telemetry.log.LoggerKt;
import com.deliveryhero.fluid.telemetry.profile.Profiler;
import com.deliveryhero.fluid.template.TemplateBuilder;
import com.deliveryhero.fluid.template.sources.ReadableTemplateSource;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\u001a\"\u0010\u0000\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a(\u0010\u0000\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¨\u0006\n"}, d2 = {"getSafely", "", "", "Lcom/deliveryhero/fluid/template/TemplateId;", "Lcom/deliveryhero/fluid/template/TemplateBuilder;", "Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource;", "request", "Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource$Request;", "requests", "", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ReadableTemplateSourceKt {
    @NotNull
    public static final Map<String, TemplateBuilder> getSafely(@NotNull ReadableTemplateSource readableTemplateSource, @NotNull Set<ReadableTemplateSource.Request> set) {
        Intrinsics.checkNotNullParameter(readableTemplateSource, "<this>");
        Intrinsics.checkNotNullParameter(set, "requests");
        try {
            Logger logger = readableTemplateSource.getParseConfig().getLogger();
            LogLevel logLevel = LogLevel.DEBUG;
            if (logLevel.compareTo(logger.getMinimumLevel()) >= 0) {
                String tag = logger.getTag();
                Logger.log$default(logger, tag, logLevel, '`' + readableTemplateSource.getDebugName() + "` — getting templates: `" + set + '`', (Throwable) null, (Pair[]) null, 24, (Object) null);
            }
            Profiler profiler = readableTemplateSource.getParseConfig().getProfiler();
            return (Map) profiler.trace(readableTemplateSource.getDebugName() + "_get", new ReadableTemplateSourceKt$getSafely$2(set, readableTemplateSource));
        } catch (Throwable th2) {
            Logger logger2 = readableTemplateSource.getParseConfig().getLogger();
            ErrorTypes errorTypes = ErrorTypes.TEMPLATE_FETCH;
            Pair[] pairArr = new Pair[3];
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(set, 10));
            for (ReadableTemplateSource.Request id2 : set) {
                arrayList.add(id2.getId());
            }
            pairArr[0] = TuplesKt.to("template_ids", arrayList);
            pairArr[1] = TuplesKt.to("source", readableTemplateSource);
            pairArr[2] = TuplesKt.to("requests", set);
            LoggerKt.error(logger2, th2, errorTypes, MapsKt__MapsKt.mapOf(pairArr));
            return MapsKt__MapsKt.emptyMap();
        }
    }

    @NotNull
    public static final Map<String, TemplateBuilder> getSafely(@NotNull ReadableTemplateSource readableTemplateSource, @NotNull ReadableTemplateSource.Request request) {
        Intrinsics.checkNotNullParameter(readableTemplateSource, "<this>");
        Intrinsics.checkNotNullParameter(request, "request");
        return getSafely(readableTemplateSource, (Set<ReadableTemplateSource.Request>) SetsKt__SetsJVMKt.setOf(request));
    }
}
