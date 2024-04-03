package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, Disposable {

    /* renamed from: c  reason: collision with root package name */
    public static final Object f23075c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static final Object f23076d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static final Object f23077e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public static final Object f23078f = new Object();
    private static final long serialVersionUID = -6120223772001106981L;

    /* renamed from: b  reason: collision with root package name */
    public final Runnable f23079b;

    public ScheduledRunnable(Runnable runnable, DisposableContainer disposableContainer) {
        super(3);
        this.f23079b = runnable;
        lazySet(0, disposableContainer);
    }

    public Object call() {
        run();
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispose() {
        /*
            r7 = this;
        L_0x0000:
            r0 = 1
            java.lang.Object r1 = r7.get(r0)
            java.lang.Object r2 = f23078f
            r3 = 0
            if (r1 == r2) goto L_0x0031
            java.lang.Object r2 = f23076d
            if (r1 == r2) goto L_0x0031
            java.lang.Object r4 = f23077e
            if (r1 != r4) goto L_0x0013
            goto L_0x0031
        L_0x0013:
            r5 = 2
            java.lang.Object r5 = r7.get(r5)
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            if (r5 == r6) goto L_0x0020
            r5 = r0
            goto L_0x0021
        L_0x0020:
            r5 = r3
        L_0x0021:
            if (r5 == 0) goto L_0x0024
            r2 = r4
        L_0x0024:
            boolean r0 = r7.compareAndSet(r0, r1, r2)
            if (r0 == 0) goto L_0x0000
            if (r1 == 0) goto L_0x0031
            java.util.concurrent.Future r1 = (java.util.concurrent.Future) r1
            r1.cancel(r5)
        L_0x0031:
            java.lang.Object r0 = r7.get(r3)
            java.lang.Object r1 = f23078f
            if (r0 == r1) goto L_0x004b
            java.lang.Object r1 = f23075c
            if (r0 == r1) goto L_0x004b
            if (r0 != 0) goto L_0x0040
            goto L_0x004b
        L_0x0040:
            boolean r1 = r7.compareAndSet(r3, r0, r1)
            if (r1 == 0) goto L_0x0031
            io.reactivex.rxjava3.disposables.DisposableContainer r0 = (io.reactivex.rxjava3.disposables.DisposableContainer) r0
            r0.delete(r7)
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.schedulers.ScheduledRunnable.dispose():void");
    }

    public boolean isDisposed() {
        Object obj = get(0);
        if (obj == f23075c || obj == f23078f) {
            return true;
        }
        return false;
    }

    public void run() {
        Object obj;
        Object obj2;
        lazySet(2, Thread.currentThread());
        try {
            this.f23079b.run();
            Object obj3 = get(0);
            if (!(obj3 == f23075c || !compareAndSet(0, obj3, f23078f) || obj3 == null)) {
                ((DisposableContainer) obj3).delete(this);
            }
            do {
                obj2 = get(1);
                if (obj2 == f23076d || obj2 == f23077e || compareAndSet(1, obj2, f23078f)) {
                    lazySet(2, (Object) null);
                }
                obj2 = get(1);
                break;
            } while (compareAndSet(1, obj2, f23078f));
            lazySet(2, (Object) null);
        } catch (Throwable th2) {
            Object obj4 = get(0);
            if (!(obj4 == f23075c || !compareAndSet(0, obj4, f23078f) || obj4 == null)) {
                ((DisposableContainer) obj4).delete(this);
            }
            do {
                obj = get(1);
                if (obj == f23076d || obj == f23077e || compareAndSet(1, obj, f23078f)) {
                    lazySet(2, (Object) null);
                }
                obj = get(1);
                break;
            } while (compareAndSet(1, obj, f23078f));
            lazySet(2, (Object) null);
            throw th2;
        }
    }

    public void setFuture(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj != f23078f) {
                if (obj == f23076d) {
                    future.cancel(false);
                    return;
                } else if (obj == f23077e) {
                    future.cancel(true);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    public String toString() {
        String str;
        Object obj = get(1);
        if (obj == f23078f) {
            str = "Finished";
        } else if (obj == f23076d) {
            str = "Disposed(Sync)";
        } else if (obj == f23077e) {
            str = "Disposed(Async)";
        } else {
            Object obj2 = get(2);
            if (obj2 == null) {
                str = "Waiting";
            } else {
                str = "Running on " + obj2;
            }
        }
        return ScheduledRunnable.class.getSimpleName() + "[" + str + "]";
    }
}
