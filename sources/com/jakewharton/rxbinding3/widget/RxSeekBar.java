package com.jakewharton.rxbinding3.widget;

import android.widget.SeekBar;
import androidx.annotation.CheckResult;
import com.jakewharton.rxbinding3.InitialValueObservable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"com/jakewharton/rxbinding3/widget/RxSeekBar__SeekBarChangeEventObservableKt", "com/jakewharton/rxbinding3/widget/RxSeekBar__SeekBarChangeObservableKt"}, k = 4, mv = {1, 1, 15})
public final class RxSeekBar {
    @CheckResult
    @NotNull
    public static final InitialValueObservable<SeekBarChangeEvent> changeEvents(@NotNull SeekBar seekBar) {
        return RxSeekBar__SeekBarChangeEventObservableKt.changeEvents(seekBar);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<Integer> changes(@NotNull SeekBar seekBar) {
        return RxSeekBar__SeekBarChangeObservableKt.changes(seekBar);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<Integer> systemChanges(@NotNull SeekBar seekBar) {
        return RxSeekBar__SeekBarChangeObservableKt.systemChanges(seekBar);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<Integer> userChanges(@NotNull SeekBar seekBar) {
        return RxSeekBar__SeekBarChangeObservableKt.userChanges(seekBar);
    }
}
