package androidx.room;

import android.annotation.SuppressLint;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LiveData;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class RoomTrackingLiveData<T> extends LiveData<T> {

    /* renamed from: e  reason: collision with root package name */
    public final RoomDatabase f37471e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f37472f;

    /* renamed from: g  reason: collision with root package name */
    public final Callable<T> f37473g;

    /* renamed from: h  reason: collision with root package name */
    public final InvalidationTracker.Observer f37474h;

    /* renamed from: i  reason: collision with root package name */
    public final AtomicBoolean f37475i = new AtomicBoolean(true);

    /* renamed from: j  reason: collision with root package name */
    public final AtomicBoolean f37476j = new AtomicBoolean(false);

    /* renamed from: k  reason: collision with root package name */
    public final AtomicBoolean f37477k = new AtomicBoolean(false);

    /* renamed from: l  reason: collision with root package name */
    public final Runnable f37478l = new Runnable() {
        /* JADX WARNING: Removed duplicated region for block: B:22:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:5:0x0025  */
        @androidx.annotation.WorkerThread
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                androidx.room.RoomTrackingLiveData r0 = androidx.room.RoomTrackingLiveData.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f37477k
                r1 = 0
                r2 = 1
                boolean r0 = r0.compareAndSet(r1, r2)
                if (r0 == 0) goto L_0x001b
                androidx.room.RoomTrackingLiveData r0 = androidx.room.RoomTrackingLiveData.this
                androidx.room.RoomDatabase r0 = r0.f37471e
                androidx.room.InvalidationTracker r0 = r0.getInvalidationTracker()
                androidx.room.RoomTrackingLiveData r3 = androidx.room.RoomTrackingLiveData.this
                androidx.room.InvalidationTracker$Observer r3 = r3.f37474h
                r0.addWeakObserver(r3)
            L_0x001b:
                androidx.room.RoomTrackingLiveData r0 = androidx.room.RoomTrackingLiveData.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f37476j
                boolean r0 = r0.compareAndSet(r1, r2)
                if (r0 == 0) goto L_0x005c
                r0 = 0
                r3 = r1
            L_0x0027:
                androidx.room.RoomTrackingLiveData r4 = androidx.room.RoomTrackingLiveData.this     // Catch:{ all -> 0x0053 }
                java.util.concurrent.atomic.AtomicBoolean r4 = r4.f37475i     // Catch:{ all -> 0x0053 }
                boolean r4 = r4.compareAndSet(r2, r1)     // Catch:{ all -> 0x0053 }
                if (r4 == 0) goto L_0x0044
                androidx.room.RoomTrackingLiveData r0 = androidx.room.RoomTrackingLiveData.this     // Catch:{ Exception -> 0x003b }
                java.util.concurrent.Callable<T> r0 = r0.f37473g     // Catch:{ Exception -> 0x003b }
                java.lang.Object r0 = r0.call()     // Catch:{ Exception -> 0x003b }
                r3 = r2
                goto L_0x0027
            L_0x003b:
                r0 = move-exception
                java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x0053 }
                java.lang.String r3 = "Exception while computing database live data."
                r2.<init>(r3, r0)     // Catch:{ all -> 0x0053 }
                throw r2     // Catch:{ all -> 0x0053 }
            L_0x0044:
                if (r3 == 0) goto L_0x004b
                androidx.room.RoomTrackingLiveData r4 = androidx.room.RoomTrackingLiveData.this     // Catch:{ all -> 0x0053 }
                r4.postValue(r0)     // Catch:{ all -> 0x0053 }
            L_0x004b:
                androidx.room.RoomTrackingLiveData r0 = androidx.room.RoomTrackingLiveData.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f37476j
                r0.set(r1)
                goto L_0x005d
            L_0x0053:
                r0 = move-exception
                androidx.room.RoomTrackingLiveData r2 = androidx.room.RoomTrackingLiveData.this
                java.util.concurrent.atomic.AtomicBoolean r2 = r2.f37476j
                r2.set(r1)
                throw r0
            L_0x005c:
                r3 = r1
            L_0x005d:
                if (r3 == 0) goto L_0x0069
                androidx.room.RoomTrackingLiveData r0 = androidx.room.RoomTrackingLiveData.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f37475i
                boolean r0 = r0.get()
                if (r0 != 0) goto L_0x001b
            L_0x0069:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomTrackingLiveData.AnonymousClass1.run():void");
        }
    };

    /* renamed from: m  reason: collision with root package name */
    public final Runnable f37479m = new Runnable() {
        @MainThread
        public void run() {
            boolean hasActiveObservers = RoomTrackingLiveData.this.hasActiveObservers();
            if (RoomTrackingLiveData.this.f37475i.compareAndSet(false, true) && hasActiveObservers) {
                RoomTrackingLiveData.this.h().execute(RoomTrackingLiveData.this.f37478l);
            }
        }
    };
    private final InvalidationLiveDataContainer mContainer;

    @SuppressLint({"RestrictedApi"})
    public RoomTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z11, Callable<T> callable, String[] strArr) {
        this.f37471e = roomDatabase;
        this.f37472f = z11;
        this.f37473g = callable;
        this.mContainer = invalidationLiveDataContainer;
        this.f37474h = new InvalidationTracker.Observer(strArr) {
            public void onInvalidated(@NonNull Set<String> set) {
                ArchTaskExecutor.getInstance().executeOnMainThread(RoomTrackingLiveData.this.f37479m);
            }
        };
    }

    public void e() {
        super.e();
        this.mContainer.b(this);
        h().execute(this.f37478l);
    }

    public void f() {
        super.f();
        this.mContainer.c(this);
    }

    public Executor h() {
        if (this.f37472f) {
            return this.f37471e.getTransactionExecutor();
        }
        return this.f37471e.getQueryExecutor();
    }
}
