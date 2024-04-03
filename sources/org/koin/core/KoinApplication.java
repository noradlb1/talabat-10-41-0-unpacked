package org.koin.core;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.module.Module;
import org.koin.core.time.MeasureKt;
import org.koin.mp.KoinPlatformTools;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\tJ\u0016\u0010\f\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u001f\u0010\r\u001a\u00020\u00002\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u0012\"\u00020\u000f¢\u0006\u0002\u0010\u0013J\u0014\u0010\r\u001a\u00020\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000fJ\u0010\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u0016J\u001a\u0010\u0017\u001a\u00020\u00002\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0019J\u0014\u0010\u001b\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u000e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001e"}, d2 = {"Lorg/koin/core/KoinApplication;", "", "()V", "allowOverride", "", "koin", "Lorg/koin/core/Koin;", "getKoin", "()Lorg/koin/core/Koin;", "", "override", "close", "loadModules", "modules", "", "Lorg/koin/core/module/Module;", "logger", "Lorg/koin/core/logger/Logger;", "", "([Lorg/koin/core/module/Module;)Lorg/koin/core/KoinApplication;", "printLogger", "level", "Lorg/koin/core/logger/Level;", "properties", "values", "", "", "unloadModules", "module", "Companion", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class KoinApplication {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private boolean allowOverride;
    @NotNull
    private final Koin koin;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lorg/koin/core/KoinApplication$Companion;", "", "()V", "init", "Lorg/koin/core/KoinApplication;", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final KoinApplication init() {
            return new KoinApplication((DefaultConstructorMarker) null);
        }
    }

    private KoinApplication() {
        this.koin = new Koin();
        this.allowOverride = true;
    }

    public /* synthetic */ KoinApplication(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* access modifiers changed from: private */
    public final void loadModules(List<Module> list) {
        this.koin.loadModules(list, this.allowOverride);
    }

    public static /* synthetic */ KoinApplication printLogger$default(KoinApplication koinApplication, Level level, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            level = Level.INFO;
        }
        return koinApplication.printLogger(level);
    }

    public final void allowOverride(boolean z11) {
        this.allowOverride = z11;
    }

    public final void close() {
        this.koin.close();
    }

    @NotNull
    public final Koin getKoin() {
        return this.koin;
    }

    @NotNull
    public final KoinApplication logger(@NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.koin.setupLogger(logger);
        return this;
    }

    @NotNull
    public final KoinApplication modules(@NotNull Module module) {
        Intrinsics.checkNotNullParameter(module, "modules");
        return modules((List<Module>) CollectionsKt__CollectionsJVMKt.listOf(module));
    }

    @NotNull
    public final KoinApplication printLogger(@NotNull Level level) {
        Intrinsics.checkNotNullParameter(level, "level");
        this.koin.setupLogger(KoinPlatformTools.INSTANCE.defaultLogger(level));
        return this;
    }

    @NotNull
    public final KoinApplication properties(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "values");
        this.koin.getPropertyRegistry().saveProperties(map);
        return this;
    }

    public final void unloadModules(@NotNull List<Module> list) {
        Intrinsics.checkNotNullParameter(list, "modules");
        this.koin.unloadModules(list);
    }

    @NotNull
    public final KoinApplication modules(@NotNull Module... moduleArr) {
        Intrinsics.checkNotNullParameter(moduleArr, "modules");
        return modules((List<Module>) ArraysKt___ArraysKt.toList((T[]) moduleArr));
    }

    public final void unloadModules(@NotNull Module module) {
        Intrinsics.checkNotNullParameter(module, "module");
        this.koin.unloadModules(CollectionsKt__CollectionsJVMKt.listOf(module));
    }

    @NotNull
    public final KoinApplication modules(@NotNull List<Module> list) {
        Intrinsics.checkNotNullParameter(list, "modules");
        if (this.koin.getLogger().isAt(Level.INFO)) {
            double measureDuration = MeasureKt.measureDuration(new KoinApplication$modules$duration$1(this, list));
            int size = this.koin.getInstanceRegistry().size();
            Logger logger = this.koin.getLogger();
            logger.info("loaded " + size + " definitions - " + measureDuration + " ms");
        } else {
            loadModules(list);
        }
        return this;
    }
}
