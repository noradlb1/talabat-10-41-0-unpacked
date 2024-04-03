package com.deliveryhero.fluid.template.sources;

import com.deliveryhero.fluid.ParseConfig;
import com.deliveryhero.fluid.telemetry.log.LogLevel;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.template.TemplateBuilder;
import com.deliveryhero.fluid.template.TemplateBuilderKt;
import com.deliveryhero.fluid.template.sources.ReadableTemplateSource;
import com.deliveryhero.fluid.template.sources.WritableTemplateSource;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J'\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J \u0010\u0015\u001a\u00020\u00162\u0016\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0016R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/deliveryhero/fluid/template/sources/CompositeTemplateSource;", "Lcom/deliveryhero/fluid/template/sources/WritableTemplateSource;", "parseConfig", "Lcom/deliveryhero/fluid/ParseConfig;", "source1", "Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource;", "source2", "(Lcom/deliveryhero/fluid/ParseConfig;Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource;Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource;)V", "name", "", "getName", "()Ljava/lang/String;", "getParseConfig", "()Lcom/deliveryhero/fluid/ParseConfig;", "get", "", "Lcom/deliveryhero/fluid/template/TemplateId;", "Lcom/deliveryhero/fluid/template/TemplateBuilder;", "requests", "", "Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource$Request;", "write", "", "templates", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CompositeTemplateSource implements WritableTemplateSource {
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f30213name;
    @NotNull
    private final ParseConfig parseConfig;
    @NotNull
    private final ReadableTemplateSource source1;
    @NotNull
    private final ReadableTemplateSource source2;

    public CompositeTemplateSource(@NotNull ParseConfig parseConfig2, @NotNull ReadableTemplateSource readableTemplateSource, @NotNull ReadableTemplateSource readableTemplateSource2) {
        Intrinsics.checkNotNullParameter(parseConfig2, "parseConfig");
        Intrinsics.checkNotNullParameter(readableTemplateSource, "source1");
        Intrinsics.checkNotNullParameter(readableTemplateSource2, "source2");
        this.parseConfig = parseConfig2;
        this.source1 = readableTemplateSource;
        this.source2 = readableTemplateSource2;
        this.f30213name = readableTemplateSource.getName() + SignatureVisitor.EXTENDS + readableTemplateSource2.getName();
    }

    @NotNull
    public TemplateBuilder get(@NotNull ReadableTemplateSource.Request request) throws Throwable {
        return WritableTemplateSource.DefaultImpls.get(this, request);
    }

    @NotNull
    public String getDebugName() {
        return WritableTemplateSource.DefaultImpls.getDebugName(this);
    }

    @NotNull
    public String getName() {
        return this.f30213name;
    }

    @NotNull
    public ParseConfig getParseConfig() {
        return this.parseConfig;
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [com.deliveryhero.fluid.template.sources.ReadableTemplateSource] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(@org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, com.deliveryhero.fluid.template.TemplateBuilder> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "templates"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            com.deliveryhero.fluid.template.sources.ReadableTemplateSource r0 = r4.source1
            boolean r1 = r0 instanceof com.deliveryhero.fluid.template.sources.WritableTemplateSource
            r2 = 0
            if (r1 == 0) goto L_0x000f
            com.deliveryhero.fluid.template.sources.WritableTemplateSource r0 = (com.deliveryhero.fluid.template.sources.WritableTemplateSource) r0
            goto L_0x0010
        L_0x000f:
            r0 = r2
        L_0x0010:
            if (r0 == 0) goto L_0x0025
            com.deliveryhero.fluid.ParseConfig r1 = r4.getParseConfig()
            com.deliveryhero.fluid.telemetry.log.Logger r1 = r1.getLogger()
            com.deliveryhero.fluid.ParseConfig r3 = r4.getParseConfig()
            com.deliveryhero.fluid.telemetry.profile.Profiler r3 = r3.getProfiler()
            com.deliveryhero.fluid.template.sources.WritableTemplateSourceKt.writeSafely(r0, r5, r1, r3)
        L_0x0025:
            com.deliveryhero.fluid.template.sources.ReadableTemplateSource r0 = r4.source2
            boolean r1 = r0 instanceof com.deliveryhero.fluid.template.sources.WritableTemplateSource
            if (r1 == 0) goto L_0x002e
            r2 = r0
            com.deliveryhero.fluid.template.sources.WritableTemplateSource r2 = (com.deliveryhero.fluid.template.sources.WritableTemplateSource) r2
        L_0x002e:
            if (r2 == 0) goto L_0x0043
            com.deliveryhero.fluid.ParseConfig r0 = r4.getParseConfig()
            com.deliveryhero.fluid.telemetry.log.Logger r0 = r0.getLogger()
            com.deliveryhero.fluid.ParseConfig r1 = r4.getParseConfig()
            com.deliveryhero.fluid.telemetry.profile.Profiler r1 = r1.getProfiler()
            com.deliveryhero.fluid.template.sources.WritableTemplateSourceKt.writeSafely(r2, r5, r0, r1)
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.fluid.template.sources.CompositeTemplateSource.write(java.util.Map):void");
    }

    @NotNull
    public Map<String, TemplateBuilder> get(@NotNull Set<ReadableTemplateSource.Request> set) {
        Intrinsics.checkNotNullParameter(set, "requests");
        Map<String, TemplateBuilder> safely = ReadableTemplateSourceKt.getSafely(this.source1, set);
        ArrayList arrayList = new ArrayList(safely.size());
        for (Map.Entry<String, TemplateBuilder> value : safely.entrySet()) {
            arrayList.add(TemplateBuilderKt.toRequest((TemplateBuilder) value.getValue()));
        }
        Set minus = SetsKt___SetsKt.minus(set, arrayList);
        Logger logger = getParseConfig().getLogger();
        LogLevel logLevel = LogLevel.DEBUG;
        if (logLevel.compareTo(logger.getMinimumLevel()) >= 0) {
            String tag = logger.getTag();
            Logger.log$default(logger, tag, logLevel, "Source1(`" + this.source1.getDebugName() + "`) unsatisfied requests: `" + minus + '`', (Throwable) null, (Pair[]) null, 24, (Object) null);
        }
        Map<String, TemplateBuilder> plus = MapsKt__MapsKt.plus(safely, ReadableTemplateSourceKt.getSafely(this.source2, (Set<ReadableTemplateSource.Request>) minus));
        write(plus);
        return plus;
    }
}
