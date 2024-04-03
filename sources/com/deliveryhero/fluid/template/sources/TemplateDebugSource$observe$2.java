package com.deliveryhero.fluid.template.sources;

import com.deliveryhero.fluid.telemetry.log.LogLevel;
import com.deliveryhero.fluid.telemetry.log.Logger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TemplateDebugSource$observe$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TemplateDebugSource$observe$fileObserver$1 f30221g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TemplateDebugSource f30222h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TemplateDebugSource$observe$2(TemplateDebugSource$observe$fileObserver$1 templateDebugSource$observe$fileObserver$1, TemplateDebugSource templateDebugSource) {
        super(0);
        this.f30221g = templateDebugSource$observe$fileObserver$1;
        this.f30222h = templateDebugSource;
    }

    public final void invoke() {
        this.f30221g.stopWatching();
        this.f30222h.fileObservers.remove(this.f30221g);
        Logger logger = this.f30222h.getParseConfig().getLogger();
        TemplateDebugSource templateDebugSource = this.f30222h;
        LogLevel logLevel = LogLevel.DEBUG;
        if (logLevel.compareTo(logger.getMinimumLevel()) >= 0) {
            String tag = logger.getTag();
            Logger.log$default(logger, tag, logLevel, "Stop observing file: `" + templateDebugSource.diskSource.getFile().getBaseFile() + '`', (Throwable) null, (Pair[]) null, 24, (Object) null);
        }
    }
}
