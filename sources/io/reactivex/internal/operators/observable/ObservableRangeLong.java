package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

public final class ObservableRangeLong extends Observable<Long> {
    private final long count;
    private final long start;

    public static final class RangeDisposable extends BasicIntQueueDisposable<Long> {
        private static final long serialVersionUID = 396518478098735504L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Long> f17489b;

        /* renamed from: c  reason: collision with root package name */
        public final long f17490c;

        /* renamed from: d  reason: collision with root package name */
        public long f17491d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f17492e;

        public RangeDisposable(Observer<? super Long> observer, long j11, long j12) {
            this.f17489b = observer;
            this.f17491d = j11;
            this.f17490c = j12;
        }

        public void clear() {
            this.f17491d = this.f17490c;
            lazySet(1);
        }

        public void dispose() {
            set(1);
        }

        public boolean isDisposed() {
            return get() != 0;
        }

        public boolean isEmpty() {
            return this.f17491d == this.f17490c;
        }

        public int requestFusion(int i11) {
            if ((i11 & 1) == 0) {
                return 0;
            }
            this.f17492e = true;
            return 1;
        }

        public void run() {
            if (!this.f17492e) {
                Observer<? super Long> observer = this.f17489b;
                long j11 = this.f17490c;
                for (long j12 = this.f17491d; j12 != j11 && get() == 0; j12++) {
                    observer.onNext(Long.valueOf(j12));
                }
                if (get() == 0) {
                    lazySet(1);
                    observer.onComplete();
                }
            }
        }

        @Nullable
        public Long poll() throws Exception {
            long j11 = this.f17491d;
            if (j11 != this.f17490c) {
                this.f17491d = 1 + j11;
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
