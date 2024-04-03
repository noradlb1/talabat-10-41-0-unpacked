package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.subjects.Subject;
import java.util.concurrent.atomic.AtomicBoolean;

final class ObservableWindowSubscribeIntercept<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Subject<T> f22488b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f22489c = new AtomicBoolean();

    public ObservableWindowSubscribeIntercept(Subject<T> subject) {
        this.f22488b = subject;
    }

    public boolean a() {
        return !this.f22489c.get() && this.f22489c.compareAndSet(false, true);
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f22488b.subscribe(observer);
        this.f22489c.set(true);
    }
}
