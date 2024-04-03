package org.mockito.internal.util.concurrent;

import org.mockito.internal.util.concurrent.WeakConcurrentMap;

public class DetachedThreadLocal<T> implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final WeakConcurrentMap<Thread, T> f63254b;

    /* renamed from: org.mockito.internal.util.concurrent.DetachedThreadLocal$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f63257a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.mockito.internal.util.concurrent.DetachedThreadLocal$Cleaner[] r0 = org.mockito.internal.util.concurrent.DetachedThreadLocal.Cleaner.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f63257a = r0
                org.mockito.internal.util.concurrent.DetachedThreadLocal$Cleaner r1 = org.mockito.internal.util.concurrent.DetachedThreadLocal.Cleaner.THREAD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f63257a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.mockito.internal.util.concurrent.DetachedThreadLocal$Cleaner r1 = org.mockito.internal.util.concurrent.DetachedThreadLocal.Cleaner.MANUAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f63257a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.mockito.internal.util.concurrent.DetachedThreadLocal$Cleaner r1 = org.mockito.internal.util.concurrent.DetachedThreadLocal.Cleaner.INLINE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.mockito.internal.util.concurrent.DetachedThreadLocal.AnonymousClass3.<clinit>():void");
        }
    }

    public enum Cleaner {
        THREAD,
        INLINE,
        MANUAL
    }

    public DetachedThreadLocal(Cleaner cleaner) {
        int i11 = AnonymousClass3.f63257a[cleaner.ordinal()];
        boolean z11 = true;
        if (i11 == 1 || i11 == 2) {
            this.f63254b = new WeakConcurrentMap<Thread, T>(cleaner != Cleaner.THREAD ? false : z11) {
                /* renamed from: b */
                public T a(Thread thread) {
                    return DetachedThreadLocal.this.b(thread);
                }
            };
        } else if (i11 == 3) {
            this.f63254b = new WeakConcurrentMap.WithInlinedExpunction<Thread, T>() {
                /* renamed from: b */
                public T a(Thread thread) {
                    return DetachedThreadLocal.this.b(thread);
                }
            };
        } else {
            throw new AssertionError();
        }
    }

    public T a(T t11) {
        return t11;
    }

    public T b(Thread thread) {
        return null;
    }

    public void clear() {
        this.f63254b.remove(Thread.currentThread());
    }

    public void clearAll() {
        this.f63254b.clear();
    }

    public void define(Thread thread, T t11) {
        this.f63254b.put(thread, t11);
    }

    public T fetchFrom(Thread thread) {
        T t11 = this.f63254b.get(thread);
        if (t11 != null) {
            set(a(t11));
        }
        return t11;
    }

    public T get() {
        return this.f63254b.get(Thread.currentThread());
    }

    public WeakConcurrentMap<Thread, T> getBackingMap() {
        return this.f63254b;
    }

    public T pushTo(Thread thread) {
        T t11 = get();
        if (t11 != null) {
            this.f63254b.put(thread, a(t11));
        }
        return t11;
    }

    public void run() {
        this.f63254b.run();
    }

    public void set(T t11) {
        this.f63254b.put(Thread.currentThread(), t11);
    }

    public T get(Thread thread) {
        return this.f63254b.get(thread);
    }
}
