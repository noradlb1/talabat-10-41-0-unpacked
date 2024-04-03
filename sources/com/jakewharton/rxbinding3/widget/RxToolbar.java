package com.jakewharton.rxbinding3.widget;

import android.view.MenuItem;
import android.widget.Toolbar;
import androidx.annotation.CheckResult;
import androidx.annotation.RequiresApi;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"com/jakewharton/rxbinding3/widget/RxToolbar__ToolbarItemClickObservableKt", "com/jakewharton/rxbinding3/widget/RxToolbar__ToolbarNavigationClickObservableKt"}, k = 4, mv = {1, 1, 15})
public final class RxToolbar {
    @RequiresApi(21)
    @CheckResult
    @NotNull
    public static final Observable<MenuItem> itemClicks(@NotNull Toolbar toolbar) {
        return RxToolbar__ToolbarItemClickObservableKt.itemClicks(toolbar);
    }

    @RequiresApi(21)
    @CheckResult
    @NotNull
    public static final Observable<Unit> navigationClicks(@NotNull Toolbar toolbar) {
        return RxToolbar__ToolbarNavigationClickObservableKt.navigationClicks(toolbar);
    }
}
