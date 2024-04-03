package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapCompletable;
import org.reactivestreams.Publisher;

public final class FlowableSwitchMapCompletablePublisher<T> extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<T> f21178b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f21179c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f21180d;

    public FlowableSwitchMapCompletablePublisher(Publisher<T> publisher, Function<? super T, ? extends CompletableSource> function, boolean z11) {
        this.f21178b = publisher;
        this.f21179c = function;
        this.f21180d = z11;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f21178b.subscribe(new FlowableSwitchMapCompletable.SwitchMapCompletableObserver(completableObserver, this.f21179c, this.f21180d));
    }
}
