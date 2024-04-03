package com.jakewharton.rxbinding3.widget;

import android.widget.AbsListView;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\tH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/AbsListViewScrollEventObservable;", "Lio/reactivex/Observable;", "Lcom/jakewharton/rxbinding3/widget/AbsListViewScrollEvent;", "view", "Landroid/widget/AbsListView;", "(Landroid/widget/AbsListView;)V", "subscribeActual", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k = 1, mv = {1, 1, 15})
final class AbsListViewScrollEventObservable extends Observable<AbsListViewScrollEvent> {
    private final AbsListView view;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0014R\u0016\u0010\u000e\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00130\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/AbsListViewScrollEventObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/widget/AbsListView$OnScrollListener;", "Landroid/widget/AbsListView;", "absListView", "", "scrollState", "", "onScrollStateChanged", "firstVisibleItem", "visibleItemCount", "totalItemCount", "onScroll", "a", "currentScrollState", "I", "view", "Landroid/widget/AbsListView;", "Lio/reactivex/Observer;", "Lcom/jakewharton/rxbinding3/widget/AbsListViewScrollEvent;", "observer", "Lio/reactivex/Observer;", "<init>", "(Landroid/widget/AbsListView;Lio/reactivex/Observer;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
    public static final class Listener extends MainThreadDisposable implements AbsListView.OnScrollListener {
        private int currentScrollState;
        private final Observer<? super AbsListViewScrollEvent> observer;
        private final AbsListView view;

        public Listener(@NotNull AbsListView absListView, @NotNull Observer<? super AbsListViewScrollEvent> observer2) {
            Intrinsics.checkParameterIsNotNull(absListView, "view");
            Intrinsics.checkParameterIsNotNull(observer2, "observer");
            this.view = absListView;
            this.observer = observer2;
        }

        public void a() {
            this.view.setOnScrollListener((AbsListView.OnScrollListener) null);
        }

        public void onScroll(@NotNull AbsListView absListView, int i11, int i12, int i13) {
            Intrinsics.checkParameterIsNotNull(absListView, "absListView");
            if (!isDisposed()) {
                this.observer.onNext(new AbsListViewScrollEvent(this.view, this.currentScrollState, i11, i12, i13));
            }
        }

        public void onScrollStateChanged(@NotNull AbsListView absListView, int i11) {
            Intrinsics.checkParameterIsNotNull(absListView, "absListView");
            this.currentScrollState = i11;
            if (!isDisposed()) {
                AbsListView absListView2 = this.view;
                this.observer.onNext(new AbsListViewScrollEvent(absListView2, i11, absListView2.getFirstVisiblePosition(), this.view.getChildCount(), this.view.getCount()));
            }
        }
    }

    public AbsListViewScrollEventObservable(@NotNull AbsListView absListView) {
        Intrinsics.checkParameterIsNotNull(absListView, "view");
        this.view = absListView;
    }

    public void subscribeActual(@NotNull Observer<? super AbsListViewScrollEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, observer);
            observer.onSubscribe(listener);
            this.view.setOnScrollListener(listener);
        }
    }
}
