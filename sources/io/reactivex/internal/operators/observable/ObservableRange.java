package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

public final class ObservableRange extends Observable<Integer> {
    private final long end;
    private final int start;

    public static final class RangeDisposable extends BasicIntQueueDisposable<Integer> {
        private static final long serialVersionUID = 396518478098735504L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Integer> f17485b;

        /* renamed from: c  reason: collision with root package name */
        public final long f17486c;

        /* renamed from: d  reason: collision with root package name */
        public long f17487d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f17488e;

        public RangeDisposable(Observer<? super Integer> observer, long j11, long j12) {
            this.f17485b = observer;
            this.f17487d = j11;
            this.f17486c = j12;
        }

        public void clear() {
            this.f17487d = this.f17486c;
            lazySet(1);
        }

        public void dispose() {
            set(1);
        }

        public boolean isDisposed() {
            return get() != 0;
        }

        public boolean isEmpty() {
            return this.f17487d == this.f17486c;
        }

        public int requestFusion(int i11) {
            if ((i11 & 1) == 0) {
                return 0;
            }
            this.f17488e = true;
            return 1;
        }

        public void run() {
            if (!this.f17488e) {
                Observer<? super Integer> observer = this.f17485b;
                long j11 = this.f17486c;
                for (long j12 = this.f17487d; j12 != j11 && get() == 0; j12++) {
                    observer.onNext(Integer.valueOf((int) j12));
                }
                if (get() == 0) {
                    lazySet(1);
                    observer.onComplete();
                }
            }
        }

        @Nullable
        public Integer poll() throws Exception {
            long j11 = this.f17487d;
            if (j11 != this.f17486c) {
                this.f17487d = 1 + j11;
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
