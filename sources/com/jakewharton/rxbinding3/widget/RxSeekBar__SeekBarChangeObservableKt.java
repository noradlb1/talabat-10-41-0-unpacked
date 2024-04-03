package com.jakewharton.rxbinding3.widget;

import android.widget.SeekBar;
import androidx.annotation.CheckResult;
import com.jakewharton.rxbinding3.InitialValueObservable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u001a\u0012\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u001a\u0012\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007¨\u0006\u0006"}, d2 = {"changes", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "", "Landroid/widget/SeekBar;", "systemChanges", "userChanges", "rxbinding_release"}, k = 5, mv = {1, 1, 15}, xs = "com/jakewharton/rxbinding3/widget/RxSeekBar")
final /* synthetic */ class RxSeekBar__SeekBarChangeObservableKt {
    @CheckResult
    @NotNull
    public static final InitialValueObservable<Integer> changes(@NotNull SeekBar seekBar) {
        Intrinsics.checkParameterIsNotNull(seekBar, "$this$changes");
        return new SeekBarChangeObservable(seekBar, (Boolean) null);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<Integer> systemChanges(@NotNull SeekBar seekBar) {
        Intrinsics.checkParameterIsNotNull(seekBar, "$this$systemChanges");
        return new SeekBarChangeObservable(seekBar, Boolean.FALSE);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<Integer> userChanges(@NotNull SeekBar seekBar) {
        Intrinsics.checkParameterIsNotNull(seekBar, "$this$userChanges");
        return new SeekBarChangeObservable(seekBar, Boolean.TRUE);
    }
}
