package com.deliveryhero.perseus.di;

import com.deliveryhero.perseus.core.config.PerseusConfigProvider;
import com.deliveryhero.perseus.core.session.AppSessionManager;
import com.deliveryhero.perseus.core.session.ClientIdProvider;
import com.deliveryhero.perseus.data.local.db.entity.HitEventFactory;
import com.deliveryhero.perseus.repository.PerseusHitsRepositoryImpl;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/deliveryhero/perseus/repository/PerseusHitsRepositoryImpl;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class DataModule$perseusHitsRepository$2 extends Lambda implements Function0<PerseusHitsRepositoryImpl> {
    public static final DataModule$perseusHitsRepository$2 INSTANCE = new DataModule$perseusHitsRepository$2();

    public DataModule$perseusHitsRepository$2() {
        super(0);
    }

    @NotNull
    public final PerseusHitsRepositoryImpl invoke() {
        CoreModule coreModule = CoreModule.INSTANCE;
        AppSessionManager appSessionManager = coreModule.getAppSessionManager();
        ClientIdProvider clientIdProvider = coreModule.getClientIdProvider();
        Calendar clock = DatabaseModule.INSTANCE.clock();
        PerseusConfigProvider perseusConfigProvider = coreModule.getPerseusConfigProvider();
        HitEventFactory hitEventFactory = new HitEventFactory();
        DataModule dataModule = DataModule.INSTANCE;
        return new PerseusHitsRepositoryImpl(dataModule.getPerseusHitsRemoteDataStore(), dataModule.getPerseusHitsLocalDataStore(), appSessionManager, clientIdProvider, perseusConfigProvider, hitEventFactory, clock, TimeModule.INSTANCE.systemClock(), LoggerModule.INSTANCE.getPerseusLogger());
    }
}
