package androidx.room;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;

class InvalidationLiveDataContainer {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public final Set<LiveData> f37420a = Collections.newSetFromMap(new IdentityHashMap());
    private final RoomDatabase mDatabase;

    public InvalidationLiveDataContainer(RoomDatabase roomDatabase) {
        this.mDatabase = roomDatabase;
    }

    public <T> LiveData<T> a(String[] strArr, boolean z11, Callable<T> callable) {
        return new RoomTrackingLiveData(this.mDatabase, this, z11, callable, strArr);
    }

    public void b(LiveData liveData) {
        this.f37420a.add(liveData);
    }

    public void c(LiveData liveData) {
        this.f37420a.remove(liveData);
    }
}
