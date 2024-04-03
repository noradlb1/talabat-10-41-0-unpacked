package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;

public final class ObservableFromArray<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final T[] f17252b;

    public static final class FromArrayDisposable<T> extends BasicQueueDisposable<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17253b;

        /* renamed from: c  reason: collision with root package name */
        public final T[] f17254c;

        /* renamed from: d  reason: collision with root package name */
        public int f17255d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f17256e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f17257f;

        public FromArrayDisposable(Observer<? super T> observer, T[] tArr) {
            this.f17253b = observer;
            this.f17254c = tArr;
        }

        public void a() {
            T[] tArr = this.f17254c;
            int length = tArr.length;
            for (int i11 = 0; i11 < length && !isDisposed(); i11++) {
                T t11 = tArr[i11];
                if (t11 == null) {
                    Observer<? super T> observer = this.f17253b;
                    observer.onError(new NullPointerException("The element at index " + i11 + " is null"));
                    return;
                }
                this.f17253b.onNext(t11);
            }
            if (!isDisposed()) {
                this.f17253b.onComplete();
            }
        }

        public void clear() {
            this.f17255d = this.f17254c.length;
        }

        public void dispose() {
            this.f17257f = true;
        }

        public boolean isDisposed() {
            return this.f17257f;
        }

        public boolean isEmpty() {
            return this.f17255d == this.f17254c.length;
        }

        @Nullable
        public T poll() {
            int i11 = this.f17255d;
            T[] tArr = this.f17254c;
            if (i11 == tArr.length) {
                return null;
            }
            this.f17255d = i11 + 1;
            return ObjectHelper.requireNonNull(tArr[i11], "The array element is null");
        }

        public int requestFusion(int i11) {
            if ((i11 & 1) == 0) {
                return 0;
            }
            this.f17256e = true;
            return 1;
        }
    }

    public ObservableFromArray(T[] tArr) {
        this.f17252b = tArr;
    }

    public void subscribeActual(Observer<? super T> observer) {
        FromArrayDisposable fromArrayDisposable = new FromArrayDisposable(observer, this.f17252b);
        observer.onSubscribe(fromArrayDisposable);
        if (!fromArrayDisposable.f17256e) {
            fromArrayDisposable.a();
        }
    }
}
