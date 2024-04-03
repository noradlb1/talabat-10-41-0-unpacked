package com.deliveryhero.perseus.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import com.deliveryhero.perseus.data.local.db.entity.DatabaseEventInfo;
import com.deliveryhero.perseus.data.local.db.entity.HitEvent;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Dao
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b!\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH'J\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r2\u0006\u0010\u000e\u001a\u00020\u0004H'J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000bH'J\b\u0010\u0011\u001a\u00020\u0012H\u0017J\b\u0010\u0013\u001a\u00020\u0006H'J\b\u0010\u0014\u001a\u00020\u0004H'¨\u0006\u0015"}, d2 = {"Lcom/deliveryhero/perseus/data/local/db/dao/CachedHitEventsDao;", "", "()V", "deleteEventsOlderThan", "", "timestamp", "", "deleteHitEvents", "", "hitEvents", "", "Lcom/deliveryhero/perseus/data/local/db/entity/HitEvent;", "getHitEvents", "Lio/reactivex/Single;", "batchSize", "insertEventTimestamp", "event", "loggingInformation", "Lcom/deliveryhero/perseus/data/local/db/entity/DatabaseEventInfo;", "oldestEventTimestamp", "sizeOfBacklog", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class CachedHitEventsDao {
    @Query("DELETE FROM tracking_perseus_events WHERE timestamp < :timestamp")
    public abstract int deleteEventsOlderThan(long j11);

    @Delete
    public abstract void deleteHitEvents(@NotNull List<HitEvent> list);

    @Transaction
    @Query("SELECT * FROM tracking_perseus_events ORDER BY timestamp DESC LIMIT :batchSize")
    @NotNull
    public abstract Single<List<HitEvent>> getHitEvents(int i11);

    @Insert(onConflict = 1)
    public abstract long insertEventTimestamp(@NotNull HitEvent hitEvent);

    @NotNull
    @Transaction
    public DatabaseEventInfo loggingInformation() {
        return new DatabaseEventInfo(oldestEventTimestamp(), sizeOfBacklog());
    }

    @Query("SELECT timestamp FROM tracking_perseus_events ORDER BY timestamp ASC LIMIT 1")
    public abstract long oldestEventTimestamp();

    @Query("SELECT COUNT(payloadTimeStamp) FROM tracking_perseus_events")
    public abstract int sizeOfBacklog();
}
