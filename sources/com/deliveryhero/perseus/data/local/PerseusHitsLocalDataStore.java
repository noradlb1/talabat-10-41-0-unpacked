package com.deliveryhero.perseus.data.local;

import com.deliveryhero.perseus.data.local.db.entity.DatabaseEventInfo;
import com.deliveryhero.perseus.data.local.db.entity.HitEvent;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\fH&¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/perseus/data/local/PerseusHitsLocalDataStore;", "", "databaseEventInfo", "Lcom/deliveryhero/perseus/data/local/db/entity/DatabaseEventInfo;", "deleteEventsOlderThan", "", "utcTimestamp", "", "deleteHitEvents", "", "events", "", "Lcom/deliveryhero/perseus/data/local/db/entity/HitEvent;", "getNextEvents", "Lio/reactivex/Single;", "insertHitEvent", "hitEvent", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface PerseusHitsLocalDataStore {
    @NotNull
    DatabaseEventInfo databaseEventInfo();

    int deleteEventsOlderThan(long j11);

    void deleteHitEvents(@NotNull List<HitEvent> list);

    @NotNull
    Single<List<HitEvent>> getNextEvents();

    long insertHitEvent(@NotNull HitEvent hitEvent);
}
