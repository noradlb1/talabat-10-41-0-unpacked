package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class ComputableLiveData<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f35980a;

    /* renamed from: b  reason: collision with root package name */
    public final LiveData<T> f35981b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f35982c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f35983d;
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    public final Runnable f35984e;
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f35985f;

    public ComputableLiveData() {
        this(ArchTaskExecutor.getIOThreadExecutor());
    }

    @WorkerThread
    public abstract T a();

    @NonNull
    public LiveData<T> getLiveData() {
        return this.f35981b;
    }

    public void invalidate() {
        ArchTaskExecutor.getInstance().executeOnMainThread(this.f35985f);
    }

    public ComputableLiveData(@NonNull Executor executor) {
        this.f35982c = new AtomicBoolean(true);
        this.f35983d = new AtomicBoolean(false);
        this.f35984e = new Runnable() {
            /* JADX INFO: finally extract failed */
            /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
            @androidx.annotation.WorkerThread
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r5 = this;
                L_0x0000:
                    androidx.lifecycle.ComputableLiveData r0 = androidx.lifecycle.ComputableLiveData.this
                    java.util.concurrent.atomic.AtomicBoolean r0 = r0.f35983d
                    r1 = 0
                    r2 = 1
                    boolean r0 = r0.compareAndSet(r1, r2)
                    if (r0 == 0) goto L_0x003b
                    r0 = 0
                    r3 = r1
                L_0x000e:
                    androidx.lifecycle.ComputableLiveData r4 = androidx.lifecycle.ComputableLiveData.this     // Catch:{ all -> 0x0032 }
                    java.util.concurrent.atomic.AtomicBoolean r4 = r4.f35982c     // Catch:{ all -> 0x0032 }
                    boolean r4 = r4.compareAndSet(r2, r1)     // Catch:{ all -> 0x0032 }
                    if (r4 == 0) goto L_0x0020
                    androidx.lifecycle.ComputableLiveData r0 = androidx.lifecycle.ComputableLiveData.this     // Catch:{ all -> 0x0032 }
                    java.lang.Object r0 = r0.a()     // Catch:{ all -> 0x0032 }
                    r3 = r2
                    goto L_0x000e
                L_0x0020:
                    if (r3 == 0) goto L_0x0029
                    androidx.lifecycle.ComputableLiveData r2 = androidx.lifecycle.ComputableLiveData.this     // Catch:{ all -> 0x0032 }
                    androidx.lifecycle.LiveData<T> r2 = r2.f35981b     // Catch:{ all -> 0x0032 }
                    r2.postValue(r0)     // Catch:{ all -> 0x0032 }
                L_0x0029:
                    androidx.lifecycle.ComputableLiveData r0 = androidx.lifecycle.ComputableLiveData.this
                    java.util.concurrent.atomic.AtomicBoolean r0 = r0.f35983d
                    r0.set(r1)
                    r1 = r3
                    goto L_0x003b
                L_0x0032:
                    r0 = move-exception
                    androidx.lifecycle.ComputableLiveData r2 = androidx.lifecycle.ComputableLiveData.this
                    java.util.concurrent.atomic.AtomicBoolean r2 = r2.f35983d
                    r2.set(r1)
                    throw r0
                L_0x003b:
                    if (r1 == 0) goto L_0x0047
                    androidx.lifecycle.ComputableLiveData r0 = androidx.lifecycle.ComputableLiveData.this
                    java.util.concurrent.atomic.AtomicBoolean r0 = r0.f35982c
                    boolean r0 = r0.get()
                    if (r0 != 0) goto L_0x0000
                L_0x0047:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ComputableLiveData.AnonymousClass2.run():void");
            }
        };
        this.f35985f = new Runnable() {
            @MainThread
            public void run() {
                boolean hasActiveObservers = ComputableLiveData.this.f35981b.hasActiveObservers();
                if (ComputableLiveData.this.f35982c.compareAndSet(false, true) && hasActiveObservers) {
                    ComputableLiveData computableLiveData = ComputableLiveData.this;
                    computableLiveData.f35980a.execute(computableLiveData.f35984e);
                }
            }
        };
        this.f35980a = executor;
        this.f35981b = new LiveData<T>() {
            public void e() {
                ComputableLiveData computableLiveData = ComputableLiveData.this;
                computableLiveData.f35980a.execute(computableLiveData.f35984e);
            }
        };
    }
}
