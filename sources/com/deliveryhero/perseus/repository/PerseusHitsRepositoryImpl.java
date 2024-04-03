package com.deliveryhero.perseus.repository;

import com.deliveryhero.perseus.core.config.PerseusConfigProvider;
import com.deliveryhero.perseus.core.session.AppSessionManager;
import com.deliveryhero.perseus.core.session.ClientIdProvider;
import com.deliveryhero.perseus.core.time.TimeProvider;
import com.deliveryhero.perseus.data.local.PerseusHitsLocalDataStore;
import com.deliveryhero.perseus.data.local.db.entity.HitEvent;
import com.deliveryhero.perseus.data.local.db.entity.HitEventFactory;
import com.deliveryhero.perseus.data.remote.PerseusHitsRemoteDataStore;
import com.deliveryhero.perseus.data.remote.api.model.HitsRequest;
import com.deliveryhero.perseus.data.remote.api.model.HitsResponse;
import com.deliveryhero.perseus.logger.PerseusLogger;
import io.reactivex.Single;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u0014\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u001bH\u0016J\u001c\u0010\u001c\u001a\u00020\u00162\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001b2\u0006\u0010\"\u001a\u00020#H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/deliveryhero/perseus/repository/PerseusHitsRepositoryImpl;", "Lcom/deliveryhero/perseus/repository/PerseusHitsRepository;", "remoteDataStore", "Lcom/deliveryhero/perseus/data/remote/PerseusHitsRemoteDataStore;", "localDataStore", "Lcom/deliveryhero/perseus/data/local/PerseusHitsLocalDataStore;", "appSessionManager", "Lcom/deliveryhero/perseus/core/session/AppSessionManager;", "clientIdProvider", "Lcom/deliveryhero/perseus/core/session/ClientIdProvider;", "configProvider", "Lcom/deliveryhero/perseus/core/config/PerseusConfigProvider;", "factory", "Lcom/deliveryhero/perseus/data/local/db/entity/HitEventFactory;", "initializeTime", "Ljava/util/Calendar;", "timeProvider", "Lcom/deliveryhero/perseus/core/time/TimeProvider;", "perseusLogger", "Lcom/deliveryhero/perseus/logger/PerseusLogger;", "(Lcom/deliveryhero/perseus/data/remote/PerseusHitsRemoteDataStore;Lcom/deliveryhero/perseus/data/local/PerseusHitsLocalDataStore;Lcom/deliveryhero/perseus/core/session/AppSessionManager;Lcom/deliveryhero/perseus/core/session/ClientIdProvider;Lcom/deliveryhero/perseus/core/config/PerseusConfigProvider;Lcom/deliveryhero/perseus/data/local/db/entity/HitEventFactory;Ljava/util/Calendar;Lcom/deliveryhero/perseus/core/time/TimeProvider;Lcom/deliveryhero/perseus/logger/PerseusLogger;)V", "deleteHits", "", "hitValues", "", "Lcom/deliveryhero/perseus/data/local/db/entity/HitEvent;", "getHitEvents", "Lio/reactivex/Single;", "insertEvent", "payload", "", "", "perseusHits", "Lcom/deliveryhero/perseus/data/remote/api/model/HitsResponse;", "hitRequest", "Lcom/deliveryhero/perseus/data/remote/api/model/HitsRequest;", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerseusHitsRepositoryImpl implements PerseusHitsRepository {
    @NotNull
    private final AppSessionManager appSessionManager;
    @NotNull
    private final ClientIdProvider clientIdProvider;
    @NotNull
    private final PerseusConfigProvider configProvider;
    @NotNull
    private final HitEventFactory factory;
    @NotNull
    private final Calendar initializeTime;
    @NotNull
    private final PerseusHitsLocalDataStore localDataStore;
    @NotNull
    private final PerseusLogger perseusLogger;
    @NotNull
    private final PerseusHitsRemoteDataStore remoteDataStore;
    @NotNull
    private final TimeProvider timeProvider;

    public PerseusHitsRepositoryImpl(@NotNull PerseusHitsRemoteDataStore perseusHitsRemoteDataStore, @NotNull PerseusHitsLocalDataStore perseusHitsLocalDataStore, @NotNull AppSessionManager appSessionManager2, @NotNull ClientIdProvider clientIdProvider2, @NotNull PerseusConfigProvider perseusConfigProvider, @NotNull HitEventFactory hitEventFactory, @NotNull Calendar calendar, @NotNull TimeProvider timeProvider2, @NotNull PerseusLogger perseusLogger2) {
        Intrinsics.checkNotNullParameter(perseusHitsRemoteDataStore, "remoteDataStore");
        Intrinsics.checkNotNullParameter(perseusHitsLocalDataStore, "localDataStore");
        Intrinsics.checkNotNullParameter(appSessionManager2, "appSessionManager");
        Intrinsics.checkNotNullParameter(clientIdProvider2, "clientIdProvider");
        Intrinsics.checkNotNullParameter(perseusConfigProvider, "configProvider");
        Intrinsics.checkNotNullParameter(hitEventFactory, "factory");
        Intrinsics.checkNotNullParameter(calendar, "initializeTime");
        Intrinsics.checkNotNullParameter(timeProvider2, "timeProvider");
        Intrinsics.checkNotNullParameter(perseusLogger2, "perseusLogger");
        this.remoteDataStore = perseusHitsRemoteDataStore;
        this.localDataStore = perseusHitsLocalDataStore;
        this.appSessionManager = appSessionManager2;
        this.clientIdProvider = clientIdProvider2;
        this.configProvider = perseusConfigProvider;
        this.factory = hitEventFactory;
        this.initializeTime = calendar;
        this.timeProvider = timeProvider2;
        this.perseusLogger = perseusLogger2;
    }

    public void deleteHits(@NotNull List<HitEvent> list) {
        Intrinsics.checkNotNullParameter(list, "hitValues");
        this.localDataStore.deleteHitEvents(list);
        PerseusLogger perseusLogger2 = this.perseusLogger;
        PerseusLogger.i$default(perseusLogger2, "Deleting " + list.size() + " events", (Throwable) null, 2, (Object) null);
    }

    @NotNull
    public Single<List<HitEvent>> getHitEvents() {
        return this.localDataStore.getNextEvents();
    }

    public void insertEvent(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "payload");
        long timeInMillis = this.initializeTime.getTimeInMillis();
        HitEventFactory hitEventFactory = this.factory;
        Date time = this.timeProvider.getCurrentTime().getTime();
        Intrinsics.checkNotNullExpressionValue(time, "timeProvider.getCurrentTime().time");
        HitEvent createEventHit = hitEventFactory.createEventHit(time, timeInMillis, this.configProvider.provideConfig(), this.appSessionManager, this.clientIdProvider, map);
        this.appSessionManager.refreshSessionTimeStamp();
        this.localDataStore.insertHitEvent(createEventHit);
    }

    @NotNull
    public Single<HitsResponse> perseusHits(@NotNull HitsRequest hitsRequest) {
        Intrinsics.checkNotNullParameter(hitsRequest, "hitRequest");
        return this.remoteDataStore.sendEventsHits(hitsRequest);
    }
}
