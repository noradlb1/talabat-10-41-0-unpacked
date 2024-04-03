package com.jakewharton.rxbinding3.widget;

import android.widget.RadioGroup;
import androidx.annotation.CheckResult;
import com.jakewharton.rxbinding3.InitialValueObservable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"com/jakewharton/rxbinding3/widget/RxRadioGroup__RadioGroupCheckedChangeObservableKt", "com/jakewharton/rxbinding3/widget/RxRadioGroup__RadioGroupToggleCheckedConsumerKt"}, k = 4, mv = {1, 1, 15})
public final class RxRadioGroup {
    @CheckResult
    @NotNull
    public static final Consumer<? super Integer> checked(@NotNull RadioGroup radioGroup) {
        return RxRadioGroup__RadioGroupToggleCheckedConsumerKt.checked(radioGroup);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<Integer> checkedChanges(@NotNull RadioGroup radioGroup) {
        return RxRadioGroup__RadioGroupCheckedChangeObservableKt.checkedChanges(radioGroup);
    }
}
