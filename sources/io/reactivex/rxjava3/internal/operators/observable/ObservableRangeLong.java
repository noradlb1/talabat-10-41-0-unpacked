package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;

public final class ObservableRangeLong extends Observable<Long> {
    private final long count;
    private final long start;

    public static final class RangeDisposable extends BasicIntQueueDisposable<Long> {
        private static final long serialVersionUID = 396518478098735504L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Long> f22028b;

        /* renamed from: c  reason: collision with root package name */
        public final long f22029c;

        /* renamed from: d  reason: collision with root package name */
        public long f22030d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f22031e;

        public RangeDisposable(Observer<? super Long> observer, long j11, long j12) {
            this.f22028b = observer;
            this.f22030d = j11;
            this.f22029c = j12;
        }

        public void clear() {
            this.f22030d = this.f22029c;
            lazySet(1);
        }

        public void dispose() {
            set(1);
        }

        public boolean isDisposed() {
            return get() != 0;
        }

        public boolean isEmpty() {
            return this.f22030d == this.f22029c;
        }

        public int requestFusion(int i11) {
            if ((i11 & 1) == 0) {
                return 0;
            }
            this.f22031e = true;
            return 1;
        }

        public void run() {
            if (!this.f22031e) {
                Observer<? super Long> observer = this.f22028b;
                long j11 = this.f22029c;
                for (long j12 = this.f22030d; j12 != j11 && get() == 0; j12++) {
                    observer.onNext(Long.valueOf(j12));
                }
                if (get() == 0) {
                    lazySet(1);
                    observer.onComplete();
                }
            }
        }

        @Nullable
        public Long poll() {
            long j11 = this.f22030d;
            if (j11 != this.f22029c) {
                this.f22030d = 1 + j11;
                return Long.valueOf(j11);
            }
            lazySet(1);
            return null;
        }
    }

    public ObservableRangeLong(long j11, long j12) {
        this.start = j11;
        this.count = j12;
    }

    public void subscribeActual(Observer<? super Long> observer) {
        long j11 = this.start;
        RangeDisposable rangeDisposable = new RangeDisposable(observer, j11, j11 + this.count);
        observer.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }
}
