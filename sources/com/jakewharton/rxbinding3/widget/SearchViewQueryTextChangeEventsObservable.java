package com.jakewharton.rxbinding3.widget;

import android.widget.SearchView;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0014R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00028TX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/SearchViewQueryTextChangeEventsObservable;", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "Lcom/jakewharton/rxbinding3/widget/SearchViewQueryTextEvent;", "Lio/reactivex/Observer;", "observer", "", "a", "Landroid/widget/SearchView;", "view", "Landroid/widget/SearchView;", "b", "()Lcom/jakewharton/rxbinding3/widget/SearchViewQueryTextEvent;", "initialValue", "<init>", "(Landroid/widget/SearchView;)V", "Listener", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
final class SearchViewQueryTextChangeEventsObservable extends InitialValueObservable<SearchViewQueryTextEvent> {
    private final SearchView view;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\tH\u0014R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u000f0\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/SearchViewQueryTextChangeEventsObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/widget/SearchView$OnQueryTextListener;", "", "s", "", "onQueryTextChange", "query", "onQueryTextSubmit", "", "a", "Landroid/widget/SearchView;", "view", "Landroid/widget/SearchView;", "Lio/reactivex/Observer;", "Lcom/jakewharton/rxbinding3/widget/SearchViewQueryTextEvent;", "observer", "Lio/reactivex/Observer;", "<init>", "(Landroid/widget/SearchView;Lio/reactivex/Observer;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
    public static final class Listener extends MainThreadDisposable implements SearchView.OnQueryTextListener {
        private final Observer<? super SearchViewQueryTextEvent> observer;
        private final SearchView view;

        public Listener(@NotNull SearchView searchView, @NotNull Observer<? super SearchViewQueryTextEvent> observer2) {
            Intrinsics.checkParameterIsNotNull(searchView, "view");
            Intrinsics.checkParameterIsNotNull(observer2, "observer");
            this.view = searchView;
            this.observer = observer2;
        }

        public void a() {
            this.view.setOnQueryTextListener((SearchView.OnQueryTextListener) null);
        }

        public boolean onQueryTextChange(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "s");
            if (isDisposed()) {
                return false;
            }
            this.observer.onNext(new SearchViewQueryTextEvent(this.view, str, false));
            return true;
        }

        public boolean onQueryTextSubmit(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "query");
            if (isDisposed()) {
                return false;
            }
            this.observer.onNext(new SearchViewQueryTextEvent(this.view, str, true));
            return true;
        }
    }

    public SearchViewQueryTextChangeEventsObservable(@NotNull SearchView searchView) {
        Intrinsics.checkParameterIsNotNull(searchView, "view");
        this.view = searchView;
    }

    public void a(@NotNull Observer<? super SearchViewQueryTextEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, observer);
            this.view.setOnQueryTextListener(listener);
            observer.onSubscribe(listener);
        }
    }

    @NotNull
    /* renamed from: b */
    public SearchViewQueryTextEvent getInitialValue() {
        SearchView searchView = this.view;
        CharSequence query = searchView.getQuery();
        Intrinsics.checkExpressionValueIsNotNull(query, "view.query");
        return new SearchViewQueryTextEvent(searchView, query, false);
    }
}
