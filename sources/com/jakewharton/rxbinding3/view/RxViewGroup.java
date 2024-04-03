package com.jakewharton.rxbinding3.view;

import android.view.ViewGroup;
import androidx.annotation.CheckResult;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"com/jakewharton/rxbinding3/view/RxViewGroup__ViewGroupHierarchyChangeEventObservableKt"}, k = 4, mv = {1, 1, 15})
public final class RxViewGroup {
    @CheckResult
    @NotNull
    public static final Observable<ViewGroupHierarchyChangeEvent> changeEvents(@NotNull ViewGroup viewGroup) {
        return RxViewGroup__ViewGroupHierarchyChangeEventObservableKt.changeEvents(viewGroup);
    }
}
