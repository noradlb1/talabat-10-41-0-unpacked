package com.jakewharton.rxbinding3.widget;

import android.widget.Adapter;
import androidx.annotation.CheckResult;
import com.jakewharton.rxbinding3.InitialValueObservable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"com/jakewharton/rxbinding3/widget/RxAdapter__AdapterDataChangeObservableKt"}, k = 4, mv = {1, 1, 15})
public final class RxAdapter {
    @CheckResult
    @NotNull
    public static final <T extends Adapter> InitialValueObservable<T> dataChanges(@NotNull T t11) {
        return RxAdapter__AdapterDataChangeObservableKt.dataChanges(t11);
    }
}
