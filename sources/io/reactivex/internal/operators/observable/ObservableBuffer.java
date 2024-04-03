package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableBuffer<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    public final int f16852c;

    /* renamed from: d  reason: collision with root package name */
    public final int f16853d;

    /* renamed from: e  reason: collision with root package name */
    public final Callable<U> f16854e;

    public static final class BufferExactObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super U> f16855b;

        /* renamed from: c  reason: collision with root package name */
        public final int f16856c;

        /* renamed from: d  reason: collision with root package name */
        public final Callable<U> f16857d;

        /* renamed from: e  reason: collision with root package name */
        public U f16858e;

        /* renamed from: f  reason: collision with root package name */
        public int f16859f;

        /* renamed from: g  reason: collision with root package name */
        public Disposable f16860g;

        public BufferExactObserver(Observer<? super U> observer, int i11, Callable<U> callable) {
            this.f16855b = observer;
            this.f16856c = i11;
            this.f16857d = callable;
        }

        public boolean a() {
            try {
                this.f16858e = (Collection) ObjectHelper.requireNonNull(this.f16857d.call(), "Empty buffer supplied");
                return true;
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f16858e = null;
                Disposable disposable = this.f16860g;
                if (disposable == null) {
                    EmptyDisposable.error(th2, (Observer<?>) this.f16855b);
                    return false;
                }
                disposable.dispose();
                this.f16855b.onError(th2);
                return false;
            }
        }

        public void dispose() {
            this.f16860g.dispose();
        }

        public boolean isDisposed() {
            return this.f16860g.isDisposed();
        }

        public void onComplete() {
            U u11 = this.f16858e;
            if (u11 != null) {
                this.f16858e = null;
                if (!u11.isEmpty()) {
                    this.f16855b.onNext(u11);
                }
                this.f16855b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            this.f16858e = null;
            this.f16855b.onError(th2);
        }

        public void onNext(T t11) {
            U u11 = this.f16858e;
            if (u11 != null) {
                u11.add(t11);
                int i11 = this.f16859f + 1;
                this.f16859f = i11;
                if (i11 >= this.f16856c) {
                    this.f16855b.onNext(u11);
                    this.f16859f = 0;
                    a();
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16860g, disposable)) {
                this.f16860g = disposable;
                this.f16855b.onSubscribe(this);
            }
        }
    }

    public static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -8223395059921494546L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super U> f16861b;

        /* renamed from: c  reason: collision with root package name */
        public final int f16862c;

        /* renamed from: d  reason: collision with root package name */
        public final int f16863d;

        /* renamed from: e  reason: collision with root package name */
        public final Callable<U> f16864e;

        /* renamed from: f  reason: collision with root package name */
        public Disposable f16865f;

        /* renamed from: g  reason: collision with root package name */
        public final ArrayDeque<U> f16866g = new ArrayDeque<>();

        /* renamed from: h  reason: collision with root package name */
        public long f16867h;

        public BufferSkipObserver(Observer<? super U> observer, int i11, int i12, Callable<U> callable) {
            this.f16861b = observer;
            this.f16862c = i11;
            this.f16863d = i12;
            this.f16864e = callable;
        }

        public void dispose() {
            this.f16865f.dispose();
        }

        public boolean isDisposed() {
            return this.f16865f.isDisposed();
        }

        public void onComplete() {
            while (!this.f16866g.isEmpty()) {
                this.f16861b.onNext(this.f16866g.poll());
            }
            this.f16861b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16866g.clear();
            this.f16861b.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = this.f16867h;
            this.f16867h = 1 + j11;
            if (j11 % ((long) this.f16863d) == 0) {
                try {
                    this.f16866g.offer((Collection) ObjectHelper.requireNonNull(this.f16864e.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources."));
                } catch (Throwable th2) {
                    this.f16866g.clear();
                    this.f16865f.dispose();
                    this.f16861b.onError(th2);
                    return;
                }
            }
            Iterator<U> it = this.f16866g.iterator();
            while (it.hasNext()) {
                Collection collection = (Collection) it.next();
                collection.add(t11);
                if (this.f16862c <= collection.size()) {
                    it.remove();
                    this.f16861b.onNext(collection);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16865f, disposable)) {
                this.f16865f = disposable;
                this.f16861b.onSubscribe(this);
            }
        }
    }

    public ObservableBuffer(ObservableSource<T> observableSource, int i11, int i12, Callable<U> callable) {
        super(observableSource);
        this.f16852c = i11;
        this.f16853d = i12;
        this.f16854e = callable;
    }

    public void subscribeActual(Observer<? super U> observer) {
        int i11 = this.f16853d;
        int i12 = this.f16852c;
        if (i11 == i12) {
            BufferExactObserver bufferExactObserver = new BufferExactObserver(observer, i12, this.f16854e);
            if (bufferExactObserver.a()) {
                this.f16799b.subscribe(bufferExactObserver);
                return;
            }
            return;
        }
        this.f16799b.subscribe(new BufferSkipObserver(observer, this.f16852c, this.f16853d, this.f16854e));
    }
}
