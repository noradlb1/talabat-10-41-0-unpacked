package com.deliveryhero.perseus.data.local;

import com.deliveryhero.perseus.PerseusParamsConfig;
import com.deliveryhero.perseus.core.config.PerseusConfigProvider;
import com.deliveryhero.perseus.data.local.db.TrackingDatabase;
import com.deliveryhero.perseus.data.local.db.entity.DatabaseEventInfo;
import com.deliveryhero.perseus.data.local.db.entity.HitEvent;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\u0014\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0015H\u0016R\u0014\u0010\u0007\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/deliveryhero/perseus/data/local/PerseusHitsLocalDataStoreImpl;", "Lcom/deliveryhero/perseus/data/local/PerseusHitsLocalDataStore;", "trackingDatabase", "Lcom/deliveryhero/perseus/data/local/db/TrackingDatabase;", "configProvider", "Lcom/deliveryhero/perseus/core/config/PerseusConfigProvider;", "(Lcom/deliveryhero/perseus/data/local/db/TrackingDatabase;Lcom/deliveryhero/perseus/core/config/PerseusConfigProvider;)V", "config", "Lcom/deliveryhero/perseus/PerseusParamsConfig;", "getConfig", "()Lcom/deliveryhero/perseus/PerseusParamsConfig;", "databaseEventInfo", "Lcom/deliveryhero/perseus/data/local/db/entity/DatabaseEventInfo;", "deleteEventsOlderThan", "", "utcTimestamp", "", "deleteHitEvents", "", "events", "", "Lcom/deliveryhero/perseus/data/local/db/entity/HitEvent;", "getNextEvents", "Lio/reactivex/Single;", "insertHitEvent", "hitEvent", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerseusHitsLocalDataStoreImpl implements PerseusHitsLocalDataStore {
    @NotNull
    private final PerseusConfigProvider configProvider;
    @NotNull
    private final TrackingDatabase trackingDatabase;

    public PerseusHitsLocalDataStoreImpl(@NotNull TrackingDatabase trackingDatabase2, @NotNull PerseusConfigProvider perseusConfigProvider) {
        Intrinsics.checkNotNullParameter(trackingDatabase2, "trackingDatabase");
        Intrinsics.checkNotNullParameter(perseusConfigProvider, "configProvider");
        this.trackingDatabase = trackingDatabase2;
        this.configProvider = perseusConfigProvider;
    }

    private final PerseusParamsConfig getConfig() {
        return this.configProvider.provideConfig();
    }

    @NotNull
    public DatabaseEventInfo databaseEventInfo() {
        return this.trackingDatabase.cachedHitEventsDao().loggingInformation();
    }

    public int deleteEventsOlderThan(long j11) {
        return this.trackingDatabase.cachedHitEventsDao().deleteEventsOlderThan(j11);
    }

    public void deleteHitEvents(@NotNull List<HitEvent> list) {
        Intrinsics.checkNotNullParameter(list, "events");
        this.trackingDatabase.cachedHitEventsDao().deleteHitEvents(list);
    }

    @NotNull
    public Single<List<HitEvent>> getNextEvents() {
        return this.trackingDatabase.cachedHitEventsDao().getHitEvents(getConfig().getBatchSize());
    }

    public long insertHitEvent(@NotNull HitEvent hitEvent) {
        Intrinsics.checkNotNullParameter(hitEvent, "hitEvent");
        return this.trackingDatabase.cachedHitEventsDao().insertEventTimestamp(hitEvent);
    }
}
