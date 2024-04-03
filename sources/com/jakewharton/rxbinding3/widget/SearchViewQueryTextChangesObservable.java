package com.jakewharton.rxbinding3.widget;

import android.widget.SearchView;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0014R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\n \n*\u0004\u0018\u00010\u00020\u00028TX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/SearchViewQueryTextChangesObservable;", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "", "Lio/reactivex/Observer;", "observer", "", "a", "Landroid/widget/SearchView;", "view", "Landroid/widget/SearchView;", "kotlin.jvm.PlatformType", "b", "()Ljava/lang/CharSequence;", "initialValue", "<init>", "(Landroid/widget/SearchView;)V", "Listener", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
final class SearchViewQueryTextChangesObservable extends InitialValueObservable<CharSequence> {
    private final SearchView view;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\tH\u0014R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u000f0\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/SearchViewQueryTextChangesObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/widget/SearchView$OnQueryTextListener;", "", "s", "", "onQueryTextChange", "query", "onQueryTextSubmit", "", "a", "Landroid/widget/SearchView;", "view", "Landroid/widget/SearchView;", "Lio/reactivex/Observer;", "", "observer", "Lio/reactivex/Observer;", "<init>", "(Landroid/widget/SearchView;Lio/reactivex/Observer;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
    public static final class Listener extends MainThreadDisposable implements SearchView.OnQueryTextListener {
        private final Observer<? super CharSequence> observer;
        private final SearchView view;

        public Listener(@NotNull SearchView searchView, @NotNull Observer<? super CharSequence> observer2) {
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
            this.observer.onNext(str);
            return true;
        }

        public boolean onQueryTextSubmit(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "query");
            return false;
        }
    }

    public SearchViewQueryTextChangesObservable(@NotNull SearchView searchView) {
        Intrinsics.checkParameterIsNotNull(searchView, "view");
        this.view = searchView;
    }

    public void a(@NotNull Observer<? super CharSequence> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, observer);
            this.view.setOnQueryTextListener(listener);
            observer.onSubscribe(listener);
        }
    }

    /* renamed from: b */
    public CharSequence getInitialValue() {
        return this.view.getQuery();
    }
}
