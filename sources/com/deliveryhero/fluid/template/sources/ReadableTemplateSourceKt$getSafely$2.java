package com.deliveryhero.fluid.template.sources;

import com.deliveryhero.fluid.telemetry.log.LogLevel;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.template.TemplateBuilder;
import com.deliveryhero.fluid.template.sources.ReadableTemplateSource;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "", "Lcom/deliveryhero/fluid/template/TemplateId;", "Lcom/deliveryhero/fluid/template/TemplateBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ReadableTemplateSourceKt$getSafely$2 extends Lambda implements Function0<Map<String, ? extends TemplateBuilder>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Set<ReadableTemplateSource.Request> f30215g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ReadableTemplateSource f30216h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReadableTemplateSourceKt$getSafely$2(Set<ReadableTemplateSource.Request> set, ReadableTemplateSource readableTemplateSource) {
        super(0);
        this.f30215g = set;
        this.f30216h = readableTemplateSource;
    }

    @NotNull
    public final Map<String, TemplateBuilder> invoke() {
        Map<String, TemplateBuilder> map;
        if (!this.f30215g.isEmpty()) {
            map = this.f30216h.get(this.f30215g);
        } else {
            map = MapsKt__MapsKt.emptyMap();
        }
        Logger logger = this.f30216h.getParseConfig().getLogger();
        ReadableTemplateSource readableTemplateSource = this.f30216h;
        LogLevel logLevel = LogLevel.DEBUG;
        if (logLevel.compareTo(logger.getMinimumLevel()) >= 0) {
            String tag = logger.getTag();
            Logger.log$default(logger, tag, logLevel, '`' + readableTemplateSource.getDebugName() + "` — obtained templates: `" + map + '`', (Throwable) null, (Pair[]) null, 24, (Object) null);
        }
        return map;
    }
}
