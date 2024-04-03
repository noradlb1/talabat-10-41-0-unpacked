package com.deliveryhero.perseus.di;

import androidx.room.Room;
import com.deliveryhero.perseus.data.local.db.TrackingDatabase;
import com.deliveryhero.perseus.data.local.db.migration.AddContextualInformationColumnsMigration;
import com.deliveryhero.perseus.data.local.db.migration.AddHitNumberToHitEventMigration;
import com.deliveryhero.perseus.data.local.db.migration.AddHitsInOneTable;
import com.deliveryhero.perseus.data.local.db.migration.AddIdToHitEventTimestampMigration;
import com.deliveryhero.persistence.cache.LocalStorage;
import com.deliveryhero.persistence.cache.MemoryCache;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/deliveryhero/perseus/di/DatabaseModule;", "", "()V", "PERSEUS_SDK_PREFERENCES", "", "localStorage", "Lcom/deliveryhero/persistence/cache/LocalStorage;", "getLocalStorage", "()Lcom/deliveryhero/persistence/cache/LocalStorage;", "localStorage$delegate", "Lkotlin/Lazy;", "memoryCache", "Lcom/deliveryhero/persistence/cache/MemoryCache;", "getMemoryCache", "()Lcom/deliveryhero/persistence/cache/MemoryCache;", "memoryCache$delegate", "trackingDatabase", "Lcom/deliveryhero/perseus/data/local/db/TrackingDatabase;", "getTrackingDatabase", "()Lcom/deliveryhero/perseus/data/local/db/TrackingDatabase;", "setTrackingDatabase", "(Lcom/deliveryhero/perseus/data/local/db/TrackingDatabase;)V", "clock", "Ljava/util/Calendar;", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DatabaseModule {
    @NotNull
    public static final DatabaseModule INSTANCE = new DatabaseModule();
    @NotNull
    private static final String PERSEUS_SDK_PREFERENCES = "perseus-sdk-pref";
    @NotNull
    private static final Lazy localStorage$delegate = LazyKt__LazyJVMKt.lazy(DatabaseModule$localStorage$2.INSTANCE);
    @NotNull
    private static final Lazy memoryCache$delegate = LazyKt__LazyJVMKt.lazy(DatabaseModule$memoryCache$2.INSTANCE);
    @NotNull
    private static TrackingDatabase trackingDatabase;

    static {
        TrackingDatabase build = Room.databaseBuilder(PerseusAppComponent.INSTANCE.getApplicationContext(), TrackingDatabase.class, "pandora.db.perseus").fallbackToDestructiveMigration().addMigrations(new AddHitNumberToHitEventMigration(), new AddContextualInformationColumnsMigration(), new AddIdToHitEventTimestampMigration(), new AddHitsInOneTable()).build();
        Intrinsics.checkNotNullExpressionValue(build, "databaseBuilder(\n       …   )\n            .build()");
        trackingDatabase = build;
    }

    private DatabaseModule() {
    }

    @NotNull
    public final Calendar clock() {
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }

    @NotNull
    public final LocalStorage getLocalStorage() {
        return (LocalStorage) localStorage$delegate.getValue();
    }

    @NotNull
    public final MemoryCache getMemoryCache() {
        return (MemoryCache) memoryCache$delegate.getValue();
    }

    @NotNull
    public final TrackingDatabase getTrackingDatabase() {
        return trackingDatabase;
    }

    public final void setTrackingDatabase(@NotNull TrackingDatabase trackingDatabase2) {
        Intrinsics.checkNotNullParameter(trackingDatabase2, "<set-?>");
        trackingDatabase = trackingDatabase2;
    }
}
