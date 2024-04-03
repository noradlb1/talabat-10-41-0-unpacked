package io.reactivex.subjects;

import i.b;
import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class BehaviorSubject<T> extends Subject<T> {
    private static final Object[] EMPTY_ARRAY = new Object[0];

    /* renamed from: i  reason: collision with root package name */
    public static final BehaviorDisposable[] f23583i = new BehaviorDisposable[0];

    /* renamed from: j  reason: collision with root package name */
    public static final BehaviorDisposable[] f23584j = new BehaviorDisposable[0];

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<Object> f23585b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<BehaviorDisposable<T>[]> f23586c;

    /* renamed from: d  reason: collision with root package name */
    public final ReadWriteLock f23587d;

    /* renamed from: e  reason: collision with root package name */
    public final Lock f23588e;

    /* renamed from: f  reason: collision with root package name */
    public final Lock f23589f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicReference<Throwable> f23590g;

    /* renamed from: h  reason: collision with root package name */
    public long f23591h;

    public static final class BehaviorDisposable<T> implements Disposable, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f23592b;

        /* renamed from: c  reason: collision with root package name */
        public final BehaviorSubject<T> f23593c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f23594d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f23595e;

        /* renamed from: f  reason: collision with root package name */
        public AppendOnlyLinkedArrayList<Object> f23596f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f23597g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f23598h;

        /* renamed from: i  reason: collision with root package name */
        public long f23599i;

        public BehaviorDisposable(Observer<? super T> observer, BehaviorSubject<T> behaviorSubject) {
            this.f23592b = observer;
            this.f23593c = behaviorSubject;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
            if (r0 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
            if (test(r0) == false) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
            b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r4 = this;
                boolean r0 = r4.f23598h
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r4)
                boolean r0 = r4.f23598h     // Catch:{ all -> 0x003e }
                if (r0 == 0) goto L_0x000c
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                return
            L_0x000c:
                boolean r0 = r4.f23594d     // Catch:{ all -> 0x003e }
                if (r0 == 0) goto L_0x0012
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                return
            L_0x0012:
                io.reactivex.subjects.BehaviorSubject<T> r0 = r4.f23593c     // Catch:{ all -> 0x003e }
                java.util.concurrent.locks.Lock r1 = r0.f23588e     // Catch:{ all -> 0x003e }
                r1.lock()     // Catch:{ all -> 0x003e }
                long r2 = r0.f23591h     // Catch:{ all -> 0x003e }
                r4.f23599i = r2     // Catch:{ all -> 0x003e }
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r0.f23585b     // Catch:{ all -> 0x003e }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x003e }
                r1.unlock()     // Catch:{ all -> 0x003e }
                r1 = 1
                if (r0 == 0) goto L_0x002b
                r2 = r1
                goto L_0x002c
            L_0x002b:
                r2 = 0
            L_0x002c:
                r4.f23595e = r2     // Catch:{ all -> 0x003e }
                r4.f23594d = r1     // Catch:{ all -> 0x003e }
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                if (r0 == 0) goto L_0x003d
                boolean r0 = r4.test(r0)
                if (r0 == 0) goto L_0x003a
                return
            L_0x003a:
                r4.b()
            L_0x003d:
                return
            L_0x003e:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.BehaviorSubject.BehaviorDisposable.a():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
            r0.forEachWhile(r2);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r2 = this;
            L_0x0000:
                boolean r0 = r2.f23598h
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r2)
                io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.f23596f     // Catch:{ all -> 0x0017 }
                if (r0 != 0) goto L_0x000f
                r0 = 0
                r2.f23595e = r0     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                return
            L_0x000f:
                r1 = 0
                r2.f23596f = r1     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                r0.forEachWhile(r2)
                goto L_0x0000
            L_0x0017:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.BehaviorSubject.BehaviorDisposable.b():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0031, code lost:
            r2.f23597g = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(java.lang.Object r3, long r4) {
            /*
                r2 = this;
                boolean r0 = r2.f23598h
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                boolean r0 = r2.f23597g
                if (r0 != 0) goto L_0x0037
                monitor-enter(r2)
                boolean r0 = r2.f23598h     // Catch:{ all -> 0x0034 }
                if (r0 == 0) goto L_0x0010
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x0010:
                long r0 = r2.f23599i     // Catch:{ all -> 0x0034 }
                int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r4 != 0) goto L_0x0018
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x0018:
                boolean r4 = r2.f23595e     // Catch:{ all -> 0x0034 }
                if (r4 == 0) goto L_0x002d
                io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r4 = r2.f23596f     // Catch:{ all -> 0x0034 }
                if (r4 != 0) goto L_0x0028
                io.reactivex.internal.util.AppendOnlyLinkedArrayList r4 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0034 }
                r5 = 4
                r4.<init>(r5)     // Catch:{ all -> 0x0034 }
                r2.f23596f = r4     // Catch:{ all -> 0x0034 }
            L_0x0028:
                r4.add(r3)     // Catch:{ all -> 0x0034 }
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x002d:
                r4 = 1
                r2.f23594d = r4     // Catch:{ all -> 0x0034 }
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                r2.f23597g = r4
                goto L_0x0037
            L_0x0034:
                r3 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                throw r3
            L_0x0037:
                r2.test(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.BehaviorSubject.BehaviorDisposable.c(java.lang.Object, long):void");
        }

        public void dispose() {
            if (!this.f23598h) {
                this.f23598h = true;
                this.f23593c.b(this);
            }
        }

        public boolean isDisposed() {
            return this.f23598h;
        }

        public boolean test(Object obj) {
            return this.f23598h || NotificationLite.accept(obj, this.f23592b);
        }
    }

    public BehaviorSubject() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f23587d = reentrantReadWriteLock;
        this.f23588e = reentrantReadWriteLock.readLock();
        this.f23589f = reentrantReadWriteLock.writeLock();
        this.f23586c = new AtomicReference<>(f23583i);
        this.f23585b = new AtomicReference<>();
        this.f23590g = new AtomicReference<>();
    }

    @CheckReturnValue
    @NonNull
    public static <T> BehaviorSubject<T> create() {
        return new BehaviorSubject<>();
    }

    @CheckReturnValue
    @NonNull
    public static <T> BehaviorSubject<T> createDefault(T t11) {
        return new BehaviorSubject<>(t11);
    }

    public boolean a(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = (BehaviorDisposable[]) this.f23586c.get();
            if (behaviorDisposableArr == f23584j) {
                return false;
            }
            int length = behaviorDisposableArr.length;
            behaviorDisposableArr2 = new BehaviorDisposable[(length + 1)];
            System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr2, 0, length);
            behaviorDisposableArr2[length] = behaviorDisposable;
        } while (!b.a(this.f23586c, behaviorDisposableArr, behaviorDisposableArr2));
        return true;
    }

    public void b(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable<T>[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = (BehaviorDisposable[]) this.f23586c.get();
            int length = behaviorDisposableArr.length;
            if (length != 0) {
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        i11 = -1;
                        break;
                    } else if (behaviorDisposableArr[i11] == behaviorDisposable) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 >= 0) {
                    if (length == 1) {
                        behaviorDisposableArr2 = f23583i;
                    } else {
                        BehaviorDisposable[] behaviorDisposableArr3 = new BehaviorDisposable[(length - 1)];
                        System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr3, 0, i11);
                        System.arraycopy(behaviorDisposableArr, i11 + 1, behaviorDisposableArr3, i11, (length - i11) - 1);
                        behaviorDisposableArr2 = behaviorDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!b.a(this.f23586c, behaviorDisposableArr, behaviorDisposableArr2));
    }

    public void c(Object obj) {
        this.f23589f.lock();
        this.f23591h++;
        this.f23585b.lazySet(obj);
        this.f23589f.unlock();
    }

    public BehaviorDisposable<T>[] d(Object obj) {
        AtomicReference<BehaviorDisposable<T>[]> atomicReference = this.f23586c;
        BehaviorDisposable<T>[] behaviorDisposableArr = f23584j;
        BehaviorDisposable<T>[] behaviorDisposableArr2 = (BehaviorDisposable[]) atomicReference.getAndSet(behaviorDisposableArr);
        if (behaviorDisposableArr2 != behaviorDisposableArr) {
            c(obj);
        }
        return behaviorDisposableArr2;
    }

    @Nullable
    public Throwable getThrowable() {
        Object obj = this.f23585b.get();
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    @Nullable
    public T getValue() {
        Object obj = this.f23585b.get();
        if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            return null;
        }
        return NotificationLite.getValue(obj);
    }

    @Deprecated
    public Object[] getValues() {
        Object[] objArr = EMPTY_ARRAY;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }

    public boolean hasComplete() {
        return NotificationLite.isComplete(this.f23585b.get());
    }

    public boolean hasObservers() {
        return ((BehaviorDisposable[]) this.f23586c.get()).length != 0;
    }

    public boolean hasThrowable() {
        return NotificationLite.isError(this.f23585b.get());
    }

    public boolean hasValue() {
        Object obj = this.f23585b.get();
        if (obj == null || NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            return false;
        }
        return true;
    }

    public void onComplete() {
        if (b.a(this.f23590g, (Object) null, ExceptionHelper.TERMINATED)) {
            Object complete = NotificationLite.complete();
            for (BehaviorDisposable c11 : d(complete)) {
                c11.c(complete, this.f23591h);
            }
        }
    }

    public void onError(Throwable th2) {
        ObjectHelper.requireNonNull(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!b.a(this.f23590g, (Object) null, th2)) {
            RxJavaPlugins.onError(th2);
            return;
        }
        Object error = NotificationLite.error(th2);
        for (BehaviorDisposable c11 : d(error)) {
            c11.c(error, this.f23591h);
        }
    }

    public void onNext(T t11) {
        ObjectHelper.requireNonNull(t11, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f23590g.get() == null) {
            Object next = NotificationLite.next(t11);
            c(next);
            for (BehaviorDisposable c11 : (BehaviorDisposable[]) this.f23586c.get()) {
                c11.c(next, this.f23591h);
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f23590g.get() != null) {
            disposable.dispose();
        }
    }

    public void subscribeActual(Observer<? super T> observer) {
        BehaviorDisposable behaviorDisposable = new BehaviorDisposable(observer, this);
        observer.onSubscribe(behaviorDisposable);
        if (!a(behaviorDisposable)) {
            Throwable th2 = this.f23590g.get();
            if (th2 == ExceptionHelper.TERMINATED) {
                observer.onComplete();
            } else {
                observer.onError(th2);
            }
        } else if (behaviorDisposable.f23598h) {
            b(behaviorDisposable);
        } else {
            behaviorDisposable.a();
        }
    }

    @Deprecated
    public T[] getValues(T[] tArr) {
        Object obj = this.f23585b.get();
        if (obj == null || NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        T value = NotificationLite.getValue(obj);
        if (tArr.length != 0) {
            tArr[0] = value;
            if (tArr.length == 1) {
                return tArr;
            }
            tArr[1] = null;
            return tArr;
        }
        T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1);
        tArr2[0] = value;
        return tArr2;
    }

    public BehaviorSubject(T t11) {
        this();
        this.f23585b.lazySet(ObjectHelper.requireNonNull(t11, "defaultValue is null"));
    }
}
