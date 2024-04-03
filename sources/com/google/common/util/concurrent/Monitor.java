package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class Monitor {
    @CheckForNull
    @GuardedBy("lock")
    private Guard activeGuards;
    private final boolean fair;
    /* access modifiers changed from: private */
    public final ReentrantLock lock;

    public static abstract class Guard {
        final Condition condition;
        @Weak
        final Monitor monitor;
        @CheckForNull
        @GuardedBy("monitor.lock")
        Guard next;
        @GuardedBy("monitor.lock")
        int waiterCount = 0;

        public Guard(Monitor monitor2) {
            this.monitor = (Monitor) Preconditions.checkNotNull(monitor2, "monitor");
            this.condition = monitor2.lock.newCondition();
        }

        public abstract boolean isSatisfied();
    }

    public Monitor() {
        this(false);
    }

    @GuardedBy("lock")
    private void await(Guard guard, boolean z11) throws InterruptedException {
        if (z11) {
            signalNextWaiter();
        }
        beginWaitingFor(guard);
        do {
            try {
                guard.condition.await();
            } finally {
                endWaitingFor(guard);
            }
        } while (!guard.isSatisfied());
    }

    @GuardedBy("lock")
    private boolean awaitNanos(Guard guard, long j11, boolean z11) throws InterruptedException {
        boolean z12 = true;
        while (j11 > 0) {
            if (z12) {
                if (z11) {
                    try {
                        signalNextWaiter();
                    } catch (Throwable th2) {
                        if (!z12) {
                            endWaitingFor(guard);
                        }
                        throw th2;
                    }
                }
                beginWaitingFor(guard);
                z12 = false;
            }
            j11 = guard.condition.awaitNanos(j11);
            if (guard.isSatisfied()) {
                if (!z12) {
                    endWaitingFor(guard);
                }
                return true;
            }
        }
        if (!z12) {
            endWaitingFor(guard);
        }
        return false;
    }

    @GuardedBy("lock")
    private void awaitUninterruptibly(Guard guard, boolean z11) {
        if (z11) {
            signalNextWaiter();
        }
        beginWaitingFor(guard);
        do {
            try {
                guard.condition.awaitUninterruptibly();
            } finally {
                endWaitingFor(guard);
            }
        } while (!guard.isSatisfied());
    }

    @GuardedBy("lock")
    private void beginWaitingFor(Guard guard) {
        int i11 = guard.waiterCount;
        guard.waiterCount = i11 + 1;
        if (i11 == 0) {
            guard.next = this.activeGuards;
            this.activeGuards = guard;
        }
    }

    @GuardedBy("lock")
    private void endWaitingFor(Guard guard) {
        int i11 = guard.waiterCount - 1;
        guard.waiterCount = i11;
        if (i11 == 0) {
            Guard guard2 = this.activeGuards;
            Guard guard3 = null;
            while (guard2 != guard) {
                guard3 = guard2;
                guard2 = guard2.next;
            }
            if (guard3 == null) {
                this.activeGuards = guard2.next;
            } else {
                guard3.next = guard2.next;
            }
            guard2.next = null;
        }
    }

    private static long initNanoTime(long j11) {
        if (j11 <= 0) {
            return 0;
        }
        long nanoTime = System.nanoTime();
        if (nanoTime == 0) {
            return 1;
        }
        return nanoTime;
    }

    @GuardedBy("lock")
    private boolean isSatisfied(Guard guard) {
        try {
            return guard.isSatisfied();
        } catch (Error | RuntimeException e11) {
            signalAllWaiters();
            throw e11;
        }
    }

    private static long remainingNanos(long j11, long j12) {
        if (j12 <= 0) {
            return 0;
        }
        return j12 - (System.nanoTime() - j11);
    }

    @GuardedBy("lock")
    private void signalAllWaiters() {
        for (Guard guard = this.activeGuards; guard != null; guard = guard.next) {
            guard.condition.signalAll();
        }
    }

    @GuardedBy("lock")
    private void signalNextWaiter() {
        for (Guard guard = this.activeGuards; guard != null; guard = guard.next) {
            if (isSatisfied(guard)) {
                guard.condition.signal();
                return;
            }
        }
    }

    private static long toSafeNanos(long j11, TimeUnit timeUnit) {
        return Longs.constrainToRange(timeUnit.toNanos(j11), 0, 6917529027641081853L);
    }

    public void enter() {
        this.lock.lock();
    }

    public boolean enterIf(Guard guard) {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public boolean enterIfInterruptibly(Guard guard) throws InterruptedException {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lockInterruptibly();
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public void enterInterruptibly() throws InterruptedException {
        this.lock.lockInterruptibly();
    }

    public void enterWhen(Guard guard) throws InterruptedException {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            reentrantLock.lockInterruptibly();
            try {
                if (!guard.isSatisfied()) {
                    await(guard, isHeldByCurrentThread);
                }
            } catch (Throwable th2) {
                leave();
                throw th2;
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public void enterWhenUninterruptibly(Guard guard) {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            reentrantLock.lock();
            try {
                if (!guard.isSatisfied()) {
                    awaitUninterruptibly(guard, isHeldByCurrentThread);
                }
            } catch (Throwable th2) {
                leave();
                throw th2;
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public int getOccupiedDepth() {
        return this.lock.getHoldCount();
    }

    public int getQueueLength() {
        return this.lock.getQueueLength();
    }

    public int getWaitQueueLength(Guard guard) {
        if (guard.monitor == this) {
            this.lock.lock();
            try {
                return guard.waiterCount;
            } finally {
                this.lock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public boolean hasQueuedThread(Thread thread) {
        return this.lock.hasQueuedThread(thread);
    }

    public boolean hasQueuedThreads() {
        return this.lock.hasQueuedThreads();
    }

    public boolean hasWaiters(Guard guard) {
        return getWaitQueueLength(guard) > 0;
    }

    public boolean isFair() {
        return this.fair;
    }

    public boolean isOccupied() {
        return this.lock.isLocked();
    }

    public boolean isOccupiedByCurrentThread() {
        return this.lock.isHeldByCurrentThread();
    }

    public void leave() {
        ReentrantLock reentrantLock = this.lock;
        try {
            if (reentrantLock.getHoldCount() == 1) {
                signalNextWaiter();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean tryEnter() {
        return this.lock.tryLock();
    }

    public boolean tryEnterIf(Guard guard) {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            if (!reentrantLock.tryLock()) {
                return false;
            }
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public void waitFor(Guard guard) throws InterruptedException {
        if (guard.monitor != this || !this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        } else if (!guard.isSatisfied()) {
            await(guard, true);
        }
    }

    public void waitForUninterruptibly(Guard guard) {
        if (guard.monitor != this || !this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        } else if (!guard.isSatisfied()) {
            awaitUninterruptibly(guard, true);
        }
    }

    public Monitor(boolean z11) {
        this.activeGuards = null;
        this.fair = z11;
        this.lock = new ReentrantLock(z11);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:14|15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r4 = remainingNanos(java.lang.System.nanoTime(), r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002b */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean enter(long r8, java.util.concurrent.TimeUnit r10) {
        /*
            r7 = this;
            long r8 = toSafeNanos(r8, r10)
            java.util.concurrent.locks.ReentrantLock r10 = r7.lock
            boolean r0 = r7.fair
            r1 = 1
            if (r0 != 0) goto L_0x0012
            boolean r0 = r10.tryLock()
            if (r0 == 0) goto L_0x0012
            return r1
        L_0x0012:
            boolean r0 = java.lang.Thread.interrupted()
            long r2 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0033 }
            r4 = r8
        L_0x001b:
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ InterruptedException -> 0x002b }
            boolean r8 = r10.tryLock(r4, r6)     // Catch:{ InterruptedException -> 0x002b }
            if (r0 == 0) goto L_0x002a
            java.lang.Thread r9 = java.lang.Thread.currentThread()
            r9.interrupt()
        L_0x002a:
            return r8
        L_0x002b:
            long r4 = remainingNanos(r2, r8)     // Catch:{ all -> 0x0031 }
            r0 = r1
            goto L_0x001b
        L_0x0031:
            r8 = move-exception
            goto L_0x0035
        L_0x0033:
            r8 = move-exception
            r1 = r0
        L_0x0035:
            if (r1 == 0) goto L_0x003e
            java.lang.Thread r9 = java.lang.Thread.currentThread()
            r9.interrupt()
        L_0x003e:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.enter(long, java.util.concurrent.TimeUnit):boolean");
    }

    public boolean enterInterruptibly(long j11, TimeUnit timeUnit) throws InterruptedException {
        return this.lock.tryLock(j11, timeUnit);
    }

    public boolean waitFor(Guard guard, long j11, TimeUnit timeUnit) throws InterruptedException {
        long safeNanos = toSafeNanos(j11, timeUnit);
        if (guard.monitor != this || !this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        } else if (guard.isSatisfied()) {
            return true;
        } else {
            if (!Thread.interrupted()) {
                return awaitNanos(guard, safeNanos, true);
            }
            throw new InterruptedException();
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean waitForUninterruptibly(com.google.common.util.concurrent.Monitor.Guard r7, long r8, java.util.concurrent.TimeUnit r10) {
        /*
            r6 = this;
            long r8 = toSafeNanos(r8, r10)
            com.google.common.util.concurrent.Monitor r10 = r7.monitor
            if (r10 != r6) goto L_0x0053
            java.util.concurrent.locks.ReentrantLock r10 = r6.lock
            boolean r10 = r10.isHeldByCurrentThread()
            if (r10 == 0) goto L_0x0053
            boolean r10 = r7.isSatisfied()
            r0 = 1
            if (r10 == 0) goto L_0x0018
            return r0
        L_0x0018:
            long r1 = initNanoTime(r8)
            boolean r10 = java.lang.Thread.interrupted()
            r3 = r8
            r5 = r0
        L_0x0022:
            boolean r7 = r6.awaitNanos(r7, r3, r5)     // Catch:{ InterruptedException -> 0x0033, all -> 0x0030 }
            if (r10 == 0) goto L_0x002f
            java.lang.Thread r8 = java.lang.Thread.currentThread()
            r8.interrupt()
        L_0x002f:
            return r7
        L_0x0030:
            r7 = move-exception
            r0 = r10
            goto L_0x0049
        L_0x0033:
            boolean r10 = r7.isSatisfied()     // Catch:{ all -> 0x0048 }
            if (r10 == 0) goto L_0x0041
            java.lang.Thread r7 = java.lang.Thread.currentThread()
            r7.interrupt()
            return r0
        L_0x0041:
            long r3 = remainingNanos(r1, r8)     // Catch:{ all -> 0x0048 }
            r5 = 0
            r10 = r0
            goto L_0x0022
        L_0x0048:
            r7 = move-exception
        L_0x0049:
            if (r0 == 0) goto L_0x0052
            java.lang.Thread r8 = java.lang.Thread.currentThread()
            r8.interrupt()
        L_0x0052:
            throw r7
        L_0x0053:
            java.lang.IllegalMonitorStateException r7 = new java.lang.IllegalMonitorStateException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.waitForUninterruptibly(com.google.common.util.concurrent.Monitor$Guard, long, java.util.concurrent.TimeUnit):boolean");
    }

    public boolean enterIf(Guard guard, long j11, TimeUnit timeUnit) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        } else if (!enter(j11, timeUnit)) {
            return false;
        } else {
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                this.lock.unlock();
            }
        }
    }

    public boolean enterIfInterruptibly(Guard guard, long j11, TimeUnit timeUnit) throws InterruptedException {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            if (!reentrantLock.tryLock(j11, timeUnit)) {
                return false;
            }
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
        if (awaitNanos(r11, r0, r3) != false) goto L_0x0049;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a A[Catch:{ all -> 0x0050, all -> 0x0057 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean enterWhen(com.google.common.util.concurrent.Monitor.Guard r11, long r12, java.util.concurrent.TimeUnit r14) throws java.lang.InterruptedException {
        /*
            r10 = this;
            long r0 = toSafeNanos(r12, r14)
            com.google.common.util.concurrent.Monitor r2 = r11.monitor
            if (r2 != r10) goto L_0x0060
            java.util.concurrent.locks.ReentrantLock r2 = r10.lock
            boolean r3 = r2.isHeldByCurrentThread()
            boolean r4 = r10.fair
            r5 = 0
            r6 = 0
            if (r4 != 0) goto L_0x0029
            boolean r4 = java.lang.Thread.interrupted()
            if (r4 != 0) goto L_0x0023
            boolean r4 = r2.tryLock()
            if (r4 == 0) goto L_0x0029
            r8 = r6
            goto L_0x0034
        L_0x0023:
            java.lang.InterruptedException r11 = new java.lang.InterruptedException
            r11.<init>()
            throw r11
        L_0x0029:
            long r8 = initNanoTime(r0)
            boolean r12 = r2.tryLock(r12, r14)
            if (r12 != 0) goto L_0x0034
            return r5
        L_0x0034:
            boolean r12 = r11.isSatisfied()     // Catch:{ all -> 0x0050 }
            if (r12 != 0) goto L_0x0049
            int r12 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r12 != 0) goto L_0x003f
            goto L_0x0043
        L_0x003f:
            long r0 = remainingNanos(r8, r0)     // Catch:{ all -> 0x0050 }
        L_0x0043:
            boolean r11 = r10.awaitNanos(r11, r0, r3)     // Catch:{ all -> 0x0050 }
            if (r11 == 0) goto L_0x004a
        L_0x0049:
            r5 = 1
        L_0x004a:
            if (r5 != 0) goto L_0x004f
            r2.unlock()
        L_0x004f:
            return r5
        L_0x0050:
            r11 = move-exception
            if (r3 != 0) goto L_0x005c
            r10.signalNextWaiter()     // Catch:{ all -> 0x0057 }
            goto L_0x005c
        L_0x0057:
            r11 = move-exception
            r2.unlock()
            throw r11
        L_0x005c:
            r2.unlock()
            throw r11
        L_0x0060:
            java.lang.IllegalMonitorStateException r11 = new java.lang.IllegalMonitorStateException
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.enterWhen(com.google.common.util.concurrent.Monitor$Guard, long, java.util.concurrent.TimeUnit):boolean");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:39|40|41) */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r9 = remainingNanos(r7, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0070, code lost:
        r12 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0071, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0076, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x006a */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036 A[Catch:{ InterruptedException -> 0x005d, all -> 0x0058, all -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0037 A[Catch:{ InterruptedException -> 0x005d, all -> 0x0058, all -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004b A[SYNTHETIC, Splitter:B:25:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean enterWhenUninterruptibly(com.google.common.util.concurrent.Monitor.Guard r12, long r13, java.util.concurrent.TimeUnit r15) {
        /*
            r11 = this;
            long r13 = toSafeNanos(r13, r15)
            com.google.common.util.concurrent.Monitor r15 = r12.monitor
            if (r15 != r11) goto L_0x007e
            java.util.concurrent.locks.ReentrantLock r15 = r11.lock
            boolean r0 = r15.isHeldByCurrentThread()
            boolean r1 = java.lang.Thread.interrupted()
            boolean r2 = r11.fair     // Catch:{ all -> 0x0073 }
            r3 = 0
            r4 = 0
            r6 = 1
            if (r2 != 0) goto L_0x0023
            boolean r2 = r15.tryLock()     // Catch:{ all -> 0x0073 }
            if (r2 != 0) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r7 = r4
            goto L_0x0030
        L_0x0023:
            long r7 = initNanoTime(r13)     // Catch:{ all -> 0x0073 }
            r9 = r13
        L_0x0028:
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ InterruptedException -> 0x006a }
            boolean r2 = r15.tryLock(r9, r2)     // Catch:{ InterruptedException -> 0x006a }
            if (r2 == 0) goto L_0x0060
        L_0x0030:
            boolean r2 = r12.isSatisfied()     // Catch:{ InterruptedException -> 0x005d, all -> 0x0058 }
            if (r2 == 0) goto L_0x0037
            goto L_0x0049
        L_0x0037:
            int r2 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0041
            long r7 = initNanoTime(r13)     // Catch:{ InterruptedException -> 0x005d, all -> 0x0058 }
            r9 = r13
            goto L_0x0045
        L_0x0041:
            long r9 = remainingNanos(r7, r13)     // Catch:{ InterruptedException -> 0x005d, all -> 0x0058 }
        L_0x0045:
            boolean r6 = r11.awaitNanos(r12, r9, r0)     // Catch:{ InterruptedException -> 0x005d, all -> 0x0058 }
        L_0x0049:
            if (r6 != 0) goto L_0x004e
            r15.unlock()     // Catch:{ all -> 0x0073 }
        L_0x004e:
            if (r1 == 0) goto L_0x0057
            java.lang.Thread r12 = java.lang.Thread.currentThread()
            r12.interrupt()
        L_0x0057:
            return r6
        L_0x0058:
            r12 = move-exception
            r15.unlock()     // Catch:{ all -> 0x0073 }
            throw r12     // Catch:{ all -> 0x0073 }
        L_0x005d:
            r0 = r3
            r1 = r6
            goto L_0x0030
        L_0x0060:
            if (r1 == 0) goto L_0x0069
            java.lang.Thread r12 = java.lang.Thread.currentThread()
            r12.interrupt()
        L_0x0069:
            return r3
        L_0x006a:
            long r9 = remainingNanos(r7, r13)     // Catch:{ all -> 0x0070 }
            r1 = r6
            goto L_0x0028
        L_0x0070:
            r12 = move-exception
            r1 = r6
            goto L_0x0074
        L_0x0073:
            r12 = move-exception
        L_0x0074:
            if (r1 == 0) goto L_0x007d
            java.lang.Thread r13 = java.lang.Thread.currentThread()
            r13.interrupt()
        L_0x007d:
            throw r12
        L_0x007e:
            java.lang.IllegalMonitorStateException r12 = new java.lang.IllegalMonitorStateException
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.enterWhenUninterruptibly(com.google.common.util.concurrent.Monitor$Guard, long, java.util.concurrent.TimeUnit):boolean");
    }
}
