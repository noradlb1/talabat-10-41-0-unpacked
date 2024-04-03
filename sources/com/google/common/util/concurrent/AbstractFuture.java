package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.Locale;
import java.util.Objects;
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
import javax.annotation.CheckForNull;
import sun.misc.Unsafe;
import v0.a;
import v8.j;

@GwtCompatible(emulated = true)
@ReflectionSupport(ReflectionSupport.Level.FULL)
@ElementTypesAreNonnullByDefault
public abstract class AbstractFuture<V> extends InternalFutureFailureAccess implements ListenableFuture<V> {
    /* access modifiers changed from: private */
    public static final AtomicHelper ATOMIC_HELPER;
    static final boolean GENERATE_CANCELLATION_CAUSES;
    private static final Object NULL = new Object();
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    private static final Logger log;
    /* access modifiers changed from: private */
    @CheckForNull
    public volatile Listener listeners;
    /* access modifiers changed from: private */
    @CheckForNull
    public volatile Object value;
    /* access modifiers changed from: private */
    @CheckForNull
    public volatile Waiter waiters;

    public static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        public abstract boolean casListeners(AbstractFuture<?> abstractFuture, @CheckForNull Listener listener, Listener listener2);

        public abstract boolean casValue(AbstractFuture<?> abstractFuture, @CheckForNull Object obj, Object obj2);

        public abstract boolean casWaiters(AbstractFuture<?> abstractFuture, @CheckForNull Waiter waiter, @CheckForNull Waiter waiter2);

        public abstract Listener gasListeners(AbstractFuture<?> abstractFuture, Listener listener);

        public abstract Waiter gasWaiters(AbstractFuture<?> abstractFuture, Waiter waiter);

        public abstract void putNext(Waiter waiter, @CheckForNull Waiter waiter2);

        public abstract void putThread(Waiter waiter, Thread thread);
    }

    public static final class Cancellation {
        @CheckForNull
        static final Cancellation CAUSELESS_CANCELLED;
        @CheckForNull
        static final Cancellation CAUSELESS_INTERRUPTED;
        @CheckForNull
        final Throwable cause;
        final boolean wasInterrupted;

        static {
            if (AbstractFuture.GENERATE_CANCELLATION_CAUSES) {
                CAUSELESS_CANCELLED = null;
                CAUSELESS_INTERRUPTED = null;
                return;
            }
            CAUSELESS_CANCELLED = new Cancellation(false, (Throwable) null);
            CAUSELESS_INTERRUPTED = new Cancellation(true, (Throwable) null);
        }

        public Cancellation(boolean z11, @CheckForNull Throwable th2) {
            this.wasInterrupted = z11;
            this.cause = th2;
        }
    }

    public static final class Failure {
        static final Failure FALLBACK_INSTANCE = new Failure(new Throwable("Failure occurred while trying to finish a future.") {
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable exception;

        public Failure(Throwable th2) {
            this.exception = (Throwable) Preconditions.checkNotNull(th2);
        }
    }

    public static final class SafeAtomicHelper extends AtomicHelper {
        final AtomicReferenceFieldUpdater<AbstractFuture, Listener> listenersUpdater;
        final AtomicReferenceFieldUpdater<AbstractFuture, Object> valueUpdater;
        final AtomicReferenceFieldUpdater<Waiter, Waiter> waiterNextUpdater;
        final AtomicReferenceFieldUpdater<Waiter, Thread> waiterThreadUpdater;
        final AtomicReferenceFieldUpdater<AbstractFuture, Waiter> waitersUpdater;

        public SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.waiterThreadUpdater = atomicReferenceFieldUpdater;
            this.waiterNextUpdater = atomicReferenceFieldUpdater2;
            this.waitersUpdater = atomicReferenceFieldUpdater3;
            this.listenersUpdater = atomicReferenceFieldUpdater4;
            this.valueUpdater = atomicReferenceFieldUpdater5;
        }

        public boolean casListeners(AbstractFuture<?> abstractFuture, @CheckForNull Listener listener, Listener listener2) {
            return a.a(this.listenersUpdater, abstractFuture, listener, listener2);
        }

        public boolean casValue(AbstractFuture<?> abstractFuture, @CheckForNull Object obj, Object obj2) {
            return a.a(this.valueUpdater, abstractFuture, obj, obj2);
        }

        public boolean casWaiters(AbstractFuture<?> abstractFuture, @CheckForNull Waiter waiter, @CheckForNull Waiter waiter2) {
            return a.a(this.waitersUpdater, abstractFuture, waiter, waiter2);
        }

        public Listener gasListeners(AbstractFuture<?> abstractFuture, Listener listener) {
            return this.listenersUpdater.getAndSet(abstractFuture, listener);
        }

        public Waiter gasWaiters(AbstractFuture<?> abstractFuture, Waiter waiter) {
            return this.waitersUpdater.getAndSet(abstractFuture, waiter);
        }

        public void putNext(Waiter waiter, @CheckForNull Waiter waiter2) {
            this.waiterNextUpdater.lazySet(waiter, waiter2);
        }

        public void putThread(Waiter waiter, Thread thread) {
            this.waiterThreadUpdater.lazySet(waiter, thread);
        }
    }

    public static final class SetFuture<V> implements Runnable {
        final ListenableFuture<? extends V> future;
        final AbstractFuture<V> owner;

        public SetFuture(AbstractFuture<V> abstractFuture, ListenableFuture<? extends V> listenableFuture) {
            this.owner = abstractFuture;
            this.future = listenableFuture;
        }

        public void run() {
            if (this.owner.value == this) {
                if (AbstractFuture.ATOMIC_HELPER.casValue(this.owner, this, AbstractFuture.getFutureValue(this.future))) {
                    AbstractFuture.complete(this.owner, false);
                }
            }
        }
    }

    public static final class SynchronizedHelper extends AtomicHelper {
        private SynchronizedHelper() {
            super();
        }

        public boolean casListeners(AbstractFuture<?> abstractFuture, @CheckForNull Listener listener, Listener listener2) {
            synchronized (abstractFuture) {
                if (abstractFuture.listeners != listener) {
                    return false;
                }
                Listener unused = abstractFuture.listeners = listener2;
                return true;
            }
        }

        public boolean casValue(AbstractFuture<?> abstractFuture, @CheckForNull Object obj, Object obj2) {
            synchronized (abstractFuture) {
                if (abstractFuture.value != obj) {
                    return false;
                }
                Object unused = abstractFuture.value = obj2;
                return true;
            }
        }

        public boolean casWaiters(AbstractFuture<?> abstractFuture, @CheckForNull Waiter waiter, @CheckForNull Waiter waiter2) {
            synchronized (abstractFuture) {
                if (abstractFuture.waiters != waiter) {
                    return false;
                }
                Waiter unused = abstractFuture.waiters = waiter2;
                return true;
            }
        }

        public Listener gasListeners(AbstractFuture<?> abstractFuture, Listener listener) {
            Listener access$700;
            synchronized (abstractFuture) {
                access$700 = abstractFuture.listeners;
                if (access$700 != listener) {
                    Listener unused = abstractFuture.listeners = listener;
                }
            }
            return access$700;
        }

        public Waiter gasWaiters(AbstractFuture<?> abstractFuture, Waiter waiter) {
            Waiter access$800;
            synchronized (abstractFuture) {
                access$800 = abstractFuture.waiters;
                if (access$800 != waiter) {
                    Waiter unused = abstractFuture.waiters = waiter;
                }
            }
            return access$800;
        }

        public void putNext(Waiter waiter, @CheckForNull Waiter waiter2) {
            waiter.next = waiter2;
        }

        public void putThread(Waiter waiter, Thread thread) {
            waiter.thread = thread;
        }
    }

    public interface Trusted<V> extends ListenableFuture<V> {
    }

    public static abstract class TrustedFuture<V> extends AbstractFuture<V> implements Trusted<V> {
        public void addListener(Runnable runnable, Executor executor) {
            AbstractFuture.super.addListener(runnable, executor);
        }

        @CanIgnoreReturnValue
        public boolean cancel(boolean z11) {
            return AbstractFuture.super.cancel(z11);
        }

        @CanIgnoreReturnValue
        @ParametricNullness
        public V get() throws InterruptedException, ExecutionException {
            return AbstractFuture.super.get();
        }

        public boolean isCancelled() {
            return AbstractFuture.super.isCancelled();
        }

        public final boolean isDone() {
            return AbstractFuture.super.isDone();
        }

        @CanIgnoreReturnValue
        @ParametricNullness
        public final V get(long j11, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return AbstractFuture.super.get(j11, timeUnit);
        }
    }

    public static final class UnsafeAtomicHelper extends AtomicHelper {
        static final long LISTENERS_OFFSET;
        static final Unsafe UNSAFE;
        static final long VALUE_OFFSET;
        static final long WAITERS_OFFSET;
        static final long WAITER_NEXT_OFFSET;
        static final long WAITER_THREAD_OFFSET;

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x005c, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0068, code lost:
            throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
            r1 = (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.common.util.concurrent.AbstractFuture.UnsafeAtomicHelper.AnonymousClass1());
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
        static {
            /*
                java.lang.Class<com.google.common.util.concurrent.AbstractFuture$Waiter> r0 = com.google.common.util.concurrent.AbstractFuture.Waiter.class
                sun.misc.Unsafe r1 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0007 }
                goto L_0x0012
            L_0x0007:
                com.google.common.util.concurrent.AbstractFuture$UnsafeAtomicHelper$1 r1 = new com.google.common.util.concurrent.AbstractFuture$UnsafeAtomicHelper$1     // Catch:{ PrivilegedActionException -> 0x005c }
                r1.<init>()     // Catch:{ PrivilegedActionException -> 0x005c }
                java.lang.Object r1 = java.security.AccessController.doPrivileged(r1)     // Catch:{ PrivilegedActionException -> 0x005c }
                sun.misc.Unsafe r1 = (sun.misc.Unsafe) r1     // Catch:{ PrivilegedActionException -> 0x005c }
            L_0x0012:
                java.lang.Class<com.google.common.util.concurrent.AbstractFuture> r2 = com.google.common.util.concurrent.AbstractFuture.class
                java.lang.String r3 = "waiters"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                WAITERS_OFFSET = r3     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                java.lang.String r3 = "listeners"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                LISTENERS_OFFSET = r3     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                java.lang.String r3 = "value"
                java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                VALUE_OFFSET = r2     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                java.lang.String r2 = "thread"
                java.lang.reflect.Field r2 = r0.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                WAITER_THREAD_OFFSET = r2     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                java.lang.String r2 = "next"
                java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                long r2 = r1.objectFieldOffset(r0)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                WAITER_NEXT_OFFSET = r2     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                UNSAFE = r1     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                return
            L_0x0053:
                r0 = move-exception
                throw r0
            L_0x0055:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                r1.<init>(r0)
                throw r1
            L_0x005c:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                java.lang.String r2 = "Could not initialize intrinsics"
                java.lang.Throwable r0 = r0.getCause()
                r1.<init>(r2, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractFuture.UnsafeAtomicHelper.<clinit>():void");
        }

        private UnsafeAtomicHelper() {
            super();
        }

        public boolean casListeners(AbstractFuture<?> abstractFuture, @CheckForNull Listener listener, Listener listener2) {
            return j.a(UNSAFE, abstractFuture, LISTENERS_OFFSET, listener, listener2);
        }

        public boolean casValue(AbstractFuture<?> abstractFuture, @CheckForNull Object obj, Object obj2) {
            return j.a(UNSAFE, abstractFuture, VALUE_OFFSET, obj, obj2);
        }

        public boolean casWaiters(AbstractFuture<?> abstractFuture, @CheckForNull Waiter waiter, @CheckForNull Waiter waiter2) {
            return j.a(UNSAFE, abstractFuture, WAITERS_OFFSET, waiter, waiter2);
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public com.google.common.util.concurrent.AbstractFuture.Listener gasListeners(com.google.common.util.concurrent.AbstractFuture<?> r3, com.google.common.util.concurrent.AbstractFuture.Listener r4) {
            /*
                r2 = this;
            L_0x0000:
                com.google.common.util.concurrent.AbstractFuture$Listener r0 = r3.listeners
                if (r4 != r0) goto L_0x0007
                return r0
            L_0x0007:
                boolean r1 = r2.casListeners(r3, r0, r4)
                if (r1 == 0) goto L_0x0000
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractFuture.UnsafeAtomicHelper.gasListeners(com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.AbstractFuture$Listener):com.google.common.util.concurrent.AbstractFuture$Listener");
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public com.google.common.util.concurrent.AbstractFuture.Waiter gasWaiters(com.google.common.util.concurrent.AbstractFuture<?> r3, com.google.common.util.concurrent.AbstractFuture.Waiter r4) {
            /*
                r2 = this;
            L_0x0000:
                com.google.common.util.concurrent.AbstractFuture$Waiter r0 = r3.waiters
                if (r4 != r0) goto L_0x0007
                return r0
            L_0x0007:
                boolean r1 = r2.casWaiters(r3, r0, r4)
                if (r1 == 0) goto L_0x0000
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractFuture.UnsafeAtomicHelper.gasWaiters(com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.AbstractFuture$Waiter):com.google.common.util.concurrent.AbstractFuture$Waiter");
        }

        public void putNext(Waiter waiter, @CheckForNull Waiter waiter2) {
            UNSAFE.putObject(waiter, WAITER_NEXT_OFFSET, waiter2);
        }

        public void putThread(Waiter waiter, Thread thread) {
            UNSAFE.putObject(waiter, WAITER_THREAD_OFFSET, thread);
        }
    }

    public static final class Waiter {
        static final Waiter TOMBSTONE = new Waiter(false);
        @CheckForNull
        volatile Waiter next;
        @CheckForNull
        volatile Thread thread;

        public Waiter() {
            AbstractFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
        }

        public Waiter(boolean z11) {
        }

        public void setNext(@CheckForNull Waiter waiter) {
            AbstractFuture.ATOMIC_HELPER.putNext(this, waiter);
        }

        public void unpark() {
            Thread thread2 = this.thread;
            if (thread2 != null) {
                this.thread = null;
                LockSupport.unpark(thread2);
            }
        }
    }

    static {
        boolean z11;
        AtomicHelper atomicHelper;
        Class<Waiter> cls = Waiter.class;
        try {
            z11 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z11 = false;
        }
        GENERATE_CANCELLATION_CAUSES = z11;
        Class<AbstractFuture> cls2 = AbstractFuture.class;
        log = Logger.getLogger(cls2.getName());
        Throwable th2 = null;
        try {
            atomicHelper = new UnsafeAtomicHelper();
            e = null;
        } catch (Error | RuntimeException e11) {
            e = e11;
            try {
                atomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(cls, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(cls, cls, "next"), AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "waiters"), AtomicReferenceFieldUpdater.newUpdater(cls2, Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(cls2, Object.class, "value"));
            } catch (Error | RuntimeException e12) {
                atomicHelper = new SynchronizedHelper();
                th2 = e12;
            }
        }
        ATOMIC_HELPER = atomicHelper;
        if (th2 != null) {
            Logger logger = log;
            Level level = Level.SEVERE;
            logger.log(level, "UnsafeAtomicHelper is broken!", e);
            logger.log(level, "SafeAtomicHelper is broken!", th2);
        }
    }

    private void addDoneString(StringBuilder sb2) {
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb2.append("SUCCESS, result=[");
            appendResultObject(sb2, uninterruptibly);
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

    private void addPendingString(StringBuilder sb2) {
        String str;
        int length = sb2.length();
        sb2.append("PENDING");
        Object obj = this.value;
        if (obj instanceof SetFuture) {
            sb2.append(", setFuture=[");
            appendUserObject(sb2, ((SetFuture) obj).future);
            sb2.append("]");
        } else {
            try {
                str = Strings.emptyToNull(pendingToString());
            } catch (RuntimeException | StackOverflowError e11) {
                str = "Exception thrown from implementation: " + e11.getClass();
            }
            if (str != null) {
                sb2.append(", info=[");
                sb2.append(str);
                sb2.append("]");
            }
        }
        if (isDone()) {
            sb2.delete(length, sb2.length());
            addDoneString(sb2);
        }
    }

    private void appendResultObject(StringBuilder sb2, @CheckForNull Object obj) {
        if (obj == null) {
            sb2.append("null");
        } else if (obj == this) {
            sb2.append("this future");
        } else {
            sb2.append(obj.getClass().getName());
            sb2.append("@");
            sb2.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    private void appendUserObject(StringBuilder sb2, @CheckForNull Object obj) {
        if (obj == this) {
            try {
                sb2.append("this future");
            } catch (RuntimeException | StackOverflowError e11) {
                sb2.append("Exception thrown from implementation: ");
                sb2.append(e11.getClass());
            }
        } else {
            sb2.append(obj);
        }
    }

    private static CancellationException cancellationExceptionWithCause(String str, @CheckForNull Throwable th2) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th2);
        return cancellationException;
    }

    @CheckForNull
    private Listener clearListeners(@CheckForNull Listener listener) {
        Listener listener2 = listener;
        Listener gasListeners = ATOMIC_HELPER.gasListeners(this, Listener.TOMBSTONE);
        while (gasListeners != null) {
            Listener listener3 = gasListeners.next;
            gasListeners.next = listener2;
            listener2 = gasListeners;
            gasListeners = listener3;
        }
        return listener2;
    }

    /* access modifiers changed from: private */
    public static void complete(AbstractFuture<?> abstractFuture, boolean z11) {
        Listener listener = null;
        AbstractFuture<V> abstractFuture2 = abstractFuture;
        while (true) {
            abstractFuture2.releaseWaiters();
            if (z11) {
                abstractFuture2.interruptTask();
                z11 = false;
            }
            abstractFuture2.afterDone();
            Listener clearListeners = abstractFuture2.clearListeners(listener);
            while (true) {
                if (clearListeners != null) {
                    listener = clearListeners.next;
                    Runnable runnable = clearListeners.task;
                    Objects.requireNonNull(runnable);
                    Runnable runnable2 = runnable;
                    if (runnable2 instanceof SetFuture) {
                        SetFuture setFuture = (SetFuture) runnable2;
                        AbstractFuture<V> abstractFuture3 = setFuture.owner;
                        if (abstractFuture3.value == setFuture) {
                            if (ATOMIC_HELPER.casValue(abstractFuture3, setFuture, getFutureValue(setFuture.future))) {
                                abstractFuture2 = abstractFuture3;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        Executor executor = clearListeners.executor;
                        Objects.requireNonNull(executor);
                        executeListener(runnable2, executor);
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

    @ParametricNullness
    private V getDoneValue(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            throw cancellationExceptionWithCause("Task was cancelled.", ((Cancellation) obj).cause);
        } else if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).exception);
        } else if (obj == NULL) {
            return NullnessCasts.uncheckedNull();
        } else {
            return obj;
        }
    }

    /* access modifiers changed from: private */
    public static Object getFutureValue(ListenableFuture<?> listenableFuture) {
        Throwable tryInternalFastPathGetFailure;
        if (listenableFuture instanceof Trusted) {
            Object obj = ((AbstractFuture) listenableFuture).value;
            if (obj instanceof Cancellation) {
                Cancellation cancellation = (Cancellation) obj;
                if (cancellation.wasInterrupted) {
                    obj = cancellation.cause != null ? new Cancellation(false, cancellation.cause) : Cancellation.CAUSELESS_CANCELLED;
                }
            }
            Objects.requireNonNull(obj);
            return obj;
        } else if ((listenableFuture instanceof InternalFutureFailureAccess) && (tryInternalFastPathGetFailure = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) listenableFuture)) != null) {
            return new Failure(tryInternalFastPathGetFailure);
        } else {
            boolean isCancelled = listenableFuture.isCancelled();
            if ((!GENERATE_CANCELLATION_CAUSES) && isCancelled) {
                Cancellation cancellation2 = Cancellation.CAUSELESS_CANCELLED;
                Objects.requireNonNull(cancellation2);
                return cancellation2;
            }
            try {
                Object uninterruptibly = getUninterruptibly(listenableFuture);
                if (isCancelled) {
                    return new Cancellation(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture));
                } else if (uninterruptibly == null) {
                    return NULL;
                } else {
                    return uninterruptibly;
                }
            } catch (ExecutionException e11) {
                if (!isCancelled) {
                    return new Failure(e11.getCause());
                }
                return new Cancellation(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture, e11));
            } catch (CancellationException e12) {
                if (isCancelled) {
                    return new Cancellation(false, e12);
                }
                return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e12));
            } catch (Error | RuntimeException e13) {
                return new Failure(e13);
            }
        }
    }

    @ParametricNullness
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
        for (Waiter gasWaiters = ATOMIC_HELPER.gasWaiters(this, Waiter.TOMBSTONE); gasWaiters != null; gasWaiters = gasWaiters.next) {
            gasWaiters.unpark();
        }
    }

    private void removeWaiter(Waiter waiter) {
        waiter.thread = null;
        while (true) {
            Waiter waiter2 = this.waiters;
            if (waiter2 != Waiter.TOMBSTONE) {
                Waiter waiter3 = null;
                while (waiter2 != null) {
                    Waiter waiter4 = waiter2.next;
                    if (waiter2.thread != null) {
                        waiter3 = waiter2;
                    } else if (waiter3 != null) {
                        waiter3.next = waiter4;
                        if (waiter3.thread == null) {
                        }
                    } else if (!ATOMIC_HELPER.casWaiters(this, waiter2, waiter4)) {
                    }
                    waiter2 = waiter4;
                }
                return;
            }
            return;
        }
    }

    public void addListener(Runnable runnable, Executor executor) {
        Listener listener;
        Preconditions.checkNotNull(runnable, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        if (isDone() || (listener = this.listeners) == Listener.TOMBSTONE) {
            executeListener(runnable, executor);
        }
        Listener listener2 = new Listener(runnable, executor);
        do {
            listener2.next = listener;
            if (!ATOMIC_HELPER.casListeners(this, listener, listener2)) {
                listener = this.listeners;
            } else {
                return;
            }
        } while (listener != Listener.TOMBSTONE);
        executeListener(runnable, executor);
    }

    @ForOverride
    public void afterDone() {
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, com.google.common.util.concurrent.ListenableFuture<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancel(boolean r8) {
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
            boolean r4 = r0 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture
            r3 = r3 | r4
            if (r3 == 0) goto L_0x005f
            boolean r3 = GENERATE_CANCELLATION_CAUSES
            if (r3 == 0) goto L_0x001f
            com.google.common.util.concurrent.AbstractFuture$Cancellation r3 = new com.google.common.util.concurrent.AbstractFuture$Cancellation
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0029
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            com.google.common.util.concurrent.AbstractFuture$Cancellation r3 = com.google.common.util.concurrent.AbstractFuture.Cancellation.CAUSELESS_INTERRUPTED
            goto L_0x0026
        L_0x0024:
            com.google.common.util.concurrent.AbstractFuture$Cancellation r3 = com.google.common.util.concurrent.AbstractFuture.Cancellation.CAUSELESS_CANCELLED
        L_0x0026:
            java.util.Objects.requireNonNull(r3)
        L_0x0029:
            r4 = r7
            r5 = r2
        L_0x002b:
            com.google.common.util.concurrent.AbstractFuture$AtomicHelper r6 = ATOMIC_HELPER
            boolean r6 = r6.casValue(r4, r0, r3)
            if (r6 == 0) goto L_0x0057
            complete(r4, r8)
            boolean r4 = r0 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture
            if (r4 == 0) goto L_0x0060
            com.google.common.util.concurrent.AbstractFuture$SetFuture r0 = (com.google.common.util.concurrent.AbstractFuture.SetFuture) r0
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r0.future
            boolean r4 = r0 instanceof com.google.common.util.concurrent.AbstractFuture.Trusted
            if (r4 == 0) goto L_0x0053
            r4 = r0
            com.google.common.util.concurrent.AbstractFuture r4 = (com.google.common.util.concurrent.AbstractFuture) r4
            java.lang.Object r0 = r4.value
            if (r0 != 0) goto L_0x004b
            r5 = r1
            goto L_0x004c
        L_0x004b:
            r5 = r2
        L_0x004c:
            boolean r6 = r0 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0060
            r5 = r1
            goto L_0x002b
        L_0x0053:
            r0.cancel(r8)
            goto L_0x0060
        L_0x0057:
            java.lang.Object r0 = r4.value
            boolean r6 = r0 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture
            if (r6 != 0) goto L_0x002b
            r1 = r5
            goto L_0x0060
        L_0x005f:
            r1 = r2
        L_0x0060:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractFuture.cancel(boolean):boolean");
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public V get(long j11, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
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
                if (waiter != Waiter.TOMBSTONE) {
                    Waiter waiter2 = new Waiter();
                    do {
                        waiter2.setNext(waiter);
                        if (ATOMIC_HELPER.casWaiters(this, waiter, waiter2)) {
                            do {
                                OverflowAvoidingLockSupport.parkNanos(this, nanos);
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
                    } while (waiter != Waiter.TOMBSTONE);
                }
                Object obj3 = this.value;
                Objects.requireNonNull(obj3);
                return getDoneValue(obj3);
            }
            while (nanos > 0) {
                Object obj4 = this.value;
                if ((obj4 != null) && (!(obj4 instanceof SetFuture))) {
                    return getDoneValue(obj4);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractFuture = toString();
            String obj5 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = obj5.toLowerCase(locale);
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

    public void interruptTask() {
    }

    public boolean isCancelled() {
        return this.value instanceof Cancellation;
    }

    public boolean isDone() {
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
    public final void maybePropagateCancellationTo(@CheckForNull Future<?> future) {
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

    @CheckForNull
    public String pendingToString() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @CanIgnoreReturnValue
    public boolean set(@ParametricNullness V v11) {
        if (v11 == null) {
            v11 = NULL;
        }
        if (!ATOMIC_HELPER.casValue(this, (Object) null, v11)) {
            return false;
        }
        complete(this, false);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean setException(Throwable th2) {
        if (!ATOMIC_HELPER.casValue(this, (Object) null, new Failure((Throwable) Preconditions.checkNotNull(th2)))) {
            return false;
        }
        complete(this, false);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        Failure failure;
        Preconditions.checkNotNull(listenableFuture);
        Object obj = this.value;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!ATOMIC_HELPER.casValue(this, (Object) null, getFutureValue(listenableFuture))) {
                    return false;
                }
                complete(this, false);
                return true;
            }
            SetFuture setFuture = new SetFuture(this, listenableFuture);
            if (ATOMIC_HELPER.casValue(this, (Object) null, setFuture)) {
                try {
                    listenableFuture.addListener(setFuture, DirectExecutor.INSTANCE);
                } catch (Error | RuntimeException e11) {
                    try {
                        failure = new Failure(e11);
                    } catch (Error | RuntimeException unused) {
                        failure = Failure.FALLBACK_INSTANCE;
                    }
                    ATOMIC_HELPER.casValue(this, setFuture, failure);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof Cancellation) {
            listenableFuture.cancel(((Cancellation) obj).wasInterrupted);
        }
        return false;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb2.append(getClass().getSimpleName());
        } else {
            sb2.append(getClass().getName());
        }
        sb2.append('@');
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            addDoneString(sb2);
        } else {
            addPendingString(sb2);
        }
        sb2.append("]");
        return sb2.toString();
    }

    @CheckForNull
    public final Throwable tryInternalFastPathGetFailure() {
        if (!(this instanceof Trusted)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    public final boolean wasInterrupted() {
        Object obj = this.value;
        if (!(obj instanceof Cancellation) || !((Cancellation) obj).wasInterrupted) {
            return false;
        }
        return true;
    }

    public static final class Listener {
        static final Listener TOMBSTONE = new Listener();
        @CheckForNull
        final Executor executor;
        @CheckForNull
        Listener next;
        @CheckForNull
        final Runnable task;

        public Listener(Runnable runnable, Executor executor2) {
            this.task = runnable;
            this.executor = executor2;
        }

        public Listener() {
            this.task = null;
            this.executor = null;
        }
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                return getDoneValue(obj2);
            }
            Waiter waiter = this.waiters;
            if (waiter != Waiter.TOMBSTONE) {
                Waiter waiter2 = new Waiter();
                do {
                    waiter2.setNext(waiter);
                    if (ATOMIC_HELPER.casWaiters(this, waiter, waiter2)) {
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
                } while (waiter != Waiter.TOMBSTONE);
            }
            Object obj3 = this.value;
            Objects.requireNonNull(obj3);
            return getDoneValue(obj3);
        }
        throw new InterruptedException();
    }
}
