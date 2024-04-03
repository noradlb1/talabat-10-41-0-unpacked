package com.deliveryhero.fluid.template.sources;

import android.os.FileObserver;
import com.deliveryhero.fluid.telemetry.log.LogLevel;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.template.TemplateBuilder;
import com.deliveryhero.fluid.template.sources.ReadableTemplateSource;
import java.io.File;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/deliveryhero/fluid/template/sources/TemplateDebugSource$observe$fileObserver$1", "Landroid/os/FileObserver;", "onEvent", "", "event", "", "path", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TemplateDebugSource$observe$fileObserver$1 extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TemplateDebugSource f30223a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1<Map<String, TemplateBuilder>, Unit> f30224b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Set<ReadableTemplateSource.Request> f30225c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TemplateDebugSource$observe$fileObserver$1(TemplateDebugSource templateDebugSource, Function1<? super Map<String, TemplateBuilder>, Unit> function1, Set<ReadableTemplateSource.Request> set, File file) {
        super(file, 2);
        this.f30223a = templateDebugSource;
        this.f30224b = function1;
        this.f30225c = set;
    }

    public void onEvent(int i11, @Nullable String str) {
        Logger logger = this.f30223a.getParseConfig().getLogger();
        LogLevel logLevel = LogLevel.DEBUG;
        if (logLevel.compareTo(logger.getMinimumLevel()) >= 0) {
            String tag = logger.getTag();
            Logger.log$default(logger, tag, logLevel, "File modified: `" + str + "`; Event: `" + i11 + '`', (Throwable) null, (Pair[]) null, 24, (Object) null);
        }
        this.f30224b.invoke(ReadableTemplateSourceKt.getSafely((ReadableTemplateSource) this.f30223a, this.f30225c));
    }
}
