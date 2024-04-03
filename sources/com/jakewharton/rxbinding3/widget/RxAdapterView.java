package com.jakewharton.rxbinding3.widget;

import android.widget.Adapter;
import android.widget.AdapterView;
import androidx.annotation.CheckResult;
import com.jakewharton.rxbinding3.InitialValueObservable;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"com/jakewharton/rxbinding3/widget/RxAdapterView__AdapterViewItemClickEventObservableKt", "com/jakewharton/rxbinding3/widget/RxAdapterView__AdapterViewItemClickObservableKt", "com/jakewharton/rxbinding3/widget/RxAdapterView__AdapterViewItemLongClickEventObservableKt", "com/jakewharton/rxbinding3/widget/RxAdapterView__AdapterViewItemLongClickObservableKt", "com/jakewharton/rxbinding3/widget/RxAdapterView__AdapterViewItemSelectionObservableKt", "com/jakewharton/rxbinding3/widget/RxAdapterView__AdapterViewSelectionObservableKt"}, k = 4, mv = {1, 1, 15})
public final class RxAdapterView {
    @CheckResult
    @NotNull
    public static final <T extends Adapter> Observable<AdapterViewItemClickEvent> itemClickEvents(@NotNull AdapterView<T> adapterView) {
        return RxAdapterView__AdapterViewItemClickEventObservableKt.itemClickEvents(adapterView);
    }

    @CheckResult
    @NotNull
    public static final <T extends Adapter> Observable<Integer> itemClicks(@NotNull AdapterView<T> adapterView) {
        return RxAdapterView__AdapterViewItemClickObservableKt.itemClicks(adapterView);
    }

    @CheckResult
    @NotNull
    @JvmOverloads
    public static final <T extends Adapter> Observable<AdapterViewItemLongClickEvent> itemLongClickEvents(@NotNull AdapterView<T> adapterView) {
        return RxAdapterView__AdapterViewItemLongClickEventObservableKt.itemLongClickEvents$default(adapterView, (Function1) null, 1, (Object) null);
    }

    @CheckResult
    @NotNull
    @JvmOverloads
    public static final <T extends Adapter> Observable<AdapterViewItemLongClickEvent> itemLongClickEvents(@NotNull AdapterView<T> adapterView, @NotNull Function1<? super AdapterViewItemLongClickEvent, Boolean> function1) {
        return RxAdapterView__AdapterViewItemLongClickEventObservableKt.itemLongClickEvents(adapterView, function1);
    }

    @CheckResult
    @NotNull
    @JvmOverloads
    public static final <T extends Adapter> Observable<Integer> itemLongClicks(@NotNull AdapterView<T> adapterView) {
        return RxAdapterView__AdapterViewItemLongClickObservableKt.itemLongClicks$default(adapterView, (Function0) null, 1, (Object) null);
    }

    @CheckResult
    @NotNull
    @JvmOverloads
    public static final <T extends Adapter> Observable<Integer> itemLongClicks(@NotNull AdapterView<T> adapterView, @NotNull Function0<Boolean> function0) {
        return RxAdapterView__AdapterViewItemLongClickObservableKt.itemLongClicks(adapterView, function0);
    }

    @CheckResult
    @NotNull
    public static final <T extends Adapter> InitialValueObservable<Integer> itemSelections(@NotNull AdapterView<T> adapterView) {
        return RxAdapterView__AdapterViewItemSelectionObservableKt.itemSelections(adapterView);
    }

    @CheckResult
    @NotNull
    public static final <T extends Adapter> InitialValueObservable<AdapterViewSelectionEvent> selectionEvents(@NotNull AdapterView<T> adapterView) {
        return RxAdapterView__AdapterViewSelectionObservableKt.selectionEvents(adapterView);
    }
}
