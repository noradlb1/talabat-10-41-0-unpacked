package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import v0.a;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class AbstractResolvableFuture<V> implements ListenableFuture<V> {
    static final AtomicHelper ATOMIC_HELPER;
    static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Object NULL = new Object();
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    private static final Logger log;
    @Nullable
    volatile Listener listeners;
    @Nullable
    volatile Object value;
    @Nullable
    volatile Waiter waiters;

    public static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        public abstract boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2);

        public abstract boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2);

        public abstract void d(Waiter waiter, Waiter waiter2);

        public abstract void e(Waiter waiter, Thread thread);
    }

    public static final class Cancellation {

        /* renamed from: c  reason: collision with root package name */
        public static final Cancellation f10402c;

        /* renamed from: d  reason: collision with root package name */
        public static final Cancellation f10403d;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f10404a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final Throwable f10405b;

        static {
            if (AbstractResolvableFuture.GENERATE_CANCELLATION_CAUSES) {
                f10403d = null;
                f10402c = null;
                return;
            }
            f10403d = new Cancellation(false, (Throwable) null);
            f10402c = new Cancellation(true, (Throwable) null);
        }

        public Cancellation(boolean z11, @Nullable Throwable th2) {
            this.f10404a = z11;
            this.f10405b = th2;
        }
    }

    public static final class Failure {

        /* renamed from: b  reason: collision with root package name */
        public static final Failure f10406b = new Failure(new Throwable("Failure occurred while trying to finish a future.") {
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f10407a;

        public Failure(Throwable th2) {
            this.f10407a = (Throwable) AbstractResolvableFuture.checkNotNull(th2);
        }
    }

    public static final class Listener {

        /* renamed from: d  reason: collision with root package name */
        public static final Listener f10408d = new Listener((Runnable) null, (Executor) null);

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f10409a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f10410b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public Listener f10411c;

        public Listener(Runnable runnable, Executor executor) {
            this.f10409a = runnable;
            this.f10410b = executor;
        }
    }

    public static final class SafeAtomicHelper extends AtomicHelper {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<Waiter, Thread> f10412a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<Waiter, Waiter> f10413b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> f10414c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> f10415d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> f10416e;

        public SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f10412a = atomicReferenceFieldUpdater;
            this.f10413b = atomicReferenceFieldUpdater2;
            this.f10414c = atomicReferenceFieldUpdater3;
            this.f10415d = atomicReferenceFieldUpdater4;
            this.f10416e = atomicReferenceFieldUpdater5;
        }

        public boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2) {
            return a.a(this.f10415d, abstractResolvableFuture, listener, listener2);
        }

        public boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            return a.a(this.f10416e, abstractResolvableFuture, obj, obj2);
        }

        public boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            return a.a(this.f10414c, abstractResolvableFuture, waiter, waiter2);
        }

        public void d(Waiter waiter, Waiter waiter2) {
            this.f10413b.lazySet(waiter, waiter2);
        }

        public void e(Waiter waiter, Thread thread) {
            this.f10412a.lazySet(waiter, thread);
        }
    }

    public static final class SetFuture<V> implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final AbstractResolvableFuture<V> f10417b;

        /* renamed from: c  reason: collision with root package name */
        public final ListenableFuture<? extends V> f10418c;

        public SetFuture(AbstractResolvableFuture<V> abstractResolvableFuture, ListenableFuture<? extends V> listenableFuture) {
            this.f10417b = abstractResolvableFuture;
            this.f10418c = listenableFuture;
        }

        public void run() {
            if (this.f10417b.value == this) {
                if (AbstractResolvableFuture.ATOMIC_HELPER.b(this.f10417b, this, AbstractResolvableFuture.getFutureValue(this.f10418c))) {
                    AbstractResolvableFuture.complete(this.f10417b);
                }
            }
        }
    }

    public static final class SynchronizedHelper extends AtomicHelper {
        public SynchronizedHelper() {
            super();
        }

        public boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.listeners != listener) {
                    return false;
                }
                abstractResolvableFuture.listeners = listener2;
                return true;
            }
        }

        public boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.value != obj) {
                    return false;
                }
                abstractResolvableFuture.value = obj2;
                return true;
            }
        }

        public boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.waiters != waiter) {
                    return false;
                }
                abstractResolvableFuture.waiters = waiter2;
                return true;
            }
        }

        public void d(Waiter waiter, Waiter waiter2) {
            waiter.f10421b = waiter2;
        }

        public void e(Waiter waiter, Thread thread) {
            waiter.f10420a = thread;
        }
    }

    public static final class Waiter {

        /* renamed from: c  reason: collision with root package name */
        public static final Waiter f10419c = new Waiter(false);
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public volatile Thread f10420a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public volatile Waiter f10421b;

        public Waiter(boolean z11) {
        }

        public void a(Waiter waiter) {
            AbstractResolvableFuture.ATOMIC_HELPER.d(this, waiter);
        }

        public void b() {
            Thread thread = this.f10420a;
            if (thread != null) {
                this.f10420a = null;
                LockSupport.unpark(thread);
            }
        }

        public Waiter() {
            AbstractResolvableFuture.ATOMIC_HELPER.e(this, Thread.currentThread());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: androidx.concurrent.futures.AbstractResolvableFuture$SynchronizedHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.concurrent.futures.AbstractResolvableFuture$Waiter> r0 = androidx.concurrent.futures.AbstractResolvableFuture.Waiter.class
            java.lang.String r1 = "guava.concurrent.generate_cancellation_cause"
            java.lang.String r2 = "false"
            java.lang.String r1 = java.lang.System.getProperty(r1, r2)
            boolean r1 = java.lang.Boolean.parseBoolean(r1)
            GENERATE_CANCELLATION_CAUSES = r1
            java.lang.Class<androidx.concurrent.futures.AbstractResolvableFuture> r1 = androidx.concurrent.futures.AbstractResolvableFuture.class
            java.lang.String r2 = r1.getName()
            java.util.logging.Logger r2 = java.util.logging.Logger.getLogger(r2)
            log = r2
            androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper r2 = new androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper     // Catch:{ all -> 0x0048 }
            java.lang.Class<java.lang.Thread> r3 = java.lang.Thread.class
            java.lang.String r4 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r3, r4)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = "b"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = "waiters"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.Class<androidx.concurrent.futures.AbstractResolvableFuture$Listener> r0 = androidx.concurrent.futures.AbstractResolvableFuture.Listener.class
            java.lang.String r3 = "listeners"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            java.lang.String r3 = "value"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r8 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0048 }
            r0 = 0
            goto L_0x004e
        L_0x0048:
            r0 = move-exception
            androidx.concurrent.futures.AbstractResolvableFuture$SynchronizedHelper r2 = new androidx.concurrent.futures.AbstractResolvableFuture$SynchronizedHelper
            r2.<init>()
        L_0x004e:
            ATOMIC_HELPER = r2
            if (r0 == 0) goto L_0x005b
            java.util.logging.Logger r1 = log
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE
            java.lang.String r3 = "SafeAtomicHelper is broken!"
            r1.log(r2, r3, r0)
        L_0x005b:
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            NULL = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.concurrent.futures.AbstractResolvableFuture.<clinit>():void");
    }

    private void addDoneString(StringBuilder sb2) {
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(userObjectToString(uninterruptibly));
            sb2.append("]");
        } catch (ExecutionException e11) {
            sb2.append("FAILURE, cause=[");
            sb2.append(e11.getCause());
            sb2.append("]");
        } catch (CancellationException unused) {
            sb2.append("CANCELLED");
        } catch (RuntimeException e12) {
            sb2.append("UNKNOWN, cause=[");
            sb2.append(e12.getClass());
            sb2.append(" thrown from get()]");
        }
    }

    private static CancellationException cancellationExceptionWithCause(@Nullable String str, @Nullable Throwable th2) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th2);
        return cancellationException;
    }

    @NonNull
    static <T> T checkNotNull(@Nullable T t11) {
        t11.getClass();
        return t11;
    }

    private Listener clearListeners(Listener listener) {
        Listener listener2;
        do {
            listener2 = this.listeners;
        } while (!ATOMIC_HELPER.a(this, listener2, Listener.f10408d));
        Listener listener3 = listener2;
        Listener listener4 = listener;
        Listener listener5 = listener3;
        while (listener5 != null) {
            Listener listener6 = listener5.f10411c;
            listener5.f10411c = listener4;
            listener4 = listener5;
            listener5 = listener6;
        }
        return listener4;
    }

    public static void complete(AbstractResolvableFuture<?> abstractResolvableFuture) {
        Listener listener = null;
        AbstractResolvableFuture<V> abstractResolvableFuture2 = abstractResolvableFuture;
        while (true) {
            abstractResolvableFuture2.releaseWaiters();
            abstractResolvableFuture2.afterDone();
            Listener clearListeners = abstractResolvableFuture2.clearListeners(listener);
            while (true) {
                if (clearListeners != null) {
                    listener = clearListeners.f10411c;
                    Runnable runnable = clearListeners.f10409a;
                    if (runnable instanceof SetFuture) {
                        SetFuture setFuture = (SetFuture) runnable;
                        AbstractResolvableFuture<V> abstractResolvableFuture3 = setFuture.f10417b;
                        if (abstractResolvableFuture3.value == setFuture) {
                            if (ATOMIC_HELPER.b(abstractResolvableFuture3, setFuture, getFutureValue(setFuture.f10418c))) {
                                abstractResolvableFuture2 = abstractResolvableFuture3;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        executeListener(runnable, clearListeners.f10410b);
                    }
                    clearListeners = listener;
                } else {
                    return;
                }
            }
        }
    }

    private static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e11) {
            Logger logger = log;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e11);
        }
    }

    private V getDoneValue(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            throw cancellationExceptionWithCause("Task was cancelled.", ((Cancellation) obj).f10405b);
        } else if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f10407a);
        } else if (obj == NULL) {
            return null;
        } else {
            return obj;
        }
    }

    static Object getFutureValue(ListenableFuture<?> listenableFuture) {
        if (listenableFuture instanceof AbstractResolvableFuture) {
            Object obj = ((AbstractResolvableFuture) listenableFuture).value;
            if (!(obj instanceof Cancellation)) {
                return obj;
            }
            Cancellation cancellation = (Cancellation) obj;
            if (!cancellation.f10404a) {
                return obj;
            }
            if (cancellation.f10405b != null) {
                return new Cancellation(false, cancellation.f10405b);
            }
            return Cancellation.f10403d;
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!GENERATE_CANCELLATION_CAUSES) && isCancelled) {
            return Cancellation.f10403d;
        }
        try {
            Object uninterruptibly = getUninterruptibly(listenableFuture);
            if (uninterruptibly == null) {
                return NULL;
            }
            return uninterruptibly;
        } catch (ExecutionException e11) {
            return new Failure(e11.getCause());
        } catch (CancellationException e12) {
            if (isCancelled) {
                return new Cancellation(false, e12);
            }
            return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e12));
        } catch (Throwable th2) {
            return new Failure(th2);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        V v11;
        boolean z11 = false;
        while (true) {
            try {
                v11 = future.get();
                break;
            } catch (InterruptedException unused) {
                z11 = true;
            } catch (Throwable th2) {
                if (z11) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z11) {
            Thread.currentThread().interrupt();
        }
        return v11;
    }

    private void releaseWaiters() {
        Waiter waiter;
        do {
            waiter = this.waiters;
        } while (!ATOMIC_HELPER.c(this, waiter, Waiter.f10419c));
        while (waiter != null) {
            waiter.b();
            waiter = waiter.f10421b;
        }
    }

    private void removeWaiter(Waiter waiter) {
        waiter.f10420a = null;
        while (true) {
            Waiter waiter2 = this.waiters;
            if (waiter2 != Waiter.f10419c) {
                Waiter waiter3 = null;
                while (waiter2 != null) {
                    Waiter waiter4 = waiter2.f10421b;
                    if (waiter2.f10420a != null) {
                        waiter3 = waiter2;
                    } else if (waiter3 != null) {
                        waiter3.f10421b = waiter4;
                        if (waiter3.f10420a == null) {
                        }
                    } else if (!ATOMIC_HELPER.c(this, waiter2, waiter4)) {
                    }
                    waiter2 = waiter4;
                }
                return;
            }
            return;
        }
    }

    private String userObjectToString(Object obj) {
        if (obj == this) {
            return "this future";
        }
        return String.valueOf(obj);
    }

    public final void addListener(Runnable runnable, Executor executor) {
        checkNotNull(runnable);
        checkNotNull(executor);
        Listener listener = this.listeners;
        if (listener != Listener.f10408d) {
            Listener listener2 = new Listener(runnable, executor);
            do {
                listener2.f10411c = listener;
                if (!ATOMIC_HELPER.a(this, listener, listener2)) {
                    listener = this.listeners;
                } else {
                    return;
                }
            } while (listener != Listener.f10408d);
        }
        executeListener(runnable, executor);
    }

    public void afterDone() {
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, com.google.common.util.concurrent.ListenableFuture<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.value
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
            r3 = r1
            goto L_0x0009
        L_0x0008:
            r3 = r2
        L_0x0009:
            boolean r4 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture.SetFuture
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0061
            boolean r3 = GENERATE_CANCELLATION_CAUSES
            if (r3 == 0) goto L_0x001f
            androidx.concurrent.futures.AbstractResolvableFuture$Cancellation r3 = new androidx.concurrent.futures.AbstractResolvableFuture$Cancellation
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0026
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            androidx.concurrent.futures.AbstractResolvableFuture$Cancellation r3 = androidx.concurrent.futures.AbstractResolvableFuture.Cancellation.f10402c
            goto L_0x0026
        L_0x0024:
            androidx.concurrent.futures.AbstractResolvableFuture$Cancellation r3 = androidx.concurrent.futures.AbstractResolvableFuture.Cancellation.f10403d
        L_0x0026:
            r4 = r7
            r5 = r2
        L_0x0028:
            androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper r6 = ATOMIC_HELPER
            boolean r6 = r6.b(r4, r0, r3)
            if (r6 == 0) goto L_0x0059
            if (r8 == 0) goto L_0x0035
            r4.interruptTask()
        L_0x0035:
            complete(r4)
            boolean r4 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture.SetFuture
            if (r4 == 0) goto L_0x0062
            androidx.concurrent.futures.AbstractResolvableFuture$SetFuture r0 = (androidx.concurrent.futures.AbstractResolvableFuture.SetFuture) r0
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r0.f10418c
            boolean r4 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture
            if (r4 == 0) goto L_0x0055
            r4 = r0
            androidx.concurrent.futures.AbstractResolvableFuture r4 = (androidx.concurrent.futures.AbstractResolvableFuture) r4
            java.lang.Object r0 = r4.value
            if (r0 != 0) goto L_0x004d
            r5 = r1
            goto L_0x004e
        L_0x004d:
            r5 = r2
        L_0x004e:
            boolean r6 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture.SetFuture
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0062
            r5 = r1
            goto L_0x0028
        L_0x0055:
            r0.cancel(r8)
            goto L_0x0062
        L_0x0059:
            java.lang.Object r0 = r4.value
            boolean r6 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture.SetFuture
            if (r6 != 0) goto L_0x0028
            r1 = r5
            goto L_0x0062
        L_0x0061:
            r1 = r2
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.concurrent.futures.AbstractResolvableFuture.cancel(boolean):boolean");
    }

    public final V get(long j11, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long j12 = j11;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j12);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            if ((obj != null) && (!(obj instanceof SetFuture))) {
                return getDoneValue(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                Waiter waiter = this.waiters;
                if (waiter != Waiter.f10419c) {
                    Waiter waiter2 = new Waiter();
                    do {
                        waiter2.a(waiter);
                        if (ATOMIC_HELPER.c(this, waiter, waiter2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                        return getDoneValue(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    removeWaiter(waiter2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            removeWaiter(waiter2);
                        } else {
                            waiter = this.waiters;
                        }
                    } while (waiter != Waiter.f10419c);
                }
                return getDoneValue(this.value);
            }
            while (nanos > 0) {
                Object obj3 = this.value;
                if ((obj3 != null) && (!(obj3 instanceof SetFuture))) {
                    return getDoneValue(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractResolvableFuture = toString();
            String obj4 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = obj4.toLowerCase(locale);
            String str = "Waited " + j12 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String str2 = str + " (plus ";
                long j13 = -nanos;
                long convert = timeUnit2.convert(j13, TimeUnit.NANOSECONDS);
                long nanos2 = j13 - timeUnit2.toNanos(convert);
                int i11 = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                boolean z11 = i11 == 0 || nanos2 > 1000;
                if (i11 > 0) {
                    String str3 = str2 + convert + " " + lowerCase;
                    if (z11) {
                        str3 = str3 + ",";
                    }
                    str2 = str3 + " ";
                }
                if (z11) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + abstractResolvableFuture);
        }
        throw new InterruptedException();
    }

    public void interruptTask() {
    }

    public final boolean isCancelled() {
        return this.value instanceof Cancellation;
    }

    public final boolean isDone() {
        boolean z11;
        Object obj = this.value;
        if (obj != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        return (!(obj instanceof SetFuture)) & z11;
    }

    /* access modifiers changed from: package-private */
    public final void maybePropagateCancellationTo(@Nullable Future<?> future) {
        boolean z11;
        if (future != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    @Nullable
    public String pendingToString() {
        Object obj = this.value;
        if (obj instanceof SetFuture) {
            return "setFuture=[" + userObjectToString(((SetFuture) obj).f10418c) + "]";
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
    }

    public boolean set(@Nullable V v11) {
        if (v11 == null) {
            v11 = NULL;
        }
        if (!ATOMIC_HELPER.b(this, (Object) null, v11)) {
            return false;
        }
        complete(this);
        return true;
    }

    public boolean setException(Throwable th2) {
        if (!ATOMIC_HELPER.b(this, (Object) null, new Failure((Throwable) checkNotNull(th2)))) {
            return false;
        }
        complete(this);
        return true;
    }

    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        SetFuture setFuture;
        Failure failure;
        checkNotNull(listenableFuture);
        Object obj = this.value;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!ATOMIC_HELPER.b(this, (Object) null, getFutureValue(listenableFuture))) {
                    return false;
                }
                complete(this);
                return true;
            }
            setFuture = new SetFuture(this, listenableFuture);
            if (ATOMIC_HELPER.b(this, (Object) null, setFuture)) {
                try {
                    listenableFuture.addListener(setFuture, DirectExecutor.INSTANCE);
                } catch (Throwable unused) {
                    failure = Failure.f10406b;
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof Cancellation) {
            listenableFuture.cancel(((Cancellation) obj).f10404a);
        }
        return false;
        ATOMIC_HELPER.b(this, setFuture, failure);
        return true;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            addDoneString(sb2);
        } else {
            try {
                str = pendingToString();
            } catch (RuntimeException e11) {
                str = "Exception thrown from implementation: " + e11.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb2.append("PENDING, info=[");
                sb2.append(str);
                sb2.append("]");
            } else if (isDone()) {
                addDoneString(sb2);
            } else {
                sb2.append("PENDING");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public final boolean wasInterrupted() {
        Object obj = this.value;
        if (!(obj instanceof Cancellation) || !((Cancellation) obj).f10404a) {
            return false;
        }
        return true;
    }

    public final V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                return getDoneValue(obj2);
            }
            Waiter waiter = this.waiters;
            if (waiter != Waiter.f10419c) {
                Waiter waiter2 = new Waiter();
                do {
                    waiter2.a(waiter);
                    if (ATOMIC_HELPER.c(this, waiter, waiter2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                removeWaiter(waiter2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return getDoneValue(obj);
                    }
                    waiter = this.waiters;
                } while (waiter != Waiter.f10419c);
            }
            return getDoneValue(this.value);
        }
        throw new InterruptedException();
    }
}
