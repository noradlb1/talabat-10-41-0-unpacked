package com.jakewharton.rxbinding3.widget;

import android.widget.RadioGroup;
import androidx.annotation.CheckResult;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"checked", "Lio/reactivex/functions/Consumer;", "", "Landroid/widget/RadioGroup;", "rxbinding_release"}, k = 5, mv = {1, 1, 15}, xs = "com/jakewharton/rxbinding3/widget/RxRadioGroup")
final /* synthetic */ class RxRadioGroup__RadioGroupToggleCheckedConsumerKt {
    @CheckResult
    @NotNull
    public static final Consumer<? super Integer> checked(@NotNull RadioGroup radioGroup) {
        Intrinsics.checkParameterIsNotNull(radioGroup, "$this$checked");
        return new RxRadioGroup__RadioGroupToggleCheckedConsumerKt$checked$1(radioGroup);
    }
}
