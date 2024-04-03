package com.deliveryhero.perseus.data.local.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.deliveryhero.perseus.data.local.db.dao.CachedHitEventsDao;
import com.deliveryhero.perseus.data.local.db.entity.HitEvent;
import com.deliveryhero.perseus.data.local.db.entity.HitEventValues;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Database(entities = {HitEvent.class, HitEventValues.class}, version = 5)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b!\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/perseus/data/local/db/TrackingDatabase;", "Landroidx/room/RoomDatabase;", "()V", "cachedHitEventsDao", "Lcom/deliveryhero/perseus/data/local/db/dao/CachedHitEventsDao;", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class TrackingDatabase extends RoomDatabase {
    @NotNull
    public abstract CachedHitEventsDao cachedHitEventsDao();
}
