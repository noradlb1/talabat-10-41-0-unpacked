package com.instabug.library.core.eventbus;

import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

public class EventBus<T> {
    private final PublishSubject<T> subject;

    public class a implements Consumer {
        public a(EventBus eventBus) {
        }

        /* renamed from: a */
        public void accept(Throwable th2) {
            InstabugSDKLogger.e("IBG-Core", "Error while receiving event: " + th2.getMessage(), th2);
        }
    }

    public EventBus() {
        this(PublishSubject.create());
    }

    public Observable<T> getEventObservable() {
        return this.subject;
    }

    public boolean hasObservers() {
        return this.subject.hasObservers();
    }

    public <E extends T> Observable<E> observeEvents(Class<E> cls) {
        return this.subject.ofType(cls);
    }

    public <E extends T> void post(E e11) {
        try {
            this.subject.onNext(e11);
        } catch (Throwable th2) {
            InstabugSDKLogger.e("IBG-Core", "Error while posting event: " + th2.getMessage(), th2);
        }
    }

    public Disposable subscribe(Consumer<? super T> consumer) {
        return this.subject.subscribe(consumer, new a(this));
    }

    public EventBus(PublishSubject<T> publishSubject) {
        this.subject = publishSubject;
    }
}
