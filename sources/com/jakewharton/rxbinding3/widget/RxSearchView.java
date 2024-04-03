package com.jakewharton.rxbinding3.widget;

import android.widget.SearchView;
import androidx.annotation.CheckResult;
import com.jakewharton.rxbinding3.InitialValueObservable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"com/jakewharton/rxbinding3/widget/RxSearchView__SearchViewQueryConsumerKt", "com/jakewharton/rxbinding3/widget/RxSearchView__SearchViewQueryTextChangeEventsObservableKt", "com/jakewharton/rxbinding3/widget/RxSearchView__SearchViewQueryTextChangesObservableKt"}, k = 4, mv = {1, 1, 15})
public final class RxSearchView {
    @CheckResult
    @NotNull
    public static final Consumer<? super CharSequence> query(@NotNull SearchView searchView, boolean z11) {
        return RxSearchView__SearchViewQueryConsumerKt.query(searchView, z11);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<SearchViewQueryTextEvent> queryTextChangeEvents(@NotNull SearchView searchView) {
        return RxSearchView__SearchViewQueryTextChangeEventsObservableKt.queryTextChangeEvents(searchView);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<CharSequence> queryTextChanges(@NotNull SearchView searchView) {
        return RxSearchView__SearchViewQueryTextChangesObservableKt.queryTextChanges(searchView);
    }
}
