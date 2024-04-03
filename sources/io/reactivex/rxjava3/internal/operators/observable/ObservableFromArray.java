package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.observers.BasicQueueDisposable;
import java.util.Objects;

public final class ObservableFromArray<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final T[] f21780b;

    public static final class FromArrayDisposable<T> extends BasicQueueDisposable<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21781b;

        /* renamed from: c  reason: collision with root package name */
        public final T[] f21782c;

        /* renamed from: d  reason: collision with root package name */
        public int f21783d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f21784e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f21785f;

        public FromArrayDisposable(Observer<? super T> observer, T[] tArr) {
            this.f21781b = observer;
            this.f21782c = tArr;
        }

        public void a() {
            T[] tArr = this.f21782c;
            int length = tArr.length;
            for (int i11 = 0; i11 < length && !isDisposed(); i11++) {
                T t11 = tArr[i11];
                if (t11 == null) {
                    Observer<? super T> observer = this.f21781b;
                    observer.onError(new NullPointerException("The element at index " + i11 + " is null"));
                    return;
                }
                this.f21781b.onNext(t11);
            }
            if (!isDisposed()) {
                this.f21781b.onComplete();
            }
        }

        public void clear() {
            this.f21783d = this.f21782c.length;
        }

        public void dispose() {
            this.f21785f = true;
        }

        public boolean isDisposed() {
            return this.f21785f;
        }

        public boolean isEmpty() {
            return this.f21783d == this.f21782c.length;
        }

        @Nullable
        public T poll() {
            int i11 = this.f21783d;
            T[] tArr = this.f21782c;
            if (i11 == tArr.length) {
                return null;
            }
            this.f21783d = i11 + 1;
            T t11 = tArr[i11];
            Objects.requireNonNull(t11, "The array element is null");
            return t11;
        }

        public int requestFusion(int i11) {
            if ((i11 & 1) == 0) {
                return 0;
            }
            this.f21784e = true;
            return 1;
        }
    }

    public ObservableFromArray(T[] tArr) {
        this.f21780b = tArr;
    }

    public void subscribeActual(Observer<? super T> observer) {
        FromArrayDisposable fromArrayDisposable = new FromArrayDisposable(observer, this.f21780b);
        observer.onSubscribe(fromArrayDisposable);
        if (!fromArrayDisposable.f21784e) {
            fromArrayDisposable.a();
        }
    }
}
