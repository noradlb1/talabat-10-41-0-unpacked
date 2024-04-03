package com.deliveryhero.perseus.di;

import com.deliveryhero.perseus.logger.DatabaseInfoLogger;
import com.deliveryhero.perseus.logger.PerseusLogger;
import kotlin.Lazy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/deliveryhero/perseus/di/LoggerModule;", "", "()V", "databaseInfoLogger", "Lcom/deliveryhero/perseus/logger/DatabaseInfoLogger;", "getDatabaseInfoLogger", "()Lcom/deliveryhero/perseus/logger/DatabaseInfoLogger;", "databaseInfoLogger$delegate", "Lkotlin/Lazy;", "perseusLogger", "Lcom/deliveryhero/perseus/logger/PerseusLogger;", "getPerseusLogger", "()Lcom/deliveryhero/perseus/logger/PerseusLogger;", "perseusLogger$delegate", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LoggerModule {
    @NotNull
    public static final LoggerModule INSTANCE = new LoggerModule();
    @NotNull
    private static final Lazy databaseInfoLogger$delegate = LazyKt__LazyJVMKt.lazy(LoggerModule$databaseInfoLogger$2.INSTANCE);
    @NotNull
    private static final Lazy perseusLogger$delegate = LazyKt__LazyJVMKt.lazy(LoggerModule$perseusLogger$2.INSTANCE);

    private LoggerModule() {
    }

    @NotNull
    public final DatabaseInfoLogger getDatabaseInfoLogger() {
        return (DatabaseInfoLogger) databaseInfoLogger$delegate.getValue();
    }

    @NotNull
    public final PerseusLogger getPerseusLogger() {
        return (PerseusLogger) perseusLogger$delegate.getValue();
    }
}
