package androidx.work.impl.utils.futures;

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

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class AbstractFuture<V> implements ListenableFuture<V> {
    private static final Object NULL = new Object();
    private static final long SPIN_THRESHOLD_NANOS = 1000;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f38176e = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: f  reason: collision with root package name */
    public static final AtomicHelper f38177f;
    private static final Logger log;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public volatile Object f38178b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public volatile Listener f38179c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public volatile Waiter f38180d;

    public static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        public abstract boolean a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2);

        public abstract boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2);

        public abstract void d(Waiter waiter, Waiter waiter2);

        public abstract void e(Waiter waiter, Thread thread);
    }

    public static final class Cancellation {

        /* renamed from: c  reason: collision with root package name */
        public static final Cancellation f38181c;

        /* renamed from: d  reason: collision with root package name */
        public static final Cancellation f38182d;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f38183a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final Throwable f38184b;

        static {
            if (AbstractFuture.f38176e) {
                f38182d = null;
                f38181c = null;
                return;
            }
            f38182d = new Cancellation(false, (Throwable) null);
            f38181c = new Cancellation(true, (Throwable) null);
        }

        public Cancellation(boolean z11, @Nullable Throwable th2) {
            this.f38183a = z11;
            this.f38184b = th2;
        }
    }

    public static final class Failure {

        /* renamed from: b  reason: collision with root package name */
        public static final Failure f38185b = new Failure(new Throwable("Failure occurred while trying to finish a future.") {
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f38186a;

        public Failure(Throwable th2) {
            this.f38186a = (Throwable) AbstractFuture.b(th2);
        }
    }

    public static final class Listener {

        /* renamed from: d  reason: collision with root package name */
        public static final Listener f38187d = new Listener((Runnable) null, (Executor) null);

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f38188a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f38189b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public Listener f38190c;

        public Listener(Runnable runnable, Executor executor) {
            this.f38188a = runnable;
            this.f38189b = executor;
        }
    }

    public static final class SafeAtomicHelper extends AtomicHelper {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<Waiter, Thread> f38191a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<Waiter, Waiter> f38192b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, Waiter> f38193c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, Listener> f38194d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, Object> f38195e;

        public SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f38191a = atomicReferenceFieldUpdater;
            this.f38192b = atomicReferenceFieldUpdater2;
            this.f38193c = atomicReferenceFieldUpdater3;
            this.f38194d = atomicReferenceFieldUpdater4;
            this.f38195e = atomicReferenceFieldUpdater5;
        }

        public boolean a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            return a.a(this.f38194d, abstractFuture, listener, listener2);
        }

        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return a.a(this.f38195e, abstractFuture, obj, obj2);
        }

        public boolean c(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            return a.a(this.f38193c, abstractFuture, waiter, waiter2);
        }

        public void d(Waiter waiter, Waiter waiter2) {
            this.f38192b.lazySet(waiter, waiter2);
        }

        public void e(Waiter waiter, Thread thread) {
            this.f38191a.lazySet(waiter, thread);
        }
    }

    public static final class SetFuture<V> implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final AbstractFuture<V> f38196b;

        /* renamed from: c  reason: collision with root package name */
        public final ListenableFuture<? extends V> f38197c;

        public SetFuture(AbstractFuture<V> abstractFuture, ListenableFuture<? extends V> listenableFuture) {
            this.f38196b = abstractFuture;
            this.f38197c = listenableFuture;
        }

        public void run() {
            if (this.f38196b.f38178b == this) {
                if (AbstractFuture.f38177f.b(this.f38196b, this, AbstractFuture.d(this.f38197c))) {
                    AbstractFuture.c(this.f38196b);
                }
            }
        }
    }

    public static final class SynchronizedHelper extends AtomicHelper {
        public SynchronizedHelper() {
            super();
        }

        public boolean a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f38179c != listener) {
                    return false;
                }
                abstractFuture.f38179c = listener2;
                return true;
            }
        }

        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f38178b != obj) {
                    return false;
                }
                abstractFuture.f38178b = obj2;
                return true;
            }
        }

        public boolean c(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f38180d != waiter) {
                    return false;
                }
                abstractFuture.f38180d = waiter2;
                return true;
            }
        }

        public void d(Waiter waiter, Waiter waiter2) {
            waiter.f38200b = waiter2;
        }

        public void e(Waiter waiter, Thread thread) {
            waiter.f38199a = thread;
        }
    }

    public static final class Waiter {

        /* renamed from: c  reason: collision with root package name */
        public static final Waiter f38198c = new Waiter(false);
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public volatile Thread f38199a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public volatile Waiter f38200b;

        public Waiter(boolean z11) {
        }

        public void a(Waiter waiter) {
            AbstractFuture.f38177f.d(this, waiter);
        }

        public void b() {
            Thread thread = this.f38199a;
            if (thread != null) {
                this.f38199a = null;
                LockSupport.unpark(thread);
            }
        }

        public Waiter() {
            AbstractFuture.f38177f.e(this, Thread.currentThread());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: androidx.work.impl.utils.futures.AbstractFuture$SafeAtomicHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: androidx.work.impl.utils.futures.AbstractFuture$SynchronizedHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: androidx.work.impl.utils.futures.AbstractFuture$SafeAtomicHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: androidx.work.impl.utils.futures.AbstractFuture$SafeAtomicHelper} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.work.impl.utils.futures.AbstractFuture$Waiter> r0 = androidx.work.impl.utils.futures.AbstractFuture.Waiter.class
            java.lang.String r1 = "guava.concurrent.generate_cancellation_cause"
            java.lang.String r2 = "false"
            java.lang.String r1 = java.lang.System.getProperty(r1, r2)
            boolean r1 = java.lang.Boolean.parseBoolean(r1)
            f38176e = r1
            java.lang.Class<androidx.work.impl.utils.futures.AbstractFuture> r1 = androidx.work.impl.utils.futures.AbstractFuture.class
            java.lang.String r2 = r1.getName()
            java.util.logging.Logger r2 = java.util.logging.Logger.getLogger(r2)
            log = r2
            androidx.work.impl.utils.futures.AbstractFuture$SafeAtomicHelper r2 = new androidx.work.impl.utils.futures.AbstractFuture$SafeAtomicHelper     // Catch:{ all -> 0x0048 }
            java.lang.Class<java.lang.Thread> r3 = java.lang.Thread.class
            java.lang.String r4 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r3, r4)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = "b"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = "d"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.Class<androidx.work.impl.utils.futures.AbstractFuture$Listener> r0 = androidx.work.impl.utils.futures.AbstractFuture.Listener.class
            java.lang.String r3 = "c"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            java.lang.String r3 = "b"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r8 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0048 }
            r0 = 0
            goto L_0x004e
        L_0x0048:
            r0 = move-exception
            androidx.work.impl.utils.futures.AbstractFuture$SynchronizedHelper r2 = new androidx.work.impl.utils.futures.AbstractFuture$SynchronizedHelper
            r2.<init>()
        L_0x004e:
            f38177f = r2
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.futures.AbstractFuture.<clinit>():void");
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

    @NonNull
    public static <T> T b(@Nullable T t11) {
        t11.getClass();
        return t11;
    }

    public static void c(AbstractFuture<?> abstractFuture) {
        Listener listener = null;
        AbstractFuture<V> abstractFuture2 = abstractFuture;
        while (true) {
            abstractFuture2.releaseWaiters();
            abstractFuture2.a();
            Listener clearListeners = abstractFuture2.clearListeners(listener);
            while (true) {
                if (clearListeners != null) {
                    listener = clearListeners.f38190c;
                    Runnable runnable = clearListeners.f38188a;
                    if (runnable instanceof SetFuture) {
                        SetFuture setFuture = (SetFuture) runnable;
                        AbstractFuture<V> abstractFuture3 = setFuture.f38196b;
                        if (abstractFuture3.f38178b == setFuture) {
                            if (f38177f.b(abstractFuture3, setFuture, d(setFuture.f38197c))) {
                                abstractFuture2 = abstractFuture3;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        executeListener(runnable, clearListeners.f38189b);
                    }
                    clearListeners = listener;
                } else {
                    return;
                }
            }
        }
    }

    private static CancellationException cancellationExceptionWithCause(@Nullable String str, @Nullable Throwable th2) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th2);
        return cancellationException;
    }

    private Listener clearListeners(Listener listener) {
        Listener listener2;
        do {
            listener2 = this.f38179c;
        } while (!f38177f.a(this, listener2, Listener.f38187d));
        Listener listener3 = listener2;
        Listener listener4 = listener;
        Listener listener5 = listener3;
        while (listener5 != null) {
            Listener listener6 = listener5.f38190c;
            listener5.f38190c = listener4;
            listener4 = listener5;
            listener5 = listener6;
        }
        return listener4;
    }

    public static Object d(ListenableFuture<?> listenableFuture) {
        if (listenableFuture instanceof AbstractFuture) {
            Object obj = ((AbstractFuture) listenableFuture).f38178b;
            if (!(obj instanceof Cancellation)) {
                return obj;
            }
            Cancellation cancellation = (Cancellation) obj;
            if (!cancellation.f38183a) {
                return obj;
            }
            if (cancellation.f38184b != null) {
                return new Cancellation(false, cancellation.f38184b);
            }
            return Cancellation.f38182d;
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!f38176e) && isCancelled) {
            return Cancellation.f38182d;
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
            throw cancellationExceptionWithCause("Task was cancelled.", ((Cancellation) obj).f38184b);
        } else if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f38186a);
        } else if (obj == NULL) {
            return null;
        } else {
            return obj;
        }
    }

    private static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
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
            waiter = this.f38180d;
        } while (!f38177f.c(this, waiter, Waiter.f38198c));
        while (waiter != null) {
            waiter.b();
            waiter = waiter.f38200b;
        }
    }

    private void removeWaiter(Waiter waiter) {
        waiter.f38199a = null;
        while (true) {
            Waiter waiter2 = this.f38180d;
            if (waiter2 != Waiter.f38198c) {
                Waiter waiter3 = null;
                while (waiter2 != null) {
                    Waiter waiter4 = waiter2.f38200b;
                    if (waiter2.f38199a != null) {
                        waiter3 = waiter2;
                    } else if (waiter3 != null) {
                        waiter3.f38200b = waiter4;
                        if (waiter3.f38199a == null) {
                        }
                    } else if (!f38177f.c(this, waiter2, waiter4)) {
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

    public void a() {
    }

    public final void addListener(Runnable runnable, Executor executor) {
        b(runnable);
        b(executor);
        Listener listener = this.f38179c;
        if (listener != Listener.f38187d) {
            Listener listener2 = new Listener(runnable, executor);
            do {
                listener2.f38190c = listener;
                if (!f38177f.a(this, listener, listener2)) {
                    listener = this.f38179c;
                } else {
                    return;
                }
            } while (listener != Listener.f38187d);
        }
        executeListener(runnable, executor);
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, com.google.common.util.concurrent.ListenableFuture<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f38178b
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
            r3 = r1
            goto L_0x0009
        L_0x0008:
            r3 = r2
        L_0x0009:
            boolean r4 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.SetFuture
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0061
            boolean r3 = f38176e
            if (r3 == 0) goto L_0x001f
            androidx.work.impl.utils.futures.AbstractFuture$Cancellation r3 = new androidx.work.impl.utils.futures.AbstractFuture$Cancellation
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0026
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            androidx.work.impl.utils.futures.AbstractFuture$Cancellation r3 = androidx.work.impl.utils.futures.AbstractFuture.Cancellation.f38181c
            goto L_0x0026
        L_0x0024:
            androidx.work.impl.utils.futures.AbstractFuture$Cancellation r3 = androidx.work.impl.utils.futures.AbstractFuture.Cancellation.f38182d
        L_0x0026:
            r4 = r7
            r5 = r2
        L_0x0028:
            androidx.work.impl.utils.futures.AbstractFuture$AtomicHelper r6 = f38177f
            boolean r6 = r6.b(r4, r0, r3)
            if (r6 == 0) goto L_0x0059
            if (r8 == 0) goto L_0x0035
            r4.e()
        L_0x0035:
            c(r4)
            boolean r4 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.SetFuture
            if (r4 == 0) goto L_0x0062
            androidx.work.impl.utils.futures.AbstractFuture$SetFuture r0 = (androidx.work.impl.utils.futures.AbstractFuture.SetFuture) r0
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r0.f38197c
            boolean r4 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture
            if (r4 == 0) goto L_0x0055
            r4 = r0
            androidx.work.impl.utils.futures.AbstractFuture r4 = (androidx.work.impl.utils.futures.AbstractFuture) r4
            java.lang.Object r0 = r4.f38178b
            if (r0 != 0) goto L_0x004d
            r5 = r1
            goto L_0x004e
        L_0x004d:
            r5 = r2
        L_0x004e:
            boolean r6 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.SetFuture
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0062
            r5 = r1
            goto L_0x0028
        L_0x0055:
            r0.cancel(r8)
            goto L_0x0062
        L_0x0059:
            java.lang.Object r0 = r4.f38178b
            boolean r6 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.SetFuture
            if (r6 != 0) goto L_0x0028
            r1 = r5
            goto L_0x0062
        L_0x0061:
            r1 = r2
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.futures.AbstractFuture.cancel(boolean):boolean");
    }

    public void e() {
    }

    @Nullable
    public String f() {
        Object obj = this.f38178b;
        if (obj instanceof SetFuture) {
            return "setFuture=[" + userObjectToString(((SetFuture) obj).f38197c) + "]";
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
    }

    public final V get(long j11, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long j12 = j11;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j12);
        if (!Thread.interrupted()) {
            Object obj = this.f38178b;
            if ((obj != null) && (!(obj instanceof SetFuture))) {
                return getDoneValue(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                Waiter waiter = this.f38180d;
                if (waiter != Waiter.f38198c) {
                    Waiter waiter2 = new Waiter();
                    do {
                        waiter2.a(waiter);
                        if (f38177f.c(this, waiter, waiter2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f38178b;
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
                            waiter = this.f38180d;
                        }
                    } while (waiter != Waiter.f38198c);
                }
                return getDoneValue(this.f38178b);
            }
            while (nanos > 0) {
                Object obj3 = this.f38178b;
                if ((obj3 != null) && (!(obj3 instanceof SetFuture))) {
                    return getDoneValue(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractFuture = toString();
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
            throw new TimeoutException(str + " for " + abstractFuture);
        }
        throw new InterruptedException();
    }

    public final boolean isCancelled() {
        return this.f38178b instanceof Cancellation;
    }

    public final boolean isDone() {
        boolean z11;
        Object obj = this.f38178b;
        if (obj != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        return (!(obj instanceof SetFuture)) & z11;
    }

    public boolean set(@Nullable V v11) {
        if (v11 == null) {
            v11 = NULL;
        }
        if (!f38177f.b(this, (Object) null, v11)) {
            return false;
        }
        c(this);
        return true;
    }

    public boolean setException(Throwable th2) {
        if (!f38177f.b(this, (Object) null, new Failure((Throwable) b(th2)))) {
            return false;
        }
        c(this);
        return true;
    }

    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        SetFuture setFuture;
        Failure failure;
        b(listenableFuture);
        Object obj = this.f38178b;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!f38177f.b(this, (Object) null, d(listenableFuture))) {
                    return false;
                }
                c(this);
                return true;
            }
            setFuture = new SetFuture(this, listenableFuture);
            if (f38177f.b(this, (Object) null, setFuture)) {
                try {
                    listenableFuture.addListener(setFuture, DirectExecutor.INSTANCE);
                } catch (Throwable unused) {
                    failure = Failure.f38185b;
                }
                return true;
            }
            obj = this.f38178b;
        }
        if (obj instanceof Cancellation) {
            listenableFuture.cancel(((Cancellation) obj).f38183a);
        }
        return false;
        f38177f.b(this, setFuture, failure);
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
                str = f();
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

    public final V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f38178b;
            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                return getDoneValue(obj2);
            }
            Waiter waiter = this.f38180d;
            if (waiter != Waiter.f38198c) {
                Waiter waiter2 = new Waiter();
                do {
                    waiter2.a(waiter);
                    if (f38177f.c(this, waiter, waiter2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f38178b;
                            } else {
                                removeWaiter(waiter2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return getDoneValue(obj);
                    }
                    waiter = this.f38180d;
                } while (waiter != Waiter.f38198c);
            }
            return getDoneValue(this.f38178b);
        }
        throw new InterruptedException();
    }
}
