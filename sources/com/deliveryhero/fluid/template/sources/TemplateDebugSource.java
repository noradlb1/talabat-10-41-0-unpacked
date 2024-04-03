package com.deliveryhero.fluid.template.sources;

import android.os.FileObserver;
import com.deliveryhero.fluid.ParseConfig;
import com.deliveryhero.fluid.telemetry.log.LogLevel;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.template.TemplateBuilder;
import com.deliveryhero.fluid.template.sources.ObservableTemplateSource;
import com.deliveryhero.fluid.template.sources.ReadableTemplateSource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ'\u0010\u0014\u001a\u0012\u0012\b\u0012\u00060\u000fj\u0002`\u0016\u0012\u0004\u0012\u00020\u00170\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002JS\u0010\u001b\u001a\f\u0012\u0004\u0012\u00020\u001d0\u001cj\u0002`\u001e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001921\u0010\u001f\u001a-\u0012#\u0012!\u0012\b\u0012\u00060\u000fj\u0002`\u0016\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\f\b!\u0012\b\b\u000e\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u001d0 H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, d2 = {"Lcom/deliveryhero/fluid/template/sources/TemplateDebugSource;", "Lcom/deliveryhero/fluid/template/sources/ObservableTemplateSource;", "parseConfig", "Lcom/deliveryhero/fluid/ParseConfig;", "file", "Ljava/io/File;", "fallback", "Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource;", "(Lcom/deliveryhero/fluid/ParseConfig;Ljava/io/File;Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource;)V", "diskSource", "Lcom/deliveryhero/fluid/template/sources/TemplateDiskSource;", "fileObservers", "", "Landroid/os/FileObserver;", "name", "", "getName", "()Ljava/lang/String;", "getParseConfig", "()Lcom/deliveryhero/fluid/ParseConfig;", "get", "", "Lcom/deliveryhero/fluid/template/TemplateId;", "Lcom/deliveryhero/fluid/template/TemplateBuilder;", "requests", "", "Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource$Request;", "observe", "Lkotlin/Function0;", "", "Lcom/deliveryhero/fluid/utils/Cancellable;", "observer", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "templates", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TemplateDebugSource implements ObservableTemplateSource {
    /* access modifiers changed from: private */
    @NotNull
    public final TemplateDiskSource diskSource;
    @NotNull
    private final ReadableTemplateSource fallback;
    /* access modifiers changed from: private */
    @NotNull
    public final List<FileObserver> fileObservers = new ArrayList();
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f30220name = "debug";
    @NotNull
    private final ParseConfig parseConfig;

    public TemplateDebugSource(@NotNull ParseConfig parseConfig2, @NotNull File file, @NotNull ReadableTemplateSource readableTemplateSource) {
        Intrinsics.checkNotNullParameter(parseConfig2, "parseConfig");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(readableTemplateSource, "fallback");
        this.parseConfig = parseConfig2;
        this.fallback = readableTemplateSource;
        this.diskSource = new TemplateDiskSource(getParseConfig(), file);
    }

    @NotNull
    public TemplateBuilder get(@NotNull ReadableTemplateSource.Request request) throws Throwable {
        return ObservableTemplateSource.DefaultImpls.get(this, request);
    }

    @NotNull
    public String getDebugName() {
        return ObservableTemplateSource.DefaultImpls.getDebugName(this);
    }

    @NotNull
    public String getName() {
        return this.f30220name;
    }

    @NotNull
    public ParseConfig getParseConfig() {
        return this.parseConfig;
    }

    @NotNull
    public Function0<Unit> observe(@NotNull Set<ReadableTemplateSource.Request> set, @NotNull Function1<? super Map<String, TemplateBuilder>, Unit> function1) {
        Intrinsics.checkNotNullParameter(set, "requests");
        Intrinsics.checkNotNullParameter(function1, "observer");
        TemplateDebugSource$observe$fileObserver$1 templateDebugSource$observe$fileObserver$1 = new TemplateDebugSource$observe$fileObserver$1(this, function1, set, this.diskSource.getFile().getBaseFile());
        this.diskSource.getFile().getBaseFile().createNewFile();
        function1.invoke(ReadableTemplateSourceKt.getSafely((ReadableTemplateSource) this, set));
        templateDebugSource$observe$fileObserver$1.startWatching();
        this.fileObservers.add(templateDebugSource$observe$fileObserver$1);
        Logger logger = getParseConfig().getLogger();
        LogLevel logLevel = LogLevel.DEBUG;
        if (logLevel.compareTo(logger.getMinimumLevel()) >= 0) {
            String tag = logger.getTag();
            Logger.log$default(logger, tag, logLevel, "Start observing file: `" + this.diskSource.getFile().getBaseFile() + '`', (Throwable) null, (Pair[]) null, 24, (Object) null);
        }
        return new TemplateDebugSource$observe$2(templateDebugSource$observe$fileObserver$1, this);
    }

    @NotNull
    public Map<String, TemplateBuilder> get(@NotNull Set<ReadableTemplateSource.Request> set) {
        Intrinsics.checkNotNullParameter(set, "requests");
        Map<String, TemplateBuilder> map = this.diskSource.get(set);
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, TemplateBuilder> value : map.entrySet()) {
            arrayList.add(((TemplateBuilder) value.getValue()).getId());
        }
        ArrayList arrayList2 = new ArrayList();
        for (T next : set) {
            if (!arrayList.contains(((ReadableTemplateSource.Request) next).getId())) {
                arrayList2.add(next);
            }
        }
        Logger logger = getParseConfig().getLogger();
        LogLevel logLevel = LogLevel.DEBUG;
        if (logLevel.compareTo(logger.getMinimumLevel()) >= 0) {
            String tag = logger.getTag();
            Logger.log$default(logger, tag, logLevel, getDebugName() + " unsatisfied requests: `" + arrayList2 + '`', (Throwable) null, (Pair[]) null, 24, (Object) null);
        }
        return MapsKt__MapsKt.plus(map, this.fallback.get((Set<ReadableTemplateSource.Request>) CollectionsKt___CollectionsKt.toSet(arrayList2)));
    }
}
