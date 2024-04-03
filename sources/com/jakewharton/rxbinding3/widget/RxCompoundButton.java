package com.jakewharton.rxbinding3.widget;

import android.widget.CompoundButton;
import androidx.annotation.CheckResult;
import com.jakewharton.rxbinding3.InitialValueObservable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"com/jakewharton/rxbinding3/widget/RxCompoundButton__CompoundButtonCheckedChangeObservableKt"}, k = 4, mv = {1, 1, 15})
public final class RxCompoundButton {
    @CheckResult
    @NotNull
    public static final InitialValueObservable<Boolean> checkedChanges(@NotNull CompoundButton compoundButton) {
        return RxCompoundButton__CompoundButtonCheckedChangeObservableKt.checkedChanges(compoundButton);
    }
}
