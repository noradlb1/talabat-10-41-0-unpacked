package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableBuffer<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    public final int f21357c;

    /* renamed from: d  reason: collision with root package name */
    public final int f21358d;

    /* renamed from: e  reason: collision with root package name */
    public final Supplier<U> f21359e;

    public static final class BufferExactObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super U> f21360b;

        /* renamed from: c  reason: collision with root package name */
        public final int f21361c;

        /* renamed from: d  reason: collision with root package name */
        public final Supplier<U> f21362d;

        /* renamed from: e  reason: collision with root package name */
        public U f21363e;

        /* renamed from: f  reason: collision with root package name */
        public int f21364f;

        /* renamed from: g  reason: collision with root package name */
        public Disposable f21365g;

        public BufferExactObserver(Observer<? super U> observer, int i11, Supplier<U> supplier) {
            this.f21360b = observer;
            this.f21361c = i11;
            this.f21362d = supplier;
        }

        public boolean a() {
            try {
                U u11 = this.f21362d.get();
                Objects.requireNonNull(u11, "Empty buffer supplied");
                this.f21363e = (Collection) u11;
                return true;
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f21363e = null;
                Disposable disposable = this.f21365g;
                if (disposable == null) {
                    EmptyDisposable.error(th2, (Observer<?>) this.f21360b);
                    return false;
                }
                disposable.dispose();
                this.f21360b.onError(th2);
                return false;
            }
        }

        public void dispose() {
            this.f21365g.dispose();
        }

        public boolean isDisposed() {
            return this.f21365g.isDisposed();
        }

        public void onComplete() {
            U u11 = this.f21363e;
            if (u11 != null) {
                this.f21363e = null;
                if (!u11.isEmpty()) {
                    this.f21360b.onNext(u11);
                }
                this.f21360b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            this.f21363e = null;
            this.f21360b.onError(th2);
        }

        public void onNext(T t11) {
            U u11 = this.f21363e;
            if (u11 != null) {
                u11.add(t11);
                int i11 = this.f21364f + 1;
                this.f21364f = i11;
                if (i11 >= this.f21361c) {
                    this.f21360b.onNext(u11);
                    this.f21364f = 0;
                    a();
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21365g, disposable)) {
                this.f21365g = disposable;
                this.f21360b.onSubscribe(this);
            }
        }
    }

    public static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -8223395059921494546L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super U> f21366b;

        /* renamed from: c  reason: collision with root package name */
        public final int f21367c;

        /* renamed from: d  reason: collision with root package name */
        public final int f21368d;

        /* renamed from: e  reason: collision with root package name */
        public final Supplier<U> f21369e;

        /* renamed from: f  reason: collision with root package name */
        public Disposable f21370f;

        /* renamed from: g  reason: collision with root package name */
        public final ArrayDeque<U> f21371g = new ArrayDeque<>();

        /* renamed from: h  reason: collision with root package name */
        public long f21372h;

        public BufferSkipObserver(Observer<? super U> observer, int i11, int i12, Supplier<U> supplier) {
            this.f21366b = observer;
            this.f21367c = i11;
            this.f21368d = i12;
            this.f21369e = supplier;
        }

        public void dispose() {
            this.f21370f.dispose();
        }

        public boolean isDisposed() {
            return this.f21370f.isDisposed();
        }

        public void onComplete() {
            while (!this.f21371g.isEmpty()) {
                this.f21366b.onNext(this.f21371g.poll());
            }
            this.f21366b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f21371g.clear();
            this.f21366b.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = this.f21372h;
            this.f21372h = 1 + j11;
            if (j11 % ((long) this.f21368d) == 0) {
                try {
                    this.f21371g.offer((Collection) ExceptionHelper.nullCheck(this.f21369e.get(), "The bufferSupplier returned a null Collection."));
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f21371g.clear();
                    this.f21370f.dispose();
                    this.f21366b.onError(th2);
                    return;
                }
            }
            Iterator<U> it = this.f21371g.iterator();
            while (it.hasNext()) {
                Collection collection = (Collection) it.next();
                collection.add(t11);
                if (this.f21367c <= collection.size()) {
                    it.remove();
                    this.f21366b.onNext(collection);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21370f, disposable)) {
                this.f21370f = disposable;
                this.f21366b.onSubscribe(this);
            }
        }
    }

    public ObservableBuffer(ObservableSource<T> observableSource, int i11, int i12, Supplier<U> supplier) {
        super(observableSource);
        this.f21357c = i11;
        this.f21358d = i12;
        this.f21359e = supplier;
    }

    public void subscribeActual(Observer<? super U> observer) {
        int i11 = this.f21358d;
        int i12 = this.f21357c;
        if (i11 == i12) {
            BufferExactObserver bufferExactObserver = new BufferExactObserver(observer, i12, this.f21359e);
            if (bufferExactObserver.a()) {
                this.f21304b.subscribe(bufferExactObserver);
                return;
            }
            return;
        }
        this.f21304b.subscribe(new BufferSkipObserver(observer, this.f21357c, this.f21358d, this.f21359e));
    }
}
