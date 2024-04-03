package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;

public final class ObservableRange extends Observable<Integer> {
    private final long end;
    private final int start;

    public static final class RangeDisposable extends BasicIntQueueDisposable<Integer> {
        private static final long serialVersionUID = 396518478098735504L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Integer> f22024b;

        /* renamed from: c  reason: collision with root package name */
        public final long f22025c;

        /* renamed from: d  reason: collision with root package name */
        public long f22026d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f22027e;

        public RangeDisposable(Observer<? super Integer> observer, long j11, long j12) {
            this.f22024b = observer;
            this.f22026d = j11;
            this.f22025c = j12;
        }

        public void clear() {
            this.f22026d = this.f22025c;
            lazySet(1);
        }

        public void dispose() {
            set(1);
        }

        public boolean isDisposed() {
            return get() != 0;
        }

        public boolean isEmpty() {
            return this.f22026d == this.f22025c;
        }

        public int requestFusion(int i11) {
            if ((i11 & 1) == 0) {
                return 0;
            }
            this.f22027e = true;
            return 1;
        }

        public void run() {
            if (!this.f22027e) {
                Observer<? super Integer> observer = this.f22024b;
                long j11 = this.f22025c;
                for (long j12 = this.f22026d; j12 != j11 && get() == 0; j12++) {
                    observer.onNext(Integer.valueOf((int) j12));
                }
                if (get() == 0) {
                    lazySet(1);
                    observer.onComplete();
                }
            }
        }

        @Nullable
        public Integer poll() {
            long j11 = this.f22026d;
            if (j11 != this.f22025c) {
                this.f22026d = 1 + j11;
                return Integer.valueOf((int) j11);
            }
            lazySet(1);
            return null;
        }
    }

    public ObservableRange(int i11, int i12) {
        this.start = i11;
        this.end = ((long) i11) + ((long) i12);
    }

    public void subscribeActual(Observer<? super Integer> observer) {
        RangeDisposable rangeDisposable = new RangeDisposable(observer, (long) this.start, this.end);
        observer.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }
}
