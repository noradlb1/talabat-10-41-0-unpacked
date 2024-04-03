package com.deliveryhero.perseus.di;

import com.deliveryhero.perseus.core.config.PerseusConfigProvider;
import com.deliveryhero.perseus.data.local.PerseusHitsLocalDataStoreImpl;
import com.deliveryhero.perseus.data.remote.api.PerseusLoggerApi;
import com.deliveryhero.perseus.logger.DatabaseInfoLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/deliveryhero/perseus/logger/DatabaseInfoLogger;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LoggerModule$databaseInfoLogger$2 extends Lambda implements Function0<DatabaseInfoLogger> {
    public static final LoggerModule$databaseInfoLogger$2 INSTANCE = new LoggerModule$databaseInfoLogger$2();

    public LoggerModule$databaseInfoLogger$2() {
        super(0);
    }

    @NotNull
    public final DatabaseInfoLogger invoke() {
        PerseusLoggerApi perseusLoggerApi = NetworkModule.INSTANCE.getPerseusLoggerApi();
        CoreModule coreModule = CoreModule.INSTANCE;
        PerseusConfigProvider perseusConfigProvider = coreModule.getPerseusConfigProvider();
        DataModule dataModule = DataModule.INSTANCE;
        PerseusHitsLocalDataStoreImpl perseusHitsLocalDataStore = dataModule.getPerseusHitsLocalDataStore();
        return new DatabaseInfoLogger(perseusConfigProvider, coreModule.getAppSessionManager(), dataModule.getPerseusUserLocalDataStore(), dataModule.getPerseusConfigLocalDataStore(), perseusHitsLocalDataStore, perseusLoggerApi, LoggerModule.INSTANCE.getPerseusLogger());
    }
}
