package com.jakewharton.rxbinding3.widget;

import android.database.DataSetObserver;
import android.widget.Adapter;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u000fB\u000f\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0004H\u0014R\u0014\u0010\b\u001a\u00028\u00008\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00028\u00008TX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/AdapterDataChangeObservable;", "Landroid/widget/Adapter;", "T", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "Lio/reactivex/Observer;", "observer", "", "a", "adapter", "Landroid/widget/Adapter;", "b", "()Landroid/widget/Adapter;", "initialValue", "<init>", "(Landroid/widget/Adapter;)V", "ObserverDisposable", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
final class AdapterDataChangeObservable<T extends Adapter> extends InitialValueObservable<T> {
    private final T adapter;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\u00020\u0003B\u001f\u0012\u0006\u0010\t\u001a\u00028\u0001\u0012\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0005\u001a\u00020\u0004H\u0014R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00028\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/AdapterDataChangeObservable$ObserverDisposable;", "Landroid/widget/Adapter;", "T", "Lio/reactivex/android/MainThreadDisposable;", "", "a", "Landroid/database/DataSetObserver;", "dataSetObserver", "Landroid/database/DataSetObserver;", "adapter", "Landroid/widget/Adapter;", "Lio/reactivex/Observer;", "observer", "<init>", "(Landroid/widget/Adapter;Lio/reactivex/Observer;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
    public static final class ObserverDisposable<T extends Adapter> extends MainThreadDisposable {
        /* access modifiers changed from: private */
        public final T adapter;
        @NotNull
        @JvmField
        public final DataSetObserver dataSetObserver;

        public ObserverDisposable(@NotNull T t11, @NotNull Observer<? super T> observer) {
            Intrinsics.checkParameterIsNotNull(t11, "adapter");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.adapter = t11;
            this.dataSetObserver = new AdapterDataChangeObservable$ObserverDisposable$dataSetObserver$1(this, observer);
        }

        public void a() {
            this.adapter.unregisterDataSetObserver(this.dataSetObserver);
        }
    }

    public AdapterDataChangeObservable(@NotNull T t11) {
        Intrinsics.checkParameterIsNotNull(t11, "adapter");
        this.adapter = t11;
    }

    public void a(@NotNull Observer<? super T> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            ObserverDisposable observerDisposable = new ObserverDisposable(getInitialValue(), observer);
            getInitialValue().registerDataSetObserver(observerDisposable.dataSetObserver);
            observer.onSubscribe(observerDisposable);
        }
    }

    @NotNull
    /* renamed from: b */
    public T getInitialValue() {
        return this.adapter;
    }
}
