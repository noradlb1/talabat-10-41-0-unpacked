package com.jakewharton.rxbinding3;

import io.reactivex.Observable;
import io.reactivex.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0003H\u0014J\u0018\u0010\u0007\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0003H$J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002R\u0014\u0010\u000b\u001a\u00028\u00008$X¤\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/jakewharton/rxbinding3/InitialValueObservable;", "T", "Lio/reactivex/Observable;", "Lio/reactivex/Observer;", "observer", "", "subscribeActual", "a", "skipInitialValue", "getInitialValue", "()Ljava/lang/Object;", "initialValue", "<init>", "()V", "Skipped", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
public abstract class InitialValueObservable<T> extends Observable<T> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/jakewharton/rxbinding3/InitialValueObservable$Skipped;", "Lio/reactivex/Observable;", "(Lcom/jakewharton/rxbinding3/InitialValueObservable;)V", "subscribeActual", "", "observer", "Lio/reactivex/Observer;", "rxbinding_release"}, k = 1, mv = {1, 1, 15})
    public final class Skipped extends Observable<T> {
        public Skipped() {
        }

        public void subscribeActual(@NotNull Observer<? super T> observer) {
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            InitialValueObservable.this.a(observer);
        }
    }

    public abstract void a(@NotNull Observer<? super T> observer);

    public abstract T getInitialValue();

    @NotNull
    public final Observable<T> skipInitialValue() {
        return new Skipped();
    }

    public void subscribeActual(@NotNull Observer<? super T> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        a(observer);
        observer.onNext(getInitialValue());
    }
}
