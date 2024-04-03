package com.google.android.gms.internal.ads;

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
import javax.annotation.CheckForNull;
import net.bytebuddy.description.method.MethodDescription;
import sun.misc.Unsafe;
import v0.a;
import v8.j;

public abstract class zzfvg<V> extends zzfxs implements zzfxa<V> {
    /* access modifiers changed from: private */
    public static final boolean zzaO;
    private static final Logger zzaR;
    /* access modifiers changed from: private */
    public static final zza zzaS;
    private static final Object zzaT = new Object();
    /* access modifiers changed from: private */
    @CheckForNull
    public volatile zzd listeners;
    /* access modifiers changed from: private */
    @CheckForNull
    public volatile Object value;
    /* access modifiers changed from: private */
    @CheckForNull
    public volatile zzk waiters;

    abstract class zza {
        public /* synthetic */ zza(zzfvf zzfvf) {
        }

        public abstract void zza(zzk zzk, @CheckForNull zzk zzk2);

        public abstract void zzb(zzk zzk, Thread thread);

        public abstract boolean zzc(zzfvg<?> zzfvg, @CheckForNull zzd zzd, zzd zzd2);

        public abstract boolean zzd(zzfvg<?> zzfvg, @CheckForNull Object obj, Object obj2);

        public abstract boolean zze(zzfvg<?> zzfvg, @CheckForNull zzk zzk, @CheckForNull zzk zzk2);
    }

    final class zzb {
        @CheckForNull
        static final zzb zza;
        @CheckForNull
        static final zzb zzb;
        final boolean zzc;
        @CheckForNull
        final Throwable zzd;

        static {
            if (zzfvg.zzaO) {
                zzb = null;
                zza = null;
                return;
            }
            zzb = new zzb(false, (Throwable) null);
            zza = new zzb(true, (Throwable) null);
        }

        public zzb(boolean z11, @CheckForNull Throwable th2) {
            this.zzc = z11;
            this.zzd = th2;
        }
    }

    final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") {
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable zzb;

        public zzc(Throwable th2) {
            th2.getClass();
            this.zzb = th2;
        }
    }

    final class zzd {
        static final zzd zza = new zzd();
        @CheckForNull
        zzd next;
        @CheckForNull
        final Runnable zzb;
        @CheckForNull
        final Executor zzc;

        public zzd() {
            this.zzb = null;
            this.zzc = null;
        }

        public zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    final class zze extends zza {
        final AtomicReferenceFieldUpdater<zzk, Thread> zza;
        final AtomicReferenceFieldUpdater<zzk, zzk> zzb;
        final AtomicReferenceFieldUpdater<zzfvg, zzk> zzc;
        final AtomicReferenceFieldUpdater<zzfvg, zzd> zzd;
        final AtomicReferenceFieldUpdater<zzfvg, Object> zze;

        public zze(AtomicReferenceFieldUpdater<zzk, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<zzk, zzk> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<zzfvg, zzk> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<zzfvg, zzd> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<zzfvg, Object> atomicReferenceFieldUpdater5) {
            super((zzfvf) null);
            this.zza = atomicReferenceFieldUpdater;
            this.zzb = atomicReferenceFieldUpdater2;
            this.zzc = atomicReferenceFieldUpdater3;
            this.zzd = atomicReferenceFieldUpdater4;
            this.zze = atomicReferenceFieldUpdater5;
        }

        public final void zza(zzk zzk, @CheckForNull zzk zzk2) {
            this.zzb.lazySet(zzk, zzk2);
        }

        public final void zzb(zzk zzk, Thread thread) {
            this.zza.lazySet(zzk, thread);
        }

        public final boolean zzc(zzfvg<?> zzfvg, @CheckForNull zzd zzd2, zzd zzd3) {
            return a.a(this.zzd, zzfvg, zzd2, zzd3);
        }

        public final boolean zzd(zzfvg<?> zzfvg, @CheckForNull Object obj, Object obj2) {
            return a.a(this.zze, zzfvg, obj, obj2);
        }

        public final boolean zze(zzfvg<?> zzfvg, @CheckForNull zzk zzk, @CheckForNull zzk zzk2) {
            return a.a(this.zzc, zzfvg, zzk, zzk2);
        }
    }

    final class zzf<V> implements Runnable {
        final zzfvg<V> zza;
        final zzfxa<? extends V> zzb;

        public zzf(zzfvg<V> zzfvg, zzfxa<? extends V> zzfxa) {
            this.zza = zzfvg;
            this.zzb = zzfxa;
        }

        public final void run() {
            if (this.zza.value == this) {
                if (zzfvg.zzaS.zzd(this.zza, this, zzfvg.zza(this.zzb))) {
                    zzfvg.zzz(this.zza);
                }
            }
        }
    }

    final class zzg extends zza {
        private zzg() {
            super((zzfvf) null);
        }

        public /* synthetic */ zzg(zzfvh zzfvh) {
            super((zzfvf) null);
        }

        public final void zza(zzk zzk, @CheckForNull zzk zzk2) {
            zzk.next = zzk2;
        }

        public final void zzb(zzk zzk, Thread thread) {
            zzk.thread = thread;
        }

        public final boolean zzc(zzfvg<?> zzfvg, @CheckForNull zzd zzd, zzd zzd2) {
            synchronized (zzfvg) {
                if (zzfvg.listeners != zzd) {
                    return false;
                }
                zzfvg.listeners = zzd2;
                return true;
            }
        }

        public final boolean zzd(zzfvg<?> zzfvg, @CheckForNull Object obj, Object obj2) {
            synchronized (zzfvg) {
                if (zzfvg.value != obj) {
                    return false;
                }
                zzfvg.value = obj2;
                return true;
            }
        }

        public final boolean zze(zzfvg<?> zzfvg, @CheckForNull zzk zzk, @CheckForNull zzk zzk2) {
            synchronized (zzfvg) {
                if (zzfvg.waiters != zzk) {
                    return false;
                }
                zzfvg.waiters = zzk2;
                return true;
            }
        }
    }

    interface zzh<V> extends zzfxa<V> {
    }

    abstract class zzi<V> extends zzfvg<V> implements zzh<V> {
    }

    final class zzj extends zza {
        static final Unsafe zza;
        static final long zzb;
        static final long zzc;
        static final long zzd;
        static final long zze;
        static final long zzf;

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x005d, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0069, code lost:
            throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
            r1 = (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.android.gms.internal.ads.zzfvg.zzj.AnonymousClass1());
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
        static {
            /*
                java.lang.Class<com.google.android.gms.internal.ads.zzfvg$zzk> r0 = com.google.android.gms.internal.ads.zzfvg.zzk.class
                sun.misc.Unsafe r1 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0007 }
                goto L_0x0012
            L_0x0007:
                com.google.android.gms.internal.ads.zzfvg$zzj$1 r1 = new com.google.android.gms.internal.ads.zzfvg$zzj$1     // Catch:{ PrivilegedActionException -> 0x005d }
                r1.<init>()     // Catch:{ PrivilegedActionException -> 0x005d }
                java.lang.Object r1 = java.security.AccessController.doPrivileged(r1)     // Catch:{ PrivilegedActionException -> 0x005d }
                sun.misc.Unsafe r1 = (sun.misc.Unsafe) r1     // Catch:{ PrivilegedActionException -> 0x005d }
            L_0x0012:
                java.lang.Class<com.google.android.gms.internal.ads.zzfvg> r2 = com.google.android.gms.internal.ads.zzfvg.class
                java.lang.String r3 = "waiters"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ Exception -> 0x0053 }
                zzc = r3     // Catch:{ Exception -> 0x0053 }
                java.lang.String r3 = "listeners"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ Exception -> 0x0053 }
                zzb = r3     // Catch:{ Exception -> 0x0053 }
                java.lang.String r3 = "value"
                java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ Exception -> 0x0053 }
                zzd = r2     // Catch:{ Exception -> 0x0053 }
                java.lang.String r2 = "thread"
                java.lang.reflect.Field r2 = r0.getDeclaredField(r2)     // Catch:{ Exception -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ Exception -> 0x0053 }
                zze = r2     // Catch:{ Exception -> 0x0053 }
                java.lang.String r2 = "next"
                java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch:{ Exception -> 0x0053 }
                long r2 = r1.objectFieldOffset(r0)     // Catch:{ Exception -> 0x0053 }
                zzf = r2     // Catch:{ Exception -> 0x0053 }
                zza = r1     // Catch:{ Exception -> 0x0053 }
                return
            L_0x0053:
                r0 = move-exception
                com.google.android.gms.internal.ads.zzfqt.zzb(r0)
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                r1.<init>(r0)
                throw r1
            L_0x005d:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                java.lang.String r2 = "Could not initialize intrinsics"
                java.lang.Throwable r0 = r0.getCause()
                r1.<init>(r2, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfvg.zzj.<clinit>():void");
        }

        private zzj() {
            super((zzfvf) null);
        }

        public /* synthetic */ zzj(zzfvi zzfvi) {
            super((zzfvf) null);
        }

        public final void zza(zzk zzk, @CheckForNull zzk zzk2) {
            zza.putObject(zzk, zzf, zzk2);
        }

        public final void zzb(zzk zzk, Thread thread) {
            zza.putObject(zzk, zze, thread);
        }

        public final boolean zzc(zzfvg<?> zzfvg, @CheckForNull zzd zzd2, zzd zzd3) {
            return j.a(zza, zzfvg, zzb, zzd2, zzd3);
        }

        public final boolean zzd(zzfvg<?> zzfvg, @CheckForNull Object obj, Object obj2) {
            return j.a(zza, zzfvg, zzd, obj, obj2);
        }

        public final boolean zze(zzfvg<?> zzfvg, @CheckForNull zzk zzk, @CheckForNull zzk zzk2) {
            return j.a(zza, zzfvg, zzc, zzk, zzk2);
        }
    }

    final class zzk {
        static final zzk zza = new zzk(false);
        @CheckForNull
        volatile zzk next;
        @CheckForNull
        volatile Thread thread;

        public zzk() {
            zzfvg.zzaS.zzb(this, Thread.currentThread());
        }

        public zzk(boolean z11) {
        }
    }

    static {
        boolean z11;
        Throwable th2;
        Throwable th3;
        zza zza2;
        Class<zzk> cls = zzk.class;
        try {
            z11 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z11 = false;
        }
        zzaO = z11;
        Class<zzfvg> cls2 = zzfvg.class;
        zzaR = Logger.getLogger(cls2.getName());
        try {
            zza2 = new zzj((zzfvi) null);
            th3 = null;
            th2 = null;
        } catch (Throwable th4) {
            th2 = th4;
            th3 = th;
            zza2 = new zzg((zzfvh) null);
        }
        zzaS = zza2;
        if (th2 != null) {
            Logger logger = zzaR;
            Level level = Level.SEVERE;
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME, "UnsafeAtomicHelper is broken!", th3);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME, "SafeAtomicHelper is broken!", th2);
        }
    }

    private static void zzA(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e11) {
            Logger logger = zzaR;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 57 + valueOf2.length());
            sb2.append("RuntimeException while executing runnable ");
            sb2.append(valueOf);
            sb2.append(" with executor ");
            sb2.append(valueOf2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", sb2.toString(), e11);
        }
    }

    private final void zzB(zzk zzk2) {
        zzk2.thread = null;
        while (true) {
            zzk zzk3 = this.waiters;
            if (zzk3 != zzk.zza) {
                zzk zzk4 = null;
                while (zzk3 != null) {
                    zzk zzk5 = zzk3.next;
                    if (zzk3.thread != null) {
                        zzk4 = zzk3;
                    } else if (zzk4 != null) {
                        zzk4.next = zzk5;
                        if (zzk4.thread == null) {
                        }
                    } else if (!zzaS.zze(this, zzk3, zzk5)) {
                    }
                    zzk3 = zzk5;
                }
                return;
            }
            return;
        }
    }

    private static final V zzC(Object obj) throws ExecutionException {
        if (obj instanceof zzb) {
            Throwable th2 = ((zzb) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th2);
            throw cancellationException;
        } else if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).zzb);
        } else if (obj == zzaT) {
            return null;
        } else {
            return obj;
        }
    }

    /* access modifiers changed from: private */
    public static Object zza(zzfxa<?> zzfxa) {
        Throwable zzk2;
        if (zzfxa instanceof zzh) {
            Object obj = ((zzfvg) zzfxa).value;
            if (obj instanceof zzb) {
                zzb zzb2 = (zzb) obj;
                if (zzb2.zzc) {
                    Throwable th2 = zzb2.zzd;
                    obj = th2 != null ? new zzb(false, th2) : zzb.zzb;
                }
            }
            obj.getClass();
            return obj;
        } else if ((zzfxa instanceof zzfxs) && (zzk2 = ((zzfxs) zzfxa).zzk()) != null) {
            return new zzc(zzk2);
        } else {
            boolean isCancelled = zzfxa.isCancelled();
            if ((!zzaO) && isCancelled) {
                zzb zzb3 = zzb.zzb;
                zzb3.getClass();
                return zzb3;
            }
            try {
                Object zzb4 = zzb(zzfxa);
                if (isCancelled) {
                    String valueOf = String.valueOf(zzfxa);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 84);
                    sb2.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                    sb2.append(valueOf);
                    return new zzb(false, new IllegalArgumentException(sb2.toString()));
                } else if (zzb4 == null) {
                    return zzaT;
                } else {
                    return zzb4;
                }
            } catch (ExecutionException e11) {
                if (isCancelled) {
                    return new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(zzfxa)), e11));
                }
                return new zzc(e11.getCause());
            } catch (CancellationException e12) {
                if (!isCancelled) {
                    return new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(zzfxa)), e12));
                }
                return new zzb(false, e12);
            } catch (Throwable th3) {
                return new zzc(th3);
            }
        }
    }

    private static <V> V zzb(Future<V> future) throws ExecutionException {
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

    private final void zzw(StringBuilder sb2) {
        try {
            Object zzb2 = zzb(this);
            sb2.append("SUCCESS, result=[");
            if (zzb2 == null) {
                sb2.append("null");
            } else if (zzb2 == this) {
                sb2.append("this future");
            } else {
                sb2.append(zzb2.getClass().getName());
                sb2.append("@");
                sb2.append(Integer.toHexString(System.identityHashCode(zzb2)));
            }
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

    private final void zzx(StringBuilder sb2) {
        String str;
        int length = sb2.length();
        sb2.append("PENDING");
        Object obj = this.value;
        if (obj instanceof zzf) {
            sb2.append(", setFuture=[");
            zzy(sb2, ((zzf) obj).zzb);
            sb2.append("]");
        } else {
            try {
                str = zzfqr.zza(zzd());
            } catch (RuntimeException | StackOverflowError e11) {
                str = "Exception thrown from implementation: ".concat(String.valueOf(e11.getClass()));
            }
            if (str != null) {
                sb2.append(", info=[");
                sb2.append(str);
                sb2.append("]");
            }
        }
        if (isDone()) {
            sb2.delete(length, sb2.length());
            zzw(sb2);
        }
    }

    private final void zzy(StringBuilder sb2, @CheckForNull Object obj) {
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

    /* access modifiers changed from: private */
    public static void zzz(zzfvg<?> zzfvg) {
        zzfvg<V> zzfvg2;
        zzd zzd2;
        zzd zzd3;
        zzd zzd4 = null;
        zzfvg<?> zzfvg3 = zzfvg;
        while (true) {
            zzk zzk2 = zzfvg3.waiters;
            if (zzaS.zze(zzfvg3, zzk2, zzk.zza)) {
                while (zzk2 != null) {
                    Thread thread = zzk2.thread;
                    if (thread != null) {
                        zzk2.thread = null;
                        LockSupport.unpark(thread);
                    }
                    zzk2 = zzk2.next;
                }
                zzfvg3.zze();
                do {
                    zzd2 = zzfvg3.listeners;
                } while (!zzaS.zzc(zzfvg3, zzd2, zzd.zza));
                while (true) {
                    zzd3 = zzd4;
                    zzd4 = zzd2;
                    if (zzd4 == null) {
                        break;
                    }
                    zzd2 = zzd4.next;
                    zzd4.next = zzd3;
                }
                while (zzd3 != null) {
                    zzd4 = zzd3.next;
                    Runnable runnable = zzd3.zzb;
                    runnable.getClass();
                    if (runnable instanceof zzf) {
                        zzf zzf2 = (zzf) runnable;
                        zzfvg<V> zzfvg4 = zzf2.zza;
                        if (zzfvg4.value == zzf2) {
                            if (zzaS.zzd(zzfvg4, zzf2, zza(zzf2.zzb))) {
                                zzfvg2 = zzfvg4;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        Executor executor = zzd3.zzc;
                        executor.getClass();
                        zzA(runnable, executor);
                    }
                    zzd3 = zzd4;
                }
                return;
            }
            zzfvg2 = zzfvg3;
            zzfvg3 = zzfvg2;
        }
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, com.google.android.gms.internal.ads.zzfxa<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.value
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0008
            r3 = r2
            goto L_0x0009
        L_0x0008:
            r3 = r1
        L_0x0009:
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzfvg.zzf
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0064
            boolean r3 = zzaO
            if (r3 == 0) goto L_0x001f
            com.google.android.gms.internal.ads.zzfvg$zzb r3 = new com.google.android.gms.internal.ads.zzfvg$zzb
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0029
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzfvg$zzb r3 = com.google.android.gms.internal.ads.zzfvg.zzb.zza
            goto L_0x0026
        L_0x0024:
            com.google.android.gms.internal.ads.zzfvg$zzb r3 = com.google.android.gms.internal.ads.zzfvg.zzb.zzb
        L_0x0026:
            r3.getClass()
        L_0x0029:
            r4 = r7
            r5 = r1
        L_0x002b:
            com.google.android.gms.internal.ads.zzfvg$zza r6 = zzaS
            boolean r6 = r6.zzd(r4, r0, r3)
            if (r6 == 0) goto L_0x005d
            if (r8 == 0) goto L_0x0038
            r4.zzp()
        L_0x0038:
            zzz(r4)
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzfvg.zzf
            if (r4 == 0) goto L_0x005b
            com.google.android.gms.internal.ads.zzfvg$zzf r0 = (com.google.android.gms.internal.ads.zzfvg.zzf) r0
            com.google.android.gms.internal.ads.zzfxa<? extends V> r0 = r0.zzb
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzfvg.zzh
            if (r4 == 0) goto L_0x0058
            r4 = r0
            com.google.android.gms.internal.ads.zzfvg r4 = (com.google.android.gms.internal.ads.zzfvg) r4
            java.lang.Object r0 = r4.value
            if (r0 != 0) goto L_0x0050
            r5 = r2
            goto L_0x0051
        L_0x0050:
            r5 = r1
        L_0x0051:
            boolean r6 = r0 instanceof com.google.android.gms.internal.ads.zzfvg.zzf
            r5 = r5 | r6
            if (r5 == 0) goto L_0x005b
            r5 = r2
            goto L_0x002b
        L_0x0058:
            r0.cancel(r8)
        L_0x005b:
            r1 = r2
            goto L_0x0064
        L_0x005d:
            java.lang.Object r0 = r4.value
            boolean r6 = r0 instanceof com.google.android.gms.internal.ads.zzfvg.zzf
            if (r6 != 0) goto L_0x002b
            r1 = r5
        L_0x0064:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfvg.cancel(boolean):boolean");
    }

    public V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) && (!(obj2 instanceof zzf))) {
                return zzC(obj2);
            }
            zzk zzk2 = this.waiters;
            if (zzk2 != zzk.zza) {
                zzk zzk3 = new zzk();
                do {
                    zza zza2 = zzaS;
                    zza2.zza(zzk3, zzk2);
                    if (zza2.zze(this, zzk2, zzk3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                zzB(zzk3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof zzf))));
                        return zzC(obj);
                    }
                    zzk2 = this.waiters;
                } while (zzk2 != zzk.zza);
            }
            Object obj3 = this.value;
            obj3.getClass();
            return zzC(obj3);
        }
        throw new InterruptedException();
    }

    public boolean isCancelled() {
        return this.value instanceof zzb;
    }

    public boolean isDone() {
        Object obj = this.value;
        return (!(obj instanceof zzf)) & (obj != null);
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
            zzw(sb2);
        } else {
            zzx(sb2);
        }
        sb2.append("]");
        return sb2.toString();
    }

    public void zzc(Runnable runnable, Executor executor) {
        zzd zzd2;
        zzfqg.zzc(runnable, "Runnable was null.");
        zzfqg.zzc(executor, "Executor was null.");
        if (isDone() || (zzd2 = this.listeners) == zzd.zza) {
            zzA(runnable, executor);
        }
        zzd zzd3 = new zzd(runnable, executor);
        do {
            zzd3.next = zzd2;
            if (!zzaS.zzc(this, zzd2, zzd3)) {
                zzd2 = this.listeners;
            } else {
                return;
            }
        } while (zzd2 != zzd.zza);
        zzA(runnable, executor);
    }

    @CheckForNull
    public String zzd() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        StringBuilder sb2 = new StringBuilder(41);
        sb2.append("remaining delay=[");
        sb2.append(delay);
        sb2.append(" ms]");
        return sb2.toString();
    }

    public void zze() {
    }

    @CheckForNull
    public final Throwable zzk() {
        if (!(this instanceof zzh)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzb;
        }
        return null;
    }

    public void zzp() {
    }

    public final void zzq(@CheckForNull Future<?> future) {
        boolean z11;
        if (future != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 && isCancelled()) {
            future.cancel(zzv());
        }
    }

    public boolean zzs(V v11) {
        if (v11 == null) {
            v11 = zzaT;
        }
        if (!zzaS.zzd(this, (Object) null, v11)) {
            return false;
        }
        zzz(this);
        return true;
    }

    public boolean zzt(Throwable th2) {
        th2.getClass();
        if (!zzaS.zzd(this, (Object) null, new zzc(th2))) {
            return false;
        }
        zzz(this);
        return true;
    }

    public final boolean zzu(zzfxa<? extends V> zzfxa) {
        zzf zzf2;
        zzc zzc2;
        zzfxa.getClass();
        Object obj = this.value;
        if (obj == null) {
            if (zzfxa.isDone()) {
                if (!zzaS.zzd(this, (Object) null, zza(zzfxa))) {
                    return false;
                }
                zzz(this);
                return true;
            }
            zzf2 = new zzf(this, zzfxa);
            if (zzaS.zzd(this, (Object) null, zzf2)) {
                try {
                    zzfxa.zzc(zzf2, zzfwe.INSTANCE);
                } catch (Throwable unused) {
                    zzc2 = zzc.zza;
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof zzb) {
            zzfxa.cancel(((zzb) obj).zzc);
        }
        return false;
        zzaS.zzd(this, zzf2, zzc2);
        return true;
    }

    public final boolean zzv() {
        Object obj = this.value;
        return (obj instanceof zzb) && ((zzb) obj).zzc;
    }

    public V get(long j11, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long j12 = j11;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j12);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            boolean z11 = true;
            if ((obj != null) && (!(obj instanceof zzf))) {
                return zzC(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                zzk zzk2 = this.waiters;
                if (zzk2 != zzk.zza) {
                    zzk zzk3 = new zzk();
                    do {
                        zza zza2 = zzaS;
                        zza2.zza(zzk3, zzk2);
                        if (zza2.zze(this, zzk2, zzk3)) {
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) && (!(obj2 instanceof zzf))) {
                                        return zzC(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    zzB(zzk3);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            zzB(zzk3);
                        } else {
                            zzk2 = this.waiters;
                        }
                    } while (zzk2 != zzk.zza);
                }
                Object obj3 = this.value;
                obj3.getClass();
                return zzC(obj3);
            }
            while (nanos > 0) {
                Object obj4 = this.value;
                if ((obj4 != null) && (!(obj4 instanceof zzf))) {
                    return zzC(obj4);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String zzfvg = toString();
            String obj5 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = obj5.toLowerCase(locale);
            String lowerCase2 = timeUnit.toString().toLowerCase(locale);
            StringBuilder sb2 = new StringBuilder(String.valueOf(lowerCase2).length() + 28);
            sb2.append("Waited ");
            sb2.append(j12);
            sb2.append(" ");
            sb2.append(lowerCase2);
            String sb3 = sb2.toString();
            if (nanos + 1000 < 0) {
                String concat = sb3.concat(" (plus ");
                long j13 = -nanos;
                long convert = timeUnit2.convert(j13, TimeUnit.NANOSECONDS);
                long nanos2 = j13 - timeUnit2.toNanos(convert);
                int i11 = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                if (i11 != 0 && nanos2 <= 1000) {
                    z11 = false;
                }
                if (i11 > 0) {
                    String valueOf = String.valueOf(concat);
                    StringBuilder sb4 = new StringBuilder(valueOf.length() + 21 + String.valueOf(lowerCase).length());
                    sb4.append(valueOf);
                    sb4.append(convert);
                    sb4.append(" ");
                    sb4.append(lowerCase);
                    String sb5 = sb4.toString();
                    if (z11) {
                        sb5 = sb5.concat(",");
                    }
                    concat = String.valueOf(sb5).concat(" ");
                }
                if (z11) {
                    String valueOf2 = String.valueOf(concat);
                    StringBuilder sb6 = new StringBuilder(valueOf2.length() + 33);
                    sb6.append(valueOf2);
                    sb6.append(nanos2);
                    sb6.append(" nanoseconds ");
                    concat = sb6.toString();
                }
                sb3 = String.valueOf(concat).concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(String.valueOf(sb3).concat(" but future completed as timeout expired"));
            }
            StringBuilder sb7 = new StringBuilder(String.valueOf(sb3).length() + 5 + String.valueOf(zzfvg).length());
            sb7.append(sb3);
            sb7.append(" for ");
            sb7.append(zzfvg);
            throw new TimeoutException(sb7.toString());
        }
        throw new InterruptedException();
    }
}
