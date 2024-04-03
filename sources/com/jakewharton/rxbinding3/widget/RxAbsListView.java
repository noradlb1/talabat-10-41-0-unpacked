package com.jakewharton.rxbinding3.widget;

import android.widget.AbsListView;
import androidx.annotation.CheckResult;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"com/jakewharton/rxbinding3/widget/RxAbsListView__AbsListViewScrollEventObservableKt"}, k = 4, mv = {1, 1, 15})
public final class RxAbsListView {
    @CheckResult
    @NotNull
    public static final Observable<AbsListViewScrollEvent> scrollEvents(@NotNull AbsListView absListView) {
        return RxAbsListView__AbsListViewScrollEventObservableKt.scrollEvents(absListView);
    }
}
